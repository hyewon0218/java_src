package day0109;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import day0107.CpEmp2VO;

public class RunUseCallableStatement {
	
	public void addTestProc() {
		String tempData = JOptionPane.showInputDialog("사원정보 추가\n입력 예)사원번호,사원명,연봉,직무");
		if (tempData != null && !tempData.equals("")) {// 데이터있다면 (and)
			String[] data = tempData.split(",");

			if (data.length != 4) {
				JOptionPane.showMessageDialog(null, "입력형식을 확인해 주세요.");
				return;// 아래로 흘러가지 않게
			}
			int empno = 0, sal=0;
			String ename = "",job="";

			try {
				empno = Integer.parseInt(data[0].trim());// 예외터지면캐치로
				ename = data[1];// 아래에있으나위에있으나실행안됨(성격같은것끼리묶기)
				sal = Integer.parseInt(data[2].trim());
				job = data[3].trim();
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "사원번호나 연봉은 숫자입니다.");
				return;
			}
			// 처리된 입력데이터를VO에 설정하고
			TestProcVO tpvo=new TestProcVO(empno, sal, ename, job);
			
			// VO의 값을 DB에 insert한다.
			try {
				String msg="";
				msg=UseCallableStatementDAO.getInstance().insertProc(tpvo);
//				ups_dao.insertCpEmp2(cevo);// 추가성공
				JOptionPane.showMessageDialog(null, empno + "번 사원정보가 입력되었습니다.");
			} catch (SQLException se) {// 예외
				
				
				JOptionPane.showMessageDialog(null, "DBMS에 사소한 문제발생");
				se.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {
		RunUseCallableStatement rucs=new RunUseCallableStatement();
		boolean exitFlag = false;
		String intputMenu = "";
		do {
			intputMenu = JOptionPane.showInputDialog("메뉴선택\n1.사원추가 2.사원변경 3.사원삭제 4.전체사원조회 5.특정사원조회 6.종료");
			if(intputMenu !=null ) {//??
				
			switch (intputMenu) {
			case "1":
				 rucs.addTestProc();// 추가
				break;
//			case "2":
//				rps.modifyCpEmp2();
//				break;
//			case "3":
//				rps.removeCpEmp2();
//				break;
//			case "4":
//				rps.searchAllCpEmp2();
//				break;
//			case "5":
//				rps.searchOneCpEmp2();
//				break;
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

}//class
