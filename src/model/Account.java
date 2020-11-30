package model;

public class Account {
	private int accountId;
	private String userId;
	private String firstName;
	private String lastName;
	private String pass;
	private String mail;
	private String address;
	private String tel;

	public Account(int accountId, String userId, String firstName, String lastName,
					String pass, String mail, String address, String tel) {
		this.accountId	 = accountId;
		this.userId		 = userId;
		this.firstName 	 = firstName;
		this.lastName 	 = lastName;
		this.pass 		 = pass;
		this.mail 		 = mail;
		this.address	 = address;
		this.tel 		 = tel;
	}

	public int getAccountId()  		{return accountId;}
	public String getUserId()  		{return userId;}
	public String getFirstName()    {return firstName;}
	public String getLastName()     {return lastName;}
	public String getPass() 		{return pass;}
	public String getMail()  	    {return mail;}
	public String getAddress()      {return address;}
	public String getTel()			{return tel;}
}