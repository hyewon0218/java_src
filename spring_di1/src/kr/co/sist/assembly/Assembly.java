package kr.co.sist.assembly;

import kr.co.sist.dao.Dao;
import kr.co.sist.dao.DaoMySqlImpl;
import kr.co.sist.service.Service;
import kr.co.sist.service.ServiceImpl;

/**
 * ������ ���� ���踦 �����ϴ� ��
 * @author SIST
 *
 */
public class Assembly {
	public Service getBean() {
		//1. ������ ������ ��ü ���� 
		//Dao dao=new DaoOracleImpl();
		Dao dao=new DaoMySqlImpl();
		//2. ������ ���� ���� ��ü �����ϸ鼭 ������ ����
		Service service=new ServiceImpl(dao);
		//3. ������ ���� ���� ��ü ��ȯ 
		return service;
	}
}//class
