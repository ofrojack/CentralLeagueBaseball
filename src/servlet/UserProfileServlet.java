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

@WebServlet("/UserProfileServlet")
public class UserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");

		SelectAccountDAO saDAO = new SelectAccountDAO();
		ArrayList<Account> at = null;
		try {
			at = saDAO.getAccount(userId);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		request.setAttribute("account", at);
		request.setAttribute("userId", userId);

//		フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/WEB-INF/jsp/userProfile.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

	}

}
