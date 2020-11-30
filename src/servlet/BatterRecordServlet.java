package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BatterRecordDAO;
import model.BatterRecord;

@WebServlet("/BatterRecordServlet")
public class BatterRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String teamID = request.getParameter("teamId");
		int teamId = Integer.parseInt(teamID);

		BatterRecordDAO brDAO = new BatterRecordDAO();
		ArrayList<BatterRecord> br = null;
		try {
			br = brDAO.getBatter(teamId);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		request.setAttribute("batterRecord", br);
		request.setAttribute("teamId", teamId);

//		フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/WEB-INF/jsp/batterRecord.jsp");
		dispatcher.forward(request,  response);

	}

	protected void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

	}

}
