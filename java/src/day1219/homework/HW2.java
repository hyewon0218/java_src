package day1219.homework;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class HW2 {

	String path;
	File[] files;
	File file; 
	int javaFiles;
	List<Integer> listIdx;
	
	public HW2() {

		getPath();

		file= new File(path);// �ش��������ϰ�ü����

		if (file.isFile()) {
			JOptionPane.showMessageDialog(null, "�Է°��� ��ΰ� �ƴ϶� �����Դϴ�.");
		} else {
			checkJava();

			String msg = "java������" + javaFiles + "�� �����մϴ�. �����Ͻðڽ��ϱ�?";

			int select = JOptionPane.showConfirmDialog(null, msg);// ��ȯ������ �����������ϱ�

			switch (select) {
			case JOptionPane.OK_OPTION:// ok
				for (int i = 0; i < listIdx.size(); i++) {
					files[listIdx.get(i)].delete(); // int�� ���ͼ� files�迭�� ��Ҽ��� �ؼ� �����
				}
			}

		}

	}

	public void getPath() {
		path = JOptionPane.showInputDialog("��θ� �Է��ϼ���. \n ��)c:/dev");// ���������� �ν��Ͻ���
	}

	public void checkJava() {
		// 'java'�� ������ �����ϴ��� �����Ǵ�
		 files= file.listFiles();
		javaFiles = 0;
		listIdx = new ArrayList<Integer>();// �������� list

//		files[0].getName()//files���� ���Ͽ� ���� ������ ��������. /�̷��� �迭�� ����� File��ü�� ��� ����
		for (int i = 0; i < files.length; i++) {// ���(�迭�� ����) ����� �������� �����ͼ�
			// for���� ���鼭 �����ؾߵǴ� �͵� : �ڹ������� ��, ������ ������ index
			if (files[i].getName().contains(".java")) {// boolean �ٷ� for������
				listIdx.add(i);// �迭�� ����� �Ǹ� 5���� ������ �����س����� list�� �������̶� //�����ϴ°��� �ε�������
				javaFiles++;// ������
			};
		}
	}

	public static void main(String[] args) {
		new HW2();
	}

}
