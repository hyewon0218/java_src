package day1206;

import java.text.DecimalFormat;

/**
 * DecimalFormat
 * ���ڸ� ������ ���ڿ��� ����
 * @author SIST
 */
public class UseDecomalFormat {
	
	public UseDecomalFormat() {
		int  temp=2018;
		System.out.println(temp);
		
		DecimalFormat df =new DecimalFormat("0,000,000,000");
		DecimalFormat df1 =new DecimalFormat("#,###,###,###");
		
		System.out.println("0���: "+df.format(temp));//0���� ä����
		System.out.println("#���: "+df1.format(temp));
		
		DecimalFormat df2 =new DecimalFormat("#,###.00");//�Ҽ������� ǥ������(0�̳�#)
		//�Ǽ� �ڸ����� ����ϸ� ������ ���ڸ��� ���� �ݿø� ����̶�� �ݿø��� �����
		// �����ش�.(0.065->0.07)
		System.out.println("�Ҽ��ڸ��� ǥ�� : "+df2.format(201812.066));
	}
	
	public static void main(String[] args) {
		new UseDecomalFormat();
	}//main

}//class
