package day1213;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import day1129.Won;

/**
 * Swing 을 사용한 Window Application 
 * @author SIST
 */
//1. JFrame 상속
@SuppressWarnings("serial")
public class HelloSwing extends JFrame implements ActionListener{

	public HelloSwing() {
		super("스윙연습");
		//컴포넌트 생성
		JButton jb=new JButton("안녕! 난 스윙이라고 해");
		Button btn =new Button("AWT버튼");
		//배치관리자 전환
		setLayout(new GridLayout(1, 2));
		//배치
		add(jb);
		add(btn);
		jb.addActionListener(this);
		//크기설정
		setBounds(100, 100, 300, 200);
		//가시화
		setVisible(true);
		//윈도우 종료 처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
	  	dispose();
	}
	
	public static void main(String[] args) {
		new HelloSwing();
	}//main

}//class
