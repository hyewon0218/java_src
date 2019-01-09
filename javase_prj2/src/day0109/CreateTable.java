package day0109;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.connection.GetConnection;

/**
 * DDL (Data Definition Language) : create, drop, truncate 을 사용하여 
 * 테이블을 생성
 * @author SIST
 */
public class CreateTable {

	public CreateTable() throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
		//1. 
		//2.
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=GetConnection.getInstance().getConn(url, id, pass);
		//3,4,5여러번일어날수있음	
			String tableName=JOptionPane.showInputDialog("생성할 테이블 명 입력");
			
		//3. //테이블이 존재하는지? 
			StringBuilder selectTname=new StringBuilder();
			selectTname.append("select tname from tab where tname=?");//오라클 : upper(?)도 가능
		//4.	
			pstmt=con.prepareStatement(selectTname.toString());
			pstmt.setString(1, tableName.toUpperCase());//테이블네임대문자
		//5.	
			rs=pstmt.executeQuery();
			boolean flag=false;
			if(rs.next()) {
				flag=JOptionPane.showConfirmDialog(null, 
						tableName+"테이블이 존재합니다. 삭제한 후 생성하시겠습니까?")
						==JOptionPane.OK_OPTION;//ok면 true 나머지 false
			}
			pstmt.close();//메모리가 셀수도있기때문에 끊고 밑에 3번에서 새로! 
			
			if(flag) {//삭제한 후 테이블 생성
				//3. 
				StringBuilder dropTable=new StringBuilder();
				dropTable.append("drop table ").append(tableName);//테이블명바인드변수안됨
				pstmt=con.prepareStatement(dropTable.toString());
				//4. 
				pstmt.execute();
				
				pstmt.close();
			}
		//3.
			StringBuilder createTable=new StringBuilder();
			
			createTable
			.append("	 create table ").append( tableName).append("(")
			.append(" name varchar2(12) not null, ")
			.append("	 age number(13) not null, ")
			.append("	 id varchar2(20) constraint pk_").append(tableName).append(" primary key)");
			
			pstmt=con.prepareStatement(createTable.toString());
		//4.
			
		//5.
			pstmt.execute();//예외처리
			JOptionPane.showMessageDialog(null, "테이블이 생성되었습니다.");
		}finally {
		//6.
			if(rs!=null) {rs.close();} 	
			if(pstmt!=null) {pstmt.close();} 	
			if(con!=null) {con.close();}	
		}
	}
	
	public static void main(String[] args) {
		try {
			new CreateTable();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "테이블이 이미 존재합니다.");
			e.printStackTrace();
		}
	}//main

}//class
