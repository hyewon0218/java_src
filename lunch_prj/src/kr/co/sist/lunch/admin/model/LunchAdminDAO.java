package kr.co.sist.lunch.admin.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.lunch.admin.view.LunchMainView;
import kr.co.sist.lunch.admin.vo.AdminLoginVO;
import kr.co.sist.lunch.admin.vo.LunchAddVO;
import kr.co.sist.lunch.admin.vo.LunchDetailVO;
import kr.co.sist.lunch.admin.vo.LunchVO;

public class LunchAdminDAO {
	private static LunchAdminDAO la_dao;
	
	private LunchAdminDAO() {
		//1. 드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
	}//LunchAdminDAO
	
	public static LunchAdminDAO getInstance() {
		if(la_dao==null ) {
		  la_dao=new LunchAdminDAO();
			
		}//end if
		return la_dao;
	}//getInstance
	
	private Connection getConn() throws SQLException {
		//2. 
		String url="jdbc:oracle:thin:@211.63.89.155:1521:orcl";
		String id="scott";
		String pass="tiger";
		Connection con=DriverManager.getConnection(url, id, pass);
		return con;
	}//getConn
	
	/**
	 * ID와 password를 입력받아 lunch_admin에서 이름을 조회하는 일
	 * @param alvo
	 * @return
	 * @throws SQLException
	 */
	public String login(AdminLoginVO alvo)throws SQLException {
		String adminName="";//초기화값
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		//1. 
		//2.
			con=getConn();
		//3.
			String selectName="SELECT NAME FROM LUNCH_ADMIN WHERE ID=? AND PASS=?";//ctrl shift x: 대문자
			pstmt=con.prepareStatement(selectName);
		//4.
			pstmt.setString(1, alvo.getId());
			pstmt.setString(2, alvo.getPass());
		//5.
			rs=pstmt.executeQuery();
			if(rs.next()) {
				adminName=rs.getString("NAME");
			}
		}finally {
		//6.
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}
		return adminName;
	}
	
	/**
	 * 입력된 도시락의 코드, 이미지, 도시락명, 단가 조회
	 * @return
	 * @throws SQLException
	 */
	public List<LunchVO> selectLunch() throws SQLException {
		List<LunchVO>list=new ArrayList<LunchVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		//1.
		//2.
			con=getConn();
		//3.
			String selectAllLunch="SELECT LUNCH_CODE,LUNCH_NAME,IMG,PRICE FROM LUNCH ORDER BY LUNCH_CODE DESC";
			pstmt=con.prepareStatement(selectAllLunch);
		//4.
		//5.
			rs=pstmt.executeQuery();
			
			LunchVO lv=null;
			
			while(rs.next()) {//LUNCH_CODE,LUNCH_NAME,IMG,PRICE
				lv=new LunchVO(rs.getString("LUNCH_CODE"), rs.getString("LUNCH_NAME"), rs.getString("IMG"), rs.getInt("PRICE"));
				list.add(lv);
			}//end while
			
		}finally {
			//6.
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}
		
		
		return list;
	}//selectLunch
	
	/**
	 * 입력되는 코드에 의한 도시락 상세정보를 조회
	 * @param code
	 * @return
	 * @throws SQLException
	 */
	public LunchDetailVO selectDtailLunch(String code)throws SQLException {
		LunchDetailVO ldvo=null;//new남발하지 않기!!
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
		//1.
		//2.
			con=getConn();
		//3.
			String selectLunch
				="SELECT LUNCH_NAME,IMG,PRICE,SPEC,TO_CHAR(INPUT_DATE,'YYYY-MM-DD')INPUT_DATE FROM LUNCH WHERE LUNCH_CODE=?";
			pstmt=con.prepareStatement(selectLunch);
		//4.
			pstmt.setString(1, code);
		//5.
			rs=pstmt.executeQuery();
			//입력된 코드로 조회된 레코드가 존재할 때 VO를 생성하고 값을 추가한다.
			if(rs.next()) {
				ldvo=new LunchDetailVO(code, rs.getString("lunch_name"), rs.getString("img"), rs.getString("spec"),rs.getString("input_date"), rs.getInt("price"));
			}
		}finally{
		//6.
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}
		return ldvo;
	}
	
	/**
	 * 도시락 정보를 추가하는 일 
	 * @param lav
	 * @throws SQLException
	 */
	public void insertLunch(LunchAddVO lav)throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;;
		//insert할거니까 result필요없음
		
		try {
		//1.
		//2.
			con=getConn();
		//3.
			StringBuilder insertLunch=new StringBuilder();
			insertLunch.append("insert into lunch")
			.append("(lunch_code,lunch_name,img,price,spec,id)")
			.append("values(lunch_code,?,?,?,?,?)");
			pstmt=con.prepareStatement(insertLunch.toString());
		//4.바인드 변수에 값 넣기
			pstmt.setString(1, lav.getLunch_name());
			pstmt.setString(2, lav.getImg());
			pstmt.setInt(3, lav.getPrice());
			pstmt.setString(4, lav.getSpec());
			pstmt.setString(5, LunchMainView.adminId);
		//5.
			pstmt.executeQuery();
		}finally {
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		//6.
		}
	}//insertLunch
	
	public boolean deleteLunch(String code)throws SQLException{
		boolean flag=false;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
		//1.
		//2.
			con=getConn();
		//3.
			String deletQuery="DELETE FROM LUNCH WHERE LUNCH_CODE=?";
			pstmt=con.prepareStatement(deletQuery);
		//4.
			pstmt.setString(1, code);
		//5.쿼리수행후결과받기
			int cnt=pstmt.executeUpdate();
			if(cnt==1) {
				flag=true;
			}
		}finally {
		//6.
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}
		
		return flag;
	}//deleteLunch
	
	public static void main(String[] args) {
		try {
			System.out.println(getInstance().selectDtailLunch("L_000002"));//단위테스트
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}//class





























