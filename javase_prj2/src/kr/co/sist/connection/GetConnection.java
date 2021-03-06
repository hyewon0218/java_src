package kr.co.sist.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton Pattern으로 만드는 클래스<br>
 * DB Connection을 반환하는 일
 * @author SIST
 */
public class GetConnection {
	private static GetConnection gc;
	
	private GetConnection() {
		
	}
	public static GetConnection getInstance() {
		if(gc==null) {
			gc=new GetConnection();
		}
		return gc;
	}
	public Connection getConn(String url, String id, String pass) throws SQLException {
		Connection con=null;
		//1. 드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//2. Connection얻기
		con=DriverManager.getConnection(url, id, pass);
		
		return con;
	}
}
