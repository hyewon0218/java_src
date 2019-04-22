package kr.co.sist.service;

import java.util.List;

import kr.co.sist.vo.EmpVo;

public interface Service {
	public void addEmp(EmpVo ev);
	public List<EmpVo> searchEmp();
}
