package day1205;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Calendar : ���� ��¥ ������ ���� ��
 * @author SIST
 */
public class UseCalendar {

	public UseCalendar() {//������
		//Calendar Ŭ������ �ν��Ͻ� ���
		//1. getInstance ���
//		Calendar cal =new Calendar();//
		Calendar cal =Calendar.getInstance();
		//2. is a ����(��κ�!)
		Calendar cal1=new GregorianCalendar();
		//3. �ڽĸ����� ��üȭ
		GregorianCalendar gc= new GregorianCalendar();
		System.out.println(cal);
		System.out.println(cal1);
		System.out.println(gc);
		
		//Constant�� ����ϸ� ������ ���
		int year=cal.get(Calendar.YEAR);
		//Java������ ���� ������ 0��
		int month=cal.get(Calendar.MONTH)+1;
		int day=cal.get(Calendar.DAY_OF_MONTH);
		
		int day_of_year=cal.get(Calendar.DAY_OF_YEAR);
		//���� : ��-1,��-2,ȭ-3,��-4,��-5,��-6,��-7
		int day_of_week=cal.get(Calendar.DAY_OF_WEEK);
		
		System.out.printf("%d-%d-%d ������ ������ %d��° ��\n",year,month,day,day_of_year );
		String week="";
//		switch (day_of_week) {
//			case Calendar.SUNDAY:
//				week="�Ͽ���";
//			case Calendar.MONDAY:
//				week="������";
//			case Calendar.TUESDAY:
//				week="ȭ����";
//			case Calendar.WEDNESDAY:
//				week="������";
//			case Calendar.THURSDAY:
//				week="�����";
//			case Calendar.FRIDAY:
//				week="�ݿ���";
//			case Calendar.SATURDAY:
//				week="�����";
//				
//		}
		String[] weekTitle = {"��","��","ȭ","��","��","��","��"};
		
		System.out.printf("%d���� %s����\n",day_of_week ,weekTitle[day_of_week-1]);
		int am_pm=cal.get(Calendar.AM_PM);
//		switch(am_pm) {
//		case Calendar.AM:
//			break;
//		case Calendar.PM:
//			
//			break;
//		}
		System.out.printf("%d, %s\n",am_pm,am_pm==Calendar.AM?"����":"����");//���׿�����
		
		int hour=cal.get(Calendar.HOUR);
		int hour24=cal.get(Calendar.HOUR_OF_DAY);
		int minute=cal.get(Calendar.MINUTE);
		int second=cal.get(Calendar.SECOND);
		System.out.printf("%d(%d):%d:%d\n",hour,hour24,minute,second);
		
		System.out.println("---------------------------------------------------------------");
		System.out.printf("���� �� %d-%d-%d %s����\n",
			cal1.get(Calendar.YEAR),cal1.get(Calendar.MONTH)+1,cal1.get(Calendar.DAY_OF_MONTH),"��,��,ȭ,��,��,��,��".split(",")
			[cal1.get(Calendar.DAY_OF_WEEK)-1]);
		//��
		cal1.set(Calendar.YEAR, 2019);//2019-12-06
		//�� : ����� �����ϴ� ������ 1���� ����
		cal1.set(Calendar.MONTH, 4);//2019-05-06
		//�� : �ش� ���� �������� �ʴ� ���� ���ڰ� �����Ǹ� ������ 1�Ϸ� ����
		cal1.set(Calendar.DAY_OF_MONTH, 15);//2019-05-06
		
		System.out.printf("���� �� %d-%d-%d %s����",
				cal1.get(Calendar.YEAR),cal1.get(Calendar.MONTH)+1,cal1.get(Calendar.DAY_OF_MONTH),"��,��,ȭ,��,��,��,��".split(",")
				[cal1.get(Calendar.DAY_OF_WEEK)-1]);
		
		System.out.println("�̹����� �������� : "+cal.getActualMaximum(Calendar.DATE));
		
	}
	public static void main(String[] args) {
			new UseCalendar();//��ü����
	}//main

}//class
