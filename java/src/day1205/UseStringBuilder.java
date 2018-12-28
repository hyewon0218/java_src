package day1205;

/**
 * StringBuffer, StringBuilder(JDK1.5)
 * 문자열을 heap에 저장하고 사용하는 클래스
 * @author SIST
 */
public class UseStringBuilder {
	
	public void useStringBuffer() {
		//1.클래스를 생성 
		StringBuffer sb=new StringBuffer();
		//2.값(정수, 실수, 문자, 불린, 문자열) 추가
		sb.append("오늘은 ");//문자열
		sb.append(12);//정수
		sb.append("월 5일").append("수요일 입니다.");//문자열
		System.out.println(sb);
		
		//3. 값 삽입
		//오늘은 12월 5일수요일 입니다.
		//0 1  2 34
		sb.insert(3, "2018년");//3번째자리에 넣어 뒤로밀림
		System.out.println(sb);
		
		//4. 값 삭제 : delete(시작인덱스,끝인덱스+1)
		//오늘은2018년 12월 5일수요일 입니다.
		sb.delete(0, 3);//문자열끝은null
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
	}
	public void useStringBuilder() {
		 
				//1.클래스를 생성 
				StringBuilder sb=new StringBuilder();
				//2.값(정수, 실수, 문자, 불린, 문자열) 추가
				sb.append("오늘은 ");//문자열
				sb.append(12);//정수
				sb.append("월 5일").append("수요일 입니다.");//문자열
				System.out.println(sb);
				
				//3. 값 삽입
				//오늘은 12월 5일수요일 입니다.
				//0 1  2 34
				sb.insert(3, "2018년");//3번째자리에 넣어 뒤로밀림
				System.out.println(sb);
				
				//4. 값 삭제 : delete(시작인덱스,끝인덱스+1)
				//오늘은2018년 12월 5일수요일 입니다.
				sb.delete(0, 3);//문자열끝은null
				System.out.println(sb);
				sb.reverse();
				System.out.println(sb);
	}
	
	public static void main(String[] args) {
		UseStringBuilder usb =new UseStringBuilder();
		usb.useStringBuffer();
		System.out.println("----------------------------------------");
		usb.useStringBuilder();
		
		String str="안녕하세요?";//짧은 문자열
		System.out.println(str);
		String str1="안";
		//문자열에 +가 붙어서 긴 문자열
		System.out.println(str1+"녕"+"하"+"세"+"요?");
		//new StringBuilder().append(str1).append("녕").append("하"),,,,,
	}//main

}//class
