package day1206;

import java.text.DecimalFormat;

/**
 * DecimalFormat
 * 숫자를 지정한 문자열로 변경
 * @author SIST
 */
public class UseDecomalFormat {
	
	public UseDecomalFormat() {
		int  temp=2018;
		System.out.println(temp);
		
		DecimalFormat df =new DecimalFormat("0,000,000,000");
		DecimalFormat df1 =new DecimalFormat("#,###,###,###");
		
		System.out.println("0사용: "+df.format(temp));//0으로 채워짐
		System.out.println("#사용: "+df1.format(temp));
		
		DecimalFormat df2 =new DecimalFormat("#,###.00");//소수점이하 표현가능(0이나#)
		//실수 자릿수를 사용하면 마지막 뒷자리의 값이 반올림 대상이라면 반올림한 결과를
		// 보여준다.(0.065->0.07)
		System.out.println("소수자리수 표현 : "+df2.format(201812.066));
	}
	
	public static void main(String[] args) {
		new UseDecomalFormat();
	}//main

}//class
