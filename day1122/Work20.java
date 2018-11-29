package day1122;
/*�Ʒ��� ������ ó���ϴ� method�� type�� �˸°� �ۼ��ϰ� API�ּ���
������ �� ȣ���Ͽ� ����� �� �� Java Doc�� �����غ�����.
- API�ּ��� � ������ method������ �ּ����� ����Ұ�.

1. �ڽ��� �̸��� ��ȯ�ϴ� method�ۼ�.(���� ��- ��ȯ�� o string , �Ű����� x)
2. ���̸� �Է¹޾� �¾ �ظ� ��ȯ�ϴ�  method �ۼ�.(���� ��- ��ȯ�� o int, �Ű����� o int (byte�� ������int�� �ٲ�))
3. ���ڸ� �Է¹޾� �ش� ������ Unicode ���� ��ȯ�ϴ� method �ۼ�.(���� ��- ��ȯ�� o int , �Ű����� o char)
4. ���ڸ� �Է¹޾� ���ڰ�  ������, ������ ������ ���� �� �ش� ������
   ���ڸ�  ����ϴ� ���� �ϴ� method  �ۼ� (���� �� - ��ȯ�� o void, �Ű����� o int)
5. ȣ���ϸ� �ڽ��� �ּҸ� ����ϴ�  method �ۼ�.(���� �� - ��ȯ��x, �Ű����� x)
6. ģ���� �̸��� �Է¹޾� ����ϴ�  method �ۼ�(ģ���� n�� �Դϴ�.)(���� �� - ��ȯ��x, �Ű����� o Variable Arguments) */
public class Work20 {
	
	public void getName() {
		System.out.println("������");
	}
	public int getYear(int age) {
		return 2018-age+1; 
	}
	public int getUnicode(char c) {
		return (int)c;
	}
	public void printNumToChar(int num) {
		if ((num > 64 && num <91) || (num>96 && num<123))
			System.out.println((char)num);
		else
			System.out.println("�ҹ��ڴ� 65~90, �빮�ڴ� 97~122");	
	}
	
	public void getMyAddress() {
		System.out.println("��õ~��~��~��");
	}
	
//����⵵-����+1
	public void printMyFriendsName(String ... names) {
		for(String name : names) {
			System.out.println(name +" ");	
		}
		System.out.println();
	}			
	public static void main(String[] args) {

		Work20 w20 = new Work20(); 
		
		w20.getName();
		
		System.out.println(w20.getYear(25));
		
		System.out.println(w20.getUnicode('A'));
		System.out.println(w20.getUnicode('z'));
		System.out.println(w20.getUnicode('a'));
		System.out.println(w20.getUnicode('z'));
		
		w20.printNumToChar(50);
		w20.printNumToChar(65);
		w20.printNumToChar(90);
		w20.printNumToChar(97);
		w20.printNumToChar(122);
		w20.printNumToChar(123);
		
		w20.getMyAddress();
		
		w20. printMyFriendsName("ģ��1","ģ��2","ģ��3","ģ��4","ģ��5");
		

		
		
		
		/*		int year = w20.getYear(25);
		System.out.println(year);*/
	}//main

}//class
