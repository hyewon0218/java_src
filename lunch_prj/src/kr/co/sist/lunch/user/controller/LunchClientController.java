package kr.co.sist.lunch.user.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.lunch.user.model.LunchClientDAO;
import kr.co.sist.lunch.user.view.LunchClientView;
import kr.co.sist.lunch.user.view.LunchOrderDetailView;
import kr.co.sist.lunch.user.vo.LunchDetailVO;
import kr.co.sist.lunch.user.vo.LunchListVO;
import kr.co.sist.lunch.user.vo.OrderInfoVO;
import kr.co.sist.lunch.user.vo.OrderListVO;

public class LunchClientController extends WindowAdapter implements ActionListener, MouseListener{

	private LunchClientView lcv;
	private LunchClientDAO lc_dao;
	public static final int DBL_CLICK=2;
	
	
	public LunchClientController(LunchClientView lcv) {
		this.lcv=lcv;
		lc_dao=LunchClientDAO.getInstance();
		
		try {
			String[] fileName=lunchImageList();//클라이언트가 가진 이미지를 체크하여
			lunchImageSend(fileName);//서버로 보내 없는 이미지를 받은 후 
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		setLunchList();//JTable을 갱신
	}//LunchClientController
	
	/**
	 * 도시락 목록을 조회하여 JTable에 설정하는 일
	 * 특장점은 25자 이상이라면 24자까지만 출력하고 나머지는 ...으로 붙여서 설정한다.
	 */
	private void setLunchList() {
		//도시락 목록 조회
		try {
			List<LunchListVO> list=lc_dao.selectLunchList();
			
			DefaultTableModel dtm=lcv.getDtmLunchList();
			dtm.setRowCount(0);
			
			Object[] rowData=null;
			
			LunchListVO llvo=null;
			String spec="";
			for(int i=0; i <list.size(); i++) {
				llvo=list.get(i);//방에있는거하나꺼내오기
				//테이블에 추가할 데이터 생성
				rowData=new Object[5];
				rowData[0]=new Integer(i+1);
				rowData[1]=new ImageIcon("C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/user/img/s_"+llvo.getImg());
				rowData[2]=llvo.getLunchCode();
				rowData[3]=llvo.getLunchName();
//				rowData[4]=llvo.getLunchSpec();
				spec=llvo.getLunchSpec();
				if(spec.length()>25) {
					spec=spec.substring(0, 24)+"...";
				}//end if
				rowData[4]=spec;
					
				//생성된 데이터를 테이블에 추가
				dtm.addRow(rowData);
				
			}
			
		} catch (SQLException e) {
			msgCenter(lcv, "도시락목록을 조회하는 중 DB에서 문제 발생");
			e.printStackTrace();
		}
	}//setLunchList
	
	private void msgCenter(Component comp, String msg) {
		JOptionPane.showMessageDialog(comp, msg);
	}//msgCenter
	
	@Override
	public void windowClosing(WindowEvent e) {
		lcv.dispose();
	}
	@Override
	public void windowClosed(WindowEvent e) {
		System.exit(JFrame.ABORT);
	}
	@Override
	public void mouseClicked(MouseEvent me) {
		if(lcv.getJtp().getSelectedIndex()==0) {
			lcv.setTitle("재찬 도시락 주문");			
		}//end if
		if(lcv.getJtp().getSelectedIndex()==1) {
			lcv.setTitle("재찬 도시락 주문 조회");
		}//end if
		
		if(me.getSource() ==lcv.getJtLunch()) {
		switch(me.getClickCount()) {
		case DBL_CLICK:
			JTable jt=lcv.getJtLunch();
			String lunch_code=(String)jt.getValueAt(jt.getSelectedRow(), 2);
			//도시락의 상세정보 조회 
			try {
				LunchDetailVO ldvo=lc_dao.selectDetailLunch(lunch_code);
				if(ldvo==null) {//코드로 조회된 결과가 없을 때
					msgCenter(lcv, lunch_code+"로 조회된 도시락이 없습니다.");
				}else {//코드로 조회된 결과가 있을 때
					new LunchOrderDetailView(lcv, ldvo);
				}
			} catch (SQLException se) {
				msgCenter(lcv, "상세정보 조회시 문제 발생!!");
				se.printStackTrace();
			}
			
			
//			System.out.println(lunch_code);
//			JOptionPane.showMessageDialog(lcv, "");
			}//end switch
		}//end if
		
		
		
	}//mouseClicked
	
	/**
	 * 주문자명과 전화번호를 가지고 도시락을 조회 
	 */
	private void searchLunchOrder() {
		JTextField jtfName=lcv.getJtfName();
		String name=jtfName.getText().trim();
		if(name.equals("")) {
			msgCenter(lcv, "주문자명은 필수 입력!!!");
			jtfName.setText("");
			jtfName.requestFocus();
			return;
		}//end if
		
		JTextField jtfTel=lcv.getJtfTel();
		String tel=jtfTel.getText().trim();
		if(name.equals("")) {
			msgCenter(lcv, "전화번호는 필수 입력!!!");
			jtfTel.setText("");
			jtfTel.requestFocus();
			return;
		}//end if
		
		
		
		
		try {
			//입력값을 사용하여 DB Table조회
			List<OrderListVO> list=lc_dao.selectOrderList(new OrderInfoVO(name, tel));
			//JTable 출력
			DefaultTableModel dtmOrderList=lcv.getDtmOrderList();
			dtmOrderList.setRowCount(0);
			
			String[] rowData=null;
			
			OrderListVO olv=null;
			for(int i=0; i < list.size(); i++) {
				olv=list.get(i);
				rowData=new String[4];
				rowData[0]=String.valueOf(i+1);
				rowData[1]=olv.getLunchName();
				rowData[2]=olv.getOrderDate();
				rowData[3]=String.valueOf(olv.getQuan());
				
				dtmOrderList.addRow(rowData);///
			}//end for
			
			if(list.isEmpty()) {
				msgCenter(lcv, "입력한 정보로 조회된 결과가 없습니다.");
			}else{
				lcv.setTitle("재찬도시락 - 조회 [ "+ name+ " 님의 주문현황]");
			}//end if
			
			jtfName.setText("");
			jtfTel.setText("");
			jtfName.requestFocus();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==lcv.getJtfName()) {
			lcv.getJtfTel().requestFocus();
		}//end if
		if(ae.getSource()== lcv.getJbtSearch() || ae.getSource()==lcv.getJtfTel()) {
			//주문한 도시락 목록 조회 
			searchLunchOrder();
		}//end if
	}
	
	/**
	 * 서버로 이미지를 보내고 없는 이미지를 받는 일 
	 * @param fileName
	 */
	private void lunchImageSend(String[] fileNames) throws IOException{
		Socket socket=null;
		DataOutputStream dos=null;
		DataInputStream dis=null;
		
		try {
			socket=new Socket("211.63.89.155", 25000);
			dos=new DataOutputStream(socket.getOutputStream());
			dos.writeInt(fileNames.length);
			
			for(int i=0; i < fileNames.length;i++) {
				dos.writeUTF(fileNames[i]);//서버로 전송
			}
			dos.flush();
			
			dis=new DataInputStream(socket.getInputStream());
			//서버가 보내오는 파일의 갯수 저장
			int fileCnt=dis.readInt();
			
			String fileName="";
			int fileSize=0;
			int filelLen=0;
			FileOutputStream fos=null;//
			
			for(int i=0; i<fileCnt; i++) {
				//전달받을 파일조각의 갯수
				fileSize=dis.readInt();
				//파일명 받기
				fileName=dis.readUTF();
				
				fos=new FileOutputStream("C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/user/img/"+fileName);
				byte[] readData=new byte[512];
				
				
				while(fileSize > 0) {
					
					filelLen=dis.read(readData);//서버에서 전송한 파일조각을 읽어들여 
					fos.write(readData,0,filelLen);//생성한 파일로 기록 
					fos.flush();
					fileSize--;
					
				}//end while
				
				
			}//end for
			
		}finally {
			if(dos!=null) {dos.close();}///////////
			if(socket!=null) {socket.close();}
		}
	}//lunchImageSend

	/**
	 * 도시락 이미지 리스트  
	 */
	private String[] lunchImageList() {
		String[] fileList=null;
		String path="C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/user/img";
				
		File dir=new File(path);
		fileList=dir.list();
		
		//큰 이미지(s_ 가 붙지 않은)만 배열에 넣으세요!!!!!
		List<String> list=new ArrayList<>();
		for(String f_name: dir.list()) {
			if(!f_name.startsWith("s_")) {
				list.add(f_name);
			}//end if
		}//end for
		fileList=new String[list.size()];
		list.toArray(fileList);
		System.out.println(Arrays.toString(fileList));
		
		return fileList;
	}//lunchImageList
	
	public LunchClientController() {
		
	}
	
//	public static void main(String[] args) {
//		new LunchClientController().lunchImageList();
//	}
	
	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}


}















