package day1123;

/**
 * ��ī���� ������� �����Ͽ�, �߻�ȭ�� �����ϰ� ������� Ŭ����<br>
 * ��ī��- ����� Ư¡ : ��, ��ü, �Ѳ�		=&gt; ����<br>
 * 			  ������ Ư¡ :  ����. -&gt; method <br>
 * ����)<br>
 * 			�⺻ �����ڸ� ����Ͽ� ��ü�� ������ �� setter method�� 
 * 			ȣ���Ͽ� ���� ������ �� ����Ѵ�.<br>
 * 			Marker m=new=Marker();<br>
 * 			m.setxxx(��);<br>
 * 
 * class�� ��������� �ڷ���, ������ ���������̴�.<br>
 * 
 * @author SIST
 */
public class Marker {
	private String color;// ��ī���� ��
	private int body;// ��ī���� ��ü�� ����
	private int cap;// ��ī���� �Ѳ��� ����
	
	/**
	 * �⺻�����ڷ� ��ī�� ��ü�� �����Ǹ� ������, �Ѳ�1��, ��ü1���� 
	 * ��ī�� ��ü�� �����մϴ�.<br>
	 * 11-26-2018 �ڵ� �߰� 
	 */
	public Marker() {
		this("������",1,1);//�⺻�����ڿ��� �����ִ� ������ ȣ���Ͽ� �� ����(�ߺ��ڵ��پ��)
		System.out.println("Marker �⺻������");
//		color="������";
//		body=1;
//		cap=1;
	}//Marker
	
	/**
	 * �����մ� ������ - ������, �Ѳ��� ��ü�� �ϳ��� �ƴ� 1���� �ƴ� ��ī���� 
	 * ������ �� ����ϴ� ������<br>
	 * ��, �Ѳ��� ��, ��ü�� ���� �Է¹޾� ��ī���� 
	 * �����ϴ� ������(������ ��������overloading)
	 * @param color ��ī���� ��
	 * @param body ��ī���� ��ü
	 * @param cap ��ī���� �Ѳ�
	 */
	public Marker(String color, int body, int cap) {
		this.color=color;
		this.body=body;
		this.cap=cap;
		System.out.println("Marker �Ű����� �ִ� ������");
	}
	
	/**
	 * ������ ��ī�水ü�� ���� �����ϴ� ��<br>
	 * ������, �Ķ���, �������� �����Ѵ�. �� �̿��� ���� ���������� ó���Ѵ�.
	 * @param color ������ ��
	 */
	public void setColor(String color) {
		//�ν��Ͻ� ������ ������ ���� ���� ���� ����.
		if(!(color.equals("������")||color.equals("�Ķ���")||color.equals("������"))){
			color="������";
		}//end if
		this.color=color;
	}//set color
	/**
	 * ������ ��ī�� ��ü�� ��ü�� ������ ����
	 * @param body ��ü�� ���� 
	 */
	public void setBody(int body) {
		this.body=body;
	}//setBody
	
	/** ������ ��ī���� ��ü�� �Ѳ� ������ �����ϴ� ��.
	 * @param cap �Ѳ��� ��
	 */
	public void setCap(int cap) {
		this.cap=cap;
	}//setCap
	
	/**
	 * ������ ��ī�� ��ü�� ������ �ִ� ���� ��ȯ�ϴ� ��
	 * @return ��
	 */
	public String getColor() {
		return color;
	}//getColor
	
	/**
	 * ������ ��ī�� ��ü�� ������ �ִ� ��ü�� ���� ��ȯ
	 * @return ��ü�� ����
	 */
	public int getBody() {
		return body;

	} //getBody
	/**������ ��ī�� ��ü�� ������ �ִ� ��ü�� �Ѳ��� ���� ��ȯ
	 * @return  �Ѳ��� ����
	 */
	public int getCap() {
		return cap;
	}
	
	/**
	 * �Էµ� �޼����� ������ ��ī������ ĥ�ǿ� ���� ��
	 * @param msg ĥ�ǿ� �� �޼���
	 * @return ���
	 */
	public String write(String msg) {
		return color+"�� ��ī������ ĥ�ǿ� \""+msg+"\"�� ����";
	}
		
	
}//class












