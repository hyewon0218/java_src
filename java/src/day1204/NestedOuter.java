package day1204;

/**
 * 내부클래스를 static변수처럼 사용할 수 있는 중첩클래스
 * @author SIST
 */
public class NestedOuter {

	int i;//쓰려면 안쪽에서바깥쪽인스턴스필요
	static int j;
	
	public NestedOuter() {
		System.out.println("바깥 클래스의 생성자");
	}
	
	public void outInstMethod() {
		System.out.println("바깥 클래스의 instance method");
	}
	
	public static void outStatMethod() {
		System.out.println("바깥 클래스의 static method");
	}
	
	////////////////////////////////////Nested class 시작////////////////////////////////////////////////
	static class NestedInner{
//		int in_i; //instance 영역 권장하지 않음!
		static int in_j;//static 변수
		
//		public NestedInner() { 권장하지 않음!
//		}
		
		public void inMethod() {
			System.out.println("안쪽클래스의 instance method");
		}
		public static void inStatMethod() {
			System.out.println(" 안쪽클래스의 static method"); 
			System.out.println("바깥 클래스의 자원 사용. i= 사용불가, j="+NestedOuter.j);//instance영역이라/(바깥클래스명.)j같은영역(static)에 대해서는 가능
//			outInstMethod();//instance영역의 method이므로 사용할 수 없다.
			NestedOuter.outStatMethod();
		}
	}//class
	
	////////////////////////////////////Nested class 끝////////////////////////////////////////////////
	public static void main(String[] args) {
		//static 영억을 사용할 때에는 객체화없이 클래스명.변수명, 클래스명.method명으로 사용한다.
		NestedInner.inStatMethod();
	}//main

}//class
