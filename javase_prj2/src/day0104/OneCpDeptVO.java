package day0104;

public class OneCpDeptVO {//저장되는값이다르면 무조건 VO를 새로만든다.(실수방지)
	private String dname, loc;

	public OneCpDeptVO() {
		super();
	}

	public OneCpDeptVO(String dname, String loc) {
		super();
		this.dname = dname;
		this.loc = loc;
	}

	public String getDname() {
		return dname;
	}

	public String getLoc() {
		return loc;
	}
	
	
}
