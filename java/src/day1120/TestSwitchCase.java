package day1120;

/**
 *	swich~case 를 사용한 학점 구하기
 * @author SIST
 */
public class TestSwitchCase {

	public static final int GRADE_A_PLUS=10;
	public static final int GRADE_A=9;
	public static final int GRADE_B=8;
	public static final int GRADE_C=7;
	public static final int GRADE_D=6;
	
	
	public static void main(String[] args) {

		int score=109;
//		char grade=' ';//char는 문자를 저장한다. ''코드셋에 문자 없음.
						  //' '공백문자(white space)- unicode \u0000 ~ \uFFFF
		char grade=64;
		System.out.println(grade+1);
		//case의 상수는 가독성이 떨어지기 때문에 Constant를 사용
		if(score >=0 && score <=100 ) {
			switch(score / 10 ) {
			case TestSwitchCase.GRADE_D: grade++;
			case TestSwitchCase.GRADE_C: grade++;
			case TestSwitchCase.GRADE_B: grade++;
			case TestSwitchCase.GRADE_A: 
			case TestSwitchCase.GRADE_A_PLUS: grade++;break;
			default: grade+=6;
		/*case 10 :
		case 9 : grade='A';	break;
		case 8 : grade='B';	break;
		case 7 : grade='C';	break;
		case 6 : grade='D';	break;
		default : grade='F';	*/
		//break; default는 아랫줄에 실행될 코드가 없으므로 분기문을 사용하지 않는다.
		}//end switch
		
		System.out.println(score+"점의 학점은"+ grade);
		}else {
			 System.out.println("점수는 0~100점 사이만 입력 가능!!! 입력점수{ " + score + "]");
		}
	}//main

}//class











