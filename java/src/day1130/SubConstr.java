package day1130;

public class SubConstr extends SuperConstr{
	int i;
	
	public SubConstr() {
		//}������ ȣ���Ѱ����ο�
		super();
		System.out.println("�ڽ��� �⺻������");
	}
	public SubConstr(int i) {
		this();
		
		System.out.println("�ڽ��� ���ڻ�����"+i);
	}
}
