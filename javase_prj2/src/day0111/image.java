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
//		JTable jt=new JTable(dtm);//입력된 객체의 toString()호출하는 기능을 가지고있음.
//		//들어간그대로표현되고싶다면? Override-부모의 기능을 수정 
//		JTable jt=new JTable() {//anonymous 
//			public class getColumnClass(int column){//모든컬럼의
//					return getValueAt(row,column).getClass{};//입력된 객체의 원래값
//											->입력된 행에대해서
//		}

		String[] columnNames = { "로고", "url", "특징" };
		img1 = new ImageIcon("C:\\dev\\daum.png");
		img2 = new ImageIcon("C:\\dev\\naver.png");
		img3 = new ImageIcon("C:\\dev\\google.png");
		jlb = new JLabel[9];
		msg = new Object[][] { {img1, "http://daum.net", "카카오프렌즈" }, { img2, "http://naver.com", "웹툰" },
				{ img3, "http://google.com", "검색엔진이좋아요" } };
		// 입력된 클래스가 그대로 Cell(cloumn)에 표현되도록 method Override
		// getColumClass(int column)
		dtm = new DefaultTableModel(msg, columnNames);
		jtb = new JTable(dtm) {
			@Override
			public Class getColumnClass(int column) {
				// row-Jtable에 입력된 이차원 배열의 행에 속한다면
				// 모든 컬럼의 값을 입려된 형으로 반환한다.
				return getValueAt(0, column).getClass();
			}
		};

		JScrollPane jsp = new JScrollPane(jtb);
		jtb.getTableHeader().setReorderingAllowed(false);// 컬럼 이동 막기
		jtb.getTableHeader().setResizingAllowed(false);// 컬럼의 크기변경 막기
		jtb.setRowHeight(100);
		add(jsp);

		setBounds(200, 200, 600, 400);
		setVisible(true);

	}

	public static void main(String[] args) {
		new image();
	}

}
