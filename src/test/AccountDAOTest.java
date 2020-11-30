package test;

import dao.AccountDAO;
import model.Account;
import model.Login;

public abstract class AccountDAOTest {

	public static void main(String[] args) {
		testFindByLogin1();
		testFindByLogin2();
	}
	public static void testFindByLogin1() {
		Login login = new Login("takuya", "1234");
		AccountDAO dao = new AccountDAO();
		Account result = dao.findByLogin(login);
		if(result != null &&
			result.getUserId().equals("takuya") &&
			result.getFirstName().equals("卓也") &&
			result.getLastName().equals("中嶋") &&
			result.getPass().equals("1234") &&
			result.getMail().equals("taku3-6@docomo.ne.jp") &&
			result.getAddress().equals("神奈川県横浜市戸塚区戸塚町2570-2") &&
			result.getTel().equals("09057745118")) {
			System.out.println("testFindByLogin1:成功しました");
		}else {
			System.out.println("testFindByLogin1:失敗しました");
		}
	}
	public static void testFindByLogin2() {
		Login login = new Login("1", "12345");
		AccountDAO dao = new AccountDAO();
		Account result = dao.findByLogin(login);
		if(result == null) {
			System.out.println("testFindByLogin2:成功しました");
		}else {
			System.out.println("testFindByLogin2:失敗しました");
		}
	}
}
