package day1120;

/**
 * for : 시작과 끝을 알 때 사용하는 반복문<br>
 * 문법 : for(시작값 ; 끝값 ; 증가|감소식){<br>
 * 				반복 수행 문장;<br>
 * @author SIST
 */
public class TestFor {

	public static void main(String[] args) {
		//0에서부터 10보다 작을 때까지 반복수행하는 for
		
		for(int i=0 ; i < 10 ; i++) {
			System.out.println(i + "번 안녕");
		}//end for
		
		//1에서부터 100까지 짝수만 반복 수행 for
		for(int i=1 ; i < 101 ; i++) {
			if (i%2==0) {
				System.out.print(i+ " ");
			}//end if
		}//end for
		System.out.println();//줄변경
		
		// 1에서부터 100까지 홀수만 출력 
		int cnt=0;
		//증.감소식은 변수에 값을 변화시키고 유지시킬 수 있는 모든 연산자를 사용할 수 있다.
		for(int i=1 ; i < 101 ; i+=2) {
			cnt++;
			System.out.print(i+ " ");
		}//end for
		System.out.println("\n"+cnt+"번");//줄변경
		
		//1~100까지 출력하기 3의 배수마다 숫자대신 "짝"을 출력
		for (int i=1; i < 101; i++) {
			if(i%3==0) {
				System.out.println("짝");
				continue;
			}
			System.out.println(i);
		}
	// 1~100까지의 합 출력	
		
		int sum=0;
		for (int i=1; i<101 ; i++) {
			sum+=i;
		}
		System.out.println(sum);
	
		// A~Z까지 출력 
		for (int c=65; c < 91; c++) {
			System.out.println((char)c);
		}//end for
		
		//구구단2단
		for(int i=1; i < 10 ; i++) {
			System.out.println("2 * "+i+" = "+ (2 *i));
		}//end for
		
	}//main

}//class
