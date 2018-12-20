package day1130;

/**
 * Override(Overriding) 다형성
 * 부모클래스가 제공하는 기능이 자식클래스에 맞지 않는다면 
 * 자식 클래스에서 부모클래스의 method와 동일한 method를 정의하여 사용하는 것
 * @author SIST
 */
public class OverrideToString {

	@Override
	public String toString() {
//		toString();//나의 주소와 내가 제공한 메세지를 같이 
		return "OverrideToString 클래스"+super.toString()
		;
	}


}//class
