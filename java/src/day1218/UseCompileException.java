package day1218;

/**
 * Compile Exception : byte code�� ���������� �����ϱ� ���� �� �����ڰ� �ݵ�� ���ܻ�Ȳ�� ó���ؾ��ϴ� ����
 * 
 * @author SIST
 */
public class UseCompileException {

	public static void main(String[] args) {
		try {
//			Object obj = Class.forName("java.lang.String");
			Object obj = Class.forName("day1217.UseRuntimeException");
			System.out.println("�ε��� Ŭ���� " + obj);
		} catch (ClassNotFoundException cnfe) {
			System.err.println("�˼��մϴ�.");
			System.err.println("���� �޼��� ��� "+cnfe.getMessage());
			System.err.println("����ó�� ��ü�� �ż��� : "+cnfe);
			cnfe.printStackTrace();//�����ڰ�����/�ٺ����� ��������!
//			System.out.println("--------");//ptintln�� printStackTrace���� ���� ��µ� �� �ִ�. 
			
		}finally {
			System.out.println("������ּż� ��");
		}// end catch
	}// main

}// class
