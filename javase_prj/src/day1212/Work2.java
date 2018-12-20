package day1212;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;

public class Work2 extends Frame{
//라벨2 리스트2 버튼2
	private Button bnt;
	private Label lbl;
	private List list;
	
	public Work2() {
	List list=new List();
	list.add("이재찬");
	list.add("이재현");
	list.add("정택성");
	
//	List list2=new List("이재찬");
	
	Button bnt1=new Button(">>");
	Button bnt2=new Button("<<");
	
	Label lbl1 = new Label();
	lbl.setText("친구목록");
	Label lbl2 = new Label();
	lbl.setText("차단된친구");
	
	Panel panelCenter=new Panel();
	Panel panelNorth=new Panel();
	
	panelCenter.setLayout(new GridLayout(1, 2));
	
	
	}
	public static void main(String[] args) {
		new Work2();
	}

}
