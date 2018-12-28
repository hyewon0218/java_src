package day1129;

import java.util.Arrays;

/**
 * 사용자 정의 데이터형(내가 만든 클래스)사용하여 배열을 생성<br>
 * 생성된 배열 방 하나는 여러개의 다양한 값을 저장하고 사용할 수 있다.
 * @author SIST
 */
public class UseClassArray { 

	public UseClassArray () {//기본생성자
		//1. 배열의 선언 : 데이터형[] 배열명 =null; //참조하는 heap의 주소가 없다.
		Data[] dataArr=null;
		//2. 생성 : 배열명=new 데이텨형[방의수];
		dataArr=new Data[4];
		//3. 값 할당 : 배열명[방의 번호]=new 생성자();//추천
		//아니면, 클래스명 객체명=new 생성자();//코드많아불편
		//배열명[방의번호]=객체명;
		dataArr[0]=new Data("공선의",27,"gong@daum.net",'G');
		dataArr[1]=new Data("김건하",29,"kim@daum.net",'K');
		dataArr[2]=new Data("최지우",25,"choi@daum.net",'C');
		//객체생성 후 값을 추가
		Data d=new Data();
		dataArr[3]=d;
		//주소는 하나이므로 배열명을 사용하여 method를 호출하든
		dataArr[3].setName("정택성");
		dataArr[3].setAge(26);
		//객체명을 사용하여 method를 호출하든 동일하게 값이 변경된다.
		d.setEmail("jung@jung.net");
		
		d.setInitial('D');
		
//		System.out.println(Arrays.toString(dataArr));
		//4. 값 사용
		//배열명으로 바로 사용.
		System.out.println(dataArr[0].getName()+"/"+dataArr[0].getAge());
		//객체에 저장하여 사용.(가독성이 좋다.)
		Data temp=dataArr[0];
		System.out.println(temp.getName()+"/"+temp.getAge());
		
		//일괄처리
//		Data tempData=null;
//		for(int i=0; i < dataArr.length; i++) {
//			 tempData=dataArr[i];
//			 System.out.println(tempData.getName()+"/"+tempData.getAge()+"/"+
//					 				tempData.getEmail()+"/"+tempData.getInitial());
//		 }
//	}
		
	for(Data tempData : dataArr) {
		 System.out.println(tempData.getName()+"/"+tempData.getAge()+"/"+
	 							tempData.getEmail()+"/"+tempData.getInitial());
	}
		
	}	
		public static void main(String[] args) {
		new UseClassArray();  //객체
			
		
	}//main

}//class
