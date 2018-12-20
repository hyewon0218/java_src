package day1128;

/**
 * 학생의 Oracle, Java, JDBC 과목 점수를 처리하는 프로그램 
 * @author SIST
 */
public class ScoreProcess2 {
	private int total;
	//
	private int subtotal;
	
	public ScoreProcess2 () {
		total=0;
	}

	
	/**
	 * 점수를 누적 합
	 * @param score
	 */
	public void addTotal (int score) {
		total+=score;
	}
	/**
	 * 점수를 얻는 일
	 * @return
	 */
	public int getTotal() {
		return total;
	}
	public double getAvg(int[] score) {
		//getTotal()/(double)score[0].length
		return getTotal()/(double)score.length;
	}
	//
	//
	public int getSubTatal() {
		return subtotal;
	}
	/**
	 * 총합 점수를 초기화 
	 */
	public void resetTotal () {
		total=0;
	}
	public void maxScore() {
		
	}
	//
//	public void subTotal(int score) {
//		subtotal+=score[i][1];
//	}
	
	public String[] namesData() {
		String[] name= {"김정운","이재현","정택성","노진경","최지우","김건하"};
			return name; 	
	}//nameData
	public int[][] scoreData() {
		int[][] score = {{85,86,81},{95,91,100},{89,71,59},{97,96,91},{78,74,77},{100,95,68}};
		return score;
	}//returnData
	public void printScore(String[] name,int[][] score) {
//		int total = 0;
		// 숙제 - 모든 일은 합당한 매개변수와 반환형을 사용하여
		// method를 정의하여 호출하고 일을 수행한 결과를 받아 출력한다.
		//1. 각 학생의 평균을 구하여 출력한다.(출력은 소수이하 한자리 까지만 출력)
		System.out.println("번호\t이름\tOracle\tJava\tJDBC\t총점\t평균");
		System.out.println("----------------------------------------------");
		for(int i=0; i < score.length; i++) {//행
			System.out.printf("%d\t%s\t",i+1,name[i]);//i+1은 번호1부터!!
			for(int j=0; j < score[i].length; j++) {//열 의 길이만큼 /2차원 배열에서 한 행은 1차원배열
				System.out.printf("%d\t",score[i][j]);	
				addTotal(score[i][j]);
//				total+=score[i][j];
			}
			System.out.printf("%d\t%.1f\n",getTotal(),getAvg(score[i]));
			resetTotal();
//			total = 0;
		}
		System.out.println("------------------------------------------------------");
		
		System.out.printf("과목총점------------------------------------------------------");
		//2. 각 과목당 총점과 총점의 총점
		
		for(int i=0; i <score.length; i++) {
			if(j==0) {
				}
			System.out.println(score[i][i]);
			
//							
//				score[0][0]+score[1][0]+score[2][0]+score[3][0]=
//				score[0][1]+score[1][1]+score[2][1]		
		}
		
		//3. 각 과목당 평균과 전체 평균(전체 평균은 소수이하 두자리 까지)
		System.out.printf("과목평균------------------------------------------------------");
		//4. 각 과목당 최고 점수를 출력 
		System.out.printf("최고점수 오라클[] 자바[] JDBC[]------------------------------");
		int maxScore=0;
		int minScore=0;
		
		for(int i=0; i < score.length; i++) {
			if(maxScore < score[i]) {
				maxScore=score[i];
				
			}
			if(minScore > score[i]) {
				minScore=score[i];
			}
		}
//		for() 
		
		//5. 일등 학생의 이름과 총점,번호
		System.out.printf("TOP 번호[] 이름[] 총점[] -------------------------------------");
		//6. 자바점수만 오름차순 정렬하여 출력 
		System.out.printf("TOP 번호[] 이름[] 총점[] -------------------------------------");
	
	}//printScore
	//숙제 2. 
	//2차원 배열을 참조형 형식으로 만들고 아래와 같이 값을 넣어 출력하는 
	// method 작성
	//	1 1 1 1 1 1 1 1 1
	//  1 0 0 0 0 0 0 0 1
	//  1 0 0 0 0 0 0 0 1
	//  1 0 0 0 0 0 0 0 1
	//  1 0 0 0 0 0 0 0 1
	//	1 1 1 1 1 1 1 1 1
	public static void main(String[] args) {
		ScoreProcess2 sp2=new ScoreProcess2();
		//처리할 데이터 받기
		String[] name=sp2.namesData();
		int[][] score=sp2.scoreData();
		//처리
		sp2.printScore(name, score);
	}//main

}//main
