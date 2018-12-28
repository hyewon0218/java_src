package day1219;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.jws.soap.SOAPBinding.Use;

/**
 * HDD에 존재하는 File과 연결하여 그 내용을 읽어들일 때 사용하는
 * FileInputStream
 * @author SIST
 */
public class UseFileInputStream {

	public UseFileInputStream() throws IOException{
		File file=new File("c:/dev/temp/java_read.txt");
		if(file.exists()) {
			BufferedReader br=null;
			try {
				//스트림을 생성하여 JVM에서 HDD의 파일과 연결
//				FileInputStream fis=new FileInputStream(file);
//				int temp=0;
//				
//				
//		
//					while((temp=fis.read())!=-1) {//읽어들인 내용이 존재한다면
//						// 1.단항연산자 2. 관계연산자 
//						System.out.print((char)temp);
//					}//end while
//				//스트림 사용을 완료했으면 스트림을 끊어서 메모리 누수를 막는다.
//					fis.close();
				
				/////////12-20-2018 코드 추가///////////////////////////////////////////////
				//8bit stream 과 16bit stream연결 : 한글이 깨지는 문제해결
//				FileInputStream fis=new FileInputStream(file);//파일과 연결
//				InputStreamReader isr=new InputStreamReader(fis);//8bit+16bit
//				br=new BufferedReader(isr);//Buffer=속도개선,줄단위 읽기
				
				br=new BufferedReader(new InputStreamReader(
						new FileInputStream(file)));//코드 간단히
				
				String temp="";
				while((temp=br.readLine())!=null) {
					//줄단위(\n전까지)로 읽어서 읽어들인 내용이 있다면 
					System.out.println(temp);//출력
				}
				
				
		
			}finally {//반드시 실행
					if(br!=null) {br.close();}//end if /에러발생x
				}//br오류->try안지역변수여서 인스턴스로올려줌
			
		}else {
			System.out.println("경로나 파일명을 확인하세요.");
		}
	}
	public static void main(String[] args) {
		try {
			new UseFileInputStream();//인스턴스한곳에서 트라이캐치
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//main

}//class
