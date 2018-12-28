package day1206;

public class RunProcessor {
	
	public static void main(String[] args) {
		
		String str ="백인재, 이봉현, 이재찬, 정택성, 이재현, 김정운";
		
		ScoreProcessor sp =new ScoreProcessor(str);
		
		int cnt = 0;
		while(true) {
			cnt=(int)(Math.random()*sp.name.size())+1;
			
			if(cnt > 1 ) break;
			
		}
		
		sp.printScore(cnt);
	}
}

