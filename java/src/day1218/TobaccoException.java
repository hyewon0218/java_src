package day1218;

/**
 * ��������ǿ���ó�� Ŭ����
 * @author SIST
 *
 */
//1. Exception�̳� RuntimeException�� ��ӹ޴´�.
@SuppressWarnings("serial")
public class TobaccoException extends Exception{//RuntimeException try~catch���ص���
	
	public TobaccoException() {
		this("��迹��-����� ���� ��! �׷��� �ǿ�ðڽ��ϱ�?");
	}
	public TobaccoException(String msg) {
		super(msg);
	}
}//class
