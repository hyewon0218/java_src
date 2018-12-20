package day1218;

import java.util.Random;

/**
 * method������ �߻��� ���ܸ� method�� ȣ���� ������ ó���ϴ� throws�� ���
 * @author SIST
 */
public class UseThrows {

	public void test()throws ClassNotFoundException {
		//throws�� ���ܸ� ������ method�ȿ��� try~catch�� �� �ʿ䰡 ����.
		String className="day1217.UseRuntimeException";
		
		if(new Random().nextBoolean()) {
			className="java.lang.Integer";
		}
		
		Object obj=Class.forName(className);
		System.out.println("Ŭ���� �ε�"+obj);
	}
	
	public static void main(String[] args) {
		UseThrows ut=new UseThrows();
		try {
			ut.test();//method�� ȣ���Ͽ� ���� �����ϴٺ��� ������ �߻��� ���� �ִ�.
		} catch (ClassNotFoundException cnfe) {
			System.out.println("�˼��մϴ�.");
			cnfe.printStackTrace();
			System.out.println("�������");
		}//end catch
	}//main

}//class
