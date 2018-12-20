package day1211;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Work extends Frame implements ItemListener {
	public Label lbl;
	public TextField tf;
	public Choice choCenter;

	public Work() {

		Label lbl = new Label("Label ");
		tf = new TextField("������ ȭ����");
		choCenter = new Choice();
//		choCenter.add("������");
//		choCenter.add("������");
//		choCenter.add("�Ķ���");
//		choCenter.add("������");
//		choCenter.add("���");
//		choCenter.add("��ȫ��");

		//string�迭����� for������ 
		String color = "������,�Ķ���,������,���,��ȫ��";
		String[] arr=color.split(",");
		for(int i=0; i<arr.length; i++) {
			choCenter.add(arr[i]);
		}
//		for(String )
		
		
		
		
		Panel panelCenter = new Panel();

		panelCenter.setLayout(new GridLayout(1, 2));
		Panel pCenterLeft = new Panel();
		panelCenter.add(pCenterLeft);
		panelCenter.add(choCenter);///

		pCenterLeft.setLayout(new GridLayout(2, 1));
		pCenterLeft.add(lbl);
		pCenterLeft.add(tf);

		add("Center", panelCenter);

		// �̺�Ʈ ���
		choCenter.addItemListener(this);

		setBounds(200, 200, 500, 300);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

	}

	public static void main(String[] args) {
		new Work();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// ������ :
		String flag = choCenter.getSelectedItem();
		Color color = null;
		switch(flag) {
		case "�Ķ���":
			color=Color.blue;
			break;
		case "������":
			color=Color.red;
			break;
		case "���":
			color=Color.green;
			break;
		case "��ȫ��":
			color=Color.magenta;
			break;
			
		default :
			color=Color.black;
			
		}
		
		
		tf.setForeground(color);
	}

}
