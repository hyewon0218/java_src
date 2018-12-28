package day1219.homework;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class HW2 {

	String path;
	File[] files;
	File file; 
	int javaFiles;
	List<Integer> listIdx;
	
	public HW2() {

		getPath();

		file= new File(path);// 해당정보파일객체생성

		if (file.isFile()) {
			JOptionPane.showMessageDialog(null, "입력값은 경로가 아니라 파일입니다.");
		} else {
			checkJava();

			String msg = "java파일이" + javaFiles + "개 존재합니다. 삭제하시겠습니까?";

			int select = JOptionPane.showConfirmDialog(null, msg);// 반환형보고 변수꼭선언하기

			switch (select) {
			case JOptionPane.OK_OPTION:// ok
				for (int i = 0; i < listIdx.size(); i++) {
					files[listIdx.get(i)].delete(); // int로 나와서 files배열에 요소선택 해서 지우기
				}
			}

		}

	}

	public void getPath() {
		path = JOptionPane.showInputDialog("경로를 입력하세요. \n 예)c:/dev");// 지역변수라 인스턴스로
	}

	public void checkJava() {
		// 'java'란 파일이 존재하는지 여부판단
		 files= file.listFiles();
		javaFiles = 0;
		listIdx = new ArrayList<Integer>();// 가변길이 list

//		files[0].getName()//files에서 파일에 대한 정보를 갖고있음. /이렇게 배열의 요소인 File객체를 사용 가능
		for (int i = 0; i < files.length; i++) {// 모든(배열의 길이) 요소의 정보들을 가져와서
			// for문을 돌면서 저장해야되는 것들 : 자바파일의 수, 삭제할 파일의 index
			if (files[i].getName().contains(".java")) {// boolean 바로 for문으로
				listIdx.add(i);// 배열을 만들게 되면 5개의 공간을 마련해놔야함 list는 가변값이라 //포함하는것의 인덱스저장
				javaFiles++;// 누적합
			};
		}
	}

	public static void main(String[] args) {
		new HW2();
	}

}
