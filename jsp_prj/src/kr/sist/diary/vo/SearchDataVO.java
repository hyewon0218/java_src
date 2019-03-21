package kr.sist.diary.vo;

public class SearchDataVO {

	private String fieldName, keyword;

	public SearchDataVO() {
		super();
	}

	public SearchDataVO(String fieldName, String keyword) {
		super();
		this.fieldName = fieldName;
		this.keyword = keyword;
	}

	public String getFieldName() {
		return fieldName;
	}

	public String getKeyword() {
		return keyword;
	}
	
	
}
