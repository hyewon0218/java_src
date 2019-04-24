package day0423;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class TestService3 {
	
	//의존성 주입 받은 객체위에 annotation 선언
	@Autowired
	private TestDao3 td;
	
	
	public TestDao3 getTestDao3() {
		return td;
	}
}//class
