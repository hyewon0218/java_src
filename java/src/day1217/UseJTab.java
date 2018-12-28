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
		//1.���� �߰��� �� �ִ� ��ü ����.
		JTabbedPane jtp=new JTabbedPane();
		
		//2. �� �ǿ� �� ������Ʈ�� ���� 
		//ó�� �ǿ� �� ������Ʈ 
		ImageIcon ii=new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/Images/img1.jpg");
		JLabel jl=new JLabel(ii);
		ImageIcon ii2=new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/Images/img2.jpg");
		JLabel jl2=new JLabel(ii2);
		
		//�ι�° �ǿ� �� ������Ʈ
		JPanel jp=new JPanel();
		jp.add(new JLabel("�̸�"));
		jp.add(new JTextField(30));
		jp.add(new JButton("�Է�"));

		JPanel tab2=new JPanel();
		tab2.setLayout(new BorderLayout());
		
		jp.setBorder(new TitledBorder("�Էµ�����"));
		
		JTextArea jta=new JTextArea();
		JScrollPane jsp=new JScrollPane(jta);
		jsp.setBorder(new TitledBorder("���â"));
		
//		UseJTab.TableEvt te=this.new TableEvt();
//		
//		public class TableEvt 
		//�׹�°�� inputdialog "������Է��ϼ���"
		//����� 123�̸� 1��°��ó�� �̹��� ����
		//123�� �ƴϸ� ù��°������
		
		
		tab2.add("North",jp);
		tab2.add("Center",jsp);
		
		jtp.addTab("ó����", jl);
		jtp.addTab("�ι�° ��", tab2);
		jtp.addTab("����° ��", new JButton("Ŭ��"));
		jtp.addTab("�׹�° ��",jl2 );
		
		jtp.addMouseListener(new MouseAdapter() {//?
			@Override
			public void mouseClicked(MouseEvent e) {
				if(jtp.getSelectedIndex()==3) {
					String pw=JOptionPane.showInputDialog(ujt,"��й�ȣ�� �Է��ϼ���","�Է�",JOptionPane.PLAIN_MESSAGE);//ujt�� â�� ��� �߰��ϱ�!(�θ�˰�)
					
					if(!pw.equals("123")) {
						jtp.setSelectedIndex(0);
					}
				}
			}
		});
		//��ġ
		add("Center",jtp);
		
		
		setBounds(100, 100, 600, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new UseJTab();
	}//main
	
	

}//class
