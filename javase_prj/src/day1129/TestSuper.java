package day1129;

import javax.swing.text.TabExpander;

/**
 * ��� ������ �θ�Ŭ���� : ��� �ڽ��� ������ �� ���� Ư¡�� ���� 
 * �θ𿡰� ���ǵ� �ڵ�� �ڽĿ��� ����� �� �ִ�.
 * @author SIST
 */
public class TestSuper {

	public int pub_i;//��� �ִ� �ڽ��̵� �ڽĿ��� ��밡��
	protected int pro_i;//���� ��Ű���� �ڽ�, �ٸ� ��Ű���� �ڽĿ��� ��� ����
	private int pri_i;//�θ�Ŭ���� �ȿ����� ��밡��
	int def_i;//���� ��Ű���� �ڽĿ��� ��밡��, ��Ű���� �ٸ��ٸ� ���Ұ�
	
	public TestSuper() {
		System.out.println("�θ�Ŭ���� �⺻������");
	}//
	public void superMethod() {
		System.out.println("�θ�Ŭ������ method");
	}
}//class
