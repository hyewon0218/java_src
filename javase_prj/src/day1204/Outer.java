package day1204;

/**
 * 
 * @author SIST
 */
public class Outer {
	int i;
	
	public Outer() {
		System.out.println("�ٱ� Ŭ������ ������");
	}//Outer
	
	public void outMethod() {
		System.out.println("�ٱ� Ŭ������ method i="+i);
//		System.out.println("���� Ŭ������ j="+j);
		//����Ŭ������ ��üȭ
		Outer.Inner in =this.new Inner();
		in.j=100;
		in.inMethod();
	}
	////////////////////////////���� Ŭ���� ����//////////////////////////////////////////////////
	public  class Inner{
		int j;
		public Inner() {
			System.out.println("���� Ŭ������ ������");
		}
		
		public void inMethod() {
			System.out.println("���� Ŭ������ method j="+j+",�ٱ� Ŭ������ ���� i="+i);
//			outMethod();//�ٱ� Ŭ������ mtehod
		}
		
		
	}//class
	////////////////////////////���� Ŭ���� ��//////////////////////////////////////////////////
	
	public static void main(String[] args) {
		//1. �ٱ� Ŭ������ ��üȭ
		Outer out =new Outer();
		out.i=10;
		out.outMethod();
//		out.j=100; // ����Ŭ������ �ڿ��� ���� �����Ͽ� ����� �� ����.
//		out.inMethod;
		//2. ���� Ŭ������ ��üȭ : -- �ٱ� Ŭ�������� ���� Ŭ������ �ڿ��� ����� �� �ִ�.
		//�ٱ�Ŭ������.����Ŭ������ ��ü�� = �ٱ�Ŭ������ ��ü��.new ���ʻ�����();
//		Outer.Inner in =out.new Inner();
		//�ٱ� Ŭ�������� ������ ���ִ�.
//		Inner in =out.new Inner();
//		in.j=12;
//		in.inMethod();
	}//main

}//class
