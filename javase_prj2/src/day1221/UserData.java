package day1221;

import java.io.Serializable;

/**
 * 데이터를 가지고 있는 클래스로 직렬화 대상 클래스 
 * @author SIST
 */
public class UserData implements Serializable{

	private static final long serialVersionUID = 1433112021624942957L;
	//나갔다 들어올 때 코드의변형이되어들어올수도있기때문에 내가 내보낸 코드를 검증하기 위해 사용(hash코드)
	private int age;
	private /*transient*/ double weight;
	private /*transient */String name;
	
	
	//transient : 직렬화 방지 키워드 (값이 JVM외부로 전달이 되지 않는다.)
	public UserData() {
		super();
	}

	public UserData(int age, double weight, String name) {
		super();
		this.age = age;
		this.weight = weight;
		this.name = name;
	}
	


	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public double getWeight() {
		return weight;
	}



	public void setWeight(double weight) {
		this.weight = weight;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}





	@Override
	public String toString() {
		return "UserData [age=" + age + ", weight=" + weight + ", name=" + name + "]";
	}//객체찍으면 주소가 아니라 값이나오게
	
	
}
