package day1220;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * JVM에서 발생한 데이터가 정수, byte[]인 경우에 File로 저장하는 FileOutputStream의 사용
 * 
 * @author SIST
 */
public class UseFileOutputStream {

	public void useFileOutputStream() throws IOException {
		int i = 65;
		// 1. File생성
		File file = new File("c:/dev/temp/java_write.txt");
		FileOutputStream fos = null;

		try {
			boolean flag = false;
			if (file.exists()) {
				boolean[] temp = { false, true, true };//?
				int select = JOptionPane.showConfirmDialog(null, "파일을 덮어쓰시겠습니까?");
				flag = temp[select];
			}

			// 2. FileOutputStream 생성-> 입력된 경로에 파일이 생성된다.
			// 파일이 없다면 생성하고, 파일이 있다면 덮어쓴다.
			if (!flag) {//예
				fos = new FileOutputStream(file);
				fos.write(i);// 값을 스트림에 기록 /수에 대한 문자가 출력
				fos.flush();
				System.out.println("파일 기록 완료!!");
			}
		} finally

		{
			// {fos.close();}//스트림에 기록된 내용이 있다면 분출하고 연결을 끊는다.
			if (fos != null) {
				fos.close();
			} // end if
		} // end finally
	}

	public static void main(String[] args) {
		UseFileOutputStream ufos = new UseFileOutputStream();
		try {
			ufos.useFileOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// main

}// class
