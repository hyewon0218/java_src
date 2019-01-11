package day0111;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Work extends JFrame{

	private JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10;
	
	public Work () {
		
	jb1=new JButton("±Ë¡§¿±");
	jb2=new JButton("π⁄øµπŒ");
	jb3=new JButton("≥Î¡¯∞Ê");
	jb4=new JButton("±Ë»Ò√∂");
	jb5=new JButton("±Ë¡§¿±");
	jb6=new JButton("¿Ã¿Á¬˘");
	jb7=new JButton("¿Ã¿Á«ˆ");
	jb8=new JButton("∞¯º±¿«");
	jb9=new JButton("±Ë∞««œ");
	jb10=new JButton("ø¿øµ±Ÿ");
	
	setLayout(new GridLayout(2, 5));
	
	add(jb1);
	
	setBounds(100, 100, 200, 500);
	}
	public static void main(String[] args) {

	}

}
