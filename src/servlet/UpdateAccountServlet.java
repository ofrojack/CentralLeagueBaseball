package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SelectAccountDAO;
import model.Account;

@WebServlet("/UpdateAccountServlet")
public class UpdateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String userID = request.getParameter("userId");

		SelectAccountDAO saDAO = new SelectAccountDAO();
		ArrayList<Account> at = null;

		try {
			at = saDAO.getAccount(userID);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		request.setAttribute("account", at);
		request.setAttribute("userID", userID);


//		フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/WEB-INF/jsp/updateAccount.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

	}
}