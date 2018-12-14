package day1214;

import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Icon Class�� ����� �̹��� ���.
 * @author SIST
 */
@SuppressWarnings("serial")
public class UseImageIcon extends JFrame {

	public UseImageIcon() {
		super("ImageIcon ���");
		 ImageIcon ii1=new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/Images/img1.jpg");
		 ImageIcon ii2=new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/Images/img2.jpg");
		 ImageIcon ii3=new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/Images/img3.jpg");
		 
		 JButton btn1=new JButton("��ư1", ii1);
		 JButton btn2=new JButton("��ư1", ii2);
		 JButton btn3=new JButton("��ư1", ii3);
		 
		 //Tooltip Text ����
		 btn1.setToolTipText("��ư1");
		 btn2.setToolTipText("��ư�� Ŭ���ϼ���.");
		 btn3.setToolTipText("������ �ݿ����Դϴ�.");
		 
		 //RollOver Icon
		 btn3.setRolloverIcon(ii2);
		 
		 //��ư ����ġ����
		 //������ġ ���� : LEFT,CENTER,RIGHT
		 btn1.setHorizontalTextPosition(JButton.RIGHT);
		 //������ġ�� ���� : TOP, MIDDLE, BOTTOM
		 btn2.setVerticalTextPosition(JButton.BOTTOM);
		 btn2.setHorizontalTextPosition(JButton.CENTER);
		 
		 setLayout(new GridLayout(1, 3));
		 
		 add(btn1);
		 add(btn2);
		 add(btn3);
		 
		 setBounds(100, 100, 1500, 600);
		 setVisible(true);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new UseImageIcon();
	}//main

}//class
