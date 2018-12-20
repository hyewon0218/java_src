package day1204;

/**
 * ����Ŭ������ static����ó�� ����� �� �ִ� ��øŬ����
 * @author SIST
 */
public class NestedOuter {

	int i;//������ ���ʿ����ٱ����ν��Ͻ��ʿ�
	static int j;
	
	public NestedOuter() {
		System.out.println("�ٱ� Ŭ������ ������");
	}
	
	public void outInstMethod() {
		System.out.println("�ٱ� Ŭ������ instance method");
	}
	
	public static void outStatMethod() {
		System.out.println("�ٱ� Ŭ������ static method");
	}
	
	////////////////////////////////////Nested class ����////////////////////////////////////////////////
	static class NestedInner{
//		int in_i; //instance ���� �������� ����!
		static int in_j;//static ����
		
//		public NestedInner() { �������� ����!
//		}
		
		public void inMethod() {
			System.out.println("����Ŭ������ instance method");
		}
		public static void inStatMethod() {
			System.out.println(" ����Ŭ������ static method"); 
			System.out.println("�ٱ� Ŭ������ �ڿ� ���. i= ���Ұ�, j="+NestedOuter.j);//instance�����̶�/(�ٱ�Ŭ������.)j��������(static)�� ���ؼ��� ����
//			outInstMethod();//instance������ method�̹Ƿ� ����� �� ����.
			NestedOuter.outStatMethod();
		}
	}//class
	
	////////////////////////////////////Nested class ��////////////////////////////////////////////////
	public static void main(String[] args) {
		//static ������ ����� ������ ��üȭ���� Ŭ������.������, Ŭ������.method������ ����Ѵ�.
		NestedInner.inStatMethod();
	}//main

}//class
