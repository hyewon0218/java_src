package day1121;

/*2.  do~while을 사용하여 아래의 형태의  *을 출력하는  static method를
작성하여 호출하세요.
 	*
    **
    ***
    *****/
public class Work19_2 {

	public static void dot() {
		int i=0;
		do {
			int j = 1;
			do {
				System.out.println("*");
				j++;
			} while (i > j);
			i++;
		}while (i < 5);
		
		
		 
	}

	public static void main(String[] args) {

		Work19_2.dot();
	}// main

}// class
