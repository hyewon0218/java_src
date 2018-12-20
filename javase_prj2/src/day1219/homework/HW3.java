package day1219.homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HW3 {

	public HW3() {
		System.out.println("디렉토리명 입력 : ");
		
		//입력
		InputStream is= System.in;
		InputStreamReader isr=new InputStreamReader(is);
		BufferedReader br=new BufferedReader(isr);
		
		try {
		  String path=br.readLine();	
			
		  File file=new File(path);
		  if(file.isFile()) {
			  System.out.println("파일을 취급하지 않습니다.");
		  }else {
			  File[] files=file.listFiles();
			  
			  StringBuilder text=new StringBuilder();
			  text.append("이름\t유형\t크기\t마지막으로 수정한 날짜\n");
			  
			  Date d;
			  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd a hh:mm");
			  
			  
			  for(int i=0; i < files.length;i++) {
				  d=new Date(files[i].lastModified());
				  
				  text.append(files[i].getName()).append("\t\t")
				  .append(files[i].isFile()?"파일":"폴더").append("\t")
				  .append(sdf.format(d)).append("\n");
			  }
			  
			  JTextArea jta=new JTextArea(10,60);
			  jta.setText(text.toString());
			  jta.setEditable(false);
			 JScrollPane jsp=new JScrollPane(jta);
			 
			 JOptionPane.showMessageDialog(null, jsp);
		  }
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new HW3();

	}

}
