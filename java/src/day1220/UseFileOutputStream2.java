package day1220;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

/**
 * 8bit stream 16bit stream 을 사용하여 문자열 데이터를 File에 기록
 * 
 * @author SIST
 */
public class UseFileOutputStream2 {

	public UseFileOutputStream2() throws IOException {
		String data = "오지고요 지리고요 고요고요 고요한 밤이고요";
		// 1. File객체 생성 : 파일이 존지한다면 덮어 쓸것인지를 판단
		File file = new File("c:/dev/temp/java_write2.txt");

		boolean flag = false;// 파일이 없을 때
		if (file.exists()) {// 파일이 존재할 때
			boolean[] temp = { false, true, true };// 예,아니오, 취소
			flag = temp[JOptionPane.showConfirmDialog(null, "덮어쓰는 부분 린정?")];
		}

		// 2. 스트림 생성
		if (!flag) {// =true
			BufferedWriter bw = null;
			try {
				
				//8bit stream과 16bit stream의 연결
				//2.파일을  생성하는 스트림 : FileNotFoundException 발생 -> 폴더없을때
//				FileOutputStream fos=new FileOutputStream(file);
//				//3. 문자열을 쓰기 위한 스트림을 연결 (속도가 느리다.)
//				OutputStreamWriter osw=new OutputStreamWriter(fos);
//				//4. 느린 속도를 개선하기 위한 스트림을 연결
//				bw=new BufferedWriter(osw);
				
//				bw=new BufferedWriter(new OutputStreamWriter
//						(new FileOutputStream(file)));
				
				////////////////////////////16bit만 사용(단순한 문자열 쓸 때)////////////////////////////////////////////
				bw=new BufferedWriter(new FileWriter(file)); 
				
				bw.write(data);//스트림에 데이터를 기록
				bw.flush();//목적지 파일로 분출 
				System.out.println("파일에 기록 완료");
				
			} finally {
				// 스트림 객체가 생성되어 있다면 연결을 끊는다.
				if (bw != null) {bw.close();}
			}
		}

	}

	public static void main(String[] args) {
		try {
			new UseFileOutputStream2();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// main

}// class
