package day1119;

/**
 * switch~case : ������ ���� ��(JDK1.7�������ʹ� ���ڿ��� �� ����)<br>
 * ����) switch(������){<br>
 * 				case ��� : ���๮��;<br>
 * 				case ��� : ���๮��;<br>
 *						.<br>
 *						.<br>
 *				default : ��ġ�ϴ� ����� ���� �� ���๮��;<br>
 *				} 
 * @author SIST
 */
public class TestSwitchCase {

	public static void main(String[] args) {
	//	String i="1";  //JDK1.7 +���� ��� ����
		int i=0;
		
		//switch�� �ԷµǴ� ������ ���������� byte,short,int,char,String
		switch(i) {
		//case�� �ԷµǴ� ������ ���� �ٸ� ����� ������ ������.
		case 0 : System.out.println("����");
		case 1 : System.out.println("��ħ");
		case 2 : System.out.println("����");
		default : System.out.println("����");
		}//end switch
	}//main

}//class
