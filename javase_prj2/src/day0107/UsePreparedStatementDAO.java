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
		//1.드라이버로딩
		//2. Connection얻기
			con=getConn();
		//3. 쿼리문 생성객체 얻기 : PreparedStatement 객체는 실행되는 쿼리문을 알고있다. 
			String insertCpEmp=
					"insert into cp_emp2(empno,ename,hiredate,sal)values(?,?,sysdate,?)";//?-bind변수
			pstmt=con.prepareStatement(insertCpEmp);
		//4. 바인드 변수에 값 설정
			pstmt.setInt(1, cevo.getEmpno());
			pstmt.setString(2, cevo.getEname());
			pstmt.setInt(3, cevo.getSal());
		//5. 쿼리수행 후 결과 얻기
			pstmt.executeUpdate();
			
		}finally {
		//6. 연결 끊기
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}
	}
//		public static void main(String[] args) {
//
//		 UsePreparedStatementDAO u=new UsePreparedStatementDAO();
//		 CpEmp2VO c=new CpEmp2VO(9876 , 3000, "김희철");
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
