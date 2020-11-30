package model;

import java.sql.SQLException;

import dao.FavoritePlayerDAO;

public class FavoritePlayerDeleteLogic {

	public boolean execute(FavoritePlayer favoritePlayer) {
		FavoritePlayerDAO dao = new FavoritePlayerDAO();
		try {
			dao.delete(favoritePlayer);
		} catch (ClassNotFoundException e) {
			return false;
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
}