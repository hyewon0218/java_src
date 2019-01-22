package day0111;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class NamecardView extends JFrame {
	
	
	private JButton jbtImg,jbtAdd;
	private DefaultTableModel dtmNamecard;
	private JLabel jlPreview;
	private JTextField jtfName,jtfAddr;
	
	public NamecardView() {
		super("���԰���");
		JLabel jlName=new JLabel("�̸�");
		JLabel jlAddr=new JLabel("�ּ�");
		JLabel jlImg=new JLabel("�̹���");
		
		jbtImg=new JButton("�̹�������");
		jbtAdd=new JButton("�����߰�");
		
		String[] columnNames= {"��ȣ", "�̹���","����","�ּ�"};
		Object[][] data=new Object[1][4];
		data[0][0]="";
		data[0][1]="";
		data[0][2]="";
		data[0][3]="";
		dtmNamecard=new DefaultTableModel(data,columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		jlPreview=new JLabel(new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/upload/no_image.png"));
		jtfName=new JTextField();
		jtfAddr=new JTextField();
		
		
		JTable jtaNamecardList=new JTable(dtmNamecard) {
			@Override
			public Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();//
			}
		};
			
		JScrollPane jsp=new JScrollPane(jtaNamecardList);
		jsp.setBorder(new TitledBorder("���Ը���Ʈ"));
		
		jtaNamecardList.getColumnModel().getColumn(0).setPreferredWidth(30);
		jtaNamecardList.getColumnModel().getColumn(1).setPreferredWidth(170);
		jtaNamecardList.getColumnModel().getColumn(2).setPreferredWidth(120);
		jtaNamecardList.getColumnModel().getColumn(3).setPreferredWidth(260);
		
		jtaNamecardList.setRowHeight(200);
		
		jtaNamecardList.getTableHeader().setReorderingAllowed(false);
		
		setLayout(null);//������ġ
		
		jlName.setBounds(10, 20, 80, 25);
		jtfName.setBounds(80, 20, 120, 25);
		jlAddr.setBounds(10, 50, 80, 25);
		jtfAddr.setBounds(80, 50, 120, 25);
		jlImg.setBounds(10, 80, 80, 25);
		jlPreview.setBounds(80, 80, 167, 199);
		
		jbtImg.setBounds(115, 285, 100, 25);
		jbtAdd.setBounds(115, 320, 100, 25);
		jsp.setBounds(260, 20, 600, 500);
		
		add(jlName);
		add(jtfName);
		add(jlAddr);//�г�(�ѹ���)����
		add(jtfAddr);
		add(jlImg);
		add(jlPreview);
		add(jbtImg);
		add(jbtAdd);
		add(jsp);
		
		//�̺�Ʈ ��� :
		NamecardViewController nvc=new NamecardViewController(this);
		addWindowListener(nvc);
		jtfAddr.addActionListener(nvc);
		jtfName.addActionListener(nvc);
		jbtImg.addActionListener(nvc);
		jbtAdd.addActionListener(nvc);
		
		
		
		setBounds(100, 100, 900, 600);
		setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
	}
	
	public JButton getJbtImg() {
		return jbtImg;
	}

	public JButton getJbtAdd() {
		return jbtAdd;
	}

	public DefaultTableModel getDtmNamecard() {
		return dtmNamecard;
	}

	public JLabel getJlPreview() {
		return jlPreview;
	}

	public JTextField getJtfName() {
		return jtfName;
	}

	public JTextField getJtfAddr() {
		return jtfAddr;
	}

	public static void main(String[] args) {
		new NamecardView();
	}//main

}//class