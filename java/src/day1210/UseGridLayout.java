package day1210;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * GridLayout : 행과 열로 구성되며, 모든 컴포넌트의 크기가 동일해야할 때
 * 
 * @author SIST
 */
//1. 윈도우 컴포넌트 상속
@SuppressWarnings("serial")
public class UseGridLayout extends Frame {

	public UseGridLayout() {
		super("GridLayout 연습");
		
		//2. 컴포넌트를 생성
		Button btn1= new Button("버튼1");
		Button btn2= new Button("버튼2");
		Button btn3= new Button("버튼3");
		Button btn4= new Button("버튼4");
		Button btn5= new Button("버튼5");
		Button btn6= new Button("버튼6");
		Button btn7= new Button("버튼7");
		Button btn8= new Button("버튼8");
		Button btn9= new Button("버튼9");
		
		//3. 배치관리자 설정  : BorderLayout ->GridLayout
		setLayout(new GridLayout(3, 3));
		//4. 배치(왼->오)
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		add(btn6);
		add(btn7);
		add(btn8);
		add(btn9);
		
		//5. 윈도우 크기 설정
		setSize(300, 400);
		
		//6. 사용자에게 보여주기
		setVisible(true);
		
		//종료처리
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
				
			}
		});
	}

	public static void main(String[] args) {
		new UseGridLayout();
	}// main

}// class
