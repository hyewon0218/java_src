package kr.co.sist.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrmDao {
	@Autowired(required=false)
	SqlSessionTemplate sst;
	
	public SqlSessionTemplate test() {
		return sst;
	}
}
