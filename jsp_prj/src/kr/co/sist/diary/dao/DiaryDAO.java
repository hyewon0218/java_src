package kr.co.sist.diary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.sist.diary.vo.DiaryDetailVO;
import kr.co.sist.diary.vo.DiaryListVO;
import kr.co.sist.diary.vo.DiaryRemoveVO;
import kr.co.sist.diary.vo.DiaryUpdateVO;
import kr.co.sist.diary.vo.DiaryVO;
import kr.co.sist.diary.vo.MonthVO;
import kr.co.sist.diary.vo.SearchDataVO;

public class DiaryDAO {
	private static DiaryDAO d_dao;
	
	public DiaryDAO() {

	}//DiaryDAO
	
	public static DiaryDAO getInstance() {
		if(d_dao==null) {
			d_dao=new DiaryDAO();
		}//end if
		return d_dao;
	}//getInstance
	
	private Connection getConn()throws SQLException {
		Connection con=null;
		
		
		try {
			//1. JNDI ��밴ü ����
			Context ctx=new InitialContext();
			//2. DBCP�� ����� DataSource ���
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/jsp_dbcp");
			//3. Connection ���
			con=ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		return con;
	}//getConn
	
	/**
	 * ��, ���� �Է¹޾� �ش� ���� ��� ������ �۹�ȣ�� ������ �����迭�� �����Ͽ� 
	 * ��ȯ�ϴ� �� 
	 * @param year ��
	 * @param month ��
	 * @return �����迭
	 * @throws SQLException
	 */
	public  MonthVO[][] selectMonthEvent(String year,String month)throws SQLException {
		MonthVO[][] mv=new MonthVO[31][];
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		//1.
		//2.
		//3.
			con=getConn();
		//4.
			//�ԷµǴ� ��,���� ���� ���ں� ������ �����Ͽ� Variable Array�� ����
			StringBuilder selectMonthData=new StringBuilder();
			selectMonthData
			.append(" select num,subject ")
			.append(" from diary ")
			.append(" where e_year=? and e_month=? and e_day=?")
			.append(" order by num");
			
			pstmt=con.prepareStatement(selectMonthData.toString());
			pstmt.setString(1, year);
			pstmt.setString(2, month);
			
			//5.
			List<MonthVO> list=new ArrayList<MonthVO>();
			for(int i=0; i<31; i++) {//�ش� ����� 
				pstmt.setString(3, String.valueOf(i+1));//1�Ϻ��� 31�ϱ��� ������ ����
				rs=pstmt.executeQuery();
				while(rs.next()) {//�������� �����Ѵٸ� �ش� ���ڿ� ���� �����ϹǷ� 
					//�̺�Ʈ���ǰ��� �����Ѵ�.
					list.add(new MonthVO(rs.getInt("num"),rs.getString("subject")));
				}//end while
				rs.close();
				if(list.size()!=0) {//�ش����ڿ� ���� �����Ѵٸ�
					MonthVO[] mvoArr=new MonthVO[list.size()];//���� ������ �迭 ����
					list.toArray(mvoArr);//����Ʈ�� �����ϴ� ���� ������ �迭�� ����
					mv[i]=mvoArr;//������ �迭�� ���� �����迭�� i�࿡ �߰�
				}
				list.clear();//����Ʈ�� �ʱ�ȭ�Ѵ�.
			}
			
		}finally{
		//6.
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}
		return mv;
	}//selectMonthEvent
	
	/**
	 * �̺�Ʈ �߰�
	 * @param d_vo
	 * @throws SQLException
	 */
	public void insertEvent(DiaryVO d_vo)throws SQLException {

		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
		//1. 
		//2.
		//3.
			con=getConn();
		//4.
			StringBuilder insertEvt=new StringBuilder();
			insertEvt.append("INSERT INTO DIARY")
			.append("(NUM,WRITER,SUBJECT,CONTENTS,E_YEAR,E_MONTH,E_DAY,PASS,IP)")
			.append("values(seq_diary.nextval,?,?,?,?,?,?,?,?)");
			
			pstmt=con.prepareStatement(insertEvt.toString());
			
			pstmt.setString(1, d_vo.getWriter());	
			pstmt.setString(2, d_vo.getSubject());	
			pstmt.setString(3, d_vo.getContents());	
			pstmt.setString(4, d_vo.getE_year());	
			pstmt.setString(5, d_vo.getE_month());	
			pstmt.setString(6, d_vo.getE_day());	
			pstmt.setString(7, d_vo.getPass());	
			pstmt.setString(8, d_vo.getIp());	
		//5.
			pstmt.executeUpdate();
		}finally {
		//6.
				if(pstmt!=null) {pstmt.close();}
				if(con!=null) {con.close();}}
	}//insertEvent
	
	/**
	 * �� ��ȣ�� �Է¹޾� �ش� �̺�Ʈ�� �� ���� ��ȸ 
	 * @param num
	 * @return
	 * @throws SQLException
	 */
	public DiaryDetailVO selectDetailEvent(int num)throws SQLException {
		DiaryDetailVO dd_vo=null;
		
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		//1.
		//2.
		//3.
			con=getConn();
		//4.
			StringBuilder selectOneEvt=new StringBuilder();
			selectOneEvt
			.append(" SELECT WRITER,SUBJECT,	CONTENTS,TO_CHAR(W_DATE,'YYYY-MM-DD DY HH24:MI') W_DATE,IP		")
			.append("  FROM DIARY ")
			.append("  WHERE NUM=?");
			
			pstmt=con.prepareStatement(selectOneEvt.toString());
			pstmt.setInt(1, num);
		//5.
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dd_vo=new DiaryDetailVO(rs.getString("writer"), rs.getString("subject"), rs.getString("contents"), rs.getString("w_date"), rs.getString("ip"));
			}
			
			
		}finally {
		//6.
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}	
		
		return dd_vo;
	}//selectDetailEvent
	
	/**
	 * �۹�ȣ, ����, ��й�ȣ�� �Է¹޾� ��й�ȣ�� ��ġ�ϸ� �ش� �۹�ȣ�� �̺�Ʈ ������ �����ϴ� ��
	 * @param du_vo
	 * @return
	 * @throws SQLException
	 */
	public int updateEvent(DiaryUpdateVO du_vo)throws SQLException {
		int cnt=0;
		Connection con=null;
		PreparedStatement pstmt=null;
	
		try {
		//1.
		//2.
		//3.
					con=getConn();
		//4.
					StringBuilder updateEvt=new StringBuilder();
					updateEvt
					.append("  update diary ")
					.append(" set contents=? ")
					.append("  where num=? and pass=?");
					
					pstmt=con.prepareStatement(updateEvt.toString());
					pstmt.setString(1, du_vo.getContents());
					pstmt.setInt(2, du_vo.getNum());
					pstmt.setString(3, du_vo.getPass());
		//5.
					cnt=pstmt.executeUpdate();
					
		}finally {
			//6.
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}	
		return cnt;
	}//updateEvent
	
	/**
	 * �۹�ȣ, ��й�ȣ�� �Է¹޾� �ش� ���� �����ϴ� ��
	 * @param dr_vo
	 * @return
	 * @throws SQLException
	 */
	public int deleteEvent(DiaryRemoveVO dr_vo)throws SQLException{
		int cnt=0;
		Connection con=null;
		PreparedStatement pstmt=null;
	
		try {
		//1.
		//2.
		//3.
					con=getConn();
		//4.
					StringBuilder deleteEvt=new StringBuilder();
					deleteEvt.append("  delete from diary where num=? and pass=? ");
					
					pstmt=con.prepareStatement(deleteEvt.toString());
					pstmt.setInt(1, dr_vo.getNum());
					pstmt.setString(2, dr_vo.getPass());
		//5.
					cnt=pstmt.executeUpdate();
					
		}finally {
			//6.
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}	
		
		
		return cnt;
	}//deleteEvent
	
	/**
	 * @param sd_vo
	 * @return
	 * @throws SQLException
	 */
	public int selectEvtCnt(SearchDataVO sd_vo)throws SQLException {
		int cnt=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		//1.
		//2.
		//3
			con=getConn();
		//4.
			StringBuilder selectCnt=new StringBuilder();
			selectCnt.append("select count(*)cnt fron diary");
			if (sd_vo!=null) {
				//Dynamic query
			}
			pstmt=con.prepareStatement(selectCnt.toString());
		//5.
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				cnt=rs.getInt("cnt");
			}
		}finally {
			//6.
			if(rs!=null) {rs.close();}
			if(pstmt!=null) {pstmt.close();}
			if(con!=null) {con.close();}
		}	
		
		return cnt;
	}//selectCnt
	
	/**
	 * �Խ����� ����Ʈ�������� ��ȸ�ϴ� ��.
	 * @param sd_vo
	 * @return
	 * @throws SQLException
	 */
	public List<DiaryListVO> selectList(SearchDataVO sd_vo)throws SQLException{
		List<DiaryListVO> list=new ArrayList<>();
		
		return list;
	}//selectList
	
}//class























