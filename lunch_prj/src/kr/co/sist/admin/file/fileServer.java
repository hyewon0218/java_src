package kr.co.sist.admin.file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;


import kr.co.sist.lunch.admin.run.LunchAdminMain;

public class fileServer extends Thread {

	@Override
	public void run() {
		ServerSocket server=null;
		try {
			try {
				server=new ServerSocket(25000);
				Socket client=null;
				DataInputStream dis=null;
				int cnt=0;
				String[] fileNames=null;
				String[] serverFileNames=null;
				
				List<String> tempFileList=new ArrayList<String>();
				
				DataOutputStream dos=null;
				while(true) {
//					System.out.println("서버가동");
					client=server.accept();
//					System.out.println("접속자 있음");
					
					
					dis=new DataInputStream(client.getInputStream());
					
					cnt=dis.readInt();//클라이언트가 보내오는 파일명의 수 
					fileNames=new String[cnt];
					
					for(int i=0; i < cnt; i++) {
						fileNames[i]=dis.readUTF();
//						System.out.println(i+"번째 파일"+fileNames[i]);
					}
					//서버에 존재하는 파일명을 배열로 복사
					serverFileNames=new String[LunchAdminMain.lunchlmgList.size()];
					LunchAdminMain.lunchlmgList.toArray(serverFileNames);
//					System.out.println("서버 "+Arrays.toString(serverFileNames));
//					System.out.println("클라이언트 "+Arrays.toString(serverFileNames));
					
//					
					
//					boolean flag=false;
//					List<String> list=new ArrayList<String>();
//					for(int i=0; i <serverFileNames.length; i++) {
//						for(int j=0; j <fileNames.length; j++) {
//							if(serverFileNames[i].equals(fileNames[j])) {
//								flag=true;
//								break;
//							}
//						}
//					
//						if(flag==false) {//중복된 값이 없다.
//							list.add(serverFileNames[i]);
//						}
//					}
//					System.out.println(list);
					
					
//					클라이언트가 보내온 파일명과 서버의 파일명을 비교하여 
//					클라이언트가 없는 파일명을 출력
					for(String tName : LunchAdminMain.lunchlmgList) {
						tempFileList.add(tName);
						tempFileList.add("s_"+tName);
					}//end for
					
					for(String rmName : fileNames) {
						tempFileList.remove(rmName);/////////////////////////////
						tempFileList.remove("s_"+rmName);
					}//end if
					
					dos=new DataOutputStream(client.getOutputStream());
					dos.writeInt(tempFileList.size());//전송할 파일의 개수를 보냄
//					
					for(String fName : tempFileList) {
						fileSend(fName, dos);
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}//end for
					
//					System.out.println("없는파일"+tempFileList);
				}//end while 
				
			}finally {
				if(server !=null) {server.close();}
			}//end finally
		}catch (IOException ie) {
			JOptionPane.showMessageDialog(null, "파일 보내기 실패 ");
			ie.printStackTrace();
		}
	}//run
	
	private void fileSend(String fName, DataOutputStream dos)throws IOException {////////////////////
		FileInputStream fis=null;
		
		
		try {
			int fileData=0;
			
			fis=new FileInputStream("C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/"+fName);
			byte[] readData=new byte[512];
			
			int fileLen=0;
			
			while((fileLen=fis.read(readData))!=-1) {
				fileData++;
			}//end while
			
			fis.close();
			dos.writeInt(fileData);//조각
			dos.flush();
			
			dos.writeUTF(fName);//writeUTF
//			dos.flush();
			
			fis=new FileInputStream("C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/"+fName);/////////////
			while((fileLen=fis.read(readData))!=-1) {
				dos.write(readData,0,fileLen);
				fileData--;
				
			}//end while
			dos.flush();
			
		}finally {
			if(fis!=null) {fis.close();}
			
		}
		
		
	}//fileSend
	
}//class









