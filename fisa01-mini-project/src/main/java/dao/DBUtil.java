package dao;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//사용자 정의로 Connection  객체 반환 메소드 
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost/fisa?characterEncoding=UTF-8&serverTimezone=UTC";
		String id = "root";
		String pw = "whfdjqakfuqek!96"; //try 블록내에서만 사용 가능한 로컬 변수
		
		 return DriverManager.getConnection(url, id, pw);
	}
	
	//사용자 정의로 자원반환 메소드
	//DQL용
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
				rs = null; //gc에게 사용 안 함을 인지
			}
			if(stmt != null) {
				stmt.close();
				stmt = null;
			}
			if(conn != null) {
				conn.close();
				conn = null;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//DML 자원반환용 메소드
	public static void close(Connection conn, Statement stmt) {
		try {			
			if(stmt != null) {
				stmt.close();
				stmt = null;
			}
			if(conn != null) {
				conn.close();
				conn = null;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}