package day1127;

public class UseString1 {
	//�̸����� �Է¹޾� �̸����� ��ȿ���� �����Ͽ� boolean������
	//����� ����� ��ȯ�ϴ� ���� �ϴ� method�� ����� ȣ���Ͽ� ���
	//5�� �̻��̸鼭 @��,�� �־����
	
	private boolean validEmail(String email) {
		boolean flag=false;
		
		if(email.length()>5 && email.indexOf("@")!=-1 &&email.indexOf(",")!=-1) {
			flag=true;
		}//end else	
		return flag;
//		flag=email.length()>5 && email.indexOf("@") &&email.indexOf(",");
//			return flag;
		}//vaildEmail
	
	//'�ñ���' ������ �ּҸ� n�� �Է¹޾� ��������� �ƴ����� �Ǵ��Ͽ� ����ϴ� method
	//public void 
	
	public static void main(String[] args) {
		UseString1 us1= new UseString1();
		String email = "esc0218@navercom";
		if(us1.validEmail(email)) {
			System.out.println(email+"��ȿ");
		}else {
			System.out.println(email+"��ȿ");
			
		}

		
	}//main

}//class
