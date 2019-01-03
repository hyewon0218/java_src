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
	private Thread threadServer;// �����ڿ� ���� ó���� �ϱ� ���� Thread
	private ServerSocket server;// PORT����
	private java.util.List<MultiChatServerHelper> listClient;// ��� �����ڸ� ������ List

	public MultiChatServerEvt(MultiChatServerView mcsv) {// has a ����
		this.mcsv = mcsv;
		listClient = new ArrayList<MultiChatServerHelper>();// �˻�,�ߺ������� ���尡��
	}
	

	@Override
	public void run() {// start�� ���� �ҷ���
		// ������Ĺ�� ���� ������ ������ �޴´�.
		try {
			server = new ServerSocket(36000);// 0~65535���� PORT�� ���� �� �ִ�.//�������������ִ�??
			DefaultListModel<String> dlmtemp = mcsv.getDlmChatList();
			dlmtemp.addElement("������ 36000 PORT�� ���� ���� ��.....");

			Socket someClient = null;// ������ ������ ������ ��ü (��ü�ʱ�ȭ null)
			InetAddress ia = null;// �������� ip address�� ��� ���� ��ü
			MultiChatServerHelper mcsh = null;// ������ ������ �޾� ��Ʈ���� �����ϰ�,
			// ��ȭ�� �аų� ��� �����ڿ��� �����ϴ� ��.
			
			for (int cnt = 0;; cnt++) {// ������ ������ ���ѷ���
				someClient = server.accept();//client�� ����
				ia = someClient.getInetAddress();
				
//				dlmtemp.addElement("["+ ia +"] ������ ����.");// ��ü����ϸ� ������ �޼ҵ� : toString �������̵��ϸ� Ŭ������ �����ϴ� �޼����� ����

				// ����, ������ ȭ�� , ���Ӽ����� �Ҵ��Ͽ� Helper class ����
				mcsh = new MultiChatServerHelper(someClient, dlmtemp, cnt, mcsv, listClient, mcsv.getJspList());
				// ������ ���� �̸��� ���� ��ü�� ������ �����ϱ� ���� List�� �߰�
				listClient.add(mcsh);
				// �������� �޼����� �о���̱� ���� Thread�� ����
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
				threadServer = new Thread(this);// ��Ŭ������ �ν��Ͻ�����Ŵ
				threadServer.start();// start()->run()
			} else {// ����������
				JOptionPane.showMessageDialog(mcsv, "ä�ü����� �̹� �������Դϴ�.");
			}
		}

		if (ae.getSource() == mcsv.getJbtCloseServer()) {
			switch (JOptionPane.showConfirmDialog(mcsv, "ä�ü����� �����Ͻðڽ��ϱ�?\n �����Ͻø� ��� �������� ������ �������ϴ�.")) {
			case JOptionPane.OK_OPTION:
				mcsv.dispose();
			}
		}
	}

}
