package kr.co.sist.vo;

public class MemberVO {
	private String name,img, loc, highschool;

	
	
	public MemberVO() {
		super();
	}

	public MemberVO(String name, String img, String loc, String highschool) {
		super();
		this.name = name;
		this.img = img;
		this.loc = loc;
		this.highschool = highschool;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getHighschool() {
		return highschool;
	}

	public void setHighschool(String highschool) {
		this.highschool = highschool;
	}
	
	
}
