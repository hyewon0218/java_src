package kr.co.sist.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.sist.domain.ItemDomain;
import kr.co.sist.service.ItemService;
import kr.co.sist.service.ItemServiceImpl;

public class AopRun {

	public void execute() {
		ApplicationContext ac=
				new ClassPathXmlApplicationContext
					("kr/co/sist/run/applicationContext.xml");
		
		ItemService is=ac.getBean(ItemService.class);
	/*	System.out.println("----------------------run getaddr");
		is.getAddr();
		System.out.println("----------------------run getname");
		is.getName();
		System.out.println("----------------------run getage");
		is.getAge();*/
		
		/*ItemDomain id= is.searchItem("이재찬");
		System.out.println( id.getItemNo() );
		System.out.println( id.getItem() );*/
		
		ItemDomain id=is.searchData("정택성");
		System.out.println(id.getItemNo()+"/"+id.getItem());
	}//execute
	
	public static void main(String[] args) {
		AopRun ar=new AopRun();
		ar.execute();
		
	}//main

}//class
