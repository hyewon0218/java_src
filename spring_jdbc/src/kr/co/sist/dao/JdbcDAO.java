package kr.co.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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

}//class
