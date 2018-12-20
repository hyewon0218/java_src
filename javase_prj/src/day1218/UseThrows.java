package day1218;

import java.util.Random;

/**
 * method내에서 발생한 예외를 method를 호출한 곳에서 처리하는 throws의 사용
 * @author SIST
 */
public class UseThrows {

	public void test()throws ClassNotFoundException {
		//throws로 예외를 날리면 method안에서 try~catch를 할 필요가 없다.
		String className="day1217.UseRuntimeException";
		
		if(new Random().nextBoolean()) {
			className="java.lang.Integer";
		}
		
		Object obj=Class.forName(className);
		System.out.println("클래스 로딩"+obj);
	}
	
	public static void main(String[] args) {
		UseThrows ut=new UseThrows();
		try {
			ut.test();//method를 호출하여 일을 수행하다보면 문제가 발생할 수도 있다.
		} catch (ClassNotFoundException cnfe) {
			System.out.println("죄송합니다.");
			cnfe.printStackTrace();
			System.out.println("정상출력");
		}//end catch
	}//main

}//class
