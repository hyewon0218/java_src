package day1121;

/**
 * Instance Variable 의 Access Modifier 사용 
 * public : 클래스외부에서 접근 가능
 * protected : 같은 패키지에서 접근 가능, 패키지가 다르면 상속관계의 
 * 				  자식 클래스만 접근 가능	
 * private : 	클래스 안에서만 접근 가능
 * default : 	같은 패키지에서 접근 가능, 패키지가 다르면 접근 불가 
 * @author SIST
 */
public class InstAccModifi {
	public int pub_i;
	protected int pro_i;
	private int pri_i;
	int def_i;
	
	
	public static void main(String[] args) {
		//객체화
		InstAccModifi ivam=new InstAccModifi();
		//변수를 가지고 있는 클래스 안에서 객체화가 되면 접근 지정자에
		// 상관 없이 모두 사용 가능 
		System.out.println("public :" +ivam.pub_i);
		System.out.println("protected :" +ivam.pro_i);
		System.out.println("private :" +ivam.pri_i);
		System.out.println("default :" +ivam.def_i);
	}//main

}//class
