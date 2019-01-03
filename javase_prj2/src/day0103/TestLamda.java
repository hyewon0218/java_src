package day0103;
//@FunctionalInterface : JDK1.8에서부터 제공. 인터페이스의 추상 method가 하나인지 체크.
@FunctionalInterface //Lamda식으로 편하게 사용할 수 있다.
public interface TestLamda {
	public abstract String toDay();
}//interface
