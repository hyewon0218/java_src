package day0111_subb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.connection.GetConnection;

public class NamecardDAO {
	private static NamecardDAO n_dao;//
	
	private NamecardDAO() {	
	}
	
	public static NamecardDAO getInstance() {
		if(n_dao ==null) {
			n_dao =new NamecardDAO();
		}
		return n_dao;
	}

	
	public void insertNamecard(NamecardVO nvo)throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=GetConnection.getInstance().getConn(url, id, pass);
			
			String insertNamecard="insert into namecard(name,addr,img) values(?,?,?)";
			pstmt=con.prepareStatement(insertNamecard);
			
			pstmt.setString(1, nvo.getName());
			pstmt.setString(2, nvo.getAddr());
			pstmt.setString(3, nvo.getImg());
			
			pstmt.executeUpdate();
		}finally {
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}
	}
	public List<NamecardVO> selectNamecard() throws SQLException {
		List<NamecardVO> list= new ArrayList<NamecardVO>();
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String id="scott";
			String pass="tiger";
			
			con=GetConnection.getInstance().getConn(url, id, pass);
			
			String selectNamecard="select name, addr,img from namecard order by input_date";
			pstmt=con.prepareStatement(selectNamecard);
			
			rs=pstmt.executeQuery();
			NamecardVO nvo=null;
			while(rs.next()) {
				nvo=new NamecardVO(rs.getString("name"),rs.getString("addr"),rs.getString("img"));
				list.add(nvo);
			}
		}finally {
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
			if(rs!=null) {rs.close();}
		}
		return list;
	}
	public static void main(String[] args) {
		NamecardDAO n=new NamecardDAO();
		try {
			n.insertNamecard(new NamecardVO("김건하","서울시 성동구 옥수수","no_image.png"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
