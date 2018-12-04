package day1204;

/**
 * method안에 클래스를 정의하는 지역class의 사용.<br>
 * 생성된 객체를 지역변수처럼 사용하는 클래스
 * @author SIST
 */
public class LocalOuter {
	int i;
	
	public LocalOuter() {
		System.out.println("바깥클래스의 생성자");
	}
	public void method(int param_i,final int param_j) { //param은 지역변수와 마찬가지
		int local_i=0;
		final int local_j=0;
		
		//method안에서 class
		///////////////////////////////////지역클래스 시작//////////////////////////////////////////
		class Local {
			int loc_i;
			
			public Local() {
				System.out.println("지역클래스의 생성자");
			}
			public void locMethod( ) {
				System.out.println("지역클래스의 method loc_i="+loc_i);
				System.out.println("외부 클래스의 인스턴스 변수 i="+i);
				//JDK1.8이전에서는 final이 붙은 매개변수만 사용할 수 있다.
				System.out.println("매개변수(Parameter) param_i="+param_i+", param_j="+param_j);
				//JDK1.8이전에서는 final이 붙은 지역변수만 사용할 수 있다.
				System.out.println("지역변수 local_i="+local_i+",local_j="+local_j);
				//local_i=2018; //JDK 1.8에서부터는 final붙어있지 않은 지역변수의 출력은 가능하지만
				// 값할당은 되지 않는다.
			}
			
		}
		///////////////////////////////////지역클래스 끝////////////////////////////////////////////
		//지역클래스의 객체화
		Local lo=new Local();
		//생성된 객체로 클래스의 내의 자원을 사용할 수 있다.
//		ioc_i=100; //직접사용불가
		lo.loc_i=100;
		lo.locMethod();
		
		System.out.println("바깥 클래스의 method 호출");
	}
	
	public static void main(String[] args) {
		LocalOuter lo=new LocalOuter();
		lo.method(12, 4);
	}//main

}//class
