package day1228;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class SimpleServer {

	public SimpleServer() throws IOException {
		
		ServerSocket server=null;
		String msg="���� ��ħ�Ҹ��� �����°�";
		DataOutputStream dos=null;
		DataInputStream dis=null;
		String revMsg="";
		try {
			server=new ServerSocket(3000);
			System.out.println("���� ������"+server);
			while(true) {
				Socket client= server.accept();
				System.out.println("������ ����"+client);
				
				dos= new DataOutputStream(client.getOutputStream());
				dos.writeUTF(msg);
				dos.flush();
				revMsg=dis.readUTF();
				JOptionPane.showMessageDialog(null, "Ŭ���̾�Ʈ�� �޼���\n"+revMsg);
			}
		}finally {
			if(server !=null) server.close();
			if(dos !=null)dos.close();
			if(dis!=null) dis.close();
		}
	}
	
	
	public static void main(String[] args) {
		try {
			new SimpleServer();
		}catch(IOException e) {
			System.out.println("��Ʈ�� �̹� ������Դϴ�.");
			e.printStackTrace();
		}
	}

}
