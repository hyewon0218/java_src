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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ZipcodeViewEvt extends WindowAdapter implements ActionListener {

	private ZipcodeVeiw zv;
	
	public ZipcodeViewEvt(ZipcodeVeiw zv) {
		this.zv=zv;
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		zv.dispose();
	}
	
	public String blockInjection(String sql) {
		return sql.replaceAll("'", "").replaceAll("--", "");
	}
	
	public List<ZipcodeVO> selectZipcode(String dong)throws SQLException {
		List<ZipcodeVO> list=new ArrayList<ZipcodeVO>();
		//1. ����̹��ε�
	    try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    
	    Connection con=null;
	    Statement stmt=null;
	    ResultSet rs=null;
		
	    try {
	    //2. Connection ���
	    	String url="jdbc:oracle:thin:@localhost:1521:orcl";
	    	String id="scott";
	    	String pass="tiger";
	    	con=DriverManager.getConnection(url, id, pass);
		//3. ������ ������ü ���
	    	stmt=con.createStatement();
		//4. ���� ���� �� ��� ���
	    	StringBuilder selectZipcode=new StringBuilder();
	    	selectZipcode
	    	.append(" select zipcode,sido,gugun,dong,nvl(bunji,' ') bunji")
	    	.append(" from zipcode")
	    	.append(" where dong like '").append( blockInjection(dong) ).append("%'");
	    	
	    	rs=stmt.executeQuery(selectZipcode.toString());
	    	
	    	ZipcodeVO zv=null;
	    	while(rs.next()) {//��ȸ�� ���ڵ尡 �����Ѵٸ� 
	    		//VO�� ���� �Ҵ��ϰ�
	    		zv=new ZipcodeVO(rs.getString("zipcode"), rs.getString("sido"), 
	    				rs.getString("gugun"), rs.getString("dong"), rs.getString("bunji"));
	    		//���� �̸��� ��ü�� ������ �����ϱ� ���� LIST �� �߰�
	    		list.add(zv);
	    	}
	    	
	    }finally {
		//5. ���� ����
	    if (rs!=null) {rs.close();}
	    if (stmt!=null) {stmt.close();}
	    if (con!=null) {con.close();}
	    }//end finally
		return list;
	}
	public void searchZipcode(String dong) {
		try {
			//DB���� ��ȸ�� ����� �޾Ƽ�
			List<ZipcodeVO>listZip=selectZipcode(dong);
			//DefaultTableModel�� �߰�=> JTable�� �ݿ��ȴ�. 
			DefaultTableModel dtm=zv.getDtmZipcode();
			//D.T.M �ʱ�ȭ 
			dtm.setRowCount(0);
            
			String[] rowData=null;
			//��ȸ�� ����� ������
			for(ZipcodeVO zv:listZip) {
				//�迭�� �ְ�
				rowData=new String[2];
				rowData[0]=zv.getZipcode();
				rowData[1]=zv.getSido()+" "+zv.getGugun()+" "+zv.getDong()+" "+zv.getBunji();
				
				
				//D.T.M�� ��(Row : �����ȣ, �ּ�) �߰�
				dtm.addRow(rowData);
			}
			if( listZip.isEmpty() ) {
				rowData=new String[2];
				rowData[0]="";
				rowData[1]="�ش� ���� �������� �ʽ��ϴ�.";
				
				dtm.addRow(rowData);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(zv, "DB���� ������ �߻�");
			e.printStackTrace();
			
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String dong=zv.getJtfDong().getText().trim();
		if(!dong.equals("")) {
			searchZipcode(dong);
		}
	}

}
