package kr.co.sist.domain;

public class MemberDetail {
	private String name, loc, highschool;

	public MemberDetail() {
		super();
	}

	public MemberDetail(String name, String loc, String highschool) {
		super();
		this.name = name;
		this.loc = loc;
		this.highschool = highschool;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "MemberDetail [name=" + name + ", loc=" + loc + ", highschool=" + highschool + "]";
	}
	
	
}
