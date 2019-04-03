package day0402;

import java.util.HashMap;
import java.util.Map;

public class Run {
		
	/**
	 * is a 관계를 사용했을 때
	 */
	public void useIsA() {
		Map<String, Person>map=new HashMap<String, Person>();
		//값할당
		map.put("gong", new Seonui());
		map.put("lee", new Jaehyun());
		map.put("jung", new Teacksung());
		
		//키
		String key="jung";
		//객체다형성을 사용하여 부모에 얻어낸 자식을 저장한다.
		if(map.containsKey(key)) {
		Person person=map.get(key);
		System.out.println( person.execute());
		}
		
	}//useIsA
	/**
	 * is a 관계를 사용하지 않고 객체를 사용할 때 
	 */
	public void notUseIsA() {
		Map<String, Object>map=new HashMap<String, Object>();
		//값할당
		map.put("gong", new Seonui());
		map.put("lee", new Jaehyun());
		map.put("jung", new Teacksung());
		
		//값사용
		String key="lee";
		if("gong".equals(key)) {
		Seonui su=(Seonui)map.get(key);
		System.out.println(su.execute());
		
		}
		if("jung".equals(key)) {
			Teacksung ts=(Teacksung)map.get(key);
			System.out.println(ts.execute());
			
		}
		if("lee".equals(key)) {
			Jaehyun jh=(Jaehyun)map.get(key);
			System.out.println(jh.execute());
			
		}
	}//useIsA
	public static void main(String[] args) {
		Run run=new Run();
		run.useIsA();
		System.out.println("------------------------------------------------");
		run.notUseIsA();
	}//main

}//class
