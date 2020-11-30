package model;

public class CreateAccount {
	private String userId;
	private String lastName;
	private String firstName;
	private String pass;
	private String mail;
	private String address;
	private String tel;

	public CreateAccount(String userId, String lastName, String firstName,
			String pass, String mail, String address, String tel) {
		this.userId    	 = userId;
		this.lastName	 = lastName;
		this.firstName   = firstName;
		this.pass 		 = pass;
		this.mail 	 	 = mail;
		this.address 	 = address;
		this.tel 		 = tel;
	}
	public String getUserId()  	 {return userId;}
	public String getLastName()  {return lastName;}
	public String getFirstName() {return firstName;}
	public String getPass()		 {return pass;}
	public String getMail()		 {return mail;}
	public String getAddress()   {return address;}
	public String getTel() 		 {return tel;}
}