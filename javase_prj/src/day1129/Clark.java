package day1129;

import day1129.Person;

/**
 * ����� ���� Ư¡�� Person���� �����ٰ� ����ϰ� �ڽŸ��� Ư¡�� 
 * ������ Ŭ����<br>
 * @author SIST
 */
public final class Clark extends Person{
	public int power;
	
	/**
	 * �⺻ ������ : ��ü�� �����Ǹ� power�� 9�� �����ȴ�.
	 */
	public Clark() {
		super(3,1,1);	
		power=9; 
	}//Clark
	
	/**
	 * �ԷµǴ� ���� ������ ���� ���� ��ȭ�� �ް��ϰ� ��ȭ�Ѵ�.
	 * @param stone ���� ���� 
	 * @return ���� ��ȭ
	 */
	public String power(String stone) {
		String result="";//�ʱⰪ
		
		if (stone.equals("Ŭ���䳪��Ʈ")) {//���ڿϺ��ϰ԰����� equals
			power=0;
			result="���� ���� ~(_-_)~";
			
		}else if(stone.equals("���̾Ƹ��")) {
			power=10;
			result="�����մϴ� ~m(^o^)m~";
		}else {
			power=12;
			result="������. �Ѥ�";
		}//end else
		
		return result;
	}
	@Override
	public String eat() {
		return getName()+"�� ������ ���� �Դ´�.";
	}
	
	@Override
	public String eat(String menu, int price) {
		return getName()+"�� ����������� "+menu+"�� ������"+price+"$ ���� ��Դ´�.";
	}

}//class