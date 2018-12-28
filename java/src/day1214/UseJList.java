package day1214;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * MVC Pattern�� ������� �� Component�� ���
 * 
 * @author SIST
 */
@SuppressWarnings("serial")
public class UseJList extends JFrame implements ActionListener,MouseListener/*, ListSelectionListener*/ {

	private JList<String> jl;// View
	private DefaultListModel<String> dlm;// Model

	private JLabel jlOutput;
	private JButton jb;

	public UseJList() {
		super("JList�� ���");

		dlm = new DefaultListModel<String>();
		dlm.addElement("Java SE 1.8.x");
		dlm.addElement("Oracle");
		dlm.addElement("JDBC");
		dlm.addElement("HTML");
		dlm.addElement("JavaScript");
		dlm.addElement("CSS");

		jl = new JList<String>(dlm);

		// ScrollBar�� ���� List���� ScrollBar ����
		JScrollPane jsp = new JScrollPane(jl);

		jlOutput = new JLabel("���");
		jlOutput.setBorder(new TitledBorder("���þ�����"));

		jb = new JButton("�Է�");

		add("North", jb);
		add("Center", jsp);// ������Ʈ�� ���� ��ũ�ѹ� ��ü�� ��ġ
		add("South", jlOutput);

		// �̺�Ʈ���
		jb.addActionListener(this);
//		jl.addListSelectionListener(this);
		jl.addMouseListener(this);
		
		
		setBounds(100, 100, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String lang = JOptionPane.showInputDialog("��ǻ�� ���� ���� �� �Է����ּ���");

		System.out.println("---" + lang);
		// �Էµ������̹Ƿ� Model ��ü�� ����Ѵ�.
		if (lang != null && !lang.equals("")) {// &&=and
			dlm.addElement(lang);

		}

	}

	public static void main(String[] args) {
		new UseJList();
	}// main

	@Override
	public void mouseClicked(MouseEvent e) {//2
		int idx=jl.getSelectedIndex();//list(jl)�� ���� 1��
		String value = dlm.get(idx);
		//JLabel�� �߰�
		jlOutput.setText(value);
//		System.out.println(value);
		
		//����(View)�� ��(Model)�� ���� 
		dlm.remove(idx);
		System.out.println("����!!!");
	}

	@Override
	public void mousePressed(MouseEvent e) {//1
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {//3
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

//	private boolean flag;//�ڹٽ�ũ��Ʈ������ ����
//	@Override
//	public void valueChanged(ListSelectionEvent lse) {
//		//Ŭ������ �� �ѹ��Ҹ���
//		// ���õ� ������(JList)�� ��(DefaultListModel)�� ���ͼ�
//		if (flag ) {
//			int idx=jl.getSelectedIndex();//list(jl)�� ���� 1��
//			String value = dlm.get(idx);
//			//JLabel�� �߰�
//			jlOutput.setText(value);
////			System.out.println(value);
//			
//			//����(View)�� ��(Model)�� ���� 
//			dlm.remove(idx);
//		}
//		flag=!flag;
//	}

}// class
