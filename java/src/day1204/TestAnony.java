package day1204;

/**
 * 인터페이스가 method의 매개변수일 때 간단하게 사용하는 방법.<br>
 * 
 * @author SIST
 */
public class TestAnony {
	
	public void useAnonInter(AnonyInter ai) {
		System.out.println(ai.getMsg()+" "+ai.getName());
	}
	
	public static void main(String[] args) {
//		AnonyInter ai=new AnonyInter();// 인터페이스는 객체화x
		//인터페이스가 매개변수였을 때 
		//1. 인터페이스를 구현한 클래스를 생성.
		//2. 구현클래스로 객체생성
		AnonyInter ai =new AnonyImpl();//is a 
//		AnonyImpl ai =new AnonyImpl();//가능
		//3. 매개변수를 가진 method를 호출하기 위해 객체 생성
		TestAnony ta= new TestAnony();
		//4. method를 호출
		ta.useAnonInter(ai);
		System.out.println("---------------------anonymous innerclass--------------------------");
		// anonymous inner class를 사용하면 클래스를 따로 만들 필요가 없음.
		
		ta.useAnonInter(new AnonyInter() {
			@Override
			public String getName() {
				return "공선의"+test()
				;
			}
			@Override
			public String getMsg() {
				return "온뇨쇼";
			}
			public String test() {
				return "자식 method";
			}
		});
	}//main

}//class
