package day1219;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.jws.soap.SOAPBinding.Use;

/**
 * HDD�� �����ϴ� File�� �����Ͽ� �� ������ �о���� �� ����ϴ�
 * FileInputStream
 * @author SIST
 */
public class UseFileInputStream {

	public UseFileInputStream() throws IOException{
		File file=new File("c:/dev/temp/java_read.txt");
		if(file.exists()) {
			BufferedReader br=null;
			try {
				//��Ʈ���� �����Ͽ� JVM���� HDD�� ���ϰ� ����
//				FileInputStream fis=new FileInputStream(file);
//				int temp=0;
//				
//				
//		
//					while((temp=fis.read())!=-1) {//�о���� ������ �����Ѵٸ�
//						// 1.���׿����� 2. ���迬���� 
//						System.out.print((char)temp);
//					}//end while
//				//��Ʈ�� ����� �Ϸ������� ��Ʈ���� ��� �޸� ������ ���´�.
//					fis.close();
				
				/////////12-20-2018 �ڵ� �߰�///////////////////////////////////////////////
				//8bit stream �� 16bit stream���� : �ѱ��� ������ �����ذ�
//				FileInputStream fis=new FileInputStream(file);//���ϰ� ����
//				InputStreamReader isr=new InputStreamReader(fis);//8bit+16bit
//				br=new BufferedReader(isr);//Buffer=�ӵ�����,�ٴ��� �б�
				
				br=new BufferedReader(new InputStreamReader(
						new FileInputStream(file)));//�ڵ� ������
				
				String temp="";
				while((temp=br.readLine())!=null) {
					//�ٴ���(\n������)�� �о �о���� ������ �ִٸ� 
					System.out.println(temp);//���
				}
				
				
		
			}finally {//�ݵ�� ����
					if(br!=null) {br.close();}//end if /�����߻�x
				}//br����->try�������������� �ν��Ͻ��ο÷���
			
		}else {
			System.out.println("��γ� ���ϸ��� Ȯ���ϼ���.");
		}
	}
	public static void main(String[] args) {
		try {
			new UseFileInputStream();//�ν��Ͻ��Ѱ����� Ʈ����ĳġ
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//main

}//class
