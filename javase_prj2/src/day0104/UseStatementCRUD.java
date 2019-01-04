package day0104;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Statement ��ü�� ����Ͽ� CRUD�� �����ϴ� Ŭ����
 * CRUD(Create Read Update Delete)�� ����. 
 * @author SIST
 */
public class UseStatementCRUD {

	/**
	 * VO�� �Է¹޾� VO�� ���� CP_DEPT���̺� �߰� 
	 * @param cdvo �μ���ȣ, �μ���, ��ġ�� ���� VO
	 * @throws SQLException 
	 */
	public void insertCpDept(CpDeptVO cdvo)throws SQLException {
		//1. ����̹��ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con=null;
		Statement stmt=null;
		
		try {
		//2. Connection ���
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";//�ܿ��!!!
			String id="scott";
			String pass="tiger";
			
			con=DriverManager.getConnection(url, id, pass);
		//3. ������ ��ü���� ���
			stmt=con.createStatement();
		//4. �������� �� ��� ���
//			String insertCpDept="insert into cp_dept(deptno,dname,loc)values("+
//										cdvo.getDeptno()+",' "+cdvo.getDname()"','"+cdvo.getLoc()+"')";
			StringBuilder insertCpDept=new StringBuilder();//�乮�ڿ�
			insertCpDept.append("insert into cp_dept(deptno,dname,loc)values(")
			.append(cdvo.getDeptno()).append(",'")
			.append(cdvo.getDname()).append("','")
			.append(cdvo.getLoc()).append("')");
			
			int cnt=stmt.executeUpdate(insertCpDept.toString());//stringbuilder�� ���� string���� 
			System.out.println(cnt);
		}finally {
		//5. �������
			if(stmt !=null) {stmt.close();}
			if(con !=null) {con.close();}
		}
	}
	public boolean updateCpDept(CpDeptVO cdvo)throws SQLException {
		boolean flag=false;
		
		//1. ����̹��ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con=null;
		Statement stmt=null;
		try { 
		//2. Connection���
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=DriverManager.getConnection(url, id, pass);
		//3. ������ ������ü���
			stmt=con.createStatement();
		//4. ���� ���� �� ��� ���
			StringBuilder updateCpDept=new StringBuilder();
			updateCpDept
			.append("update cp_dept set ")//���� ����!!
			.append("dname='").append(cdvo.getDname()).append("',")
			.append("loc='").append(cdvo.getLoc()).append("' ")
			.append("where deptno=").append(cdvo.getDeptno());

			int cnt=stmt.executeUpdate(updateCpDept.toString());//??
			//���̺��� ������ �μ���ȣ�� PK�̹Ƿ� ���ุ ����ȴ�.
			if(cnt!=0) {//�߹ٲ���ٸ� 
				flag=true;
			}
		}finally {
		//5. ���� ����
			if(stmt!=null) {stmt.close();}
			if(con!=null) {con.close();}
		}
		
		return flag;
	}
	public boolean deleteCpDept(int deptno)throws SQLException {
		boolean flag=false;
		
		//1. ����̹��ε�
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		Connection con=null;
		Statement stmt=null;
		try {
		//2. Connection���
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=DriverManager.getConnection(url, id, pass);
		//3. ������ ������ü ���
			stmt=con.createStatement();
		//4. ���� ���� �� ��� ���
			StringBuilder deleteCpDept=new StringBuilder();
			deleteCpDept.append("delete from cp_dept where deptno=").append(deptno);
			
			int cnt=stmt.executeUpdate(deleteCpDept.toString());
			
			if(cnt==1) {//�μ���ȣ �ѰǸ�/=!0���� �ص� ��
				flag=true;
			}
			
		}finally {
		//5. ���� ����
			if(stmt !=null) {stmt.close();}
			if(con !=null) {con.close();}
		}
		
		return flag;
	}
	
	public List<CpDeptVO>selectAllCpDept() throws SQLException {
		List<CpDeptVO> list=new ArrayList<CpDeptVO>();
		//1.����̹��ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
		//2.Connection ���
		String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";//127.0.0.1��� localhost���� 
		String id="scott";
		String pass="tiger";
		
		con=DriverManager.getConnection(url, id, pass);
		//3.������ ������ü ���
		stmt=con.createStatement();
		//4.���� ���� �� ��� ���
		String selectCpDept="select deptno,dname,loc from cp_dept";
		
		rs=stmt.executeQuery(selectCpDept);
		CpDeptVO cdvo=null;
		
		while(rs.next()) {//��ȸ�� ���ڵ尡 �����Ѵٸ�
			//0���� cursor�ڸ��̱⶧���� ������ �� ����.
//			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			//�÷������� ��ȸ(����)
//			System.out.println(rs.getInt("deptno")+" "+rs.getString("dname")
//									+" "+rs.getString("loc"));
			cdvo=new CpDeptVO(rs.getInt("deptno"),rs.getString("dname"),
					rs.getString("loc"));
			//���� �̸����� ������ cdvo��ü�� ������� �ʵ��� �����ϱ� ���� List�� �߰�
			list.add(cdvo);//���ڵ尡������ ���帶�������� ��
//			
		}
		
		
		
		}finally {	
		//5.���� ����
			if(rs !=null) {rs.close();}
			if(stmt !=null) {stmt.close();}
			if(con !=null) {con.close();}
		}
		return list;
	}
	
	
	
	public OneCpDeptVO selectCpDept(int deptno) throws SQLException {
		OneCpDeptVO ocdvo=null;
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
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pass="tiger";
			
			con=DriverManager.getConnection(url, id, pass);
		//3. ������ ������ü ���
			stmt=con.createStatement();
		//4. ���� ���� �� ��� ���
			StringBuilder selectCpDept=new StringBuilder();
			selectCpDept.append("select dname,loc from cp_dept where deptno=")
			.append(deptno);//�μ���ȣ�� primary key
			
			rs=stmt.executeQuery(selectCpDept.toString());//rs�� DB �ζ��� ���� Ŀ���� �����
			if(rs.next()) {//��ȸ�� ���ڵ尡 �����Ѵٸ� (primary key�� �Ѱ��� if��(0����)/��������� while)
				ocdvo=new OneCpDeptVO(rs.getString("dname"),rs.getString("loc"));//�Ѱ��ϱ�list�������ʿ�x//vo�� null�̰ų� ��
			}
		}finally {	
		//5. ���� ����
			if(rs !=null) {rs.close();}
			if(stmt !=null) {stmt.close();}
			if(con !=null) {con.close();}
		}
		
		return ocdvo;
	}
	public List<Integer>selectAllCpDeptNo() throws SQLException {//���μ���ȸ
		List<Integer> list=new ArrayList<Integer>();
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pass="tiger";
			
			con=DriverManager.getConnection(url, id, pass);
			
			stmt=con.createStatement();
			
			StringBuilder selectCpDept=new StringBuilder();
			selectCpDept.append("select deptno from cp_dept order by deptno");
			
			rs=stmt.executeQuery(selectCpDept.toString());
			
			
			while(rs.next()) {
				list.add(new Integer(rs.getInt("deptno")));
			}
			
		}finally {
			if(rs !=null) {rs.close();}
			if(stmt !=null) {stmt.close();}
			if(con !=null) {con.close();}
		}
	
		
		return list;
	}
	
	
}//class
