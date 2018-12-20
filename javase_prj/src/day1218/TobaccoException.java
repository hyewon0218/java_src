package day1218;

/**
 * 사용자정의예외처리 클래스
 * @author SIST
 *
 */
//1. Exception이나 RuntimeException을 상속받는다.
@SuppressWarnings("serial")
public class TobaccoException extends Exception{//RuntimeException try~catch안해도됨
	
	public TobaccoException() {
		this("담배예외-폐암의 원인 흡연! 그래도 피우시겠습니까?");
	}
	public TobaccoException(String msg) {
		super(msg);
	}
}//class
