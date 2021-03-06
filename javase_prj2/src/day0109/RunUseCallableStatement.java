package day0109;

import java.awt.Font;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import day0107.CpEmp2AllVO;
import day0107.CpEmp2OneVO;
import day0107.CpEmp2VO;
import day0110.TestProcAllVO;
import day0110.TestProcOneVO;
import day0110.TestProcUpdateVO;

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
	public void modifyTestProc() {
		String tempData = JOptionPane.showInputDialog("사원정보 변경\n 사원번호에 일치하는 직무과 연봉를 변경합니다. \n입력 예)사원번호,직무,연봉");
		if (tempData != null && !tempData.equals("")) {// 데이터있다면 (and)
			String[] data = tempData.split(",");

			if (data.length != 3) {
				JOptionPane.showMessageDialog(null, "입력형식을 확인해 주세요.");
				return;// 아래로 흘러가지 않게
			}
			int empno = 0,sal=0;
			String job = "";

			try {
				empno = Integer.parseInt(data[0].trim());//정수로 예외터지면캐치로
				job = data[1].trim();// 앞뒤공백제거
				sal = Integer.parseInt(data[2].trim());
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "사원번호나 연봉은 숫자입니다.");
				return;
				
			}
			// 처리된 입력데이터를VO에 설정하고
			TestProcUpdateVO tpuvo = new TestProcUpdateVO(empno, sal, job);
			// VO의 값을 DB에 insert한다.
			try {
				String msg="";
				msg=UseCallableStatementDAO.getInstance().updateProc(tpuvo);
				
				JOptionPane.showMessageDialog(null, msg);
				
			} catch (SQLException se) {// 예외
				
				
				JOptionPane.showMessageDialog(null, "죄송! 잠시 후 다시 시도");
				se.printStackTrace();
			}

		}
	}
	public void removeTestProc() {
		String inputData=JOptionPane.showInputDialog("사원삭제\n삭제할 사원번호 입력");
		if(inputData !=null && !inputData.equals("")) {//데이터가있을때 (!주의)
			int empno=0;
			
			try {
				empno=Integer.parseInt(inputData.trim());//숫자일때만, 앞뒤공백제거
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "사원번호는 숫자이어야합니다.");
				return;//아래로 흘러가지못하게
			}
			try {
				String msg="";
				msg=UseCallableStatementDAO.getInstance().deleteProc(empno);///??
				
				JOptionPane.showMessageDialog(null, msg);
				
			} catch (SQLException se) {
				JOptionPane.showMessageDialog(null, "죄송합니다. 문제가 발생하였습니다.");
				se.printStackTrace();
			}
			
			
		}
	}
	public void searchAllTestProc() {
		
		StringBuilder viewTestProc=new StringBuilder();
		viewTestProc
		.append("---------------------------------------------------------------------------------------------------------------\n")
		.append("번호\t사원번호\t사원명\t연봉\t직무\t입사일\n")
		.append("---------------------------------------------------------------------------------------------------------------\n");
		
		
		int rowCount=0;
		try {
			//DB에서 조회한 결과 받기
			List<TestProcAllVO> list=UseCallableStatementDAO.getInstance().selectAllTestProc();
			
			TestProcAllVO tpavo=null;
			
			rowCount=list.size();
			for(int i=0; i < list.size() ; i++) {
				tpavo=list.get(i);
				viewTestProc.append(i+1).append("\t")
				.append(tpavo.getEmpno()).append("\t")
				.append(tpavo.getEname()).append("\t")
				.append(tpavo.getSal()).append("\t")
				.append(tpavo.getJob()).append("\t")
				.append(tpavo.getHiredate()).append("\n");
			}
			
			if(list.isEmpty()) {//list.size()==0과 같음
				viewTestProc.append("입력된 사원정보가 존재하지 않습니다.\n");
			}
		} catch (SQLException e) {
			viewTestProc.append("DBMS에서 문제가 발생했습니다.ㅈㅅ!\n");
			e.printStackTrace();
		}
		
		viewTestProc.append("---------------------------------------------------------------------------------------------------------------\n")
		.append("\t\t총").append(rowCount).append("명의 사원정보가 조회되었습니다.");
		
		JTextArea jta=new JTextArea(20, 50);
		jta.setEditable(false);//사용자가 임의로 편집하지 못하게 막음
		jta.setText(viewTestProc.toString());//만들어진 출력데이터를 T.A에 설정한다. 
		
		JScrollPane jsp=new JScrollPane(jta);
		jsp.setBorder(new TitledBorder("전체 사원 조회 결과"));
		JOptionPane.showMessageDialog(null, jsp);
	}
	public void searchOneTestProc() {
		
		String inputData=JOptionPane.showInputDialog("사원조회\n조회할 사원번호 입력");
		if(inputData!=null && !inputData.equals("")) {
			 int deptno=0;
			try {
			   int empno=Integer.parseInt(inputData.trim());
			   //사원번호를 입력하여 사원번호에 해당하는 부서정보를 조회
			   //조회한 사원가 있다면 생성된 객체(TestProcOneVO)가 반환되고 조회된 사원가 없다면
			   //null이 반환된다.
			   TestProcOneVO tpovo=UseCallableStatementDAO.getInstance().selectOneTestProc(empno);//불러주기
			   
			   
			   StringBuilder viewData=new StringBuilder();
			   viewData.append("사원명 : ").append(tpovo.getEname())
			   .append(", 연봉 : ").append(tpovo.getSal())
			   .append(", 직급 : ").append(tpovo.getJob())
			   .append(", 입사일 : ").append(tpovo.getHiredate() );//tostring메소드 불려옴(날짜형식,,)
			   
			   JLabel lbl=new JLabel(viewData.toString());
			   lbl.setFont(new Font("SensSerif", Font.BOLD, 15));
			   
			   JOptionPane.showMessageDialog(null, lbl);
			}catch(NullPointerException npe) {
				JOptionPane.showMessageDialog(null, inputData+"번 사원번호는 존재하지 않습니다.");		
			}catch(NumberFormatException nfe) {
				JOptionPane.showInputDialog(null, "사원번호는 정수형태로 입력하셔야 합니다.");
			} catch (SQLException e) {//한번에 여러catch가능
				JOptionPane.showMessageDialog(null, "서버에서 문제발생!!");
				e.printStackTrace();
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
			case "2":
				rucs.modifyTestProc();
				break;
			case "3":
				rucs.removeTestProc();
				break;
			case "4":
				rucs.searchAllTestProc();
				break;
			case "5":
				rucs.searchOneTestProc();
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

}//class
