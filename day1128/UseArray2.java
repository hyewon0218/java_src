package day1128;

/**
 * ��� ���� ������ ������ �迭 
 * @author SIST
 */
public class UseArray2 {
	/**
	 * ������ �������� 2���� �迭 ���
	 */
	public void refType() {
		//1. ����) �������� [][] �迭��=null;
		int[][] arr=null;
		//2. ����) �迭��=new ��������[���� ����][���� ����];
		//��� ���� ���� �ʱ�ȭ
		arr=new int[3][4];
		System.out.println("���� �� : "+arr.length+",���� �� :"+arr[0].length);
		//1+2) ��������[][] �迭��=new ��������[���� ��][���� ��];
		int[][] arr1=new int[4][5];
		System.out.println("���� �� : "+arr1.length+",���� �� :"+arr1[0].length);
		
		//3. �� �Ҵ�)�迭��[���� ��ȣ][���� ��ȣ]=��;
		arr[0][0]=10;
		arr[1][1]=20;
		arr[2][2]=30;
		
		//4. �� ���) �迭��[���� ��ȣ][���� ��ȣ]
		System.out.println(arr[0][0]+"/"+arr[0][1]+"/"+arr[0][2]);
		
		//��� ���� �� ���
		for(int i=0; i < arr.length; i++) {//���� �ε���
			for(int j=0; j < arr[i].length ; j++) {//���� �ε���
				System.out.printf("arr[%d][%d]=%-4d",i,j,arr[i][j]);
			}//for
			System.out.println();
		}//for
		
		//2���� �迭�� �� ���� ������ �迭�� �̷���� �ִ�.
		for(int[] temp : arr1) {
			//1���� �迭�� ����  ���� ������������ �̷���� �ִ�.
			for(int val : temp) {
				System.out.print(val+"\t");
			}
			System.out.println();
		}
		
	}//refType
	/**
	 * �⺻�� ������ ���
	 */
	public void priType() {
		//�౸�� ��ȣ�� ���� ���� �����ȴ�. 
		//1.����) ��������[][] �迭��={{��,,,,,},{,,,,},{,,,}};
		int[][] arr= {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
			System.out.println("��: "+arr.length+", �� : "+arr[0].length);
		//2.���Ҵ�)
			arr[0][0]=100;
		//r3.����� )
			System.out.println(arr[0][0]+"/"+arr[0][1]);
			
			for(int i=0; i < arr.length;i++) {//��
				for(int j=0; j < arr[i].length;j++) {//��
					System.out.printf("arr[%d][%d]=%-4d",i,j,arr[i][j]);
				}
				System.out.println();
			}
	}//priType
	public static void main(String[] args) {
		UseArray2 ua2=new UseArray2();
		ua2.refType();
		System.out.println("-----------------------------");
		ua2.priType();
	}//main

}//class
