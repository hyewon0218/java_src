package kr.co.sist.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import kr.co.sist.domain.Member;
import kr.co.sist.domain.MemberDetail;
import kr.co.sist.vo.MemberVO;
@Component
public class JdbcDAO {
	@Autowired(required=false)
	private JdbcTemplate jt;
	
	public void insertMemer(MemberVO mv)throws DataAccessException {
		//Spring JDBC를 사용하여 레코드 추가
		String insertMember="insert into test_like(num,name,loc,highschool,img) values(seq_reply.nextval, ?,?,?,?)";
		jt.update(insertMember, mv.getName(), mv.getLoc(), mv.getHighschool(), mv.getImg());
	}
	
	
	public List<Member> selectAllMember() throws DataAccessException{
		List<Member> list=null;
		
		//조회결과를 Domain에 저장하는 객체 생성 (RowMapper) 
		RowMapper<Member> rm=new RowMapper<Member>() {
			
			@Override
			public Member mapRow(ResultSet rs, int idx) throws SQLException {
				Member m=new Member(rs.getInt("num"), rs.getString("name"), 
												rs.getString("img"));
				return m;
			}//mapRow
		};//anosymous innerclass
		//SQL문 작성 
		
		String selectMember="select num,name,img from test_like";
		//쿼리를 실행하여 결과 얻기
		list=jt.query(selectMember,rm);
		
		return list;
	}//selectAllMember
	
	//한행 조회
	public MemberDetail 	selectOneMember(int num) throws DataAccessException{
		MemberDetail md=null;
		//조회된 결과를 저장
		RowMapper<MemberDetail> rm=new RowMapper<MemberDetail>() {
			
			@Override
			public MemberDetail mapRow(ResultSet rs, int idx) throws SQLException {
				MemberDetail md=null;
				md=new MemberDetail(rs.getString("name"), rs.getString("loc"), rs.getString("highschool"));
				return md;
			}
		};
		
		//쿼리실행 : 한행조회 queryForOBJECT
		String selectOne="select name, loc, highschool from test_like where num=?";
		md=jt.queryForObject(selectOne, rm, num);
		System.out.println(md);
		
		return md;
	}
	

}//class


















