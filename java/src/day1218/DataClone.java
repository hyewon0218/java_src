package day1218;

import java.util.Stack;

public class DataClone {
	private Stack<Data> historyStack;

	public DataClone() {
		historyStack = new Stack<Data>();
	}

	public void useData() throws CloneNotSupportedException {
		Data d=new Data("쌍용 유치원");
		
		if(d instanceof Cloneable) {
			
		
		d.setSchool("쌍용초등학교");
		Data d1=d.getData();//안담아도됨
		historyStack.push(d1);//쌍용초가 복제된 값/d1대신 d.getData()넣어도됨!

		d.setSchool("쌍용중학교");
		Data d2=d.getData();
		historyStack.push(d2);//쌍용중가 복제된 값
		
		d.setSchool("쌍용고등학교");
		Data d3=d.getData();
		historyStack.push(d3);//쌍용중가 복제된 값
		
		d.setSchool("쌍용대학교");
		historyStack.push(d.getData());
		
		getHistoryData();
		}else {
			System.out.println("Cloneable만 처리합니다.");
		}
	}

	public void getHistoryData() {
		Data temp=null;
		while(!historyStack.empty()) {
			temp=historyStack.pop();
			System.out.println(temp);
			System.out.println(temp.getSchool());
		}
	}
	
	public static void main(String[] args) {
		try {
			new DataClone().useData();
		} catch (CloneNotSupportedException e) {
			System.err.println("복제되지 않습니다.");
			e.printStackTrace();
		}

	}// main

}// class
