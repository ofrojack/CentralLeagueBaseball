package model;

public class Login {
	private int accountId;
	private String userId;
	private String pass;

	public Login(String userId, String pass) {
//		this.accountId = accountId;
		this.userId = userId;
		this.pass = pass;
	}

	public Login(String userId) {
//		this.accountId = accountId;
		this.userId = userId;
	}

	public int getAccountId() {return accountId;}
	public String getUserId() {return userId;}
	public String getPass()   {return pass;}
}