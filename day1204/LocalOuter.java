package day1204;

/**
 * method�ȿ� Ŭ������ �����ϴ� ����class�� ���.<br>
 * ������ ��ü�� ��������ó�� ����ϴ� Ŭ����
 * @author SIST
 */
public class LocalOuter {
	int i;
	
	public LocalOuter() {
		System.out.println("�ٱ�Ŭ������ ������");
	}
	public void method(int param_i,final int param_j) { //param�� ���������� ��������
		int local_i=0;
		final int local_j=0;
		
		//method�ȿ��� class
		///////////////////////////////////����Ŭ���� ����//////////////////////////////////////////
		class Local {
			int loc_i;
			
			public Local() {
				System.out.println("����Ŭ������ ������");
			}
			public void locMethod( ) {
				System.out.println("����Ŭ������ method loc_i="+loc_i);
				System.out.println("�ܺ� Ŭ������ �ν��Ͻ� ���� i="+i);
				//JDK1.8���������� final�� ���� �Ű������� ����� �� �ִ�.
				System.out.println("�Ű�����(Parameter) param_i="+param_i+", param_j="+param_j);
				//JDK1.8���������� final�� ���� ���������� ����� �� �ִ�.
				System.out.println("�������� local_i="+local_i+",local_j="+local_j);
				//local_i=2018; //JDK 1.8�������ʹ� final�پ����� ���� ���������� ����� ����������
				// ���Ҵ��� ���� �ʴ´�.
			}
			
		}
		///////////////////////////////////����Ŭ���� ��////////////////////////////////////////////
		//����Ŭ������ ��üȭ
		Local lo=new Local();
		//������ ��ü�� Ŭ������ ���� �ڿ��� ����� �� �ִ�.
//		ioc_i=100; //�������Ұ�
		lo.loc_i=100;
		lo.locMethod();
		
		System.out.println("�ٱ� Ŭ������ method ȣ��");
	}
	
	public static void main(String[] args) {
		LocalOuter lo=new LocalOuter();
		lo.method(12, 4);
	}//main

}//class
