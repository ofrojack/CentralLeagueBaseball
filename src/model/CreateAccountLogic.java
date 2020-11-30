package model;

import java.sql.SQLException;

import dao.CreateAccountDAO;

public class CreateAccountLogic {

	public boolean execute(CreateAccount createAccount) {
		CreateAccountDAO dao = new CreateAccountDAO();
		try {
			dao.create(createAccount);
		} catch (ClassNotFoundException e) {
			return false;
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
}