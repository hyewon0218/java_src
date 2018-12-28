package day1129.sub;

import day1129.TestSuper;

/**
 * TestSuper의 자식클래스
 * @author SIST
 */
public class TestSub extends TestSuper {
	int i;
	public TestSub() {
		System.out.println("자식의 생성자");
	}
	public void subMethod() {
		System.out.println("자식 method");
	}
	public static void main(String[] args) {
		//객체화는 자식클래스를 사용한다.
		TestSub ts= new TestSub();
		//자식과 부모가 다른 패키지에 존재하면 부모가 가진
		//변수나 method의 접근지정자가 public,protected인
		//자원만 사용할 수 있다. (캡슐화 encapsulation)
		ts.pub_i=10;//public 
		ts.pro_i=20; //protected
//		ts.def_i=30; // default
		ts.i=100;
		System.out.println("부모의 자원 "+ts.pub_i+"/"+ts.pro_i/*+"/"+ts.def_i*/);
		System.out.println("자식의 자원"+ts.i);
		
		ts.superMethod();
	}//main

}//class
