package day1129;

public class UseWork {

	public UseWork() {// �⺻������
		int con_s = 0;
		int sumage = 0;
		int oldestage=0;
		String oldName="";
		
		Work22[] dataArr = null;
		dataArr = new Work22[7];

		dataArr[0] = new Work22("������", "����� ������ ���ﵿ", 28, "����");
		dataArr[1] = new Work22("������", "����� ���빮�� ��ʸ���", 27, "����");
		dataArr[2] = new Work22("������", "������ ���뱸 ���뵿", 26, "����");
		dataArr[3] = new Work22("���ü�", "����� ���α� ���ε�", 27, "����");
		dataArr[4] = new Work22("���ü�", "��⵵ ��õ�� ��õ��", 29, "����");
		dataArr[5] = new Work22("������", "����� ������ ���ﵿ", 26, "����");
		dataArr[6] = new Work22("�����", "����� ������ �����絿", 27, "����");

//		Work22 temp = dataArr[0];

		for (Work22 tempWork : dataArr) {//tempWork�� Work22�ǰ�ü!!!!!
			sumage+=tempWork.getAge();
			if (tempWork.getAdd().contains("����")) {
					con_s++;
			}
			if(oldestage < tempWork.getAge() ) {
				oldestage=tempWork.getAge();
				oldName=tempWork.getName();
			}
			System.out.println(
					tempWork.getName() + "/" + tempWork.getAdd() + "/" + tempWork.getAge() + "/" + tempWork.getGen());
		}
		System.out.println("����� ������ : "+con_s);
		System.out.println("������ �� : "+sumage);
		System.out.println("���� ���� ���� ��� : "+ oldName);
	}
	// boolean contain
	// temp.get.,,,
//	=s.cotains("����");
//	
// ���� ����, ������(����)	

	public static void main(String[] args) {
		new UseWork();
	}

}
