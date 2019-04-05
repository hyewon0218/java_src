package kr.co.sist.exam.service;

import java.util.List;

import kr.co.sist.exam.dao.MyBatisDAO1;
import kr.co.sist.exam.domain.Emp;
import kr.co.sist.exam.domain.Zipcode;
import kr.co.sist.exam.vo.EmpVO;

public class MyBatisService1 {
	public List<Emp> multiParam(EmpVO ev) {
		List<Emp> list=null;
		MyBatisDAO1 mb_dao=new MyBatisDAO1();
		list=mb_dao.multiParam(ev);
		return list;
	}//multiParam
	
	public List<Emp> lessThan(int sal) {
		List<Emp> list=null;
		
		if(sal < 0) {
			sal=-sal;
		}//end if
		
		MyBatisDAO1 mb_dao=new MyBatisDAO1();
		list=mb_dao.lessThan(sal);
		
		return list;
	}//lessThan
	
	public List<Emp> greaterThan(int sal) {
		List<Emp> list=null;
		
		if(sal > 10000) {
			sal=10000;
		}//end if
		
		MyBatisDAO1 mb_dao=new MyBatisDAO1();
		list=mb_dao.greaterThan(sal);
		
		return list;
	}//lessThan
	
	public List<Zipcode> like(String dong) {
		List<Zipcode> list=null;
		
		MyBatisDAO1 mb_dao=new MyBatisDAO1();
		list=mb_dao.like(dong);
		
		return list;
	}//like
	
}












