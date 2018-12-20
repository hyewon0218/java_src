package day1211;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Has a ����� �̺�Ʈ ó��
 * @author SIST
 */
//2. �̺�Ʈ ó�� ��ü�� ����
public class EventHandlingHasA implements ActionListener{
//EventHandlingHasA �� Design�� ������ �ִ�.
	//2. has a ���踦 �����ϰ� ����� ��ü�� ����
	private Design design;
	
	public EventHandlingHasA(Design design) {
		this.design=design;//this�� �ν���Ʈ ������
	}
	
	@Override
	
	//3. abstract method override
	public void actionPerformed(ActionEvent ae) {
		//�̺�Ʈ�� �߻����� �� ó���� �ڵ�
		System.out.println("���޹��� Design��ü"+design);
		design.dispose();//�����첨�� ������ ����ִ��� ����ؾ��Ѵ�.
	}

}//class
