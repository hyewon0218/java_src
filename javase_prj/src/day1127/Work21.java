package day1127;

//1. 주민번호를 입력받아 처리하는 프로그램 작성
//	 각 작업은 method로 정의하고 호출하여 결과를 받아서 처리
//	1-1 생성자는 주민번호를 받아 instance변수에 할당한다.
//  인스턴스 변수의 값을 사용
//  1-2 주민번호의 길이를 체크하여 14자가 아니면 false 반환 checkssn
//  1-3 주민번호의 6번째 자리가 '-'가 아니면 false 반환
//  1-4 주민번호의 유효성 검증(각 자리에 2345 곱해서....)을 하여 유효하면 true, 그렇지 않으면 false 반환
//				각 자리에 234567892345 를 곱한 값을 더하여 11로 나눈 나머지 값을 얻고 11에서 그값을 빼고
//				10으로 나눈 나머지가 주민번호의 끝자리와 같다면 true, 그렇지 않으면 false
//  1-5 생년월일을 반환하는 일 "1988-11-11"
//  1-6 나이를 반환 하는 일 ex)25 현재년도-태어난해+1
//	1-7 성별을 반환 ex) 남,여 
// 1-8  내국인/외국인 반환
//       012349      56(1900's)78(2000's)
// 1-9  띠를 반환 ex) "양띠"
public class Work21 {
	
	String ssn;
	
	
	public boolean checkSsn() {
		if(ssn.length()!=14) {
			return false;
		}	else {
			return true;
		}
	}
	
	public boolean checkSsn1() {
		if(ssn.charAt(6)!='-') {
			return false;
		}else {	
			return true;
		}
	}
	public boolean validSsn() {
		int checkNum =0;
		
		int j =2;
		
		
		for(int i=0; i<6;i++) {
			checkNum+=Integer.parseInt(ssn.substring(i, i+1))*j;
			j++;
		}
		
		for(int i=7; i<ssn.length()-1;i++) {
			checkNum+=Integer.parseInt(ssn.substring(i, i+1))*j;
			j++;
			if(j>9) j=2;
		}
		
		checkNum %=11;
		checkNum =11- checkNum;
		checkNum %=10;
		
		if(Integer.parseInt(ssn.substring(13))==checkNum) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	public Work21(String ssn) {
		this.ssn=ssn;
	}
	public	 String getBirth() {
		
		int flag= Integer.parseInt(ssn.substring(7, 8));
		String birth;
		
		if (flag ==1 || flag==2 || flag ==5 || flag==6) {
			birth =19+ssn.substring(0,2)+"-"+ssn.substring(2,4)+"-"+ssn.substring(4,6);
		}else {
			birth =20+ssn.substring(0,2)+"-"+ssn.substring(2,4)+"-"+ssn.substring(4,6);
			
		}
		
		return birth;
	}
	public int getAge() {
		int flag= Integer.parseInt(ssn.substring(7, 8));
		String birthYear;
		int age;
		
		
		if (flag ==1 || flag==2 || flag ==5 || flag==6) {
			birthYear =19+ssn.substring(0,2);
			age = 2018-Integer.parseInt(birthYear)+1;
		}else {
			birthYear =20+ssn.substring(0,2);
			age = 2018-Integer.parseInt(birthYear)+1;
			
		}
		return age;
	}
	public char getGender() {
		int flag = Integer.parseInt(ssn.substring(7,8));
			
		if (flag == 1 || flag == 3 || flag == 5 || flag == 7) {
			return '남';
		} else {
			return '여';
			}
		}
	public String checkNation() {
		
		int flag = Integer.parseInt(ssn.substring(7,8));
		
		if (flag == 0 || flag == 1 || flag == 2 || flag == 3 || flag == 4 || flag == 9) {
			return "내국인";
		} else {
			return "외국인";
		}
	}
	private String getChineseZodiac() {
		
		int flag = Integer.parseInt(ssn.substring(7,8));
		String birthYear;
		
		if (flag == 1 || flag == 2 || flag == 5 || flag == 6) {
			birthYear = 19+ssn.substring(0,2); 
		} else {
			birthYear = 20+ssn.substring(0,2); 
		}
		
		int i = Integer.parseInt(birthYear);
		
		if (i%12 == 11) {
			return "양";
		} else if (i%12 == 10) {
			return "말";
		} else if (i%12 == 9) {
			return "뱀";
		} else if (i%12 == 8) {
			return "용";
		} else if (i%12 == 7) {
			return "토끼";
		} else if (i%12 == 6) {
			return "호랑이";
		} else if (i%12 == 5) {
			return "소";
		} else if (i%12 == 4) {
			return "쥐";
		} else if (i%12 == 3) {
			return "돼지";
		} else if (i%12 == 2) {
			return "개";
		} else if (i%12 == 1) {
			return "닭";
		} else {
			return "원숭이";
		}
	}
	
	public static void main(String[] args) {
		String ssn = "940218-2268415";
		Work21 w21 =new Work21(ssn);
		if (w21.checkSsn()) {
			if(w21.checkSsn1()) {
				if(w21.validSsn()) {
					System.out.println("생년월일 : " + w21.getBirth());
					System.out.println("나이 : " + w21.getAge());
					System.out.println("성별 : " + w21.getGender());
					System.out.println("국적 : " + w21.checkNation());
					System.out.println("띠 : "+w21.getChineseZodiac());
				} else {
					System.out.println("검증이 안되는 주민번호입니다..");
				}
			} else {
				System.out.println("6번째 자리에 '-'이 없습니다..");
			}
		} else {
			System.out.println("주민번호 길이가 14자가 아닙니다..");
		}
	}//main

		
	}//calss



