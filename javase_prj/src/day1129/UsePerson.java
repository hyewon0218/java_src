package day1129;

import java.util.Date;

public class UsePerson {

	public static void main(String[] args) {
		HongGilDong gd =new HongGilDong();
		gd.setName("ȫ�浿");//�θ��� method�� ��� 
		System.out.println("�� : "+gd.getEye()+",�� : "+gd.getNose()+", �� : "+gd.getMouth());
		System.out.println(gd.eat());
		System.out.println(gd.eat("����",1));
		//�ڽŸ��� Ư¡
		
		System.out.println(gd.fight(6));//7>8
		System.out.println(gd.fight(7));//8>9
		System.out.println(gd.fight(9));//���.9>8
		System.out.println(gd.fight(10));//����.8>7
		System.out.println(gd.fight(9));//����.8>7
		
		System.out.println("------------------------------------------------------------------------------");
		Clark superman=new Clark();//�ڽ��� �����Ǹ� �θ�Ŭ������ ���� ������ �� �ڽ��� �����ȴ�.
		//�ڽ��� ��ü�� �θ�Ŭ������ �ڿ�(����,method)�� �ڽ��� ��ó�� ����� �� �ִ�.(�ڵ��� ���뼺)
		superman.setName("Ŭ��");//�ڽ�Ŭ������ ��ü������ �󸶵���..
		
		System.out.println(superman.getEye()+"/"+superman.getNose()+"/"
							+superman.getMouth()+"/"+superman.getName());
		
		System.out.println(superman.eat());
		System.out.println(superman.eat("������ũ",10));
		
		//�ڽ�(�ڽ�)�� �ڿ�(����,method) 
		String stone="¯��";
		System.out.println(stone+"�� ���� ���"+superman.power(stone)+", ���� ��ȭ :"+superman.power);//getter�����ʰ�����
		stone="Ŭ���䳪��Ʈ";
		System.out.println(stone+"�� ���� ���"+superman.power(stone)+", ���� ��ȭ :"+superman.power);//getter�����ʰ�����
		stone="���̾Ƹ��";
		System.out.println(stone+"�� ���� ���"+superman.power(stone)+", ���� ��ȭ :"+superman.power);//getter�����ʰ�����
		
		Won w =new Won();
		w.setName("Won");
		System.out.println(w.getName()); 
		System.out.println(w.run());
		System.out.println(gd);//�ּҳ��� object�� toString �ҷ��� ��
		System.out.println(gd.toString());
		System.out.println(w.toString());
		
		String s=new String ("������ �ݿ�");
		
		Date d=new Date();
		System.out.println(d.getYear());//����õmethod
		System.out.println(s.toString());//overriding �θ� �����ϴ� �ּ��� ��±�� �Ⱦ� �ٲ� 
	}//main

}//class
