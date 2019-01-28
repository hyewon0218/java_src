package prj;


public class RandomPW {

	public RandomPW() {
		
	}
	
	public char[] createPassword () {
		char[] tempPass=new char[12];
		//영문자대문자(65~90), 소문자, 숫자(48~57)로 이루어진 임의의 비밀번호 8자리를 생성하여 반환하는 일
		String flag="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		
		for(int i=0; i < tempPass.length ; i++) {
			tempPass[i]=flag.charAt((int)(Math.random()*flag.length())); 
			System.out.print(tempPass[i]);
		}
		return tempPass;
	}
	
	public static void main(String[] args) {
		new RandomPW().createPassword();
		
	}//main
}
