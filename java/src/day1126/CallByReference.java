package day1126;

/**
 * method�� �Ű������� ��������������(class, ���ڿ�, array)�� ���
 * arguments�� ������ �ϳ��� �ּҰ� �Ҵ�ȴ�.
 * (���� �����ϸ� ������ ��ü�� ���� ���� ����ȴ�.)
 * @author SIST
 */
public class CallByReference {
	private int i;
	private int j;//instance����
	
	public void swap(CallByReference cbr) {//�ּҰ� �״�� ���޵ȴ�.
		int temp=0;
		temp=cbr.i;
		cbr.i=cbr.j;
		cbr.j=cbr.i;
		System.out.println("swap method�� i="+i+",j="+j);
	}//swap (instance method)
	
	public static void main(String[] args) {
		CallByReference cbr = new CallByReference();
		cbr.i=11;
		cbr.j=26;
		
		
		System.out.println("swap �� �� i="+cbr.i+",j="+cbr.j);//i�� j����x
		cbr.swap(cbr);// �ּҰ� �״�� ����
		System.out.println("swap �� �� i="+cbr.i+",j="+cbr.j);//i�� j����x
		
		
	}//main

}//class
