package day0111_subb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class NamecardViewController extends WindowAdapter implements ActionListener{

	private NamecardView nv;
	private NamecardDAO n_dao;
	private String imgPath;
	
	public NamecardViewController(NamecardView nv) {
		this.nv=nv;
		n_dao=NamecardDAO.getInstance();
	
	}
	
	@Override
	public void windowClosing(WindowEvent ae) {
		nv.dispose();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == nv.getJbtAdd()) {
			
		}
		if(ae.getSource()==nv.getJbtImg()) {
			
		}
	}
	private void addNamecard() {
		JTextField jtfName=nv.getJtfName();
		JTextField jtfAddr=nv.getJtfAddr();
		
		String name=jtfName.getText().trim();
		if(name.equals("")) {
			JOptionPane.showMessageDialog(nv, "�̸��� �ʼ� �Է�!!");
			jtfName.requestFocus();
			return;
		}
		String addr=jtfAddr.getText().trim();
		if(addr.equals("")) {
			JOptionPane.showMessageDialog(nv, "�ּҴ� �ʼ� �Է�!!!");
		}
		boolean insertFlag=false;
		if(imgPath.equals("")) {//�̹����� �������� �ʾ��� �� 
			 insertFlag=JOptionPane.showConfirmDialog(nv, "�⺻�̹����� ����Ͻðڽ��ϱ�?")
			 	==JOptionPane.OK_OPTION;
			 if(insertFlag) {
				 imgPath="no_image.png";
			 }
		}else {//�̹����� �������� ��
			insertFlag=true;
		}
		if(insertFlag) {
			StringBuilder filePath=new StringBuilder();
			filePath.append(System.currentTimeMillis()).append(imgPath.substring(imgPath.lastIndexOf(".")));
			
			try {
				if(!imgPath.equals("no_image.png")) {
					uploadImg(filePath.toString());
				}
				NamecardVO nvo=new NamecardVO(name, addr, !imgPath.equals("no_image.png")?filePath.toString():"no_image.png");
				n_dao.insertNamecard(nvo);
				JOptionPane.showMessageDialog(nv, "������ �߰��Ǿ����ϴ�.");
				
				jtfName.setText("");
				jtfAddr.setText("");//�ʱ�ȭ
				nv.getJlPreview().setIcon(new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/upload/no_image.png"));
				jtfName.requestFocus();
				
				setAllNamecard();
				
			}catch(SQLException se) {
				JOptionPane.showMessageDialog(nv, "���� �߰� �� ���� �߻�");
			}catch(IOException ie) {
				JOptionPane.showMessageDialog(nv, "�̹��� ���ε� �� ���� �߻�");
			}
			imgPath="";
		}
	}
	
	private void setAllNamecard() {
		try {
			List<NamecardVO> list=n_dao.selectNamecard();
			
			DefaultTableModel dtm=nv.getDtmNamecard();
			dtm.removeRow(0);
			
			Object[] rowData=null;
			
			NamecardVO nvo=null;
			for(int i=0; i < list.size(); i++) {
				nvo=list.get(i);
				rowData[0]=new Integer(i+1);
				rowData[1]=new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/upload/\" + nvo.getImg()");
				rowData[2]=nvo.getName();
				rowData[3]=nvo.getAddr();
				
				dtm.addRow(rowData);
			}
		
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(nv, "�����͸� �������� �� ������ �߻��Ͽ����ϴ�.");
			e.printStackTrace();
		}
		}
		private boolean uploadImg(String filePath) throws IOException {
			boolean flag=false;
			
			FileInputStream fis=new FileInputStream(imgPath);
			FileOutputStream fos=new FileOutputStream("C:/dev/workspace/javase_prj2/src/day0111/upload/"+filePath);
			
			try {
				byte[] readData=new byte[512];
				int byteSize=0;
				
				while((byteSize=fis.read(readData))!=-1) {
					fos.write(readData,0,byteSize);
					fos.flush();
				}
			}finally {
				if(fos!=null) {fos.close();}
				if(fis!=null) {fis.close();}
			}
			
			return flag;		
		}
	}


