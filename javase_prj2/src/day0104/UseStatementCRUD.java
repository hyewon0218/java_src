package day0104;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Statement 객체를 사용하여 CRUD를 구현하는 클래스
 * CRUD(Create Read Update Delete)의 약자. 
 * @author SIST
 */
public class UseStatementCRUD {

	/**
	 * VO를 입력받아 VO의 값을 CP_DEPT테이블에 추가 
	 * @param cdvo 부서번호, 부서명, 위치를 가진 VO
	 * @throws SQLException 
	 */
	public void insertCpDept(CpDeptVO cdvo)throws SQLException {
		//1. 드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con=null;
		Statement stmt=null;
		
		try {
		//2. Connection 얻기
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";//외우기!!!
			String id="scott";
			String pass="tiger";
			
			con=DriverManager.getConnection(url, id, pass);
		//3. 쿼리문 객체생성 얻기
			stmt=con.createStatement();
		//4. 쿼리수행 후 결과 얻기
//			String insertCpDept="insert into cp_dept(deptno,dname,loc)values("+
//										cdvo.getDeptno()+",' "+cdvo.getDname()"','"+cdvo.getLoc()+"')";
			StringBuilder insertCpDept=new StringBuilder();//긴문자열
			insertCpDept.append("insert into cp_dept(deptno,dname,loc)values(")
			.append(cdvo.getDeptno()).append(",'")
			.append(cdvo.getDname()).append("','")
			.append(cdvo.getLoc()).append("')");
			
			int cnt=stmt.executeUpdate(insertCpDept.toString());//stringbuilder의 값을 string으로 
			System.out.println(cnt);
		}finally {
		//5. 연결끊기
			if(stmt !=null) {stmt.close();}
			if(con !=null) {con.close();}
		}
	}
	public boolean updateCpDept(CpDeptVO cdvo)throws SQLException {
		boolean flag=false;
		
		//1. 드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con=null;
		Statement stmt=null;
		try { 
		//2. Connection얻기
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=DriverManager.getConnection(url, id, pass);
		//3. 쿼리문 생성객체얻기
			stmt=con.createStatement();
		//4. 쿼리 수행 후 결과 얻기
			StringBuilder updateCpDept=new StringBuilder();
			updateCpDept
			.append("update cp_dept set ")//띄어쓰기 주의!!
			.append("dname='").append(cdvo.getDname()).append("',")
			.append("loc='").append(cdvo.getLoc()).append("' ")
			.append("where deptno=").append(cdvo.getDeptno());

			int cnt=stmt.executeUpdate(updateCpDept.toString());//??
			//테이블의 구조상 부서번호는 PK이므로 한행만 변경된다.
			if(cnt!=0) {//잘바뀌었다면 
				flag=true;
			}
		}finally {
		//5. 연결 끊기
			if(stmt!=null) {stmt.close();}
			if(con!=null) {con.close();}
		}
		
		return flag;
	}
	public boolean deleteCpDept(int deptno)throws SQLException {
		boolean flag=false;
		
		//1. 드라이버로딩
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		Connection con=null;
		Statement stmt=null;
		try {
		//2. Connection얻기
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=DriverManager.getConnection(url, id, pass);
		//3. 쿼리문 생성객체 얻기
			stmt=con.createStatement();
		//4. 쿼리 수행 후 결과 얻기
			StringBuilder deleteCpDept=new StringBuilder();
			deleteCpDept.append("delete from cp_dept where deptno=").append(deptno);
			
			int cnt=stmt.executeUpdate(deleteCpDept.toString());
			
			if(cnt==1) {//부서번호 한건만/=!0으로 해도 됨
				flag=true;
			}
			
		}finally {
		//5. 연결 끊기
			if(stmt !=null) {stmt.close();}
			if(con !=null) {con.close();}
		}
		
		return flag;
	}
	
	public List<CpDeptVO>selectAllCpDept() throws SQLException {
		List<CpDeptVO> list=new ArrayList<CpDeptVO>();
		//1.드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
		//2.Connection 얻기
		String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";//127.0.0.1대신 localhost가능 
		String id="scott";
		String pass="tiger";
		
		con=DriverManager.getConnection(url, id, pass);
		//3.쿼리문 생성객체 얻기
		stmt=con.createStatement();
		//4.쿼리 수행 후 결과 얻기
		String selectCpDept="select deptno,dname,loc from cp_dept";
		
		rs=stmt.executeQuery(selectCpDept);
		CpDeptVO cdvo=null;
		
		while(rs.next()) {//조회된 레코드가 존재한다면
			//0번은 cursor자리이기때문에 꺼내쓸 수 없다.
//			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			//컬럼명으로 조회(권장)
//			System.out.println(rs.getInt("deptno")+" "+rs.getString("dname")
//									+" "+rs.getString("loc"));
			cdvo=new CpDeptVO(rs.getInt("deptno"),rs.getString("dname"),
					rs.getString("loc"));
			//같은 이름으로 생성된 cdvo객체를 사라지지 않도록 관리하기 위해 List에 추가
			list.add(cdvo);//이코드가없으면 가장마지막값만 들어감
//			
		}
		
		
		
		}finally {	
		//5.연결 끊기
			if(rs !=null) {rs.close();}
			if(stmt !=null) {stmt.close();}
			if(con !=null) {con.close();}
		}
		return list;
	}
	
	
	
	public OneCpDeptVO selectCpDept(int deptno) throws SQLException {
		OneCpDeptVO ocdvo=null;
		//1. 드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
		//2. Connection 얻기
			String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String id="scott";
			String pass="tiger";
			
			con=DriverManager.getConnection(url, id, pass);
		//3. 쿼리문 생성객체 얻기
			stmt=con.createStatement();
		//4. 쿼리 수행 후 결과 얻기
			StringBuilder selectCpDept=new StringBuilder();
			selectCpDept.append("select dname,loc from cp_dept where deptno=")
			.append(deptno);//부서번호가 primary key
			
			rs=stmt.executeQuery(selectCpDept.toString());//rs는 DB 인라인 뷰의 커서의 제어권
			if(rs.next()) {//조회된 레코드가 존재한다면 (primary key가 한개라 if로(0개도)/여러개라면 while)
				ocdvo=new OneCpDeptVO(rs.getString("dname"),rs.getString("loc"));//한개니까list에담을필요x//vo는 null이거나 값
			}
		}finally {	
		//5. 연결 끊기
			if(rs !=null) {rs.close();}
			if(stmt !=null) {stmt.close();}
			if(con !=null) {con.close();}
		}
		
		return ocdvo;
	}
	public List<Integer>selectAllCpDeptNo() throws SQLException {//모든부서조회
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
