package kr.co.sist.exam.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.sist.exam.domain.CarModel;



public class carDAO {
	public List<String> selectMaker(String country) {
		List<String> list=null;
		//4. handler 얻기
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		
		list=ss.selectList("selectCarCountry",country);
		
		ss.close();
		
		return list;
		
	}//multiParam
	
	public List<String> selectModel(String maker) {
		List<String> list=null;
		//4. handler 얻기
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		
		list=ss.selectList("selectCarMaker",maker);
		
		ss.close();
		
		return list;
		
	}//multiParam
	
	public List<CarModel> selectDetailModel(String model) {
		List<CarModel> list=null;
		//4. handler 얻기
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		
		list=ss.selectList("selectCarModel",model);
		
		ss.close();
		
		return list;
		
	}//multiParam
	

	public static void main(String[] args) {
		carDAO md=new carDAO();
		md.selectMaker("수입");
		//md.selectModel("BMW");
	}
}//class



























