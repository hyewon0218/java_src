package day1203;

/**
 * 추상클래스를 부모로 하는 자식클래스
 * 자식클래스는 반드시 부모클래스의 추상 method를 반드시 Override 해야한다.
 * @author SIST
 */
public class AbstractSub extends AbstractSuper{
	
	public void subMethod() {
		System.out.println("자식 method!!!!!");
	}
	
	@Override
	//Override 규칙 : 접근지정자는 달라도 되고(광의의) 반환형, method 명
	//매개변수는 같아야 한다.
	public  void absMethod() {
		//추상method는 super로 호출할 수 없다. 
//		super.absMethod(); Error
		System.out.println("Override한 자식의 absMethod");
	}
	@Override
	public  String absMethod1(int param_i) {
		return String.valueOf(param_i).concat("- 자식");//valueof:문자열로 바뀜!
	}
	
	
	public static void main(String[] args) {
		//자식클래스가 객체화되면 추상클래스는 객체화가 된다.
		AbstractSub as =new AbstractSub();//부모의 생성자 출력
		//자식클래스로 객체화 : 부모의 변수, method, 자식의 변수, method
		as.i=12;//부모의 변수
		as.method();//부모 method
		
		//Override된 method 자식에서 구현한 것이므로 자식의 method호출
		as.absMethod();//같은 이름으로 존재한다면 자식의 method
		System.out.println(as.absMethod1(3));//자식의 method
		as.subMethod();
		
		//is a 관계의 객체화 : 객체 다형성 
		//부모클래스명 객체명=new 자식의생성자();
		AbstractSuper as1=new AbstractSub();//같은 이름의 method 다양하게
		//부모의 자원호출 가능/자식에대한x
		as1.i=100;
		as1.method();
		//Override된 method가 존재한다면 자식의 method 호출할 수 있다.
		//추상 method는 body가 없지만 호출하게 되면 자식의 method가 호출된다.
		as1.absMethod();
		System.out.println(as1.absMethod1(2018));
		
		//is a 관계로 객체화하면 자식이 가진 method는 호출 불가(Overriding한것만호출가능!)
//		as1.subMethod();
	}//main

}
