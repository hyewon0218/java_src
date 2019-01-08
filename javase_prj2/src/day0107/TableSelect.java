package day0107;

import java.awt.GridLayout;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class TableSelect extends JFrame{
	
	private JLabel jlbTS;
	private JComboBox<String> jcbTS;
	private JButton jbtTS;
	private JTextArea jtaTS;
	private DefaultTableModel dtmTS;

	public JTextArea getJtaTS() {
		return jtaTS;
	}

	public DefaultTableModel getDtmTS() {
		return dtmTS;
	}

	public TableSelect () {
		jlbTS=new JLabel("���̺� ����");
		jcbTS=new JComboBox<String>();
		jbtTS=new JButton("����");
		
		setLayout(new GridLayout(3, 1));
		JPanel panel=new JPanel();
		panel.add(jlbTS);
		panel.add(jcbTS);
		panel.add(jbtTS);
		
		String[] columnNames= {"�÷���","��������","ũ��","�������"};
		dtmTS =new DefaultTableModel(columnNames, 5);
		JTable tableTS=new JTable(dtmTS);
		
		tableTS.getTableHeader().setReorderingAllowed(false);//�÷� �̵� ����
		tableTS.setRowHeight(24);
		JScrollPane jsp=new JScrollPane(tableTS);
		
		add("North",panel);
		add("Center",jsp);
		
		TableSelectEvt tse=new TableSelectEvt(this);
		try {
			tse.Table("fsf");//�޼ҵ����
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			
		}
		
		
		jbtTS.addActionListener(tse);

		setBounds(100, 100, 500, 300);
		setVisible(true);
		
	}
	
	public JLabel getJlbTS() {
		return jlbTS;
	}

	public JComboBox<String> getJcbTS() {
		return jcbTS;
	}

	public JButton getJbtTS() {
		return jbtTS;
	}

	public static void main(String[] args) {
		new TableSelect();
	}
}
