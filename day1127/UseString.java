package day1127;

/**
 * 문자열 저장소의 주소를 저장하고, 문자열을 다루는 기능을 재공하는
 * String class 사용
 * java에서 제공하는 클래스의 이름과 내가 만든 클래스의 이름이 같다면 
 * 내가 만든 클래스를 먼저 사용하게 된다.
 * JAVA에서 제공하는 클래스를 사용할 때마다 "FULL PATH: 패키지명을 모두
 * 기술하여 클래스를 사용하는 것"로 사용해야한다.
 * 패키지명.클래스명
 * @author SIST
 */
public class UseString {

	public static void main(String[] args) {
		System.out.println("안녕");
//		기본형 형식 사용.	String s="문자열";
		String str="AbcdEfg";
//		참조형 형식 사용. String s1=new String("문자열");
		String mail=new String("esc0218@naver.com");
		System.out.println(str);
		System.out.println(mail);
		
		System.out.println(str+"의 길이"+str.length());
		System.out.println(mail+"의 길이"+mail.length());
		
		System.out.println(str+ "모두 대문자"+str.toUpperCase());
		System.out.println(str+ "모두 대문자"+str.toLowerCase());
		//"AbcdEfg"
		// 0 123456
		//indexOf는 L->R진행하면 가장 처음 찾아지는 문자열의 인덱스를 얻는다.(한자가 아닐 수도 있다 여러자 가능)
		System.out.println(str+"에서 'd'의 인덱스 :"+str.indexOf("dEf"));
		System.out.println(str+"에서 'z'의 인덱스 :"+str.indexOf("z"));//없는 문자는 -1
		
		
		System.out.println(mail+"에서 \"@\"의 인덱스 :"+mail.indexOf("@"));//
		//lastIntexOf R->L로 진행 가장 처음 찾아지는 문자열의 인덱스를 얻는다.
		str="AbcdEfAg";
		System.out.println(str+"문자열에서 뒤로부터 'A'의 인덱스 :"+str.indexOf("A"));//
		System.out.println(str+"문자열에서 뒤로부터 'A'의 인덱스 :"+str.lastIndexOf("A"));//
		//특정 인덱스의 문자 얻기
		char temp=str.charAt(2);
		System.out.println(str +"에서 2번째 인덱스에 해당하는 문자"+temp);
		
		//자식문자열 자르기
		//AbcdEfAg
		//01234567 (f자리에 null)	
		System.out.println(str+"에서 인덱스가 2~5번째에 해당하는 문자열"+str.substring(2,6));
		//esc0218@na v e   r  .  c o m
		//01234567 891011 1213141516<-String index
		System.out.println(mail+"에서 메일 주소만 얻기"+mail.substring(0,mail.indexOf("@")));
		System.out.println(mail+"에서 도메인 주소만 얻기"+mail.substring(mail.indexOf("@")+1,mail.length()));
		//substring은 시작인덱스만 넣으면 끝까지 잘라낸다.
		System.out.println(mail+"에서 도메인 주소만 얻기"+mail.substring(mail.indexOf("@")+1));
		
		//앞뒤공백 자르기
		str="   A BC   ";
		System.out.println("["+str+"]에서 앞뒤공백 제거["+str.trim()+"]");
		
		//문자열 붙이기
		str="ABCD";
		String str1=str.concat("Efg");
		String str2=str+"Efg";
		System.out.println(str1);
		System.out.println(str2);
		
		//문자열이 같은지 비교
		str="이재현";
		System.out.println(str+"은(는)"+(str.equals("이재찬")?"반장":"평민"));
		
		//문자열이 이 문자열로 시작하는지 
		str="피씨방";
		if(str.startsWith("씨방")) {
			System.out.println("욕은 사용하실 수 없습니다.");
		}else {
			System.out.println(str);
		}//else
		
		str="서울시 강남구";
		str1="수원시 팔달구";
		
		System.out.println(str1+"은(는)"+(str1.startsWith("서울")?"서울시입니다.":"서울이 아닙니다."));
		//특정 문자열로 끝났는지
		str="서울시 강남구 역삼동";
		str1="경기도 김포시 김포리";
		System.out.println(str1+"은(는)"+(str1.endsWith("동")?"도시":"시골"));
		
		//치환: 문자열 내의 모든 문자열을 찾아서 치환
		str="나 지금 피씨방인데 넌 어디니 씨 방새야!";
//		System.out.println(str.replaceAll("씨방", "**"));//뜨ㅣ어쓰면 적용안됨
		//method 를 연결해서 호출하는 것을 method chain
		System.out.println(str.replaceAll("씨", "*").replaceAll("방","*"));//반환형. method
		
		
		str="   A BC   ";
		System.out.println(str.replaceAll(" ", ""));
		
		int i=27;
//		str=1; int는 String으로 할당될 수 없다.
		//기본형 데이터형을 문자열로 변환
		str=String.valueOf( i );
		System.out.println( str );
		double d= 11.27;
		str=d+"";
		System.out.println( str );
		
		str="11";
		System.out.println( str.isEmpty() );
		
		//객체 생성을 하지 않았을 때 그 클래스가 제공하는 method를 
		// 사용할 수 없다. error
//		str=null;
//		System.out.println(str.isEmpty());
		
		
		////////////////////////////11-28-2018 split 사용 코드 추가/////////////////
		String data =
		"이재찬, 이재현, 정택성~공선의~김건하.최지우,노진경,김정운.김정윤";
		//split은 한번에 하나의 문자로 구분하여 자른다.
		String[] arr=data.split("[.]");//.은 그냥 쓰면 구분되지 않는다.[]묶어서 쓴다. 
		System.out.println("구분된 배열 방의 갯수 :"+arr.length);
		for(String name : arr) {
			System.out.println(name);
		}
		
		
		
		
	}//main

}//class
