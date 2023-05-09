package view;

import java.sql.Connection;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import controller.UserController;
import dao.DBUtil;

public class StartView {

	/*
	 * 첫 화면 뷰 출력
	 */
	public static void printStartView() {
		System.out.println("\n===== TQQQ, SQQQ 모의 투자 프로그램 =====\n");
		System.out.println("[1] 로그인");
		System.out.println("[2] 회원가입");
		System.out.print(">> ");
	}

	/*
	 * 로그인 뷰 출력
	 * UserController의 로그인 로직 수행 후
	 * return userNo
	 */
	public static void printLogInView() {
		Scanner sc = new Scanner(System.in);
		int userNo = -1;

		while (true) {
			System.out.println("===== 로그인 =====\n");
			System.out.print("ID : ");
			String id = sc.next();
			System.out.print("PW : ");
			String pw = sc.next();

			userNo = UserController.login(id, pw);

			// 반환값이 -1이 아닌 경우 (로그인에 성공한 경우)
			if (userNo != -1) {
				MainView.mainView(userNo);
				break;
			}
			
			errorView("로그인에 실패했습니다.");
		}
		sc.close();
	}

	/*
	 * 회원가입 뷰 출력
	 * UserController의 회원가입 로직 수행 후
	 * return userNo
	 */
	public static void printSignUpView() {
		Scanner sc = new Scanner(System.in);
		int userNo = -1;

		while (true) {
			System.out.println("===== 회원가입 =====\n");
			System.out.print("ID : ");
			String id = sc.next();
			System.out.print("PW : ");
			String pw = sc.next();

			userNo = UserController.signUp(id, pw);
			// 반환값이 -1이 아닌 경우 (회원가입에 성공한 경우)
			if (userNo != -1) {
				MainView.mainView(userNo);
				break;
			}
			
			errorView("회원가입에 실패했습니다.");
		}
		sc.close();
	}
	
	public static void errorView(String error) {
		System.out.println("[Error] " + error + "\n");
	}

	public static void startView() {
		int userInput = 0;

		while (true) {
			printStartView();
			try{
				Scanner sc = new Scanner(System.in);
				userInput = sc.nextInt();

				System.out.println();
				if (userInput == 1) {
					printLogInView();
					System.out.println();
					break;
				} else if (userInput == 2) {
					printSignUpView();
					System.out.println();
					
					break;
				} else {
					errorView("1 또는 2를 입력해주세요.");
					continue;
				}
			} catch (InputMismatchException e) {
				errorView("1 또는 2를 입력해주세요.");
				continue;
			} catch (NoSuchElementException e) {
				errorView("1 또는 2를 입력해주세요.");
				continue;
			}
		}
	}
	
	public static void main(String[] args) {
		startView();
	}
}
