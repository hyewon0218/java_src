package day1129;

public class UsePerson {

	public static void main(String[] args) {
		HongGilDong gd =new HongGilDong();
		gd.setName("È«±æµ¿");//ºÎ¸ðÀÇ method¸¦ »ç¿ë 
		System.out.println("´« : "+gd.getEye()+",ÄÚ : "+gd.getNose()+", ÀÔ : "+gd.getMouth());
		System.out.println(gd.eat());
		System.out.println(gd.eat("±¹¹ä",1));
		//ÀÚ½Å¸¸ÀÇ Æ¯Â¡
		
		System.out.println(gd.fight(6));//7>8
		System.out.println(gd.fight(7));//8>9
		System.out.println(gd.fight(9));//ºñ±è.9>8
		System.out.println(gd.fight(10));//Áø´Ù.8>7
		System.out.println(gd.fight(9));//Áø´Ù.8>7
		
	}//main

}//class
