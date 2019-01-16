package kr.co.sist.lunch.admin.vo;

public class LunchUpdateVO {
	
	private String lunch_code,name,img,spec;
	private int price;
	
	public LunchUpdateVO(String lunch_code, String name, String img, String spec, int price) {
		super();
		this.lunch_code = lunch_code;
		this.name = name;
		this.img = img;
		this.spec = spec;
		this.price = price;
	}
	
	public String getLunch_code() {
		return lunch_code;
	}
	public String getName() {
		return name;
	}
	public String getImg() {
		return img;
	}
	public String getSpec() {
		return spec;
	}
	public int getPrice() {
		return price;
	}
	
	
}
