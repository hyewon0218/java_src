package day1203;

/**
 * ����Ŭ����(�ڽ�Ŭ����)���� �ݵ�� �����ؾ��ϴ� ���� ��ϸ�
 * �����ϴ� interface�� ����(������ ������)
 * @author SIST
 */
//interface�� �θ� ������ ���� �� �ִ�.
public interface SuperInterface extends InterA, InterB {//interface���� ���,���߻��
	//constant : ������ ���ó�� ���
//	int i;// ������ �ۼ��� �� ����.//error
	public static final int FALG_VALUE=12;
	
	//�߻�method ����
	//�Ϲ� method�� ���� �� ����.error
//	public void test () {// 
		
//	}
	//�������̽��� ��ӿ��� �߻� method�� Override�� ���� �ʴ´�.
//	@Override
//	public String msg(); //�θ�� �Ȱ��� �� �ѹ� �����ִ°�,,
	//abstract�� ������� �ʾƵ� �ȴ�.
	public void methodA();
	//abstract�� ����ص� �ȴ�.
	public abstract void methodB(int i);
}//interface
