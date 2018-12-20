package day1205;

/**
 * 1~45 까지의 사이의 수중에서 무작위로 하나를 뽑아 6개의 세트를 만들어 배열로 반환하는 method를 만들고 호출하여 출력할 것. 단,
 * 중복된 수는 배열에 입력되지 않아야한다.
 * 
 * @author SIST
 */
public class Work2 {

	public int[] Lotto645() {
		int[] lotto = new int[6];
		int rnd = 0;

		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (int) (Math.random() * 45 + 1);// 0부터니까 +1

			for (int j = 0; j < i; j++) {
				if (lotto[i] == lotto[j]) {
					i--;
					break;
				} // if
			} // j
		} // i
		for (int i = 0; i < lotto.length; i++) {
			System.out.println(lotto[i] + " ");
		}
		return lotto;
	}

	public static void main(String[] args) {
		Work2 w2 = new Work2();
		w2.Lotto645();
		System.out.println("\n------------------");
	}// main

}// class
