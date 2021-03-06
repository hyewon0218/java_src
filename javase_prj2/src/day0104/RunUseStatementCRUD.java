package day0104;

import java.awt.Font;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

public class RunUseStatementCRUD {

	private UseStatementCRUD us_crud;

	public RunUseStatementCRUD() {
		us_crud = new UseStatementCRUD();
	}

	public void addCpDept() {//추가성공실패3가지
		String tempData = JOptionPane.showInputDialog("부서정보 추가\n입력 예)부서번호,부서명,위치");
		if (tempData != null && !tempData.equals("")) {// 데이터있다면 (and)
			String[] data = tempData.split(",");

			if (data.length != 3) {
				JOptionPane.showMessageDialog(null, "입력형식을 확인해 주세요.");
				return;// 아래로 흘러가지 않게
			}
			int deptno = 0;
			String dname = "";
			String loc = "";

			try {
				deptno = Integer.parseInt(data[0]);// 예외터지면캐치로
				dname = data[1];// 아래에있으나위에있으나실행안됨(성격같은것끼리묶기)
				loc = data[2];
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "부서번호는 숫자입니다.");
				return;
			}
			// 처리된 입력데이터를VO에 설정하고
			CpDeptVO cdvo = new CpDeptVO(deptno, dname, loc);
			// VO의 값을 DB에 insert한다.
			try {
				us_crud.insertCpDept(cdvo);// 추가성공
				JOptionPane.showMessageDialog(null, deptno + "번 부서정보 추가");
			} catch (SQLException se) {// 예외
				
				String errMmsg="";
				switch (se.getErrorCode()) {
				case 1: errMmsg=deptno+"번 부서는 이미 존재합니다"; break;	
				case 1438: errMmsg="부서번호는 두자리입니다."; break;	
				case 12899: errMmsg="부서명이나 위치가 너무 깁니다."; break;	
				default : errMmsg="뎨둉합니다. 시스템에 문제가 발생했습니다. 잠시후에 다시 시도";
				}
				JOptionPane.showMessageDialog(null, errMmsg);
				se.printStackTrace();
			}

		}
	}

	public void modifyCpDept() {
		String tempData = JOptionPane.showInputDialog("부서정보 변경 부서번호에 일치하는 부서명과 위치를 변경합니다. \n입력 예)부서번호,부서명,위치");
		if (tempData != null && !tempData.equals("")) {// 데이터있다면 (and)
			String[] data = tempData.split(",");

			if (data.length != 3) {
				JOptionPane.showMessageDialog(null, "입력형식을 확인해 주세요.");
				return;// 아래로 흘러가지 않게
			}
			int deptno = 0;
			String dname = "";
			String loc = "";

			try {
				deptno = Integer.parseInt(data[0]);// 예외터지면캐치로
				dname = data[1];// 아래에있으나위에있으나실행안됨(성격같은것끼리묶기)
				loc = data[2];
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "부서번호는 숫자입니다.");
				return;
			}
			// 처리된 입력데이터를VO에 설정하고
			CpDeptVO cdvo = new CpDeptVO(deptno, dname, loc);
			// VO의 값을 DB에 insert한다.
			try {
				String msg="";
				if(us_crud.updateCpDept(cdvo)) {//변경된 레코드 존재
					msg=deptno+"번 부서의 정보를 변경하였습니다";
				}else {//변경된 레코드 존재하지x
					msg=deptno+"번 부서는 존재하지 않습니다.";
					
				}
				JOptionPane.showMessageDialog(null, msg);
			} catch (SQLException se) {// 예외
				
				String errMmsg="";
				switch (se.getErrorCode()) {
				case 12899: errMmsg="부서명은이나 위치가 너무 깁니다."; break;	
				default : errMmsg="뎨둉합니다. 시스템에 문제가 발생했습니다. 잠시후에 다시 시도";
				}
				JOptionPane.showMessageDialog(null, errMmsg);
				se.printStackTrace();
			}

		}
	}

	public void removeCpDept() {
		String inputData=JOptionPane.showInputDialog("부서삭제\n삭제할 부서번호 입력");
		if(inputData !=null && !inputData.equals("")) {//데이터가있을때 (!주의)
			int deptno=0;
			
			try {
				deptno=Integer.parseInt(inputData);//숫자일때만
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "부서번호는 숫자이어야합니다.");
				return;//아래로 흘러가지못하게
			}
			try {
				String msg=deptno+"번 부서는 존재하지 않습니다";
				
				if(us_crud.deleteCpDept(deptno)) {
					msg=deptno+"번 부서 정보를 삭제하였습니다.";
				}
				
				JOptionPane.showMessageDialog(null, msg);
				
			} catch (SQLException se) {
				JOptionPane.showMessageDialog(null, "죄송합니다. 문제가 발생하였습니다.");
				se.printStackTrace();
			}
			
			
		}
	}

	public void searchAllCpDept() {
		
		StringBuilder viewCpDept=new StringBuilder();
		viewCpDept
		.append("---------------------------------------------------------------------------------------------------------------\n")
		.append("번호\t부서번호\t부서명\t위치\n")
		.append("---------------------------------------------------------------------------------------------------------------\n");
		
		
		int rowCount=0;
		try {
			//DB에서 조회한 결과 받기
			List<CpDeptVO> list=us_crud.selectAllCpDept();
			CpDeptVO cdv=null;
			
			rowCount=list.size();
			for(int i=0; i < list.size() ; i++) {
				cdv=list.get(i);
				viewCpDept.append(i+1).append("\t")
				.append(cdv.getDeptno()).append("\t")
				.append(cdv.getDname()).append("\t")
				.append(cdv.getLoc()).append("\n");
			}
			
			if(list.isEmpty()) {//list.size()==0과 같음
				viewCpDept.append("입력된 부서정보가 존재하지 않습니다.\n");
			}
		} catch (SQLException e) {
			viewCpDept.append("DBMS에서 문제가 발생했습니다.ㅈㅅ!\n");
			e.printStackTrace();
		}
		
		viewCpDept.append("---------------------------------------------------------------------------------------------------------------\n")
		.append("\t\t총").append(rowCount).append("개의 부서정보가 조회되었습니다.");
		
		JTextArea jta=new JTextArea(20, 50);
		jta.setEditable(false);//사용자가 임의로 편집하지 못하게 막음
		jta.setText(viewCpDept.toString());//만들어진 출력데이터를 T.A에 설정한다. 
		
		JScrollPane jsp=new JScrollPane(jta);
		jsp.setBorder(new TitledBorder("전체 부서 조회 결과"));
		JOptionPane.showMessageDialog(null, jsp);
	}

	public void searchOneCpDept() {
		String inputData=JOptionPane.showInputDialog("부서조회\n조회할 부서번호 입력");
		if(inputData!=null && !inputData.equals("")) {
			 int deptno=0;
			try {
			   deptno=Integer.parseInt(inputData);
			   //부서번호를 입력하여 부서번호에 해당하는 부서정보를 조회
			   //조회한 부서가 있다면 생성된 객체가 반환되고 조회된 부서가 없다면
			   //null이 반환된다.
			   OneCpDeptVO ocd_vo=us_crud.selectCpDept(deptno);
			   
			   StringBuilder viewData=new StringBuilder();
			   viewData.append("부서명 : ").append(ocd_vo.getDname())
			   .append(", 위치 : ").append(ocd_vo.getLoc());
			   
			   JLabel lbl=new JLabel(viewData.toString());
			   lbl.setFont(new Font("SensSerif", Font.BOLD, 15));
			   
			   JOptionPane.showMessageDialog(null, lbl);
			}catch(NullPointerException npe) {
				//존재하는 부서번호를 제공 
				try {
					List<Integer> listDepNo=us_crud.selectAllCpDeptNo();
					
					if(!listDepNo.isEmpty()) {
						StringBuilder msg=new StringBuilder();
						msg.append(deptno).append("부서는 존재하지 않습니다.");
						for(int i=0; i<listDepNo.size(); i++) {
							if(i==listDepNo.size()-1) {
								msg.append(listDepNo.get(i));
							}else {
								msg.append(listDepNo.get(i)).append(",");
							}
						}
						msg.append("번 부서만 존재합니다.");
						JOptionPane.showMessageDialog(null, msg);
					
					}else {
						JOptionPane.showMessageDialog(null, "어떤 부서도 존재하지 않습니다.");
					}
				
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
			}catch(NumberFormatException nfe) {
				JOptionPane.showInputDialog(null, "부서번호는 정수형태로 입력하셔야 합니다.");
			} catch (SQLException e) {//한번에 여러catch가능
				JOptionPane.showMessageDialog(null, "서버에서 문제발생!!");
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		RunUseStatementCRUD rus_crud = new RunUseStatementCRUD();

		boolean exitFlag = false;
		String intputMenu = "";
		do {
			intputMenu = JOptionPane.showInputDialog("메뉴선택\n1.부서추가 2.부서변경 3.부서삭제 4.전체부서조회 5.특정부서조회 6.종료");
			if(intputMenu !=null ) {//??
				
			switch (intputMenu) {
			case "1":
				rus_crud.addCpDept();// 추가
				break;
			case "2":
				rus_crud.modifyCpDept();
				break;
			case "3":
				rus_crud.removeCpDept();
				break;
			case "4":
				rus_crud.searchAllCpDept();
				break;
			case "5":
				rus_crud.searchOneCpDept();
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
	}// main

}
