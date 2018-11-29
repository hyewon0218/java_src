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
		1. 출퇴근 시간을 입력받아 아래의 조건으로 출력하세요.
		      출력 :  출퇴근 시간은 최대 2시간의 제한이 있으며 60분을 넘는다면 "장거리", 
		          60분 이하라면 "단거리"를 출력하세요.

		2. 이름, 교통수단과 출퇴근 거리를 입력받아 아래와 같이 출력하세요.
		      교통수단은 "버스,지하철,택시,도보"로 제한한다.
		      버스요금 1200원, 지하철 요금 1250원, 택시요금 3800원 입니다.
		      요금은 10키로 까지는 기본요금, 매 5키로 초과시 마다 100원씩 증가 합니다.

                      출력   :  xxx님 출퇴근 교통수단은 xx이며 거리는 xx 키로 입니다.
		                    편도 이용 요금 xx원이고, 왕복이용 요금 xx원이며, 한달 20일기준
		                    교통비는 총: xxxx원 입니다.  
*/
		// 1. 
		int minute;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("출퇴근 시간 입력 : ");
		minute = sc.nextInt();
		
		if (minute > FLAG_MINUTE * 2) {
			minute = 120;
		}
		
		if (minute > FLAG_MINUTE) {
			System.out.println("[" + minute + "]분, 장거리");
		} else {
			System.out.println("[" + minute + "]분, 단거리");
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
		
		System.out.print("이름 : ");
		name = sc.nextLine();
		
		System.out.print("교통수단 : ");
		transport = sc.nextLine();
		
		System.out.print("출퇴근 거리 : ");
		distance = sc.nextLine();
		dist = Integer.parseInt(distance);
		
		System.out.println("[" + name + "]님. 출퇴근 교통수단은 [" + transport + "]이며, 왕복 거리는 [" + (dist * 2) + 
				"]km입니다.");
		
		switch (transport) {
			case "버스":
				if (dist <= 10) {
					total_fee = bus_fee;
				} else {
					total_fee = bus_fee + (int)(((dist - 10) / 5) * 100);
				}
				break;
			case "지하철":
				if (dist <= 10) {
					total_fee = subway_fee;
				} else {
					total_fee = subway_fee + (int)(((dist - 10) / 5) * 100);
				}
				break;
			case "택시":
				if (dist <= 10) {
					total_fee = taxi_fee;
				} else {
					total_fee = taxi_fee + (int)(((dist - 10) / 5) * 100);
				}
				break;
			case "도보":
				total_fee = 0;
				
		} // end switch
		
		System.out.println("편도 이용요금은 [" + total_fee + "]원이고, 왕복 이용요금은 [" + (total_fee * 2) + 
				"]원이며, 한 달 20일 기준 왕복 교통비는 총 [" + (total_fee * 20 * 2) + "]원입니다.");
		
		sc.close();
	} // main

} // class
