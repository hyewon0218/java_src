package day1210;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Container Component : 
 * �Ϲ� ������Ʈ�� Container ������Ʈ�� �����Ҽ� �ִ� Component�� ���
 * @author SIST
 */
//1. window component ���
@SuppressWarnings("serial")
public class UsePanel extends Frame{
	
	public UsePanel() {
		super("Container Component ���");
		//2. Component ����
		Label lblName=new Label("�̸�");//��������+�ϴ��� : �밡������̹�
		//�� ���� : Field
		lblName.setBackground(Color.PINK);
		lblName.setForeground(Color.MAGENTA);
		TextField tfName=new TextField(20);
		//������: RGB�� ����� �����ڸ� ��� -> �پ��� ���� ����� �� �ִ�.
		Color back = new Color(0x5CD1E5);//������������ ��ü�� �����Ͽ� �ν��Ͻ��־ ���
		Color fore = new Color(0x8041D9);//������������ ��ü�� �����Ͽ� �ν��Ͻ��־ ���
		tfName.setBackground(new Color(0x5CD1E5));
		tfName.setForeground(new Color(0x8041D9));
		
		Button btnAdd =new Button("�߰�");
		btnAdd.setBackground(back);
		btnAdd.setForeground(fore);
		
		Button btnClose =new Button("����");
		TextArea taDisplay=new TextArea();
		//�۲� :  Dialog, Dialoginput, Monospaced, Serif, or SansSerif
		//Style : PLAIN,BOLD,ITALIC, BOLD|ITALIC
		taDisplay.setFont(new Font("Dialog", Font.BOLD|Font.ITALIC, 20));

		
		//�Ϲ� ������Ʈ�� ��ġ�� �� �ִ� �����̳�������Ʈ�� ����
		Panel panelNorth=new Panel();//FlowLayout 
		//������ �����̳� ������Ʈ�� �Ϲ� ������Ʈ�� ��ġ
		panelNorth.add(lblName);
		panelNorth.add(tfName);
		panelNorth.add(btnAdd);
		panelNorth.add(btnClose);
		
		
		//3. ��ġ������ ����
		setLayout(new BorderLayout());
		//4. ��ġ BorderLayout Ư¡ : �ϳ��� ����(����)���� �ϳ��� ������Ʈ�� ���� ����
		add("North",panelNorth);
//		add("North",lblName);
//		add("North",tfName);
//		add("North",btnAdd);
//		add("North",btnClose);//�������ϳ���������
		add("Center",taDisplay);
		
		//5. ������ ũ�� ����
		setBounds(200, 150, 400, 250);
		//6. ����ڿ��� �����ֱ�
		setVisible(true);
		//������ ���� �̺�Ʈ ó��
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
	}
	
	public static void main(String[] args) {
	
		new UsePanel();
	}//main

}//class
