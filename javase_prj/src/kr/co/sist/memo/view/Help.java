package kr.co.sist.memo.view;
//�޸�������
//(T.A)�� �޸����� java�� ����������� ������ �ڵ� ���� �� ������ �� �� �ֽ��ϴ�.
//��. �� �ڵ带 ����Ͽ� �������� ������ �ҽ������� ��Ģ���� �Ѵ�.GMU
//�ۼ��� : ���ü�
//version:1.0
//Ȯ�ι�ư������ ���� 

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
		super(jm,"����",true);
		ta=new TextArea("�޸��� ���� �� �޸����� Java�� �����������\n"+"������ �ڵ� ���� �� ������ �� �ֽ��ϴ�. \n"
				+ "��, �� �ڵ带 ����Ͽ� �����Ͽ��� �� �ҽ������� ��Ģ���� �Ѵ�. GNU\n\n"+"�ۼ���:������");
		btn=new Button("Ȯ��");
		
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
