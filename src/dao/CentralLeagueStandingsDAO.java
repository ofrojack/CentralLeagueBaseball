package dao;

import java.sql.Connection;//DBMSへの接続や切断を行う。プログラムとデータベースを結ぶ道路。
import java.sql.DriverManager;//DBMSへの接続準備を行う
import java.sql.PreparedStatement;//SQLの送信を行う。SQLを運ぶ車。
import java.sql.ResultSet;//DBMSから検索結果を受け取る。検索結果を受け取る入れ物のようなもの。
import java.sql.SQLException;//データベースに関するエラー情報を提供する
import java.util.ArrayList;

import model.CentralTeam;

public class CentralLeagueStandingsDAO {
//	データベース接続に使用する情報
	private final String JDBC_URL =
			"jdbc:mysql://localhost:3306/baseball?serverTimezone=JST&useSSL=false";
	private final String DB_USER = "root";
	private final String DB_PASS = "a3112336";

//	centralTeam = ct
	public ArrayList<CentralTeam> getTeam() throws ClassNotFoundException{
		ArrayList<CentralTeam> ct = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			throw e1;
		}

	try(Connection conn = DriverManager.getConnection(
		JDBC_URL, DB_USER, DB_PASS)){
		String sql = "select * from baseballTeam order by gb";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		ResultSet rs = pStmt.executeQuery();

		while(rs.next()){
			int teamId = rs.getInt("teamId");
			String name = rs.getString("name");
			int game = rs.getInt("game");
			int win = rs.getInt("win");
			int lose = rs.getInt("lose");
			int draw = rs.getInt("draw");
			float gb = rs.getInt("gb");
			String homeStadium = rs.getString("homeStadium");
			String homeAddress = rs.getString("homeAddress");
			String mapUrl = rs.getString("mapUrl");
			CentralTeam team = new CentralTeam(teamId, name, game, win, lose, draw, gb, homeStadium, homeAddress, mapUrl);

			ct.add(team);

		}
		conn.close();
	}catch(SQLException e) {
			e.printStackTrace();//接続やSQL処理失敗時の処理（必要に応じて適切な処理を入れる）
			return null;
	}
	return ct;
    }
}