package day1129;

/**
 * 면,행,열로 구성된 배열
 * @author SIST
 */
public class UseArray3 {
	
	public UseArray3() {
		//3차원 배열 참조형 형식의 사용
		//1. 선언 : 데이터형[][][] 배열명=null;
		int[][][] arr=null;
		//2. 생성 : 배열명=new 데이터형[면의 수][행의 수][열의 수];
		arr=new int[2][3][4];
		//1+2) 데이터형[][][] 배열명=new 데이터형[면][행][열];
		int[][][] arr1=new int[3][4][5];//4행5열짜리 배열3개
		//3. 값 할당)배열명[면번호][행번호][열번호]=값;
		arr[0][0][0]=10;
		arr[1][2][3]=1000;
		//4. 값 사용) 배열명[면][행번호][열번호];
		System.out.println(arr[0][0][0]+"/"+arr[0][0][1]+"/"+arr[0][0][2]);
		System.out.println("arr배열의 면의 수 : "+arr.length+",행의 수 :"+arr[0].length+",열의 수 :"+arr[0][0].length);
		System.out.println("arr1배열의 면의 수 : "+arr1.length+",행의 수 :"+arr1[0].length+",열의 수 :"+arr1[0][0].length);
		//모든 방의 값 출력)
		for(int i=0 ; i < arr.length; i ++) {//면
			System.out.println(i+"면 시작");
			for(int j=0; j < arr[i].length; j++) {//행
				System.out.println(i+"면"+j+"행 시작");
				for(int k=0; k< arr[i][j].length; k++) {//열
					System.out.print(arr[i][j][k]+"\t");
				}
				System.out.println("\n"+i+"면"+j+"행 끝");
			}
			System.out.println(i+"면 끝");
		}//end for
		System.out.println("-------------------------");
		//3차원 배열의 한 면은 2차원 배열로 이루어져 있다.
		for(int[][] arr2 : arr1) {
		//2차원 배열의 한 행은 1차원 배열로 이루어져있다.
			for(int[] arr0 : arr2) {
				for(int val : arr0) {
					System.out.print(val+"\t");
				}
				System.out.println("\n행 끝");
			}
			System.out.println("\n면 끝");
		//1차원 배열읭 한 열은 단일 데이터형으로 이루어져있다.
		}
	}
	public void priType() {
		//기본형 형식으로 3차원 배열선언
		//데이터형[][][] 배열명={{{값,,},{,,,,,,,}},{{,,,,,,,,,,},{,,,,,,,,,}}};
		int[][][] arr= {{{1,2,3},{4,5,6}}/*0면*/,{{7,8,9},{10,11,12}}/*1면*/};
		System.out.println("면의 수 :"+arr.length+", 행의 수 :"+arr[0].length+",열의 수 :"+arr[0][0].length);
		
		for(int i=0; i < arr.length; i++) {//면
			for(int j=0; j < arr[i].length; j++) {//행
				for(int k=0; k < arr[i][j].length; k++) {//열
					System.out.print(arr[i][j][k]+"\t");//print 주의!!!!!
				}
				System.out.println();
			}
			System.out.println();
		}//end for
	}//priType
	
	public static void main(String[] args) {
		new UseArray3().priType();;//인스턴스명저장안하는(생성자만쓸때!!) 매소드 하나더생기면 뒤에. 메소드체인!!!
	}//main

}//class
