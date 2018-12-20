package day1213;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Frame 클래스에서 Dialog클래스를 has a로 사용
 * 
 * @author SIST
 */
@SuppressWarnings("serial")
public class UseDialogHasA extends Frame implements ActionListener {

	private Button btn1, /* Frame에 배치 */btn2/* Dialog */;
	private Dialog d; //actionPerformed의 btn2사용하기위해 인스턴스변수로 올림

	public UseDialogHasA() {
		super("다이얼로그의 사용");

		btn1 = new Button("다이얼로그 사용");
		Panel panel = new Panel();
		panel.add(btn1);

		add("Center", panel);

		btn1.addActionListener(this);

		setBounds(100, 100, 300, 400);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==btn1) {
			createDialog();
		}
		if(ae.getSource()==btn2) {
			d.dispose();
		}
	}

	public void createDialog() {
		// 1. 생성
		d = new Dialog(this, "다이얼로그", false/*비modal 부모창클릭!*/);//Dialog 인스턴스변수로올려줌 /true-modal,false-비modal
		// 2. Dialog에 배치될 컴포넌트를 생성
		Label lbl = new Label("오늘은 눈오는 목요일입니다.(^.~)");
		btn2 = new Button("닫기");

		d.add("Center", lbl);
		d.add("South", btn2);

		btn2.addActionListener(this);

		// 2. 크기 설정
		d.setBounds(200, 200, 300, 300);

		// 다이얼로그는 비저블위에 종료
		d.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				d.dispose();
			}
		});
		// 가시화
		d.setVisible(true);

	}

	public static void main(String[] args) {
		new UseDialogHasA();
	}

}
