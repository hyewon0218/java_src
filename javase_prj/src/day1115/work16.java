class Homework {
	public static void main(String[] args) {
		//1번
		int i = -10;
		int j = 2147483647;
		boolean flag1=false, flag2=false, flag3=false, flag4=false;
		System.out.println("입력된 값이 양수이면 2진수 음수이면 ~를 이용하여 10진수 = " 
			+ ( i >= 0 ? Integer.toBinaryString(i) : ~i+1 ));

		//2번
		j >>= 16;
		System.out.println("상위 2byte = " + j);
		j = 2147483647;
		j <<= 16;
		System.out.println("하위 2byte = " + ~j);

		//3번
		flag3=((flag1=4>3) || (flag2=5>4)); // 후항이 연산되었으면 flag2가 true가 되었어야 하지만 출력시 false가 된다. 
		System.out.println("전항 : " + flag1 + " , 후항 : " + flag2+ " , 판정 : " + flag3);

	}
}
