package day1115;
/*
 ����Ʈ������
 <<(left shift) : ��Ʈ�� �������� �а� �о ��ĭ�� �׻� 0���� ä���.
 >>(rignt shift) : ��Ʈ�� ���������� �а� �о ��ĭ�� �ֻ��� ��ȣ��Ʈ�� ���� ����� 0�� ������ 1�� ä���.
 >>>(unsigned shift) : ��Ʈ�� ���������� �а� �о ��ĭ�� �׻� 0���� ä���.
*/

class   Operator3{
	public static void main(String[] args) {

		//method : static method���
		// Ŭ������.method��(��)
		int i=11; 
		System.out.println(Integer.toBinaryString(i));//1011
		System.out.println(Integer.toOctalString(i));//013 8����
		System.out.println(Integer.toHexString(i));//0xb	16����

		i=9;
		System.out.println(i+"<<3 = " + (i <<3));
		i=36;
		System.out.println(i+">>3 = " + (i >>3));
		i=120;
		System.out.println(i+">>>4 = " + (i >>>4));

		i=1;
		System.out.println(i <<31);//�ֻ��� ��ȣ��Ʈ�� ���� 
		i=-1;
		System.out.println(i >>100);// �ֻ��� ��ȣ��Ʈ ���� 
		System.out.println(i >>>1);//�ֻ��� ��ȣ��Ʈ���� 0���� ����


	}//main
}//class


/*00001001
01001000

8+64=72

00100100
00000100
=4

6432
01111000
00000111
=7
*/