package day1205;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * ������ �ִ� ��¥ ������ ���� �� 
 * ���� - java.text.SimpleDateaFormat
 * ��¥���� - java.util.Date
 * @author SIST
 */
public class UseDate {
	
	public UseDate() {
		Date date=new Date();
		System.out.println(date);
//		System.out.println(1900+date.getYear());//����õ method�� ����.
		// Locale - �ٸ� ������ ��¥ �������� �����Ͽ� ������ ��.
		
		
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy��MM��dd�� a EEEE HH(hh,kk):mm:ss ",Locale.KOREA);
		String formatDate=sdf.format(date);
		System.out.println(formatDate);
		
	}
	
	public static void main(String[] args) {
		new UseDate();
	}//main

}//class
