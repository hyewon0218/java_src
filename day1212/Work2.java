package day1212;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;

public class Work2 extends Frame{
//��2 ����Ʈ2 ��ư2
	private Button bnt;
	private Label lbl;
	private List list;
	
	public Work2() {
	List list=new List();
	list.add("������");
	list.add("������");
	list.add("���ü�");
	
//	List list2=new List("������");
	
	Button bnt1=new Button(">>");
	Button bnt2=new Button("<<");
	
	Label lbl1 = new Label();
	lbl.setText("ģ�����");
	Label lbl2 = new Label();
	lbl.setText("���ܵ�ģ��");
	
	Panel panelCenter=new Panel();
	Panel panelNorth=new Panel();
	
	panelCenter.setLayout(new GridLayout(1, 2));
	
	
	}
	public static void main(String[] args) {
		new Work2();
	}

}
