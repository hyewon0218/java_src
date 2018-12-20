package day1211;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionEvent�� ����� is a ����� �̺�Ʈ ó�� ���<br>
 * �����ΰ� �̺�Ʈ ó���� �ϳ��� Ŭ���� �ȿ��� ó���Ѵ�.(���� ���� ����� ���ϴ�.)
 * @author SIST
 */
//1. ������� Frame�� ó���ϰ� �������� �̺�Ʈ ó����ü�� ó���Ѵ�.
@SuppressWarnings("serial")
public class EventHandlingIsA extends Frame implements ActionListener{

	//2. �ʵ忡 �̺�Ʈ ó���� ������ �ִ� ������Ʈ�� ���� instance����(Ŭ��������ü�θ������������) ����
	private Button btn;//3. �ν���Ʈ���� (�ܺο������ٰ���/����Ʈ����Ű���ȿ���)
	public EventHandlingIsA () {
		super("is a ����� �̺�Ʈ ó���ϴ� ���");////4.����
		//3. ������Ʈ ����
		btn=new Button("Ŭ��");
		
		//4. ������ ������Ʈ�� �̺�Ʈ���߻���ų �� �ֵ��� �̺�Ʈ�� ��Ͻ��Ѿ� �Ѵ�. addxx
		btn.addActionListener(this);//Argument�� �Էµ�  ��ü(this)�� Override�� method�� ȣ��ȴ�.
		
		Panel panel=new  Panel();		
		panel.add(btn);
		
		//5. ������ ������Ʈ�� ��ġ
		add("Center", panel);
		
		//6. ������ ������Ʈ�� ũ�� ����
		setBounds(100, 100, 300, 300);
		
		//7. ����ڿ��� �����ֱ�
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {////2.�߻�Ŭ����EventHandlingIsA�������̵�
		System.out.println("��ư�� Ŭ���Ǿ����ϴ�.");//�߻�޼���� ������ �������̵�������Ѵ�.
		dispose();
	}
	
	public static void main(String[] args) {
		new EventHandlingIsA();
	}//main

}//class
