package kr.co.sist.dao;

import java.sql.SQLException;
import java.util.List;

import kr.co.sist.vo.EmpVo;

public interface Dao {
	public int insertEmp(EmpVo ev)throws SQLException;
	public List<EmpVo> selectEmp()throws SQLException;
}
