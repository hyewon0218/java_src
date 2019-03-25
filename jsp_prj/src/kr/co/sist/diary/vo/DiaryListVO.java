package kr.co.sist.diary.vo;

public class DiaryListVO {

	private int num;
	private String subject, writer, e_year, e_month, e_day, w_date;
	public DiaryListVO() {
		super();
	}
	public DiaryListVO(int num, String subject, String writer, String e_year, String e_month, String e_day,
			String w_date) {
		super();
		this.num = num;
		this.subject = subject;
		this.writer = writer;
		this.e_year = e_year;
		this.e_month = e_month;
		this.e_day = e_day;
		this.w_date = w_date;
	}
	public int getNum() {
		return num;
	}
	public String getSubject() {
		return subject;
	}
	public String getWriter() {
		return writer;
	}
	public String getE_year() {
		return e_year;
	}
	public String getE_month() {
		return e_month;
	}
	public String getE_day() {
		return e_day;
	}
	public String getW_date() {
		return w_date;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setE_year(String e_year) {
		this.e_year = e_year;
	}
	public void setE_month(String e_month) {
		this.e_month = e_month;
	}
	public void setE_day(String e_day) {
		this.e_day = e_day;
	}
	public void setW_date(String w_date) {
		this.w_date = w_date;
	}

	
	
}
