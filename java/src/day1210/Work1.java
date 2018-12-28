package day1210;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Work1 extends Frame {

	public Work1() {
		super("수동배치");

		Label lbl = new Label();
		lbl.setText("글꼴");
		Label lbl1 = new Label();
		lbl1.setText("글꼴스타일");
		Label lbl2 = new Label();
		lbl2.setText("크기");
		Label lbl3 = new Label();
		lbl3.setText("보기");

		TextField tf = new TextField();
		TextField tf1 = new TextField();
		TextField tf2 = new TextField();

		TextField tf3 = new TextField("AaBbYyZz");

		List list = new List();
		list.add("Dialog");
		list.add("Serif");
		list.add("SansSerif");
		list.add("Monospaced");
		list.add("DialogInput");

		List list1 = new List();
		list1.add("일반");
		list1.add("굵게");
		list1.add("기울림꼴");
		list1.add("굴게 기울림꼴");

//		2~10까지는 2씩 증가
// 		2,4,6,8,10
//      그 뒤는 1씩 증가
//		11,12,13...80

		List list2 = new List();
		
		for (int i = 2; i < 11; i += 2) {
			list2.add(Integer.toString(i));
		}

		for (int j = 11; j < 81; j++) {
			list2.add(Integer.toString(j));
		}

//		TextField tf3=new TextField();
//		TextField tf4=new TextField();
//		TextField tf5=new TextField();
		Button btn = new Button("확인");
		Button btn1 = new Button("취소");

		setLayout(null);

		lbl.setBounds(10, 35, 80, 20);
		lbl1.setBounds(150, 35, 80, 20);
		lbl2.setBounds(300, 35, 80, 20);
		lbl3.setBounds(300, 250, 80, 20);

		tf.setBounds(10, 60, 120, 25);
		tf1.setBounds(150, 60, 120, 25);
		tf2.setBounds(300, 60, 120, 25);
		tf3.setBounds(250, 300, 100, 70);

		list.setBounds(10, 120, 120, 100);
		list1.setBounds(150, 120, 120, 100);
		list2.setBounds(300, 120, 120, 100);

		btn.setBounds(330, 400, 50, 23);
		btn1.setBounds(400, 400, 50, 23);

		add(lbl);
		add(lbl1);
		add(lbl2);
		add(lbl3);

		add(tf);
		add(tf1);
		add(tf2);
		add(tf3);

		add(list);
		add(list1);
		add(list2);

		add(btn);
		add(btn1);

		setBounds(400, 300, 600, 500);
		setResizable(false);

		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
	}

	public static void main(String[] args) {
		new Work1();
	}

}
