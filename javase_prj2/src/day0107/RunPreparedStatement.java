package day0107;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import day0104.CpDeptVO;

public class RunPreparedStatement {
	
	private UsePreparedStatementDAO ups_dao;
	
	public RunPreparedStatement() {
		ups_dao=new UsePreparedStatementDAO();
	}

	public void addCpEmp2 () {
		
		String tempData = JOptionPane.showInputDialog("사원정보 추가\n입력 예)사원번호,사원명,연봉");
		if (tempData != null && !tempData.equals("")) {// 데이터있다면 (and)
			String[] data = tempData.split(",");

			if (data.length != 3) {
				JOptionPane.showMessageDialog(null, "입력형식을 확인해 주세요.");
				return;// 아래로 흘러가지 않게
			}
			int empno = 0, sal=0;
			String ename = "";

			try {
				empno = Integer.parseInt(data[0]);// 예외터지면캐치로
				ename = data[1];// 아래에있으나위에있으나실행안됨(성격같은것끼리묶기)
				sal = Integer.parseInt(data[2]);
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "사원번호나 연봉은 숫자입니다.");
				return;
			}
			// 처리된 입력데이터를VO에 설정하고
			CpEmp2VO cevo = new CpEmp2VO(empno,sal, ename);
			
			// VO의 값을 DB에 insert한다.
			try {
				ups_dao.insertCpEmp2(cevo);// 추가성공
				JOptionPane.showMessageDialog(null, empno + "번 사원정보가 입력되었습니다.");
			} catch (SQLException se) {// 예외
				
				String errMmsg="";
				switch (se.getErrorCode()) {
					case 1438: errMmsg="사원 번호는 4자리이고 연봉은 5자리입니다."; break;	
					case 12899: errMmsg="사원명이 너무 깁니다."; break;	
					default : errMmsg="뎨둉합니다. 시스템에 문제가 발생했습니다. 잠시후에 다시 시도";
				}
				JOptionPane.showMessageDialog(null, errMmsg);
				se.printStackTrace();
			}

		}
	}
	public void modifyCpEmp2 () {
		
	}
	public void removeCpEmp2 () {
		
	}
	public void searchAllCpEmp2 () {
		
	}
	public void searchOneCpEmp2 () {
		
	}
	
	public static void main(String[] args) {
		RunPreparedStatement rps=new RunPreparedStatement();
		
		boolean exitFlag = false;
		String intputMenu = "";
		do {
			intputMenu = JOptionPane.showInputDialog("메뉴선택\n1.사원추가 2.사원변경 3.사원삭제 4.전체사원조회 5.특정사원조회 6.종료");
			if(intputMenu !=null ) {//??
				
			switch (intputMenu) {
			case "1":
				rps.addCpEmp2();// 추가
				break;
			case "2":
				rps.modifyCpEmp2();
				break;
			case "3":
				rps.removeCpEmp2();
				break;
			case "4":
				rps.searchAllCpEmp2();
				break;
			case "5":
				rps.searchOneCpEmp2();
				break;
			case "6":
				exitFlag = true;// 나감
				break;

			default:
				JOptionPane.showMessageDialog(null, intputMenu + "는(은) 제공되는 서비스가 아닙니다.");
				break;
			}//end switch
			}else {
				exitFlag=true;
		}//end if
	} while (!exitFlag);
		JOptionPane.showMessageDialog(null, "사용해 주셔서 감사합니다.");
	}//main

}
