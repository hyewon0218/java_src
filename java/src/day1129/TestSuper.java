package day1129;

import javax.swing.text.TabExpander;

/**
 * 상속 관계의 부모클래스 : 모든 자식이 가져야 할 공통 특징을 정의 
 * 부모에게 정의된 코드는 자식에서 사용할 수 있다.
 * @author SIST
 */
public class TestSuper {

	public int pub_i;//어디에 있는 자식이든 자식에서 사용가능
	protected int pro_i;//같은 패키지의 자식, 다른 패키지의 자식에서 사용 가능
	private int pri_i;//부모클래스 안에서만 사용가능
	int def_i;//같은 패키지의 자식에서 사용가능, 패키지가 다르다면 사용불가
	
	public TestSuper() {
		System.out.println("부모클래스 기본생성자");
	}//
	public void superMethod() {
		System.out.println("부모클래스의 method");
	}
}//class
