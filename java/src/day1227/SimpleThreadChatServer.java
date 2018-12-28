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
 * Thread를 도입하여 메세지를 읽는 코드를 화면, 메세지를 보내는 코드와 동시에 처리한다.
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
		super(":::::::채팅서버:::::::");

		jta = new JTextArea();
		jta.setBorder(new TitledBorder("대화내용"));
		jta.setEditable(false);
		jta.setLineWrap(true);
		jta.setWrapStyleWord(true);

		JScrollPane jsp = new JScrollPane(jta);

		jtf = new JTextField();
		jtf.setBorder(new TitledBorder("대화입력"));

		add("Center", jsp);
		add("South", jtf);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// 화면이 종료된 후 windowClosed 호출
				dispose();
			}

			// closing처리만하면 껍데기만 죽고 소켓연결은 남아있음
			// windowClosed에서 연결을 모두 끊어줘야 한다.
			@Override
			public void windowClosed(WindowEvent e) {
				try {
					close(); // 클라이언트와 연결하고 있는 스트림, 소켓, 서버소켓 종료
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
//			//has a : 메세지를 읽는 코드를 Tread 로 처리하면 어디에 있든 동작을 하게 된다.
//			Thread t=new Thread(this);
//			t.start();//start에 의해 run 호출 
////			revMsg();
//		} catch (SocketException se) {
//			System.err.println("접속자가 들어오기 전 종료 " + se.getMessage());
//		} catch (IOException ie) {
//			JOptionPane.showMessageDialog(this, "서버 가동 실패! 메시지를 읽어들일 수 없습니다.");
//			ie.printStackTrace();
//		}

		jtf.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			// 접속자가 존재하여 스트림이 생성된 경우만
			if (writeStream != null) { // 메시지를 보낸다.
				sendMsg();
			} else {
				JOptionPane.showMessageDialog(this, "대화상대가 없습니다.");
				jtf.setText("");
			}
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(this, "메시지 전송 실패!");
			e1.printStackTrace();
		}
	}

	/**
	 * 1. ServerSocket 생성(PORT 열림), 2.접속자 소켓이 들어오면(accept) 대화를 주고 받을 수 있도록 3.Stream을
	 * 연결(DIS, DOS)
	 */
	public void openSever() throws IOException, SocketException {
		serverNick=JOptionPane.showInputDialog("대화명 입력");
		// 1.
		server = new ServerSocket(65535);
		jta.setText("서버가동 중.... 접속자를 기다립니다.");
		// 3.
		client = server.accept();
		jta.append("\n----------- client 접속 -----------\n");
		// 4. 스트림 연결
		readStream = new DataInputStream(client.getInputStream());
		writeStream = new DataOutputStream(client.getOutputStream());
		//접속자의 닉네임을 받는다.
		clientNick=readStream.readUTF();
		//내 닉을 보내준다.
		writeStream.writeUTF(serverNick);
		
	}

	/**
	 * 접속자에게 메시지를 보내는 일
	 * 
	 * @throws IOException
	 */
	public void sendMsg() throws IOException {
		// T.F의 값을 가져와서
		String msg = jtf.getText().trim();
		// 스트림에 기록하고
		writeStream.writeUTF(msg);
		// 스트림의 내용을 목적지로 분출
		writeStream.flush();
		jta.append("["+serverNick+"] : " + msg + "\n");
		// 입력이 편하도록 jtf를 초기화
		jtf.setText("");
		jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
	}

	/**
	 * 접속자가 보내오는 메시지를 계속 읽어 들어야 한다.
	 * 
	 * @throws IOException
	 */
	@Override
	public void run() {
		String revMsg = "";
		if (readStream != null) {// 연결이되어있
			try {
				while (true) {
					// 메시지를 읽어들여
					revMsg = readStream.readUTF();
					// 대화창에 출력
					jta.append("["+clientNick+"] : " + revMsg + "\n");
					jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
				}
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(this, clientNick+"접속자가 퇴실하였습니다.");
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
			// thread와 stcs객체를 has a관계로 설정
			Thread t = new Thread(stcs);
			// 메세지를 읽는 코드를 thread로 처리
			t.start();// start에 의해 run 호출
		} catch (SocketException se) {
			System.err.println("접속자가 들어오기 전 종료 " + se.getMessage());
		} catch (IOException ie) {
			JOptionPane.showMessageDialog(stcs, "서버 가동 실패! 메시지를 읽어들일 수 없습니다.");
			ie.printStackTrace();
////		revMsg();

			// //has a : 메세지를 읽는 코드를 Tread 로 처리하면 어디에 있든 동작을 하게 된다.
//	}
		}
	}
}
