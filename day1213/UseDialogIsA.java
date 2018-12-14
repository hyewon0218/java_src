package day1213;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Frame Ŭ�������� is a�� ������ DialogŬ������ ���
 * 
 * @author SIST
 */
@SuppressWarnings("serial")
public class UseDialogIsA extends Frame implements ActionListener {

	private Button btn1;

	public UseDialogIsA() {
		super("���̾�α��� ���");

		btn1 = new Button("���̾�α� ���");
		Panel panel = new Panel();
		panel.add(btn1);

		add("Center", panel);

		btn1.addActionListener(this);

		setBounds(100, 100, 300, 400);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==btn1) {
			createDialog();
		}
	}

	public void createDialog() {
		new DialogIsA(this);//UseDialogIsA�� this�� DialogIsA �� has a ���� super�� ����

	}

	public static void main(String[] args) {
		new UseDialogIsA();
	}

}
