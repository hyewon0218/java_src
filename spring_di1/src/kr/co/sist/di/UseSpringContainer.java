package kr.co.sist.di;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.sist.service.ServiceImpl;
import kr.co.sist.vo.EmpVo;

public class UseSpringContainer {

	public static void main(String[] args) {
		
		//1. 설정파일을 사용하여 Spring Container 생성
		ApplicationContext ac=new ClassPathXmlApplicationContext("kr/co/sist/di/applicationContext.xml");
		
		//2. id를 사용하여 Bean(의존성 주입받은 객체) 얻기
		//ServiceImpl si=(ServiceImpl)ac.getBean("service");//2.5.3
		
		ServiceImpl si=ac.getBean(ServiceImpl.class);
		
		//3. 찾아낸 Bean을 사용하여 사용
		si.addEmp(new EmpVo(3333, "김정윤"));
		
		List<EmpVo> list=si.searchEmp();
		for(EmpVo ev : list) {
			System.out.println(ev.getEmpno()+"/"+ev.getEname());
		}
	}//main

}//class
