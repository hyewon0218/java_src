package kr.co.sist.memo.run;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import kr.co.sist.memo.view.JavaMemo;

/**
 * �޸��� Ŭ������ �����ϴ� �� 
 * @author SIST
 */
public class RunJavaMemo {
	
	
	public Font readFontInfo() throws IOException {
		BufferedReader br=null;
		Font	font=null;
		
		try {
			br=new BufferedReader(new FileReader("c:/dev/temp/memo.dat"));
			String readFont=br.readLine();//�����о���̱�
			String[] temp=readFont.split(",");
			font=new Font(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));//�޸������̺�Ʈ
		}finally {
			if(br!=null) {br.close();}
		}
		return font;
		
	}
	/**
	 * �ڹ�Ŭ������ �����ϴ� �� : Java Application
	 * @param args
	 */
	public static void main(String[] args) {
		RunJavaMemo rjm=new RunJavaMemo();
		Font font=null;
		try {
			font=rjm.readFontInfo();
		} catch (IOException e) {
			e.printStackTrace();
		}
		new JavaMemo(font);//�ν��Ͻ�
	}//main

}//class



