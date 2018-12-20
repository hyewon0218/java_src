package day1207;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import javax.jws.soap.SOAPBinding.Use;

/**
 * Set : �˻��� ����� ������(get x) �ߺ����� �������� �ʴ� ���. 
 * @author SIST
 */
public class UseSet {
	
	public UseSet() {
		//JDL1.5 ���Ͽ����� Generic�� �������� �ʰ� ��ü�� ����
		//1. ����)
		Set<String> set =new HashSet<String>();
		//2. �� �Ҵ�)
	 	set.add("���ü�");//���׸����ش�Ǵ°����Է¹޵���
	 	set.add("������");
	 	set.add("������");
	 	set.add("������");
	 	set.add("������");
	 	set.add("������");
	 	set.add("�̺���");
	 	set.add("������");
	 	set.add("������");
	 	set.add("������");
	 	set.add("������");//�ߺ����� �������� �ʴ´�.
		System.out.println(set.size()+"/"+set);//Object�� �ִ� toString�� override�ؼ� �ּҰ� ������ �ʰ� ���� ���´�. 
		set.remove("������");//����������
		System.out.println(set.size()+"/"+set);
		
		//�迭�� ����
		String[] names=new String[set.size()];
		set.toArray(names);
		
		//set�� ��� ��(Element)�� �� ��� 
//		System.out.println(set.get("������"));//set ��ü���� �˻��� ����� ����.
		//Iterator�� ����Ͽ� ���� ��� 
		Iterator<String> ita=set.iterator();//set�� ������� String����
		
		String name="";//""empty
		while(ita.hasNext()) {//Iterator�� �����ϴ� Set�� ��Ұ� �����Ѵٸ�
			name=ita.next();//�ش����� ���� ��� ���� �����ͷ� �̵�
			System.out.println(name);
		}
		
		System.out.println("----------------------���� for---------------------------------------------");
		for(String temp : set) {
			System.out.println(temp);
		}
		
		//��� ���� �� ����
		set.clear();
		System.out.println("clear�� "+set.size()+","+set);
		System.out.println("-----------------------------------�迭�� ������ ��-----------------------------");
		for(int i=0; i< names.length; i++) {
			System.out.println(names[i]);
		}
		
		
	}
		public int[] lotto() {//int ��ȯ�ؾ�
			int[] tempLotto=new int[6];
			
			Random random=new Random();
			for(int i=0 ; i < tempLotto.length; i++) {
				tempLotto[i]=random.nextInt(45)+1;//���� ���� �߻��� �� �ִ�.
				for(int j=0; j<i; j++) {//�չ�� �� ó������ �����̶� ���� �ʴ´�.
					if (tempLotto[i]==tempLotto[j]) {//���� ���� ����.
						i--;//�ߺ��߻��� ��ȣ�� �ε�����°�� �ٽ� �߻���Ű�� ���� �ε�����ȣ�� �ϳ� ���δ�.
						break;//�ݺ����� ����������.
					}
				}
			}
			return tempLotto;
	}//lotto
		
		public Integer[] lotto1() {//int ��ȯ�ؾ�
			Integer[] tempLotto=new Integer[6];
			
			Set<Integer> set =new HashSet<Integer>();//�ߺ�������x
			Random random=new Random();
			while(true ) {//���ѷ���
				set.add(random.nextInt(45)+1);//���� ���� �߰����� �ʴ´�.
				if(set.size()==6) {
					break;
				}
			}
			set.toArray(tempLotto);
			return tempLotto;
		}

	public static void main(String[] args) {
		UseSet us=new UseSet();
		Integer [] temp=us.lotto1();
		
		for(int i=0; i< temp.length; i++) {
			System.out.print(temp[i]+" ");
			
		}
		System.out.println("---------------------------\n");
		Integer [] temp1=us.lotto1();
		
		for(int i=0; i< temp1.length; i++) {
			System.out.print(temp1[i]+" ");
			
		}
	}//main

}//class
