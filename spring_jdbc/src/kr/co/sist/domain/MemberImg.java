package kr.co.sist.domain;

public class MemberImg {
	private int cnt;
	private String img;
	
	public MemberImg() {
		super();
	}
	public MemberImg(int cnt, String img) {
		super();
		this.cnt = cnt;
		this.img = img;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
}
