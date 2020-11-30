package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountDAO {
//	データベース接続に使用する情報
	private final String JDBC_URL =
			"jdbc:mysql://localhost:3306/baseball?serverTimezone=JST&useSSL=false";
	private final String DB_USER = "root";
	private final String DB_PASS = "a3112336";

	public Account findByLogin(Login login){
		Account account = null;

//		Class.forName("com.mysql.jdbc.Driver");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

//		データベースへ接続
		try(Connection conn = DriverManager.getConnection(
//			接続先DB、ユーザ名、パスワード
			JDBC_URL, DB_USER, DB_PASS)){

//			SELECT文を準備
			String sql = "select * from account where userId = ? and pass = ?";
//			SQLをDBに届けるPreparedStatementインスタンスを取得する。
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getUserId());
			pStmt.setString(2, login.getPass());

//			SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

//			一致したユーザーが存在した場合、そのユーザーを表すAccountインスタンスを生成
			if(rs.next()) {
//				結果表からデータを取得
				int accountId = rs.getInt("accountId");
				String userId = rs.getString("userId");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String pass = rs.getString("pass");
				String mail = rs.getString("mail");
				String address = rs.getString("address");
				String tel = rs.getString("tel");
				account = new Account(accountId, userId, firstName, lastName, pass, mail, address, tel);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
//		見つかったユーザーを返す
		return account;
	}

//	public Account getAccount(Login login){
//		Account account = null;
//
////		Class.forName("com.mysql.jdbc.Driver");
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e1) {
//			e1.printStackTrace();
//		}
//
////		データベースへ接続
//		try(Connection conn = DriverManager.getConnection(
////			接続先DB、ユーザ名、パスワード
//			JDBC_URL, DB_USER, DB_PASS)){
//
////			SELECT文を準備
//			String sql = "select * from account where userId = ?";
////			SQLをDBに届けるPreparedStatementインスタンスを取得する。
//			PreparedStatement pStmt = conn.prepareStatement(sql);
//			pStmt.setString(1, login.getUserId());
//
////			SELECT文を実行し、結果表を取得
//			ResultSet rs = pStmt.executeQuery();
//
////			一致したユーザーが存在した場合、そのユーザーを表すAccountインスタンスを生成
//			if(rs.next()) {
////				結果表からデータを取得
//				int accountId = rs.getInt("accountId");
//				String userId = rs.getString("userId");
//				String firstName = rs.getString("firstName");
//				String lastName = rs.getString("lastName");
//				String pass = rs.getString("pass");
//				String mail = rs.getString("mail");
//				String address = rs.getString("address");
//				String tel = rs.getString("tel");
//				Account at = new Account(accountId, userId, firstName, lastName, pass, mail, address, tel);
//
//				account.add(at);
//			}
//		}catch(SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
////		見つかったユーザーを返す
//		return account;
//	}
}