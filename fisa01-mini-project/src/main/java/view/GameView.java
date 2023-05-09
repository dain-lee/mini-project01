package view;

import java.sql.SQLException;

import controller.GameController;
import dao.UserDao;
import dto.UserDto;

public class GameView {

	static int TQQQ;
	static int SQQQ;
	
	public void startGame(int choiceUserNo) {
		GameController controller = new GameController();
		UserDto userDto = UserDao.getUserDtoByUserNo(choiceUserNo);
		
		int userNo = userDto.getUserNo();
		String userId = userDto.getUserId();
		int topScore = userDto.getTopScore();
		int status = userDto.getStatus();
		
		TQQQ = 10000;
		SQQQ = 10000;
		int day = 1;
		
		int money = 100000;
		
		int countTq = 0;
		int countSq = 0;
		
		System.out.println("\n===== 모의 투자 프로그램 =====");
		do {
			int choice = controller.showStatus(userDto, 
					countTq, countSq,
					TQQQ, SQQQ, money, day);

			if(choice == 1) {
				int num = controller.buyTQ(money, TQQQ);
				countTq += num;
				money -= (num*TQQQ);
				
			}else if(choice == 2) {
				int num = controller.sellTQ(countTq);
				countTq -= num;
				money += (num*TQQQ);
				
			}else if(choice == 3) {
				int num = controller.buySQ(money, SQQQ);
				countSq += num;
				money -= (num*SQQQ);
				
			}else if(choice == 4) {
				int num = controller.sellSQ(countSq);
				countSq -= num;
				money += (num*SQQQ);
				
			}else if(choice == 5) {
				day++;
				
				if (day > GameController.MAX_DAY) {
					int total = money + (TQQQ*countTq) + (SQQQ*countSq);
					System.out.println("[System] 모든 턴이 종료되었습니다.");
					
					System.out.println("[System] 최종 총액 : " + total);
					if (total > topScore) {
						System.out.println("[System] 축하합니다. 최고 기록입니다!");
						try {
							UserDao.updateTopScore(userNo, total);
						} catch (SQLException e) {
							System.out.println("[Error] 기록 저장에 실패했습니다.");
						}
					}
					System.out.println("[System] 메인으로 돌아갑니다.");
					MainView.mainView(userNo);
					return;
				}
				
				System.out.println("[System] 다음날로 넘어갑니다.");
				double rand = Math.round((Math.random() - 0.5) * 10.0) / 10.0;
				
				TQQQ = (int)(TQQQ*(1+rand));
				SQQQ = (int)(SQQQ*(1-rand));
			}else if(choice == 99) {
				System.out.println("[System] 메인으로 돌아갑니다.");
				MainView.mainView(userNo);
				return;
			}else {
			}
			
		}while(day<6);
	}
}
