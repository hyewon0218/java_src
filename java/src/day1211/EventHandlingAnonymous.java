package day1211;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * anonymous inner class로 이벤트 처리
 * 
 * @author SIST
 */
//1. 윈도우 컴포넌트 상속
@SuppressWarnings("serial")
public class EventHandlingAnonymous extends Frame {
	// 2. 이벤트 처리에 사용할 Component 선언
	private Button btn;// 경고나와서 get만들어줌

	public EventHandlingAnonymous() {
		super();
		// 3. 컴포넌트 생성
		btn = new Button("클릭");
		// 4. 배치
		Panel panel = new Panel();
		panel.add(btn);

		add("Center", panel);
		// 5. 이벤트 등록 : anonymous innerclass로 등록
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼 클릭!");
				dispose();
			}
		});

		// 6. 윈도우 크기 설정
		setBounds(200, 100, 400, 200);

		// 7. 사용자에게 보여주기
		setVisible(true);

	}

	public Button getBtn() {
		return btn;
	}

	public static void main(String[] args) {
		new EventHandlingAnonymous();
	}// main

}// class
