package day0423;

public class TestService {
	
	private TestDao td;//������ ���� ���� ��ü�� ����� �� �ֵ��� instance������ ����
	
	public TestService(TestDao td) {//interface�� ������ ���� ������ �����
		this.td=td;
		System.out.println("������ ������ ����");
	}//TestService
	public TestService() {
		System.out.println("�⺻�����ڸ� ����Ͽ� ��ü ����");
	}
	
	//method ������ ����: �ݵ�� �⺻ �����ڰ� �����ؾ��Ѵ�.
	public void setTd(TestDao td) {
		this.td=td;
	}//setTd
	public TestDao getTd( ) {
		return td;
	}//getTd
	
}
