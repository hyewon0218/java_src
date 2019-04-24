package day0423;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunAnnotation {

	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("day0423/applicationContext3.xml");
		TestService3 ts2=ac.getBean(TestService3.class);
		System.out.println(ts2);
		System.out.println(ts2.getTestDao3());//autowired로 의존성 주입
	}

}
