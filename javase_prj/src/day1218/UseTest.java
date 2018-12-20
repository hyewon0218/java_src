package day1218;

public class UseTest {
	
	public void useTest(Test test) {
		if(test instanceof TestImpl) {
		String date=test.getDate();
		System.out.println(date);
		}else {
			System.out.println("TestImpl만 처리합니다.");
		}
		
	}

	public static void main(String[] args) {
		TestImpl ti=new TestImpl();
		TestImpl2 ti2=new TestImpl2();
		
		
		UseTest ut=new UseTest();
		ut.useTest(ti);
		ut.useTest(ti2);
	}

}
