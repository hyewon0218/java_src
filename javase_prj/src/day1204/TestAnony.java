package day1204;

/**
 * �������̽��� method�� �Ű������� �� �����ϰ� ����ϴ� ���.<br>
 * 
 * @author SIST
 */
public class TestAnony {
	
	public void useAnonInter(AnonyInter ai) {
		System.out.println(ai.getMsg()+" "+ai.getName());
	}
	
	public static void main(String[] args) {
//		AnonyInter ai=new AnonyInter();// �������̽��� ��üȭx
		//�������̽��� �Ű��������� �� 
		//1. �������̽��� ������ Ŭ������ ����.
		//2. ����Ŭ������ ��ü����
		AnonyInter ai =new AnonyImpl();//is a 
//		AnonyImpl ai =new AnonyImpl();//����
		//3. �Ű������� ���� method�� ȣ���ϱ� ���� ��ü ����
		TestAnony ta= new TestAnony();
		//4. method�� ȣ��
		ta.useAnonInter(ai);
		System.out.println("---------------------anonymous innerclass--------------------------");
		// anonymous inner class�� ����ϸ� Ŭ������ ���� ���� �ʿ䰡 ����.
		
		ta.useAnonInter(new AnonyInter() {
			@Override
			public String getName() {
				return "������"+test()
				;
			}
			@Override
			public String getMsg() {
				return "�´���";
			}
			public String test() {
				return "�ڽ� method";
			}
		});
	}//main

}//class
