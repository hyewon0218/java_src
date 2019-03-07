package day0306;

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

public class EmpDAO {
	public List<EmpVO> selectAllEmp() throws SQLException{
		List<EmpVO> list=new ArrayList<EmpVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		//1. JNDI ��밴ü ���
			try {
				Context ctx=new InitialContext();
				//2. DataSource�� DBCP���� �����´�
				DataSource ds=(DataSource) ctx.lookup("java:comp/env/jdbc/dbcp");
				//3. Connection ���
				con=ds.getConnection();
			} catch (NamingException ne) {
				ne.printStackTrace();
			}
		//4. ������ ���� ��ü ���
			String selectEmp="select empno,mgr,sal,ename,job,to_char(hiredate,'yyyy-mm-dd')hiredate from emp order by sal";
			pstmt=con.prepareStatement(selectEmp);
			
		//5. ������ ���� �� ��� ���
			rs=pstmt.executeQuery();
			EmpVO ev=null;
			while (rs.next()) {
				ev=new EmpVO(rs.getInt("empno"), rs.getInt("mgr"), rs.getInt("sal"), rs.getString("ename"), rs.getString("job"), rs.getString("hiredate"));
				list.add(ev);
			}
	}finally {
		//6. ���� ����
		if(rs!=null) {rs.close();}
		if(pstmt!=null) {pstmt.close();}
		if(con!=null) {con.close();}
	}
		return list;
	}//selectAllEmp
}//class
