package day1207;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HW {

	Set<Integer> set = new HashSet<>();
	Map<Integer, Integer> map = new HashMap<>();

	public void setDate(String[] input) {
		System.out.println("setDate");
		Calendar c = Calendar.getInstance();// 객체화안됨

		int temp;
		for (int i = 0; i < input.length; i++) {
			temp = Integer.parseInt(input[i]);
			if (temp > 0 && temp < 32) {
				set.add(temp);

			}
		}
		System.out.println(set);

		Iterator<Integer> ita = set.iterator();

		while (ita.hasNext()) {// get이 없기 때문에 iterator
			temp = ita.next();
			c.set(Calendar.DAY_OF_MONTH, temp);// 날짜바꿈
			map.put(temp, c.get(Calendar.DAY_OF_WEEK));// put!!!
		}
		System.out.println(map);

	}

	public void printDate(Map<Integer, Integer> map) {

		String[] dayOfWeek = { "일", "월", "화", "수", "목", "금", "토" };
		Integer[] day = new Integer[set.size()];

		Set<Integer> set = map.keySet();
		set.toArray(day);

		//선택정렬
		int temp = 0;
		for (int i = 0; i < day.length; i++) {
			for (int j = i + 1; j < day.length; j++) {
				if (day[i] > day[j]) {
					temp = day[i];
					day[i] = day[j];
					day[j] = temp;
				}
			}
		}
//		for(int i=0; i<day.length; i++) {
//			System.out.println(day[i]);
//		}
		for (int i = 0; i < map.size(); i++) {
			System.out.println(day[i]+" "+dayOfWeek[map.get(day[i])-1]);
		}

	}

}
