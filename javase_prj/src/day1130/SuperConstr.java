package day1130;

public class SuperConstr {
	int i;
	
	public SuperConstr() {
		this(100);
		
		System.out.println("�θ��� �⺻������");
	}//�⺻������ ������ �ڽĿ��� ������!
	public SuperConstr(int i) {
		//object�θ�
		this. i=i;
		System.out.println("�θ��� ���ڻ�����"+i);
	}
}
