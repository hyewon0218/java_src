package day0103;

public class UseLamda2 {

	
	public static void main(String[] args) {
		//매개변수가 있는 abstract method 사용
		//추상 method가 매개변수를 가지고 있다면 람다식의 매개변수를 정의  
//		TestLamda2 tl2= (int i, int j)-> System.out.println(i+" + "+ j + " = " + (i+j));
		//람다식에 기술되는 매개변수명은 추상method의 매개변수명과 같을 필요는 없다.
//		TestLamda2 tl2= (int num1, int num2)-> 
//						System.out.println(num1+" + "+ num2 + " = " + (num1+num2));
		
		//타입 추론 : 람다식에 기술되는 매개변수는 데이터형을 생략할 수있다.
//		TestLamda2 tl2= (num1, num2)-> 
//						System.out.println(num1+" + "+ num2 + " = " + (num1+num2));
		
		TestLamda2 tl2= (num1, num2)-> {
						StringBuilder sb=new StringBuilder();
						sb.append(num1).append(" + ").append(num2)
						   .append(" = ").append(num1+num2);
						
						
						System.out.println(sb);
						};	
		tl2.plus(1, 3);
	}//main
}//class
