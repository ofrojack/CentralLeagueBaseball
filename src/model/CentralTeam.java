package model;

public class CentralTeam {
	private int teamId;
	private String name;
	private int game;
	private int win;
	private int lose;
	private int draw;
	private float gb;
	private String homeStadium;
	private String homeAddress;
	private String mapUrl;

	public CentralTeam(int teamId, String name, int game, int win, int lose,
			int draw, float gb, String homeStadium, String homeAddress, String mapUrl) {
		this.teamId			 = teamId;
		this.name	  	 = name;
		this.game 		 = game;
		this.win 	 	 = win;
		this.lose 		 = lose;
		this.draw 		 = draw;
		this.gb	 	 	 = gb;
		this.homeStadium = homeStadium;
		this.homeAddress = homeAddress;
		this.mapUrl = mapUrl;

	}
	public int getTeamId()  		 {return teamId;}
	public String getName()  		 {return name;}
	public int getGame()   			 {return game;}
	public int getWin() 			 {return win;}
	public int getLose()  			 {return lose;}
	public int getDraw()   			 {return draw;}
	public float getGb()   			 {return gb;}
	public String getHomeStadium()   {return homeStadium;}
	public String getHomeAddress()   {return homeAddress;}
	public String getMapUrl()		 {return mapUrl;}
}
