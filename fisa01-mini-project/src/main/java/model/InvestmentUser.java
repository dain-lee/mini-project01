package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InvestmentUser {
	private int userNo;
	private String userId;
	private String userPw;
	private int topScore;
	private int status;
	
	public void setTopScore(int topScore) {
		this.topScore = topScore;
	}
	public void setStatus(int status) {
		this.status = status;
	}

}
