package day0423;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunJcf {

	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("day0423/applicationContext2.xml");
		
		System.out.println("-----------------------List Injection---------------------------");
		JcfInjection ji=ac.getBean("jiList",JcfInjection.class);
		System.out.println(ji.getList());
		System.out.println("-----------------------Set Injection---------------------------");
		JcfInjection ji1=ac.getBean("jiSet",JcfInjection.class);
		System.out.println(ji1.geSet());
		System.out.println("-----------------------List VO Injection---------------------------");
		JcfInjection ji2=ac.getBean("jiVoList",JcfInjection.class);
		System.out.println(ji2.getVoList());
		System.out.println("-----------------------Map VO Injection---------------------------");
		JcfInjection ji3=ac.getBean("jiMap",JcfInjection.class);
		System.out.println(ji3.getMap());
	}

}
