package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/UpdateAccountCheckServlet")
public class UpdateAccountCheckServlet extends HttpServlet {
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

////		DAOの処理AccountDAOでupdateメソッド作る
//		SelectAccountDAO saDAO = new SelectAccountDAO();
//		ArrayList<Account> at = null;
//		try {
//			at = saDAO.updateAccount(userId,lastName, firstName, pass, mail, address, tel);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}

//		リクエストスコープに保存！
		HttpSession session = request.getSession();
//		request.setAttribute("account", at);
		session.setAttribute("userID", userID);
		session.setAttribute("userId", userId);
		session.setAttribute("lastName", lastName);
		session.setAttribute("firstName", firstName);
		session.setAttribute("pass", pass);
		session.setAttribute("mail", mail);
		session.setAttribute("address", address);
		session.setAttribute("tel", tel);

//		フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/WEB-INF/jsp/updateAccountCheck.jsp");
		dispatcher.forward(request,  response);

	}

}
