package day1212;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StdInfoEvt extends WindowAdapter implements ActionListener, ItemListener {
	private StdInfo si;

	public StdInfoEvt(StdInfo si) {
		this.si = si;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		ckList();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == si.getBtnAdd()) {
			ckAdd();
		}
		if (e.getSource() == si.getBtnDel()) {
			ckDel();
		}
		if (e.getSource() == si.getBtnUpdate()) {
			ckUpdate();
		}
		if (e.getSource() == si.getBtnExit()) {
			ckExit();
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		si.dispose();
	}

	private void ckAdd() {
		String input = "";
		input = si.getTfName().getText() + "/" + si.getTfAge().getText() + "/" + si.getTfAddr().getText();
		if (!si.getTfName().getText().equals("") && !si.getTfAge().getText().equals("") && !si.getTfAddr().getText().equals("")) {
			si.getListData().add(input);
		}
		si.getTfName().setText("");
		si.getTfAge().setText("");
		si.getTfAddr().setText("");
	}

	private void ckUpdate() {
		int idx = -1;
		String input = "";
		idx = si.getListData().getSelectedIndex();

		if (idx != -1) {
			input = si.getTfName().getText() + "/" + si.getTfAge().getText() + "/" + si.getTfAddr().getText();
			si.getListData().add(input, idx);
			si.getListData().remove(idx + 1);
		}
	}

	private void ckDel() {
		int idx = -1;
		String input = "";
		idx = si.getListData().getSelectedIndex();

		if (idx != -1) {
			input = si.getTfName().getText() + "/" + si.getTfAge().getText() + "/" + si.getTfAddr().getText();
			if (si.getListData().getItem(idx).equals(input)) {
				si.getListData().remove(idx);
			}
		}
	}

	private void ckExit() {
		si.dispose();
	}

	private void ckList() {
		List tempList = si.getListData();
		String data[] = tempList.getSelectedItem().split("/");
		si.getTfName().setText(data[0]);
		si.getTfAge().setText(data[1]);
		si.getTfAddr().setText(data[2]);

	}

}
