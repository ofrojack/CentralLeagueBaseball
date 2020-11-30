package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.FavoritePlayer;
import model.SearchFavPlayer;

public class FavoritePlayerDAO {
//	データベース接続に使用する情報
	private final String JDBC_URL =
			"jdbc:mysql://localhost:3306/baseball?serverTimezone=JST&useSSL=false";
	private final String DB_USER = "root";
	private final String DB_PASS = "a3112336";

//	accountIdごとにお気に入り選手を表示
//	favorite player = fp
	public ArrayList<FavoritePlayer> findAll(int AccountId) throws ClassNotFoundException {
		ArrayList<FavoritePlayer> fp = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			throw e1;
		}
//		データベースへ接続
		try(Connection conn = DriverManager.getConnection(
//			接続先DB、ユーザ名、パスワード
			JDBC_URL, DB_USER, DB_PASS)){

//			favplayerとallplayerを一緒のテーブルにして、
//			PlayerDataServletに必要なgetParameter(fpId,accountId,teamId,posiId,playerId,name)を取得してfpに格納
			String sql = "select favplayer.fpId, favplayer.accountId, allplayer.teamId, allplayer.posiId, allplayer.playerId,"
					+ " allplayer.name from allplayer join favplayer using(playerId) where favplayer.accountId=?;";
//			SQLをDBに届けるPreparedStatementインスタンスを取得する。
			PreparedStatement pStmt=conn.prepareStatement(sql);
//			insert文中の「?」に使用する値を指定し、SQL文を完成
			pStmt.setInt(1, AccountId);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()){
				int fpId = rs.getInt("fpId");
				int accountId = rs.getInt("accountId");
				int teamId = rs.getInt("teamId");
				int posiId = rs.getInt("posiId");
				int playerId = rs.getInt("playerId");
				String name = rs.getString("name");
//				FavoritePlayer = favP
				FavoritePlayer favP = new FavoritePlayer(fpId, accountId, teamId, posiId, playerId, name);

				fp.add(favP);
			}
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return fp;
	}

//	お気に入り検索DAO
//	findByFavPlayer = fbfp
	public FavoritePlayer findByFavPlayer(SearchFavPlayer searchFavPlayer){
		FavoritePlayer fbfp = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

//		データベースへ接続
		try(Connection conn = DriverManager.getConnection(
//			接続先DB、ユーザ名、パスワード
			JDBC_URL, DB_USER, DB_PASS)){

//			INSERT文を準備
			String sql = "select * from favplayer where accountId = ? and playerId = ?";
//			SQLをDBに届けるPreparedStatementインスタンスを取得する。
			PreparedStatement pStmt=conn.prepareStatement(sql);
//			insert文中の「?」に使用する値を指定し、SQL文を完成
			pStmt.setInt(1, searchFavPlayer.getAccountId());
			pStmt.setInt(2, searchFavPlayer.getPlayerId());
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()){
				int fpId = rs.getInt("fpId");
				int accountId = rs.getInt("accountId");
				int playerId = rs.getInt("playerId");
				fbfp = new FavoritePlayer(fpId, accountId, playerId);
			}
		}catch(SQLException e) {
				e.printStackTrace();//接続やSQL処理失敗時の処理（必要に応じて適切な処理を入れる）
				return null;
		}
		return fbfp;
    }


//	お気に入り追加DAO
	public void create(FavoritePlayer favoritePlayer) throws SQLException, ClassNotFoundException{

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			throw e1;
		}

//		データベースへ接続
		try(Connection conn = DriverManager.getConnection(
//			接続先DB、ユーザ名、パスワード
			JDBC_URL, DB_USER, DB_PASS)){

//			INSERT文を準備。存在したらInsertしないSQL文。
			String sql = "INSERT INTO favplayer (accountId, playerId) SELECT ?, ? FROM dual "
					+ "WHERE NOT EXISTS(SELECT * FROM favplayer WHERE accountId = ? and playerId = ?)";
//			SQLをDBに届けるPreparedStatementインスタンスを取得する。
			PreparedStatement pStmt=conn.prepareStatement(sql);
//			insert文中の「?」に使用する値を指定し、SQL文を完成
			pStmt.setInt(1, favoritePlayer.getAccountId());
			pStmt.setInt(2, favoritePlayer.getPlayerId());
			pStmt.setInt(3, favoritePlayer.getAccountId());
			pStmt.setInt(4, favoritePlayer.getPlayerId());
			pStmt.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}


//	お気に入り削除DAO
	public void delete(FavoritePlayer favoritePlayer) throws SQLException, ClassNotFoundException{

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			throw e1;
		}

//		データベースへ接続
		try(Connection conn = DriverManager.getConnection(
//			接続先DB、ユーザ名、パスワード
			JDBC_URL, DB_USER, DB_PASS)){

//			INSERT文を準備
			String sql = "delete from favplayer where accountId = ? and playerId = ?";
//			SQLをDBに届けるPreparedStatementインスタンスを取得する。
			PreparedStatement pStmt=conn.prepareStatement(sql);
//			insert文中の「?」に使用する値を指定し、SQL文を完成
			pStmt.setInt(1, favoritePlayer.getAccountId());
			pStmt.setInt(2, favoritePlayer.getPlayerId());
			pStmt.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
}