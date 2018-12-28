package day1220;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 16bit stream�� ����Ͽ� ���� �б�
 * @author SIST
 */
public class UseFileReader {

	public void useFileReader() throws IOException {//�ݵ�� ���� ���� ���ؼ� throws
		BufferedReader br=null;
		
		try {
			File file=new File("C:/dev/temp/java_read.txt");
			//1. �ٿ��� ���Ͽ� ��Ʈ���� ����
//			FileReader fr=new FileReader(file);
//			//2. �ٴ����� �о���̴� ����� ���� ��Ʈ�� ���� 
//			br=new BufferedReader(fr);
			
			br=new BufferedReader(new FileReader(file));
			
			
			String temp="";
			//���پ� �о�鿩 �о���� ������ �����Ѵٸ�
			while((temp=br.readLine())!=null) {
				System.out.println(temp);
			}
			
		}finally {
			//�� ��ٸ� ����� ��Ʈ���� ���´�.
			if(br !=null)/*�����Ǿ��ִ���*/ {br.close();} //end if
		}
	}
	
	public static void main(String[] args) {
		UseFileReader ufr=new UseFileReader();
		try {
			ufr.useFileReader();//���⼭ Ʈ����ĳġ (1.throw 2. throws 3.try~catch)
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//main

}//class
