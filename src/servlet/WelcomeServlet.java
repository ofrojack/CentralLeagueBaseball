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

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

		CentralLeagueStandingsDAO ctDAO = new CentralLeagueStandingsDAO();
		ArrayList<CentralTeam> ct = null;
		try {
			ct = ctDAO.getTeam();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		request.setAttribute("centralTeam", ct);

		String view = "/WEB-INF/jsp/welcome.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
	}
}