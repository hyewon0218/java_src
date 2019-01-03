package day0103;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UseLamda {

	public static void main(String[] args) {
//		TestLamda tl=()-> new Date().toString();//return ���� ����
//		TestLamda tl=()-> {return new Date().toString();};//return ���. {}�ʿ�
		// abstract method ���� �ڵ尡 ����(������)�� ��쿡�� {}�� �ݵ�� ���
		TestLamda tl = () -> {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for (int i = 0; i < 10; i++) {
				System.out.println("i =" + i);
			}
			return sdf.format(new Date());
			};
		System.out.println(tl.toDay());
	}

}
