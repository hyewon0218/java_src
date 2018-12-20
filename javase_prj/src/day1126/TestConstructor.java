package day1126;

/**
 *클래스가 객체로 생성될 대 기본적으로 가지고 있어야할 기본값을 설정하거나, 기본적으로 수행될 코드를 정의하는 method일종(객체 초기화값)
 * @author SIST
 */
public class TestConstructor {

	/**
	 * 기본 생성자 : 클래스를 작성할 때 생성자를 하나도 정의하지 않으면 
	 * 컴파일러가 매개변수 없는 Default Constructer를 생성한다. 
	 */
	public TestConstructor() {
		System.out.println("기본 생성자");
//		TestConstructer(300); // 생성자는 method 호출하듯 호출할 수 없다. 객체화를 통해서만 부를 수 있다.
	}//TestConstructer
	
	/**
	 * 외부에 입력값을 가지고 생성하는 인자있는 생성자의 Overload
	 * @param i 임의의 값
	 */
	public TestConstructor(int i) {
		System.out.println("인자 있는 생성자:"+i);//하나라도 정의하면 기본생성자 만들지 않음
	}//TestConstructer
	public void test() {
		System.out.println("test method!!!");
		temp();// method 호출
		
	}//test
		public void temp() {
			System.out.println("-------------temp method!!!");
	}//temp (instance method 고정적(반환형,매개x))
	
	public static void main(String[] args) {
		//Overloading 된 생성자를 사용하여 객체화를 다양하게 할 수 있음(다형성)
		TestConstructor tc = new TestConstructor();//기본 생성자(class로부터 만들어진객체(값) tc에 저장)
		TestConstructor tc1 = new TestConstructor(26);//인자있는 생성자

		System.out.println(tc);//heap에 만들어진 주소
		System.out.println(tc1);
		
		tc.test();//test
//		안에 temp까지 
	}//main

}//class
