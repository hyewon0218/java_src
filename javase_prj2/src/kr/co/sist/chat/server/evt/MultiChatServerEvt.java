package kr.co.sist.chat.server.evt;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import kr.co.sist.chat.server.helper.MultiChatServerHelper;
import kr.co.sist.chat.server.view.MultiChatServerView;

public class MultiChatServerEvt extends WindowAdapter implements ActionListener, Runnable {

	private MultiChatServerView mcsv;
	private Thread threadServer;// 접속자에 대한 처리를 하기 위한 Thread
	private ServerSocket server;// PORT열기
	private java.util.List<MultiChatServerHelper> listClient;// 모든 접속자를 관리할 List

	public MultiChatServerEvt(MultiChatServerView mcsv) {// has a 관계
		this.mcsv = mcsv;
		listClient = new ArrayList<MultiChatServerHelper>();// 검색,중복데이터 저장가능
	}
	

	@Override
	public void run() {// start에 의해 불려짐
		// 서버소캣을 열고 접속자 소켓을 받는다.
		try {
			server = new ServerSocket(36000);// 0~65535개의 PORT가 열릴 수 있다.//여러개열릴수있다??
			DefaultListModel<String> dlmtemp = mcsv.getDlmChatList();
			dlmtemp.addElement("서버가 36000 PORT를 열고 가동 중.....");

			Socket someClient = null;// 접속자 소켓을 저장할 객체 (객체초기화 null)
			InetAddress ia = null;// 접속자의 ip address를 얻기 위한 객체
			MultiChatServerHelper mcsh = null;// 접속자 소켓을 받아 스트림을 연결하고,
			// 대화를 읽거나 모든 접속자에게 전송하는 일.
			
			for (int cnt = 0;; cnt++) {// 조건이 없으면 무한루프
				someClient = server.accept();//client와 연결
				ia = someClient.getInetAddress();
				
//				dlmtemp.addElement("["+ ia +"] 접속자 접속.");// 객체출력하면 나오는 메소드 : toString 오버라이딩하면 클래스가 제공하는 메세지가 나옴

				// 소켓, 서버의 화면 , 접속순서를 할당하여 Helper class 생성
				mcsh = new MultiChatServerHelper(someClient, dlmtemp, cnt, mcsv, listClient, mcsv.getJspList());
				// 생성된 같은 이름의 소켓 객체를 여려거 관리하기 위해 List에 추가
				listClient.add(mcsh);
				// 접속자의 메세지를 읽어들이기 위한 Thread를 시작
				mcsh.start();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		mcsv.dispose();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		try {
		if(server !=null) {server.close(); }
		}catch	(IOException ie) {
			ie.printStackTrace();
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == mcsv.getJbtOpenServer()) {
			if (threadServer == null) {
				threadServer = new Thread(this);// 내클래스의 인스턴스가리킴
				threadServer.start();// start()->run()
			} else {// 서버가동중
				JOptionPane.showMessageDialog(mcsv, "채팅서버가 이미 가동중입니다.");
			}
		}

		if (ae.getSource() == mcsv.getJbtCloseServer()) {
			switch (JOptionPane.showConfirmDialog(mcsv, "채팅서버를 종료하시겠습니까?\n 종료하시면 모든 접속자의 연결이 끊어집니다.")) {
			case JOptionPane.OK_OPTION:
				mcsv.dispose();
			}
		}
	}

}
