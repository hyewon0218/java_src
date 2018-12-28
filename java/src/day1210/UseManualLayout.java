package day1210;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ������ġ : �����ڰ� ������Ʈ�� ��ġ ��ġ�� ũ�⸦ �����ϴ� ��ġ���
 * 
 * @author SIST
 */
//1. ������ ������Ʈ ���
@SuppressWarnings("serial")
public class UseManualLayout extends Frame {

	public UseManualLayout() {
		super("������ġ");
		// 1. ������Ʈ ����
		Label lbl=new Label();
		lbl.setText("��");//������x
		TextField tf =new TextField();
		Button btn =new Button("Ŭ��");
		// 2. ��ġ������ ����(����) : BorderLayout ->null ����
		setLayout(null);
		// 3. ��ġ
		//������Ʈ�� ��ǥ, ũ�� ����
		lbl.setLocation(10, 35);//��ġ�Ǵ� ��ǥ
		lbl.setSize(80,20);//��ġ ũ��
		tf.setBounds(50, 100, 120, 25);//x,y,w,h(�����ϸ� ���Ա� ����)
		btn.setBounds(250, 200, 120, 23);
		
		add(lbl);//Frame�� ��ġ
		add(tf);//Frame�� ��ġ
		add(btn);//Frame�� ��ġ
		
		// 4. �������� ��ǥ ����
//		setLocation(100, 200); //(������ (0,0)���� ���� window)
		// 5. �������� ũ�� ����
//		setSize(500, 600);
		setBounds(200, 100, 400, 250);
		setResizable(false); 
		// 6. ����ڿ��� �����ֱ�
		setVisible(true);
		// 7. ����ó��
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
	}

	public static void main(String[] args) {
		new UseManualLayout();
	}// main

}// class
