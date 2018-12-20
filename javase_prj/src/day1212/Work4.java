package day1212;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//�߰��� ������ �̸�, ���� ,�ּҸ� List�� �߰��ϰ� TA�� �ʱ�ȭ 
//List�� �������� Ŭ���ϸ� ������ ���� TF�� �Էµȴ�.
//������ �������� ����Ʈ�� �������� ���õǾ����� Ȯ���� TF�� ������ �ش� ���� ����
//������ �������� ����Ʈ�� �������� ���õǾ����� Ȯ���� �� TF�� ���� ��ġ�ϴ�
//�������� ���� 
//�ݱⰡ �������� ���α׷��� �����Ѵ�.
@SuppressWarnings("serial")
public class Work4 extends Frame {

	private TextField tfName,tfAge,tfAdd;
	private Button btn1, btn2, btn3,btn4;
	private List list;
	
	public Work4() {
		
	Label lblName=new Label("�̸�");
	Label lblAge=new Label("����");
	Label lblAdd=new Label("�ּ�");
	
	Label lableList =new Label();
	lableList.setText("List"); 
	
	tfName=new TextField(10);
	tfAge=new TextField(10);
	tfAdd=new TextField(10);
	
	list=new List();

	
	btn1=new Button("�߰�");
	btn2=new Button("����");
	btn3=new Button("����");
	btn4=new Button("�ݱ�");
	
	
	Panel panelCenter=new Panel();
	Panel pCenterLeft=new Panel();
	Panel pCenterRight=new Panel();
	panelCenter.setLayout(new GridLayout(1, 2));
	panelCenter.add(pCenterLeft);
	panelCenter.add(pCenterRight);
	
	pCenterLeft.setLayout(new GridLayout(3, 2));
	pCenterLeft.add(lblName);
	pCenterLeft.add(tfName);
	pCenterLeft.add(lblAge);
	pCenterLeft.add(tfAge);
	pCenterLeft.add(lblAdd);
	pCenterLeft.add(tfAdd);
	
	pCenterRight.setLayout(new GridLayout(2, 1));
	pCenterRight.add(lableList);
	pCenterRight.add(list);
	
	Panel panelSouth=new Panel();
	panelSouth.add(btn1);
	panelSouth.add(btn2);
	panelSouth.add(btn3);
	panelSouth.add(btn4);
	
	add("Center",panelCenter);
	add("South", panelSouth);
	
	//����
	Work4Evt we =new Work4Evt(this);
	addWindowListener(we);
	tfName.addTextListener(we);
	tfAge.addTextListener(we);
	tfAdd.addTextListener(we);
	btn1.addActionListener(we);
	btn2.addActionListener(we);
	btn3.addActionListener(we);
	btn4.addActionListener(we);
	list.addItemListener(we);
	
	setBounds(200, 200, 300, 250);
	
	setVisible(true);
	

	

	}
	
	
	public TextField getTfName() {
		return tfName;
	}


	public TextField getTfAge() {
		return tfAge;
	}


	public TextField getTfAdd() {
		return tfAdd;
	}


	public Button getBtn1() {
		return btn1;
	}


	public Button getBtn2() {
		return btn2;
	}


	public Button getBtn3() {
		return btn3;
	}


	public Button getBtn4() {
		return btn4;
	}


	public List getList() {
		return list;
	}


	public static void main(String[] args) {
		new Work4();
	}

}
