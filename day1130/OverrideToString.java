package day1130;

/**
 * Override(Overriding) ������
 * �θ�Ŭ������ �����ϴ� ����� �ڽ�Ŭ������ ���� �ʴ´ٸ� 
 * �ڽ� Ŭ�������� �θ�Ŭ������ method�� ������ method�� �����Ͽ� ����ϴ� ��
 * @author SIST
 */
public class OverrideToString {

	@Override
	public String toString() {
//		toString();//���� �ּҿ� ���� ������ �޼����� ���� 
		return "OverrideToString Ŭ����"+super.toString()
		;
	}


}//class
