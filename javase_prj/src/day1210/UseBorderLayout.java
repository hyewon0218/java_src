package day1210;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * �Ϲ� ������Ʈ�� LayoutManager �� ��� 
 * @author SIST
 */
//1. Window Component ���(����ڿ��� �������� ��)
@SuppressWarnings("serial")
public class UseBorderLayout extends Frame{//����ϸ� �θ� ���� ������(object��������)

	public UseBorderLayout() {//�⺻������
		super("BorderLayout ����");//�θ��� �Ű������޴»����� ȣ��
		//2. ����� �Ϲ� ������Ʈ�� ���� 
		TextField tfNorth =new TextField("North");//�����ڰ��ֱ⶧�����⺻�����ڸ����������Ʈ���� ����
		Label lblEast=new Label("East");
		TextArea taCenter=new TextArea("Center");
		Label lblWest =new Label("West");
		Choice choSouth=new Choice();
		choSouth.add("South");
		
		//3. ��ġ������ ���� : ������ ������Ʈ�� Frame, Dialog��
		//BorderLayout ����
		setLayout(new BorderLayout());
		
		//4. ������Ʈ�� ��ġ�����ڸ� ����Ͽ� ��ġ : 
		//add("��ġ��ġ", ������Ʈ); add(���, ������Ʈ);//overload
		//���ڿ� ��� ����Ͽ� ��ġ
		add("North",tfNorth);//" "���ͷ� ���ڿ�����ҿ� �����
		add("Center",taCenter);//center�� ��ġ�ϸ� �׵θ��� north,west,south,east�ڸ��� �������. 
		//Constant (Field)�� ����Ͽ� ��ġ
		add(BorderLayout.WEST,lblWest);
		add(BorderLayout.EAST,lblEast);
		add(BorderLayout.SOUTH,choSouth);
		
		//5. ������ ũ�� ����
		setSize(400, 400);
	
		//6. ����ڿ��� �����ֱ� 
		setVisible(true);
		//���� 
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		} );
	}
	
	
	public static void main(String[] args) {
		new UseBorderLayout();
	}

}
