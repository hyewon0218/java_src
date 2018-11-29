package day1127;

/**
 * ���ڿ� ������� �ּҸ� �����ϰ�, ���ڿ��� �ٷ�� ����� ����ϴ�
 * String class ���
 * java���� �����ϴ� Ŭ������ �̸��� ���� ���� Ŭ������ �̸��� ���ٸ� 
 * ���� ���� Ŭ������ ���� ����ϰ� �ȴ�.
 * JAVA���� �����ϴ� Ŭ������ ����� ������ "FULL PATH: ��Ű������ ���
 * ����Ͽ� Ŭ������ ����ϴ� ��"�� ����ؾ��Ѵ�.
 * ��Ű����.Ŭ������
 * @author SIST
 */
public class UseString {

	public static void main(String[] args) {
		System.out.println("�ȳ�");
//		�⺻�� ���� ���.	String s="���ڿ�";
		String str="AbcdEfg";
//		������ ���� ���. String s1=new String("���ڿ�");
		String mail=new String("esc0218@naver.com");
		System.out.println(str);
		System.out.println(mail);
		
		System.out.println(str+"�� ����"+str.length());
		System.out.println(mail+"�� ����"+mail.length());
		
		System.out.println(str+ "��� �빮��"+str.toUpperCase());
		System.out.println(str+ "��� �빮��"+str.toLowerCase());
		//"AbcdEfg"
		// 0 123456
		//indexOf�� L->R�����ϸ� ���� ó�� ã������ ���ڿ��� �ε����� ��´�.(���ڰ� �ƴ� ���� �ִ� ������ ����)
		System.out.println(str+"���� 'd'�� �ε��� :"+str.indexOf("dEf"));
		System.out.println(str+"���� 'z'�� �ε��� :"+str.indexOf("z"));//���� ���ڴ� -1
		
		
		System.out.println(mail+"���� \"@\"�� �ε��� :"+mail.indexOf("@"));//
		//lastIntexOf R->L�� ���� ���� ó�� ã������ ���ڿ��� �ε����� ��´�.
		str="AbcdEfAg";
		System.out.println(str+"���ڿ����� �ڷκ��� 'A'�� �ε��� :"+str.indexOf("A"));//
		System.out.println(str+"���ڿ����� �ڷκ��� 'A'�� �ε��� :"+str.lastIndexOf("A"));//
		//Ư�� �ε����� ���� ���
		char temp=str.charAt(2);
		System.out.println(str +"���� 2��° �ε����� �ش��ϴ� ����"+temp);
		
		//�ڽĹ��ڿ� �ڸ���
		//AbcdEfAg
		//01234567 (f�ڸ��� null)	
		System.out.println(str+"���� �ε����� 2~5��°�� �ش��ϴ� ���ڿ�"+str.substring(2,6));
		//esc0218@na v e   r  .  c o m
		//01234567 891011 1213141516<-String index
		System.out.println(mail+"���� ���� �ּҸ� ���"+mail.substring(0,mail.indexOf("@")));
		System.out.println(mail+"���� ������ �ּҸ� ���"+mail.substring(mail.indexOf("@")+1,mail.length()));
		//substring�� �����ε����� ������ ������ �߶󳽴�.
		System.out.println(mail+"���� ������ �ּҸ� ���"+mail.substring(mail.indexOf("@")+1));
		
		//�յڰ��� �ڸ���
		str="   A BC   ";
		System.out.println("["+str+"]���� �յڰ��� ����["+str.trim()+"]");
		
		//���ڿ� ���̱�
		str="ABCD";
		String str1=str.concat("Efg");
		String str2=str+"Efg";
		System.out.println(str1);
		System.out.println(str2);
		
		//���ڿ��� ������ ��
		str="������";
		System.out.println(str+"��(��)"+(str.equals("������")?"����":"���"));
		
		//���ڿ��� �� ���ڿ��� �����ϴ��� 
		str="�Ǿ���";
		if(str.startsWith("����")) {
			System.out.println("���� ����Ͻ� �� �����ϴ�.");
		}else {
			System.out.println(str);
		}//else
		
		str="����� ������";
		str1="������ �ȴޱ�";
		
		System.out.println(str1+"��(��)"+(str1.startsWith("����")?"������Դϴ�.":"������ �ƴմϴ�."));
		//Ư�� ���ڿ��� ��������
		str="����� ������ ���ﵿ";
		str1="��⵵ ������ ������";
		System.out.println(str1+"��(��)"+(str1.endsWith("��")?"����":"�ð�"));
		
		//ġȯ: ���ڿ� ���� ��� ���ڿ��� ã�Ƽ� ġȯ
		str="�� ���� �Ǿ����ε� �� ���� �� �����!";
//		System.out.println(str.replaceAll("����", "**"));//�ߤӾ�� ����ȵ�
		//method �� �����ؼ� ȣ���ϴ� ���� method chain
		System.out.println(str.replaceAll("��", "*").replaceAll("��","*"));//��ȯ��. method
		
		
		str="   A BC   ";
		System.out.println(str.replaceAll(" ", ""));
		
		int i=27;
//		str=1; int�� String���� �Ҵ�� �� ����.
		//�⺻�� ���������� ���ڿ��� ��ȯ
		str=String.valueOf( i );
		System.out.println( str );
		double d= 11.27;
		str=d+"";
		System.out.println( str );
		
		str="11";
		System.out.println( str.isEmpty() );
		
		//��ü ������ ���� �ʾ��� �� �� Ŭ������ �����ϴ� method�� 
		// ����� �� ����. error
//		str=null;
//		System.out.println(str.isEmpty());
		
		
		////////////////////////////11-28-2018 split ��� �ڵ� �߰�/////////////////
		String data =
		"������, ������, ���ü�~������~�����.������,������,������.������";
		//split�� �ѹ��� �ϳ��� ���ڷ� �����Ͽ� �ڸ���.
		String[] arr=data.split("[.]");//.�� �׳� ���� ���е��� �ʴ´�.[]��� ����. 
		System.out.println("���е� �迭 ���� ���� :"+arr.length);
		for(String name : arr) {
			System.out.println(name);
		}
		
		
		
		
	}//main

}//class
