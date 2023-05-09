package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.UserController;
import dao.DBUtil;
import dto.RankingDto;
import dto.UserDto;

public class UserDao {

	public static UserDto getUserDto(String userId) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserDto dto = new UserDto();

		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT user_no, user_id, top_score, status FROM investment_user WHERE user_id = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				dto.setUserNo(rs.getInt("user_no"));
				dto.setUserId(rs.getString("user_id"));
				dto.setTopScore(rs.getInt("top_score"));
				dto.setStatus(rs.getInt("status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}

		return dto;
	}
	
	public static UserDto getUserDtoByUserNo(int userNo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserDto dto = new UserDto();

		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT user_no, user_id, top_score, status FROM investment_user WHERE user_no = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				dto.setUserNo(rs.getInt("user_no"));
				dto.setUserId(rs.getString("user_id"));
				dto.setTopScore(rs.getInt("top_score"));
				dto.setStatus(rs.getInt("status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}

		return dto;
	}

	public static int signUp(String id, String pw) throws SQLException{

		Connection conn = null;
//		PreparedStatement pstmt1 = null;
//		ResultSet rs = null;
		
		PreparedStatement pstmt2 = null;		

		try {
			conn = DBUtil.getConnection();
			
			try {
				
//				pstmt1 = conn.prepareStatement("select * from investment_user where user_id = ?");
//				pstmt1.setString(1, id);
//				rs = pstmt1.executeQuery();
//				if(rs.next()) {
//					System.out.println("중복된 ID 입니다.");
//					return -1;
//				}else {
//					rs.close();
//					rs = null;
//					pstmt1.close();
//					pstmt1 = null;
//				}
				
				pstmt2 = conn.prepareStatement("insert into investment_user(user_id, user_pw, status) "
												+ "values (?,?,?)");
				pstmt2.setString(1, id);
				pstmt2.setString(2, pw);
				pstmt2.setInt(3, 1);
				
				int result = pstmt2.executeUpdate();
				
				UserDto userDto = getUserDto(id);
				pstmt2.close();
				pstmt2 = null;
				return userDto.getUserNo();
			}catch(Exception e) {
				System.out.println("[Error] ID 중복입니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt2);
		}
	 
		return -1;
	}
	
	public static void convertStatus(String userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		UserDto userDto = new UserDto();
		int status = userDto.getStatus();
		int result;
		if(status==0) result = 1;
		else result = 0;
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("update investment_user set status=? where user_id=?");
			pstmt.setInt(1, result);
			pstmt.setString(2, userId);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pstmt);
		}
		
	}
	
	public static int login(String userId, String userPw) throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select * from investment_user where user_id=?");
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if(rs.getString(3).equals(userPw)) {
					convertStatus(userId);
					return rs.getInt(1);
				}else {
					return -1;
				}
			} else {
				return -1;
			}
		} finally {
			DBUtil.close(conn, pstmt);
		}
	}
	
	// 로그아웃 DAO
	public static boolean logout(int userNo) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("update investment_user set status = 0 where user_no=?");
			pstmt.setInt(1, userNo);

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(conn, pstmt);
		}
		return false;
	}

	public static boolean updateTopScore(int userNo, int topScore) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("update investment_user set top_score=? where user_no=?");
			pstmt.setInt(1, topScore);
			pstmt.setInt(2, userNo);

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(conn, pstmt);
		}
		
		return false;
	}
	
	public static ArrayList<RankingDto> getRanking(int userNo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RankingDto> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select user_id, top_score from investment_user order by top_score desc");
			rset = pstmt.executeQuery();

			list = new ArrayList<RankingDto>();
			while (rset.next()) {
				RankingDto rank = new RankingDto(rset.getString(1), rset.getInt(2));
				list.add(rank);
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	

}