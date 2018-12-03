package day1203;

/**
 * �߻�Ŭ������ �θ�� �ϴ� �ڽ�Ŭ����
 * �ڽ�Ŭ������ �ݵ�� �θ�Ŭ������ �߻� method�� �ݵ�� Override �ؾ��Ѵ�.
 * @author SIST
 */
public class AbstractSub extends AbstractSuper{
	
	public void subMethod() {
		System.out.println("�ڽ� method!!!!!");
	}
	
	@Override
	//Override ��Ģ : ���������ڴ� �޶� �ǰ�(������) ��ȯ��, method ��
	//�Ű������� ���ƾ� �Ѵ�.
	public  void absMethod() {
		//�߻�method�� super�� ȣ���� �� ����. 
//		super.absMethod(); Error
		System.out.println("Override�� �ڽ��� absMethod");
	}
	@Override
	public  String absMethod1(int param_i) {
		return String.valueOf(param_i).concat("- �ڽ�");//valueof:���ڿ��� �ٲ�!
	}
	
	
	public static void main(String[] args) {
		//�ڽ�Ŭ������ ��üȭ�Ǹ� �߻�Ŭ������ ��üȭ�� �ȴ�.
		AbstractSub as =new AbstractSub();//�θ��� ������ ���
		//�ڽ�Ŭ������ ��üȭ : �θ��� ����, method, �ڽ��� ����, method
		as.i=12;//�θ��� ����
		as.method();//�θ� method
		
		//Override�� method �ڽĿ��� ������ ���̹Ƿ� �ڽ��� methodȣ��
		as.absMethod();//���� �̸����� �����Ѵٸ� �ڽ��� method
		System.out.println(as.absMethod1(3));//�ڽ��� method
		as.subMethod();
		
		//is a ������ ��üȭ : ��ü ������ 
		//�θ�Ŭ������ ��ü��=new �ڽ��ǻ�����();
		AbstractSuper as1=new AbstractSub();//���� �̸��� method �پ��ϰ�
		//�θ��� �ڿ�ȣ�� ����/�ڽĿ�����x
		as1.i=100;
		as1.method();
		//Override�� method�� �����Ѵٸ� �ڽ��� method ȣ���� �� �ִ�.
		//�߻� method�� body�� ������ ȣ���ϰ� �Ǹ� �ڽ��� method�� ȣ��ȴ�.
		as1.absMethod();
		System.out.println(as1.absMethod1(2018));
		
		//is a ����� ��üȭ�ϸ� �ڽ��� ���� method�� ȣ�� �Ұ�(Overriding�Ѱ͸�ȣ�Ⱑ��!)
//		as1.subMethod();
	}//main

}
