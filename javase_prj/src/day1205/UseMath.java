package day1205;

/**
 * Math : ��ü�� �������� �ʰ� ����ϴ� Ŭ����
 * @author SIST
 */
public class UseMath {

	public UseMath() {
//		Math m=new Math();//��ü���������ʴ´�.
		int i=-12;
		System.out.println(i+"i�� ���밪 :"+Math.abs(i));
		System.out.println(Math.ceil(10.1));
		System.out.println(Math.round(10.5));//�Ҽ�������ó���ڸ������� �ݿø�.
		System.out.println(Math.floor(10.45));//�Ҽ�������ó���ڸ������� �ݿø�
		double d=Math.random();
		System.out.println("�߻��� ���� : "+d);
		System.out.println("������ ������ ���� : "+d*5);
		System.out.println("������ ������ �������� ���� : "+(int)(d*5));
		
		//A(65)-Z(90)�� �ϳ��� ���ڸ� ��ȯ�ϴ� ��.
		System.out.println((char)((int)(d*26)+65));
	}
	
	public char[] createPassword () {
		char[] tempPass=new char[8];
		//�����ڴ빮��(65~90), �ҹ���, ����(48~57)�� �̷���� ������ ��й�ȣ 8�ڸ��� �����Ͽ� ��ȯ�ϴ� ��
		String flag="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		
		for(int i=0; i < tempPass.length ; i++) {
			tempPass[i]=flag.charAt((int)(Math.random()*flag.length())); 
			System.out.print(tempPass[i]);
		}
		return tempPass;
	}
	
	public static void main(String[] args) {
		new UseMath().createPassword();
		
	}//main

}//class
