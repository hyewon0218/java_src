package day1212;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Work4Evt extends WindowAdapter implements ActionListener, ItemListener, TextListener {

	private Work4 w;
	private String name, age, addr;

	public Work4Evt(Work4 w) {
		this.w = w;
	}

	@Override
	public void windowClosing(WindowEvent e) {
		w.dispose();
	}

	@Override
	public void textValueChanged(TextEvent e) {
		if (e.getSource() == w.getTfName()) {
			name = w.getTfName().getText();
		}
		if (e.getSource() == w.getTfAge()) {
			age = w.getTfAge().getText();
		}
		if (e.getSource() == w.getTfAdd()) {
			addr = w.getTfAdd().getText();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		String temp = w.getList().getSelectedItem();
		String[] arry = temp.split("/");
		w.getTfName().setText(arry[0]);
		w.getTfAge().setText(arry[1]);
		w.getTfAdd().setText(arry[2]);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == w.getBtn1()) {
//			if (!(name.isEmpty() || age.isEmpty() || addr.isEmpty())) {
				StringBuilder item = new StringBuilder();
				item.append(name).append("/").append(age).append("/").append(addr);
				w.getList().add(item.toString());
				// 초기화
				w.getTfName().setText("");
				w.getTfAge().setText("");
				w.getTfAdd().setText("");

			}
//		}
		if (e.getSource() == w.getBtn2()) {

			// 예외처리
			if (w.getList().getSelectedItem() != null) {
				int idx = w.getList().getSelectedIndex();
				w.getList().remove(idx);
			}
		}
		if (e.getSource() == w.getBtn3()) {
			if (w.getList().getSelectedItem() != null) {

				int idx1 = w.getList().getSelectedIndex();
				// 삭제먼저
				w.getList().remove(idx1);
				// 그다음 삽입
				StringBuilder item1 = new StringBuilder();
				item1.append(name).append("/").append(age).append("/").append(addr);
				w.getList().add(item1.toString(), idx1);
				w.getTfName().setText("");
				w.getTfAge().setText("");
				w.getTfAdd().setText("");
			}
		}
		if (e.getSource() == w.getBtn4()) {
			w.dispose();
		}
	}

}
