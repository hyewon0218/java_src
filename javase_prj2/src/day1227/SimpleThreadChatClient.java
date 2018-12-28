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

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Thread�� ����Ͽ� ���Ϸ����� �޼����� �о���̴� �ڵ带 
 * ȭ�� �����ΰ� �޼����� ������ �ڵ�� ���ÿ� �����Ų��. 
 * @author SIST
 */
@SuppressWarnings("serial")
public class SimpleThreadChatClient extends JFrame implements ActionListener,Runnable {
	
	private JTextArea jta;
	private JTextField jtf;
	private JScrollPane jsp;
	
	private Socket client; // ������ �����ϱ� ����
	private DataInputStream readStream; // ������ �����͸� �б����� ��Ʈ��
	private DataOutputStream writeStream; // ������ �����͸� ���������� ��Ʈ��
	
	private String serverNick;//������ ��ȭ��
	private String clientNick;//Ŭ���̾�Ʈ�� ��ȭ��
	
	public SimpleThreadChatClient() {
		super(":::::::ä��Ŭ���̾�Ʈ:::::::");
		
		jta = new JTextArea();
		jta.setBorder(new TitledBorder("��ȭ����"));
		jta.setEditable(false);
		jta.setLineWrap(true);
		jta.setWrapStyleWord(true);
		
		jsp = new JScrollPane(jta);
		
		
		jtf = new JTextField();
		jtf.setBorder(new TitledBorder("��ȭ�Է�"));
		
		add("Center", jsp);
		add("South", jtf);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}
			@Override
			public void windowClosed(WindowEvent we) {
					try {
						close();
						System.exit(0);
					} catch (IOException ie) {
						ie.printStackTrace();
					}
			}
		});
		

		setBounds(400, 200, 300, 400);
		setVisible(true);
		jtf.requestFocus();
		
//		try {
//			this.connectToServer();
////			this.revMsg();
//			//Thread�� ���� Ŭ������ has a
//			Thread t=new Thread(this);
//			//Thread ����
//			t.start();
//		} catch (IOException ie) {
//			ie.printStackTrace();
//		}
		jtf.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			sendMsg();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
	
	public void close() throws IOException {
		try {
			if (readStream != null) { readStream.close(); }
			if (writeStream != null) { writeStream.close(); }
		} finally {
			if (client != null) { client.close(); }
		}
	}

	/**
	 * 2. ������ �����Ͽ� ������ �����ϰ� 
	 * ��ȭ�� �аų� ������ ���� 4.��Ʈ���� �����Ѵ�.
	 * @throws IOException
	 */
	public void connectToServer() throws IOException {
		clientNick=JOptionPane.showInputDialog("��ȭ�� �Է�");
		// 2.
		client = new Socket("211.63.89.149", 65535);
		// 4. ��Ʈ�� ����
		readStream = new DataInputStream(client.getInputStream());
		writeStream = new DataOutputStream(client.getOutputStream());
		
		//������ ��ȭ�� ���� 
		writeStream.writeUTF(clientNick);
		jta.setText("��ȭ�濡 \""+clientNick+"\"���� �����ϼ̽��ϴ�.\n");
		//������ ��ȭ���� ����
		readStream.readUTF();
	}
	
	/**
	 * �������� �������� �޽����� ���ѷ����� �о� ���δ�.
	 */
	@Override
	public void run() {
		String revMsg = "";
		if(readStream !=null) {
			try {
				while(true) {
				revMsg = readStream.readUTF();
				// ��ȭâ�� �о���� �޽����� ���
				jta.append("[+serverNick+] : "+revMsg+"\n");
				//�޼��� T.A�� �߰��Ǹ� JScollPane�� ��ũ�ѹ��� ���� 
				//J.S.P�� �ְ����� �������ش�.
				jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
				
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, serverNick+"�� ����Ͽ����ϴ�.");
				e.printStackTrace();
			}
		}
		}
	
	
	/**
	 * �ۼ��� �޽����� ������ ������ ��
	 */
	public void sendMsg() throws IOException {
		// �ۼ��� �޽����� �����ͼ�
		String sendMsg = jtf.getText().trim();
		// ��Ʈ���� ����ϰ�
		writeStream.writeUTF(sendMsg);
		// ��Ʈ���� ������ �������� ����
		writeStream.flush();
		// �ۼ��� �޽����� ä��â�� �ø���.
		jta.append("["+clientNick+"] : "+sendMsg+"\n");
		// TextField�� ������ �����Ѵ�.
		jtf.setText("");
		jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
	}

	public static void main(String[] args) {
		SimpleThreadChatClient stcc=new SimpleThreadChatClient();
		try {
			stcc.connectToServer();
			//�޼����� ���ÿ� �о���ϱ� ������ thread�� ó��
			Thread t=new Thread(stcc);
			t.start();
		} catch (IOException ie) {
			ie.printStackTrace();
	}
//		new SimpleThreadChatClient();
//			this.connectToServer();
////			this.revMsg();
//			//Thread�� ���� Ŭ������ has a
//			//Thread ����
//		}
//		jtf.addActionListener(this);
			
	}
}
