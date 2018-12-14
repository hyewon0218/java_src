package kr.co.sist.memo.view;
//메모장정보
//(T.A)이 메모장은 java로 만들어졌으며 누구나 코드 수정 및 배포를 할 수 있습니다.
//단. 이 코드를 사용하여 개선했을 때에는 소스공개를 원칙으로 한다.GMU
//작성자 : 정택성
//version:1.0
//확인버튼누르면 닫힘 

import java.awt.Button;
import java.awt.Dialog;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.memo.evt.HelpEvt;
import kr.co.sist.memo.view.JavaMemo;

public class Help extends Dialog{

	private TextArea ta;
	private Button btn;
	public Help(JavaMemo jm) {
		super(jm,"도움말",true);
		ta=new TextArea("메모장 정보 이 메모장은 Java로 만들어졌으며\n"+"누구나 코드 수정 및 배포할 수 있습니다. \n"
				+ "단, 이 코드를 사용하여 개선하였을 때 소스공개를 원칙으로 한다. GNU\n\n"+"작성자:최혜원");
		btn=new Button("확인");
		
		setLayout(null);
		
		ta.setBounds(50, 80, 410, 200);
		btn.setBounds(200, 350, 100, 50);
		
		add(ta);
		add(btn);
		
		HelpEvt he=new HelpEvt(this);
		btn.addActionListener(he);
	
		addWindowListener(he);
		
		setBounds(500, 500, 500, 450);
		setVisible(true);
		
		addWindowListener(he);
		
	}
	public TextArea getTa() {
		return ta;
	}
	public Button getBtn() {
		return btn;
	}
	
}
