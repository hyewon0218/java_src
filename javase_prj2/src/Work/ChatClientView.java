package Work;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientView extends JFrame {
	
	private JTextArea taNick, taChatDisplay;
	private JTextField tfTalk;
	private JButton btnConnect, btnCapture, btnClose, btnUser;
	private JLabel lblNick;
	
	private JScrollPane jsp;
	
	public ChatClientView () {
		super("ä�� Ŭ���̾�Ʈ");	
		
		lblNick =new JLabel("��ȭ��");
		taNick=new JTextArea();
		btnConnect=new JButton("����");
		btnCapture=new JButton("������");
		btnClose=new JButton("����");
		btnUser=new JButton("������");
		
		
		taChatDisplay=new JTextArea();
		jsp=new JScrollPane(taChatDisplay);
		
		tfTalk=new JTextField();
		
		
		Panel panelNorth=new Panel();
		panelNorth.setLayout(new GridLayout(1, 6));
		panelNorth.add(lblNick);
		panelNorth.add(taNick);
		panelNorth.add(btnConnect);
		panelNorth.add(btnCapture);
		panelNorth.add(btnClose);
		panelNorth.add(btnUser);
		
		setLayout(new BorderLayout());
		add("North",panelNorth);
		add("Center", jsp);
		add("South", tfTalk);
//		add(jsp);
		
		setBounds(300, 300, 500 ,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new ChatClientView();
		
	
	}
	

}
