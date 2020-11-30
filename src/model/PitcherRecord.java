package model;

public class PitcherRecord {;
	private int pitcherId;
	private int playerId;
	private int teamId;
	private String name;
	private int year;
	private String era;
	private int o;
	private int sta;
	private int cg;
	private String ip;
	private int w;
	private int l;
	private int h;
	private int hp;
	private int sv;
	private String wpct;
	private int k;
	private int r;
	private String oba;
	private String whip;


	public PitcherRecord(int pitcherId, int playerId, int teamId, String name, int year, String era, int o, int sta,
			int cg, String ip, int w, int l, int h, int hp, int sv, String wpct, int k, int r, String oba, String whip) {
		this.pitcherId	= pitcherId;
		this.playerId	= playerId;
		this.teamId		= teamId;
		this.name		= name;
		this.year		= year;
		this.era		= era;
		this.o			= o;
		this.sta		= sta;
		this.cg			= cg;
		this.ip			= ip;
		this.w			= w;
		this.l			= l;
		this.h			= h;
		this.hp			= hp;
		this.sv			= sv;
		this.wpct		= wpct;
		this.k			= k;
		this.r			= r;
		this.oba		= oba;
		this.whip		= whip;
	}

	public int getPitcherId()  	{return pitcherId;}
	public int getPlayerId()  	{return playerId;}
	public int getTeamId()  	{return teamId;}
	public String getName()  	{return name;}
	public int getYear()   		{return year;}
	public String getEra()  	{return era;}
	public int getO()   		{return o;}
	public int getSta()   		{return sta;}
	public int getCg()   		{return cg;}
	public String getIp()   	{return ip;}
	public int getW()   		{return w;}
	public int getL()   		{return l;}
	public int getH()   		{return h;}
	public int getHp()   		{return hp;}
	public int getSv()   		{return sv;}
	public String getWpct()		{return wpct;}
	public int getK()   		{return k;}
	public int getR()   		{return r;}
	public String getOba()		{return oba;}
	public String getWhip()		{return whip;}
}