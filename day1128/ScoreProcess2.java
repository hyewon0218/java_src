package day1128;

/**
 * �л��� Oracle, Java, JDBC ���� ������ ó���ϴ� ���α׷� 
 * @author SIST
 */
public class ScoreProcess2 {
	private int total;
	//
	private int subtotal;
	
	public ScoreProcess2 () {
		total=0;
	}

	
	/**
	 * ������ ���� ��
	 * @param score
	 */
	public void addTotal (int score) {
		total+=score;
	}
	/**
	 * ������ ��� ��
	 * @return
	 */
	public int getTotal() {
		return total;
	}
	public double getAvg(int[] score) {
		//getTotal()/(double)score[0].length
		return getTotal()/(double)score.length;
	}
	//
	//
	public int getSubTatal() {
		return subtotal;
	}
	/**
	 * ���� ������ �ʱ�ȭ 
	 */
	public void resetTotal () {
		total=0;
	}
	public void maxScore() {
		
	}
	//
//	public void subTotal(int score) {
//		subtotal+=score[i][1];
//	}
	
	public String[] namesData() {
		String[] name= {"������","������","���ü�","������","������","�����"};
			return name; 	
	}//nameData
	public int[][] scoreData() {
		int[][] score = {{85,86,81},{95,91,100},{89,71,59},{97,96,91},{78,74,77},{100,95,68}};
		return score;
	}//returnData
	public void printScore(String[] name,int[][] score) {
//		int total = 0;
		// ���� - ��� ���� �մ��� �Ű������� ��ȯ���� ����Ͽ�
		// method�� �����Ͽ� ȣ���ϰ� ���� ������ ����� �޾� ����Ѵ�.
		//1. �� �л��� ����� ���Ͽ� ����Ѵ�.(����� �Ҽ����� ���ڸ� ������ ���)
		System.out.println("��ȣ\t�̸�\tOracle\tJava\tJDBC\t����\t���");
		System.out.println("----------------------------------------------");
		for(int i=0; i < score.length; i++) {//��
			System.out.printf("%d\t%s\t",i+1,name[i]);//i+1�� ��ȣ1����!!
			for(int j=0; j < score[i].length; j++) {//�� �� ���̸�ŭ /2���� �迭���� �� ���� 1�����迭
				System.out.printf("%d\t",score[i][j]);	
				addTotal(score[i][j]);
//				total+=score[i][j];
			}
			System.out.printf("%d\t%.1f\n",getTotal(),getAvg(score[i]));
			resetTotal();
//			total = 0;
		}
		System.out.println("------------------------------------------------------");
		
		System.out.printf("��������------------------------------------------------------");
		//2. �� ����� ������ ������ ����
		
		for(int i=0; i <score.length; i++) {
			if(j==0) {
				}
			System.out.println(score[i][i]);
			
//							
//				score[0][0]+score[1][0]+score[2][0]+score[3][0]=
//				score[0][1]+score[1][1]+score[2][1]		
		}
		
		//3. �� ����� ��հ� ��ü ���(��ü ����� �Ҽ����� ���ڸ� ����)
		System.out.printf("�������------------------------------------------------------");
		//4. �� ����� �ְ� ������ ��� 
		System.out.printf("�ְ����� ����Ŭ[] �ڹ�[] JDBC[]------------------------------");
		int maxScore=0;
		int minScore=0;
		
		for(int i=0; i < score.length; i++) {
			if(maxScore < score[i]) {
				maxScore=score[i];
				
			}
			if(minScore > score[i]) {
				minScore=score[i];
			}
		}
//		for() 
		
		//5. �ϵ� �л��� �̸��� ����,��ȣ
		System.out.printf("TOP ��ȣ[] �̸�[] ����[] -------------------------------------");
		//6. �ڹ������� �������� �����Ͽ� ��� 
		System.out.printf("TOP ��ȣ[] �̸�[] ����[] -------------------------------------");
	
	}//printScore
	//���� 2. 
	//2���� �迭�� ������ �������� ����� �Ʒ��� ���� ���� �־� ����ϴ� 
	// method �ۼ�
	//	1 1 1 1 1 1 1 1 1
	//  1 0 0 0 0 0 0 0 1
	//  1 0 0 0 0 0 0 0 1
	//  1 0 0 0 0 0 0 0 1
	//  1 0 0 0 0 0 0 0 1
	//	1 1 1 1 1 1 1 1 1
	public static void main(String[] args) {
		ScoreProcess2 sp2=new ScoreProcess2();
		//ó���� ������ �ޱ�
		String[] name=sp2.namesData();
		int[][] score=sp2.scoreData();
		//ó��
		sp2.printScore(name, score);
	}//main

}//main
