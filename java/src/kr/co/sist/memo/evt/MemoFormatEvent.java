package kr.co.sist.memo.evt;

import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import kr.co.sist.memo.view.MemoFormat;

public class MemoFormatEvent extends WindowAdapter implements ActionListener, ItemListener {

	private MemoFormat mf;

	public MemoFormatEvent(MemoFormat mf) {
		this.mf = mf;
	}

	@Override
	public void windowClosing(WindowEvent e) {
		mf.dispose();
	}

	@Override
	public void itemStateChanged(ItemEvent ie) {
		String selectedValue = ((List) ie.getSource()).getSelectedItem();
		Font temp = mf.getLblPreview().getFont();// ���ص�����
		String font = temp.getFamily();
		int style = temp.getStyle();
		int size = temp.getSize();

		// ������ �������� TF�� ������ �����Ѵ�.
		// �̸����� ���� ����

		if (ie.getSource() == mf.getListFont()) {
			mf.getTfFontText().setText(selectedValue);
			font = selectedValue;
		}
		if (ie.getSource() == mf.getListStyle()) {
			mf.getTfStyleText().setText(selectedValue);
			style = ((List) ie.getSource()).getSelectedIndex();
		}
		if (ie.getSource() == mf.getListSize()) {
			mf.getTfSizeText().setText(selectedValue);
			size = Integer.parseInt(selectedValue);// ���ڿ��� ������
		}
		// ������ ���� �� ����� ������ ������ Preview�� �۲������� �����Ѵ�.
		mf.getLblPreview().setFont(new Font(font, style, size));
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == mf.getBtnYes()) {// ������ �۲� ������ ����
			setTaNoteFont();
		}
		if (ae.getSource() == mf.getBtnNo()) {// ����
			mf.dispose();
		}
	}

	/**
	 * MemoFormat Ŭ������ �̸����� Label�� Font ������ JavaMemo Ŭ������ TextArea�� ����
	 */
	public void setTaNoteFont() {
		mf.getJm()/* �ڹٸ޸� */.getTaNote().setFont(mf.getLblPreview().getFont());
		try {
			fontStatusSave();//������ �۲û��������� ����
		} catch (IOException e) {
			e.printStackTrace();
		}
		mf.dispose();
	}

	/**
	 * ������ ��Ʈ ���¸� ���Ϸ� ����- �������� ���α׷��� ����Ǹ� ���� ����� ��Ʈ���� �����Ͽ� TA�� �����ϸ� ������°� �����ȴ�.
	 */
	private void fontStatusSave() throws IOException {
//		BufferedWriter bw = null;

		ObjectOutputStream oos=null;
		
		try {
			// �̸����⿡ ���� ������ ��Ʈ������ ��´�.
			Font fontTemp = mf.getLblPreview().getFont();
			oos=new ObjectOutputStream(new FileOutputStream("c:/dev/temp/memo.dat"));
			oos.writeObject(fontTemp);
			oos.flush();
//			StringBuilder fontData = new StringBuilder();
//			fontData.append(fontTemp.getFamily()).append(",").append(fontTemp.getStyle()).append(",")
//					.append(fontTemp.getSize());

//			bw=new BufferedWriter(new FileWriter("c:/dev/temp/memo.dat"));
//			bw.write(fontData.toString());
//			bw.flush();
			
		} finally {
//			if (bw != null) {bw.close();}//end if
			if(oos!=null) {oos.close();}
		}
	}
}
