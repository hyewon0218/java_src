package day1128;

public class Array2 {
	int[][] arr= new int[6][9];
	
	public void setArray() {
		System.out.println("set array 입니다");
		for(int i=0; i < arr.length; i++) {
			for(int j=0; j < arr[i].length; j++) {
				if (i==0 ||i==5 ||j==0|| j==8) {
					arr[i][j]=1;
				}else {
					arr[i][j]=0;
				}
			}
		}
	}
	
	public void printArray() {
		System.out.println("print array입니다.");
		for(int i=0; i < arr.length; i++) {
			for(int j=0; j < arr[i].length ; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}
