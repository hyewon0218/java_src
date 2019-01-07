package day0107;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.net.aso.p;

public class UsePreparedStatementDAO {
 
	public UsePreparedStatementDAO() {
		
	}
	private Connection getConn() throws SQLException {
		Connection con=null;
		//1.
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//2.
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String id="scott";
		String pass="tiger";
		
		con=DriverManager.getConnection(url, id, pass);
		return con;
		
	}
	
	public void insertCpEmp2(CpEmp2VO cevo)throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		
		try {
		//1.����̹��ε�
		//2. Connection���
			con=getConn();
		//3. ������ ������ü ��� : PreparedStatement ��ü�� ����Ǵ� �������� �˰��ִ�. 
			String insertCpEmp=
					"insert into cp_emp2(empno,ename,hiredate,sal)values(?,?,sysdate,?)";//?-bind����
			pstmt=con.prepareStatement(insertCpEmp);
		//4. ���ε� ������ �� ����
			pstmt.setInt(1, cevo.getEmpno());
			pstmt.setString(2, cevo.getEname());
			pstmt.setInt(3, cevo.getSal());
		//5. �������� �� ��� ���
			pstmt.executeUpdate();
			
		}finally {
		//6. ���� ����
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}
	}
//		public static void main(String[] args) {
//
//		 UsePreparedStatementDAO u=new UsePreparedStatementDAO();
//		 CpEmp2VO c=new CpEmp2VO(9876 , 3000, "����ö");
//		 try {
//			u.insertCpEmp2(c);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		}//main

	public boolean updateCpEmp2(CpEmp2VO cevo)throws SQLException {
		boolean flag=false;
		
		return flag;
	}
	public boolean deleteCpEmp2(int empno)throws SQLException {
		boolean flag=false;
		
		return flag;
	}
	
	public List<CpEmp2AllVO> selectAllCpEmp2() throws SQLException {
		List<CpEmp2AllVO> list=new ArrayList<CpEmp2AllVO>();
		
		return list;
	}
	
	public CpEmp2OneVO selectOneCpEmp2(int empno)throws SQLException {
		CpEmp2OneVO cevo=null;
		
		return cevo;
	}
	
	
}//class
