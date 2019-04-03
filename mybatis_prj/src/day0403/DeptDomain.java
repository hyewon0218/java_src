package day0403;

/**
 * 조회하는 컬럼의 값을 저장하는 VO를 domain
 * @author SIST
 */
public class DeptDomain {
	private int deptno;
	private String dname,loc;
	
/*	public DeptDomain() {
		System.out.println("DeptDomain 기본 생성자");
	}
	
	public DeptDomain(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
		System.out.println("DeptDomain 인자있는 생성자");
	}*/
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	
}
