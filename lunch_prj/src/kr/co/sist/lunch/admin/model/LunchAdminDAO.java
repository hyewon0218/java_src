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
import kr.co.sist.lunch.admin.vo.CalcVO;
import kr.co.sist.lunch.admin.vo.LunchAddVO;
import kr.co.sist.lunch.admin.vo.LunchDetailVO;
import kr.co.sist.lunch.admin.vo.LunchUpdateVO;
import kr.co.sist.lunch.admin.vo.LunchVO;
import kr.co.sist.lunch.admin.vo.OrderVO;
import kr.co.sist.lunch.user.vo.OrderAddVO;
import kr.co.sist.lunch.user.vo.OrderListVO;

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
	 * 요청사항 뽑아내기(추가)
	 * @param orderNum
	 * @return
	 * @throws SQLException
	 */
	public String selectAsk(String orderNum) throws SQLException{
		OrderAddVO oavo=null;
		String msg="";
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=getConn();
			String selectAsk="select ask from ordering where lunch_code=?";
			pstmt=con.prepareStatement(selectAsk);
			pstmt.setString(1, orderNum);
			if(rs.next()) {
				oavo=new OrderAddVO(orderNum, rs.getString("phone"), rs.getString("ipAddress"), rs.getString("lunchCode"), rs.getString("ask"), rs.getInt("quan"));
			}
		}finally {
			
		}
		
		return msg;
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
			pstmt.setString(5, LunchMainView.adminId);//
		//5.
			pstmt.executeQuery();//update?
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
	
	/**
	 * 도시락 코드, 도시락명, 이미지, 가격, 특장점을 입력받아 도시락 코드에 해당하는 도시락을 변경
	 * 이미지가 ""라면 이미지는 변경하지 않는다.(다이나믹 쿼리-select)
	 * @param luvo
	 * @return
	 * @throws SQLException
	 */
	public boolean updateLunch(LunchUpdateVO luvo)throws SQLException {
		boolean flag=false;
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
		//1. 
		//2.
			con=getConn();
		//3.
			StringBuilder updateLunch=new StringBuilder();
			updateLunch
			.append("	  update lunch         ")
			.append("	  set lunch_name=?,   ")
			.append("	  	   price=?,spec=?  ");
			if(!luvo.getImg().equals("")) {//update한 이미지가 있다면
				updateLunch.append(", img=? ");//if가 맞으면 이미지가 들어가고 아니면 안들어감
			}//end if
			updateLunch.append("   where lunch_code=?");
			
			pstmt=con.prepareStatement(updateLunch.toString());
		//4.
			pstmt.setString(1, luvo.getName());//getLunch_name바꾸기
			pstmt.setInt(2, luvo.getPrice());
			pstmt.setString(3, luvo.getSpec());
			
//			int index=4;
//			if(!luvo.getImg().equals("")) {
//				pstmt.setString(index++, luvo.getImg());//전의는내꺼먼저 후의는남의것먼저
//			}else {
//				pstmt.setString(index, luvo.getLunch_code());
//			}//코드줄이기
			
			if(!luvo.getImg().equals("")) {
				pstmt.setString(4, luvo.getImg());
				pstmt.setString(5, luvo.getLunch_code());
			}else {
				pstmt.setString(4, luvo.getLunch_code());
			}
			
		//5.
			int cnt=pstmt.executeUpdate();
			if(cnt==1) {
				flag=true;
			}//end if
		}finally{	
		//6.
			if(pstmt!=null) {pstmt.close();}	
			if(con!=null) {con.close();}	
		}
		return flag;
	}//updateLunch
	
	public List<CalcVO> selectCalc(String date) throws SQLException {
		List<CalcVO> list=new ArrayList<CalcVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		//1.
		//2.
			con=getConn();
		//3.
			StringBuilder selectCalc=new StringBuilder();
			selectCalc
			.append("		select l.lunch_name, l.lunch_code, sum(o.quan) total, sum(o.quan)*l.price price	 ")
			.append("		from lunch l, ordering o	")
			.append("		where o.lunch_code = l.lunch_code	")
			.append("		 and to_char(o.order_date, 'yyyy-mm-dd') = to_char(to_date(?, 'yyyy-mm-dd'), 'yyyy-mm-dd')	")//바인드변수에 ''붙이지않는다!
			.append("		 and o.status='Y' ")
			.append("		group by l.lunch_code, l.lunch_name, l.price	")
			.append("		order by l.lunch_code	");
			
			pstmt=con.prepareStatement(selectCalc.toString());
		//4.
			pstmt.setString(1, date);//date가 물음표로 들어감
			
		//5.
			rs=pstmt.executeQuery();
			
			CalcVO cvo=null;
			while(rs.next()) {
				cvo=new CalcVO(rs.getString("lunch_code"), rs.getString("lunch_name"), rs.getInt("price"), rs.getInt("total"));
				list.add(cvo);
			}
			
			
		}finally {
		//6.
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}//end finally
		
		return list;
	}//selectCalc
	
	/**
	 * 오늘의 13시 이전의 주문 현황 
	 * @return
	 * @throws SQLException
	 */
	public List<OrderVO> selectOrderList() throws SQLException{
		System.out.println("---");
		List<OrderVO> list=new ArrayList<OrderVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		//1.
		//2.
			con=getConn();
		//3.
			StringBuilder selectOrder=new StringBuilder();
			selectOrder
			.append("		select     o.order_num, l.lunch_code, l.lunch_name, o.order_name,			")
			.append("		o.quan, l.price*o.quan price, to_char(o.order_date,'yyyy-mm-dd hh:mi:ss') order_date,	")//price는 소비자에게 받을 돈
			.append("		o.phone, o.ip_address, o.status														")
			.append("		from 		lunch l, ordering o															")
			.append("		where    o.lunch_code=l.lunch_code												")
			.append("		and to_char(order_date,'yyyy-mm-dd')=to_char(sysdate,'yyyy-mm-dd')		")
//			.append("		and to_char(order_date,'yyyy-mm-dd')='2019-01-15'							")
//			.append("		and to_char(order_date,'hh24') <=13												")
			.append("		order by o.order_num																	");
			
			pstmt=con.prepareStatement(selectOrder.toString());
		//4.
		//5.
			rs=pstmt.executeQuery();
			
			OrderVO ovo=null;
			while(rs.next()) {
				ovo=new OrderVO(rs.getString("order_num"), rs.getString("lunch_code"), rs.getString("lunch_name"), rs.getString("order_name")
						, rs.getString("order_date"), rs.getString("phone"), rs.getString("ip_address"), rs.getString("status"), rs.getInt("quan"), rs.getInt("price"));
				System.out.println(ovo);
				list.add(ovo);
				
			}//end while
		}finally {	
		//6.
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}
		return list;
	}
	
	/**
	 * 도시락 제작 완료시점에 호출되어 해당 주문 도시락의 완성 상태를 변경하는 일.
	 * @param orderNum
	 * @return
	 */
	public boolean updateStatus (String orderNum)throws SQLException {
		boolean flag=false;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
		//1.
		//2.
			con=getConn();
		//3.
			String updateOrder="update ordering set status='Y' where order_num=?";
			pstmt=con.prepareStatement(updateOrder);
		//4.
			pstmt.setString(1, orderNum);
		//5.
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
	}//updateStatus
	
	/**
	 * 주문된 도시락을 삭제하는 일.
	 * @param orderNum
	 * @return
	 */
	public boolean deleteOrder(String orderNum)throws SQLException{
		boolean flag=false;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
		//1.
		//2.
			con=getConn();
		//3.
			String deleteOrder="delete from ordering where order_num=?";
			pstmt=con.prepareStatement(deleteOrder);
		//4.
			pstmt.setString(1, orderNum);
		//5.
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
	}
	
	
	
	public static void main(String[] args) {
		try {
			System.out.println(getInstance().selectOrderList());//단위테스트
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}//class





























