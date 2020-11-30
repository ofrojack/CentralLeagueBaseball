package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SelectAccountDAO;
import model.Account;

@WebServlet("/UpdateAccountResultServlet")
public class UpdateAccountResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

//		リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String userID = request.getParameter("userID");
		String userId = request.getParameter("userId");
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String pass = request.getParameter("pass");
		String mail = request.getParameter("mail");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");

//		DAO前変数デバック
		System.out.println("変更前userID:" + userID);
		System.out.println("変更後userId:" + userId);

//		DAOの処理AccountDAOでupdateメソッド作る
		SelectAccountDAO saDAO = new SelectAccountDAO();
		ArrayList<Account> at = null;
		try {
			at = saDAO.updateAccount(userID, userId, lastName, firstName, pass, mail, address, tel);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

//		リクエストスコープに保存！
		HttpSession session = request.getSession();
		request.setAttribute("account", at);
		request.setAttribute("userID", userID);
		session.setAttribute("userId", userId);
		session.setAttribute("lastName", lastName);
		session.setAttribute("firstName", firstName);
		session.setAttribute("pass", pass);
		session.setAttribute("mail", mail);
		session.setAttribute("address", address);
		session.setAttribute("tel", tel);

//		DAO後変数デバック
		System.out.println("変更前userID:" + userID);
		System.out.println("変更後userId:" + userId);

//		フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/WEB-INF/jsp/updateAccountResult.jsp");
		dispatcher.forward(request,  response);

	}
}