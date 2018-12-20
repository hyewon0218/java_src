package kr.co.sist.memo.evt;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.memo.view.Help;
import kr.co.sist.memo.view.JavaMemo;
import kr.co.sist.memo.view.MemoFormat;

public class JavaMemoEvt extends WindowAdapter implements ActionListener {
	
	private JavaMemo jm;
	
	public JavaMemoEvt(JavaMemo jm) {
		this.jm=jm;
	}
	
	@Override
	public void windowClosing(WindowEvent we) {
		jm.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		//miNew, miOpen, miSave, miNewSave
		//miEnd, miFormat, miHelp
		//���� �޴������ۿ��� �̺�Ʈ�� �߻����� �� 
		if(ae.getSource()==jm.getMiNew()) {
			newMemo();
		}
		//���� �޴������ۿ��� �̺�Ʈ�� �߻����� ��
		if(ae.getSource()==jm.getMiOpen()) {
			openMemo();
		}
		//���� �޴� �����ۿ��� �̺�Ʈ�� �߻����� ��
		if(ae.getSource()==jm.getMiSave()) {
			saveMemo();
		}
		//�ٸ��̸����� ���� �޴� �����ۿ��� �̺�Ʈ�� �߻����� ��
		if(ae.getSource()==jm.getMiNewSave()) {
			newSaveMemo();
		}
		//���� �޴� �����ۿ��� �̺�Ʈ�� �߻����� ��
		if(ae.getSource()==jm.getMiEnd()) {
			jm.dispose();
		}
		//���� �޴������ۿ��� �����ۿ��� �̺�Ʈ�� �߻����� ��
		if(ae.getSource()==jm.getMiFormat()) {
			formatDialog();
		}
		//���� �޴������ۿ��� �����ۿ��� �̺�Ʈ�� �߻����� ��
		if(ae.getSource()==jm.getMiHelp()) {
			helpDialog();
		}
		
		
	}//actionPerformed
	/**
	 * ���� : TextArea �ʱ�ȭ�Ѵ�.
	 */
	public void newMemo() {
		jm.getTaNote().getText();//�����´�����
		jm.getTaNote().setText("");//�ʱ�ȭ
		
		
		jm.setTitle("�޸��� - ����");
	}

	/**
	 * txt���� ���� 
	 */
	public void openMemo() {
		FileDialog fdOpen=new FileDialog(jm, "��������", FileDialog.LOAD);
		fdOpen.setVisible(true);
		
		String filePath= fdOpen.getDirectory();
		String fileName=fdOpen.getFile();
		
		if(filePath !=null) {//������ ������ ����
			//������ ��ο� �̸��� Frame�� TitleBar�� ����
			jm.setTitle("�޸��� - ���� "+filePath+fileName);
		}
	}
	/**
	 * �ۼ��� �޸� ���� - ������ ���ϸ��� �״�� �����ϴ� ���ϸ� �ݿ�
	 */
	public void saveMemo() {
		newSaveMemo();
	}
	/**
	 * ���ϸ��� �Է¹޾� ���̸����� ����
	 */
	public void newSaveMemo() {
		FileDialog fdSave=new FileDialog(jm, "��������", FileDialog.SAVE);
		fdSave.setVisible(true);
		
		String filePath= fdSave.getDirectory();
		String fileName=fdSave.getFile();
		
		if(filePath !=null) {//������ ������ ����
			//������ ��ο� �̸��� Frame�� TitleBar�� ����
			jm.setTitle("�޸���- ���� "+filePath+fileName);
		}
	}
	
	/**
	 * �۲��� �����ϴ� ���̾�α׸� �����ϴ� ��
	 */
	public void formatDialog() {
		new MemoFormat(jm);
	}
	
	/**
	 * �޸��� ������ �����ϴ� ���̾�α׸� ����
	 */
	public void helpDialog() {
		new Help(jm);
	}
	
	
	
}//class
