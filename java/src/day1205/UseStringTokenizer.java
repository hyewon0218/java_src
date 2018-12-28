package day1205;

import java.util.StringTokenizer;

/**
 * ���ڿ��� ª�� ����� �����ϴ� StringTokenizer�� ���
 * @author SIST
 */
public class UseStringTokenizer {
	
	public UseStringTokenizer () {
		String msg="������ ������ �Դϴ�. ������ -5�Դϴ�. �����ٰ� �սô�.";
		
		//�������� ���� : �Ű����� �ϳ��� ������ ���
		StringTokenizer stk =new StringTokenizer(msg);
		
		System.out.println(stk.countTokens() +"��");
		
		while(stk.hasMoreTokens() ) {//��ū�� �����ϴ���?
			//��ū�� ��� �����͸��������� �̵�
			System.out.println(stk.nextToken());	
		}
		String names="������,������~���ü�,����ö.������~������,������";
		
		//Ư�����ڷ� ��ū ���� : �Ű����� �ΰ��� ������
		StringTokenizer stk1= new StringTokenizer(names, ",");//�ش繮�� �� �ڸ� �� ����(split���� �������)
		System.out.println("----------------------------------------------------------------------");
		System.out.println("��ū�� �� : "+stk1.countTokens());
		while(stk1.hasMoreTokens()) {
			System.out.println(stk1.nextToken());
		}
		//Ư�����ڷ� ��ū ����, ���е� ���ڿ��� ��ū���� ó�� : 
		//�Ű����� 3���� ������ 
		System.out.println("------------------------------------------------------------------------");
		StringTokenizer stk2 = new StringTokenizer(names, ",.~",true);//true=���е� ���ڿ��� ��ū���� ó��
		while (stk2.hasMoreTokens()) {
			System.out.println(stk2.nextToken());
		}
	}
		
	
	public static void main(String[] args) {
		new UseStringTokenizer();
	}//main

}//class
