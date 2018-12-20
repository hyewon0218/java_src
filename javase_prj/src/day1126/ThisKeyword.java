package day1126;

/**
 * method�� ȣ���ϴ� ��ü�� �ּҷ� ����Ǿ� ���Ǵ� this.
 * @author SIST
 */
public class ThisKeyword {
	int i;//instance����
	/**
	 * parameter�� �̸��� instance������ �̸��� ���� �� 
	 * this�� ������� �ʰ� parameter�� ���� �ν��Ͻ� ������ ������ ��
	 */
	public void useInstance(int i, ThisKeyword t) {
		t.i=i;//t.i=instance����/ parameter ����(stack)�� ���� instance����(heap)�� �Ҵ��ϰڽ��ϴ�.
		System.out.println("���޹��� ��ü"+t);
	}//useInstance
	/**
	 * �Ķ������ �̸��� �ν��Ͻ������� �̸��� ���� ������ ��ü�� �ѱ�� 
	 * �޾Ƽ� ����Ϸ��� �ڵ��� �������� ����´�. �����ϱ� ���� this�� ����
	 * @param i
	 */
	public void useThis(int i) {
		//this�� method�� ȣ���ϴ� ��ü�� �ּҷ� ��ȯ�Ǵ� Ű����/this=tk
		//�Ű������� ��ü�� ���� �ʿ䰡 ����.(ThisKeyword t �ʿ����!)
		this.i=i;
		System.out.println("method�� ȣ���� ��ü�� �ּ� :"+this);
	}//useThis
	
	public static void test() {
//		this.i=10; //static method�ȿ����� this keyword�� ����� �� ����.
		System.out.println("static method");
	}
	public static void main(String[] args) {
		ThisKeyword tk = new ThisKeyword();
		System.out.println("������ ��ü"+tk);
		tk.useInstance(300, tk);	
		System.out.println("������ ��ü�� �ν��Ͻ� ������ ��"+tk.i);
		System.out.println("=================================================");
		tk.useThis(900);//instance
		System.out.println("this�� ����Ͽ� ������ �ν��Ͻ������� ��"+tk.i);
		
		ThisKeyword.test();//static
		
	}//main

}//calss
