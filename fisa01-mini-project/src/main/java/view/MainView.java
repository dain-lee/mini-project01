package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.MainController;
import controller.UserController;

public class MainView {
	public static void mainView(int userNo) {
		
		
		
		do {
			System.out.println("\n===== 메인 화면 =====\n");
			System.out.println("[1] 모의투자 시작");
			System.out.println("[2] 랭킹 조회");
			System.out.println("[3] 로그아웃");
			System.out.print(">> ");
					
			
			try {
				Scanner sc = new Scanner(System.in);
				int n = sc.nextInt();
				if (n == 1) {
					GameView game = new GameView();
					game.startGame(userNo);
				} else if (n == 2) {
					try{
						MainController.getRanking(userNo);
					}catch(InputMismatchException e) {
						continue;
					}
				} else if (n == 3) {
					UserController.logout(userNo);
				} else {
					System.out.println("[Error] 1, 2, 3 중 입력해주세요.");
					mainView(userNo);
				}
			}catch (InputMismatchException e) {
				System.out.println("[System] 잘못된 입력입니다.");
				continue;
			}catch (Exception e) {
				e.printStackTrace();
			}
		}while(true);
		
		

	}
}