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
 * MVC Pattern�� ����� class
 * 
 * @author SIST
 */
@SuppressWarnings("serial")
public class UseJTable extends JFrame implements ActionListener {

	private JTable jt;// inner class���� ���� ���ؼ� �ν��Ͻ�������~
	private JButton btnAdd;
	private DefaultTableModel dtm;// �ν��Ͻ�������ü����
	private UseJTable ujt;

	public UseJTable() {// �ν��Ͻ����� ����
		super("JTable ����");
		ujt = this;// ?
		// 1. �����͸� �����ϴ� Model Ŭ���� ����
		String[] columnNames = { "��ȣ", "�̸�", "�ּ�", "�̸���" };
		String[][] rowData = { { "1", "������", "��õ�� �ҷ���", "chan@test.com" },
				{ "2", "���ü�", "����� ���ε�", "teack@sist.co.kr" }, { "3", "������", "��⵵ �Ⱦ��", "hyun@gmail.com" } };

		dtm = new DefaultTableModel(rowData, columnNames) {// anonymous inner class
			// �������߰�����
			@Override
			public boolean isCellEditable(int row, int column) {//���� �Ұ���
				return false;
			}
		};
		// 2. �����͸� �����ִ� View Ŭ���� ����
		jt = new JTable(dtm);// 16���� ��ü�� jtable��
		// ���̺� �÷��� ũ�� ���� : �÷��� �ϳ��� ���̸� �����ϸ� ���� ��� �÷���
		// ������ ũ�⸦ ����޴´�.
		// �÷�ũ�⺯�� 1. : �÷��� ��´�.
		TableColumn tc = jt.getColumnModel().getColumn(0);
		// �÷�ũ�⺯�� 2. : �÷��� ũ�� ����.
		tc.setPreferredWidth(30);

		jt.getColumnModel().getColumn(1).setPreferredWidth(100);
		jt.getColumnModel().getColumn(2).setPreferredWidth(230);
		jt.getColumnModel().getColumn(3).setPreferredWidth(140);

		// ���̺� ���� ���� ����
		jt.setRowHeight(50);

		btnAdd = new JButton("�������߰�");

		// Column�� �̸��� ScrollBar�� ����� �� �ֵ��� JScrollPane�� ��ġ
		JScrollPane jsp = new JScrollPane(jt);
		JPanel jp = new JPanel();
		jp.add(btnAdd);

		// ��ġ
		add("Center", jsp);
		add("South", jp);

		// �̺�Ʈ ���
		btnAdd.addActionListener(this);

		UseJTable.TableEvt te = this.new TableEvt();// inner class ��üȭ
		jt.addMouseListener(te);

		setBounds(100, 100, 500, 300);// 500�̳� ����!!
		setVisible(true);// window component �������� �ʼ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String inputData = JOptionPane.showInputDialog("�������Է�\n��)��ȣ,�̸�,�ּ�,�̸���");

		String[] tempData = inputData.split(",");

		if (tempData.length != 4) {
			JOptionPane.showMessageDialog(this, "�Էµ������� ���´� \n��ȣ,�̸�,�ּ�,�̸��� �̾���մϴ�.", "�Է¿���", JOptionPane.ERROR_MESSAGE);
			return;// void�϶� ȣ���Ѱ����� ���ư���!
		}

		// �Էµ� �����͸� ȭ�鿡 �����ֱ� ����DfaultTableModel�� �߰�(���߰�)
		dtm.addRow(tempData);// object�� string�� �θ��̹Ƿ� tempdata�� �� �� �ִ�.??

	}

//////////////////////////////////inner class ����////////////////////////////////////////
	public class TableEvt extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent me) {
//		System.out.println("�༱�� : "+jt.getSelectedRow()+"������ : "+jt.getSelectedColumn());
//		String selectValue=(String)jt.getValueAt(jt.getSelectedRow(), jt.getColumnCount());//casting(�⺻��<������)/object�� String���� �� �� ����(�θ���ڽ��̴�������)
//		String selectValue0=(String)jt.getValueAt(jt.getSelectedRow(), 0);//casting(�⺻��<������)/object�� String���� �� �� ����(�θ���ڽ��̴�������)
//		String selectValue1=(String)jt.getValueAt(jt.getSelectedRow(), 1);
//		String selectValue2=(String)jt.getValueAt(jt.getSelectedRow(), 2);
//		String selectValue3=(String)jt.getValueAt(jt.getSelectedRow(), 3);//�� �� �ȵɰ�� �� �ڵ尡 �� ����!

			StringBuilder viewData = new StringBuilder();
			int selectedRow = jt.getSelectedRow();
			int columnCount = jt.getColumnCount();

			int flag = JOptionPane.showConfirmDialog(ujt, "���� ������ ��ȸ, �ƴϿ��� ������ ������ �����մϴ�.");

			switch (flag) {
			case JOptionPane.OK_OPTION:
				for (int i = 0; i < columnCount; i++) {
					viewData.append(jt.getValueAt(selectedRow, i)).append("\n");
				}

				JOptionPane.showMessageDialog(ujt/* �θ� */, viewData);// ���⼭ this�� MouseAdapter(component�� �ƴ�!)�� ����x

				break;
			case JOptionPane.NO_OPTION:
				
				switch (JOptionPane.showConfirmDialog(ujt, "���� �����Ͻðڽ��ϱ�?")) {// ����� ������ �ݵ�� �����!
				case JOptionPane.OK_OPTION:
					dtm.removeRow(selectedRow);	
				}
			}

		}

	}

///////////////////////////////inner class ��////////////////////////////////////////////	
	public static void main(String[] args) {
		new UseJTable();// �ν��Ͻ�ȭ - ��ü����
	}// main
}// class
