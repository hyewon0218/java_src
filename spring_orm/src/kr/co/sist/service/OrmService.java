package kr.co.sist.service;

import java.sql.SQLException;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.OrmDao;
import kr.co.sist.domain.Lunch;
import kr.co.sist.domain.LunchDetail;

@Component
public class OrmService {
	@Autowired(required=false)
	private OrmDao o_dao;
	
	public List<Lunch> searchAllLunch() {
		List<Lunch> list=null;
		
		try {
			list=o_dao.selelctAllLunch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}//searchAllLunch
	
	public JSONObject searchLunch(String lunch_code) {
		JSONObject json=null;
		
		try {
			LunchDetail ld=o_dao.selelctDetail(lunch_code);
			json=new JSONObject();
			json.put("img", ld.getImg());
			json.put("spec", ld.getSpec());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return json;
	}//searchLunch
}
