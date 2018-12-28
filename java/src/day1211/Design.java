package day1211;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;

/**
 * has a ������ �̺�Ʈ ó��
 * �����ΰ� �̺�Ʈó�� �ڵ带 �и��Ͽ� �ڵ��� ���⵵�� ���� �� �ִ�.
 * @author SIST
 */
//1. ������ ������Ʈ ���
public class Design extends Frame {
	//2. �̺�Ʈ ó���� �����ִ� component�� ����
	private Button btn;
	
	public Design() {
		super("������");
		//3. ������Ʈ ����
		btn=new Button("Ŭ��");
		
		//4. ��ġ
		Panel panel=new Panel();
		panel.add(btn);
		
		add("Center",panel);//���Ϳ��гι�ġ
		
		//5. �̺�Ʈ ���(�ٽõ��ƿ�)
		//�̺�Ʈ ó�� ��ü �����ϰ� has a ����
		EventHandlingHasA ehha=new EventHandlingHasA(this);
		System.out.println("������ ������ ��ü"+this);
		//������Ʈ�� �̺�Ʈ�� ��� 
		btn.addActionListener(ehha);//��ư���� �̺�Ʈ�� �߻��ϸ� 
		//ehha ��ü�� Override�� method���� �̺�Ʈ ó��
		
		//6. ������ ũ�⸦ ����
		setBounds(100, 100, 400, 300);
		//7. ����ڿ��� �����ֱ� 
		setVisible(true);
		//8. ������ �����̺�Ʈ ó��
		
	}
	//�ۿ��� ��ư�� �޾ư��� method
	
	public Button getBtn() {
		return btn;
	}
	
	public static void main(String[] args) {
		new Design();
	}//main

}//class
