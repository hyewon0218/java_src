package day1203;

/**
 * interface를 구현하는 class (자식 클래스이고 interface내에 모든 추상method를 Override하는 클래스)
 * 구현 interface가 부모 interface를 가진다면 최종적인 자식클래스에서는 
 * 모든 추상 method를 구현해야 한다.
 * @author SIST
 */
public class InterfaceImpl implements SuperInterface {

	@Override	
	public String msg() {//interA
		return "내일은 화요일";
	}
	@Override
	public String msgB() {//interB
		return "오늘은 월요일";
	}
	
    @Override
	public void methodA() {//SuperInterface
		System.out.println("methodA");
	}

	@Override
	public void methodB(int i) {//SuperInterface
		System.out.println("methodB");
		
	}
	public void test() {
		
	}
	
	public static void main(String[] args) {
		//자식 클래스로 객체화 : 모든 method를 호출할 수 있다.
		//ii.msg,ii.msgB(),ii.methodA(),ii.methodB(), ii.test()
		InterfaceImpl ii=new InterfaceImpl();
		ii.methodB(12);

		//is a 관계의 객체화(데이터형이 중요!)
		//SuperInterface로 객체화를 하면 Override된 method만 호출
		// 부모의 method도 모두 호출 가능 
		//si.msg(), si.msgB(), si.methodA(), si.methodB() /test는 부를 수 없음.
		SuperInterface si=new InterfaceImpl();
		System.out.println(si.msg());
		
		//InterA로 객체화하면 ia.msg만 호출 가능.
		InterA ia=new InterfaceImpl();
		System.out.println(ia.msg());
		
		InterB ib=new InterfaceImpl();
		System.out.println(ib.msgB());
		
		//Object o=new InterfaceImpl();// object은 모든 자식을 다 저장할 수 있다.
		//interface는 객체화되지 않는다.
//		interA ia1=new InterA();
//		SuperInterface si1= new SuperInterface(); //인터페이스는 자식을 통해서만 객체가 만들어진다.
	}// main
}// class
