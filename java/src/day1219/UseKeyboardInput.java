package day1219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ����ڰ� �Է��� Ű������ ���� ó���ϴ� System.in 
 * @author SIST
 */
public class UseKeyboardInput {

	public UseKeyboardInput () {
		
		System.out.println("�ƹ�Ű�� ������ ����");
		
		//8bit stream�� 16bit stream�� ����
		
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));
		try {
			//�Է� �� �� ���� �Է� ���� �ϳ� �ޱ�.
//			int input=System.in.read();
//			System.out.println("�Է°�"+input); 
			
			//�Էµ� ��� ���ڿ� �ޱ� : �ѱ��� ���� �� ����.
//			int input=0;
//			while(true) {
//				input=System.in.read();
//				System.out.print((char)input);
//				
//				if(input==13) {
//					break;
//				}
//			}
			//16bit stream�� ����Ͽ� �Էµ����͸� �ٴ����� �о���δ�.
			String str=br.readLine();
			
			System.out.println(str);
			
			//��Ʈ������� �������� ��Ʈ���� ������ ���´�.
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new UseKeyboardInput();
	}//main

}//class
