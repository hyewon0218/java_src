package day1211;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Inner class�� ����� �̺�Ʈ ó�� : 
 * �����ο� �ش��ϴ� �̺�Ʈ ó�� �ڵ尡 �ſ� ���ų� Ư�������ο� �ش��ϴ� �̺�Ʈ�� ó���� �� 
 * @author SIST
 */

//1. ������ ������Ʈ�� ��� 
@SuppressWarnings("serial")
public class EventHandlingInnerClass extends Frame{
	//2. �̺�Ʈ ó�� ���� ������Ʈ�� ��üȭ
	private Button btn;
	
	public EventHandlingInnerClass() {
		super("inner class�� �̺�Ʈ ó��");
		//������Ʈ ����
		btn=new Button("Ŭ��");
		//4. ��ġ
		Panel panel=new Panel();
		panel.add(btn);
		
		add("Center",panel);
		//5. �̺�Ʈ ���
		//Inner class ���� 
		EventHandlingInnerClass.InnerActionImple iai=this.new InnerActionImple();
		//������Ʈ�� �̺�Ʈ�� ���
		btn.addActionListener(iai);
		
		//6. ������ ũ�� ����
		setBounds(100, 100, 300, 300);
		
		//7. ����ڿ��� �����ֱ�
		setVisible(true);
		
		
	}
	/////////////////////////////////////////////////////Inner class ����///////////////////////////////////////////////////////
	//5-1. Inner class�� �̺�Ʈó�� �����ʸ� ����
	
	public class InnerActionImple implements ActionListener{

		@Override
		//5-2. abstract method Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("��ư�� Ŭ���Ͽ����ϴ�. o(>.<)o ��~~~~");
			dispose();//���� Ŭ���������� �ٱ� Ŭ������ �ڿ��� ����ó�� ����� �� �ִ�.
		}
		
	}
	
	/////////////////////////////////////////////////////Inner class ��///////////////////////////////////////////////////////
	public Button getBtn() {
		return btn;
	}
	public static void main(String[] args) {
		new EventHandlingInnerClass();
	}//main

}//class
