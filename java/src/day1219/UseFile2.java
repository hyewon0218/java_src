package day1219;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;




/**
 * ��������, ���ϻ���
 * @author SIST
 */
public class UseFile2 {

	public void createDirectory() {
		File file=new File("c:/hyewon/choi");
		if(file.mkdirs()) {
			System.out.println("������������");
		}else {
			System.out.println("���� �̸��� ���� ����");
			
		}
	}
	public void removeFile() {
		File file=new File("c:/dev/temp/a.txt");
		boolean flag=file.delete();
		if(flag) {
			System.out.println("���� ���� ����");
		}else {
			System.out.println("���� ���� ����");
			
		}
	}

	
	
	public static void main(String[] args) {
		UseFile2 uf2=new UseFile2();
		uf2.createDirectory();
		System.out.println("---------------------------------------------------------------------------");
		uf2.removeFile();
	
	}//main

}//class
