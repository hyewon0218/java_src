package day1128;

public class Work21 {
	int[][] arr=new int[6][9];
	
	public void setArray() {
		for(int i=0; i < arr.length; i++) {
			for(int j=0; j < arr[i].length; j++) {
				if (i==0 || i==5 || j==0 || j==8) {
					arr[i][j]=1;
				}else {
					arr[i][j]=0;
				}
			}
		}
	}
	
	public void printArray() {
		for(int i=0; i < arr.length; i++) {
			for(int j=0; j < arr[i].length; i++) {
				System.out.println(arr[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Work21 obj =new Work21();
		
		obj.setArray();
		obj.printArray();
	}

}
