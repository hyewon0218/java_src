package day1206;

import java.util.Stack;

/**
 * LIFO(Last Input First Output)�� ������ Ŭ����
 * @author SIST
 */
public class UseStack {
	
	public UseStack() {
		
		//����)
		Stack<String> stk =new Stack<String>();
		//�� �Ҵ�)
//		stk.add("�θ�"); //�θ�Ŭ������ �����ϴ� ����� ������� �ʴ´�.(stack�� ��������� ����)
		stk.push("�ϼ̽��ϴ�.");//1
		stk.push("����");//2
		stk.push("���õ�");//3
		System.out.println(stk);
		System.out.println("ũ�� : "+stk.size());//�θ� 
		
//�θ�Ŭ������ �����ϴ� ����� ����ϸ� Stack�� ��������� ����� �� ���Եȴ�.
//		for(int i=0; i < stk.size() ; i++) { 
//			System.out.println(stk.get(i));
//		}
		System.out.println(stk.empty());
		while(!stk.empty()) {
			System.out.println(stk.pop());//Stack ���� �����͸� ������ ���������� 
												//�� �����͸� ����� �� ����.					
		}
		
		
		
	}//UseStack

	public static void main(String[] args) {
		new UseStack();
	}//main

}//class
