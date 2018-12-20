package day1129;

public class UseWork {

	public UseWork() {// 기본생성자
		int con_s = 0;
		int sumage = 0;
		int oldestage=0;
		String oldName="";
		
		Work22[] dataArr = null;
		dataArr = new Work22[7];

		dataArr[0] = new Work22("이재찬", "서울시 강남구 역삼동", 28, "남자");
		dataArr[1] = new Work22("이재현", "서울시 동대문구 답십리동", 27, "남자");
		dataArr[2] = new Work22("김정운", "수원시 영통구 영통동", 26, "남자");
		dataArr[3] = new Work22("정택성", "서울시 구로구 구로동", 27, "남자");
		dataArr[4] = new Work22("정택순", "경기도 부천시 부천동", 29, "여자");
		dataArr[5] = new Work22("이재찬", "서울시 강남구 역삼동", 26, "남자");
		dataArr[6] = new Work22("이재순", "서울시 광진구 광나루동", 27, "여자");

//		Work22 temp = dataArr[0];

		for (Work22 tempWork : dataArr) {//tempWork는 Work22의객체!!!!!
			sumage+=tempWork.getAge();
			if (tempWork.getAdd().contains("서울")) {
					con_s++;
			}
			if(oldestage < tempWork.getAge() ) {
				oldestage=tempWork.getAge();
				oldName=tempWork.getName();
			}
			System.out.println(
					tempWork.getName() + "/" + tempWork.getAdd() + "/" + tempWork.getAge() + "/" + tempWork.getGen());
		}
		System.out.println("서울시 거주자 : "+con_s);
		System.out.println("나이의 합 : "+sumage);
		System.out.println("가장 나이 많은 사람 : "+ oldName);
	}
	// boolean contain
	// temp.get.,,,
//	=s.cotains("서울");
//	
// 서울 포함, 나이합(누적)	

	public static void main(String[] args) {
		new UseWork();
	}

}
