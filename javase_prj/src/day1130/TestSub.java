package day1130;

/**
 * TestSuper�� �ڽ� Ŭ����
 * @author SIST
 */
public class TestSub extends TestSuper{
	int p_j;//�̸� ��
	
	@Override
	public void method() {//�̸������� �ϴ��ϴٸ�!
		p_i=400;//�����׾��µ� ����ó��! �ڵ������뼺//�θ��� ����
		p_j=500;//�ڽ��� �� /���� �̸��� ������ �����ϸ� �ڽ��� �� ���
		System.out.println("�ڽ��� method : "+ this.p_i+"/"+this.p_j);
		super.method();//�ڽĲ�����.�״�θ�
		
		System.out.println(this);
//		System.out.println(super);//super�� �ּҴ� ����� �� ����.
	}
	public static void main(String[] args) {
		TestSub ts =new TestSub();// �θ�
		ts.method();//Overriding�����������θ�
	}//main

}//class
