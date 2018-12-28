package day1227;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Thread�� �����Ͽ� �޼����� �д� �ڵ带 ȭ��, �޼����� ������ �ڵ�� ���ÿ� ó���Ѵ�.
 * 
 * @author SIST
 *
 */
@SuppressWarnings("serial")
public class SimpleThreadChatServer extends JFrame implements ActionListener, Runnable {

	private JTextArea jta;
	private JTextField jtf;
	private JScrollPane jsp;

	private ServerSocket server;
	private Socket client;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	
	private String serverNick;
	private String clientNick;

	public SimpleThreadChatServer() {
		super(":::::::ä�ü���:::::::");

		jta = new JTextArea();
		jta.setBorder(new TitledBorder("��ȭ����"));
		jta.setEditable(false);
		jta.setLineWrap(true);
		jta.setWrapStyleWord(true);

		JScrollPane jsp = new JScrollPane(jta);

		jtf = new JTextField();
		jtf.setBorder(new TitledBorder("��ȭ�Է�"));

		add("Center", jsp);
		add("South", jtf);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// ȭ���� ����� �� windowClosed ȣ��
				dispose();
			}

			// closingó�����ϸ� �����⸸ �װ� ���Ͽ����� ��������
			// windowClosed���� ������ ��� ������� �Ѵ�.
			@Override
			public void windowClosed(WindowEvent e) {
				try {
					close(); // Ŭ���̾�Ʈ�� �����ϰ� �ִ� ��Ʈ��, ����, �������� ����
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		setBounds(400, 200, 300, 400);
		setVisible(true);
		jtf.requestFocus();

//		try {
//			openSever();
//			//has a : �޼����� �д� �ڵ带 Tread �� ó���ϸ� ��� �ֵ� ������ �ϰ� �ȴ�.
//			Thread t=new Thread(this);
//			t.start();//start�� ���� run ȣ�� 
////			revMsg();
//		} catch (SocketException se) {
//			System.err.println("�����ڰ� ������ �� ���� " + se.getMessage());
//		} catch (IOException ie) {
//			JOptionPane.showMessageDialog(this, "���� ���� ����! �޽����� �о���� �� �����ϴ�.");
//			ie.printStackTrace();
//		}

		jtf.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			// �����ڰ� �����Ͽ� ��Ʈ���� ������ ��츸
			if (writeStream != null) { // �޽����� ������.
				sendMsg();
			} else {
				JOptionPane.showMessageDialog(this, "��ȭ��밡 �����ϴ�.");
				jtf.setText("");
			}
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(this, "�޽��� ���� ����!");
			e1.printStackTrace();
		}
	}

	/**
	 * 1. ServerSocket ����(PORT ����), 2.������ ������ ������(accept) ��ȭ�� �ְ� ���� �� �ֵ��� 3.Stream��
	 * ����(DIS, DOS)
	 */
	public void openSever() throws IOException, SocketException {
		serverNick=JOptionPane.showInputDialog("��ȭ�� �Է�");
		// 1.
		server = new ServerSocket(65535);
		jta.setText("�������� ��.... �����ڸ� ��ٸ��ϴ�.");
		// 3.
		client = server.accept();
		jta.append("\n----------- client ���� -----------\n");
		// 4. ��Ʈ�� ����
		readStream = new DataInputStream(client.getInputStream());
		writeStream = new DataOutputStream(client.getOutputStream());
		//�������� �г����� �޴´�.
		clientNick=readStream.readUTF();
		//�� ���� �����ش�.
		writeStream.writeUTF(serverNick);
		
	}

	/**
	 * �����ڿ��� �޽����� ������ ��
	 * 
	 * @throws IOException
	 */
	public void sendMsg() throws IOException {
		// T.F�� ���� �����ͼ�
		String msg = jtf.getText().trim();
		// ��Ʈ���� ����ϰ�
		writeStream.writeUTF(msg);
		// ��Ʈ���� ������ �������� ����
		writeStream.flush();
		jta.append("["+serverNick+"] : " + msg + "\n");
		// �Է��� ���ϵ��� jtf�� �ʱ�ȭ
		jtf.setText("");
		jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
	}

	/**
	 * �����ڰ� �������� �޽����� ��� �о� ���� �Ѵ�.
	 * 
	 * @throws IOException
	 */
	@Override
	public void run() {
		String revMsg = "";
		if (readStream != null) {// �����̵Ǿ���
			try {
				while (true) {
					// �޽����� �о�鿩
					revMsg = readStream.readUTF();
					// ��ȭâ�� ���
					jta.append("["+clientNick+"] : " + revMsg + "\n");
					jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
				}
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(this, clientNick+"�����ڰ� ����Ͽ����ϴ�.");
				ie.printStackTrace();
			}
		}
	}

	public void close() throws IOException {
		try {
			if (readStream != null)
				readStream.close();
			if (writeStream != null)
				writeStream.close();
			if (client != null)
				client.close();
		} finally {
			if (server != null)
				server.close();
		}
	}

	public static void main(String[] args) {
//		new SimpleThreadChatServer();
		SimpleThreadChatServer stcs = new SimpleThreadChatServer();
		try {
			stcs.openSever();
			// thread�� stcs��ü�� has a����� ����
			Thread t = new Thread(stcs);
			// �޼����� �д� �ڵ带 thread�� ó��
			t.start();// start�� ���� run ȣ��
		} catch (SocketException se) {
			System.err.println("�����ڰ� ������ �� ���� " + se.getMessage());
		} catch (IOException ie) {
			JOptionPane.showMessageDialog(stcs, "���� ���� ����! �޽����� �о���� �� �����ϴ�.");
			ie.printStackTrace();
////		revMsg();

			// //has a : �޼����� �д� �ڵ带 Tread �� ó���ϸ� ��� �ֵ� ������ �ϰ� �ȴ�.
//	}
		}
	}
}
