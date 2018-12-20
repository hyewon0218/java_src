package day1217;

import javax.swing.JOptionPane;

import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.List;

public class ScoreProcess2 {

	private List<ScoreVO> listStu;
	private int totalScore;

	public ScoreProcess2() {
		listStu = new ArrayList<ScoreVO>();
	}

	public void inputMenu() {
		String selectMenu="", inputResult="";
		boolean exitFlag=false;
		
		do {
			selectMenu=JOptionPane.showInputDialog("�޴�����\n1.�Է� 2. ��� 3.����");
			try {
				switch(parseInt(selectMenu)) {
				case 1:
					inputResult="�������� ������ ���� �ʰų� ������ ���������̾�� �մϴ�.";
					
					if(inputData()) {
						inputResult="�߰�����";
					}
					JOptionPane.showMessageDialog(null, inputResult);
					break;
				case 2:
					printData();
					break;
				case 3:
					exitFlag=true;
					break;
				default:
					JOptionPane.showMessageDialog(null, "�޴��� 1,2,3 �� �ϳ��̾�� �մϴ�.");
				}
				
			}catch(NumberFormatException nfe) {//���������� �ƴѰ�� �߻�
				JOptionPane.showMessageDialog(null, "�޴��� �����̾�� �մϴ�.");
			}
		}while(!exitFlag);
	
	}

	public boolean inputData() {
		boolean flag = false;

		String inputData = JOptionPane.showInputDialog("�������Է�\\n��)�̸�, �ڹ�����, ����Ŭ����");
		try {
			String[] data = inputData.replaceAll(" ", "").split(",");
			if (data.length == 3) {
				try {
					ScoreVO sv = new ScoreVO(data[0], parseInt(data[1]), parseInt(data[2]));
					listStu.add(sv);
					flag = true;
				} catch (NumberFormatException nfe) {
					flag = false;
				}
			}
		} catch (NullPointerException npe) {

		}
		return flag;///
	}

	public void printData() {
		if(listStu.size()==0) {
			JOptionPane.showMessageDialog(null, "����� �����Ͱ� �����ϴ�.");
			return;
		}
		StringBuilder viewData=new StringBuilder();
		viewData
		.append("------------------------------------------------------------------------\n")
		.append("��ȣ\t�̸�\t�ڹ�\t����Ŭ\t����\t���\n")
		.append("--------------------------------------------------------------------------\n");
		int tempTotal=0;
		ScoreVO sv=null;
		for(int i=0; i < listStu.size(); i++) {
			sv=listStu.get(i);
			tempTotal=sv.getJavaScore()+sv.getOraclScore();
		}
		
	}

	public static void main(String[] args) {
		ScoreProcess2 sp2 = new ScoreProcess2();
	}

}
