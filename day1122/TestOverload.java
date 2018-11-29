package day1122;

/**
 *	다형성 : method Overload <br>
 *  하나의 클래스에서 같은 이름의 method를 여러개 작성하는 것<br>
 *  규칙) 접근지정자 반환형 method명은 같게 만들고,
 *  		매개변수만 다르게 작성.
 * @author SIST
 */
public class TestOverload {

	/**
	 * ★을 하나 출력하는 일
	 */
	public void printStar() {
		System.out.println("★");
	}//printStart
	/**입력되는 값에 따라 ★을 여러개 출력하는 일 
	 * @param count 출력할 별의 갯수
	 */
	public void printStar(int count) {
		for(int i=0; i < count ; i++) {
			System.out.print("☆");
			
		}//end for
	}//printStart
	
	public void gugudan() {
		System.out.println("3단");
		for(int i=2 ;i<10 ;i++ ) {
			System.out.println("3*"+i+"="+3*i);
		}
	}
	
	
	public void gugudan(int count) {
		for(int i=2, i <10 ;i++) {
			for(int j=1, j<10;j++) {
			System.out.println(i+"*"+j+"="+i*j);	
			}
		}
		
	}
	
	public static void main(String[] args) {
		TestOverload to=new TestOverload();
		//별을 1개 출력
		to.printStar();
		//별을 여러개 출력
		to.printStar(5);
		
		//구구단 3단을 출력하는 method
		to.gugudan();
		//입력하는 단이 2~9단 사이일 때 해당 단부터 9단까지를 출력하는 method
		to.gugudan(4);
	}//main	

}//class
