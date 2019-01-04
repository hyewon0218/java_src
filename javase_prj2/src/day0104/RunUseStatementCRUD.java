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

	public void addCpDept() {//�߰���������3����
		String tempData = JOptionPane.showInputDialog("�μ����� �߰�\n�Է� ��)�μ���ȣ,�μ���,��ġ");
		if (tempData != null && !tempData.equals("")) {// �������ִٸ� (and)
			String[] data = tempData.split(",");

			if (data.length != 3) {
				JOptionPane.showMessageDialog(null, "�Է������� Ȯ���� �ּ���.");
				return;// �Ʒ��� �귯���� �ʰ�
			}
			int deptno = 0;
			String dname = "";
			String loc = "";

			try {
				deptno = Integer.parseInt(data[0]);// ����������ĳġ��
				dname = data[1];// �Ʒ�����������������������ȵ�(���ݰ����ͳ�������)
				loc = data[2];
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�μ���ȣ�� �����Դϴ�.");
				return;
			}
			// ó���� �Էµ����͸�VO�� �����ϰ�
			CpDeptVO cdvo = new CpDeptVO(deptno, dname, loc);
			// VO�� ���� DB�� insert�Ѵ�.
			try {
				us_crud.insertCpDept(cdvo);// �߰�����
				JOptionPane.showMessageDialog(null, deptno + "�� �μ����� �߰�");
			} catch (SQLException se) {// ����
				
				String errMmsg="";
				switch (se.getErrorCode()) {
				case 1: errMmsg=deptno+"�� �μ��� �̹� �����մϴ�"; break;	
				case 1438: errMmsg="�μ���ȣ�� ���ڸ��Դϴ�."; break;	
				case 12899: errMmsg="�μ������̳� ��ġ�� �ʹ� ��ϴ�."; break;	
				default : errMmsg="���E�մϴ�. �ý��ۿ� ������ �߻��߽��ϴ�. ����Ŀ� �ٽ� �õ�";
				}
				JOptionPane.showMessageDialog(null, errMmsg);
				se.printStackTrace();
			}

		}
	}

	public void modifyCpDept() {
		String tempData = JOptionPane.showInputDialog("�μ����� ���� �μ���ȣ�� ��ġ�ϴ� �μ����� ��ġ�� �����մϴ�. \n�Է� ��)�μ���ȣ,�μ���,��ġ");
		if (tempData != null && !tempData.equals("")) {// �������ִٸ� (and)
			String[] data = tempData.split(",");

			if (data.length != 3) {
				JOptionPane.showMessageDialog(null, "�Է������� Ȯ���� �ּ���.");
				return;// �Ʒ��� �귯���� �ʰ�
			}
			int deptno = 0;
			String dname = "";
			String loc = "";

			try {
				deptno = Integer.parseInt(data[0]);// ����������ĳġ��
				dname = data[1];// �Ʒ�����������������������ȵ�(���ݰ����ͳ�������)
				loc = data[2];
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�μ���ȣ�� �����Դϴ�.");
				return;
			}
			// ó���� �Էµ����͸�VO�� �����ϰ�
			CpDeptVO cdvo = new CpDeptVO(deptno, dname, loc);
			// VO�� ���� DB�� insert�Ѵ�.
			try {
				String msg="";
				if(us_crud.updateCpDept(cdvo)) {//����� ���ڵ� ����
					msg=deptno+"�� �μ��� ������ �����Ͽ����ϴ�";
				}else {//����� ���ڵ� ��������x
					msg=deptno+"�� �μ��� �������� �ʽ��ϴ�.";
					
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

	public void removeCpDept() {
		String inputData=JOptionPane.showInputDialog("�μ�����\n������ �μ���ȣ �Է�");
		if(inputData !=null && !inputData.equals("")) {//�����Ͱ������� (!����)
			int deptno=0;
			
			try {
				deptno=Integer.parseInt(inputData);//�����϶���
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�μ���ȣ�� �����̾���մϴ�.");
				return;//�Ʒ��� �귯�������ϰ�
			}
			try {
				String msg=deptno+"�� �μ��� �������� �ʽ��ϴ�";
				
				if(us_crud.deleteCpDept(deptno)) {
					msg=deptno+"�� �μ� ������ �����Ͽ����ϴ�.";
				}
				
				JOptionPane.showMessageDialog(null, msg);
				
			} catch (SQLException se) {
				JOptionPane.showMessageDialog(null, "�˼��մϴ�. ������ �߻��Ͽ����ϴ�.");
				se.printStackTrace();
			}
			
			
		}
	}

	public void searchAllCpDept() {
		
		StringBuilder viewCpDept=new StringBuilder();
		viewCpDept
		.append("---------------------------------------------------------------------------------------------------------------\n")
		.append("��ȣ\t�μ���ȣ\t�μ���\t��ġ\n")
		.append("---------------------------------------------------------------------------------------------------------------\n");
		
		
		int rowCount=0;
		try {
			//DB���� ��ȸ�� ��� �ޱ�
			List<CpDeptVO>list=us_crud.selectAllCpDept();
			CpDeptVO cdv=null;
			
			rowCount=list.size();
			for(int i=0; i < list.size() ; i++) {
				cdv=list.get(i);
				viewCpDept.append(i+1).append("\t")
				.append(cdv.getDeptno()).append("\t")
				.append(cdv.getDname()).append("\t")
				.append(cdv.getLoc()).append("\n");
			}
			
			if(list.isEmpty()) {//list.size()==0�� ����
				viewCpDept.append("�Էµ� �μ������� �������� �ʽ��ϴ�.\n");
			}
		} catch (SQLException e) {
			viewCpDept.append("DBMS���� ������ �߻��߽��ϴ�.����!\n");
			e.printStackTrace();
		}
		
		viewCpDept.append("---------------------------------------------------------------------------------------------------------------\n")
		.append("\t\t��").append(rowCount).append("���� �μ������� ��ȸ�Ǿ����ϴ�.");
		
		JTextArea jta=new JTextArea(20, 50);
		jta.setEditable(false);//����ڰ� ���Ƿ� �������� ���ϰ� ����
		jta.setText(viewCpDept.toString());//������� ��µ����͸� T.A�� �����Ѵ�. 
		
		JScrollPane jsp=new JScrollPane(jta);
		jsp.setBorder(new TitledBorder("��ü �μ� ��ȸ ���"));
		JOptionPane.showMessageDialog(null, jsp);
	}

	public void searchOneCpDept() {
		String inputData=JOptionPane.showInputDialog("�μ���ȸ\n��ȸ�� �μ���ȣ �Է�");
		if(inputData!=null && !inputData.equals("")) {
			 int deptno=0;
			try {
			   deptno=Integer.parseInt(inputData);
			   //�μ���ȣ�� �Է��Ͽ� �μ���ȣ�� �ش��ϴ� �μ������� ��ȸ
			   //��ȸ�� �μ��� �ִٸ� ������ ��ü�� ��ȯ�ǰ� ��ȸ�� �μ��� ���ٸ�
			   //null�� ��ȯ�ȴ�.
			   OneCpDeptVO ocd_vo=us_crud.selectCpDept(deptno);
			   
			   StringBuilder viewData=new StringBuilder();
			   viewData.append("�μ��� : ").append(ocd_vo.getDname())
			   .append(", ��ġ : ").append(ocd_vo.getLoc());
			   
			   JLabel lbl=new JLabel(viewData.toString());
			   lbl.setFont(new Font("SensSerif", Font.BOLD, 15));
			   
			   JOptionPane.showMessageDialog(null, lbl);
			}catch(NullPointerException npe) {
				//�����ϴ� �μ���ȣ�� ���� 
				try {
					List<Integer> listDepNo=us_crud.selectAllCpDeptNo();
					
					if(!listDepNo.isEmpty()) {
						StringBuilder msg=new StringBuilder();
						msg.append(deptno).append("�μ��� �������� �ʽ��ϴ�.");
						for(int i=0; i<listDepNo.size(); i++) {
							if(i==listDepNo.size()-1) {
								msg.append(listDepNo.get(i));
							}else {
								msg.append(listDepNo.get(i)).append(",");
							}
						}
						msg.append("�� �μ��� �����մϴ�.");
						JOptionPane.showMessageDialog(null, msg);
					
					}else {
						JOptionPane.showMessageDialog(null, "� �μ��� �������� �ʽ��ϴ�.");
					}
				
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
			}catch(NumberFormatException nfe) {
				JOptionPane.showInputDialog(null, "�μ���ȣ�� �������·� �Է��ϼž� �մϴ�.");
			} catch (SQLException e) {//�ѹ��� ����catch����
				JOptionPane.showMessageDialog(null, "�������� �����߻�!!");
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		RunUseStatementCRUD rus_crud = new RunUseStatementCRUD();

		boolean exitFlag = false;
		String intputMenu = "";
		do {
			intputMenu = JOptionPane.showInputDialog("�޴�����\n1.�μ��߰� 2.�μ����� 3.�μ����� 4.��ü�μ���ȸ 5.Ư���μ���ȸ 6.����");
			if(intputMenu !=null ) {//??
				
			switch (intputMenu) {
			case "1":
				rus_crud.addCpDept();// �߰�
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
	}// main

}