package day0423;

public class TestService {
	
	private TestDao td;//의존성 주입 받은 객체를 사용할 수 있도록 instance변수로 선언
	
	public TestService(TestDao td) {//interface를 의존성 주입 받으면 약결합
		this.td=td;
		System.out.println("생성자 의존성 주입");
	}//TestService
	public TestService() {
		System.out.println("기본생성자를 사용하여 객체 생성");
	}
	
	//method 의존성 주입: 반드시 기본 생성자가 존재해야한다.
	public void setTd(TestDao td) {
		this.td=td;
	}//setTd
	public TestDao getTd( ) {
		return td;
	}//getTd
	
}
