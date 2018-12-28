package day1123;

public class Work21 {
	private String company;
	private String color;
	private String maker;
	
	public Work21() {
		this("DD라면",0);
	
	public Work21(String color, String maker) {
		this.color = color;
		this. maker= maker;
	}
	
	public void setCompany(String company) {
		this.company=company;
	}
	
	public void setColor(String color) {
		this.color=color;
	}
	public void setMaker(String maker) {
		this.maker=maker;
	}
	public String getCompany() {
		
		return company;
	}
	public String getColor() {
		return color;
	}
	public String getMaker() {
		return maker;
	}
	public String eat( ) {
		return "회사가"+company+"인 라면을 먹는다.";
	}
public static void main(String[] args) {
	
	Work21 w = new Work21();
	Work21 w1= new Work21();
	
	System.out.println(w);
	System.out.println(w1);
}
	

}
