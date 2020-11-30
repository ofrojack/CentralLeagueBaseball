package model;

import java.sql.SQLException;

import dao.FavoritePlayerDAO;

public class FavoritePlayerInsertLogic {

	public boolean execute(FavoritePlayer favoritePlayer) {
		FavoritePlayerDAO dao = new FavoritePlayerDAO();
		try {
			dao.create(favoritePlayer);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean execute2(SearchFavPlayer searchFavPlayer) {
		FavoritePlayerDAO fbfpDAO = new FavoritePlayerDAO();
		FavoritePlayer fbfp = fbfpDAO.findByFavPlayer(searchFavPlayer);
		return fbfp != null;
	}
}

