package day0423;

public class TestService2 {
	
	private TestDao td;//������ ���� ���� ��ü�� ����� �� �ֵ��� instance������ ����
	private TestDao2 td2;//������ ���� ���� ��ü�� ����� �� �ֵ��� instance������ ����
	
	public TestService2(TestDao td,TestDao2 td2) {//interface�� ������ ���� ������ �����
		this.td=td;
		this.td2=td2;
		System.out.println("�Ű������� �������� ������ ������ ����");
	}//TestService
	public TestService2() {
		System.out.println("�⺻�����ڸ� ����Ͽ� ��ü ����");
	}//TestService2

	
}//class
