package day0109;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import kr.co.sist.connection.GetConnection;

public class QueryViewEvt extends WindowAdapter implements ActionListener{

	private QueryView qv;///
	private StringBuilder sql; 
	private boolean flagFirstCol;
	private String columnName;
	private String primaryName;
	
	public QueryViewEvt(QueryView qv) {
		this.qv=qv;
	}

	public void comB(String dataType)throws SQLException{
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			Connection con=null;
			Statement stmt=null;
			ResultSet rs=null;
			
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=DriverManager.getConnection(url, id, pass);
	}
//			try {
//				stmt=con.createStatement();
//				StringBuilder dataType1 =new StringBuilder();
//			}
//			
//		}finally {
//			
//		}
	
	@Override
	public void windowClosing(WindowEvent e) {
		qv.dispose();
	}
	
	
	public void inputTN() {
		String tableName=qv.getJtfTN().getText().trim();
		
		if(tableName!=null&&!tableName.equals("")) {
			createStartQuery(tableName);
		}else {
			JOptionPane.showMessageDialog(qv, "���̺���� �Է��ϼ���.");
			qv.getJtfTN().requestFocus();
		}
//		if(qv.getJtf()!=null) {
//			String q=qv.getJtaTN().getText();
//			String p="create table "+q+"(\n);";
//		qv.getJtf().setText(p);
//		}
	}
	
	public void createStartQuery(String tableName) {
		sql=new StringBuilder();
		sql.append("create table ").append(tableName).append("(");
	}
	
//	public void createStart()

	public void inputCN () {
		String columnName= qv.getJtfCN().getText().trim();
		if(columnName.isEmpty()) {
			JOptionPane.showMessageDialog(qv, "�÷����� �Է��ϼ���.");
			qv.getJtfCN().requestFocus();
		}
	}
	public void selectDT() {
		String dataType=qv.getJcbDT().getSelectedItem().toString();
		if(dataType.equals("date")) {
			
			qv.getJtfP().setText(" ");
			JOptionPane.showMessageDialog(qv, "���������� date�� ��� ũ�Ⱑ ������մϴ�.");
			//��������?
		}
	}
		
	public void inputSize() {
		String size=qv.getJtfP().getText().trim();
		if(size.isEmpty()) {
			JOptionPane.showMessageDialog(qv, "ũ�⸦ �Է��ϼ���.");
			qv.getJtfP().requestFocus();
		}
		
	}
	public void selectCon() {
		String primary=qv.getJcbCon().getSelectedItem().toString();
		String primaryName=qv.getJtfConN().getText().trim();
		if(!primary.equals("null")||primary.equals("not null")) {
			qv.getjtf
//			JOptionPane.showMessageDialog(qv, "������׸��� ");
		}else {
			if(!) {
				
			}
			.append("constraint").append(primaryName).append(" ").append("constraint")).toString();
			qv.getJta().setText(i);
			System.out.println(i);
		
			
		
		}
	}
		
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()==qv.getJbtP1()) {
		
			inputTN();				
			qv.getJta().setText(sql.toString());
			qv.getJta().append(");");
		
		}
//		
//		public void inputTF() {
//			String tableName=qv.getJtfTN().getText().trim();
//			
//			if(tableName!=null&&!tableName.equals("")) {
//				createStartQuery(tableName);
//			}else {
//				JOptionPane.showMessageDialog(qv, "���̺���� �Է��ϼ���.");
//				qv.getJtfTN().requestFocus();
//			}
		
		
		if (ae.getSource()==qv.getJbtP2()) {
			inputCN();
//			if() {}
			selectDT();
			inputSize();
			selectCon();
			if(flagFirstCol) {
				sql.append(",\n");
			}
		
			String p=qv.getJtfP().getText();
			String cn=qv.getJtfCN().getText();
			String con=qv.getJtfConN().getText();
			String dt=qv.getJcbDT().getSelectedItem().toString();
			String con1=qv.getJcbCon().getSelectedItem().toString();
	
			String e=(sql.append("\n").append("\t").append(cn).append(" ")
					.append(dt).append(" ").append(p).append(" ").append(con1).append(" ").append(con).toString());
//			System.out.println(e);//���⿡ �̾���̱�
			qv.getJta().setText(e.toString());
			qv.getJta().append(");");
			flagFirstCol=true;
			
//			qv.getJta().setText(e);
//			qv.getJta().append("constraint").
		}
		if (ae.getSource()==qv.getJcbDT()) {
			qv.getJcbDT().getSelectedItem().toString();
		}
		if(ae.getSource()==qv.getJcbCon()) {
			
		}
		if(ae.getSource()==qv.getJbtTC()) {
			
		}
		if(ae.getSource()==qv.getJbtNull()) {
			
		}
	}
}
