package model;

public class BatterRecord {;
	private int batterId;
	private int playerId;
	private int teamId;
	private String name;
	private int year;
	private String avg;
	private int g;
	private int pa;
	private int ab;
	private int h;
	private int hr;
	private int rbi;
	private int so;
	private int fdb;
	private int sb;
	private String obp;
	private String scpos;
	private int e;
	private String ops;


	public BatterRecord(int batterId, int playerId, int teamId, String name, int year, String avg, int g, int pa, int ab, int h,
			int hr, int rbi, int so, int fdb, int sb, String obp, String scpos, int e, String ops) {
		this.batterId	= batterId;
		this.playerId	= playerId;
		this.teamId		= teamId;
		this.name		= name;
		this.year		= year;
		this.avg		= avg;
		this.g			= g;
		this.pa			= pa;
		this.ab			= ab;
		this.h			= h;
		this.hr			= hr;
		this.rbi		= rbi;
		this.so			= so;
		this.fdb		= fdb;
		this.sb			= sb;
		this.obp		= obp;
		this.scpos		= scpos;
		this.e			= e;
		this.ops		= ops;
	}

	public int getBatterId()  	{return batterId;}
	public int getPlayerId()  	{return playerId;}
	public int getTeamId()  	{return teamId;}
	public String getName()  	{return name;}
	public int getYear()   		{return year;}
	public String getAvg()  	{return avg;}
	public int getG()   		{return g;}
	public int getPa()   		{return pa;}
	public int getAb()   		{return ab;}
	public int getH()   		{return h;}
	public int getHr()   		{return hr;}
	public int getRbi()   		{return rbi;}
	public int getSo()   		{return so;}
	public int getFdb()   		{return fdb;}
	public int getSb()   		{return sb;}
	public String getObp()		{return obp;}
	public String getScpos()	{return scpos;}
	public int getE()   		{return e;}
	public String getOps()		{return ops;}

}