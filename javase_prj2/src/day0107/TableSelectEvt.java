package day0107;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import kr.co.sist.connection.GetConnection;

public class TableSelectEvt extends WindowAdapter implements ActionListener{

	private TableSelect ts;
    private TableMetaData tmd;
	
	public TableSelectEvt(TableSelect ts) {
		this.ts = ts;
//		try {
//			this.Table("t");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}	
	}
	public void getRecord(String tabName)throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ResultSetMetaData rsmd=null;
		
		GetConnection gc=GetConnection.getInstance();
		
		String url ="jdbc:oracle:thin:@localhost:1521:orcl";
		String id= "scott";
		String pass=	"tiger";
		
		try {
			con=gc.getConn(url, id, pass);
			String selectTaInfo="select utc.column_name, utc.data_type, NVL(utc.data_precision,0) data_pricision, NVL(ucc.constraint_name,' ') constraint_name " + 
					"from user_tab_cols utc ,user_cons_columns ucc " + 
					"where (utc.table_name=?) " + 
					"AND (utc.table_name=ucc.table_name(+)) " + 
					"AND(utc.column_name=ucc.column_name(+))" ;
			
			pstmt=con.prepareStatement(selectTaInfo);
			pstmt.setString(1, tabName);
			
			rs=pstmt.executeQuery();
			
			ts.getDtmTS().setRowCount(0);
			
			
			String[] rowData=new String[4];
			while(rs.next()) {
				rowData[0]=rs.getString("COLUMN_NAME");
				rowData[1]=rs.getString("DATA_TYPE");
				rowData[2]=rs.getString("DATA_PRECISION");
				rowData[3]=rs.getString("CONSTRAINT_NAME");
				ts.getDtmTS().addRow(rowData);
			}
					
		} finally {
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
			
			
		}
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		ts.dispose();
	}

	public String Table(String id) throws SQLException {
		String tname = "";
		// 1. 드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		// 2. Connection 얻기
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String dbo_id = "scott";
		String dbo_pass = "tiger";
		con = DriverManager.getConnection(url, dbo_id, dbo_pass);// ??

		try {
			// 3. 쿼리문 생성객체 얻기
			stmt = con.createStatement();
			// 4. 쿼리문 수행 후 결과 얻기
			StringBuilder selectTname = new StringBuilder();
			selectTname.append(" select tname ").append(" from tab ");

			rs = stmt.executeQuery(selectTname.toString());

			List<String> list = new ArrayList<String>();
			while (rs.next()) {
				ts.getJcbTS().addItem(rs.getString("TNAME"));
			}
		} finally {
			// 5. 연결 끊기
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
			return tname;
	}
	


	@Override
	public void actionPerformed(ActionEvent ae) {
		String item=ts.getJcbTS().getSelectedItem().toString();
		try {
			getRecord(item);
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		System.out.println(item);
			
	}
}