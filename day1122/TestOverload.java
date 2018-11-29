package day1122;

/**
 *	������ : method Overload <br>
 *  �ϳ��� Ŭ�������� ���� �̸��� method�� ������ �ۼ��ϴ� ��<br>
 *  ��Ģ) ���������� ��ȯ�� method���� ���� �����,
 *  		�Ű������� �ٸ��� �ۼ�.
 * @author SIST
 */
public class TestOverload {

	/**
	 * ���� �ϳ� ����ϴ� ��
	 */
	public void printStar() {
		System.out.println("��");
	}//printStart
	/**�ԷµǴ� ���� ���� ���� ������ ����ϴ� �� 
	 * @param count ����� ���� ����
	 */
	public void printStar(int count) {
		for(int i=0; i < count ; i++) {
			System.out.print("��");
			
		}//end for
	}//printStart
	
	public void gugudan() {
		System.out.println("3��");
		for(int i=2 ;i<10 ;i++ ) {
			System.out.println("3*"+i+"="+3*i);
		}
	}
	
	
	public void gugudan(int count) {
		for(int i=2, i <10 ;i++) {
			for(int j=1, j<10;j++) {
			System.out.println(i+"*"+j+"="+i*j);	
			}
		}
		
	}
	
	public static void main(String[] args) {
		TestOverload to=new TestOverload();
		//���� 1�� ���
		to.printStar();
		//���� ������ ���
		to.printStar(5);
		
		//������ 3���� ����ϴ� method
		to.gugudan();
		//�Է��ϴ� ���� 2~9�� ������ �� �ش� �ܺ��� 9�ܱ����� ����ϴ� method
		to.gugudan(4);
	}//main	

}//class
