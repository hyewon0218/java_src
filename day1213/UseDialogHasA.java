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
 * Frame Ŭ�������� DialogŬ������ has a�� ���
 * 
 * @author SIST
 */
@SuppressWarnings("serial")
public class UseDialogHasA extends Frame implements ActionListener {

	private Button btn1, /* Frame�� ��ġ */btn2/* Dialog */;
	private Dialog d; //actionPerformed�� btn2����ϱ����� �ν��Ͻ������� �ø�

	public UseDialogHasA() {
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
		if(ae.getSource()==btn2) {
			d.dispose();
		}
	}

	public void createDialog() {
		// 1. ����
		d = new Dialog(this, "���̾�α�", false/*��modal �θ�âŬ��!*/);//Dialog �ν��Ͻ������ο÷��� /true-modal,false-��modal
		// 2. Dialog�� ��ġ�� ������Ʈ�� ����
		Label lbl = new Label("������ ������ ������Դϴ�.(^.~)");
		btn2 = new Button("�ݱ�");

		d.add("Center", lbl);
		d.add("South", btn2);

		btn2.addActionListener(this);

		// 2. ũ�� ����
		d.setBounds(200, 200, 300, 300);

		// ���̾�α״� ���������� ����
		d.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				d.dispose();
			}
		});
		// ����ȭ
		d.setVisible(true);

	}

	public static void main(String[] args) {
		new UseDialogHasA();
	}

}
