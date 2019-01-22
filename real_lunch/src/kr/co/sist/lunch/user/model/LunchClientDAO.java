package kr.co.sist.lunch.user.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.lunch.user.vo.LunchDetailVO;
import kr.co.sist.lunch.user.vo.LunchListVO;
import kr.co.sist.lunch.user.vo.OrderAddVO;
import kr.co.sist.lunch.user.vo.OrderInfoVO;
import kr.co.sist.lunch.user.vo.OrderListVO;
import oracle.jdbc.OracleTypes;

/**
 * 도시락 주문자에 대한 DB 처리
 * @author owner
 */
public class LunchClientDAO {
	private static LunchClientDAO lc_dao;
	
	private LunchClientDAO() {
		//1. 
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
	}//LunchClientDAO
	
	public static LunchClientDAO getInstance() {
		if(lc_dao == null) {
			lc_dao=new LunchClientDAO();
		}//end if
		return lc_dao;
	}//getInstance
	
	private Connection getConn() throws SQLException{
		//2.
		Connection con=null;
		
		String url="jdbc:oracle:thin:@211.63.89.130:1521:orcl";
		String id="scott";
		String pass="tiger";
		
		con=DriverManager.getConnection(url, id, pass );
		
		return con;
	}//getConn
	
	/**
	 * DB에 추가된 모든 도시락 목록 조회
	 * @return
	 * @throws SQLException
	 */
	public List<LunchListVO> selectLunchList()throws SQLException{
		List<LunchListVO> list=new ArrayList<LunchListVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		//1.
		//2.
			con=getConn();
		//3.
			String selectLunch
				="select lunch_code,lunch_name, img,spec from lunch order by lunch_code desc";
			pstmt=con.prepareStatement(selectLunch);
		//4.
		//5.
			rs=pstmt.executeQuery();
			
			LunchListVO llv=null;
			
			while(rs.next()) {
				llv=new LunchListVO(rs.getString("img"), rs.getString("lunch_code"), 
						rs.getString("lunch_name"), rs.getString("spec"));
				list.add(llv);
			}//end while
			
		}finally {
		//6.
			if( rs != null ) { rs.close(); }//end if
			if( pstmt != null ) { pstmt.close(); }//end if
			if( con != null ) { con.close(); }//end if
		}//end finally
		return list;
	}//selectLunchList
	
	/**
	 * 도시락의 상세정보 조회
	 * @param lunchCode
	 * @return
	 * @throws SQLException
	 */
	public LunchDetailVO selectDetailLunch(String lunchCode)throws SQLException{
		LunchDetailVO ldvo=null;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		//1.
		//2.
			con=getConn();
		//3.
			String selectLunch
					="select  img, lunch_name, spec, price from lunch where lunch_code=?";
			pstmt=con.prepareStatement(selectLunch);
		//4.
			pstmt.setString(1, lunchCode);
		//5.
			rs=pstmt.executeQuery();
			
			if( rs.next() ) {
				ldvo=new LunchDetailVO(lunchCode, rs.getString("lunch_name"), 
						rs.getString("spec"), rs.getString("img"), rs.getInt("price"));
			}//end if
			
		}finally{
		//6.
			if( rs != null ) { rs.close(); }//end if
			if( pstmt != null ) { pstmt.close(); }//end if
			if( con != null ) { con.close(); }//end if
		}//end finally			
		
		return ldvo;
	}//selectDetailLunch
	
	public void insertOrder(OrderAddVO oavo)throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
		//1.
		//2.
			con=getConn();
		//3.
			String insertOrder
					="insert into ordering(order_num,quan,order_name,phone,ip_address,lunch_code,request	)values(order_code,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(insertOrder);
		//4.
			pstmt.setInt(1, oavo.getQuan());
			pstmt.setString(2, oavo.getOrderName());
			pstmt.setString(3, oavo.getPhone());
			pstmt.setString(4, oavo.getIpAddress());
			pstmt.setString(5, oavo.getLunchCode());
			/////////////////////// 요청사항추가////////////////////////////////////////////
			pstmt.setString(6, oavo.getRequest());
		//5.
			pstmt.executeUpdate();
		}finally {
		//6.
			if( pstmt != null ) { pstmt.close(); }//end if
			if( con != null ) { con.close(); }//end if
		}//end finally
	}//insertOrder
	
	public List<OrderListVO> selectOrderList(OrderInfoVO oivo)throws SQLException{
		List<OrderListVO> list=new ArrayList<OrderListVO>();
		
		Connection con=null;
		CallableStatement cstmt=null;
		ResultSet rs=null;
		
		try {
		//1.
		//2.
			con=getConn();
		//3.
			cstmt=con.prepareCall(" { call  lunch_order_select(?,?,?) } ");
		//4.
			//in parameter
			cstmt.setString(1, oivo.getOrderName());
			cstmt.setString(2, oivo.getOrderTel());
			//out parameter
			cstmt.registerOutParameter(3, OracleTypes.CURSOR);
			
		//5.쿼리 실행( 프로시져실행)
			cstmt.execute();
			//out parameter에 저장된 값 자바의 변수(rs)로 저장
			rs=(ResultSet)cstmt.getObject(3);
			
			OrderListVO olvo=null;
			
			while( rs.next() ) {
				olvo=new OrderListVO(rs.getString("lunch_name"), 
						rs.getString("order_date"),rs.getInt("quan"));
						
				list.add(olvo);
			}//end while
			
		}finally {
		//6.
			if( rs != null ) { rs.close(); }//end if
			if( cstmt != null ) { cstmt.close(); }//end if
			if( con != null ) { con.close(); }//end if
		}//end finally
		
		return list;
	}//selectOrderList
	
}//class







