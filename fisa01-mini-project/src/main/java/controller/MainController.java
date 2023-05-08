package controller;

import java.sql.SQLException; 
import java.util.ArrayList;
import java.util.Scanner;

import dao.UserDao;
import dto.RankingDto;
import view.MainView;
import view.RankingView;

/*
 * 랭킹보기
 * 게임실행
 * 첫 화면
 */
public class MainController {
	
	public static void getRanking(int user_no) throws SQLException {
		ArrayList<RankingDto> list = UserDao.getRanking(user_no);
		
		System.out.println("\n===== 랭킹 조회 =====\n");
		if (list == null) {
			System.out.println("[Error] 조회 내역이 없습니다.\n");
			MainView.mainView(user_no);
		} else {
			RankingView.showRanking(list);
			System.out.println("\n[System] 메인페이지로 돌아가시려면 아무 키를 눌러주세요.\n");
			System.out.print(">> ");
			Scanner sc = new Scanner(System.in);	
			int input = sc.nextInt();
			if(input==1){
				MainView.mainView(user_no);
			}
		}
	}
}