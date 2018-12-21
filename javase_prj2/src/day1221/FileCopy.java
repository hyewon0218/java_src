package day1221;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

@SuppressWarnings("serial")
public class FileCopy extends JFrame implements ActionListener, Runnable {

	private JButton jb;
	private JProgressBar jpb;// 진척도
	private long fileLen;
	private int cnt;

	public FileCopy() {
		super("파일복사");
		jb = new JButton("파일선택");
		jpb = new JProgressBar(0, 100);
		jpb.setString("진척도");
		jpb.setValue(50);

		JPanel jp = new JPanel();
		jp.add(jb);

		add("Center", jp);
		add("South", jpb);

		jb.addActionListener(this);
		setBounds(100, 100, 500, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void run() {
		for (int i = 0; i <= fileLen; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			jpb.setValue((int) (cnt/ (double) fileLen * 100));
			System.out.println(fileLen + " " + cnt+" "+jpb.getValue());

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FileDialog fd = new FileDialog(this, "파일선택", FileDialog.LOAD);
		fd.setVisible(true);

		String path = fd.getDirectory();
		String name = fd.getFile();
		if (path != null)/* 파일선택 */ {
			File file = new File(path + name);
			try {
				copy(file);
				JOptionPane.showMessageDialog(this, file + "복사 성공");
			} catch (FileNotFoundException fnfe) {
				JOptionPane.showMessageDialog(this, "파일이 존재하지 않습니다.");
				fnfe.printStackTrace();
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(this, "입출력 작업에 문제가 발생했습니다.");
				ie.printStackTrace();
			} // end catch
		} // end if

	}

	public void copy(File file) throws FileNotFoundException, IOException {

		int selectValue = JOptionPane.showConfirmDialog(this, "파일을 복사하시겠습니까?");

		switch (selectValue) {
		case JOptionPane.OK_OPTION:
			StringBuilder copyFileName = new StringBuilder(file.getAbsolutePath());
			copyFileName.insert(copyFileName.lastIndexOf("."), "_bak");
//			System.out.println(copyFileName);

			FileInputStream fis = null;
			FileOutputStream fos = null;

			try {

				// 원본파일에 스트림을 연결
				fis = new FileInputStream(file);
				fos = new FileOutputStream(copyFileName.toString());// __bak가 들어간 이름 /스트링자리에스트링빌더들어가서에러
				int temp = 0;
				// 파일과 연결된 스트림에서 값을 얻는다.
//				int i=0;//몇번 돌았는지!
				fileLen = file.length();/////
				cnt = 0;
				int i =0;
				File tempFile=null;
//				 읽어들이 내용을 _bak가 붙은 파일을 생성하여 출력(복사)

//				 HDD가 읽어들이는 크기를 무시하고 1byte씩 읽어들여 사용
				while ((temp = fis.read()) != -1) {// ??
					fos.write(temp);
					fos.flush();
//					jpb.setValue((int) (cnt / (double) fileLen * 100));// ?
//					System.out.println(jpb.getValue());
//					System.out.print((char)temp);
					cnt++;
					Thread t = new Thread(this);
					t.start();
				}
				// HDD가 한번에 읽어들이는 크기를 그대로 사용
//				byte[] temp = new byte[512];
//				int len = 0;
//				while((len=fis.read(temp))!=-1)/*-1이 아니면 읽어들인데이터가있다*/ {
//					fos.write(temp,0,len);
//					fos.flush();
//				}

			} finally {
				if (fis != null) {
					fis.close();
				}
				if (fos != null) {
					fos.close();
				}
			}

		}
	}

	public static void main(String[] args) {
		new FileCopy();
	}// main

}// class
