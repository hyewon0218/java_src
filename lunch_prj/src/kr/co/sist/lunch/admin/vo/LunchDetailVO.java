package kr.co.sist.lunch.admin.vo;

public class LunchDetailVO {

	private String lunch_code,name,img,spec,input_date ;
	private int price;
	
	public LunchDetailVO(String lunch_code, String name, String img, String spec, String input_date, int price) {
		super();
		this.lunch_code = lunch_code;
		this.name = name;
		this.img = img;
		this.spec = spec;
		this.input_date = input_date;
		this.price = price;
	}

	public String getLunch_code() {
		return lunch_code;
	}

	public String getName() {//lunch_name으로
		return name;
	}

	public String getImg() {
		return img;
	}

	public String getSpec() {
		return spec;
	}

	public String getInput_date() {
		return input_date;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {//주소가아닌값
		return "LunchDetailVO [lunch_code=" + lunch_code + ", name=" + name + ", img=" + img + ", spec=" + spec
				+ ", input_date=" + input_date + ", price=" + price + "]";
	}
	
	
}
