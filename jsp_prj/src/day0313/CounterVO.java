package day0313;

/**
 * scope �Ӽ��� ���� �����Ǵ� ��ü
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
		this.cnt += cnt;//������
	}
	
	
	
	

}
