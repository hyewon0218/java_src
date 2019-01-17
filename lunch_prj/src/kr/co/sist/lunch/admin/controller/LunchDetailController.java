package kr.co.sist.lunch.admin.controller;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import kr.co.sist.lunch.admin.model.LunchAdminDAO;
import kr.co.sist.lunch.admin.view.LunchDetailView;
import kr.co.sist.lunch.admin.vo.LunchUpdateVO;

public class LunchDetailController extends WindowAdapter implements ActionListener{

	private LunchDetailView ldv;
	private LunchMainController lmc;
	private LunchAdminDAO la_dao;
	private String origicalImg;
	private String uploadImg;
	
	public LunchDetailController(LunchDetailView ldv,LunchMainController lmc, String originalImg) {
		this.ldv=ldv;
		this.lmc=lmc;
		la_dao=LunchAdminDAO.getInstance();
		this.origicalImg=originalImg;
		uploadImg="";//null�κ������ʱ����� 
	}//LunchDetailController
	
	@Override
	public void windowClosing(WindowEvent e) {
		ldv.dispose();
	}//windowClosing
	
	private void removeLunch(String code) {//���ö�����
		
		try {
			if(la_dao.deleteLunch(code)) {//���ö� ����
				lmc.setLunch();//���ö� ����Ʈ�� �����Ѵ�.
				//������ ����
				File file=new File("C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/"+origicalImg);
				File rmFile=new File(file.getAbsolutePath());//ū����
				File rmFile2=new File(file.getParent()+"/s_"+file.getName());//��������

				
				rmFile.delete();
				rmFile2.delete();
				
				JOptionPane.showMessageDialog(ldv, "���ö��� �����Ǿ����ϴ�.");
			}else {
				JOptionPane.showMessageDialog(ldv, "���ö��� �������� �ʽ��ϴ�.");
			}//end else	
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(ldv, "DB���� ���� �߻�");
			e.printStackTrace();
		
		}//end catch
		
	}//removeLunch
	
	public void chgImg() {
		FileDialog fdOpen=new FileDialog(ldv, "���ö� �̹��� ����" , FileDialog.LOAD);
		fdOpen.setVisible(true);
		
		String path=fdOpen.getDirectory();
		String name=fdOpen.getFile();
		
		boolean flag=false;
		if(path!=null) {//????
			String[] extFlag= {"jpg","gif","jpeg","png","bmp"};
			for(String ext : extFlag) {
				if(name.toLowerCase().endsWith(ext)) {//���ε� ���� Ȯ����
					flag=true;
				}//end if			
			}//end for
			if(flag) {
				uploadImg=path+name;
				ldv.getJlLunchImg().setIcon(new ImageIcon(uploadImg));
			}else {
//			if(uploadImg.equals("")) {
				JOptionPane.showMessageDialog(ldv, name+"�� �̹����� �ƴմϴ�.");			
			}
		}//end if
		
	}//chgImg
	
	/**
	 * ���ö� �ڵ�, ���ö���, �̹���, ����, Ư������ �Է¹޾� �ڵ忡 �ش��ϴ� ���ö��� ������ ����.
	 * @return
	 */
	private void modifyLunch() {
		boolean flag=false;
		//��ȿ�� ���� : ���ö���, ����, Ư������ ""�� �ƴ� ��, ������ ��������,
		//�̹����� ����Ǿ��ٸ� �̹����� s_�� ���� �̹����ΰ� �����ϴ� �̹�������
		JTextField tfName=ldv.getJtfLunchName();
		JTextField tfPrice=ldv.getJtfLunchPrice();
		JTextArea taSpec=ldv.getJtaLunchSpec();
		
		if(tfName.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(ldv, "���ö����� �Է����ּ���.");
			tfName.setText("");
			tfName.requestFocus();
			return;
		}//end if
		if(tfPrice.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(ldv, "���ö� ������ �Է����ּ���.");
			tfPrice.setText("");
			tfPrice.requestFocus();
			return;
		}//end if
		if(taSpec.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(ldv, "���ö� Ư������ �Է����ּ���.");
			taSpec.setText("");
			taSpec.requestFocus();
			return;
		}//end if
		
		int price=0;
		try {
			price=Integer.parseInt(tfPrice.getText().trim());
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(ldv, "���ö� ������ ���ڸ� �Է� ����");
			return;
		}//end catch
		
		//������ �̹����� ������ �̸��� �̹����� s_�� ������ ���� ��� �̹��� �۾��� �Ǿ����� ���� ���.
		//uploadImg�� ���
		if(!uploadImg.equals("")) {//�̹��� ������ ������ ���
			File tempFile=new File(uploadImg);//ū �̹���
			File smallFile=new File(tempFile.getParent()+"/s_"+tempFile.getName());//���� �̹���?????????
			if(!smallFile.exists()) {
				JOptionPane.showMessageDialog(ldv, "�����Ͻ� ������ ���� �̹����� �������� �ʽ��ϴ�.");
				uploadImg="";//�ʱ�ȭ
			return;
			}//end if
		}//end if
		
		StringBuilder updateMsg=new  StringBuilder();
		updateMsg.append("�������� \n").append("���ö� �� : ").append(tfName.getText()).append("\n")
		.append("���� : ").append(tfPrice.getText()).append("\n").append("Ư���� : ").append(taSpec.getText())
		.append("\n").append("���� ������ ���ö��� ������ ����˴ϴ�. �����Ͻðڽ��ϱ�? ");
		
		switch (JOptionPane.showConfirmDialog(ldv, updateMsg.toString())) {
		case JOptionPane.OK_OPTION:
			//����� ������ VO�� �����ϰ� 
			File file=new File(uploadImg);
			LunchUpdateVO luvo
				=new LunchUpdateVO(ldv.getJtfLunchCode().getText(), tfName.getText().trim(), file.getName(), taSpec.getText(), price);
			try {
				if(la_dao.updateLunch(luvo)) {//DB Table���� update�� ���� 
					JOptionPane.showMessageDialog(ldv, "���ö� ������ ����Ǿ����ϴ�.");
					if(!uploadImg.equals("")) {//������ �̹����� �����ϴ� ���
						try {
							//���� �̹����� ������ ��
							File original=new File("C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/"+origicalImg);
							File small=new File(original.getParent()+"/s_"+original.getName());
							original.delete();
							small.delete();
							
							
							uploadImg(file);//������ �̹����� ������ ������ ���ε��Ѵ�.
						} catch (IOException e) {
							e.printStackTrace();
						}//end catch
					}//end if
					lmc.setLunch();//�θ�â�� ���ö� ����Ʈ�� �����Ѵ�.
					}else {
						JOptionPane.showMessageDialog(ldv, "���ö� ������ ������� �ʾҽ��ϴ�.");
					}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(ldv, "DB���� ���� �߻�");
				e.printStackTrace();
			}//end else
					
			break;
		}//end switch
		
	}//modifyLunch
	
	private void uploadImg(File file) throws IOException {
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
		//ū �̹��� ���ε�
		fis=new FileInputStream(file);
		byte[] readData=new byte[512];
		
		int len=0;
		String uploadPath="C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/";
		fos=new FileOutputStream(uploadPath+file.getName());
		
		while((len=fis.read(readData))!=-1) {//ū�̹��� �ø���
			fos.write(readData,0,len);
			fos.flush();
		}
		fis.close();
		fos.close();
		
		//���� �̹��� ���ε�
		fis=new FileInputStream(file.getParent()+"/s_"+file.getName());
		
		len=0;
		fos=new FileOutputStream(uploadPath+"s_"+file.getName());
		
		while((len=fis.read(readData))!=-1) {//ū�̹��� �ø���
			fos.write(readData,0,len);
			fos.flush();
		}
	
		}finally {
			if(fos!=null) {fos.close();}
			if(fis!=null) {fis.close();}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==ldv.getJbUpdate()) {//����
			modifyLunch();
		}
		if(ae.getSource()==ldv.getJbDelete()) {//����
			StringBuilder deleteMsg=new StringBuilder();
			deleteMsg.append(ldv.getJtfLunchName().getText()).append("(")
			.append(ldv.getJtfLunchCode().getText()).append(")��(��) �����Ͻðڽ��ϱ�?");
			
			switch(JOptionPane.showConfirmDialog(ldv, deleteMsg.toString())) {
			case JOptionPane.OK_OPTION:
//				System.out.println(ldv.getJlLunchImg().getIcon());
				removeLunch(ldv.getJtfLunchCode().getText());
			}//end swich
		}//end if(����!)
		if(ae.getSource()==ldv.getJbEnd()) {//����
			ldv.dispose();
		}//end if
		if(ae.getSource()==ldv.getJbImg()) {//�̹�������
			chgImg();
		}//end if
	}

}








