package day1119;

/**
 * if~else : �� �� �ϳ��� �ڵ带 �����ؾ� �� �� ���<br>
 * ���� ) if(���ǽ�){<br>
 * 				���ǿ� ���� �� ������ �����;<br>
 * 			}else{<br>
 * 				���ǿ� ���� ���� �� ������ �����;<br>
 * 			} 
 * 
 * @author SIST
 */
public class TestIfElse {

	public static void main(String[] args) {
		int i=19; 
		//������ �����ϴ� ���� �������� ��������� �Ǵ�	
		System.out.print(i+"��(��)");
		if(i < 0) {
			System.out.println("����");
		}else {
			System.out.println("���");
		}//end if
		//������ �����ϴ� ���� Ȧ������ ¦�������� �Ǵ�
		// �����ϴ� ����� �� ���̶�� {�� ������ �� �ִ�.
		if(i % 2 ==0) {
			System.out.println("¦��");
		}else {
			System.out.println("Ȧ��");
		}//end if
		
		// �Է��� ���� 3�� ������ "¦"�� ����ϰ� �׷��� �ʴٸ�
		//�Է��� ���� ����ϼ���.
		int j=10;
		if(j % 3 ==0) {
			System.out.println("¦");
		}else {
			System.out.println(j);
		}
		
		
		
		
		
	}//main

}//class
