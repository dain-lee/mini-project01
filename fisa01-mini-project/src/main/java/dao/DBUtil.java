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
	
	 
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost/fisa?characterEncoding=UTF-8&serverTimezone=UTC";
		String id = "root";
		String pw = "whfdjqakfuqek!96";
		
		 return DriverManager.getConnection(url, id, pw);
	}
	
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
				rs = null;
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