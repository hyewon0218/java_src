package day1119;

/**
 * switch~case : 정수를 비교할 때(JDK1.7에서부터는 문자열도 비교 가능)<br>
 * 문법) switch(변수명){<br>
 * 				case 상수 : 수행문장;<br>
 * 				case 상수 : 수행문장;<br>
 *						.<br>
 *						.<br>
 *				default : 일치하는 상수가 없을 때 수행문장;<br>
 *				} 
 * @author SIST
 */
public class TestSwitchCase {

	public static void main(String[] args) {
	//	String i="1";  //JDK1.7 +에서 사용 가능
		int i=0;
		
		//switch에 입력되는 변수의 데이터형은 byte,short,int,char,String
		switch(i) {
		//case는 입력되는 변수에 따라 다른 상수의 범위를 가진다.
		case 0 : System.out.println("새벽");
		case 1 : System.out.println("아침");
		case 2 : System.out.println("점심");
		default : System.out.println("저녁");
		}//end switch
	}//main

}//class
