package model;

public class FavoritePlayer {
	private int fpId;
	private int accountId;
	private int teamId;
	private int posiId;
	private int playerId;
	private String name;

	public FavoritePlayer(int fpId, int accountId, int playerId) {
		this.fpId		 = fpId;
		this.accountId	 = accountId;
		this.playerId	 = playerId;
	}

	public FavoritePlayer(int fpId, int accountId, int teamId, int posiId, int playerId, String name) {
		this.fpId		 = fpId;
		this.accountId	 = accountId;
		this.teamId		 = teamId;
		this.posiId		 = posiId;
		this.playerId	 = playerId;
		this.name	 = name;
	}

	public FavoritePlayer(int accountId, int playerId) {
		this.accountId	 = accountId;
		this.playerId	 = playerId;
	}

	public int getFpId()  		{return fpId;}
	public int getAccountId() 	{return accountId;}
	public int getTeamId() 		{return teamId;}
	public int getPosiId() 		{return posiId;}
	public int getPlayerId()  	{return playerId;}
	public String getName()  		{return name;}
}