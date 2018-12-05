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
		String names="이재찬,이재현.공선의,정택성~이재현!최지우.김희철,이재찬,이재찬,정택성.공선의";
		Work w=new Work();
		String[] w1=w.getName(names);
		
		for(int i=0; i<w1.length; i++) {
			System.out.print(w1[i]+" ");		
		}
		w.getName(names);
	}//main
}//class
