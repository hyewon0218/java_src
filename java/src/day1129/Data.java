package day1129;

/**
 * 이름, 나이, 이메일, 성의 이니셜 한자를 저장하는 클래스 
 * @author SIST
 */
public class Data {
	
	private String name;
	private int age;
	private String email;
	private char initial;
	
	public Data() {//기본생성자
		System.out.println("Data Default Construntor");
		
	}//Data
	
	public Data(String name, int age, String email, char initnial) {//인자있는 생성자
		System.out.println("Data Construntor");
		this.name=name;//heap의 주소
		this.age=age; //힙에있는이니셜변수에스텍에있는이니셜변수넣어줌
		this.email=email;
		this.initial=initnial;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public void setInitial(char initial) {
		this.initial=initial;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getEmail() {
		return email;
	}
	public char getInitial() {
		return initial;
	}
	public String toString() {
		return "이름" + name +",나이 "+age+", 이메일 :"+email+"이니셜 : "+initial;
	}
	
}//class
