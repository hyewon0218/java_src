package day1203;

/**
 * 사람을 추상화하여 만드는 클래스<br>
 * 명사적 특징: 눈, 코, 입, 이름
 * 동사적 특징: 먹는다.
 * 
 * 객체화)Person 객체명=new Person();<br>
 * 	생성된 객체로 먹는 일을 할 수 있다.
 * 
 * Person을 일반 클래스에서 abstract클래스로 변경<br>
 * 모든 사람의 집에서 먹는 일과 밖에서 사먹는 일, 언어를 반드시 가진다.
 * @author SIST
 */

public abstract class Person {
	private String name;
	private int eye,nose,mouth;
	private String[] language;//사용하는 언어
	
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
	 * 언어를 추가할 수 있도록 
	 * @param eye 눈의 수
	 * @param nose 코의 수
	 * @param mouth 입의 수
	 */
	public Person(int eye, int nose, int mouth) {
		this.eye=eye;
		this.nose=nose;
		this.mouth=mouth;
		language=new String[10];
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
	public String[] getLanguage() {
		return language;
	}
	/**
	 * 동사적인 특징 <br>
	 * 생성된 사람 객체가 집에서 밥을 먹는 일을 구현
	 * @return 결과
	 */
	public abstract String eat();
	/**
	 * method overload(overloading) : 
	 * 다형성 - 같은 이름의 method를 여러개 정의하는 방법
	 * 생성된 사람 객체가 식당에 주문한 음식을 먹는 일을 구현
	 * @param menu 음식의 종료
	 * @param price 음식 가격
	 * @return 결과
	 */
	public abstract String eat(String menu,int price);
	
	/**
	 * 사람은 언어를 여러개 할 수 있다.
	 * @return 할 수 있는 언어
	 */
	public String[] language(String lang) {
		String[] tempLang = getLanguage();
		
		int idx = 0;
		for (int i = 0; i < tempLang.length; i++) {
			if (tempLang[i] != null) {
				// 습득한 언어가 존재한다면 다음 인덱스를 얻는다.
				if (lang.equals(tempLang[i])) {
					// 입력된 언어가 이미 습득한 언어라면 반복문을 빠져나가
					// 해당 방에 덮어쓸 수 있는 인덱스를 가진다.
					break;
				} // end if
				idx++;
			} // end if
		}//end if
		//없으면 추가되고 있따면 덮어쓴다. : upsert
		tempLang[idx] = lang;

		return tempLang;
	}//language
}//class
