package prj;


public class RandomPW {

	public RandomPW() {
		
	}
	
	public char[] createPassword () {
		char[] tempPass=new char[12];
		//�����ڴ빮��(65~90), �ҹ���, ����(48~57)�� �̷���� ������ ��й�ȣ 8�ڸ��� �����Ͽ� ��ȯ�ϴ� ��
		String flag="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		
		for(int i=0; i < tempPass.length ; i++) {
			tempPass[i]=flag.charAt((int)(Math.random()*flag.length())); 
			System.out.print(tempPass[i]);
		}
		return tempPass;
	}
	
	public static void main(String[] args) {
		new RandomPW().createPassword();
		
	}//main
}
