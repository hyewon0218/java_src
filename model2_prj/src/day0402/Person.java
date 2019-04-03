package day0402;

public interface Person {
	public String execute();
	public default void test() {
		System.out.println("ddd");
	}
}
