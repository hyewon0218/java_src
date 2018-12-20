package day1203;

/**
 * 나는 것들의 일<br>
 * 나는 것은 속도, 높이 
 * @author SIST
 */
public interface Fly {
	/**
	 * 나는 속도
	 * @param speed
	 * @return
	 */
	public abstract String speed(String speed);
	/**
	 * 비행 높이
	 * @param height
	 * @return
	 */
	public  String height (String height);//interface의 추상method는 public만
}//interface
