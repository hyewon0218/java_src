package day1120;

/**
 * for : ���۰� ���� �� �� ����ϴ� �ݺ���<br>
 * ���� : for(���۰� ; ���� ; ����|���ҽ�){<br>
 * 				�ݺ� ���� ����;<br>
 * @author SIST
 */
public class TestFor {

	public static void main(String[] args) {
		//0�������� 10���� ���� ������ �ݺ������ϴ� for
		
		for(int i=0 ; i < 10 ; i++) {
			System.out.println(i + "�� �ȳ�");
		}//end for
		
		//1�������� 100���� ¦���� �ݺ� ���� for
		for(int i=1 ; i < 101 ; i++) {
			if (i%2==0) {
				System.out.print(i+ " ");
			}//end if
		}//end for
		System.out.println();//�ٺ���
		
		// 1�������� 100���� Ȧ���� ��� 
		int cnt=0;
		//��.���ҽ��� ������ ���� ��ȭ��Ű�� ������ų �� �ִ� ��� �����ڸ� ����� �� �ִ�.
		for(int i=1 ; i < 101 ; i+=2) {
			cnt++;
			System.out.print(i+ " ");
		}//end for
		System.out.println("\n"+cnt+"��");//�ٺ���
		
		//1~100���� ����ϱ� 3�� ������� ���ڴ�� "¦"�� ���
		for (int i=1; i < 101; i++) {
			if(i%3==0) {
				System.out.println("¦");
				continue;
			}
			System.out.println(i);
		}
	// 1~100������ �� ���	
		
		int sum=0;
		for (int i=1; i<101 ; i++) {
			sum+=i;
		}
		System.out.println(sum);
	
		// A~Z���� ��� 
		for (int c=65; c < 91; c++) {
			System.out.println((char)c);
		}//end for
		
		//������2��
		for(int i=1; i < 10 ; i++) {
			System.out.println("2 * "+i+" = "+ (2 *i));
		}//end for
		
	}//main

}//class
