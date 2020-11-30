package dao;

import java.sql.Connection;//DBMSへの接続や切断を行う。プログラムとデータベースを結ぶ道路。
import java.sql.DriverManager;//DBMSへの接続準備を行う
import java.sql.PreparedStatement;//SQLの送信を行う。SQLを運ぶ車。
import java.sql.ResultSet;//DBMSから検索結果を受け取る。検索結果を受け取る入れ物のようなもの。
import java.sql.SQLException;//データベースに関するエラー情報を提供する
import java.util.ArrayList;

import model.Account;

public class SelectAccountDAO {
//	データベース接続に使用する情報
	private final String JDBC_URL =
			"jdbc:mysql://localhost:3306/baseball?serverTimezone=JST&useSSL=false";
	private final String DB_USER = "root";
	private final String DB_PASS = "a3112336";

//	AccounT = at
	public ArrayList<Account> getAccount(String searchUserId) throws ClassNotFoundException{
		ArrayList<Account> at = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			throw e1;
		}

		try(Connection conn = DriverManager.getConnection(
			JDBC_URL, DB_USER, DB_PASS)){
			String sql = "select * from account where userId = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, searchUserId);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()){
				int accountId = rs.getInt("accountId");
				String userId = rs.getString("userId");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String pass = rs.getString("pass");
				String mail = rs.getString("mail");
				String address = rs.getString("address");
				String tel = rs.getString("tel");
				Account user = new Account(accountId, userId, firstName, lastName, pass, mail, address, tel);
				at.add(user);

			}
			conn.close();
		}catch(SQLException e) {
				e.printStackTrace();//接続やSQL処理失敗時の処理（必要に応じて適切な処理を入れる）
				return null;
		}
		return at;
    }

//	AccounT = at
	public ArrayList<Account> getAccount2(int AccountId) throws ClassNotFoundException{
		ArrayList<Account> at = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			throw e1;
		}

		try(Connection conn = DriverManager.getConnection(
			JDBC_URL, DB_USER, DB_PASS)){
			String sql = "select * from account where accountId = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, AccountId);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()){
				int accountId = rs.getInt("accountId");
				String userId = rs.getString("userId");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String pass = rs.getString("pass");
				String mail = rs.getString("mail");
				String address = rs.getString("address");
				String tel = rs.getString("tel");
				Account user = new Account(accountId, userId, firstName, lastName, pass, mail, address, tel);

				at.add(user);

			}
			conn.close();
		}catch(SQLException e) {
				e.printStackTrace();//接続やSQL処理失敗時の処理（必要に応じて適切な処理を入れる）
				return null;
		}
		return at;
    }

	public ArrayList<Account> updateAccount(String UserID, String UserId, String LastName, String FirstName, String Pass,
			String Mail, String Address, String Tel) throws ClassNotFoundException{
		ArrayList<Account> at = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			throw e1;
		}

		try(Connection conn = DriverManager.getConnection(
			JDBC_URL, DB_USER, DB_PASS)){
			String sql = "update account set userId = ?, lastName = ?, firstName = ?, pass = ?,"
					+ " mail = ?, address = ?, tel = ? where userId = ?";
//	        setAutoCommitメソッドで引数はfalse。オートコミットじゃないようにした。
//			conn.setAutoCommit(false);
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(8, UserID);
			pStmt.setString(1, UserId);
			pStmt.setString(2, LastName);
			pStmt.setString(3, FirstName);
			pStmt.setString(4, Pass);
			pStmt.setString(5, Mail);
			pStmt.setString(6, Address);
			pStmt.setString(7, Tel);

			pStmt.executeUpdate();
//			conn.commit();
//			while(rs.next()){
//				int accountId = rs.getInt("accountId");
//				String userId = rs.getString("userId");
//				String firstName = rs.getString("firstName");
//				String lastName = rs.getString("lastName");
//				String pass = rs.getString("pass");
//				String mail = rs.getString("mail");
//				String address = rs.getString("address");
//				String tel = rs.getString("tel");
//				Account user = new Account(accountId, userId, firstName, lastName, pass, mail, address, tel);
//
//				at.add(user);
//			}
			conn.close();
		}catch(SQLException e) {
				e.printStackTrace();//接続やSQL処理失敗時の処理（必要に応じて適切な処理を入れる）
				return null;
		}
		return at;
    }
}