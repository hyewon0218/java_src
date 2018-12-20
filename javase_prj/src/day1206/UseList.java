package day1206;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * List : <br>
 * 중복값을 허용하며, 검색의 기능이 있고 순서대로 값을 입력하는 가변길이형
 * 
 * @author SIST
 */
public class UseList {

	public UseList() {
		// JDK1.4에서는 Generic이 제공되지 않고 객체만 저장된다.
//		List list=new ArrayList();
//		//값 추가 : JDK1.5 이하에서는 객체로만 값을 넣을 수 있다. 
//		list.add(new Integer(10));
//		list.add(new Short((short)10));
//		list.add("공선의");//객체라면 뭐든지 가능
//		
//		System.out.println(list.size());
//		System.out.println(((Integer)list.get(0)).intValue()+10);

		// JDK1.5+에서 사용 : Generic, auto boxing, unboxing
		// Generic을 권장
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);// autoboxing ==> list.add(new Integer(10)); compiler가 해줌
		list.add(20);
		list.add(new Integer(30));
//		list.add("김건하");//Generic으로 설정된 형이 아닌 데이터형을 추가할 수 없다.

		System.out.println("크기" + list.size());
		System.out.println(list.get(2) + 10);// (Integer)캐스팅할필요없음
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	/**
	 * ArrayList의 사용 : Multi Thread환경에서 동시 접근 가능(동기화x)
	 */
	public void useArrayaList() {
		// 1.생성
		ArrayList<String> al = new ArrayList<>();// 방이 0개
		List<String> al1 = new ArrayList<String>(100);// 방이 100개

		System.out.println(al + "/" + al1);// 주소가나오지않는이유는 자식어레이가 투스트링으로 오버라이딩
		// 값 추가 : 순서대로 추가된다.
		al.add("이재현");
		al.add("정택성");
		al.add("김정윤");
		al.add("김건하");
		al.add("김정윤");// 중복값 저장 가능
		al.add("노진경");
		al.add("김정윤");// 중복값 저장 가능
		al.add("김정윤");// 중복값 저장 가능
		al.add("공선의");
		System.out.println(al + "/" + al1);
		// size() : 데이터의 크기
		System.out.println("al 크기" + al.size() + "/ al1의 크기 : " + al1.size());// 값이 '들어있는' 크기

		// 배열에 복사
		String[] names = new String[al.size()];// 고정길이라 크기지정해야
		al.toArray(names);

		// 방의 값 삭제 :
		// 인덱스로 삭제 : 특정 인덱스방의 값이 삭제.
		al.remove(4);
		System.out.println(al.size() + "/" + al);
		// 방의 내용으로 삭제 : 가장 첫방이 삭제된다.
		al.remove("김정윤");// L->R으로 진행하면서 일치하는 첫방의 값만 삭제
		System.out.println(al.size() + "/" + al);

		for (String name : al) {
			System.out.println(name);
		}
		// 모든 방의 값 삭제 :
		al.clear();
		System.out.println("전체 삭제 후 : " + al.size() + "/" + al);

		// 배열의 값
		for (int i = 0; i < names.length; i++) {
			System.out.printf("%s\t", names[i]);// 배열의값은 사라지지않았
		}

	}

	public void useVector() {
		// 1.생성
		Vector<String> vec = new Vector<>();// 방이 0개
		List<String> vec1 = new Vector<String>(100);// 방이 100개

		System.out.println(vec + "/" + vec1);// 주소가나오지않는이유는 자식어레이가 투스트링으로 오버라이딩
		// 값 추가 : 순서대로 추가된다.
		vec.add("이재현");
		vec.add("정택성");
		vec.add("김정윤");
		vec.add("김건하");
		vec.add("김정윤");// 중복값 저장 가능
		vec.add("노진경");
		vec.add("김정윤");// 중복값 저장 가능
		vec.add("김정윤");// 중복값 저장 가능
		vec.add("공선의");
		System.out.println(vec + "/" + vec1);
		// size() : 데이터의 크기
		System.out.println("vec 크기" + vec.size() + "/ vec1의 크기 : " + vec1.size());// 값이 '들어있는' 크기

		// 배열에 복사
		String[] names = new String[vec.size()];// 고정길이라 크기지정해야
		vec.toArray(names);

		// 방의 값 삭제 :
		// 인덱스로 삭제 : 특정 인덱스방의 값이 삭제.
		vec.remove(4);
		System.out.println(vec.size() + "/" + vec);
		// 방의 내용으로 삭제 : 가장 첫방이 삭제된다.
		vec.remove("김정윤");// L->R으로 진행하면서 일치하는 첫방의 값만 삭제
		System.out.println(vec.size() + "/" + vec);

		for (String name : vec) {
			System.out.println(name);
		}
		// 모든 방의 값 삭제 :
		vec.clear();
		System.out.println("전체 삭제 후 : " + vec.size() + "/" + vec);

		// 배열의 값
		for (int i = 0; i < names.length; i++) {
			System.out.printf("%s\t", names[i]);// 배열의값은 사라지지않았
		}

	}

	public void useLinkedList() {
		// 1.생성
		LinkedList<String> ll = new LinkedList<>();// 방이 0개
		List<String> ll1 = new LinkedList<String>();// 방이 100개

		System.out.println(ll + "/" + ll1);// 주소가나오지않는이유는 자식어레이가 투스트링으로 오버라이딩
		// 값 추가 : 순서대로 추가된다.
		ll.add("이재현");
		ll.add("정택성");
		ll.add("김정윤");
		ll.add("김건하");
		ll.add("김정윤");// 중복값 저장 가능
		ll.add("노진경");
		ll.add("김정윤");// 중복값 저장 가능
		ll.add("김정윤");// 중복값 저장 가능
		ll.add("공선의");
		System.out.println(ll + "/" + ll1);
		// size() : 데이터의 크기
		System.out.println("ll 크기" + ll.size() + "/ ll1의 크기 : " + ll1.size());// 값이 '들어있는' 크기

		// 배열에 복사
		String[] names = new String[ll.size()];// 고정길이라 크기지정해야
		ll.toArray(names);

		// 방의 값 삭제 :
		// 인덱스로 삭제 : 특정 인덱스방의 값이 삭제.
		ll.remove(4);
		System.out.println(ll.size() + "/" + ll);
		// 방의 내용으로 삭제 : 가장 첫방이 삭제된다.
		ll.remove("김정윤");// L->R으로 진행하면서 일치하는 첫방의 값만 삭제
		System.out.println(ll.size() + "/" + ll);

		for (String name : ll) {
			System.out.println(name);
		}
		// 모든 방의 값 삭제 :
		ll.clear();
		System.out.println("전체 삭제 후 : " + ll.size() + "/" + ll);

		// 배열의 값
		for (int i = 0; i < names.length; i++) {
			System.out.printf("%s\t", names[i]);// 배열의값은 사라지지않았
		}

	}

	public static void main(String[] args) {
		UseList ul = new UseList();
		System.out.println("---------------------ArrayList-----------------------------");
		ul.useArrayaList();
		System.out.println("------------------------Vector--------------------------");
		ul.useVector();
		System.out.println("---------------------------LinkedList-----------------------");
		ul.useLinkedList();
	}// main

}// class

