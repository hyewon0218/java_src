package day0111;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Work extends JFrame{

	private JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10;
	
	public Work () {
		
	jb1=new JButton("������");
	jb2=new JButton("�ڿ���");
	jb3=new JButton("������");
	jb4=new JButton("����ö");
	jb5=new JButton("������");
	jb6=new JButton("������");
	jb7=new JButton("������");
	jb8=new JButton("������");
	jb9=new JButton("�����");
	jb10=new JButton("������");
	
	setLayout(new GridLayout(2, 5));
	
	add(jb1);
	
	setBounds(100, 100, 200, 500);
	}
	public static void main(String[] args) {

	}

}
