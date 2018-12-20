package day1126;

/**
 *Ŭ������ ��ü�� ������ �� �⺻������ ������ �־���� �⺻���� �����ϰų�, �⺻������ ����� �ڵ带 �����ϴ� method����(��ü �ʱ�ȭ��)
 * @author SIST
 */
public class TestConstructor {

	/**
	 * �⺻ ������ : Ŭ������ �ۼ��� �� �����ڸ� �ϳ��� �������� ������ 
	 * �����Ϸ��� �Ű����� ���� Default Constructer�� �����Ѵ�. 
	 */
	public TestConstructor() {
		System.out.println("�⺻ ������");
//		TestConstructer(300); // �����ڴ� method ȣ���ϵ� ȣ���� �� ����. ��üȭ�� ���ؼ��� �θ� �� �ִ�.
	}//TestConstructer
	
	/**
	 * �ܺο� �Է°��� ������ �����ϴ� �����ִ� �������� Overload
	 * @param i ������ ��
	 */
	public TestConstructor(int i) {
		System.out.println("���� �ִ� ������:"+i);//�ϳ��� �����ϸ� �⺻������ ������ ����
	}//TestConstructer
	public void test() {
		System.out.println("test method!!!");
		temp();// method ȣ��
		
	}//test
		public void temp() {
			System.out.println("-------------temp method!!!");
	}//temp (instance method ������(��ȯ��,�Ű�x))
	
	public static void main(String[] args) {
		//Overloading �� �����ڸ� ����Ͽ� ��üȭ�� �پ��ϰ� �� �� ����(������)
		TestConstructor tc = new TestConstructor();//�⺻ ������(class�κ��� ���������ü(��) tc�� ����)
		TestConstructor tc1 = new TestConstructor(26);//�����ִ� ������

		System.out.println(tc);//heap�� ������� �ּ�
		System.out.println(tc1);
		
		tc.test();//test
//		�ȿ� temp���� 
	}//main

}//class
