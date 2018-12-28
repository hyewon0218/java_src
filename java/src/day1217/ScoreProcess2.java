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
			selectMenu=JOptionPane.showInputDialog("메뉴선택\n1.입력 2. 출력 3.종료");
			try {
				switch(parseInt(selectMenu)) {
				case 1:
					inputResult="데이터의 갯수가 맞지 않거나 점수는 숫자형태이어야 합니다.";
					
					if(inputData()) {
						inputResult="추가성공";
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
					JOptionPane.showMessageDialog(null, "메뉴는 1,2,3 중 하나이어야 합니다.");
				}
				
			}catch(NumberFormatException nfe) {//숫자형식이 아닌경우 발생
				JOptionPane.showMessageDialog(null, "메뉴는 숫자이어야 합니다.");
			}
		}while(!exitFlag);
	
	}

	public boolean inputData() {
		boolean flag = false;

		String inputData = JOptionPane.showInputDialog("데이터입력\\n예)이름, 자바점수, 오라클점수");
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
			JOptionPane.showMessageDialog(null, "출력할 데이터가 없습니다.");
			return;
		}
		StringBuilder viewData=new StringBuilder();
		viewData
		.append("------------------------------------------------------------------------\n")
		.append("번호\t이름\t자바\t오라클\t총점\t평균\n")
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
