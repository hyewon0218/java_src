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
		tf = new TextField("오늘은 화요일");
		choCenter = new Choice();
//		choCenter.add("색선택");
//		choCenter.add("검은색");
//		choCenter.add("파란색");
//		choCenter.add("빨간색");
//		choCenter.add("녹색");
//		choCenter.add("심홍색");

		//string배열만들고 for문으로 
		String color = "검은색,파란색,빨간색,녹색,심홍색";
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

		// 이벤트 등록
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
		// 색설정 :
		String flag = choCenter.getSelectedItem();
		Color color = null;
		switch(flag) {
		case "파란색":
			color=Color.blue;
			break;
		case "빨간색":
			color=Color.red;
			break;
		case "녹색":
			color=Color.green;
			break;
		case "심홍색":
			color=Color.magenta;
			break;
			
		default :
			color=Color.black;
			
		}
		
		
		tf.setForeground(color);
	}

}
