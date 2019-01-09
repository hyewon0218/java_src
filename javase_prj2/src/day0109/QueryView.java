package day0109;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class QueryView extends JFrame{

	private JLabel jlbTN,jlbCN,jlbDT,jblP,jlbCon,jlbConN;
	private JTextField jtfTN,jtfCN,jtfP,jtfConN;
	private JComboBox<String> jcbDT,jcbCon;
	private JButton jbtP1,jbtP2,jbtTC,jbtNull;
	private JTextArea jta;
	
	public QueryView() {
		jlbTN=new JLabel("테이블명");
		jlbCN=new JLabel("컬럼명");
		jlbDT=new JLabel("데이터형");
		jblP=new JLabel("크기");
		jlbCon=new JLabel("제약사항");
		jlbConN=new JLabel("제약사항명");
		
		jtfTN=new JTextField();
		jtfCN=new JTextField();
		jtfP=new JTextField();
		jtfConN=new JTextField();
		
		String[] jcbox= {"varchar2","char","number","date"};
		jcbDT=new JComboBox<String>(jcbox);
		String[] jcbox2= {"null","primary key","unique","not null"};
		jcbCon=new JComboBox<String>(jcbox2);
		
		jbtP1=new JButton("추가");
		jbtP1.setText("추가");
		jbtP2=new JButton("추가");
		jbtTC=new JButton("테이블생성");
		jbtNull=new JButton("초기화");
		
		jta=new JTextArea();
		
		setLayout(null);
		
		jlbTN.setBounds(30, 30, 60, 20);
		jlbCN.setBounds(30, 70, 60, 20);
		jlbDT.setBounds(200, 70, 70, 20);//데이터형
		jblP.setBounds(400, 70, 70, 20);//제약사항
		jlbCon.setBounds(30, 150, 60, 20);
		jlbConN.setBounds(200, 150, 80, 20);
		
		jtfTN.setBounds(100, 30, 90, 20);
		jtfCN.setBounds(100, 70, 90, 20);
		jtfP.setBounds(440, 70, 90, 20);
		jtfConN.setBounds(270,150,90,20);
		
		
		jcbDT.setBounds(260, 70, 90, 20);
		jcbCon.setBounds(100, 150, 90, 20);
		
		 jbtP1.setBounds(260, 20, 60, 50);
		 jbtP2.setBounds(440, 150, 60, 50);
		 jbtTC.setBounds(300, 450, 100, 50);
		 jbtNull.setBounds(450, 450, 100, 50);
		 
		 jta.setBounds(30, 200, 520, 200);
		
		add(jlbTN);
		add(jlbCN);
		add(jlbDT);
		add(jblP);
		add(jlbCon);
		add(jlbConN);
		
		add(jtfTN);
		add(jtfCN);
		add(jtfP);
		add(jtfConN);
		
		add(jcbDT);
		add(jcbCon);
		
		add(jbtP1);
		add(jbtP2);
		add(jbtTC);
		add(jbtNull);
		
		add(jta);
		
		QueryViewEvt qve=new QueryViewEvt(this);
		jbtP1.addActionListener(qve);
		jbtP2.addActionListener(qve);
		jcbCon.addActionListener(qve);
		jcbDT.addActionListener(qve);
		jbtTC.addActionListener(qve);
		jbtNull.addActionListener(qve);
		addWindowListener(qve);
		
		setBounds(200, 150, 600, 600);
		setVisible(true);
	}
	
	

	public JLabel getJlbTN() {
		return jlbTN;
	}



	public void setJlbTN(JLabel jlbTN) {
		this.jlbTN = jlbTN;
	}



	public JLabel getJlbCN() {
		return jlbCN;
	}



	public void setJlbCN(JLabel jlbCN) {
		this.jlbCN = jlbCN;
	}



	public JLabel getJlbDT() {
		return jlbDT;
	}



	public void setJlbDT(JLabel jlbDT) {
		this.jlbDT = jlbDT;
	}



	public JLabel getJblP() {
		return jblP;
	}



	public void setJblP(JLabel jblP) {
		this.jblP = jblP;
	}



	public JLabel getJlbCon() {
		return jlbCon;
	}



	public void setJlbCon(JLabel jlbCon) {
		this.jlbCon = jlbCon;
	}



	public JLabel getJlbConN() {
		return jlbConN;
	}



	public void setJlbConN(JLabel jlbConN) {
		this.jlbConN = jlbConN;
	}



	public JTextField getJtfTN() {
		return jtfTN;
	}



	public void setJtfTN(JTextField jtfTN) {
		this.jtfTN = jtfTN;
	}



	public JTextField getJtfCN() {
		return jtfCN;
	}



	public void setJtfCN(JTextField jtfCN) {
		this.jtfCN = jtfCN;
	}



	public JTextField getJtfP() {
		return jtfP;
	}



	public void setJtfP(JTextField jtfP) {
		this.jtfP = jtfP;
	}



	public JTextField getJtfConN() {
		return jtfConN;
	}



	public void setJtfConN(JTextField jtfConN) {
		this.jtfConN = jtfConN;
	}



	public JComboBox<String> getJcbDT() {
		return jcbDT;
	}



	public void setJcbDT(JComboBox<String> jcbDT) {
		this.jcbDT = jcbDT;
	}



	public JComboBox<String> getJcbCon() {
		return jcbCon;
	}



	public void setJcbCon(JComboBox<String> jcbCon) {
		this.jcbCon = jcbCon;
	}



	public JButton getJbtP1() {
		return jbtP1;
	}



	public void setJbtP1(JButton jbtP1) {
		this.jbtP1 = jbtP1;
	}



	public JButton getJbtP2() {
		return jbtP2;
	}



	public void setJbtP2(JButton jbtP2) {
		this.jbtP2 = jbtP2;
	}



	public JButton getJbtTC() {
		return jbtTC;
	}



	public void setJbtTC(JButton jbtTC) {
		this.jbtTC = jbtTC;
	}



	public JButton getJbtNull() {
		return jbtNull;
	}



	public void setJbtNull(JButton jbtNull) {
		this.jbtNull = jbtNull;
	}



	public JTextArea getJta() {
		return jta;
	}



	public void setJta(JTextArea jta) {
		this.jta = jta;
	}



	public static void main(String[] args) {
		new QueryView();
	}
}
