package day1210;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Work extends Frame {
	
	public Work() {
	super("�ڵ���ġ");	
	
	

	Label lblNorth=new Label("�л�����", Label.CENTER);
	TextField tfName=new TextField();
	TextField tfAge=new TextField();
	TextField tfTel=new TextField();
	TextField tfGen=new TextField();
	
	
	Label lbl=new Label();
	lbl.setText("��");
	Label lblName=new Label("�̸�");
	Label lblAge=new Label("����");
	Label lblTel=new Label("��ȭ��ȣ");
	Label lblGen=new Label("����");
	
	TextArea taCenter =new TextArea();
	
	Button btn1 =new Button("�߰�");
	Button btn2 =new Button("����");
	Button btn3 =new Button("����");
	Button btn4 =new Button("����");
	Panel panelCenter=new Panel();
	Panel panelSouth=new Panel();
	Panel panelGen=new Panel();
	
//	setLayout(null);
//	lbl.setLocation(10,35);
//	lbl.setSize(80,20);
//	
	
//	panelCenter.add(lblCenter1);
//	panelCenter.add(lblCenter2);
//	panelCenter.add(lblCenter3);
//	panelCenter.add(lblCenter4);
	panelCenter.setLayout(new GridLayout(1,2));
	Panel pCenterLeft=new Panel();
	panelCenter.add(pCenterLeft);
	panelCenter.add(taCenter);
	
	pCenterLeft.setLayout(new GridLayout(4, 2));
	pCenterLeft.add(lblName);
	pCenterLeft.add(tfName);
	pCenterLeft.add(lblAge);
	pCenterLeft.add(tfAge);
	pCenterLeft.add(lblTel);
	pCenterLeft.add(tfTel);
	pCenterLeft.add(lblGen);
	pCenterLeft.add(panelGen);
	
	panelGen.setLayout(new GridLayout(1, 2));
	CheckboxGroup cg= new CheckboxGroup();
	Checkbox cb1 =new Checkbox("����",true , cg);
	Checkbox cb2 =new Checkbox("����",false , cg);
	panelGen.add(cb1);
	panelGen.add(cb2);
	
	
	
	
	panelSouth.add(btn1);
	panelSouth.add(btn2);
	panelSouth.add(btn3);
	panelSouth.add(btn4);
	
	
	setLayout(new BorderLayout());
	setLayout(new GridLayout(4, 1));
	
	
	add("North", lblNorth);
	add("Center", panelCenter);
//	add("Center",taCenter);
	add("South",panelSouth);
	
	setSize(500, 500);
	
	setVisible(true);
	
	addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent we) {
			dispose();
		}
	});
	}
	public static void main(String[] args) {
		new Work();
	}//main

}//class
