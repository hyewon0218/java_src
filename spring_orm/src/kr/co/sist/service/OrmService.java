package kr.co.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.OrmDao;

@Component
public class OrmService {
	@Autowired(required=false)
	private OrmDao o_dao;
	
	public void test() {
		System.out.println("----------"+o_dao);
	}
}
