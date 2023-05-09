package dto;

public class RankingDto {
	private String userId;
	private int topScore;
	
	
	public RankingDto(String userId, int topScore) {
		super();
		this.userId = userId;
		this.topScore = topScore;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getTopScore() {
		return topScore;
	}
	public void setTopScore(int topScore) {
		this.topScore = topScore;
	}
	
	
}