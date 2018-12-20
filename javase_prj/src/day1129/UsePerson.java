package day1129;

import java.util.Date;

public class UsePerson {

	public static void main(String[] args) {
		HongGilDong gd =new HongGilDong();
		gd.setName("홍길동");//부모의 method를 사용 
		System.out.println("눈 : "+gd.getEye()+",코 : "+gd.getNose()+", 입 : "+gd.getMouth());
		System.out.println(gd.eat());
		System.out.println(gd.eat("국밥",1));
		//자신만의 특징
		
		System.out.println(gd.fight(6));//7>8
		System.out.println(gd.fight(7));//8>9
		System.out.println(gd.fight(9));//비김.9>8
		System.out.println(gd.fight(10));//진다.8>7
		System.out.println(gd.fight(9));//진다.8>7
		
		System.out.println("------------------------------------------------------------------------------");
		Clark superman=new Clark();//자식이 생성되면 부모클래스가 먼저 생성된 후 자식이 생성된다.
		//자식의 객체로 부모클래스의 자원(변수,method)를 자신의 것처럼 사용할 수 있다.(코드의 재사용성)
		superman.setName("클락");//자식클래스의 객체명으로 얼마든지..
		
		System.out.println(superman.getEye()+"/"+superman.getNose()+"/"
							+superman.getMouth()+"/"+superman.getName());
		
		System.out.println(superman.eat());
		System.out.println(superman.eat("스테이크",10));
		
		//자식(자신)의 자원(변수,method) 
		String stone="짱돌";
		System.out.println(stone+"은 맞은 결과"+superman.power(stone)+", 힘의 변화 :"+superman.power);//getter쓰지않고접근
		stone="클립토나이트";
		System.out.println(stone+"은 맞은 결과"+superman.power(stone)+", 힘의 변화 :"+superman.power);//getter쓰지않고접근
		stone="다이아몬드";
		System.out.println(stone+"은 맞은 결과"+superman.power(stone)+", 힘의 변화 :"+superman.power);//getter쓰지않고접근
		
		Won w =new Won();
		w.setName("Won");
		System.out.println(w.getName()); 
		System.out.println(w.run());
		System.out.println(gd);//주소나옴 object의 toString 불러다 씀
		System.out.println(gd.toString());
		System.out.println(w.toString());
		
		String s=new String ("오늘은 금욜");
		
		Date d=new Date();
		System.out.println(d.getYear());//비추천method
		System.out.println(s.toString());//overriding 부모가 제공하는 주소의 출력기능 싫어 바꿈 
	}//main

}//class
