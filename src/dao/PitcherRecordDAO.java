package dao;

import java.sql.Connection;//DBMSへの接続や切断を行う。プログラムとデータベースを結ぶ道路。
import java.sql.DriverManager;//DBMSへの接続準備を行う
import java.sql.PreparedStatement;//SQLの送信を行う。SQLを運ぶ車。
import java.sql.ResultSet;//DBMSから検索結果を受け取る。検索結果を受け取る入れ物のようなもの。
import java.sql.SQLException;//データベースに関するエラー情報を提供する
import java.util.ArrayList;

import model.PitcherRecord;

public class PitcherRecordDAO {
//	データベース接続に使用する情報
	private final String JDBC_URL =
			"jdbc:mysql://localhost:3306/baseball?serverTimezone=JST&useSSL=false";
	private final String DB_USER = "root";
	private final String DB_PASS = "a3112336";

//	pitcherRecord = pr
//	チームで引っ張るDAO
	public ArrayList<PitcherRecord> getPitcher(int searchTeamId) throws ClassNotFoundException{
		ArrayList<PitcherRecord> pr = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			throw e1;
		}

		try(Connection conn = DriverManager.getConnection(
			JDBC_URL, DB_USER, DB_PASS)){
//			String sql = "select * from pitcherrecord";
			String sql = "select * from pitcherrecord where teamId = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, searchTeamId);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()){
				int pitcherId	= rs.getInt("pitcherId");
				int playerId	= rs.getInt("playerId");
				int teamId		= rs.getInt("teamId");
				String name		= rs.getString("name");
				int year		= rs.getInt("year");
				String era		= rs.getString("era");
				int o			= rs.getInt("o");
				int sta			= rs.getInt("sta");
				int cg			= rs.getInt("cg");
				String ip		= rs.getString("ip");
				int w			= rs.getInt("w");
				int l			= rs.getInt("l");
				int h			= rs.getInt("h");
				int hp			= rs.getInt("hp");
				int sv			= rs.getInt("sv");
				String wpct		= rs.getString("wpct");
				int k			= rs.getInt("k");
				int r			= rs.getInt("r");
				String oba		= rs.getString("oba");
				String whip		= rs.getString("whip");
				PitcherRecord pitcher = new PitcherRecord(pitcherId, playerId, teamId, name, year, era, o, sta,
						cg, ip, w, l, h, hp, sv, wpct, k, r, oba, whip);

				pr.add(pitcher);

			}
			conn.close();
		}catch(SQLException e) {
				e.printStackTrace();//接続やSQL処理失敗時の処理（必要に応じて適切な処理を入れる）
				return null;
		}
		return pr;
    }

//	pitcherRecord2 = pr2
//	個人(playerId)で引っ張るDAO
	public ArrayList<PitcherRecord> getPitcherRecord(int PlayerId) throws ClassNotFoundException{
		ArrayList<PitcherRecord> pr2 = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			throw e1;
		}

		try(Connection conn = DriverManager.getConnection(
			JDBC_URL, DB_USER, DB_PASS)){
//			String sql = "select * from pitcherrecord";
			String sql = "select * from pitcherrecord where playerId = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, PlayerId);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()){
				int pitcherId	= rs.getInt("pitcherId");
				int playerId	= rs.getInt("playerId");
				int teamId		= rs.getInt("teamId");
				String name		= rs.getString("name");
				int year		= rs.getInt("year");
				String era		= rs.getString("era");
				int o			= rs.getInt("o");
				int sta			= rs.getInt("sta");
				int cg			= rs.getInt("cg");
				String ip		= rs.getString("ip");
				int w			= rs.getInt("w");
				int l			= rs.getInt("l");
				int h			= rs.getInt("h");
				int hp			= rs.getInt("hp");
				int sv			= rs.getInt("sv");
				String wpct		= rs.getString("wpct");
				int k			= rs.getInt("k");
				int r			= rs.getInt("r");
				String oba		= rs.getString("oba");
				String whip		= rs.getString("whip");
				PitcherRecord pitcher = new PitcherRecord(pitcherId, playerId, teamId, name, year, era, o, sta,
						cg, ip, w, l, h, hp, sv, wpct, k, r, oba, whip);

				pr2.add(pitcher);

			}
			conn.close();
		}catch(SQLException e) {
				e.printStackTrace();//接続やSQL処理失敗時の処理（必要に応じて適切な処理を入れる）
				return null;
		}
		return pr2;
    }

//	投手成績検索用
//	searchPitcherRecord=spr
	public ArrayList<PitcherRecord> searchPitcherRecord(String TeamId, String Name, String Year, String Era, String O, String Sta, String Cg,
			String Ip, String W, String L, String H, String Hp, String Sv, String Wpct, String K, String R, String Oba, String Whip) throws ClassNotFoundException{
		ArrayList<PitcherRecord> spr = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			throw e1;
		}

		try(Connection conn = DriverManager.getConnection(
			JDBC_URL, DB_USER, DB_PASS)){
			String sql = "select * from pitcherrecord where ((teamId like ?) and (name like ?) and (year like ?)"
					+ " and (era like ?) and (o like ?) and (sta like ?) and (cg like ?) and (ip like ?) and (w like ?)"
					+ " and (l like ?) and (h like ?) and (hp like ?) and (sv like ?) and (wpct like ?)"
					+ " and (k like ?) and (r like ?) and (oba like ?) and (whip like ?)) order by convert(teamId, signed)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, "%" + TeamId + "%");
			pStmt.setString(2, "%" + Name + "%");
			pStmt.setString(3, "%" + Year + "%");
			pStmt.setString(4, "%" + Era + "%");
			pStmt.setString(5, "%" + O + "%");
			pStmt.setString(6, "%" + Sta + "%");
			pStmt.setString(7, "%" + Cg + "%");
			pStmt.setString(8, "%" + Ip + "%");
			pStmt.setString(9, "%" + W + "%");
			pStmt.setString(10, "%" + L + "%");
			pStmt.setString(11, "%" + H + "%");
			pStmt.setString(12, "%" + Hp + "%");
			pStmt.setString(13, "%" + Sv + "%");
			pStmt.setString(14, "%" + Wpct + "%");
			pStmt.setString(15, "%" + K + "%");
			pStmt.setString(16, "%" + R + "%");
			pStmt.setString(17, "%" + Oba + "%");
			pStmt.setString(18, "%" + Whip + "%");

			ResultSet rs = pStmt.executeQuery();

			while(rs.next()){
				int pitcherId	= rs.getInt("pitcherId");
				int playerId	= rs.getInt("playerId");
				int teamId		= rs.getInt("teamId");
				String name		= rs.getString("name");
				int year		= rs.getInt("year");
				String era		= rs.getString("era");
				int o			= rs.getInt("o");
				int sta			= rs.getInt("sta");
				int cg			= rs.getInt("cg");
				String ip		= rs.getString("ip");
				int w			= rs.getInt("w");
				int l			= rs.getInt("l");
				int h			= rs.getInt("h");
				int hp			= rs.getInt("hp");
				int sv			= rs.getInt("sv");
				String wpct		= rs.getString("wpct");
				int k			= rs.getInt("k");
				int r			= rs.getInt("r");
				String oba		= rs.getString("oba");
				String whip		= rs.getString("whip");
				PitcherRecord record = new PitcherRecord(pitcherId, playerId, teamId, name, year, era, o, sta,
						cg, ip, w, l, h, hp, sv, wpct, k, r, oba, whip);

				spr.add(record);

			}
			conn.close();
		}catch(SQLException e) {
				e.printStackTrace();//接続やSQL処理失敗時の処理（必要に応じて適切な処理を入れる）
				return null;
		}
		return spr;
    }
}