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
		String msg="누가 기침소리를 내었는가";
		DataOutputStream dos=null;
		DataInputStream dis=null;
		String revMsg="";
		try {
			server=new ServerSocket(3000);
			System.out.println("서버 가동중"+server);
			while(true) {
				Socket client= server.accept();
				System.out.println("접속자 있음"+client);
				
				dos= new DataOutputStream(client.getOutputStream());
				dos.writeUTF(msg);
				dos.flush();
				revMsg=dis.readUTF();
				JOptionPane.showMessageDialog(null, "클라이언트의 메세지\n"+revMsg);
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
			System.out.println("포트가 이미 사용중입니다.");
			e.printStackTrace();
		}
	}

}
