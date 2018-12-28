package day1129;

/**
 * HonGilDong 은 클래스의 접근 지정자에 final이 없으므로 자식 클래스가 
 * 존재할 수 있지만, Clark은 클래스의 접근지정자에 final이 존재하므로
 * 자식클래스가 존재할 수 없다.
 * HongGilDong은 자신의 기능에 추가하여 다른 기능을 구현할 수있지만
 * Clock은 자신의 기능만으로 사용하게 된다.
 * @author SIST
 */
public class Test extends HongGilDong {
//public class Test extends Clark {

}
