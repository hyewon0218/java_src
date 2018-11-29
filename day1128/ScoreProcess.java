package day1128;

/**
 * 4������ �л����� ����ó�� ���α׷�
 * @author SIST
 */
public class ScoreProcess {

	
	
	public ScoreProcess() {
		
		String[] nameArr= {"������","���ü�","������","��ǿ�","������"};//instance����(������������ ���������ھ��� ����)
		int[] scoreArr= {89,76,99,64,50};
//		int maxScore=scoreArr[0];
		int maxScore=0;//�ְ�����
		int minScore=101;//��������
		int temp=0;//���İ��� �ӽ÷� ����
		
		
		System.out.println("��ȣ\t�̸�\t����");
		System.out.println("------------------------------------------------");
		
		int totalScore=0;// totalscoreó��0
		for(int i=0; i < nameArr.length ; i++) {
			System.out.printf("%d\t%s\t%d\n",i+1,nameArr[i],scoreArr[i]);//1���ͽ��� ������������ i+1
			totalScore +=scoreArr[i];//������ ���� ��
			
			//�ְ������� ���� ��ȯ���� ���� ������ �۴ٸ�  
			if(maxScore < scoreArr[i]) {
			//���� ��ȯ���� ���� ������ �ְ������� �������ش�.	
				maxScore=scoreArr[i];
			}
			//���������� ���� ��ȯ���� ���� ������ ũ�ٸ�  
			if(minScore > scoreArr[i]) {
				//���� ��ȯ���� ���� ������ ���������� �������ش�.	
				minScore=scoreArr[i];
			}
		}//end for
		System.out.println("-------------------------------------------------");
		System.out.println("�����ο� : "+nameArr.length+"��");
		System.out.printf("���� [%5d] ��� [%.2f ]\n ", totalScore, totalScore/(double)nameArr.length);//5���������� .�Ҽ����Ǽ��κ�Ȯ������/�������������������� �Ҽ���x castiong
		System.out.println(totalScore/nameArr.length);
		System.out.printf("�ְ��� [%3d] ������[%d]\n ",maxScore,minScore);
		
		for(int i=0; i<scoreArr.length-1; i++) {//�ǵ޹��x
			for(int j=i+1; j <scoreArr.length ;j++) {
				if(scoreArr[i] < scoreArr[j]) {//�չ��� ���� �޹溸�� �۴ٸ� 
					temp=scoreArr[i];
					scoreArr[i]=scoreArr[j];
					scoreArr[j]=temp;
					
				}
			}
		}//end for
		
		
		for(int i=0; i < scoreArr.length ;i++) {
			System.out.printf("%4d",scoreArr[i]);
		}
		
	}//ScoreProcess ������
	
	public static void main(String[] args) {
		
		new ScoreProcess();//instance
		System.out.println("--------------------------------------------------------");
		int birth=1999;
		String[] zodiac= {"������","��","��","����","��","��","ȣ����","�䳢","��","��","��","��"};
		System.out.println(zodiac[birth%12]);
	}//main

}//class
