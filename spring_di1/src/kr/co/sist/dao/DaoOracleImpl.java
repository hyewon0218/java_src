package kr.co.sist.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.vo.EmpVo;

public class DaoOracleImpl implements Dao {

	@Override
	public int insertEmp(EmpVo ev) throws SQLException {
		//Oracle DB에 insert작업 수행
		System.out.println("Oracle에 사원정보 추가");
		return 1;
	}//insertEmp

	@Override
	public List<EmpVo> selectEmp() throws SQLException {
		List<EmpVo> list=new ArrayList<EmpVo>();
		list.add(new EmpVo(1111, "노진경"));
		list.add(new EmpVo(1112, "김희철"));
		list.add(new EmpVo(1113, "김정윤"));
		list.add(new EmpVo(1114, "이재찬"));
		
		return list;
	}

}
