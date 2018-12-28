package day1122;

/**
 *	method의 4가지 형태
 * @author SIST
 */
public class MethodType {

	/**
	 * 반환형 없고 매개변수 없는 형- 고정 일
	 */
	public void typeA() {
		System.out.println("안녕하세요?");
	}//typeA
	
	/**
	 * 반환형 없고 매개변수 있는 형 - 가변 일
	 * @param i 출력하고 싶은 값
	 */
	public void typeB(int i) {
		System.out.println(i+"번 안녕");
	}//typeB
	
	/**
	 * 반환형 있고 매개변수 없는 형 - 고정 값<br>
	 * 값을 받아 사용하는 코드가 필요
	 * @return 년.월을 실수형으로 반환
	 */
	public double typeC() {
//		int i=11;
		return 2018.11;
//		System.out.println("III"); return 구문 아래에 코드가 정의될 수 없다.
	}//typeC
	
	/**
	 * 반환형 있고 매개변수 있는 형 - 가변 값
	 * @param d 정수로 만들고 싶은 실수값 	
	 * @return	정수로 변환된 값  	
	 */
	public int typeD(double d) {
		
		int i=(int)d;
		
		return i;
		//return (int)d;
	}//typeD
	
	public static void main(String[] args) {
		
		MethodType mt = new MethodType();
		//1. 고정 일 method 호출
		 	mt.typeA();
		 //2. 가변 일 method 호출
		 	mt.typeB(22);
		 //3. 고정 값 method 호출-반환형과 일치하는 변수를 만들어서 값을 저장
		 	double i= mt.typeC()+1;
		 	System.out.println("고정값"+i);
		 //4. 가변 값 method 호출- 반환형과 일치하는 변수를 만들어서 값을 저장	
		 	int j=mt.typeD(300.003);
		 	System.out.println("가변값"+j);
	}//main

}//class
