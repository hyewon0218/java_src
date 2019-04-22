package kr.co.sist.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.vo.EmpVo;

public class DaoMySqlImpl implements Dao {

	@Override
	public int insertEmp(EmpVo ev) throws SQLException {
		//Oracle DB에 insert작업 수행
		System.out.println("MySQL에 사원정보 추가");
		return 1;
	}//insertEmp

	@Override
	public List<EmpVo> selectEmp() throws SQLException {
		List<EmpVo> list=new ArrayList<EmpVo>();
		list.add(new EmpVo(2111, "공선의"));
		list.add(new EmpVo(2112, "이재현"));
		list.add(new EmpVo(2113, "오영근"));
		list.add(new EmpVo(2114, "정택성"));
		list.add(new EmpVo(2115, "이봉현"));
		
		return list;
	}

}
