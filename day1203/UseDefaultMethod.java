package day1203;

public class UseDefaultMethod implements UseDefault {

	@Override
	public void test() {
		System.out.println("Override한 method");
	}

	public static void main(String[] args) {
		//자식 클래스 객체화 
		UseDefaultMethod udm=new UseDefaultMethod();
		udm.test();
		udm.temp();//default method
		
		//is a 관계의 객체화 //자식methodxx
		UseDefault ud= new UseDefaultMethod();
		ud.test();//Override한 method호출
		ud.temp();//default method
	}

}
