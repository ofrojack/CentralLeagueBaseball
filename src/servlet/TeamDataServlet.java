package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CentralLeagueStandingsDAO;
import model.CentralTeam;


@WebServlet("/TeamDataServlet")
public class TeamDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

//		Team1Servletからの本拠地住所表示を参考に、
//		ctリストから表示するのか、servletのgetパラメータにするのか考える。
//		request.setCharacterEncoding("UTF-8");
//		String teamID = request.getParameter("teamId");
//		int teamId = Integer.parseInt(teamID);
//
//		SelectAllPlayerDAO psDAO = new SelectAllPlayerDAO();
//		ArrayList<Player> ps = null;
//		try {
//			ps = psDAO.getPlayer(teamId);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
////		System.out.println(teamId);
//		request.setAttribute("player", ps);
//		request.setAttribute("teamId", teamId);


		request.setCharacterEncoding("UTF-8");
		String homeAddress = request.getParameter("homeAddress");

		CentralLeagueStandingsDAO ctDAO = new CentralLeagueStandingsDAO();
		ArrayList<CentralTeam> ct = null;
		try {
			ct = ctDAO.getTeam();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		request.setAttribute("centralTeam", ct);
		request.setAttribute("homeAddress", homeAddress);
//		System.out.println(ct);
//		System.out.println("処理終了");



		String view = "/WEB-INF/jsp/teamData.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}


	protected void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

	}

}
