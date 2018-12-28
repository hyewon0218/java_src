package day1205;

import java.util.StringTokenizer;

/**
 * 문자열을 짧은 마디로 구분하는 StringTokenizer의 사용
 * @author SIST
 */
public class UseStringTokenizer {
	
	public UseStringTokenizer () {
		String msg="오늘은 수요일 입니다. 날씨는 -5입니다. 쉬었다가 합시다.";
		
		//공백으로 구분 : 매개변수 하나인 생성자 사용
		StringTokenizer stk =new StringTokenizer(msg);
		
		System.out.println(stk.countTokens() +"개");
		
		while(stk.hasMoreTokens() ) {//토큰이 존재하는지?
			//토큰을 얻고 포인터를다음으로 이동
			System.out.println(stk.nextToken());	
		}
		String names="이재현,이재찬~정택성,김희철.김정운~김정윤,공선의";
		
		//특정문자로 토큰 구분 : 매개변수 두개인 생성자
		StringTokenizer stk1= new StringTokenizer(names, ",");//해당문자 다 자를 수 있음(split보다 기능좋음)
		System.out.println("----------------------------------------------------------------------");
		System.out.println("토큰의 수 : "+stk1.countTokens());
		while(stk1.hasMoreTokens()) {
			System.out.println(stk1.nextToken());
		}
		//특정문자로 토큰 구분, 구분된 문자열도 토큰으로 처리 : 
		//매개변수 3개인 생성자 
		System.out.println("------------------------------------------------------------------------");
		StringTokenizer stk2 = new StringTokenizer(names, ",.~",true);//true=구분된 문자열도 토큰으로 처리
		while (stk2.hasMoreTokens()) {
			System.out.println(stk2.nextToken());
		}
	}
		
	
	public static void main(String[] args) {
		new UseStringTokenizer();
	}//main

}//class
