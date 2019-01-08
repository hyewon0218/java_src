package day0107;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	/**
	 * �����ȣ, �����, ������ �Է¹޾� CpEmp2���̺� �����ϴ� ��
	 * @param cevo
	 * @throws SQLException
	 */
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

	/**
	 * �����ȣ, �����, ������ �Է¹޾� �����ȣ�� �ش��ϴ� �����, ������ �����ϴ� ��
	 * @param cevo
	 * @return
	 * @throws SQLException
	 */
	public boolean updateCpEmp2(CpEmp2VO cevo)throws SQLException {
		boolean flag=false;
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
		//1. ����̹��ε�
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		//2. Connection���
			con=getConn();
		//3. ������ ������ü ���
			String updateCpEmp2="update cp_emp2 set ename=?,sal=? where empno=?";
			pstmt=con.prepareStatement(updateCpEmp2);
		//4. ���ε� ������ �� �ֱ�
			pstmt.setString(1, cevo.getEname());
			pstmt.setInt(2, cevo.getSal());
			pstmt.setInt(3, cevo.getEmpno());
		//5. ������ ���� �� ��� ���
			int cnt=pstmt.executeUpdate();
			if(cnt!=0) {//0�̸� ������ ��.
				flag=true;
			}
		}finally {
			//6. ������� 
		}
		return flag;
	}
	/**
	 * �����ȣ�� �Է¹޾� �����ȣ�� �ش��ϴ� ����� �����ϴ� ��.
	 * @param empno
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteCpEmp2(int empno)throws SQLException {
		boolean flag=false;
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
		//1. ����̹��ε�
		//2. Connection���
			con=getConn();
		//3. ������ ������ü ���
			String deleteCpEmp2="delete from cp_emp2 where empno=?";
			pstmt=con.prepareStatement(deleteCpEmp2);
		//4. ���ε� ������ �� ����
			pstmt.setInt(1, empno);
		//5. ���� ���� �� ��� ���
			int cnt=pstmt.executeUpdate();
			
			if(cnt!=0) {
				flag=true;
			}
		}finally {
		//6. ���� ����
		if (pstmt!=null) {pstmt.close();}
		if (con!=null) {con.close();}
		}
		return flag;
	}
	
	/**
	 * ��� �μ� ��������� ��ȸ 
	 * @return
	 * @throws SQLException
	 */
	public List<CpEmp2AllVO> selectAllCpEmp2() throws SQLException {
		List<CpEmp2AllVO> list=new ArrayList<CpEmp2AllVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;//��ȸ�ؼ�����������̱⶧��
		
		try {
		//1. ����̹��ε�
		//2. Connection ���
			con=getConn();
		//3. ������ ������ü ���
			String selectCpEmp2="select empno,ename,sal,to_char(hiredate,'yyyy-mm-dd') hiredate from cp_emp2";/////
			pstmt=con.prepareStatement(selectCpEmp2);		
		//4. ���ε庯���� �� �ֱ�
	    //5. ���� ���� �� ��� ���
			rs=pstmt.executeQuery();
			
			//��ȸ����� VO�� �Ҵ�
			CpEmp2AllVO cda_vo=null;
			while(rs.next()) {
				cda_vo=new CpEmp2AllVO(rs.getInt("empno"),rs.getInt("sal"),
						rs.getString("ename"),rs.getString("hiredate"));
				list.add(cda_vo);
			}
		}finally {
		//6. ���� ����
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}
		return list;
	}
	
	/**
	 * �ԷµǴ� �����ȣ�� �ش��ϴ� ������� ��ȸ
	 * @param empno
	 * @return
	 * @throws SQLException
	 */
	public CpEmp2OneVO selectOneCpEmp2(int empno)throws SQLException {
		CpEmp2OneVO cevo=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		//1.����̹��ε�
		//2. Connection���
			con=getConn();
		//3. ������ ������ü ���
			String selectOneCpEmp="select ename, sal,hiredate from cp_emp2 where empno=?";
			pstmt=con.prepareStatement(selectOneCpEmp);	
		//4. ���ε� ������ �� ����
			pstmt.setInt(1, empno);
		//5. ������ ���� �� ������
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
			cevo=new CpEmp2OneVO(rs.getInt("sal"), rs.getString("ename"), rs.getDate("hiredate"));
			}
		}finally {
		if(rs!=null) {rs.close();}
		if(pstmt!=null) {pstmt.close();}
		if(con!=null) {con.close();}
		//6. ���� ����
		}
		return cevo;
	}
	
//	public static void main(String[] args) {
//		
//		UsePreparedStatementDAO u=new UsePreparedStatementDAO();
//		try {
//			CpEmp2OneVO c=u.selectOneCpEmp2(7521);
//			System.out.println(c);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}//main
	
}//class
