package day0226;

/**
 * Garbage Collector�� ȣ���Ͽ� ��ü�� �Ҹ��Ű��(�޸��� �������� Ȯ��)
 * @author SIST
 */
public class UseGarbageCollector {

	public static void main(String[] args) {
		Person p=new Person("������");
		p=new Person("������");
		p=new Person("���ü�");
		p=new Person("������");
		p=new Person("������");
		
		System.gc();//Garbage Collector ȣ��
		System.out.println("���� ��� : "+ p.getName());
	}//main

}//class
