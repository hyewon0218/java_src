package day1130;

/**
 * TestSuper의 자식 클래스
 * @author SIST
 */
public class TestSub extends TestSuper{
	int p_j;//이름 같
	
	@Override
	public void method() {//이름같지만 하는일다름!
		p_i=400;//나한테없는데 내것처럼! 코드의재사용성//부모의 변수
		p_j=500;//자식의 것 /같은 이름의 변수가 존재하면 자식의 것 사용
		System.out.println("자식의 method : "+ this.p_i+"/"+this.p_j);
		super.method();//자식꺼먼저.그담부모꺼
		
		System.out.println(this);
//		System.out.println(super);//super의 주소는 출력할 수 없다.
	}
	public static void main(String[] args) {
		TestSub ts =new TestSub();// 부모꺼
		ts.method();//Overriding은내꺼먼저부름
	}//main

}//class
