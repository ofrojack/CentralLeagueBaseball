package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.FavoriteTeam;
import model.SearchFavTeam;

public class FavoriteTeamDAO {
//	データベース接続に使用する情報
	private final String JDBC_URL =
			"jdbc:mysql://localhost:3306/baseball?serverTimezone=JST&useSSL=false";
	private final String DB_USER = "root";
	private final String DB_PASS = "a3112336";

//	accountIdごとにお気に入りチームを表示
//	favorite team = ft
	public ArrayList<FavoriteTeam> findAll(int AccountId) throws ClassNotFoundException {
		ArrayList<FavoriteTeam> ft = new ArrayList<>();

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
//			TeamServletに必要なgetParameter(ftId,accountId,teamId,name,homeaddress,homestadium,mapurl)を取得してfpに格納
			String sql = "select favteam.ftId, favteam.accountId, favteam.teamId, baseballTeam.name,"
					+ " baseballTeam.homeaddress, baseballTeam.homestadium, baseballTeam.mapurl"
					+ " from baseballTeam join favteam using(teamId) where favteam.accountId=?";
//			SQLをDBに届けるPreparedStatementインスタンスを取得する。
			PreparedStatement pStmt=conn.prepareStatement(sql);
//			insert文中の「?」に使用する値を指定し、SQL文を完成
			pStmt.setInt(1, AccountId);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()){
				int ftId = rs.getInt("ftId");
				int accountId = rs.getInt("accountId");
				int teamId = rs.getInt("teamId");
				String name = rs.getString("name");
				String homeaddress = rs.getString("homeaddress");
				String homestadium = rs.getString("homestadium");
				String mapurl = rs.getString("mapurl");
//				FavoriteTeam = favT
				FavoriteTeam favT = new FavoriteTeam(ftId, accountId, teamId, name, homeaddress, homestadium, mapurl);

				ft.add(favT);
			}
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return ft;
	}

//	お気に入り検索DAO
//	findByFavTeam = fbft
	public FavoriteTeam findByFavTeam(SearchFavTeam searchFavTeam){
		FavoriteTeam fbft = null;

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
			String sql = "select * from favteam where accountId = ? and teamId = ?";
//			SQLをDBに届けるPreparedStatementインスタンスを取得する。
			PreparedStatement pStmt=conn.prepareStatement(sql);
//			insert文中の「?」に使用する値を指定し、SQL文を完成
			pStmt.setInt(1, searchFavTeam.getAccountId());
			pStmt.setInt(2, searchFavTeam.getTeamId());
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()){
				int ftId = rs.getInt("ftId");
				int accountId = rs.getInt("accountId");
				int teamId = rs.getInt("teamId");
				fbft = new FavoriteTeam(ftId, accountId, teamId);
			}
		}catch(SQLException e) {
				e.printStackTrace();//接続やSQL処理失敗時の処理（必要に応じて適切な処理を入れる）
				return null;
		}
		return fbft;
    }


	public void create(FavoriteTeam favoriteTeam) throws SQLException, ClassNotFoundException{

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
			String sql = "INSERT INTO favteam (accountId, teamId) SELECT ?, ? FROM dual "
					+ "WHERE NOT EXISTS(SELECT * FROM favteam WHERE accountId = ? and teamId = ?)";
//			SQLをDBに届けるPreparedStatementインスタンスを取得する。
			PreparedStatement pStmt=conn.prepareStatement(sql);
//			insert文中の「?」に使用する値を指定し、SQL文を完成
			pStmt.setInt(1, favoriteTeam.getAccountId());
			pStmt.setInt(2, favoriteTeam.getTeamId());
			pStmt.setInt(3, favoriteTeam.getAccountId());
			pStmt.setInt(4, favoriteTeam.getTeamId());
			pStmt.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void delete(FavoriteTeam favoriteTeam) throws SQLException, ClassNotFoundException{

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
			String sql = "delete from favteam where accountId = ? and teamId = ?";
//			SQLをDBに届けるPreparedStatementインスタンスを取得する。
			PreparedStatement pStmt=conn.prepareStatement(sql);
//			insert文中の「?」に使用する値を指定し、SQL文を完成
			pStmt.setInt(1, favoriteTeam.getAccountId());
			pStmt.setInt(2, favoriteTeam.getTeamId());
			pStmt.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
}