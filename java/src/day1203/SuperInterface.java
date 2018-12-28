package day1203;

/**
 * 구현클래스(자식클래스)에서 반드시 구현해야하는 일의 목록만
 * 정의하는 interface의 사용법(구현의 강제성)
 * @author SIST
 */
//interface는 부모를 여러개 가질 수 있다.
public interface SuperInterface extends InterA, InterB {//interface끼리 상속,다중상속
	//constant : 변수를 상수처럼 사용
//	int i;// 변수는 작성할 수 없다.//error
	public static final int FALG_VALUE=12;
	
	//추상method 구성
	//일반 method는 가질 수 없다.error
//	public void test () {// 
		
//	}
	//인터페이스간 상속에는 추상 method를 Override를 하지 않는다.
//	@Override
//	public String msg(); //부모랑 똑같은 거 한번 더써주는거,,
	//abstract을 사용하지 않아도 된다.
	public void methodA();
	//abstract를 사용해도 된다.
	public abstract void methodB(int i);
}//interface
