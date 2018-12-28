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

//추가가 눌리면 이름, 나이 ,주소를 List에 추가하고 TA를 초기화 
//List의 아이템을 클릭하면 선택한 값이 TF에 입력된다.
//변경이 눌려지면 리스트의 아이템이 선택되었는지 확인후 TF의 값으로 해당 값을 수정
//삭제가 눌려지면 리스트의 아이템이 선택되었는지 확인한 후 TF의 값과 일치하는
//아이템을 삭제 
//닫기가 눌려지면 프로그램을 종료한다.
@SuppressWarnings("serial")
public class Work4 extends Frame {

	private TextField tfName,tfAge,tfAdd;
	private Button btn1, btn2, btn3,btn4;
	private List list;
	
	public Work4() {
		
	Label lblName=new Label("이름");
	Label lblAge=new Label("나이");
	Label lblAdd=new Label("주소");
	
	Label lableList =new Label();
	lableList.setText("List"); 
	
	tfName=new TextField(10);
	tfAge=new TextField(10);
	tfAdd=new TextField(10);
	
	list=new List();

	
	btn1=new Button("추가");
	btn2=new Button("삭제");
	btn3=new Button("변경");
	btn4=new Button("닫기");
	
	
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
	
	//연결
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
