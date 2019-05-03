package kr.co.sist.dao;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.domain.Lunch;
import kr.co.sist.domain.LunchDetail;

@Component
public class OrmDao {
	@Autowired(required=false)
	SqlSessionTemplate sst;
	
	public List<Lunch> selelctAllLunch() throws SQLException{
		List<Lunch> list=null;
		list=sst.selectList("kr.co.sist.selectAllLunch");//namespace까지 쓰는 것 권장
		
		return list;
	}
	public LunchDetail selelctDetail(String lunchCode) throws SQLException{
		LunchDetail ld=null;

		ld=sst.selectOne("kr.co.sist.selectDetail",lunchCode);
		
		return ld;
	}
}
