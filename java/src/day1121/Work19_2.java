package day1121;

/*2.  do~while�� ����Ͽ� �Ʒ��� ������  *�� ����ϴ�  static method��
�ۼ��Ͽ� ȣ���ϼ���.
 	*
    **
    ***
    *****/
public class Work19_2 {

	public static void dot() {
		int i=0;
		do {
			int j = 1;
			do {
				System.out.println("*");
				j++;
			} while (i > j);
			i++;
		}while (i < 5);
		
		
		 
	}

	public static void main(String[] args) {

		Work19_2.dot();
	}// main

}// class
