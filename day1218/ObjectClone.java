package day1218;

import java.util.Stack;

/**
 * ��ü ���� : �����Ǵ� ��ü�� Cloneable interface�� �����ؾ߸� �Ѵ�.
 * @author SIST
 */
public class ObjectClone implements Cloneable {

	private int i;
	private Stack<ObjectClone> stack=new Stack<>();
	
	

	public static void main(String[] args) {

		ObjectClone oc=new ObjectClone();
		oc.i=100;
		
		try {
			ObjectClone oc1=(ObjectClone) oc.clone();
			System.out.println("��������"+oc1);
			oc.i=200;//���� ��ü�� ���°� ����
			System.out.println("���� : "+oc.i+" ������ : "+oc1.i);
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}//catch
	}//main

}//class
