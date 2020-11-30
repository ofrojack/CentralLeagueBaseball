package model;

public class SearchFavTeam {
	private int accountId;
	private int teamId;

	public SearchFavTeam(int accountId, int teamId) {
		this.accountId	 = accountId;
		this.teamId	 = teamId;
	}

	public int getAccountId() 	{return accountId;}
	public int getTeamId()  	{return teamId;}

}
