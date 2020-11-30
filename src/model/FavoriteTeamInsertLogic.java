package model;

import java.sql.SQLException;

import dao.FavoriteTeamDAO;

public class FavoriteTeamInsertLogic {

	public boolean execute(FavoriteTeam favoriteTeam) {
		FavoriteTeamDAO dao = new FavoriteTeamDAO();
		try {
			dao.create(favoriteTeam);
		} catch (ClassNotFoundException e) {
			return false;
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public boolean execute2(SearchFavTeam searchFavTeam) {
		FavoriteTeamDAO fbftDAO = new FavoriteTeamDAO();
		FavoriteTeam fbft = fbftDAO.findByFavTeam(searchFavTeam);
		return fbft != null;
	}
}