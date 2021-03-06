package day1115;
/*
	논리연산자 : 
	 일반논리
		&&(AND) : 전항과 후항이 모두 true일 때만 true 반환
 		||(OR) : 전항과 후항이 모두 false일 때만 false 반환
	비트논리
		&(AND) : 상위비트와 하위비트 모두 1인경우 1내림
		| (OR) : 상위비트와 하위비트 모두 0인 경우 0내림
		^ (XOR) - Exclusive OR : 상위비트와 하위비트 둘중 하나만 1인 경우 1내림 


*/

class Operator5 {
	public static void main(String[] args) {
		boolean flag1=true, flag2=false, flag3=true, flag4=false;
		int i=0,j=0;

		System.out.println("-----------------------------------&&---------------------------------------------");
		System.out.println(flag1+"&&"+flag3+" = " +(flag1 && flag3)); //true
		System.out.println(flag1+"&&"+flag2+" = " +(flag1 && flag2)); //false
		//전항이 false이면 후항을 계산하지 않고 false인 결과를 만든다.
		System.out.println(flag2+"&&"+flag1+" = " +(flag2 && flag1)); //true
		System.out.println(flag2+"&&"+flag4+" = " +(flag2 && flag4)); //true

		System.out.println("-----------------------------------||---------------------------------------------");
		System.out.println(flag1+"||"+flag3+" = " +(flag1 || flag3)); //true
		System.out.println(flag1+"||"+flag2+" = " +(flag1 || flag2)); //false
		//전항이 false이면 후항을 계산하지 않고 false인 결과를 만든다.
		System.out.println(flag2+"||"+flag1+" = " +(flag2 || flag1)); //true
		System.out.println(flag2+"||"+flag4+" = " +(flag2 || flag4)); //true
	
		System.out.println("--------------------------------------------------------------------------------");
		
		flag1=false; 
		flag2=false;
		flag3=false;

		flag3=(flag1=3>4) && (flag2=5>4);
		System.out.println("전항 : "+flag1+", 후항 : "+flag2+",판정 : "+flag3);
		System.out.println("--------------------------------------------------------------------------------");
		
		i=28;
		j=48;
		System.out.println(i+" & "+j+" = "+(i&j));
		// 0001 1100 & 0011 0000 = 0001 0000
		i=16;
		j=3;		
		System.out.println(i+" | "+j+" = "+(i|j));
		// 0001 0000 & 0000 0011 = 0001 0011
		i=10;
		j=12;	
		System.out.println(i+" ^ "+j+" = "+(i^j));
		//0000 1010 ^ 0000 1100 = 0000 0110 

	}//main
}//class
