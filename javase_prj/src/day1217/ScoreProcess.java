package day1217;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import static java.lang.Integer.parseInt;//����������

import java.text.DecimalFormat;

public class ScoreProcess {

	private List<ScoreVO> listStu;
	private int totalScore;

	public static final int INPUT_DATA = 1;
	public static final int VIEW_DATA = 2;
	public static final int EXIT = 3;
	
	public ScoreProcess() {
		listStu=new ArrayList<ScoreVO>();//?
	}

	/**
	 * ���� �޴� ����
	 */
	public void inputMenu() {
		String selectMenu = "", inputResult = "";
		boolean exitFlag = false;

		do {// �������ѹ�������
			selectMenu = JOptionPane.showInputDialog("�޴�����\n1.�Է� 2. ��� 3. ����");
			try {
				switch (parseInt(selectMenu)) {
				case INPUT_DATA:
					inputResult = "�������� ������ ���� �ʰų� ������ ���������̾�� �մϴ�.";
					if (inputData()) {
						inputResult = "�߰�����";
					}
					JOptionPane.showMessageDialog(null, inputResult);
					break;
				case VIEW_DATA:
					printData();
					break;
				case EXIT:
					exitFlag = true;
					break;
				default:
					JOptionPane.showMessageDialog(null, "�޴��� 1,2,3 �� �ϳ��̾�� �մϴ�.");
				}
			} catch (NumberFormatException nfe) {// ���ڷιٲ����ʴ°�쿡���ؼ�ó��
				JOptionPane.showMessageDialog(null, "�޴��� �����̾�� �մϴ�.");
			}

		} while (!exitFlag);// ���ѷ���
	}

	/**
	 * ����ó���� �����͸� �Է¹ޱ�
	 * 
	 * @return
	 */
	public boolean inputData() {
		boolean flag = false;

		String inputData = JOptionPane.showInputDialog("�������Է�\n��)�̸�, �ڹ�����, ����Ŭ����");
		try {
			String[] data = inputData.replaceAll(" ", "").split(",");// ��������� ���ֹ��� replace
			if (data.length == 3) {// �Է����Ŀ� ���� ��
				try {
					ScoreVO sv = new ScoreVO(data[0], parseInt(data[1]), parseInt(data[2]));
					listStu.add(sv);// ������ �����͸� list�� �߰�
					flag = true;// ���� ����� ����
					// �ڹ������� ����Ŭ������ �����̾�� �Ѵ�.
				} catch (NumberFormatException nfe) {
					flag = false;
				}
			}
		} catch (NullPointerException npe) {
		}
		return flag;

	}

	/**
	 * �Է������� ����ϴ� ��
	 */
	public void printData() {
		if(listStu.size()==0) {
			JOptionPane.showMessageDialog(null, "����� �����Ͱ� �����ϴ�.");
			return;
		}
		
		StringBuilder viewData=new StringBuilder();//?
		viewData
		.append("---------------------------------------------------------------------------------------------\n")
		.append("��ȣ\t�̸�\t�ڹ�\t����Ŭ\t����\t���\n")
		.append("---------------------------------------------------------------------------------------------\n");
		int tempTotal=0; 
		ScoreVO sv=null;
		for(int i=0; i < listStu.size(); i++) {
			sv=listStu.get(i);
			tempTotal=sv.getJavaScore()+sv.getOraclScore();
			viewData.append(i+1).append("\t").append(sv.getName())
			.append("\t").append(sv.getJavaScore())
			.append("\t").append(sv.getOraclScore())
			.append("\t").append(tempTotal)
			.append("\t").append(tempTotal/2.0).append("\n");
			
			//�� �л��� �ڹ������� ����Ŭ ������ ���� ���� ������
			
			totalScore+=tempTotal;
			//�� �л��� ���������� �ʱ�ȭ
			tempTotal=0;
		}
//		DecimalFormat df=new DecimalFormat("0.00");
//		String avg=df.format(totalScore/(double)(listStu.size()*2));
		
		viewData.append("-----------------------------------------------------------------------------------\n")
		.append("\t\t\t\t����").append(totalScore).append("\t���")
		.append(String.format("%5.2f", totalScore/(double)(listStu.size()*2)));
		
		
		JTextArea jta=new JTextArea(7,50);
		jta.append(viewData.toString());//ȭ���� ������ �����͸� JTA�� �ٿ��ش�.
		JScrollPane jsp=new JScrollPane(jta);
		JOptionPane.showMessageDialog(null, jsp);
	}

	public static void main(String[] args) {
		ScoreProcess sp = new ScoreProcess();
		sp.inputMenu();
	}// main

}// class
