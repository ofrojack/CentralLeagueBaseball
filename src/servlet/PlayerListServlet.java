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
import dao.SelectAllPlayerDAO;
import model.Account;
import model.Catcher;
import model.Infielder;
import model.Outfielder;
import model.Pitcher;


@WebServlet("/PlayerListServlet")
public class PlayerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
//		HttpSession session = request.getSession();
//		Account account = (Account) session.getAttribute("account");
//		String accountID = request.getParameter("accountId");
//		int accountId = Integer.parseInt(accountID);
		String userId = request.getParameter("userId");
		System.out.println("PlayerDataServlet37/userId:" + userId);
//		String playerID = request.getParameter("playerId");
//		int playerId = Integer.parseInt(playerID);
//		System.out.println("PlayerDataServlet40/playerId:" + playerId);
//		String teamID = request.getParameter("teamId");
//		int teamId = Integer.parseInt(teamID);
//		System.out.println("PlayerDataServlet43/teamId:" + teamId);
//		String posiID = request.getParameter("posiId");
//		int posiId = Integer.parseInt(posiID);
//		System.out.println("PlayerDataServlet46/posiId:" + posiId);

//		accountId取得するためにatDAO
		SelectAccountDAO atDAO = new SelectAccountDAO();
		ArrayList<Account> at = null;
		try {
			at = atDAO.getAccount(userId);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		request.setAttribute("user", at);
		System.out.println("PlayerListServlet57/at:" + at);


//		ピッチャーSELECT用DAO
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");
//		String playerID = request.getParameter("playerId");
//		int playerId = Integer.parseInt(playerID);
		String teamID = request.getParameter("teamId");
		int teamId = Integer.parseInt(teamID);

		SelectAllPlayerDAO pDAO = new SelectAllPlayerDAO();
		ArrayList<Pitcher> p = null;
		try {
			p = pDAO.getPitcher(teamId);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		request.setAttribute("pitcher", p);
		request.setAttribute("teamId", teamId);


//		キャッチャーSELECT用DAO
		SelectAllPlayerDAO cDAO = new SelectAllPlayerDAO();
		ArrayList<Catcher> c = null;
		try {
			c = cDAO.getCatcher(teamId);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		request.setAttribute("catcher", c);
		request.setAttribute("teamId", teamId);

//		内野手SELECT用DAO
		SelectAllPlayerDAO inDAO = new SelectAllPlayerDAO();
		ArrayList<Infielder> in = null;
		try {
			in = inDAO.getInfielder(teamId);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		request.setAttribute("infielder", in);
		request.setAttribute("teamId", teamId);

//		外野手SELECT用DAO
		SelectAllPlayerDAO outDAO = new SelectAllPlayerDAO();
		ArrayList<Outfielder> ou = null;
		try {
			ou = outDAO.getOutfielder(teamId);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		request.setAttribute("outfielder", ou);
		request.setAttribute("teamId", teamId);
		request.setAttribute("account", account);

		String view = "/WEB-INF/jsp/playerList.jsp";
//		String view = "/WEB-INF/jsp/memojsp/memo.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

	}
}