package day1203;

/**
 * ����� �������� ����� �θ� Ŭ���� .<br>
 * ��üȭ�� ���� �ʴ´�.<br>
 * �ڽ� Ŭ������ �ݵ�� �����ؾ��� abstract method�� ������ Ŭ����
 * @author SIST
 */
public abstract class AbstractSuper {
	int i;
	
	public AbstractSuper() {
		//�ڽ�Ŭ������ ������ ���� ȣ��ȴ�.
		System.out.println("AbstractSuper �θ� ������");
	}	
	public void method() {//�Ϲ�method�� body{}�ʿ�
	 System.out.println("�θ� ���� �ϴ� �Ϲ� method");	
	}
	//�߻� method�� �ڽ��� �ݵ�� �����ؾ� �� ���� ���(�߻�ȭ�� �� )�� �����Ѵ�.
	public abstract void absMethod(); //�߻�method
	public abstract String absMethod1(int i); //�߻�method
	
//	public static void main(String[] args) {
//		new AbstractSuper();// �߻�Ŭ������ ��üȭ�� �� ����.
	}//


