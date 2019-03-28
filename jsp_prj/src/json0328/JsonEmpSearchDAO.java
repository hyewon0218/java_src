package json0328;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JsonEmpSearchDAO {
	private static JsonEmpSearchDAO jes_dao;
	
	
	private JsonEmpSearchDAO() {
		
	}
	public static JsonEmpSearchDAO getInstance() {
		if(jes_dao==null) {
			jes_dao=new JsonEmpSearchDAO();
			
		}
		return jes_dao;
	}
	
	private Connection getConn()throws SQLException {
		Connection con=null;
		
		
		try {
			//1. JNDI ��밴ü ����
			Context ctx=new InitialContext();
			//2. DBCP�� ����� DataSource ���
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/jsp_dbcp");
			//3. Connection ���
			con=ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		return con;
	}//getConn
	
	
	
	public List<EmpVO> selectEmpList(int deptno) throws SQLException {
		List<EmpVO> list=new ArrayList<>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			//2. DataSource�� DBCP���� �����´�
			//3. Connection ���
			con=getConn();
			//4. ������ ���� ��ü ���
			String selectEmp="select empno,sal,ename,job,to_char(hiredate,'yyyy-mm-dd')hiredate from emp where deptno=?";
			pstmt=con.prepareStatement(selectEmp);
			pstmt.setInt(1, deptno);
	//5. ������ ���� �� ��� ���
			rs=pstmt.executeQuery();
			EmpVO ev=null;
			while (rs.next()) {
				ev=new EmpVO(rs.getInt("empno"), rs.getInt("sal"), rs.getString("ename"), rs.getString("job"), rs.getString("hiredate"));
				list.add(ev);
			}
				}finally {
					//6. ���� ����
					if(rs!=null) {rs.close();}
					if(pstmt!=null) {pstmt.close();}
					if(con!=null) {con.close();}
				}
			
		return list;
	}//selectEmpList
}//class
