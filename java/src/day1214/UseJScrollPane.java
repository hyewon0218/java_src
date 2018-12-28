package day1214;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * JScrollPane 사용
 * @author SIST
 */
@SuppressWarnings("serial")
public class UseJScrollPane extends JFrame {

	public UseJScrollPane() {
		super("스크롤 바가 없는 객체");
		
		JTextArea jta =new JTextArea();
		//JTextArea내 작성한 글이 J.T.A의 끝에 도달하면 줄 변경
		jta.setLineWrap(true);
		//줄이 변경되면 단어를 보호하면서 줄을 변경(한글은 x)
		jta.setWrapStyleWord(true);
		
		//JTextArea에 SCrollBar 설정
		//1. JScrollPane 생성
		JScrollPane jsp=new JScrollPane(jta);
		//2. 배치
		add("Center",jsp);
		
		setBounds(100, 100, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new UseJScrollPane();
	}//main

}//class
