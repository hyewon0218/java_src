package day1211;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * XxxAdapter class가 사용되어야 하는 이유 
 * @author SIST
 */
@SuppressWarnings("serial")
public class UseWindowEvent extends Frame {//추상메소드 오버라이딩(구현의강제성)

	public UseWindowEvent() {
		super("윈도우 이벤트 연습");
		
		setBounds(100, 100, 400, 400);
		setVisible(true);
		UseWindowEvent.WindowImpl wi=this.new WindowImpl();
		addWindowListener(wi);//윈도우이벤트 내클래스안에서처리
	}
	
	public static void main(String[] args) {
		new UseWindowEvent();
	}
	//windowListner interface를 구현한 class는 사용하지 않는 method일지라도
	//모두 Override 해야한다. 
	public class WindowImpl implements WindowListener{
		
	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing");
		dispose();
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		//closing에서 dispose()가 호출되면 그때 windowClosed가 호출
		System.out.println("windowClosed");
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("windowIconified");
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("windowDeiconified");
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("windowActivated");
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("windowDeactivated");
		
	}
	}//innerclass 종료
}
