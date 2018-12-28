package day1128;

/**
 * �л��� Oracle, Java, JDBC ���� ������ ó���ϴ� ���α׷�
 * 
 * @author owner
 */
public class ScoreProcess3 {
	private int total;
	private int[] m_result;// ������ ��ȯ�� ���� �������
	private double[] m_resultD;// ������� ��ȯ�� ���� �������
	private String m_name;
	private int m_stdNum;
	private int[] m_sortJavaScore;//���ĵ� �ڹ����� ����

	public ScoreProcess3() {
		total = 0;
		m_result = new int[3];
		m_sortJavaScore = new int[6];
	}

	public String[] nameData() {
		String[] name = { "������", "������", "���ü�", "������", "������", "�����" };
		return name;
	}

	public int[][] scoreData() {
		int[][] score = { { 85, 86, 81 }, { 95, 91, 100 }, { 89, 71, 59 }, { 97, 96, 91 }, { 78, 74, 77 },
				{ 100, 95, 68 } };
		return score;
	}

	// ���� - ������� �մ��� �Ű������� ��ȯ���� ���. method�� �����Ͽ� ȣ���Ͽ� ���
	// 1. �� �л��� ����� ���Ͽ� ���( �Ҽ����� ���ڸ�)
	public void printScore(String[] name, int[][] score) {
		System.out.println("��ȣ\t�̸�\tOracle\tJava\tJDBC\t����\t���");
		for (int i = 0; i < score.length; i++) {
			System.out.printf("%d\t%s\t", i + 1, name[i]);
			for (int j = 0; j < score[i].length; j++) {
				System.out.printf("%d\t", score[i][j]);
				addTotal(score[i][j]);
			}
			System.out.printf("%d\t%.1f\n", getTotal(), avrUser());
			resetTotal();
		}
		System.out.println("------------------------------------------------");

		// 2. �� ����� ����
		System.out.println("��������-------------------------------------------");
		m_result = sumSub(score);
		System.out.printf("����Ŭ : %d �ڹ� : %d JDBC : %d\n", m_result[0], m_result[1], m_result[2]);

		// 3. �� ����� ��հ� ��ü��� (��ü����� �Ҽ����� ���ڸ�����)
		System.out.println("�������-------------------------------------------");
		m_resultD = avrSub(score);
		System.out.printf("����Ŭ : %.2f �ڹ� : %.2f JDBC : %.2f\n", m_resultD[0], m_resultD[1], m_resultD[2]);

		// 4. ����� �ְ����� ���
		m_result = maxSub(score);
		System.out.printf("�ְ����� ����Ŭ[%d] �ڹ�[%d] JDBC[%d]\n", m_result[0], m_result[1], m_result[2]);

		// 5. �ϵ��л��� �̸��� ����, ��ȣ
		System.out.printf("TOP ��ȣ[%d] �̸�[%s] ����[%d]\n",topStd(name, score).m_stdNum, topStd(name, score).m_name, topStd(name, score).total);

		// 6. �ڹ������� �������� �����Ͽ� ���
		
		m_sortJavaScore = acdJavaScore(score);
		System.out.print("�ڹ�����(��������) : ");
		for(int i=0; i<m_sortJavaScore.length; i++) {
			System.out.print(m_sortJavaScore[i] + " ");
		}
		System.out.println();
	}

	// ����2��
	/*
	 * 2���� �迭�� ������ �������� ����� �Ʒ��� ���� ���� �־� ����ϴ� method�� �ۼ�. 
	 * 1 1 1 1 1 1 1 1 1 
	 * 1 0 0 0 0 0 0 0 1 
	 * 1 0 0 0 0 0 0 0 1 
	 * 1 0 0 0 0 0 0 0 1 
	 * 1 0 0 0 0 0 0 0 1 
	 * 1 1 1 1 1 1 1 1 1
	 */
	

	/**
	 * ���� ���
	 * 
	 * @param score
	 */
	public void addTotal(int score) {
		total += score;
	}

	/**
	 * ������ ����
	 * 
	 * @return
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * ������ �ʱ�ȭ
	 */
	public void resetTotal() {
		total = 0;
	}

	// 1-1. ������հ��
	public double avrUser() {
		double result = (double) total / 3;
		return result;
	}

	// 1-2. �� ����� ����
	public int[] sumSub(int[][] score) {
		int[] result = new int[3];

		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				result[j] += score[i][j];
			}
		}
		return result;
	}

	// 1-3. �� ���� ���
	public double[] avrSub(int[][] score) {
		double[] result = new double[3];

		for (int i = 0; i < score[0].length; i++)
			result[i] = (double) m_result[i] / score.length;
		return result;
	}

	// 1-4. �� ���� �ְ���
	public int[] maxSub(int[][] score) {
		int[] result = new int[3];

		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				if (result[j] < score[i][j])
					result[j] = score[i][j];
			}
		}
		return result;
	}

	// 1-5 �ϵ� �л��� �̸��� ����
	public ScoreProcess3 topStd(String[] name, int[][] score) {
		ScoreProcess3 tmp_sp2 = new ScoreProcess3();
		int temp = 0;
		resetTotal();

		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				addTotal(score[i][j]);
			}
			if (temp < getTotal()) {
				temp = getTotal();
				tmp_sp2.m_stdNum = i + 1;
				tmp_sp2.m_name = name[i];
			}
			resetTotal();
		}
		tmp_sp2.total = temp;
		
		return tmp_sp2;
	}
	
	//1-6 �ڹ������� �������� �Ͽ� ���
	public int[] acdJavaScore(int[][] score) {
		int[] result = new int[6];
		int temp = 0;
		//score���� java������ ���� ����
		for (int i = 0; i < score.length; i++) {
			result[i] = score[i][1];
		}
		
		//������Ʈ(��������)
		for (int i = 0; i < result.length - 1; i++) {
			for (int j = i + 1; j < result.length; j++) {
				if (result[i] > result[j]) {
					temp = result[i];
					result[i] = result[j];
					result[j] = temp;
				}
			}
		}

		return result;
	}
	
	//����2
	public void printArr2() {
		int[][] arr = new int[6][9];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(i==0 || j==0 || i==5 || j==8) {
					arr[i][j] = 1;
				}
				System.out.print(arr[i][j] + " ");
			}
			
			System.out.println();
		}
	}

	public static void main(String[] args) {
		ScoreProcess3 sp2 = new ScoreProcess3();
		String[] name = sp2.nameData();
		int[][] score = sp2.scoreData();

		sp2.printScore(name, score);
		sp2.printArr2();
	}
}