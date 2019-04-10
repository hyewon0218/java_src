package kr.co.sist.exam.service;

import java.util.List;

import kr.co.sist.exam.dao.carDAO;
import kr.co.sist.exam.domain.CarModel;


public class carService {
	private carDAO cd;
	public carService() {
		cd=new carDAO();
	}
	
	public List<String> searchMaker(String country) {
		List<String> list=null;
		list=cd.selectMaker(country);
		return list;
	}//multiParam
	
	public List<String> searchModel(String maker) {
		List<String> list=null;
		list=cd.selectModel(maker);
		return list;
	}//multiParam
	
	public List<CarModel> searchDetailModel(String model) {
		List<CarModel> list=null;
		list=cd.selectDetailModel(model);
		return list;
	}//multiParam
	
	
}












