package day1130;

public class SubConstr extends SuperConstr{
	int i;
	
	public SubConstr() {
		//}끝나고 호출한곳으로옴
		super();
		System.out.println("자식의 기본생성자");
	}
	public SubConstr(int i) {
		this();
		
		System.out.println("자식의 인자생성자"+i);
	}
}
