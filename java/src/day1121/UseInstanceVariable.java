package day1121;

/**
 * Instance(member) 변수<br>
 * 객체가 생성될 때 메모리(heap)에 할당되고, 그 주소를 저장한 변수를 (객체,instance,object) 를 사용하여 접근하는 변수
 * 자동초기화가 된다.
 * 
 * @author SIST
 */
public class UseInstanceVariable {

	int i; // 정수형 초기화값 0
	int j;
	double d;// 실수형 초기화값 0.0
	char c; // 문자형 초기화값 \u0000
	boolean b; // 불형 초기화값 false
	String str;// 참조형 초기화값 null
	UseInstanceVariable jaehyun;// 참조형 초기화값 null

	public static void main(String[] args) {
		// static 영역은 가장 먼저 메모리(method)에 로드되므로, 생성될지도 모르는
		// instance 변수를 직접 사용할 수 있다.
		// i=300;

		// 객체화를 하면 객체가 메모리(heap)에 생성되고 그 주소를 메모리(stack)에 저장
		// 객체화 문법 : 클래스명 객체명=new 클래스명();
		UseInstanceVariable uiv = new UseInstanceVariable();
		UseInstanceVariable uiv1 = new UseInstanceVariable();
		System.out.println("객체 출력(heap의 주소)" + uiv);
		System.out.println("객체 출력(heap의 주소)" + uiv1);

		// heap에 생성된 instance variable을 사용
		uiv.i = 11;
		uiv.j = 21;

		System.out.println("uiv객체의 멤버변수 i=" + uiv.i);
		System.out.println("uiv객체의 instance변수 j=" + uiv.j);

		// instance (member)변수는 자동초기화된다.
		System.out.println("uiv1객체 i :" + uiv1.i + ", uin객체 j :" + uiv1.j);
		System.out.println("-----------------자동 초기화 값----------------");
		System.out.println("정수형 i :" + uiv1.i);
		System.out.println("실수형 i :" + uiv1.d);
		System.out.println("문자형 i :" + uiv1.c);
		System.out.println("불린형 i :" + uiv1.b);
		System.out.println("참조형1 :" + uiv1.str);
		System.out.println("참조형2 :" + uiv1.jaehyun);

	}// main

}// class
