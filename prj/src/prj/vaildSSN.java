package prj;

public class vaildSSN {
	
public void verifySsn() { //�ֹι�ȣ �˻�
		
		try {
		if((suv.getJtfSsn1().getText().trim()==null)||
				((suv.getJtfSsn1().getText().trim().equals("")))||
				(suv.getJtfSsn2().getText().trim()==null)||
				((suv.getJtfSsn2().getText().trim().equals("")))) {
			JOptionPane.showMessageDialog(suv, "�ֹι�ȣ�� �Է��ϼ���.");
			return;
		}
		if((Integer.parseInt(suv.getJtfSsn1().getText().trim())<7)||(Integer.parseInt(suv.getJtfSsn2().getText().trim())<8)) {
			JOptionPane.showMessageDialog(suv, "�ֹι�ȣ ������ �߸��Ǿ����ϴ�.");
			
		}
		
		/*	-- �ֹι�ȣ�� ��ȿ�� ����
	-- �� �ڸ��� 2,3,4,5,6,7,8,9,2,3,4,5�� ���Ѱ��� ���ؼ�
	-- 11�� ���� �������� ���ϰ� 11���� ������ 10���� ����
	-- �������� ���� �� ���� �ֹι�ȣ�� ������ ���ڿ� ���ٸ� ��ȿ / ��ȿ	
		 */
		String ssn = suv.getJtfSsn1().getText().trim()+suv.getJtfSsn2().getText().trim();
		char[] cutSsn =new char[ssn.length()];
		int sum = 0;
		int valid = 0;
		
		
		for(int i=0;i<ssn.length()-1;i++) {
			cutSsn[i] = ssn.charAt(i);
			if(i<8) {
				sum += ((int)cutSsn[i]-48)*(i+2);
			}else {
				sum += ((int)cutSsn[i]-48)*(i-6);
			}
		}
		valid = (int)ssn.charAt(12)-48;
		
		int nahnhum=(11-(sum%11))%10;
		if(!(valid==nahnhum)) {
			flagSsn = false;
			return;
		}
		flagSsn = true;
		JOptionPane.showMessageDialog(suv, "������ Ȯ�εǾ����ϴ�!");
		
		
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(suv, "�ֹι�ȣ ������ �߸��Ǿ����ϴ�.");
		}
	
	}
	
	public void verifyEmail() {
		String[] dotcom = {"com","co.kr","net","kr","org","or.kr"};
		for(int i=0;i<dotcom.length;i++) {
			if(!(suv.getJtfEmail2().getText().substring(suv.getJtfEmail2().getText().indexOf(".")+1).equals(dotcom[i]))) {
				flagEmail = false;
			}else {
				break;
			}
		}
		if(suv.getJtfEmail2().getText().contains("@")||!suv.getJtfEmail2().getText().contains(".")||
				suv.getJtfEmail1().getText().contains("@")) {
			flagEmail = false;
			return;
		}
		flagEmail =true;
	}
	
}
