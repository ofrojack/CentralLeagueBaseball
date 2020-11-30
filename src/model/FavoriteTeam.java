package model;

public class FavoriteTeam {
	private int ftId;
	private int accountId;
	private int teamId;
	private String name;
	private String homeaddress;
	private String homestadium;
	private String mapurl;

	public FavoriteTeam(int ftId, int accountId, int teamId) {
		this.ftId		 = ftId;
		this.accountId	 = accountId;
		this.teamId	 = teamId;
	}

	public FavoriteTeam(int ftId, int accountId, int teamId, String name, String homeaddress, String homestadium, String mapurl) {
		this.ftId		 = ftId;
		this.accountId	 = accountId;
		this.teamId	 = teamId;
		this.name	 = name;
		this.homeaddress	 = homeaddress;
		this.homestadium	 = homestadium;
		this.mapurl	 = mapurl;
	}

	public FavoriteTeam(int accountId, int teamId) {
		this.accountId	 = accountId;
		this.teamId	 = teamId;
	}

	public int getFtId()  			{return ftId;}
	public int getAccountId() 		{return accountId;}
	public int getTeamId()  		{return teamId;}
	public String getName()  		{return name;}
	public String getHomeaddress() 	{return homeaddress;}
	public String getHomestadium()  {return homestadium;}
	public String getMapurl()  		{return mapurl;}

}
