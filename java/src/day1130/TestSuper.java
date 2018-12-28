package day1130;

/**
 * 부모클래스 : 자식이 사용할 공통 코드를 정의 
 * @author SIST
 */
public class TestSuper {
	int p_i;
	int p_j;
	
	public TestSuper() {
		System.out.println("부모의 기본생성자");
	}
	
	public void method() {
		System.out.println("부모의 method p_i :"+ p_i+",p_j :"+p_j);
		
	}
}//class
