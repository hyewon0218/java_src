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
		Font temp = mf.getLblPreview().getFont();// 기준데이터
		String font = temp.getFamily();
		int style = temp.getStyle();
		int size = temp.getSize();

		// 선택한 아이템을 TF에 값으로 설정한다.
		// 미리보기 라벨을 변경

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
			size = Integer.parseInt(selectedValue);// 문자열을 정수로
		}
		// 설정된 정보 중 변경된 정보만 가지고 Preview의 글꼴정보를 변경한다.
		mf.getLblPreview().setFont(new Font(font, style, size));
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == mf.getBtnYes()) {// 설정한 글꼴 정보를 적용
			setTaNoteFont();
		}
		if (ae.getSource() == mf.getBtnNo()) {// 닫힘
			mf.dispose();
		}
	}

	/**
	 * MemoFormat 클래스의 미리보기 Label에 Font 정보를 JavaMemo 클래스의 TextArea에 설정
	 */
	public void setTaNoteFont() {
		mf.getJm()/* 자바메모 */.getTaNote().setFont(mf.getLblPreview().getFont());
		try {
			fontStatusSave();//설정한 글꼴상태정보를 저장
		} catch (IOException e) {
			e.printStackTrace();
		}
		mf.dispose();
	}

	/**
	 * 설정한 폰트 상태를 파일로 저장- 다음번에 프로그램이 실행되면 현재 저장된 폰트값을 적용하여 TA를 설정하면 변경상태가 유지된다.
	 */
	private void fontStatusSave() throws IOException {
//		BufferedWriter bw = null;

		ObjectOutputStream oos=null;
		
		try {
			// 미리보기에 라벨의 설정된 폰트정보를 얻는다.
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
