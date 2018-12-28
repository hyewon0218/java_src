package day1211;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionEvent를 사용한 is a 관계로 이벤트 처리 방법<br>
 * 디자인과 이벤트 처리를 하나의 클래스 안에서 처리한다.(값에 대한 사용이 편리하다.)
 * @author SIST
 */
//1. 상속으로 Frame을 처리하고 구현으로 이벤트 처리객체를 처리한다.
@SuppressWarnings("serial")
public class EventHandlingIsA extends Frame implements ActionListener{

	//2. 필드에 이벤트 처리에 관련이 있는 컴포넌트를 선언 instance변수(클래스가객체로만들어지면힙에) 선언
	private Button btn;//3. 인스턴트변수 (외부에서접근가능/디폴트는패키지안에서)
	public EventHandlingIsA () {
		super("is a 관계로 이벤트 처리하는 방법");////4.제목
		//3. 컴포넌트 생성
		btn=new Button("클릭");
		
		//4. 생성된 컴포넌트가 이벤트를발생시킬 수 있도록 이벤트에 등록시켜야 한다. addxx
		btn.addActionListener(this);//Argument로 입력된  객체(this)의 Override된 method가 호출된다.
		
		Panel panel=new  Panel();		
		panel.add(btn);
		
		//5. 생성된 컴포넌트를 배치
		add("Center", panel);
		
		//6. 윈도우 컴포넌트의 크기 설정
		setBounds(100, 100, 300, 300);
		
		//7. 사용자에게 보여주기
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {////2.추상클래스EventHandlingIsA오버라이딩
		System.out.println("버튼이 클릭되었습니다.");//추상메서드는 무조건 오버라이딩해줘야한다.
		dispose();
	}
	
	public static void main(String[] args) {
		new EventHandlingIsA();
	}//main

}//class
