package day1119;

public class Work17 {
	/*
	 * 숙제 1. 출퇴근 시간을 입력받아 아래의 조건으로 출력하세요. 출력 : 출퇴근 시간은 최대 2시간의 제한이 있으며 60분을 넘는 다면
	 * "장거리" 60분 이하라면 "단거리"를 출력하세요.
	 * 
	 * 
	 */
	public static void main(String[] args) {
//		int time = Integer.parseInt(args[0]);
//		if(time<120) {
//			if(time>60) {
//				System.out.println("장거리");
//			}
//			else {
//				System.out.println("단거리");
//			}
//		}
//		else {
//			System.out.println("출퇴근 시간은 최대 2시간입니다.");
//		}
/*		 * 2. 이름, 교통수단과 출퇴근 거리를 입력받아 아래와 같이 출력하세요. 교통수단은 "버스,지하철,택시,도보"로 제한한다. 버스요금
		 * 1200원, 지하철 요금 1250원, 택시요금 3800원 입니다. 요금은 10키로 까지는 기본요금, 매 5키로 초과시 마다 100원씩 증가
		 * 합니다. // dist/5!=0
		 * 
		 * 출력 : xxx님 출퇴근 교통수단은 xx이며 거리는 xx 키로 입니다. 편도 이용 요금 xx원이고, 왕복이용 요금 xx원이며, 한달
		 * 20일기준 교통비는 총: xxxx원 입니다.*/
		String Name = args[0];
		String Trans = args[1];
		int Dist = Integer.parseInt(args[2]);
		int charge = 0;
		int Plus_charge = 0;
		if(Trans.equals("버스")||Trans.equals("지하철")||Trans.equals("택시")||Trans.equals("도보")) {
			if(Trans.equals("버스")) {
				charge = 1200;
			}else if(Trans.equals("지하철")) {
				charge = 1250;
			}else if(Trans.equals("택시")){
				charge = 3800;
			}
			
			if(charge>10) {
				Plus_charge = (int)((Dist-10)/5);
				charge= charge+Plus_charge*100;
			}
			System.out.println(Name+"님 출퇴근 교통수단은 "+Trans+"이며 거리는"+Dist+"키로 입니다. 편도 이용 요금 "+charge+"원이고, 왕복이용요금"
						+(charge*2)+"원이며, 한달 20일 기준 교통비는 총: "+(20*charge*2)+"원입니다.");
		}else {
			System.out.println("버스,지하철,택시,도보가 아닙니다");
		}

		
		

	}//main
}// class
