package model;

public class SearchFavPlayer {
	private int accountId;
	private int playerId;

	public SearchFavPlayer(int accountId, int playerId) {
		this.accountId	 = accountId;
		this.playerId	 = playerId;
	}

	public int getAccountId() 	{return accountId;}
	public int getPlayerId()  	{return playerId;}

}
