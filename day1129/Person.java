package day1129;

/**
 * 사람을 추상화하여 만드는 클래스<br>
 * 명사적 특징: 눈, 코, 입, 이름
 * 동사적 특징: 먹는다.
 * 
 * 객체화)Person 객체명=new Person();<br>
 * 	생성된 객체로 먹는 일을 할 수 있다.
 * 
 * @author SIST
 */
public class Person {
	private String name;
	private int eye,nose,mouth;
	
	/**
	 * 사람클래스의 기본 생성자<br>
	 * 눈 2개, 코1개, 입 1개를 가진 사람 객체를 생성
	 */
	public Person() {
		this(2,1,1);
//		eye=2;
//		nose=1;
//		mouth=1;
	}//Person
	
	/**
	 * 눈 2개,코 1개,입 1개가 아닌 사람 객체를 생성할 때 사용하는 생성자
	 * @param eye 눈의 수
	 * @param nose 코의 수
	 * @param mouth 입의 수
	 */
	public Person(int eye, int nose, int mouth) {
		this.eye=eye;
		this.nose=nose;
		this.mouth=mouth;
	}//Person
	/**
	 * 생성된 사람 객체에 이름을 설정하는 일
	 * @param name 설정한 이름 
	 */
	public void setName(String name) {
		this.name=name;
	}//parameter인지 instance인지 구분
	
	/**
	 * 생성된 사람 객체의 눈을 설정하는 일<br>
	 * 눈의 갯수는 최대 3개까지 설정할 수 있다.
	 * 3개가 넘어가면 2개로 설정된다.
	 * @param eye 눈의 갯수
	 */
	public void setEye(int eye) {
		if(eye > 3) {
			eye=2;
		}//end if
		this.eye=eye;
	}//setEye
	
	/**
	 * 생성된 사람 객체의 코를 설정하느 일
	 * @param nose 코의 갯수
	 */
	public void setNose(int nose) {
	
		this.nose=nose;
	}
	
	/**
	 * 생성된 사람 객체에 입의 갯수를 설정하는 일
	 * @param mouth 설정한 입의 갯수
	 */
	public void setMouth(int mouth) {
		this.mouth=mouth;
	}//instance method
	
	/**
	 * 생성된 사람 객체에 이름을 반환
	 * @return 이름
	 */
	public String getName() {
		return name;
		
	}
	/**가지고 있는 눈의 갯수 반환
	 * @return 눈의 갯수
	 */
	public int getEye() {
		return eye;
	}
	public int getNose() {
		return nose;
	}
	public int getMouth() {
		return mouth;
	}
	/**
	 * 동사적인 특징 <br>
	 * 생성된 사람 객체가 집에서 밥을 먹는 일을 구현
	 * @return 결과
	 */
	public String eat( ) {
		return name +"이(가) 집에서 밥을 먹는다.";
	}
	/**
	 * method overload(overloading) : 
	 * 다형성 - 같은 이름의 method를 여러개 정의하는 방법
	 * 생성된 사람 객체가 식당에 주문한 음식을 먹는 일을 구현
	 * @param menu 음식의 종료
	 * @param price 음식 가격
	 * @return 결과
	 */
	public String eat(String menu,int price) {
		return name+"이(가) 식당에서 " + menu+"인 음식을"+price+"원 내고 사먹는다.";
	}
}//class
