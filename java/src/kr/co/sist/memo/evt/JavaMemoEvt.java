package kr.co.sist.memo.evt;

import java.awt.FileDialog;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import kr.co.sist.memo.view.Help;
import kr.co.sist.memo.view.JavaMemo;
import kr.co.sist.memo.view.MemoFormat;

public class JavaMemoEvt extends WindowAdapter implements ActionListener {

	private JavaMemo jm;
	private String taNoteData;// T.A�� ������ ������ ����
	private String openPath;// ������ ���ϸ��� �����ϴ� ����

	public JavaMemoEvt(JavaMemo jm) {
		this.jm = jm;
		taNoteData = "";// �Ѱ����� ó�����ֱ� ���ؼ�
		openPath = "";
	}

	@Override
	public void windowClosing(WindowEvent we) {
		closeMemo();

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// miNew, miOpen, miSave, miNewSave
		// miEnd, miFormat, miHelp
		// ���� �޴������ۿ��� �̺�Ʈ�� �߻����� ��
		if (ae.getSource() == jm.getMiNew()) {
			newMemo();
		}
		// ���� �޴������ۿ��� �̺�Ʈ�� �߻����� ��
		if (ae.getSource() == jm.getMiOpen()) {
			try {
				openMemo();
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(jm, "������ ������ ���� �� �����ϴ�.", "���Ͽ��� ����", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(jm, "������ ������ �о���̴� �� ������ �߻��Ͽ���.", "���Ͽ��� ����", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
		// ���� �޴� �����ۿ��� �̺�Ʈ�� �߻����� ��
		if (ae.getSource() == jm.getMiSave()) {
			saveMemo();
		}
		// �ٸ��̸����� ���� �޴� �����ۿ��� �̺�Ʈ�� �߻����� ��
		if (ae.getSource() == jm.getMiNewSave()) {
			newSaveMemo();
		}
		// ���� �޴� �����ۿ��� �̺�Ʈ�� �߻����� ��
		if (ae.getSource() == jm.getMiEnd()) {
			// ������� ���� ������ �ִٸ� �����ϰ� ���� / ���ѰԾ����� �׳�����
			closeMemo();

		}
		// ���� �޴������ۿ��� �����ۿ��� �̺�Ʈ�� �߻����� ��
		if (ae.getSource() == jm.getMiFormat()) {
			formatDialog();
		}
		// ���� �޴������ۿ��� �����ۿ��� �̺�Ʈ�� �߻����� ��
		if (ae.getSource() == jm.getMiHelp()) {
			helpDialog();
		}

	}// actionPerformed

	/**
	 * �����ϱ�
	 */
	public void closeMemo() {
		TextArea tempTa = jm.getTaNote();
		boolean flagClose = false;
		// ������ ������ �Ǵ�
		if (!taNoteData.equals(tempTa.getText())) {// ������ �������ʿ���� !:�ٸ��ٸ�����

			int flag = JOptionPane.showConfirmDialog(jm, "�����Ͻðڽ��ϱ�?");
			switch (flag) {
			case JOptionPane.OK_OPTION:
				saveMemo();
			case JOptionPane.NO_OPTION:
				break;
			default:
				flagClose = true;
			}
			
		}
		if(!flagClose) {//true�϶��� �����
			jm.dispose();
		}
	}

	/**
	 * ���� : TextArea �ʱ�ȭ�Ѵ�.
	 */
	public void newMemo() {

		TextArea tempTa = jm.getTaNote();
		boolean flagNew = false;
		// ������ ������ �Ǵ�
		if (!taNoteData.equals(tempTa.getText())) {// ������ �������ʿ���� !:�ٸ��ٸ�����
			int flag = JOptionPane.showConfirmDialog(jm, "�ٸ� �̸����� �����Ͻðڽ��ϱ�?");
			switch (flag) {
			case JOptionPane.OK_OPTION:
				newSaveMemo();
			case JOptionPane.NO_OPTION:
				flagNew = false;
				break;
			default:
				flagNew = true;
			}
		}

		// ��Ұ������������Ǹ�ȵ�
		if (!flagNew) {
			tempTa.getText();// �����´�����
			tempTa.setText("");// �ʱ�ȭ/bug

			// ������ �� ���Ŀ��� �б��� ������ �ʱ�ȭ
			taNoteData = tempTa.getText();// taNoteData="";
			openPath = "";// �о���� ������ ��θ� �ʱ�ȭ
			jm.setTitle("�޸��� - ����");
		}
	}

	/**
	 * txt���� ����
	 */
	public void openMemo() throws FileNotFoundException, IOException {
		// ta�� ����� �о�鿴�� ������ �ٸ��ٸ� ���忩�θ� ����
		// �۾��� �����Ѵ�.
		TextArea tempTa = jm.getTaNote();// ��������
		boolean flagOpen = false;
		if (!taNoteData.equals(tempTa.getText())) {
			int flag = JOptionPane.showConfirmDialog(jm, openPath + "\n �����Ͻðڽ��ϱ�?");
			switch (flag) {
			case JOptionPane.OK_OPTION:
				if (!openPath.equals("")) {// ������ �ѹ��̶� ������
					// ������ �̸��� ������ ������
					saveMemo();
				} else {
					// �ٸ��̸����� ����
					newSaveMemo();
				} // end else
			case JOptionPane.NO_OPTION:
				flagOpen = false;
				break;
			default:
				flagOpen = true;
			}// end if
		} // end if

		if (!flagOpen) {// !����
			FileDialog fdOpen = new FileDialog(jm, "��������", FileDialog.LOAD);
			fdOpen.setVisible(true);

			String filePath = fdOpen.getDirectory();
			String fileName = fdOpen.getFile();

			if (filePath != null) {// ������ ������ ����
				////////////////////////// 12-20-2018 ��Ʈ������ ������ ������ �д� �ڵ� �߰�
				////////////////////////// ����/////////////////////////

				// ������ ���Ϸ� ���� ��ü ����.
				File file = new File(filePath + fileName);
				// 16bit stream���
				BufferedReader br = null;

				try {

					br = new BufferedReader(new FileReader(file));
					String temp = "";
					// TextA �ʱ�ȭ�� ��
					tempTa.setText("");

					while ((temp = br.readLine()) != null) {
						// ���Ͽ��� �о���� ������ �����Ѵ�.
						tempTa.append(temp + "\n");
					}
					// ������ �о���� ������ ����
					taNoteData = tempTa.getText();
					// ������ ���ϸ��� ����
					openPath = file.getAbsolutePath();
				} finally {
					if (br != null) {
						br.close();
					} // end if/nullpointerException����
				} // end finally

				////////////////////////// 12-20-2018 ��Ʈ������ ������ ������ �д� �ڵ� �߰�
				////////////////////////// ��/////////////////////////
				// ������ ��ο� �̸��� Frame�� TitleBar�� ����
				jm.setTitle("�޸��� - ���� " + filePath + fileName);
			}
		}
	}

	/**
	 * �ۼ��� �޸� ���� - ������ ���ϸ��� �״�� �����ϴ� ���ϸ� �ݿ�
	 */
	public void saveMemo() {
		// ������ ������ �̸��� ���Ͽ� ���� ���� ��
		try {
			if (!openPath.equals("")) {
				createFile(openPath);
			} else {
				newSaveMemo();
			} // end else
		} catch (IOException e) {
			e.printStackTrace();
		}
//		newSaveMemo();//
	}

	private void createFile(String pathName) throws IOException {
		BufferedWriter bw = null;

		try {
			// ����ڰ� ���丮���� ������� ������ �� ���� ������
			// File Ŭ������ ����� �ʿ䰡 ����.
			bw = new BufferedWriter(new FileWriter(pathName));
			bw.write(jm.getTaNote().getText());// TA�� ������ ��Ʈ���� ���
			bw.flush();// ��Ʈ���� ��ϵ� ������ �������� ����

			openPath = pathName;
			taNoteData = jm.getTaNote().getText();
		} finally {
			if (bw != null) {
				bw.close();
			} // ��ü����������ִٸ� �����
		} // end finally
	}

	/**
	 * ���ϸ��� �Է¹޾� ���̸����� ����
	 */
	public void newSaveMemo() {
		FileDialog fdSave = new FileDialog(jm, "��������", FileDialog.SAVE);
		fdSave.setVisible(true);

		String filePath = fdSave.getDirectory();
		String fileName = fdSave.getFile();

		if (filePath != null) {// �����ư�� ������ �� ����
			try {
				createFile(filePath + fileName);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(jm, "���� �� ���� �߻�", "�����߻�", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			// ������ ��ο� �̸��� Frame�� TitleBar�� ����
			jm.setTitle("�޸���- ���� " + filePath + fileName);
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

}// class
