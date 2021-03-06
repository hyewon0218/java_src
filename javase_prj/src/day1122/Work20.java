package day1122;
/*아래의 업무를 처리하는 method를 type에 알맞게 작성하고 API주석을
설정한 후 호출하여 결과를 본 후 Java Doc을 생성해보세요.
- API주석은 어떤 형태의 method인지를 주석으로 기술할것.

1. 자신의 이름을 반환하는 method작성.(고정 값- 반환형 o string , 매개변수 x)
2. 나이를 입력받아 태어난 해를 반환하는  method 작성.(가변 값- 반환형 o int, 매개변수 o int (byte도 어차피int로 바뀜))
3. 문자를 입력받아 해당 문자의 Unicode 값을 반환하는 method 작성.(가변 값- 반환형 o int , 매개변수 o char)
4. 숫자를 입력받아 숫자가  영문자, 숫자의 범위에 있을 때 해당 숫자의
   문자를  출력하는 일을 하는 method  작성 (가변 일 - 반환형 o void, 매개변수 o int)
5. 호출하면 자신의 주소를 출력하는  method 작성.(고정 일 - 반환형x, 매개변수 x)
6. 친구의 이름을 입력받아 출력하는  method 작성(친구는 n명 입니다.)(가변 일 - 반환형x, 매개변수 o Variable Arguments) */
public class Work20 {
	
	public void getName() {
		System.out.println("최혜원");
	}
	public int getYear(int age) {
		return 2018-age+1; 
	}
	public int getUnicode(char c) {
		return (int)c;
	}
	public void printNumToChar(int num) {
		if ((num > 64 && num <91) || (num>96 && num<123))
			System.out.println((char)num);
		else
			System.out.println("소문자는 65~90, 대문자는 97~122");	
	}
	
	public void getMyAddress() {
		System.out.println("인천~구~동~로");
	}
	
//현재년도-나이+1
	public void printMyFriendsName(String ... names) {
		for(String name : names) {
			System.out.println(name +" ");	
		}
		System.out.println();
	}			
	public static void main(String[] args) {

		Work20 w20 = new Work20(); 
		
		w20.getName();
		
		System.out.println(w20.getYear(25));
		
		System.out.println(w20.getUnicode('A'));
		System.out.println(w20.getUnicode('z'));
		System.out.println(w20.getUnicode('a'));
		System.out.println(w20.getUnicode('z'));
		
		w20.printNumToChar(50);
		w20.printNumToChar(65);
		w20.printNumToChar(90);
		w20.printNumToChar(97);
		w20.printNumToChar(122);
		w20.printNumToChar(123);
		
		w20.getMyAddress();
		
		w20. printMyFriendsName("친구1","친구2","친구3","친구4","친구5");
		

		
		
		
		/*		int year = w20.getYear(25);
		System.out.println(year);*/
	}//main

}//class
