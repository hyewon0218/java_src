package day0110;

public class TransactionVO {
	private String subject, writer;

	public TransactionVO() {
		super();
	}

	public TransactionVO(String subject, String writer) {
		super();
		this.subject = subject;
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}

	public String getWriter() {
		return writer;
	}
	
	
}
