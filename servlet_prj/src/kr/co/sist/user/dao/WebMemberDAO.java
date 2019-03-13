package kr.co.sist.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.sist.user.vo.WebMemberVO;

public class WebMemberDAO {
	private static WebMemberDAO wm_dao;
	
	private WebMemberDAO() {
		
	}
	
	public static WebMemberDAO getInstance() {
		if(wm_dao==null) {
			wm_dao=new WebMemberDAO();
		}//end if
		return wm_dao;
	}//getInstance
	
	private Connection getConn() throws SQLException{
		Connection con=null;
		try {
			//1.JNDI ��밴ü ����
			Context ctx=new InitialContext();
			//2.DBCP���� DataSource ��� 
			DataSource ds=(DataSource) ctx.lookup("java:comp/env/jdbc/dbcp");
			//3.DataSource���� Connection���
			con=ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		}//end catch
		
		return con;
		
	}//getConn
	
	/**
	 * ID�� �����ϴ��� �ߺ� �˻�
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public boolean selectId(String id)throws SQLException{
		boolean flag=false;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		//1.
		//2.
		//3.
			con=getConn();
		//4.
			String selectId="select id from web_member where id=?";
			pstmt=con.prepareStatement(selectId);
			pstmt.setString(1, id);
		//5.
			rs=pstmt.executeQuery();
		
			flag = !rs.next();
		}finally {
			//6.
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}
		return flag;
	}//selectId
	
	/**
	 * �Էµ� ȸ�������� ������ DB�� �߰��ϴ� ��
	 * @param wm_vo
	 * @throws SQLException
	 */
	public void insertMember(WebMemberVO wm_vo) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
		//1.
		//2.
		//3.
			con=getConn();
		//4.
			StringBuilder insertMember=new StringBuilder();
			insertMember
			.append("insert into web_member(")
			.append("id,pass,name,ssn,gender,birth,age,marriage,marriage_date,zipcode,addr1,addr2,greeting,ip_address ")
			.append(" ) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			pstmt=con.prepareStatement(insertMember.toString());
			pstmt.setString(1, wm_vo.getId());
			pstmt.setString(2, wm_vo.getPass());
			pstmt.setString(3, wm_vo.getName());
			pstmt.setString(4, wm_vo.getSsn());
			pstmt.setString(5, wm_vo.getGender());
			pstmt.setString(6, wm_vo.getBirth());
			pstmt.setString(7, wm_vo.getAge());
			pstmt.setString(8, wm_vo.getMarriage());
			pstmt.setString(9, wm_vo.getMarriage_date());
			pstmt.setString(10, wm_vo.getZipcode());
			pstmt.setString(11, wm_vo.getAddr1());
			pstmt.setString(12, wm_vo.getAddr2());
			pstmt.setString(13, wm_vo.getGreeting());
			pstmt.setString(14, wm_vo.getIp_address());
		//5.	
			pstmt.executeUpdate();
			
			String[] lang=wm_vo.getLang();
			if(lang!=null) {//���ɾ������
				pstmt.close();
				String insertLang="insert into web_lang(id,lang) values(?,?)";
				//4.	
				pstmt=con.prepareStatement(insertLang);
				for(int i=0; i<lang.length; i++) {
					pstmt.setString(1, wm_vo.getId());
					pstmt.setString(2, lang[i]);
				//5.
					pstmt.executeQuery();
				}//end for
				
			}//end if
		}finally {
			//6.
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}	
	}//insertMember
	
	
}//class

















