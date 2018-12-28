package day1129;

public class Work22 {
	
	private String name;
	private String add; 
	private int age;
	private String gen;
	
	public Work22 () {
		
	}	
	public Work22(String name, String add, int age, String gen) {
		this.name=name;
		this.add=add;
		this.age=age;
		this.gen=gen;
		
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setAdd(String add) {
		this.add=add;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public void setGen(String gen) {
		this.gen=gen;
	}	
	
	public String getName() {
		return name;
	}	
	public String getAdd() {
		return add;
	}
	public int getAge() {
		return age;
	}
	public String getGen () {
		return gen;
	}	
//	public Stirng toString() {
//		return ""
//	}
	
	
	public static void main(String[] args) {
	new Work22();	
	}

}
