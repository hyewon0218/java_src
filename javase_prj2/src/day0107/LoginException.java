package day0107;

/**
 * ����� ���� ����ó�� Ŭ����<br>
 * Exception(RuntionException) ��ӹ޴´�.
 * @author SIST
 */
@SuppressWarnings("serial")
public class LoginException extends Exception {
	public LoginException () {
		this("�α��� ����"); 
	}
	
	public LoginException (String msg) {
		super(msg);//����ó�� ��ü�� ����Ͽ� ���ܸ޼����� ����� �� �ִ�. (�θ�Ŭ������ �޼�������)
	}

}
