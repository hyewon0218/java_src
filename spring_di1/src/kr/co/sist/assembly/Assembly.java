package kr.co.sist.assembly;

import kr.co.sist.dao.Dao;
import kr.co.sist.dao.DaoMySqlImpl;
import kr.co.sist.service.Service;
import kr.co.sist.service.ServiceImpl;

/**
 * 의존성 주입 관계를 설정하는 일
 * @author SIST
 *
 */
public class Assembly {
	public Service getBean() {
		//1. 의존성 주입할 객체 생성 
		//Dao dao=new DaoOracleImpl();
		Dao dao=new DaoMySqlImpl();
		//2. 의존성 주입 받을 객체 생성하면서 의존성 주입
		Service service=new ServiceImpl(dao);
		//3. 의존성 주입 받은 객체 반환 
		return service;
	}
}//class
