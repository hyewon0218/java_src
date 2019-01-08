package day0108;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ZipcodeViewEvt extends WindowAdapter implements ActionListener {

	private ZipcodeVeiw zv;
	
	public ZipcodeViewEvt(ZipcodeVeiw zv) {
		this.zv=zv;
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		zv.dispose();
	}
	

	
	/**
	 * PreparedStatement를 사용하여 SQLIjection방어
	 * @param dong
	 * @return
	 * @throws SQLException
	 */
	public List<ZipcodeVO> selectZipcode(String dong)throws SQLException {
		List<ZipcodeVO> list=new ArrayList<ZipcodeVO>();
		//1. 드라이버로딩
	    try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    
	    Connection con=null;
	    PreparedStatement pstmt=null;
	    ResultSet rs=null;
		
	    try {
	    //2. Connection 얻기
	    	String url="jdbc:oracle:thin:@localhost:1521:orcl";
	    	String id="scott";
	    	String pass="tiger";
	    	con=DriverManager.getConnection(url, id, pass);
		//3. 쿼리문 생성객체 얻기
	    	StringBuilder selectZipcode=new StringBuilder();
	    	selectZipcode
	    	.append(" select zipcode,sido,gugun,dong,nvl(bunji,' ') bunji ")
	    	.append(" from zipcode ")
	    	.append(" where dong like ?||'%'");//홀따옴 주의!
	    	
	    	
	    	System.out.println(selectZipcode);
	    	pstmt=con.prepareStatement(selectZipcode.toString());
	    //4.바인드변수에 값 넣기
	    	pstmt.setString(1, dong);
	    	
		//5. 쿼리 수행 후 결과 얻기
	    	
	    	rs=pstmt.executeQuery();
	    	
	    	ZipcodeVO zv=null;
	    	while(rs.next()) {//조회된 레코드가 존재한다면 
	    		//VO에 값을 할당하고
	    		zv=new ZipcodeVO(rs.getString("zipcode"), rs.getString("sido"), 
	    				rs.getString("gugun"), rs.getString("dong"), rs.getString("bunji"));
	    		//같은 이름의 객체를 여러개 관리하기 위해 LIST 에 추가
	    		list.add(zv);
	    	}
	    	
	    }finally {
		//5. 연결 끊기
	    if (rs!=null) {rs.close();}
	    if (pstmt!=null) {pstmt.close();}
	    if (con!=null) {con.close();}
	    }//end finally
		return list;
	}
	public void searchZipcode(String dong) {
		try {
			//DB에서 조회한 결과를 받아서
			List<ZipcodeVO>listZip=selectZipcode(dong);
			//DefaultTableModel에 추가=> JTable에 반영된다. 
			DefaultTableModel dtm=zv.getDtmZipcode();
			//D.T.M 초기화 
			dtm.setRowCount(0);
            
			String[] rowData=null;
			//조회된 결과를 가지고
			for(ZipcodeVO zv:listZip) {
				//배열에 넣고
				rowData=new String[2];
				rowData[0]=zv.getZipcode();
				rowData[1]=zv.getSido()+" "+zv.getGugun()+" "+zv.getDong()+" "+zv.getBunji();
				
				
				//D.T.M에 행(Row : 우편번호, 주소) 추가
				dtm.addRow(rowData);
			}
			if( listZip.isEmpty() ) {
				rowData=new String[2];
				rowData[0]="";
				rowData[1]="해당 동은 존재하지 않습니다.";
				
				dtm.addRow(rowData);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(zv, "DB에서 문제가 발생");
			e.printStackTrace();
			
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String dong=zv.getJtfDong().getText().trim();
		if(!dong.equals("")) {
			searchZipcode(dong);
		}
	}

}
