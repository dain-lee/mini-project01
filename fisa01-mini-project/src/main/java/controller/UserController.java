package controller;

import java.sql.SQLException;

import dao.UserDao;
import view.StartView;

/*
 * 회원가입
 * 로그인
 * 로그아웃
 */
public class UserController {

	public static int signUp(String id, String pw) {
		try {
			return UserDao.signUp(id, pw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static int login(String id, String pw) {
		try {
			return UserDao.login(id, pw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	// 로그아웃 Ctrl
	public static void logout(int userNo) {
		try {
			boolean result = UserDao.logout(userNo);
			if (result == true) {
				StartView.startView();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			StartView.errorView("[Error] 로그아웃에 실패했습니다.");
		}
	}
}