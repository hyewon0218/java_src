package day0108;

/**
 * 실행중인 JVM에서 하나의 객체가 만들어지고, 하나의 객체만 사용되는 Pattern
 * @author SIST
 */
public class Singleton {
	private static Singleton single;
	
	/**
	 * 1. class외부에서 객체화를 하지 못하도록 막는다.
	 */
	private Singleton() {
	}
	public static Singleton getInstance() {//static영역에서 instance변수 직접 참조 못함
		if(single ==null) {//객체가 생성되어있지 않다면 객체를 생성하고
		single=new Singleton();
		}
		//객체가 생성되어있다면 생성된 객체가 반환된다.
		return single;
	}
}//class
