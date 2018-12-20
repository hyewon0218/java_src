package day1119;

import java.util.Scanner;

/**
 * Work17<br>
 * @author owner
 */
public class Work17 {
	public static final int FLAG_MINUTE = 60;
	
	public static void main(String[] args) {
/*
		1. ����� �ð��� �Է¹޾� �Ʒ��� �������� ����ϼ���.
		      ��� :  ����� �ð��� �ִ� 2�ð��� ������ ������ 60���� �Ѵ´ٸ� "��Ÿ�", 
		          60�� ���϶�� "�ܰŸ�"�� ����ϼ���.

		2. �̸�, ������ܰ� ����� �Ÿ��� �Է¹޾� �Ʒ��� ���� ����ϼ���.
		      ��������� "����,����ö,�ý�,����"�� �����Ѵ�.
		      ������� 1200��, ����ö ��� 1250��, �ýÿ�� 3800�� �Դϴ�.
		      ����� 10Ű�� ������ �⺻���, �� 5Ű�� �ʰ��� ���� 100���� ���� �մϴ�.

                      ���   :  xxx�� ����� ��������� xx�̸� �Ÿ��� xx Ű�� �Դϴ�.
		                    �� �̿� ��� xx���̰�, �պ��̿� ��� xx���̸�, �Ѵ� 20�ϱ���
		                    ������ ��: xxxx�� �Դϴ�.  
*/
		// 1. 
		int minute;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("����� �ð� �Է� : ");
		minute = sc.nextInt();
		
		if (minute > FLAG_MINUTE * 2) {
			minute = 120;
		}
		
		if (minute > FLAG_MINUTE) {
			System.out.println("[" + minute + "]��, ��Ÿ�");
		} else {
			System.out.println("[" + minute + "]��, �ܰŸ�");
		}
		
		// 2.
		System.out.println("------------------------------");
		
		String name;
		String transport;
		String distance;
		int dist;
		int total_fee = 0;
		int bus_fee = 1200;
		int subway_fee = 1250;
		int taxi_fee = 3800;
		
		sc.nextLine();
		
		System.out.print("�̸� : ");
		name = sc.nextLine();
		
		System.out.print("������� : ");
		transport = sc.nextLine();
		
		System.out.print("����� �Ÿ� : ");
		distance = sc.nextLine();
		dist = Integer.parseInt(distance);
		
		System.out.println("[" + name + "]��. ����� ��������� [" + transport + "]�̸�, �պ� �Ÿ��� [" + (dist * 2) + 
				"]km�Դϴ�.");
		
		switch (transport) {
			case "����":
				if (dist <= 10) {
					total_fee = bus_fee;
				} else {
					total_fee = bus_fee + (int)(((dist - 10) / 5) * 100);
				}
				break;
			case "����ö":
				if (dist <= 10) {
					total_fee = subway_fee;
				} else {
					total_fee = subway_fee + (int)(((dist - 10) / 5) * 100);
				}
				break;
			case "�ý�":
				if (dist <= 10) {
					total_fee = taxi_fee;
				} else {
					total_fee = taxi_fee + (int)(((dist - 10) / 5) * 100);
				}
				break;
			case "����":
				total_fee = 0;
				
		} // end switch
		
		System.out.println("�� �̿����� [" + total_fee + "]���̰�, �պ� �̿����� [" + (total_fee * 2) + 
				"]���̸�, �� �� 20�� ���� �պ� ������ �� [" + (total_fee * 20 * 2) + "]���Դϴ�.");
		
		sc.close();
	} // main

} // class
