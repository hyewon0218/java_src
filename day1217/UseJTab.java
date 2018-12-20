package day1217;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class UseJTab extends JFrame {

	private UseJTab ujt;
	
	public UseJTab() {
		super("Tab");
		ujt=this;
		//1.탭을 추가할 수 있는 객체 생성.
		JTabbedPane jtp=new JTabbedPane();
		
		//2. 각 탭에 들어갈 컴포넌트를 생성 
		//처음 탭에 들어갈 컴포넌트 
		ImageIcon ii=new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/Images/img1.jpg");
		JLabel jl=new JLabel(ii);
		ImageIcon ii2=new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/Images/img2.jpg");
		JLabel jl2=new JLabel(ii2);
		
		//두번째 탭에 들어갈 컴포넌트
		JPanel jp=new JPanel();
		jp.add(new JLabel("이름"));
		jp.add(new JTextField(30));
		jp.add(new JButton("입력"));

		JPanel tab2=new JPanel();
		tab2.setLayout(new BorderLayout());
		
		jp.setBorder(new TitledBorder("입력데이터"));
		
		JTextArea jta=new JTextArea();
		JScrollPane jsp=new JScrollPane(jta);
		jsp.setBorder(new TitledBorder("결과창"));
		
//		UseJTab.TableEvt te=this.new TableEvt();
//		
//		public class TableEvt 
		//네번째탭 inputdialog "비번을입력하세요"
		//비번이 123이면 1번째탭처럼 이미지 띄우기
		//123이 아니면 첫번째탭으로
		
		
		tab2.add("North",jp);
		tab2.add("Center",jsp);
		
		jtp.addTab("처음탭", jl);
		jtp.addTab("두번째 탭", tab2);
		jtp.addTab("세번째 탭", new JButton("클릭"));
		jtp.addTab("네번째 탭",jl2 );
		
		jtp.addMouseListener(new MouseAdapter() {//?
			@Override
			public void mouseClicked(MouseEvent e) {
				if(jtp.getSelectedIndex()==3) {
					String pw=JOptionPane.showInputDialog(ujt,"비밀번호를 입력하세요","입력",JOptionPane.PLAIN_MESSAGE);//ujt로 창의 가운데 뜨게하기!(부모알게)
					
					if(!pw.equals("123")) {
						jtp.setSelectedIndex(0);
					}
				}
			}
		});
		//배치
		add("Center",jtp);
		
		
		setBounds(100, 100, 600, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new UseJTab();
	}//main
	
	

}//class
