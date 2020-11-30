package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PitcherRecordDAO;
import model.PitcherRecord;

@WebServlet("/PitcherRecordServlet")
public class PitcherRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String teamID = request.getParameter("teamId");
		int teamId = Integer.parseInt(teamID);

		PitcherRecordDAO prDAO = new PitcherRecordDAO();
		ArrayList<PitcherRecord> pr = null;
		try {
			pr = prDAO.getPitcher(teamId);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		request.setAttribute("pitcherRecord", pr);
		request.setAttribute("teamId", teamId);

//		フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/WEB-INF/jsp/pitcherRecord.jsp");
		dispatcher.forward(request,  response);

	}

	protected void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

	}

}

