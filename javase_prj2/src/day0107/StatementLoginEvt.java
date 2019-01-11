package day0107;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class StatementLoginEvt extends WindowAdapter implements ActionListener {

	private StatementLogin sl;

	public StatementLoginEvt(StatementLogin sl) {
		this.sl = sl;
	}

	@Override
	public void windowClosing(WindowEvent e) {
		sl.dispose();
	}

	public boolean chkNull(String id,String pass) {
		boolean flag=false;
		
		
		try {
		if(id.equals("")) {
			JOptionPane.showMessageDialog(sl, "���̵�� �ʼ� �Է�");
			sl.getJtfId().requestFocus();
			flag=true;
			//���ܸ� ������ �߻� : throw new ����ó�� Ŭ������();
			throw new LoginException();
		}
		if(pass.equals("")) {
			JOptionPane.showMessageDialog(sl, "��й�ȣ�� �ʼ� �Է�");
			sl.getJpfPass().requestFocus();
			flag=true;
		}
		}catch(LoginException le) {
			le.printStackTrace();
		}
		return !flag;//id pass���ٸ� false
	}
	
	public String login(String id,String pass) throws SQLException{
		String name="";
		//1. ����̹��ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");//�� �ܿ��!
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		//2. Connection ���
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String dbo_id="scott";
		String dbo_pass="tiger";
		con=DriverManager.getConnection(url, dbo_id, dbo_pass);//??
		
		try {
		//3. ������ ������ü ���
			stmt=con.createStatement();
		//4. ������ ���� �� ��� ���
			StringBuilder selectName=new StringBuilder();
			selectName
			.append(" select name ")
			.append(" from test_login ")
			.append(" where id='").append(blockSqlInjection(id)).append("'and ")
			.append(" pass='").append(blockSqlInjection(pass)).append("'");
			
			rs=stmt.executeQuery(selectName.toString());
			if(rs.next()) {//�Էµ� ���̵�� ��й�ȣ�� �´� �̸��� ����=>�α��� ���� 
				name=rs.getString("name");
				
			}
		}finally {
		}
		//5. ���� ���� 
		if(rs !=null) {rs.close();}
		if(stmt !=null) {stmt.close();}
		if(con !=null) {con.close();}
		return name;
	}
	public String blockSqlInjection(String data) {
		return data.replace(" ", "").replaceAll("'", "").replaceAll("--", "");//������ֱ�,Ȧ����ǥ���ֱ�,�����¾��ֱ�
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == sl.getJtfId() || ae.getSource() == sl.getJpfPass()
				|| ae.getSource() == sl.getJbtLogin()) {// id���� enter
			String id=sl.getJtfId().getText().trim();
			String pass=new String(sl.getJpfPass().getPassword()).trim();//
			
			if (chkNull(id,pass)) {
				try {
					String name=login(id,pass);
					if(name.isEmpty()) {//�̸������?
						JOptionPane.showMessageDialog(sl, "���̵� ��й�ȣ�� Ȯ�����ּ���.");
						sl.getJtfId().setText("");
						sl.getJpfPass().setText("");
						sl.getJtfId().requestFocus();
						return;
					}
					JOptionPane.showMessageDialog(sl, name+"�� �α��� �ϼ̽��ϴ�.");
					
					JDialog jd=new JDialog(sl, "�α��� ����", true);
					jd.add(new JLabel(name+"�� �α��� �ϼ̽��ϴ�."));
					jd.setBounds(sl.getX()+100, sl.getY(), 300, 200);
					jd.setVisible(true);
					jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(sl, "DB�۾� �� ������ �߻��Ͽ����ϴ�.");
					e.printStackTrace();
				}
			}

			if (ae.getSource() == sl.getJbtCancle()) {
				sl.getJtfId().setText("");
				sl.getJpfPass().setText("");
				sl.getJtfId().requestFocus();
			}
		}

	}
}