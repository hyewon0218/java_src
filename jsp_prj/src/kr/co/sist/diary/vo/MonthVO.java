package kr.co.sist.diary.vo;

public class MonthVO {
	private int num;
	private String subject;

	public MonthVO() {
		super();
	}
	public MonthVO(int num, String subject) {
		super();
		this.num = num;
		this.subject = subject;
	}
	public int getNum() {
		return num;
	}
	public String getSubject() {
		return subject;
	}
	@Override
	public String toString() {
		return "MonthVO [num=" + num + ", subject=" + subject + "]";
	}
	
	

}
