package day1114;
/*
��������ȯ : 
������ ���������� �Ͻ������� ��ȯ�Ͽ� ����ϴ� ��.
*/

class UseCasting{ 

	public static void main(String[] args) {
		byte b1=10,b2=20;//�ڵ�����ȯ
		byte result =(byte)(b1+b2);
	//������ ����� int�� �ڵ�����ȯ �Ǵ� ���� byte�� ��������ȯ 
		System.out.println(b1+" + " +b2+ " = "+result);
		
		
	//������ �����x casting��	
		double d=11.14;
		float f=(float)d;
		System.out.println("double : "+d+",float :"+f);

		float f1=(float )2018.11;//����� ��� ����
		System.out.println("float : "+f1);
		//long l=(long)2147483648;//������� literal���� ũ�ٸ� casting�� �����ϱ� ���� Error�߻�
//����Ʈ���� ������ ���´޶� 
		int i=(int)f1;//���ս� �߻�(�Ǽ����� ���� ��� ����� �Ҵ�)
		System.out.println("int : "+i+",foalt : "+f1);

		char c='A';
		System.out.println(c +"�� unicode(ASCII code)�� "+(int)c);

		//����(�⺻�� <->������) �ٸ��� ��������ȯ�� ���� �ʴ´�.
		//String s="11"; //������
		//int i=(int)s;//�⺻��

	  //boolean���� boolean�� ������ ��ȯ����. �ٸ������� �ȹٲ�
	  boolean b=true;
	  //i = (int)b;//error
	    boolean bc= (boolean)b;
		System.out.println(bc);
	}//main
}//calss
