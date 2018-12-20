package day1205;

/**
 * 1~45 ������ ������ ���߿��� �������� �ϳ��� �̾� 6���� ��Ʈ�� ����� �迭�� ��ȯ�ϴ� method�� ����� ȣ���Ͽ� ����� ��. ��,
 * �ߺ��� ���� �迭�� �Էµ��� �ʾƾ��Ѵ�.
 * 
 * @author SIST
 */
public class Work2 {

	public int[] Lotto645() {
		int[] lotto = new int[6];
		int rnd = 0;

		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (int) (Math.random() * 45 + 1);// 0���ʹϱ� +1

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
