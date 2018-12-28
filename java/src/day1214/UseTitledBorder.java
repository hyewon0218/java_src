package day1214;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import kr.co.sist.memo.view.JavaMemo;

public class UseTitledBorder extends JFrame implements ActionListener {

	private JTextField jtfid;
	private JPasswordField jpfPass;
	private JLabel jlOutput;
	
	public UseTitledBorder() {
		super("border 사용");
		
		
		jtfid=new JTextField();
		jpfPass=new JPasswordField();
		jlOutput=new JLabel("결과 : ");
		
		//일반컴포넌트 
		jtfid.setBorder(new TitledBorder("아이디"));
		jpfPass.setBorder(new TitledBorder("비밀번호"));
		jlOutput.setBorder(new TitledBorder("출력창"));
		
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(3, 1));
		//컨테이너 컴포넌트 
		panel.setBorder(new TitledBorder("로그인"));
		
		
		panel.add(jtfid);
		panel.add(jpfPass);
		panel.add(jlOutput);
		
		jtfid.addActionListener(this);
		jpfPass.addActionListener(this);
		
		add("Center",panel);
		
		setBounds(100, 100, 250, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		String id=jtfid.getText().trim();
		if(ae.getSource()==jtfid) {//아이디에서 이벤트가 발생하면
			//아이디에 값이 들어있다면 커서를 비밀번호로 이동 
			if(!id.equals("")) {
				jpfPass.requestFocus();
				
			}
		}
		if(ae.getSource()==jpfPass) {//비밀번호에서 이벤트가 발생하면
			//아이디에 값이 없다면 커서를 아이디로 이동
			if(id.equals("")) {
				jtfid.requestFocus();
				jlOutput.setText("아이디를 입력해주세요");
				return;//반환형이 void인 method에서 코드의 실행을 멈추고 호출한 곳으로
				//돌아가라.(기존의 return은 값을 반환.)
			}
			
			//비밀번호에 값이 없다면 출력창에 "비번입력"을 보여주고 커서를
			//비밀번호에 이동 
			String pass=new String(jpfPass.getPassword());
			if(pass.trim().equals("")) {
				jlOutput.setText("비밀번호를 입력해주세요");
				return;
			}
			//비밀번호에 값이 있다면 아이디가 admit, 비밀번호가 123과 같은지 
			//비교하여 같다면 자바메모장 클래스를 실행
			if(id.equals("admin")&& pass.equals("123")) {
//				new JavaMemo();
				dispose();
			}else {
				jlOutput.setText("아이디나 비밀번호를 확인해주세요.");
			}
			
		}
	}

	public static void main(String[] args) {
			new UseTitledBorder();
	}//main

}//class
