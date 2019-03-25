package kr.co.sist.diary.vo;

public class ListRangeVO {

	int startNum, endNum;

	public ListRangeVO() {
		super();
	}
	public ListRangeVO(int startNum, int endNum) {
		super();
		this.startNum = startNum;
		this.endNum = endNum;
	}


	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
	
	
}//class
