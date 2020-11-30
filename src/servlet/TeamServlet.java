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

import dao.CentralLeagueStandingsDAO;
import dao.SelectAllPlayerDAO;
import model.Account;
import model.CentralTeam;
import model.FavoriteTeamInsertLogic;
import model.Player;
import model.SearchFavTeam;

@WebServlet("/TeamServlet")
public class TeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");
		String teamID = request.getParameter("teamId");
		int teamId = Integer.parseInt(teamID);

		SelectAllPlayerDAO psDAO = new SelectAllPlayerDAO();
		ArrayList<Player> ps = null;
		try {
			ps = psDAO.getPlayer(teamId);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("TeamServlet40/teamId:" + teamId);
		request.setAttribute("player", ps);
		request.setAttribute("teamId", teamId);

		request.setCharacterEncoding("UTF-8");
		request.setAttribute("account", account);
		String name = request.getParameter("name");
		String homeAddress = request.getParameter("homeAddress");
		String homeStadium = request.getParameter("homeStadium");
		String mapUrl = request.getParameter("mapUrl");

		CentralLeagueStandingsDAO ctDAO = new CentralLeagueStandingsDAO();
		ArrayList<CentralTeam> ct = null;
		try {
			ct = ctDAO.getTeam();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		request.setAttribute("centralTeam", ct);
		request.setAttribute("name", name);
		request.setAttribute("homeAddress", homeAddress);
		request.setAttribute("homeStadium", homeStadium);
		request.setAttribute("mapUrl", mapUrl);

//		favteamから検索
//		ログイン処理の実行
		SearchFavTeam searchFavTeam = new SearchFavTeam(account.getAccountId(), teamId);
		FavoriteTeamInsertLogic bo = new FavoriteTeamInsertLogic();
		boolean result = bo.execute2(searchFavTeam);

//		セッションスコープにresultを保存
		session.setAttribute("result", result);
		System.out.println("TeamServlet77/result:" + result);
		request.setAttribute("result", result);

		String view = "/WEB-INF/jsp/team.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

	}
}
