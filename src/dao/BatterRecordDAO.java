package dao;

import java.sql.Connection;//DBMSへの接続や切断を行う。プログラムとデータベースを結ぶ道路。
import java.sql.DriverManager;//DBMSへの接続準備を行う
import java.sql.PreparedStatement;//SQLの送信を行う。SQLを運ぶ車。
import java.sql.ResultSet;//DBMSから検索結果を受け取る。検索結果を受け取る入れ物のようなもの。
import java.sql.SQLException;//データベースに関するエラー情報を提供する
import java.util.ArrayList;

import model.BatterRecord;

public class BatterRecordDAO {
//	データベース接続に使用する情報
	private final String JDBC_URL =
			"jdbc:mysql://localhost:3306/baseball?serverTimezone=JST&useSSL=false";
	private final String DB_USER = "root";
	private final String DB_PASS = "a3112336";

//	batterRecord = br
//	チームごとに引っ張るDAO
	public ArrayList<BatterRecord> getBatter(int searchTeamId) throws ClassNotFoundException{
		ArrayList<BatterRecord> br = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			throw e1;
		}

		try(Connection conn = DriverManager.getConnection(
			JDBC_URL, DB_USER, DB_PASS)){
			String sql = "select * from batterrecord where teamId = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, searchTeamId);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()){
				int batterId = rs.getInt("batterId");
				int playerId = rs.getInt("playerId");
				int teamId = rs.getInt("teamId");
				String name = rs.getString("name");
				int year = rs.getInt("year");
				String avg = rs.getString("avg");
				int g = rs.getInt("g");
				int pa = rs.getInt("pa");
				int ab = rs.getInt("ab");
				int h = rs.getInt("h");
				int hr = rs.getInt("hr");
				int rbi = rs.getInt("rbi");
				int so = rs.getInt("so");
				int fdb = rs.getInt("fdb");
				int sb = rs.getInt("sb");
				String obp = rs.getString("obp");
				String scpos = rs.getString("scpos");
				int e = rs.getInt("e");
				String ops = rs.getString("ops");
				BatterRecord batter = new BatterRecord(batterId, playerId, teamId, name, year, avg, g, pa, ab, h,
						 hr, rbi, so, fdb, sb, obp, scpos, e, ops);

				br.add(batter);

			}
			conn.close();
		}catch(SQLException e) {
				e.printStackTrace();//接続やSQL処理失敗時の処理（必要に応じて適切な処理を入れる）
				return null;
		}
		return br;
    }

//	batterRecord2 = br2
//	個人で引っ張るDAO(playerId)
	public ArrayList<BatterRecord> getBatterRecord(int PlayerId) throws ClassNotFoundException{
		ArrayList<BatterRecord> br2 = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			throw e1;
		}

		try(Connection conn = DriverManager.getConnection(
			JDBC_URL, DB_USER, DB_PASS)){
			String sql = "select * from batterrecord where playerId = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, PlayerId);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()){
				int batterId = rs.getInt("batterId");
				int playerId = rs.getInt("playerId");
				int teamId = rs.getInt("teamId");
				String name = rs.getString("name");
				int year = rs.getInt("year");
				String avg = rs.getString("avg");
				int g = rs.getInt("g");
				int pa = rs.getInt("pa");
				int ab = rs.getInt("ab");
				int h = rs.getInt("h");
				int hr = rs.getInt("hr");
				int rbi = rs.getInt("rbi");
				int so = rs.getInt("so");
				int fdb = rs.getInt("fdb");
				int sb = rs.getInt("sb");
				String obp = rs.getString("obp");
				String scpos = rs.getString("scpos");
				int e = rs.getInt("e");
				String ops = rs.getString("ops");
				BatterRecord batter = new BatterRecord(batterId, playerId, teamId, name, year, avg, g, pa, ab, h,
						 hr, rbi, so, fdb, sb, obp, scpos, e, ops);

				br2.add(batter);

			}
			conn.close();
		}catch(SQLException e) {
				e.printStackTrace();//接続やSQL処理失敗時の処理（必要に応じて適切な処理を入れる）
				return null;
		}
		return br2;
    }

//	野手成績検索用
//	searchBatterRecord=sbr
	public ArrayList<BatterRecord> searchBatterRecord(String TeamId, String Name, String Year, String Avg, String G, String Pa, String Ab,
			String H, String Hr, String Rbi, String So, String Fdb, String Sb, String Obp, String Scpos, String E, String Ops) throws ClassNotFoundException{
		ArrayList<BatterRecord> sbr = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			throw e1;
		}

		try(Connection conn = DriverManager.getConnection(
			JDBC_URL, DB_USER, DB_PASS)){
			String sql = "select * from batterrecord where ((teamId like ?) and (name like ?) and (year like ?)"
					+ " and (avg like ?) and (g like ?) and (pa like ?) and (ab like ?) and (h like ?) and (hr like ?)"
					+ " and (rbi like ?) and (so like ?) and (fdb like ?) and (sb like ?) and (obp like ?)"
					+ " and (scpos like ?) and (e like ?) and (ops like ?)) order by convert(teamId, signed)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, "%" + TeamId + "%");
			pStmt.setString(2, "%" + Name + "%");
			pStmt.setString(3, "%" + Year + "%");
			pStmt.setString(4, "%" + Avg + "%");
			pStmt.setString(5, "%" + G + "%");
			pStmt.setString(6, "%" + Pa + "%");
			pStmt.setString(7, "%" + Ab + "%");
			pStmt.setString(8, "%" + H + "%");
			pStmt.setString(9, "%" + Hr + "%");
			pStmt.setString(10, "%" + Rbi + "%");
			pStmt.setString(11, "%" + So + "%");
			pStmt.setString(12, "%" + Fdb + "%");
			pStmt.setString(13, "%" + Sb + "%");
			pStmt.setString(14, "%" + Obp + "%");
			pStmt.setString(15, "%" + Scpos + "%");
			pStmt.setString(16, "%" + E + "%");
			pStmt.setString(17, "%" + Ops + "%");

			ResultSet rs = pStmt.executeQuery();

			while(rs.next()){
				int batterId = rs.getInt("batterId");
				int playerId = rs.getInt("playerId");
				int teamId = rs.getInt("teamId");
				String name = rs.getString("name");
				int year = rs.getInt("year");
				String avg = rs.getString("avg");
				int g = rs.getInt("g");
				int pa = rs.getInt("pa");
				int ab = rs.getInt("ab");
				int h = rs.getInt("h");
				int hr = rs.getInt("hr");
				int rbi = rs.getInt("rbi");
				int so = rs.getInt("so");
				int fdb = rs.getInt("fdb");
				int sb = rs.getInt("sb");
				String obp = rs.getString("obp");
				String scpos = rs.getString("scpos");
				int e = rs.getInt("e");
				String ops = rs.getString("ops");
				BatterRecord record = new BatterRecord(batterId, playerId, teamId, name, year, avg, g, pa, ab, h, hr,
						rbi, so, fdb, sb, obp, scpos, e, ops);

				sbr.add(record);

			}
			conn.close();
		}catch(SQLException e) {
				e.printStackTrace();//接続やSQL処理失敗時の処理（必要に応じて適切な処理を入れる）
				return null;
		}
		return sbr;
    }
}