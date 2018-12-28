package day1211;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Has a 관계로 이벤트 처리
 * @author SIST
 */
//2. 이벤트 처리 객체를 구현
public class EventHandlingHasA implements ActionListener{
//EventHandlingHasA 는 Design을 가지고 있다.
	//2. has a 관계를 저장하고 사용할 객체를 선언
	private Design design;
	
	public EventHandlingHasA(Design design) {
		this.design=design;//this는 인스턴트 변수를
	}
	
	@Override
	
	//3. abstract method override
	public void actionPerformed(ActionEvent ae) {
		//이벤트가 발생했을 때 처리할 코드
		System.out.println("전달받은 Design객체"+design);
		design.dispose();//윈도우꺼기 때문에 어디에있는지 언급해야한다.
	}

}//class
