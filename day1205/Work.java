package day1205;

import java.util.StringTokenizer;

public class Work {

	public String[] getName(String names) {
		
		StringTokenizer stk=new StringTokenizer(names,",.~!");
		String[] name =new String[stk.countTokens()];
	
		int i=0;
		while(stk.hasMoreTokens()) {
			name[i]=stk.nextToken();
			i++;
		}
		return name;
	}


	public static void main(String[] args) {
		String names="������,������.������,���ü�~������!������.����ö,������,������,���ü�.������";
		Work w=new Work();
		String[] w1=w.getName(names);
		
		for(int i=0; i<w1.length; i++) {
			System.out.print(w1[i]+" ");		
		}
		w.getName(names);
	}//main
}//class
