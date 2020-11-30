package model;

public class Infielder {
	private int playerId;
	private int teamId;
	private String name;
	private String kana;
	private String lastName;
	private String firstName;
	private int posiId;
	private String num;
	private String birth;
	private int height;
	private int weight;
	private String blood;
	private String dexterity;
	private String draft;
	private int career;
	private String finEdu;
	private String born;

	public Infielder(
			int playerId, int teamId, String name, String kana, String lastName, String firstName, int posiId, String num, String birth, int height, int weight,
			String blood, String dexterity, String draft, int career, String finEdu, String born) {
		this.playerId	= playerId;
		this.teamId		= teamId;
		this.name		= name;
		this.kana		= kana;
		this.lastName	= lastName;
		this.firstName	= firstName;
		this.posiId		= posiId;
		this.num		= num;
		this.birth		= birth;
		this.height		= height;
		this.weight		= weight;
		this.blood		= blood;
		this.dexterity	= dexterity;
		this.draft		= draft;
		this.career		= career;
		this.finEdu		= finEdu;
		this.born		= born;
	}

	public Infielder(String lastName, String firstName, String num) {
		this.lastName	= lastName;
		this.firstName	= firstName;
		this.num		= num;
	}

	public int getPlayerId() 	 {return playerId;}
	public int getTeamId() 	 	 {return teamId;}
	public String getName()		 {return name;}
	public String getKana()		 {return kana;}
	public int getPosiId()		 {return posiId;}
	public String getLastName()	 {return lastName;}
	public String getFirstName() {return firstName;}
	public String getNum()		 {return num;}
	public String getBirth() 	 {return birth;}
	public int getHeight() 	 	 {return height;}
	public int getWeight()	 	 {return weight;}
	public String getBlood()	 {return blood;}
	public String getDexterity() {return dexterity;}
	public String getDraft() 	 {return draft;}
	public int getCareer()	 	 {return career;}
	public String getFinEdu() 	 {return finEdu;}
	public String getBorn()		 {return born;}
}
