package day1206;

import java.util.Stack;

/**
 * LIFO(Last Input First Output)을 구현한 클래스
 * @author SIST
 */
public class UseStack {
	
	public UseStack() {
		
		//생성)
		Stack<String> stk =new Stack<String>();
		//값 할당)
//		stk.add("부모"); //부모클래스가 제공하는 기능은 사용하지 않는다.(stack의 고유기능을 위해)
		stk.push("하셨습니다.");//1
		stk.push("수고");//2
		stk.push("오늘도");//3
		System.out.println(stk);
		System.out.println("크기 : "+stk.size());//부모 
		
//부모클래스가 제공하는 기능을 사용하면 Stack은 고유기능을 사용할 수 없게된다.
//		for(int i=0; i < stk.size() ; i++) { 
//			System.out.println(stk.get(i));
//		}
		System.out.println(stk.empty());
		while(!stk.empty()) {
			System.out.println(stk.pop());//Stack 에서 데이터를 꺼내면 다음번에는 
												//그 데이터를 사용할 수 없다.					
		}
		
		
		
	}//UseStack

	public static void main(String[] args) {
		new UseStack();
	}//main

}//class
