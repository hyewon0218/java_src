package day1123;

/**
 * Marker���� ������ Ŭ������ ����ϴ� Ŭ����<br>
 * 4. ��ü����<br>
 * 5. ������ ��ü ���
 * @author SIST
 */
public class UseMarker {

	public static void main(String[] args) {
		//������ ��ī�� 1�� ����
		Marker black=new Marker();
//		black.setColor("������");
//		black.setCap(1);
//		black.setBody(1);
		
		System.out.printf("������ ��ī�� �� [%s], �Ѳ�[%d], ��ü[%d]\n",
				black.getColor(), black.getCap(), black.getBody());
		//������ ��ü�� ���
		System.out.println(black.write("�ȳ��ϼ���?"));

		Marker red = new Marker("������",5,5);//setter�� �θ��� �ʾƵ��� �ڵ尣��
//		red.color="���";//���������ڰ� public �̶�� �ܺο��� ���� ����
		// ������ �� �����Ƿ� �߸��� ���� �Էµ� �� �ִ�.
//		red.setColor("���");
//		red.setCap(5);
//		red.setBody(5);
		
		System.out.printf("������ ��ī�� �� [%s], �Ѳ�[%d], ��ü[%d]\n",
				red.getColor(), red.getCap(), red.getBody());
		//������ ��ü�� ���
		System.out.println(red.write("������"));
	}//main

}//class

