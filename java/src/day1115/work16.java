class Homework {
	public static void main(String[] args) {
		//1��
		int i = -10;
		int j = 2147483647;
		boolean flag1=false, flag2=false, flag3=false, flag4=false;
		System.out.println("�Էµ� ���� ����̸� 2���� �����̸� ~�� �̿��Ͽ� 10���� = " 
			+ ( i >= 0 ? Integer.toBinaryString(i) : ~i+1 ));

		//2��
		j >>= 16;
		System.out.println("���� 2byte = " + j);
		j = 2147483647;
		j <<= 16;
		System.out.println("���� 2byte = " + ~j);

		//3��
		flag3=((flag1=4>3) || (flag2=5>4)); // ������ ����Ǿ����� flag2�� true�� �Ǿ���� ������ ��½� false�� �ȴ�. 
		System.out.println("���� : " + flag1 + " , ���� : " + flag2+ " , ���� : " + flag3);

	}
}
