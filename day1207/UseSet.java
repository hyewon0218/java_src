package day1207;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import javax.jws.soap.SOAPBinding.Use;

/**
 * Set : 검색의 기능이 없으며(get x) 중복값을 저장하지 않는 기능. 
 * @author SIST
 */
public class UseSet {
	
	public UseSet() {
		//JDL1.5 이하에서는 Generic이 지원되지 않고 객체만 저장
		//1. 생성)
		Set<String> set =new HashSet<String>();
		//2. 값 할당)
	 	set.add("정택성");//제네릭에해당되는값만입력받도록
	 	set.add("이재현");
	 	set.add("공선의");
	 	set.add("김정운");
	 	set.add("노진경");
	 	set.add("최지우");
	 	set.add("이봉현");
	 	set.add("김정운");
	 	set.add("김정운");
	 	set.add("김정운");
	 	set.add("김정운");//중복값을 저장하지 않는다.
		System.out.println(set.size()+"/"+set);//Object에 있는 toString을 override해서 주소가 나오지 않고 값이 나온다. 
		set.remove("김정운");//가변길이형
		System.out.println(set.size()+"/"+set);
		
		//배열로 복사
		String[] names=new String[set.size()];
		set.toArray(names);
		
		//set의 모든 방(Element)의 값 얻기 
//		System.out.println(set.get("김정운"));//set 자체에는 검색의 기능이 없다.
		//Iterator를 사용하여 값을 얻기 
		Iterator<String> ita=set.iterator();//set의 제어권이 String으로
		
		String name="";//""empty
		while(ita.hasNext()) {//Iterator가 참조하는 Set의 요소가 존재한다면
			name=ita.next();//해당요소의 값을 얻고 다음 포인터로 이동
			System.out.println(name);
		}
		
		System.out.println("----------------------향상된 for---------------------------------------------");
		for(String temp : set) {
			System.out.println(temp);
		}
		
		//모든 방의 값 삭제
		set.clear();
		System.out.println("clear후 "+set.size()+","+set);
		System.out.println("-----------------------------------배열에 복사한 값-----------------------------");
		for(int i=0; i< names.length; i++) {
			System.out.println(names[i]);
		}
		
		
	}
		public int[] lotto() {//int 반환해야
			int[] tempLotto=new int[6];
			
			Random random=new Random();
			for(int i=0 ; i < tempLotto.length; i++) {
				tempLotto[i]=random.nextInt(45)+1;//같은 수가 발생할 수 있다.
				for(int j=0; j<i; j++) {//앞방과 비교 처음방은 거짓이라 돌지 않는다.
					if (tempLotto[i]==tempLotto[j]) {//방의 값이 같다.
						i--;//중복발생된 번호의 인덱스번째를 다시 발생시키기 위해 인덱스번호를 하나 줄인다.
						break;//반복문을 빠져나간다.
					}
				}
			}
			return tempLotto;
	}//lotto
		
		public Integer[] lotto1() {//int 반환해야
			Integer[] tempLotto=new Integer[6];
			
			Set<Integer> set =new HashSet<Integer>();//중복값저장x
			Random random=new Random();
			while(true ) {//무한루프
				set.add(random.nextInt(45)+1);//같은 수가 추가되지 않는다.
				if(set.size()==6) {
					break;
				}
			}
			set.toArray(tempLotto);
			return tempLotto;
		}

	public static void main(String[] args) {
		UseSet us=new UseSet();
		Integer [] temp=us.lotto1();
		
		for(int i=0; i< temp.length; i++) {
			System.out.print(temp[i]+" ");
			
		}
		System.out.println("---------------------------\n");
		Integer [] temp1=us.lotto1();
		
		for(int i=0; i< temp1.length; i++) {
			System.out.print(temp1[i]+" ");
			
		}
	}//main

}//class
