package day0402;

import java.util.HashMap;
import java.util.Map;

public class Run {
		
	/**
	 * is a ���踦 ������� ��
	 */
	public void useIsA() {
		Map<String, Person>map=new HashMap<String, Person>();
		//���Ҵ�
		map.put("gong", new Seonui());
		map.put("lee", new Jaehyun());
		map.put("jung", new Teacksung());
		
		//Ű
		String key="jung";
		//��ü�������� ����Ͽ� �θ� �� �ڽ��� �����Ѵ�.
		if(map.containsKey(key)) {
		Person person=map.get(key);
		System.out.println( person.execute());
		}
		
	}//useIsA
	/**
	 * is a ���踦 ������� �ʰ� ��ü�� ����� �� 
	 */
	public void notUseIsA() {
		Map<String, Object>map=new HashMap<String, Object>();
		//���Ҵ�
		map.put("gong", new Seonui());
		map.put("lee", new Jaehyun());
		map.put("jung", new Teacksung());
		
		//�����
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
