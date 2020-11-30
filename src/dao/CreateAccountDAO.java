package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.CreateAccount;

public class CreateAccountDAO {
//	データベース接続に使用する情報
	private final String JDBC_URL =
			"jdbc:mysql://localhost:3306/baseball?serverTimezone=JST&useSSL=false";
	private final String DB_USER = "root";
	private final String DB_PASS = "a3112336";

	public void create(CreateAccount createAccount) throws SQLException, ClassNotFoundException{

//		Class.forName("com.mysql.jdbc.Driver");
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
			String sql = "insert into account(accountId, UserId, lastName, firstName, pass, mail, address, tel) values(0, ?, ?, ?, ?, ?, ?, ?)";
//			SQLをDBに届けるPreparedStatementインスタンスを取得する。
			PreparedStatement pStmt=conn.prepareStatement(sql);
//			insert文中の「?」に使用する値を指定し、SQL文を完成
			pStmt.setString(1, createAccount.getUserId());
			pStmt.setString(2, createAccount.getLastName());
			pStmt.setString(3, createAccount.getFirstName());
			pStmt.setString(4, createAccount.getPass());
			pStmt.setString(5, createAccount.getMail());
			pStmt.setString(6, createAccount.getAddress());
			pStmt.setString(7, createAccount.getTel());
			pStmt.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
}