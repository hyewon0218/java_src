package day1129;

import day1129.sub.Person;

/**
 * ����� ���� Ư¡�� �θ�(Person)�κ��� ����ϰ� �ڽŸ��� 
 *  Ư¡�� (�ο��� ���Ѵ�)���� (�ڽ�Ŭ������ ũ���۾���)
 * @author SIST
 */
public class HongGilDong extends Person{

	private int level;//ȫ�浿�� �ο� ����
	
	/**
	 * ȫ�浿�� �ο��� ��κ��� ���ϹǷ� 7�� ����
	 */
	public HongGilDong() {//������ : ��ü�������ɶ� ��ü���ʱⰪ���־���
		super();
		level=7;
	}

	/**
	 * �ο��ϴ� �� : �Էµ� �������� ���ٸ� �й�, 
	 * �Էµ� �������� ���ٸ� �¸�, �Էµ� ������ ���ٸ� ���.<br>
	 * �¸��ϸ� ������ 1����, �й��ϸ� ������ 1����, ���� ������ȭ ����
	 * ������ �ִ� 10, �ּ� 0�� ������.
	 * @param inputLevel �ο� ������� ���� 
	 * @return �ο��� ��� 
	 */
	public String fight(int inputLevel) {
		String result="";
		
		if(level > inputLevel) {//�¸�
			result="�̰��. s('. ^)v";
			level++;
			if(level > 10) {
				level=10;
			}//end if
		}else if (level < inputLevel) {//�й�
			result="����. ~(_-_)~";
			level--;
			if(level < 1) {
				level=1;
			}
		}else {//���
			result="��� �Ѥ�+;;";
		}//end else
		
		return result;
	}
	public String toString() {
		return "ȫ�浿 ��ü�� �� �� : "+getEye()+", �� :"+getNose()+", �� "+getMouth();
	}//toString
	
	
	/** 
	 * �θ�Ŭ������ �����ϴ� method�� ����� �ڽĿ��� ���� �ʾ�<br>
	 * ����� �Ĵ��� �ָ����� ����<br>
	 * ȭ�� ������ ���� ������ ����<br>
	 */
	@Override
	public String eat(String menu, int price) {
		return getName()+"�� �ָ����� "+menu+"�� ������"+price+"�� ���� ��Դ´�.";
	}
}//class
