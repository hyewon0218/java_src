package day1207;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map : KVP로 되어있는 자료구조, 키를 사용하여 값을 얻는 일
 * 
 * @author SIST
 */
public class UseMap {
	public UseMap() {
		// JDK1.5이하인 경우 Generic을 사용할 수 없고, 객체만 저장 가능하다.
		// 1. 생성
		Map<String, String> map = new HashMap<String, String>();
		// 2. 값 할당 - 키는 유일 , 값은 중복 가능, 입력되는 순서대로 값이 추가되지 않는다.
		map.put("Oracle", "대용량 데이터베이스");
		map.put("Java", "프로그래밍 언어");
		map.put("Python", "프로그래밍 언어");// 값은 중복 가능
		map.put("Java", "완벽한 객체지향 언어");// 키가 존재한다면 해당 키에 덮어 쓴다.
		map.put("HTML", "Markup Language");// 키가 존재한다면 해당 키에 덮어 쓴다.
		System.out.println(map.size() + " " + map);
		// 3. 값 얻기) 키를 사용하여 값을 얻는다.
		// 키에 해당하는 값이 없다면 null을 반환
		String val = map.get("Java");// Java,HTML
		System.out.println(val);
		// 4. 키가 존재하는지?
		String key = "Java";
		boolean flag = map.containsKey("Java");
		System.out.println(key + "키가 존재 " + flag);

		// 5. 값 삭제
		map.remove("Java");
		System.out.println("삭제 후 : " + map);

		/// 6. 모든 키 얻기
		Set<String> allkeys = map.keySet();
		System.out.println("맵이 가진 모든 키 : " + allkeys);

		// 7. 모든 값 얻기
		Iterator<String> ita = allkeys.iterator();// 모든 키가 iterator에들어감
		String value = "";
		while (ita.hasNext()) {// 키가 존재한다면
			value = map.get(ita.next());// 얻어낸 키를 가지고 맵의 값을 얻는다.
			System.out.println(value);

		}
		// 8. 모두 삭제
		map.clear();
		System.out.println("모두 삭제 : " + map.size() + "/" + map);
	}
	
	/**
	 * 기본생성자를 사용하면 11개의 행이 자동 생성
	 * MultiThread에서 동시접근 불가능.
	 * 데이터가 전체 행 갯수의 약 75%채워있을 때 가장 빠른 검색을 한다.
	 */
	public void useHashtable(String key) {
		//1. 생성
		Map<String, String> bloodmap =new HashMap<String,String>(100);
		//2. 값 할당
		bloodmap.put("A","세심하다, 친절하다.^o^b");
		bloodmap.put("B","성질드럽다 ㅡ,.ㅡ");
		bloodmap.put("AB","싸이코 @,.@");
		bloodmap.put("O","우유부단하다 ~(^^~)(~^^)~");
		bloodmap.put("A","소심하다. ☞^.^☜");
		
		//값 얻기
		String value=bloodmap.get(key.toUpperCase());
		
		if(!bloodmap.containsKey(key.toUpperCase())) {//키가 존재하는지?
			System.out.println(key+"혈액형은 사람의 것이 아닙니다.");
		}else {
			System.out.println(key+"형 의 특징은 : "+ value);
		}
	}
	/**
	 * 기본생성자를 사용하면 16개의 행이 자동 생성
	 * MultiThread에서 동시접근 가능.
	 * 데이터가 전체 행 갯수의 약 75%채워있을 때 가장 빠른 검색을 한다.
	 */
	public void useHashMap(String key) {
		//1. 생성
		Map<String,String> map =new HashMap<String, String>();
		//2. 값 할당
		map.put("결초보은", "풀을 묶어 은혜를 값는다.");
		map.put("역지사지", "상대방의 입장에서 생각한다.");
		map.put("무념무상", "아무것도 하지 않지만 더 격렬하게 아무것도 하지 않겠다.");
		map.put("내로남불", "내가하면 로맨스 니가하면 불륜");
		map.put("이부망천", "서울살다 이혼하면 부천가고 망하면 인천간다.");
		map.put("낄끼빠빠", "낄 때 보고 끼어라.");
		map.put("순망치한", "입술이 없으면 징그러워요.");
		map.put("정택성씨", "구로구의 자랑.");
		
		//3. 값 얻기
		if (map.containsKey(key)) {//맵에 키가 존재한다면 
			String value=map.get(key);//값 얻기
			System.out.println(key+"의 뜻은 "+value);
		}else {	
			System.out.println(key+"사자성어는 준비되지 않았습니다.");
		}
	}

	public static void main(String[] args) {
		UseMap um=new UseMap();
		System.out.println("------------------------Hashtable사용------------------------------------");
		um.useHashtable("a");
		System.out.println("------------------------HashMap사용------------------------------------");
		um.useHashMap("결초보은");
	}// main

}// class
