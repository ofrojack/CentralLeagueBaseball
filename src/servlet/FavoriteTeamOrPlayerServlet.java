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

import dao.FavoritePlayerDAO;
import dao.FavoriteTeamDAO;
import model.Account;
import model.FavoritePlayer;
import model.FavoriteTeam;

@WebServlet("/FavoriteTeamOrPlayerServlet")
public class FavoriteTeamOrPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");
		request.setAttribute("account", account);

		FavoritePlayerDAO fpDAO = new FavoritePlayerDAO();
		ArrayList<FavoritePlayer> fp = null;
		try {
			fp = fpDAO.findAll(account.getAccountId());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		request.setAttribute("favP", fp);
		System.out.println("FavoriteTeamOrPlayerServlet40/fp:" + fp);

		FavoriteTeamDAO ftDAO = new FavoriteTeamDAO();
		ArrayList<FavoriteTeam> ft = null;
		try {
			ft = ftDAO.findAll(account.getAccountId());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		request.setAttribute("favT", ft);
		System.out.println("FavoriteTeamOrPlayerServlet52/ft:" + ft);

		if (ft == null || fp == null) {
//			フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher(
					"/WEB-INF/jsp/noFav.jsp");
			dispatcher.forward(request,  response);
		}else{
//			フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher(
					"/WEB-INF/jsp/favoriteTeamOrPlayer.jsp");
			dispatcher.forward(request,  response);
		}
	}

		protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		}
}
