package day1203;

/**
 * interface�� �����ϴ� class (�ڽ� Ŭ�����̰� interface���� ��� �߻�method�� Override�ϴ� Ŭ����)
 * ���� interface�� �θ� interface�� �����ٸ� �������� �ڽ�Ŭ���������� 
 * ��� �߻� method�� �����ؾ� �Ѵ�.
 * @author SIST
 */
public class InterfaceImpl implements SuperInterface {

	@Override	
	public String msg() {//interA
		return "������ ȭ����";
	}
	@Override
	public String msgB() {//interB
		return "������ ������";
	}
	
    @Override
	public void methodA() {//SuperInterface
		System.out.println("methodA");
	}

	@Override
	public void methodB(int i) {//SuperInterface
		System.out.println("methodB");
		
	}
	public void test() {
		
	}
	
	public static void main(String[] args) {
		//�ڽ� Ŭ������ ��üȭ : ��� method�� ȣ���� �� �ִ�.
		//ii.msg,ii.msgB(),ii.methodA(),ii.methodB(), ii.test()
		InterfaceImpl ii=new InterfaceImpl();
		ii.methodB(12);

		//is a ������ ��üȭ(���������� �߿�!)
		//SuperInterface�� ��üȭ�� �ϸ� Override�� method�� ȣ��
		// �θ��� method�� ��� ȣ�� ���� 
		//si.msg(), si.msgB(), si.methodA(), si.methodB() /test�� �θ� �� ����.
		SuperInterface si=new InterfaceImpl();
		System.out.println(si.msg());
		
		//InterA�� ��üȭ�ϸ� ia.msg�� ȣ�� ����.
		InterA ia=new InterfaceImpl();
		System.out.println(ia.msg());
		
		InterB ib=new InterfaceImpl();
		System.out.println(ib.msgB());
		
		//Object o=new InterfaceImpl();// object�� ��� �ڽ��� �� ������ �� �ִ�.
		//interface�� ��üȭ���� �ʴ´�.
//		interA ia1=new InterA();
//		SuperInterface si1= new SuperInterface(); //�������̽��� �ڽ��� ���ؼ��� ��ü�� ���������.
	}// main
}// class
