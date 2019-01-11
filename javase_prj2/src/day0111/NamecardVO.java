package day0111;

public class NamecardVO {
	private String name, addr, img;

	public NamecardVO() {
		super();
	}

	public NamecardVO(String name, String addr, String img) {
		super();
		this.name = name;
		this.addr = addr;
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public String getAddr() {
		return addr;
	}

	public String getImg() {
		return img;
	}

	@Override
	public String toString() {
		return "NamecardVO [name=" + name + ", addr=" + addr + ", age=" + img + "]";
	}
	
}
