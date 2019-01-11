package day0109;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.CSS;

import day0110.TestProcAllVO;
import day0110.TestProcOneVO;
import day0110.TestProcUpdateVO;
import kr.co.sist.connection.GetConnection;
import oracle.jdbc.internal.OracleTypes;

/**
 * Procedure�� ����� CRUD
 * @author SIST
 *
 */
public class UseCallableStatementDAO {
	
	private static UseCallableStatementDAO ucs_dao;
	
	private UseCallableStatementDAO() {
		
	}
	public static UseCallableStatementDAO getInstance() {//�̱���
		if(ucs_dao ==null) {
			ucs_dao=new UseCallableStatementDAO();
		}
		return ucs_dao;
	}
	
	/**
	 * test_proc ���̺� �����ȣ, �����, ����, ������ �߰��ϴ� �� 
	 * @param tpvo
	 * @return
	 * @throws SQLException
	 */
	public String insertProc(TestProcVO tpvo)throws SQLException {
		String resultMsg="";
		Connection con=null;
		CallableStatement cstmt=null;
		
		try {
		//1.
		//2.
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=GetConnection.getInstance().getConn(url, id, pass);
		//3. ���ν��� ���ఴü ���
			cstmt=con.prepareCall("{ call insert_test_proc(?, ?, ?, ?, ?, ?) }");
		//4.
			//���ε庯���� �� ����
			//in parameter
			cstmt.setInt(1, tpvo.getEmpno());
			cstmt.setString(2, tpvo.getEname());
			cstmt.setInt(3, tpvo.getSal());
			cstmt.setString(4, tpvo.getJob());
			//out parameter : ���ν����� ó���� ����� ������ ���������� ����
			cstmt.registerOutParameter(5, Types.VARCHAR);	
			cstmt.registerOutParameter(6, Types.NUMERIC);
			
			
		//5.
			cstmt.execute();
			//procedure�� ����� �� outparameter�� ������ �� ���
			resultMsg=cstmt.getString(5);
			int cnt=cstmt.getInt(6);
			System.out.println(cnt);
			
			
		}finally {
			//6.
			if(cstmt !=null) {cstmt.close();}
			if(con !=null) {con.close();}
		}
		return resultMsg;
	}
	
	public String updateProc(TestProcUpdateVO tpuvo)throws SQLException{
		String msg="";
		Connection con=null;
		CallableStatement cstmt=null;
		
		try {
		//1.
		//2.
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=GetConnection.getInstance().getConn(url, id, pass);
		//3.
			cstmt=con.prepareCall("{ call update_test_proc(?, ?, ?, ?, ?) }");
		//4.
			//bind������ �� �ֱ� =>procedure�� �Ű����� 
			//in parameter
			cstmt.setInt(1, tpuvo.getEmpno());
			cstmt.setString(2, tpuvo.getJob());
			cstmt.setInt(3, tpuvo.getSal());
			//out parameter : procedure�� ó���� ����� ������ �Ű����� 
			cstmt.registerOutParameter(4, Types.NUMERIC);
			cstmt.registerOutParameter(5, Types.VARCHAR);
		//5.
			cstmt.executeQuery();//�θ��� method ��� procedure ���� => �������� outparameter�� ����
			int cnt=cstmt.getInt(4);
			msg=cstmt.getString(5);
			System.out.println("update : " + cnt);
			
		}finally {
			//6.
			if(cstmt!=null) {cstmt.close();}
			if(con!=null) {con.close();}
		}
		return msg;
	}
	public String deleteProc(int empno) throws SQLException {
		String msg="";
		Connection con=null;
		CallableStatement cstmt=null;
		
		try {
		//1.
		//2.
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=GetConnection.getInstance().getConn(url, id, pass);
		//3.
			cstmt=con.prepareCall("{call delete_test_proc (?, ?, ?) }");
		//4.
			//���ε庯���� �� ����
			//in parameter
			cstmt.setInt(1, empno);
			//out parameter
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.registerOutParameter(3, Types.NUMERIC); 
		//5.
			cstmt.execute();
			//out parameter�� ������ �� �ޱ�
			msg=cstmt.getString(2);
			int cnt=cstmt.getInt(3);
			System.out.println(cnt+"�� ����");
		}finally {
			//6.
			if(cstmt!=null) {cstmt.close();}
			if(con!=null) {con.close();}
		}
		return msg;
	}
	public List<TestProcAllVO> selectAllTestProc() throws SQLException {
		List<TestProcAllVO> list=new ArrayList<>();
		Connection con=null;
		CallableStatement cstmt=null;
		ResultSet rs=null;
		
		try {
		//1.
		//2.
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=GetConnection.getInstance().getConn(url, id, pass);
		//3.
			cstmt=con.prepareCall("{call select_all_test_proc(?, ?)}");
		//4.
			//���ε� ���� �� �ֱ�
			//out parameter : sys_refcursor->OracleTypes.CURSOR//Ŀ��������ǹ����γ�����
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);//����Ŭ��Ŀ�����ڹ��Ǹ�����
//			cstmt.registerOutParameter(1, Types.REF_CURSOR);//����Ŭ��Ŀ�����ڹ��Ǹ�����
			//in parameter
			cstmt.setString(2, "mm-dd-yyyy day hh24:mi");
		//5.
			cstmt.execute();
			//Ŀ���� ����� �ޱ� 
			rs=(ResultSet)cstmt.getObject(1);
			
			//������� �޾� ��ȸ�� ��� �÷����� VO�� �Ҵ��ϰ� List�� �߰� //VO�ϳ������ڵ��ϳ� 
			TestProcAllVO tpavo=null;
			
			while(rs.next()) {
				tpavo=new TestProcAllVO(rs.getInt("empno"), rs.getInt("sal"), 
						rs.getString("ename"), rs.getString("hiredate"), rs.getString("job"));
				//����Ʈ�� �÷���˾ƾ�
			
				list.add(tpavo);
			}
		}finally {
		//6.
			if(rs!=null) {rs.close();};
			if(cstmt!=null) {cstmt.close();};
			if(con!=null) {con.close();};
		}
		return list;
	}
	public TestProcOneVO selectOneTestProc(int empno) throws SQLException {
		TestProcOneVO tpovo=null;
		
		Connection con=null;
		CallableStatement cstmt=null;
		ResultSet rs=null;
		
		try {
			
		//1.
		//2.
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=GetConnection.getInstance().getConn(url, id, pass);
		//3.
			cstmt=con.prepareCall("{ call select_one_test_proc(?,?,?)}");
		//4.
			//���ε� ������ �� �ֱ�
			//in parameter
			cstmt.setInt(1, empno);
			//out parameter
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.registerOutParameter(3, OracleTypes.VARCHAR);//Types.VARCHAR
			
		//5.
			cstmt.execute();
			rs=(ResultSet)cstmt.getObject(2);
			
			if(rs.next()) {
				tpovo=new TestProcOneVO(rs.getInt("sal"), rs.getString("ename"), rs.getString("job"), rs.getString("hiredate"));
			}
		}finally {
		//6.
			if(rs!=null) {rs.close();}
			if(cstmt!=null) {cstmt.close();}
			if(con!=null) {con.close();}
		}
		return tpovo;
	}
	
	public static void main(String[] args) {
		UseCallableStatementDAO u=new UseCallableStatementDAO();
//		TestProcUpdateVO t=new TestProcUpdateVO(1234, 3000, "����");
//		TestProcVO t=new TestProcVO(2222, 4200, "������", "����");
		try {
			System.out.println(u.selectOneTestProc(2222));
//			List<TestProcAllVO> l=u.selectAllTestProc();
//			System.out.println(l);
//			u.insertProc(t);
//			System.out.println(u.deleteProc(1234));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}//main
}//class
