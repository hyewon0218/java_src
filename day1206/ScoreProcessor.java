package day1206;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ScoreProcessor {

	List<String> name = new ArrayList<>();
	List<Integer> score = new ArrayList<>();

	public ScoreProcessor(String str) {

		String[] name = str.split(",");
//		(int)Math.random()*100+1
		Random r = new Random();

		for (int i = 0; i < name.length; i++) {
			this.name.add(name[i]);
			score.add(r.nextInt(101));

		}
		System.out.println(this.name + "/" + score);
	}

	public void printScore(int cnt) {

		int[] idx = new int[name.size()];// 0으로초기화/idx중복갑x
		int sumOfScore = 0;
		Random r = new Random();

		for (int i = 0; i < name.size(); i++) {
			idx[i] = r.nextInt(name.size());// 바운더리0에서5까지
			for (int j = 0; j < i; j++) {
				if (idx[i] == idx[j]) {
					i--;
					break;
				}
			}
		}
		for (int i = 0; i < cnt; i++) {
			System.out.println(name.get(r.nextInt(name.size())) + "/" + score.get(r.nextInt(name.size())));
			sumOfScore += score.get(idx[i]);
		}
		System.out.println("총점" + sumOfScore);
	}
}
