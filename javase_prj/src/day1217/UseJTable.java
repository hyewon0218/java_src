package day1217;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView.TableCell;

/**
 * MVC Pattern이 적용된 class
 * 
 * @author SIST
 */
@SuppressWarnings("serial")
public class UseJTable extends JFrame implements ActionListener {

	private JTable jt;// inner class에서 쓰기 위해서 인스턴스변수로~
	private JButton btnAdd;
	private DefaultTableModel dtm;// 인스턴스변수객체생성
	private UseJTable ujt;

	public UseJTable() {// 인스턴스변수 힙에
		super("JTable 연습");
		ujt = this;// ?
		// 1. 데이터를 관리하는 Model 클래스 생성
		String[] columnNames = { "번호", "이름", "주소", "이메일" };
		String[][] rowData = { { "1", "이재찬", "인천시 소래동", "chan@test.com" },
				{ "2", "정택성", "서울시 구로동", "teack@sist.co.kr" }, { "3", "이재현", "경기도 안양시", "hyun@gmail.com" } };

		dtm = new DefaultTableModel(rowData, columnNames) {// anonymous inner class
			// 데이터추가삭제
			@Override
			public boolean isCellEditable(int row, int column) {//변경 불가능
				return false;
			}
		};
		// 2. 데이터를 보여주는 View 클래스 생성
		jt = new JTable(dtm);// 16개의 객체가 jtable에
		// 테이블 컬럼의 크기 변경 : 컬럼은 하나의 넓이를 변경하면 하위 모든 컬럼은
		// 동일한 크기를 적용받는다.
		// 컬럼크기변경 1. : 컬럼을 얻는다.
		TableColumn tc = jt.getColumnModel().getColumn(0);
		// 컬럼크기변경 2. : 컬럼의 크기 변경.
		tc.setPreferredWidth(30);

		jt.getColumnModel().getColumn(1).setPreferredWidth(100);
		jt.getColumnModel().getColumn(2).setPreferredWidth(230);
		jt.getColumnModel().getColumn(3).setPreferredWidth(140);

		// 테이블 행의 높이 변경
		jt.setRowHeight(50);

		btnAdd = new JButton("데이터추가");

		// Column의 이름과 ScrollBar를 사용할 수 있도록 JScrollPane에 배치
		JScrollPane jsp = new JScrollPane(jt);
		JPanel jp = new JPanel();
		jp.add(btnAdd);

		// 배치
		add("Center", jsp);
		add("South", jp);

		// 이벤트 등록
		btnAdd.addActionListener(this);

		UseJTable.TableEvt te = this.new TableEvt();// inner class 객체화
		jt.addMouseListener(te);

		setBounds(100, 100, 500, 300);// 500이내 주의!!
		setVisible(true);// window component 보여질때 필수
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String inputData = JOptionPane.showInputDialog("데이터입력\n예)번호,이름,주소,이메일");

		String[] tempData = inputData.split(",");

		if (tempData.length != 4) {
			JOptionPane.showMessageDialog(this, "입력데이터의 형태는 \n번호,이름,주소,이메일 이어야합니다.", "입력오류", JOptionPane.ERROR_MESSAGE);
			return;// void일때 호출한곳으로 돌아가라!
		}

		// 입력된 데이터를 화면에 보여주기 위해DfaultTableModel에 추가(행추가)
		dtm.addRow(tempData);// object가 string의 부모이므로 tempdata가 들어갈 수 있다.??

	}

//////////////////////////////////inner class 시작////////////////////////////////////////
	public class TableEvt extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent me) {
//		System.out.println("행선택 : "+jt.getSelectedRow()+"열선택 : "+jt.getSelectedColumn());
//		String selectValue=(String)jt.getValueAt(jt.getSelectedRow(), jt.getColumnCount());//casting(기본형<참조형)/object가 String으로 들어갈 수 없음(부모는자식이누군지모름)
//		String selectValue0=(String)jt.getValueAt(jt.getSelectedRow(), 0);//casting(기본형<참조형)/object가 String으로 들어갈 수 없음(부모는자식이누군지모름)
//		String selectValue1=(String)jt.getValueAt(jt.getSelectedRow(), 1);
//		String selectValue2=(String)jt.getValueAt(jt.getSelectedRow(), 2);
//		String selectValue3=(String)jt.getValueAt(jt.getSelectedRow(), 3);//몇 개 안될경우 이 코드가 더 나음!

			StringBuilder viewData = new StringBuilder();
			int selectedRow = jt.getSelectedRow();
			int columnCount = jt.getColumnCount();

			int flag = JOptionPane.showConfirmDialog(ujt, "예를 누르면 조회, 아니오를 누르면 삭제를 수행합니다.");

			switch (flag) {
			case JOptionPane.OK_OPTION:
				for (int i = 0; i < columnCount; i++) {
					viewData.append(jt.getValueAt(selectedRow, i)).append("\n");
				}

				JOptionPane.showMessageDialog(ujt/* 부모 */, viewData);// 여기서 this는 MouseAdapter(component가 아님!)라 쓸수x

				break;
			case JOptionPane.NO_OPTION:
				
				switch (JOptionPane.showConfirmDialog(ujt, "정말 삭제하시겠습니까?")) {// 변경과 삭제는 반드시 물어보고!
				case JOptionPane.OK_OPTION:
					dtm.removeRow(selectedRow);	
				}
			}

		}

	}

///////////////////////////////inner class 끝////////////////////////////////////////////	
	public static void main(String[] args) {
		new UseJTable();// 인스턴스화 - 객체생성
	}// main
}// class
