package day0111;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class image extends JFrame {

	private JLabel[] jlb;
	private JTable jtb;
	private DefaultTableModel dtm;
	private ImageIcon img1, img2, img3;
	private Object[][] msg;

	public image() {

//		Object [][] rowData=new Object[][];
//		rowData [0][0]=new ImageIcon("C:\\dev\\daum.png");
//		rowData [0][1]=new String("http://daum.net") ;
//		rowData [0][2]=new ImageIcon();
//		DefaultTableModel dtm=new DefaultTableModel(rowData, );
//		JTable jt=new JTable(dtm);//�Էµ� ��ü�� toString()ȣ���ϴ� ����� ����������.
//		//���״��ǥ���ǰ�ʹٸ�? Override-�θ��� ����� ���� 
//		JTable jt=new JTable() {//anonymous 
//			public class getColumnClass(int column){//����÷���
//					return getValueAt(row,column).getClass{};//�Էµ� ��ü�� ������
//											->�Էµ� �࿡���ؼ�
//		}

		String[] columnNames = { "�ΰ�", "url", "Ư¡" };
		img1 = new ImageIcon("C:\\dev\\daum.png");
		img2 = new ImageIcon("C:\\dev\\naver.png");
		img3 = new ImageIcon("C:\\dev\\google.png");
		jlb = new JLabel[9];
		msg = new Object[][] { {img1, "http://daum.net", "īī��������" }, { img2, "http://naver.com", "����" },
				{ img3, "http://google.com", "�˻����������ƿ�" } };
		// �Էµ� Ŭ������ �״�� Cell(cloumn)�� ǥ���ǵ��� method Override
		// getColumClass(int column)
		dtm = new DefaultTableModel(msg, columnNames);
		jtb = new JTable(dtm) {
			@Override
			public Class getColumnClass(int column) {
				// row-Jtable�� �Էµ� ������ �迭�� �࿡ ���Ѵٸ�
				// ��� �÷��� ���� �Է��� ������ ��ȯ�Ѵ�.
				return getValueAt(0, column).getClass();
			}
		};

		JScrollPane jsp = new JScrollPane(jtb);
		jtb.getTableHeader().setReorderingAllowed(false);// �÷� �̵� ����
		jtb.getTableHeader().setResizingAllowed(false);// �÷��� ũ�⺯�� ����
		jtb.setRowHeight(100);
		add(jsp);

		setBounds(200, 200, 600, 400);
		setVisible(true);

	}

	public static void main(String[] args) {
		new image();
	}

}
