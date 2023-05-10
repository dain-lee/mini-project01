package view;

import java.util.ArrayList;

import dto.RankingDto;

public class RankingView {
	
	public static void main() {
		System.out.println();
	}

	public static void showRanking(ArrayList<RankingDto> list) {
		int listSize = list.size();
		
		if(listSize !=0) {
			int cnt = 1;
			
			for(RankingDto r : list) {
				System.out.println((cnt++) + ". " + r.getUserId() + " " + r.getTopScore());
			}
			
		}
	}
}