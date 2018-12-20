package day1127;

//1. �ֹι�ȣ�� �Է¹޾� ó���ϴ� ���α׷� �ۼ�
//	 �� �۾��� method�� �����ϰ� ȣ���Ͽ� ����� �޾Ƽ� ó��
//	1-1 �����ڴ� �ֹι�ȣ�� �޾� instance������ �Ҵ��Ѵ�.
//  �ν��Ͻ� ������ ���� ���
//  1-2 �ֹι�ȣ�� ���̸� üũ�Ͽ� 14�ڰ� �ƴϸ� false ��ȯ checkssn
//  1-3 �ֹι�ȣ�� 6��° �ڸ��� '-'�� �ƴϸ� false ��ȯ
//  1-4 �ֹι�ȣ�� ��ȿ�� ����(�� �ڸ��� 2345 ���ؼ�....)�� �Ͽ� ��ȿ�ϸ� true, �׷��� ������ false ��ȯ
//				�� �ڸ��� 234567892345 �� ���� ���� ���Ͽ� 11�� ���� ������ ���� ��� 11���� �װ��� ����
//				10���� ���� �������� �ֹι�ȣ�� ���ڸ��� ���ٸ� true, �׷��� ������ false
//  1-5 ��������� ��ȯ�ϴ� �� "1988-11-11"
//  1-6 ���̸� ��ȯ �ϴ� �� ex)25 ����⵵-�¾��+1
//	1-7 ������ ��ȯ ex) ��,�� 
// 1-8  ������/�ܱ��� ��ȯ
//       012349      56(1900's)78(2000's)
// 1-9  �츦 ��ȯ ex) "���"
public class Work21 {
	
	String ssn;
	
	
	public boolean checkSsn() {
		if(ssn.length()!=14) {
			return false;
		}	else {
			return true;
		}
	}
	
	public boolean checkSsn1() {
		if(ssn.charAt(6)!='-') {
			return false;
		}else {	
			return true;
		}
	}
	public boolean validSsn() {
		int checkNum =0;
		
		int j =2;
		
		
		for(int i=0; i<6;i++) {
			checkNum+=Integer.parseInt(ssn.substring(i, i+1))*j;
			j++;
		}
		
		for(int i=7; i<ssn.length()-1;i++) {
			checkNum+=Integer.parseInt(ssn.substring(i, i+1))*j;
			j++;
			if(j>9) j=2;
		}
		
		checkNum %=11;
		checkNum =11- checkNum;
		checkNum %=10;
		
		if(Integer.parseInt(ssn.substring(13))==checkNum) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	public Work21(String ssn) {
		this.ssn=ssn;
	}
	public	 String getBirth() {
		
		int flag= Integer.parseInt(ssn.substring(7, 8));
		String birth;
		
		if (flag ==1 || flag==2 || flag ==5 || flag==6) {
			birth =19+ssn.substring(0,2)+"-"+ssn.substring(2,4)+"-"+ssn.substring(4,6);
		}else {
			birth =20+ssn.substring(0,2)+"-"+ssn.substring(2,4)+"-"+ssn.substring(4,6);
			
		}
		
		return birth;
	}
	public int getAge() {
		int flag= Integer.parseInt(ssn.substring(7, 8));
		String birthYear;
		int age;
		
		
		if (flag ==1 || flag==2 || flag ==5 || flag==6) {
			birthYear =19+ssn.substring(0,2);
			age = 2018-Integer.parseInt(birthYear)+1;
		}else {
			birthYear =20+ssn.substring(0,2);
			age = 2018-Integer.parseInt(birthYear)+1;
			
		}
		return age;
	}
	public char getGender() {
		int flag = Integer.parseInt(ssn.substring(7,8));
			
		if (flag == 1 || flag == 3 || flag == 5 || flag == 7) {
			return '��';
		} else {
			return '��';
			}
		}
	public String checkNation() {
		
		int flag = Integer.parseInt(ssn.substring(7,8));
		
		if (flag == 0 || flag == 1 || flag == 2 || flag == 3 || flag == 4 || flag == 9) {
			return "������";
		} else {
			return "�ܱ���";
		}
	}
	private String getChineseZodiac() {
		
		int flag = Integer.parseInt(ssn.substring(7,8));
		String birthYear;
		
		if (flag == 1 || flag == 2 || flag == 5 || flag == 6) {
			birthYear = 19+ssn.substring(0,2); 
		} else {
			birthYear = 20+ssn.substring(0,2); 
		}
		
		int i = Integer.parseInt(birthYear);
		
		if (i%12 == 11) {
			return "��";
		} else if (i%12 == 10) {
			return "��";
		} else if (i%12 == 9) {
			return "��";
		} else if (i%12 == 8) {
			return "��";
		} else if (i%12 == 7) {
			return "�䳢";
		} else if (i%12 == 6) {
			return "ȣ����";
		} else if (i%12 == 5) {
			return "��";
		} else if (i%12 == 4) {
			return "��";
		} else if (i%12 == 3) {
			return "����";
		} else if (i%12 == 2) {
			return "��";
		} else if (i%12 == 1) {
			return "��";
		} else {
			return "������";
		}
	}
	
	public static void main(String[] args) {
		String ssn = "940218-2268415";
		Work21 w21 =new Work21(ssn);
		if (w21.checkSsn()) {
			if(w21.checkSsn1()) {
				if(w21.validSsn()) {
					System.out.println("������� : " + w21.getBirth());
					System.out.println("���� : " + w21.getAge());
					System.out.println("���� : " + w21.getGender());
					System.out.println("���� : " + w21.checkNation());
					System.out.println("�� : "+w21.getChineseZodiac());
				} else {
					System.out.println("������ �ȵǴ� �ֹι�ȣ�Դϴ�..");
				}
			} else {
				System.out.println("6��° �ڸ��� '-'�� �����ϴ�..");
			}
		} else {
			System.out.println("�ֹι�ȣ ���̰� 14�ڰ� �ƴմϴ�..");
		}
	}//main

		
	}//calss



