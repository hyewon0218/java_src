package day1121;

/**
 *	while : ���۰� ���� �� �� ����ϴ� �ݺ���<br>
 * 			�ּ� 0�� ���� �ִ� ���Ǳ��� ����<br>
 * ����) while (���ǽ�){<br>
 * 			�ݺ� ���๮��;<br>
 *   	} 
 * @author SIST
 */
public class TestWhile {

	public static void main(String[] args) {
		int i=0;//�ʱⰪ
		
	while(i<10) {//���ǽ�
		System.out.println("i="+i);//�ݺ����๮��
		i++;//������
	}//end while
	
		System.out.println("-----------------------------------------------");
		
		//���� �Է¹޾� 2~9�� ���̶�� ������ ���
		int input = Integer.parseInt(args[0]);
		if (input > 1 && input < 10) {
		 i=1;
			while(i < 10) {
				System.out.println(input + "*"+i+"="+(input*i));
				i++;
			}
		}
		
		// ���� loop
		i=0;
		while(true) {
		System.out.println("���� loop");	
		if(i==5) {
			break;
		}//end if
		i++;
		}//end while
		
	}//main
	

}//class
