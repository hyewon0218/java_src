package day1130;

public class SuperConstr {
	int i;
	
	public SuperConstr() {
		this(100);
		
		System.out.println("부모의 기본생성자");
	}//기본생성자 없으면 자식에서 에러남!
	public SuperConstr(int i) {
		//object부름
		this. i=i;
		System.out.println("부모의 인자생성자"+i);
	}
}
