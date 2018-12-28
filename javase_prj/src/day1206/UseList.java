package day1206;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * List : <br>
 * �ߺ����� ����ϸ�, �˻��� ����� �ְ� ������� ���� �Է��ϴ� ����������
 * 
 * @author SIST
 */
public class UseList {

	public UseList() {
		// JDK1.4������ Generic�� �������� �ʰ� ��ü�� ����ȴ�.
//		List list=new ArrayList();
//		//�� �߰� : JDK1.5 ���Ͽ����� ��ü�θ� ���� ���� �� �ִ�. 
//		list.add(new Integer(10));
//		list.add(new Short((short)10));
//		list.add("������");//��ü��� ������ ����
//		
//		System.out.println(list.size());
//		System.out.println(((Integer)list.get(0)).intValue()+10);

		// JDK1.5+���� ��� : Generic, auto boxing, unboxing
		// Generic�� ����
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);// autoboxing ==> list.add(new Integer(10)); compiler�� ����
		list.add(20);
		list.add(new Integer(30));
//		list.add("�����");//Generic���� ������ ���� �ƴ� ���������� �߰��� �� ����.

		System.out.println("ũ��" + list.size());
		System.out.println(list.get(2) + 10);// (Integer)ĳ�������ʿ����
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	/**
	 * ArrayList�� ��� : Multi Threadȯ�濡�� ���� ���� ����(����ȭx)
	 */
	public void useArrayaList() {
		// 1.����
		ArrayList<String> al = new ArrayList<>();// ���� 0��
		List<String> al1 = new ArrayList<String>(100);// ���� 100��

		System.out.println(al + "/" + al1);// �ּҰ��������ʴ������� �ڽľ�̰� ����Ʈ������ �������̵�
		// �� �߰� : ������� �߰��ȴ�.
		al.add("������");
		al.add("���ü�");
		al.add("������");
		al.add("�����");
		al.add("������");// �ߺ��� ���� ����
		al.add("������");
		al.add("������");// �ߺ��� ���� ����
		al.add("������");// �ߺ��� ���� ����
		al.add("������");
		System.out.println(al + "/" + al1);
		// size() : �������� ũ��
		System.out.println("al ũ��" + al.size() + "/ al1�� ũ�� : " + al1.size());// ���� '����ִ�' ũ��

		// �迭�� ����
		String[] names = new String[al.size()];// �������̶� ũ�������ؾ�
		al.toArray(names);

		// ���� �� ���� :
		// �ε����� ���� : Ư�� �ε������� ���� ����.
		al.remove(4);
		System.out.println(al.size() + "/" + al);
		// ���� �������� ���� : ���� ù���� �����ȴ�.
		al.remove("������");// L->R���� �����ϸ鼭 ��ġ�ϴ� ù���� ���� ����
		System.out.println(al.size() + "/" + al);

		for (String name : al) {
			System.out.println(name);
		}
		// ��� ���� �� ���� :
		al.clear();
		System.out.println("��ü ���� �� : " + al.size() + "/" + al);

		// �迭�� ��
		for (int i = 0; i < names.length; i++) {
			System.out.printf("%s\t", names[i]);// �迭�ǰ��� ��������ʾ�
		}

	}

	public void useVector() {
		// 1.����
		Vector<String> vec = new Vector<>();// ���� 0��
		List<String> vec1 = new Vector<String>(100);// ���� 100��

		System.out.println(vec + "/" + vec1);// �ּҰ��������ʴ������� �ڽľ�̰� ����Ʈ������ �������̵�
		// �� �߰� : ������� �߰��ȴ�.
		vec.add("������");
		vec.add("���ü�");
		vec.add("������");
		vec.add("�����");
		vec.add("������");// �ߺ��� ���� ����
		vec.add("������");
		vec.add("������");// �ߺ��� ���� ����
		vec.add("������");// �ߺ��� ���� ����
		vec.add("������");
		System.out.println(vec + "/" + vec1);
		// size() : �������� ũ��
		System.out.println("vec ũ��" + vec.size() + "/ vec1�� ũ�� : " + vec1.size());// ���� '����ִ�' ũ��

		// �迭�� ����
		String[] names = new String[vec.size()];// �������̶� ũ�������ؾ�
		vec.toArray(names);

		// ���� �� ���� :
		// �ε����� ���� : Ư�� �ε������� ���� ����.
		vec.remove(4);
		System.out.println(vec.size() + "/" + vec);
		// ���� �������� ���� : ���� ù���� �����ȴ�.
		vec.remove("������");// L->R���� �����ϸ鼭 ��ġ�ϴ� ù���� ���� ����
		System.out.println(vec.size() + "/" + vec);

		for (String name : vec) {
			System.out.println(name);
		}
		// ��� ���� �� ���� :
		vec.clear();
		System.out.println("��ü ���� �� : " + vec.size() + "/" + vec);

		// �迭�� ��
		for (int i = 0; i < names.length; i++) {
			System.out.printf("%s\t", names[i]);// �迭�ǰ��� ��������ʾ�
		}

	}

	public void useLinkedList() {
		// 1.����
		LinkedList<String> ll = new LinkedList<>();// ���� 0��
		List<String> ll1 = new LinkedList<String>();// ���� 100��

		System.out.println(ll + "/" + ll1);// �ּҰ��������ʴ������� �ڽľ�̰� ����Ʈ������ �������̵�
		// �� �߰� : ������� �߰��ȴ�.
		ll.add("������");
		ll.add("���ü�");
		ll.add("������");
		ll.add("�����");
		ll.add("������");// �ߺ��� ���� ����
		ll.add("������");
		ll.add("������");// �ߺ��� ���� ����
		ll.add("������");// �ߺ��� ���� ����
		ll.add("������");
		System.out.println(ll + "/" + ll1);
		// size() : �������� ũ��
		System.out.println("ll ũ��" + ll.size() + "/ ll1�� ũ�� : " + ll1.size());// ���� '����ִ�' ũ��

		// �迭�� ����
		String[] names = new String[ll.size()];// �������̶� ũ�������ؾ�
		ll.toArray(names);

		// ���� �� ���� :
		// �ε����� ���� : Ư�� �ε������� ���� ����.
		ll.remove(4);
		System.out.println(ll.size() + "/" + ll);
		// ���� �������� ���� : ���� ù���� �����ȴ�.
		ll.remove("������");// L->R���� �����ϸ鼭 ��ġ�ϴ� ù���� ���� ����
		System.out.println(ll.size() + "/" + ll);

		for (String name : ll) {
			System.out.println(name);
		}
		// ��� ���� �� ���� :
		ll.clear();
		System.out.println("��ü ���� �� : " + ll.size() + "/" + ll);

		// �迭�� ��
		for (int i = 0; i < names.length; i++) {
			System.out.printf("%s\t", names[i]);// �迭�ǰ��� ��������ʾ�
		}

	}

	public static void main(String[] args) {
		UseList ul = new UseList();
		System.out.println("---------------------ArrayList-----------------------------");
		ul.useArrayaList();
		System.out.println("------------------------Vector--------------------------");
		ul.useVector();
		System.out.println("---------------------------LinkedList-----------------------");
		ul.useLinkedList();
	}// main

}// class
