package day1218;

public class Data /*implements Cloneable*/ {//중요(history를 남겨야하는 상황에 객체복제)
	private String school;

	public Data() {
		super();
	}

	public Data(String school) {
		super();
		this.school = school;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	public Data getData() throws CloneNotSupportedException {
		Data data=(Data)this.clone();
		//clone()은 protected접근지정자를 가지고있어 외부 클래스에서 
		// 다른 클래스의 clone() 을 호출할 수 없다.
		return data;
	}
	
}
