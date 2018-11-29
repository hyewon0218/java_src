package day1121;

/*while을 사용하여 구구단 전체 단을 출력하는  instance method를
작성하고, 호출하세요.*/
public class Work19 {
	public void gugudan() {

		int i = 2;
		while (i < 10) {
			// i=i+1;

			int j = 1;
			while (j < 10) {
				System.out.println(i + " * " + j + " = " + i * j);
				j++;
			}
			i++; 
		}
	}

	public static void main(String[] args) {
		Work19 w19 = new Work19();

		w19.gugudan();
	}// main
}// class
