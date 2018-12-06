package day1206;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Work {
	List<String> name = new ArrayList<String>();
	List<Integer> score = new ArrayList<Integer>();
	
	public Work (String str) {
		
		String[] name =str.split(",");
		Random r=new Random();
		
		for(int i=0; i<name.length;i++) {
			this.name.add(name[i]);
			score.add(r.nextInt(101));
		}
	}

	public void Work(int cnt) {
		int sumOfScore =0;
		Random r=new Random();
		int [] tmpIdx =new int[name.size()];
		
		for(int i=0; i < tmpIdx.length; i++) {
			tmpIdx[i]=r.nextInt(name.size());
			for(int j=0; j<i;j++) {
				if(tmpIdx[i]==tmpIdx[j]) {
					j--;
					break;
				}
			}
		}
		System.out.println(name.get(tmpIdx[i])+" "+score.get(tmpIdx[i]));
		sumOfScore += score.get(tmpIdx[i]);
	}
//	public void useWork() {
//
//		name.add("백인재");
//		name.add("이봉현");
//		name.add("이재찬");
//		name.add("정택성");
//		name.add("이재현");
//		name.add("김정운");
//		
//
//		String[] names = new String[name.size()];
//		name.toArray(names);
//
//		for (String name : name) {
//			System.out.println(name);
//		}
//	}

	public static void main(String[] args) {
//		Work w = new Work();
//		w.useWork();
	}// main

}// class
