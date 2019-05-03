package kr.co.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.ItemDAO;
import kr.co.sist.domain.ItemDomain;
@Component
public class ItemServiceImpl implements ItemService{
	@Autowired
	private ItemDAO i_dao;
	
	@Override
	public ItemDomain searchItem(String name) {
		System.out.println("------------- searchItem È£Ãâ");
		return i_dao.selectItem(name);
	}//searchItem

	@Override
	public String getName() {
		String name="±èÁ¤À±";
		System.out.println("getName///"+name);
		return name;
	}

	@Override
	public String getAddr() {
		String addr="¼­¿ï½Ã °­³²±¸ ¿ª»ïµ¿ ";
		
		i_dao.getDbName();
		System.out.println("getAddr///"+addr);
		return addr;
	}

	@Override
	public int getAge() {
		int age=20;
		System.out.println("getAddr///"+age);
		return age;
	}

	@Override
	public ItemDomain searchData(String name) {
		
		return new ItemDomain("IO_O001",name+"¾Ö¹ú·¡, Å©·±Ä¿,,,");
	}//searchData

	
}//class
