package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CreateAccount;
import model.CreateAccountLogic;


@WebServlet("/CreateAccountServlet")
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
//		フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/WEB-INF/jsp/createAccount.jsp");
		dispatcher.forward(request,  response);
	}

	protected void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

//		リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String userId		= request.getParameter("userId");
		String lastName		= request.getParameter("lastName");
		String firstName	= request.getParameter("firstName");
		String pass			= request.getParameter("pass");
		String mail			= request.getParameter("mail");
		String address		= request.getParameter("address");
		String tel			= request.getParameter("tel");

//		ログイン処理の実行(LoginServlet参照)
		CreateAccount createAccount = new CreateAccount(userId, lastName,
				firstName, pass, mail, address, tel);
		CreateAccountLogic bo = new CreateAccountLogic();
		boolean result = bo.execute(createAccount);

////		ログイン処理の成否によって処理を分岐
		if(result) {//ログイン成功時
//			セッションスコープに保存
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			session.setAttribute("lastName", lastName);
			session.setAttribute("firstName", firstName);
			session.setAttribute("pass", pass);
			session.setAttribute("mail", mail);
			session.setAttribute("address", address);
			session.setAttribute("tel", tel);
//			フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher(
//					↓createAccountCheck画面を挟みたい
					"/WEB-INF/jsp/createAccountResult.jsp");
			dispatcher.forward(request,  response);
		} else {//ログイン失敗時
//			フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher(
					"/WEB-INF/jsp/createAccount.jsp");
			dispatcher.forward(request,  response);
		}
	}
}