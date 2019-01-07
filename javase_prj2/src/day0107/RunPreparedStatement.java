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
		
		String tempData = JOptionPane.showInputDialog("������� �߰�\n�Է� ��)�����ȣ,�����,����");
		if (tempData != null && !tempData.equals("")) {// �������ִٸ� (and)
			String[] data = tempData.split(",");

			if (data.length != 3) {
				JOptionPane.showMessageDialog(null, "�Է������� Ȯ���� �ּ���.");
				return;// �Ʒ��� �귯���� �ʰ�
			}
			int empno = 0, sal=0;
			String ename = "";

			try {
				empno = Integer.parseInt(data[0]);// ����������ĳġ��
				ename = data[1];// �Ʒ�����������������������ȵ�(���ݰ����ͳ�������)
				sal = Integer.parseInt(data[2]);
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�����ȣ�� ������ �����Դϴ�.");
				return;
			}
			// ó���� �Էµ����͸�VO�� �����ϰ�
			CpEmp2VO cevo = new CpEmp2VO(empno,sal, ename);
			
			// VO�� ���� DB�� insert�Ѵ�.
			try {
				ups_dao.insertCpEmp2(cevo);// �߰�����
				JOptionPane.showMessageDialog(null, empno + "�� ��������� �ԷµǾ����ϴ�.");
			} catch (SQLException se) {// ����
				
				String errMmsg="";
				switch (se.getErrorCode()) {
					case 1438: errMmsg="��� ��ȣ�� 4�ڸ��̰� ������ 5�ڸ��Դϴ�."; break;	
					case 12899: errMmsg="������� �ʹ� ��ϴ�."; break;	
					default : errMmsg="���E�մϴ�. �ý��ۿ� ������ �߻��߽��ϴ�. ����Ŀ� �ٽ� �õ�";
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
			intputMenu = JOptionPane.showInputDialog("�޴�����\n1.����߰� 2.������� 3.������� 4.��ü�����ȸ 5.Ư�������ȸ 6.����");
			if(intputMenu !=null ) {//??
				
			switch (intputMenu) {
			case "1":
				rps.addCpEmp2();// �߰�
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
				exitFlag = true;// ����
				break;

			default:
				JOptionPane.showMessageDialog(null, intputMenu + "��(��) �����Ǵ� ���񽺰� �ƴմϴ�.");
				break;
			}//end switch
			}else {
				exitFlag=true;
		}//end if
	} while (!exitFlag);
		JOptionPane.showMessageDialog(null, "����� �ּż� �����մϴ�.");
	}//main

}
