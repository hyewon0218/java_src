package day1210;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 일반 컴포넌트와 LayoutManager 의 사용 
 * @author SIST
 */
//1. Window Component 상속(사용자에게 보여지는 일)
@SuppressWarnings("serial")
public class UseBorderLayout extends Frame{//상속하면 부모가 먼저 생성됨(object가젤먼저)

	public UseBorderLayout() {//기본생성자
		super("BorderLayout 연습");//부모의 매개변수받는생성자 호출
		//2. 사용할 일반 컴포넌트를 생성 
		TextField tfNorth =new TextField("North");//생성자가있기때문에기본생성자만들어컴포넌트생성 한줄
		Label lblEast=new Label("East");
		TextArea taCenter=new TextArea("Center");
		Label lblWest =new Label("West");
		Choice choSouth=new Choice();
		choSouth.add("South");
		
		//3. 배치관리자 설정 : 윈도우 컴포넌트인 Frame, Dialog는
		//BorderLayout 설정
		setLayout(new BorderLayout());
		
		//4. 컴포넌트의 배치관리자를 사용하여 배치 : 
		//add("배치위치", 컴포넌트); add(상수, 컴포넌트);//overload
		//문자열 상수 사용하여 배치
		add("North",tfNorth);//" "리터럴 문자열저장소에 저장됨
		add("Center",taCenter);//center만 배치하면 테두리인 north,west,south,east자리가 사라진다. 
		//Constant (Field)를 사용하여 배치
		add(BorderLayout.WEST,lblWest);
		add(BorderLayout.EAST,lblEast);
		add(BorderLayout.SOUTH,choSouth);
		
		//5. 윈도의 크기 설정
		setSize(400, 400);
	
		//6. 사용자에게 보여주기 
		setVisible(true);
		//종료 
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		} );
	}
	
	
	public static void main(String[] args) {
		new UseBorderLayout();
	}

}
