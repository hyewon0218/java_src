package day1126;

/**
 * this를 사용한 생성자 호출 
 * @author SIST
 */
public class ThisConstructor {
	public ThisConstructor() {
//		this(26);//인자있는 생성자 먼저 나오고 기본생성자 나옴
		System.out.println("기본 생성자");
	}//ThisConstructor
	
	public ThisConstructor(int i) {
		this();
		System.out.println("인자있는 생성자");
//		this();//생성자의 첫번째 줄에서만 사용가능
	}//ThisConstructor
	
	public static void main(String[] args) {
//		new ThisConstructor();//객체를 저장해서 사용할 일이 없을 때
		new ThisConstructor(22);
	}//main
}//class
