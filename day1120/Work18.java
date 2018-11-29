package day1120;

public class Work18 {

	public static void main(String[] args) {
		for(int i=1 ; i < 10 ; i++) {
			for(int j=2 ; j < 10 ; j++) {
				System.out.print(j+" x " +i+" = "+ i*j+"    ");
			}//end for
			System.out.println();
		}//end for
		
		for(int i=0 ; i <4 ; i++) {
			for(int k=0 ; k<=i-1 ; k++) {
				
				System.out.print(" ");
			}
			for(int j=0 ; j<=i  ; j++) {
				System.out.print(i+" "+j+" ");
			}//end for
			System.out.println();
	}//end for	
	}//main

}//class

//0 0
//1 0 1 1
//2 0 2 1 2 2
//3 0 3 1 3 2 3 3 