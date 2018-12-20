package day1121;

/**
 *	while : 시작과 끝을 모를 때 사용하는 반복문<br>
 * 			최소 0번 수행 최대 조건까지 수행<br>
 * 문법) while (조건식){<br>
 * 			반복 수행문장;<br>
 *   	} 
 * @author SIST
 */
public class TestWhile {

	public static void main(String[] args) {
		int i=0;//초기값
		
	while(i<10) {//조건식
		System.out.println("i="+i);//반복수행문장
		i++;//증가식
	}//end while
	
		System.out.println("-----------------------------------------------");
		
		//단을 입력받아 2~9단 사이라면 구구단 출력
		int input = Integer.parseInt(args[0]);
		if (input > 1 && input < 10) {
		 i=1;
			while(i < 10) {
				System.out.println(input + "*"+i+"="+(input*i));
				i++;
			}
		}
		
		// 무한 loop
		i=0;
		while(true) {
		System.out.println("무한 loop");	
		if(i==5) {
			break;
		}//end if
		i++;
		}//end while
		
	}//main
	

}//class
