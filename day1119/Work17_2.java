package day1119;

public class Work17 {
	/*
	 * ���� 1. ����� �ð��� �Է¹޾� �Ʒ��� �������� ����ϼ���. ��� : ����� �ð��� �ִ� 2�ð��� ������ ������ 60���� �Ѵ� �ٸ�
	 * "��Ÿ�" 60�� ���϶�� "�ܰŸ�"�� ����ϼ���.
	 * 
	 * 
	 */
	public static void main(String[] args) {
//		int time = Integer.parseInt(args[0]);
//		if(time<120) {
//			if(time>60) {
//				System.out.println("��Ÿ�");
//			}
//			else {
//				System.out.println("�ܰŸ�");
//			}
//		}
//		else {
//			System.out.println("����� �ð��� �ִ� 2�ð��Դϴ�.");
//		}
/*		 * 2. �̸�, ������ܰ� ����� �Ÿ��� �Է¹޾� �Ʒ��� ���� ����ϼ���. ��������� "����,����ö,�ý�,����"�� �����Ѵ�. �������
		 * 1200��, ����ö ��� 1250��, �ýÿ�� 3800�� �Դϴ�. ����� 10Ű�� ������ �⺻���, �� 5Ű�� �ʰ��� ���� 100���� ����
		 * �մϴ�. // dist/5!=0
		 * 
		 * ��� : xxx�� ����� ��������� xx�̸� �Ÿ��� xx Ű�� �Դϴ�. �� �̿� ��� xx���̰�, �պ��̿� ��� xx���̸�, �Ѵ�
		 * 20�ϱ��� ������ ��: xxxx�� �Դϴ�.*/
		String Name = args[0];
		String Trans = args[1];
		int Dist = Integer.parseInt(args[2]);
		int charge = 0;
		int Plus_charge = 0;
		if(Trans.equals("����")||Trans.equals("����ö")||Trans.equals("�ý�")||Trans.equals("����")) {
			if(Trans.equals("����")) {
				charge = 1200;
			}else if(Trans.equals("����ö")) {
				charge = 1250;
			}else if(Trans.equals("�ý�")){
				charge = 3800;
			}
			
			if(charge>10) {
				Plus_charge = (int)((Dist-10)/5);
				charge= charge+Plus_charge*100;
			}
			System.out.println(Name+"�� ����� ��������� "+Trans+"�̸� �Ÿ���"+Dist+"Ű�� �Դϴ�. �� �̿� ��� "+charge+"���̰�, �պ��̿���"
						+(charge*2)+"���̸�, �Ѵ� 20�� ���� ������ ��: "+(20*charge*2)+"���Դϴ�.");
		}else {
			System.out.println("����,����ö,�ý�,������ �ƴմϴ�");
		}

		
		

	}//main
}// class
