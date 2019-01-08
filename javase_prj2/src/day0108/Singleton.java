package day0108;

/**
 * �������� JVM���� �ϳ��� ��ü�� ���������, �ϳ��� ��ü�� ���Ǵ� Pattern
 * @author SIST
 */
public class Singleton {
	private static Singleton single;
	
	/**
	 * 1. class�ܺο��� ��üȭ�� ���� ���ϵ��� ���´�.
	 */
	private Singleton() {
	}
	public static Singleton getInstance() {//static�������� instance���� ���� ���� ����
		if(single ==null) {//��ü�� �����Ǿ����� �ʴٸ� ��ü�� �����ϰ�
		single=new Singleton();
		}
		//��ü�� �����Ǿ��ִٸ� ������ ��ü�� ��ȯ�ȴ�.
		return single;
	}
}//class
