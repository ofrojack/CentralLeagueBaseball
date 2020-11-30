package model;

import java.sql.SQLException;

import dao.FavoriteTeamDAO;

public class FavoriteTeamDeleteLogic {

	public boolean execute(FavoriteTeam favoriteTeam) {
		FavoriteTeamDAO dao = new FavoriteTeamDAO();
		try {
			dao.delete(favoriteTeam);
		} catch (ClassNotFoundException e) {
			return false;
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
}