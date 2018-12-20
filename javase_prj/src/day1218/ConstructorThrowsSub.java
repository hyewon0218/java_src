package day1218;

public class ConstructorThrowsSub extends ConstructorThrows{
	//부모클래스의 생성자가 컴파일 예외를 날리면 자식클래스의 생성자에서도
	//예외를 날려야 한다.
	public ConstructorThrowsSub() throws ClassNotFoundException {
//		super();//super는 생성자의 첫번째 줄에서만 기술할 수 있으므로 
		//부모클래스의 생성자가 Compile Exception을 throws로 나릴면 
		//생성자를 호출하는 자식 클래스에서는 반드시 예외를 처리해야 하는 
		//문법상 Error가 발생하게 된다.
	}

	public static void main(String[] args) {

	}

}
