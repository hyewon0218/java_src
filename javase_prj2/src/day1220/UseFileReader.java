package day1220;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 16bit stream만 사용하여 파일 읽기
 * @author SIST
 */
public class UseFileReader {

	public void useFileReader() throws IOException {//반드시 연결 끊기 위해서 throws
		BufferedReader br=null;
		
		try {
			File file=new File("C:/dev/temp/java_read.txt");
			//1. 근원지 파일에 스트림을 연결
//			FileReader fr=new FileReader(file);
//			//2. 줄단위로 읽어들이는 기능을 가진 스트림 연결 
//			br=new BufferedReader(fr);
			
			br=new BufferedReader(new FileReader(file));
			
			
			String temp="";
			//한줄씩 읽어들여 읽어들인 내용이 존재한다면
			while((temp=br.readLine())!=null) {
				System.out.println(temp);
			}
			
		}finally {
			//다 썼다면 연결된 스트림을 끊는다.
			if(br !=null)/*생성되어있는지*/ {br.close();} //end if
		}
	}
	
	public static void main(String[] args) {
		UseFileReader ufr=new UseFileReader();
		try {
			ufr.useFileReader();//여기서 트라이캐치 (1.throw 2. throws 3.try~catch)
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//main

}//class
