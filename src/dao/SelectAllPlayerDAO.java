package dao;

import java.sql.Connection;//DBMSへの接続や切断を行う。プログラムとデータベースを結ぶ道路。
import java.sql.DriverManager;//DBMSへの接続準備を行う
import java.sql.PreparedStatement;//SQLの送信を行う。SQLを運ぶ車。
import java.sql.ResultSet;//DBMSから検索結果を受け取る。検索結果を受け取る入れ物のようなもの。
import java.sql.SQLException;//データベースに関するエラー情報を提供する
import java.util.ArrayList;

import model.Catcher;
import model.Infielder;
import model.Outfielder;
import model.Pitcher;
import model.Player;

public class SelectAllPlayerDAO {
//	データベース接続に使用する情報
	private final String JDBC_URL =
			"jdbc:mysql://localhost:3306/baseball?serverTimezone=JST&useSSL=false";
	private final String DB_USER = "root";
	private final String DB_PASS = "a3112336";

//	playerSmall = ps
	public ArrayList<Player> getPlayer(int searchTeamId) throws ClassNotFoundException{
		ArrayList<Player> ps = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			throw e1;
		}

		try(Connection conn = DriverManager.getConnection(
			JDBC_URL, DB_USER, DB_PASS)){
			String sql = "select * from allplayer where teamId = ? order by convert(num, signed)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, searchTeamId);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()){
				int playerId = rs.getInt("playerId");
				int teamId = rs.getInt("teamId");
				String name = rs.getString("name");
				String kana = rs.getString("kana");
				String lastName = rs.getString("lastName");
				String firstName = rs.getString("firstName");
				int posiId = rs.getInt("posiId");
				String num = rs.getString("num");
				String birth = rs.getString("birth");
				int height = rs.getInt("height");
				int weight = rs.getInt("weight");
				String blood = rs.getString("blood");
				String dexterity = rs.getString("dexterity");
				String draft = rs.getString("draft");
				int career = rs.getInt("career");
				String finEdu = rs.getString("finEdu");
				String born = rs.getString("born");
				Player play = new Player(playerId, teamId, name, kana, lastName, firstName, posiId, num, birth, height, weight,
						blood, dexterity, draft, career, finEdu, born);

				ps.add(play);

			}
			conn.close();
		}catch(SQLException e) {
				e.printStackTrace();//接続やSQL処理失敗時の処理（必要に応じて適切な処理を入れる）
				return null;
		}
		return ps;
    }

	public ArrayList<Player> getPlayer2(int searchTeamId, int searchPlayerId) throws ClassNotFoundException{
		ArrayList<Player> ps = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			throw e1;
		}

		try(Connection conn = DriverManager.getConnection(
			JDBC_URL, DB_USER, DB_PASS)){
//			int teamId = 1;
//			String sql = "select * from allplayer order by convert(num, signed)";
			String sql = "select * from allplayer where teamId = ? and playerId = ? order by convert(num, signed)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, searchTeamId);
			pStmt.setInt(2, searchPlayerId);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()){
				int playerId = rs.getInt("playerId");
				int teamId = rs.getInt("teamId");
				String name = rs.getString("name");
				String kana = rs.getString("kana");
				String lastName = rs.getString("lastName");
				String firstName = rs.getString("firstName");
				int posiId = rs.getInt("posiId");
				String num = rs.getString("num");
				String birth = rs.getString("birth");
				int height = rs.getInt("height");
				int weight = rs.getInt("weight");
				String blood = rs.getString("blood");
				String dexterity = rs.getString("dexterity");
				String draft = rs.getString("draft");
				int career = rs.getInt("career");
				String finEdu = rs.getString("finEdu");
				String born = rs.getString("born");
				Player play = new Player(playerId, teamId, name, kana, lastName, firstName, posiId, num, birth, height, weight,
						blood, dexterity, draft, career, finEdu, born);

				ps.add(play);

			}
			conn.close();
		}catch(SQLException e) {
				e.printStackTrace();//接続やSQL処理失敗時の処理（必要に応じて適切な処理を入れる）
				return null;
		}
		return ps;
    }


//	ピッチャー検索用DAO
	public ArrayList<Pitcher> getPitcher(int TeamId) throws ClassNotFoundException{
		ArrayList<Pitcher> p = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			throw e1;
		}

		try(Connection conn = DriverManager.getConnection(
			JDBC_URL, DB_USER, DB_PASS)){
//			int teamId = 1;
//			String sql = "select * from allplayer order by convert(num, signed)";
			String sql = "select * from allplayer where posiId = 1 and teamId = ? order by convert(num, signed)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, TeamId);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()){
				int playerId = rs.getInt("playerId");
				int teamId = rs.getInt("teamId");
				String name = rs.getString("name");
				String kana = rs.getString("kana");
				String lastName = rs.getString("lastName");
				String firstName = rs.getString("firstName");
				int posiId = rs.getInt("posiId");
				String num = rs.getString("num");
				String birth = rs.getString("birth");
				int height = rs.getInt("height");
				int weight = rs.getInt("weight");
				String blood = rs.getString("blood");
				String dexterity = rs.getString("dexterity");
				String draft = rs.getString("draft");
				int career = rs.getInt("career");
				String finEdu = rs.getString("finEdu");
				String born = rs.getString("born");
				Pitcher pitcher = new Pitcher(playerId, teamId, name, kana, lastName, firstName, posiId, num, birth, height, weight,
						blood, dexterity, draft, career, finEdu, born);

				p.add(pitcher);

			}
			conn.close();
		}catch(SQLException e) {
				e.printStackTrace();//接続やSQL処理失敗時の処理（必要に応じて適切な処理を入れる）
				return null;
		}
		return p;
    }

//	キャッチャー検索用DAO
	public ArrayList<Catcher> getCatcher(int TeamId) throws ClassNotFoundException{
		ArrayList<Catcher> c = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			throw e1;
		}

		try(Connection conn = DriverManager.getConnection(
			JDBC_URL, DB_USER, DB_PASS)){
//			int teamId = 1;
//			String sql = "select * from allplayer order by convert(num, signed)";
			String sql = "select * from allplayer where posiId = 2 and teamId = ? order by convert(num, signed)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, TeamId);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()){
				int playerId = rs.getInt("playerId");
				int teamId = rs.getInt("teamId");
				String name = rs.getString("name");
				String kana = rs.getString("kana");
				String lastName = rs.getString("lastName");
				String firstName = rs.getString("firstName");
				int posiId = rs.getInt("posiId");
				String num = rs.getString("num");
				String birth = rs.getString("birth");
				int height = rs.getInt("height");
				int weight = rs.getInt("weight");
				String blood = rs.getString("blood");
				String dexterity = rs.getString("dexterity");
				String draft = rs.getString("draft");
				int career = rs.getInt("career");
				String finEdu = rs.getString("finEdu");
				String born = rs.getString("born");
				Catcher catcher = new Catcher(playerId, teamId, name, kana, lastName, firstName, posiId, num, birth, height, weight,
						blood, dexterity, draft, career, finEdu, born);

				c.add(catcher);

			}
			conn.close();
		}catch(SQLException e) {
				e.printStackTrace();//接続やSQL処理失敗時の処理（必要に応じて適切な処理を入れる）
				return null;
		}
		return c;
    }

//	内野手検索用DAO
	public ArrayList<Infielder> getInfielder(int TeamId) throws ClassNotFoundException{
		ArrayList<Infielder> in = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			throw e1;
		}

		try(Connection conn = DriverManager.getConnection(
			JDBC_URL, DB_USER, DB_PASS)){
//			int teamId = 1;
//			String sql = "select * from allplayer order by convert(num, signed)";
			String sql = "select * from allplayer where posiId = 3 and teamId = ? order by convert(num, signed)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, TeamId);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()){
				int playerId = rs.getInt("playerId");
				int teamId = rs.getInt("teamId");
				String name = rs.getString("name");
				String kana = rs.getString("kana");
				String lastName = rs.getString("lastName");
				String firstName = rs.getString("firstName");
				int posiId = rs.getInt("posiId");
				String num = rs.getString("num");
				String birth = rs.getString("birth");
				int height = rs.getInt("height");
				int weight = rs.getInt("weight");
				String blood = rs.getString("blood");
				String dexterity = rs.getString("dexterity");
				String draft = rs.getString("draft");
				int career = rs.getInt("career");
				String finEdu = rs.getString("finEdu");
				String born = rs.getString("born");
				Infielder infielder = new Infielder(playerId, teamId, name, kana, lastName, firstName, posiId, num, birth, height, weight,
						blood, dexterity, draft, career, finEdu, born);

				in.add(infielder);

			}
			conn.close();
		}catch(SQLException e) {
				e.printStackTrace();//接続やSQL処理失敗時の処理（必要に応じて適切な処理を入れる）
				return null;
		}
		return in;
    }

//	外野手検索用DAO
	public ArrayList<Outfielder> getOutfielder(int TeamId) throws ClassNotFoundException{
		ArrayList<Outfielder> ou = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			throw e1;
		}

		try(Connection conn = DriverManager.getConnection(
			JDBC_URL, DB_USER, DB_PASS)){
//			int teamId = 1;
//			String sql = "select * from allplayer order by convert(num, signed)";
			String sql = "select * from allplayer where posiId = 4 and teamId = ? order by convert(num, signed)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, TeamId);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()){
				int playerId = rs.getInt("playerId");
				int teamId = rs.getInt("teamId");
				String name = rs.getString("name");
				String kana = rs.getString("kana");
				String lastName = rs.getString("lastName");
				String firstName = rs.getString("firstName");
				int posiId = rs.getInt("posiId");
				String num = rs.getString("num");
				String birth = rs.getString("birth");
				int height = rs.getInt("height");
				int weight = rs.getInt("weight");
				String blood = rs.getString("blood");
				String dexterity = rs.getString("dexterity");
				String draft = rs.getString("draft");
				int career = rs.getInt("career");
				String finEdu = rs.getString("finEdu");
				String born = rs.getString("born");
				Outfielder outfielder = new Outfielder(playerId, teamId, name, kana, lastName, firstName, posiId, num, birth, height, weight,
						blood, dexterity, draft, career, finEdu, born);

				ou.add(outfielder);

			}
			conn.close();
		}catch(SQLException e) {
				e.printStackTrace();//接続やSQL処理失敗時の処理（必要に応じて適切な処理を入れる）
				return null;
		}
		return ou;
    }

	public ArrayList<Player> searchPlayer(String TeamId, String Name, String Kana, String PosiId, String Num, String Birth, String Height,
			String Weight, String Dexterity, String Blood, String Draft, String Career, String Born) throws ClassNotFoundException{
		ArrayList<Player> ps = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			throw e1;
		}

		try(Connection conn = DriverManager.getConnection(
			JDBC_URL, DB_USER, DB_PASS)){
			String sql = "select * from allplayer where ((teamId like ?) and (name like ?) and (kana like ?) and (posiId like ?) and (num like ?)"
					+ " and (birth like ?) and (height like ?) and (weight like ?) and (dexterity like ?)"
					+ " and (blood like ?) and (draft like ?) and (career like ?) and (born like ?)) order by convert(teamId, signed)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, "%" + TeamId + "%");
			pStmt.setString(2, "%" + Name + "%");
			pStmt.setString(3, "%" + Kana + "%");
			pStmt.setString(4, "%" + PosiId + "%");
			pStmt.setString(5, "%" + Num + "%");
			pStmt.setString(6, "%" + Birth + "%");
			pStmt.setString(7, "%" + Height + "%");
			pStmt.setString(8, "%" + Weight + "%");
			pStmt.setString(9, "%" + Dexterity + "%");
			pStmt.setString(10, "%" + Blood + "%");
			pStmt.setString(11, "%" + Draft + "%");
			pStmt.setString(12, "%" + Career + "%");
			pStmt.setString(13, "%" + Born + "%");

			ResultSet rs = pStmt.executeQuery();

			while(rs.next()){
				int playerId = rs.getInt("playerId");
				int teamId = rs.getInt("teamId");
				String name = rs.getString("name");
				String kana = rs.getString("kana");
				String lastName = rs.getString("lastName");
				String firstName = rs.getString("firstName");
				int posiId = rs.getInt("posiId");
				String num = rs.getString("num");
				String birth = rs.getString("birth");
				int height = rs.getInt("height");
				int weight = rs.getInt("weight");
				String blood = rs.getString("blood");
				String dexterity = rs.getString("dexterity");
				String draft = rs.getString("draft");
				int career = rs.getInt("career");
				String finEdu = rs.getString("finEdu");
				String born = rs.getString("born");
				Player play = new Player(playerId, teamId, name, kana, lastName, firstName, posiId, num, birth, height, weight,
						blood, dexterity, draft, career, finEdu, born);

				ps.add(play);

			}
			conn.close();
		}catch(SQLException e) {
				e.printStackTrace();//接続やSQL処理失敗時の処理（必要に応じて適切な処理を入れる）
				return null;
		}
		return ps;
    }
}