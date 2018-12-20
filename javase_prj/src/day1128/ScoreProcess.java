package day1128;

/**
 * 4강의장 학생들의 성적처리 프로그램
 * @author SIST
 */
public class ScoreProcess {

	
	
	public ScoreProcess() {
		
		String[] nameArr= {"이재찬","정택성","이재현","김건우","공선의"};//instance변수(지역변수에는 접근지정자없이 가능)
		int[] scoreArr= {89,76,99,64,50};
//		int maxScore=scoreArr[0];
		int maxScore=0;//최고점수
		int minScore=101;//최저점수
		int temp=0;//정렬값을 임시로 저장
		
		
		System.out.println("번호\t이름\t점수");
		System.out.println("------------------------------------------------");
		
		int totalScore=0;// totalscore처음0
		for(int i=0; i < nameArr.length ; i++) {
			System.out.printf("%d\t%s\t%d\n",i+1,nameArr[i],scoreArr[i]);//1부터시작 보여지기위해 i+1
			totalScore +=scoreArr[i];//총점을 누적 합
			
			//최고점수가 현재 순환중인 방의 값보다 작다면  
			if(maxScore < scoreArr[i]) {
			//현재 순환중인 방의 값으로 최고점수를 변경해준다.	
				maxScore=scoreArr[i];
			}
			//최저점수가 현재 순환중인 방의 값보다 크다면  
			if(minScore > scoreArr[i]) {
				//현재 순환중인 방의 값으로 최저점수를 변경해준다.	
				minScore=scoreArr[i];
			}
		}//end for
		System.out.println("-------------------------------------------------");
		System.out.println("응시인원 : "+nameArr.length+"명");
		System.out.printf("총점 [%5d] 평균 [%.2f ]\n ", totalScore, totalScore/(double)nameArr.length);//5오른쪽정렬 .소수점실수부분확인위해/정수나누기정수는정수 소숫점x castiong
		System.out.println(totalScore/nameArr.length);
		System.out.printf("최고점 [%3d] 최하점[%d]\n ",maxScore,minScore);
		
		for(int i=0; i<scoreArr.length-1; i++) {//맨뒷방비교x
			for(int j=i+1; j <scoreArr.length ;j++) {
				if(scoreArr[i] < scoreArr[j]) {//앞방의 값이 뒷방보다 작다면 
					temp=scoreArr[i];
					scoreArr[i]=scoreArr[j];
					scoreArr[j]=temp;
					
				}
			}
		}//end for
		
		
		for(int i=0; i < scoreArr.length ;i++) {
			System.out.printf("%4d",scoreArr[i]);
		}
		
	}//ScoreProcess 생성자
	
	public static void main(String[] args) {
		
		new ScoreProcess();//instance
		System.out.println("--------------------------------------------------------");
		int birth=1999;
		String[] zodiac= {"원숭이","닭","개","돼지","쥐","소","호랑이","토끼","용","뱀","말","양"};
		System.out.println(zodiac[birth%12]);
	}//main

}//class
