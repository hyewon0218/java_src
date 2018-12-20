package day1122;

/**
 * Variable Arguments
 * �Ű������� �ϳ��ε� �μ��� ������ ���� �� �ִ� ���.<br>
 * method �������� �迭�� ó���ȴ�.<br>
 * ����) "�������� ... �Ķ���͸�" �������� ����
 * @author SIST
 */
public class VariableArguments {
	/**���� ������������ �� �μ� ���� ������ ����� ��
	 * @param param ���� �μ���
	 */
	public void test(int ... param ) {
		
		for(int val : param) {	
			System.out.println(val);
		}
		System.out.println("test method called!!!");
		
	}//test
	

	/**���� �μ��� �ޱ����� �Ű������� ���� ���������� ����� �� �ִ�.
	 * @param i
	 * @param d
	 * @param j
	 */
	public void test1(int i, double d,int ... j ) {
		System.out.println("ó�� �Ű����� :"+i);
		System.out.println("�ι�° �Ű����� :"+d);
		System.out.println("����° �Ű����� :"+j);
		for(int idx=0; idx < j.length ; idx++) {
			System.out.println(j[idx]);
		}//end for
	}
	//���ڿ��� �Է¹��� �� �ִ� �Ű������� ���
	public void printName(String name) {
		System.out.println(name+"�� �ȳ��ϼ���?");
	}//printName
	public static void main(String[] args) {
		VariableArguments va= new VariableArguments();
//		va.test(1,2,3,4,5);
		va.test1(1, 3.14, 10,20,30,40,50,60);
		
		String name="������";
		va.printName(name);
		
		
		System.out.println("\'�ȳ��ϼ���\'");
		System.out.println("\"�ȳ��ϼ���\"");
	}//main

}//class
