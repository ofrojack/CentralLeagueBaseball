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

import dao.SelectAllPlayerDAO;
import model.Player;

@WebServlet("/SearchPlayerServlet")
public class SearchPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

//		フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/WEB-INF/jsp/searchPlayerForm.jsp");
		dispatcher.forward(request,  response);

	}

	protected void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

//		リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String teamId	= request.getParameter("teamId");
//		int teamId		= Integer.parseInt(teamID);
//		if(teamId == null) {
//			teamId = "";
//		}
		System.out.println(teamId);
		String name		= request.getParameter("name");
		if(name == null) {
			name = "";
		}
		System.out.println(name);
		String kana		= request.getParameter("kana");
		if(kana == null) {
			kana = "";
		}
		System.out.println(kana);
		String posiId	= request.getParameter("posiId");
//		if(posiId == null) {
//			posiId = "";
//		}
		System.out.println(posiId);
		String num		= request.getParameter("num");
		if(num == null) {
			num = "";
		}
		System.out.println(num);
		String birth	= request.getParameter("birth");
		if(birth == null) {
			birth = "";
		}
		System.out.println(birth);
		String height	= request.getParameter("height");
		if(height == null) {
			height = "";
		}
		System.out.println(height);

		String weight	= request.getParameter("weight");
		if(weight == null) {
			weight = "";
		}
		System.out.println(weight);

		String dexterity= request.getParameter("dexterity");
//		if(dexterity == null) {
//			dexterity = "";
//		}
		System.out.println(dexterity);

		String blood	= request.getParameter("blood");
//		if(blood == null) {
//			blood = "";
//		}
		System.out.println(blood);

		String draft	= request.getParameter("draft");
		if(draft == null)
			draft = "";
		System.out.println(draft);

		String career	= request.getParameter("career");
		if(career == null) {
			career = "";
		}
		System.out.println(career);

		String born		= request.getParameter("born");
//		if(born == null) {
//			born = "";
//		}
		System.out.println(born);

//		SelectAllPlayerDAO psDAO = new SelectAllPlayerDAO();
//		ArrayList<Player> ps = null;
//		try {
//			ps = psDAO.searchPlayer(teamId, name, posiId, num, birth, height, weight, dexterity, blood, draft, career);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}


		SelectAllPlayerDAO psDAO = new SelectAllPlayerDAO();
		ArrayList<Player> ps = null;
		try {
			ps = psDAO.searchPlayer(teamId, name, kana, posiId, num, birth, height, weight, dexterity, blood, draft, career, born);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
//			System.out.println("入力されてない項目があります");
//			response.setIntHeader("Refresh", 5);
		}

//		リクエストスコープに保存！
		HttpSession session = request.getSession();
		request.setAttribute("player", ps);
		session.setAttribute("teamId", teamId);
		session.setAttribute("name", name);
		session.setAttribute("kana", kana);
		session.setAttribute("posiId", posiId);
		session.setAttribute("num", num);
		session.setAttribute("birth", birth);
		session.setAttribute("height", height);
		session.setAttribute("weight", weight);
		session.setAttribute("dexterity", dexterity);
		session.setAttribute("blood", blood);
		session.setAttribute("draft", draft);
		session.setAttribute("career", career);
		session.setAttribute("born", born);

//		フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/WEB-INF/jsp/searchPlayer.jsp");
		dispatcher.forward(request,  response);

	}
}