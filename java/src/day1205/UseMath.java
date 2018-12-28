package day1205;

/**
 * Math : 객체를 생성하지 않고 사용하는 클래스
 * @author SIST
 */
public class UseMath {

	public UseMath() {
//		Math m=new Math();//객체생성하지않는다.
		int i=-12;
		System.out.println(i+"i의 절대값 :"+Math.abs(i));
		System.out.println(Math.ceil(10.1));
		System.out.println(Math.round(10.5));//소수점이하처음자리에서만 반올림.
		System.out.println(Math.floor(10.45));//소수점이하처음자리에서만 반올림
		double d=Math.random();
		System.out.println("발생한 난수 : "+d);
		System.out.println("범위를 설정한 난수 : "+d*5);
		System.out.println("범위를 설정한 난수에서 정수 : "+(int)(d*5));
		
		//A(65)-Z(90)중 하나의 문자를 반환하는 일.
		System.out.println((char)((int)(d*26)+65));
	}
	
	public char[] createPassword () {
		char[] tempPass=new char[8];
		//영문자대문자(65~90), 소문자, 숫자(48~57)로 이루어진 임의의 비밀번호 8자리를 생성하여 반환하는 일
		String flag="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		
		for(int i=0; i < tempPass.length ; i++) {
			tempPass[i]=flag.charAt((int)(Math.random()*flag.length())); 
			System.out.print(tempPass[i]);
		}
		return tempPass;
	}
	
	public static void main(String[] args) {
		new UseMath().createPassword();
		
	}//main

}//class
