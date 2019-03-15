package day0313;

/**
 * scope 속성에 따라 생성되는 객체
 * @author SIST
 *	
 */
public class CounterVO {
	
	private int cnt;

	public CounterVO() {
	System.out.println("ConterVO");
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt += cnt;//누적합
	}
	
	
	
	

}
