package day0107;

import java.awt.Font;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import day0104.CpDeptVO;
import day0104.OneCpDeptVO;

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
		String tempData = JOptionPane.showInputDialog("������� ����\n �����ȣ�� ��ġ�ϴ� ������ ��ġ�� �����մϴ�. \n�Է� ��)�����ȣ,�����,��ġ");
		if (tempData != null && !tempData.equals("")) {// �������ִٸ� (and)
			String[] data = tempData.split(",");

			if (data.length != 3) {
				JOptionPane.showMessageDialog(null, "�Է������� Ȯ���� �ּ���.");
				return;// �Ʒ��� �귯���� �ʰ�
			}
			int empno = 0,sal=0;
			String ename = "";

			try {
				empno = Integer.parseInt(data[0].trim());//������ ����������ĳġ��
				ename = data[1].trim();// �յڰ�������
				sal = Integer.parseInt(data[2].trim());
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�����ȣ�� ������ �����Դϴ�.");
				return;
				
			}
			// ó���� �Էµ����͸�VO�� �����ϰ�
			CpEmp2VO cevo = new CpEmp2VO(empno, sal, ename);
			// VO�� ���� DB�� insert�Ѵ�.
			try {
				String msg="";
				if(ups_dao.updateCpEmp2(cevo)) {//����� ���ڵ� ����
					msg=empno+"�� ����� ������ �����Ͽ����ϴ�";
				}else {//����� ���ڵ� ��������x
					msg=empno+"�� ����� �������� �ʽ��ϴ�.";	
				}
				JOptionPane.showMessageDialog(null, msg);
				
			} catch (SQLException se) {// ����
				
				String errMmsg="";
				switch (se.getErrorCode()) {
				case 12899: errMmsg="�μ������̳� ��ġ�� �ʹ� ��ϴ�."; break;	
				default : errMmsg="���E�մϴ�. �ý��ۿ� ������ �߻��߽��ϴ�. ����Ŀ� �ٽ� �õ�";
				}
				JOptionPane.showMessageDialog(null, errMmsg);
				se.printStackTrace();
			}

		}
	}


	public void removeCpEmp2 () {
		String inputData=JOptionPane.showInputDialog("�������\n������ �����ȣ �Է�");
		if(inputData !=null && !inputData.equals("")) {//�����Ͱ������� (!����)
			int empno=0;
			
			try {
				empno=Integer.parseInt(inputData.trim());//�����϶���, �յڰ�������
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�����ȣ�� �����̾���մϴ�.");
				return;//�Ʒ��� �귯�������ϰ�
			}
			try {
				String msg=empno+"�� ����� �������� �ʽ��ϴ�";
				
				if(ups_dao.deleteCpEmp2(empno)) {
					msg=empno+"�� ��� ������ �����Ͽ����ϴ�.";
				}
				
				JOptionPane.showMessageDialog(null, msg);
				
			} catch (SQLException se) {
				JOptionPane.showMessageDialog(null, "�˼��մϴ�. ������ �߻��Ͽ����ϴ�.");
				se.printStackTrace();
			}
			
			
		}
	
	}
	public void searchAllCpEmp2 () {
		StringBuilder viewCpEmp=new StringBuilder();
		viewCpEmp
		.append("---------------------------------------------------------------------------------------------------------------\n")
		.append("��ȣ\t�����ȣ\t�����\t����\t�Ի���\n")
		.append("---------------------------------------------------------------------------------------------------------------\n");
		
		
		int rowCount=0;
		try {
			//DB���� ��ȸ�� ��� �ޱ�
			List<CpEmp2AllVO> list=ups_dao.selectAllCpEmp2();
			CpEmp2AllVO cevo=null;
			
			rowCount=list.size();
			for(int i=0; i < list.size() ; i++) {
				cevo=list.get(i);
				viewCpEmp.append(i+1).append("\t")
				.append(cevo.getEmpno()).append("\t")
				.append(cevo.getEname()).append("\t")
				.append(cevo.getSal()).append("\t")
				.append(cevo.getHiredate()).append("\n");
			}
			
			if(list.isEmpty()) {//list.size()==0�� ����
				viewCpEmp.append("�Էµ� ��������� �������� �ʽ��ϴ�.\n");
			}
		} catch (SQLException e) {
			viewCpEmp.append("DBMS���� ������ �߻��߽��ϴ�.����!\n");
			e.printStackTrace();
		}
		
		viewCpEmp.append("---------------------------------------------------------------------------------------------------------------\n")
		.append("\t\t��").append(rowCount).append("���� ��������� ��ȸ�Ǿ����ϴ�.");
		
		JTextArea jta=new JTextArea(20, 50);
		jta.setEditable(false);//����ڰ� ���Ƿ� �������� ���ϰ� ����
		jta.setText(viewCpEmp.toString());//������� ��µ����͸� T.A�� �����Ѵ�. 
		
		JScrollPane jsp=new JScrollPane(jta);
		jsp.setBorder(new TitledBorder("��ü ��� ��ȸ ���"));
		JOptionPane.showMessageDialog(null, jsp);
	}
	public void searchOneCpEmp2 () {
		String inputData=JOptionPane.showInputDialog("�����ȸ\n��ȸ�� �����ȣ �Է�");
		if(inputData!=null && !inputData.equals("")) {
			 int deptno=0;
			try {
			   int empno=Integer.parseInt(inputData.trim());
			   //�����ȣ�� �Է��Ͽ� �����ȣ�� �ش��ϴ� �μ������� ��ȸ
			   //��ȸ�� ����� �ִٸ� ������ ��ü(cpemp2onevo)�� ��ȯ�ǰ� ��ȸ�� ����� ���ٸ�
			   //null�� ��ȯ�ȴ�.
			   CpEmp2OneVO ceo_vo=ups_dao.selectOneCpEmp2(empno);
			   
			   SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yy EEEEE");//��¥�����ֱ����ذ�ü����(toChar�� �ȸ�����(������))
			   
			   StringBuilder viewData=new StringBuilder();
			   viewData.append("����� : ").append(ceo_vo.getEname())
			   .append(", ���� : ").append(ceo_vo.getSal())
			   .append(", �Ի��� : ").append(sdf.format(ceo_vo.getHiredate()) );//tostring�޼ҵ� �ҷ���(��¥����,,)
			   
			   JLabel lbl=new JLabel(viewData.toString());
			   lbl.setFont(new Font("SensSerif", Font.BOLD, 15));
			   
			   JOptionPane.showMessageDialog(null, lbl);
			}catch(NullPointerException npe) {
				JOptionPane.showMessageDialog(null, inputData+"�� �����ȣ�� �������� �ʽ��ϴ�.");		
			}catch(NumberFormatException nfe) {
				JOptionPane.showInputDialog(null, "�����ȣ�� �������·� �Է��ϼž� �մϴ�.");
			} catch (SQLException e) {//�ѹ��� ����catch����
				JOptionPane.showMessageDialog(null, "�������� �����߻�!!");
				e.printStackTrace();
			}
		}
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
