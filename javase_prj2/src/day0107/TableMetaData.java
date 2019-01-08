package day0107;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class TableMetaData {

	public TableMetaData() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd=null;
		
		// 1. 드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String dbo_id = "scott";
		String dbo_pass = "tiger";
		con = DriverManager.getConnection(url, dbo_id, dbo_pass);// ??

		String selectDept="select * from dept";
			pstmt = con.prepareStatement(selectDept);
			
			rs = pstmt.executeQuery();
			rsmd=rs.getMetaData();
			
//			List<String> list = new ArrayList<String>();
//			while (rs.next()) {
//				ts.getJcbTS().addItem(rs.getString("TNAME"));
//			}
			
			int cnt=rsmd.getColumnCount();

			
			StringBuilder output = new StringBuilder();
			output.append("컬럼명\t데이터형\t크기\t제약사항\n");
			for(int i=1; i<cnt+1; i++) {
				output
				.append(rsmd.getColumnLabel(i)).append("\t")
				.append(rsmd.getColumnTypeName(i)).append("\t")
				.append(rsmd.getPrecision(i)).append("\n");
			}
System.out.println(output);

		} finally {
			// 5. 연결 끊기
			if (rs != null) {rs.close();}
			if (pstmt != null) {pstmt.close();}
			if (con != null) {con.close();}
		}
	}
	
	public static void main(String[] args) {
	try {
		TableMetaData tmd=new TableMetaData();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}

}
