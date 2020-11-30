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

import dao.BatterRecordDAO;
import dao.PitcherRecordDAO;
import model.BatterRecord;
import model.PitcherRecord;

@WebServlet("/SearchRecordServlet")
public class SearchRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

//		フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/WEB-INF/jsp/searchRecordForm.jsp");
		dispatcher.forward(request,  response);

	}

	protected void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

//		野手検索
//		リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String name		= request.getParameter("name");
		if(name == null) {
			name = "";
		}
		System.out.println(name);
		String teamId	= request.getParameter("teamId");
		System.out.println(teamId);
		String year	= request.getParameter("year");
		System.out.println(year);
		String avg		= request.getParameter("avg");
		if(avg == null) {
			avg = "";
		}
		System.out.println(avg);
		String g	= request.getParameter("g");
		if(g == null) {
			g = "";
		}
		System.out.println(g);
		String pa	= request.getParameter("pa");
		if(pa == null) {
			pa = "";
		}
		System.out.println(pa);
		String ab	= request.getParameter("ab");
		if(ab == null) {
			ab = "";
		}
		System.out.println(ab);
		String h	= request.getParameter("h");
		if(h == null) {
			h = "";
		}
		System.out.println(h);
		String hr	= request.getParameter("hr");
		if(hr == null) {
			hr = "";
		}
		System.out.println(hr);
		String rbi	= request.getParameter("rbi");
		if(rbi == null) {
			rbi = "";
		}
		System.out.println(rbi);
		String so	= request.getParameter("so");
		if(so == null) {
			so = "";
		}
		System.out.println(so);
		String fdb	= request.getParameter("fdb");
		if(fdb == null) {
			fdb = "";
		}
		System.out.println(fdb);
		String sb	= request.getParameter("sb");
		if(sb == null) {
			sb = "";
		}
		System.out.println(sb);
		String obp	= request.getParameter("obp");
		if(obp == null) {
			obp = "";
		}
		System.out.println(obp);
		String scpos	= request.getParameter("scpos");
		if(scpos == null) {
			scpos = "";
		}
		System.out.println(scpos);
		String e	= request.getParameter("e");
		if(e == null) {
			e = "";
		}
		System.out.println(e);
		String ops	= request.getParameter("ops");
		if(ops == null) {
			ops = "";
		}
		System.out.println(ops);

		BatterRecordDAO sbrDAO = new BatterRecordDAO();
		ArrayList<BatterRecord> sbr = null;
		try {
			sbr = sbrDAO.searchBatterRecord(teamId, name, year, avg, g, pa, ab, h, hr,
					rbi, so, fdb, sb, obp, scpos, e, ops);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
//			System.out.println("入力されてない項目があります");
//			response.setIntHeader("Refresh", 5);
		}

//		リクエストスコープに保存！
		HttpSession session = request.getSession();
		request.setAttribute("batterrecord", sbr);
		session.setAttribute("teamId", teamId);
		session.setAttribute("name", name);
		session.setAttribute("year", year);
		session.setAttribute("avg", avg);
		session.setAttribute("g", g);
		session.setAttribute("pa", pa);
		session.setAttribute("ab", ab);
		session.setAttribute("h", h);
		session.setAttribute("hr", hr);
		session.setAttribute("rbi", rbi);
		session.setAttribute("so", so);
		session.setAttribute("fdb", fdb);
		session.setAttribute("sb", sb);
		session.setAttribute("obp", obp);
		session.setAttribute("scpos", scpos);
		session.setAttribute("e", e);
		session.setAttribute("ops", ops);

//		投手検索
//		リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String teamID	= request.getParameter("teamID");
		System.out.println(teamID);
		String namE		= request.getParameter("namE");
		if(namE == null) {
			namE = "";
		}
		System.out.println(namE);
		String yeaR	= request.getParameter("yeaR");
		System.out.println(yeaR);
		String erA		= request.getParameter("erA");
		if(erA == null) {
			erA = "";
		}
		System.out.println(erA);
		String O	= request.getParameter("O");
		if(O == null) {
			O = "";
		}
		System.out.println(O);
		String stA	= request.getParameter("stA");
		if(stA == null) {
			stA = "";
		}
		System.out.println(stA);
		String cG	= request.getParameter("cG");
		if(cG == null) {
			cG = "";
		}
		System.out.println(cG);
		String iP	= request.getParameter("iP");
		if(iP == null) {
			iP = "";
		}
		System.out.println(iP);
		String W	= request.getParameter("W");
		if(W == null) {
			W = "";
		}
		System.out.println(W);
		String L	= request.getParameter("L");
		if(L == null) {
			L = "";
		}
		System.out.println(L);
		String hold	= request.getParameter("H");
		if(hold == null) {
			hold = "";
		}
		System.out.println(hold);
		String hP	= request.getParameter("hP");
		if(hP == null) {
			hP = "";
		}
		System.out.println(hP);
		String sV	= request.getParameter("sV");
		if(sV == null) {
			sV = "";
		}
		System.out.println(sV);
		String wpcT	= request.getParameter("wpcT");
		if(wpcT == null) {
			wpcT = "";
		}
		System.out.println(wpcT);
		String K	= request.getParameter("K");
		if(K == null) {
			K = "";
		}
		System.out.println(K);
		String R	= request.getParameter("R");
		if(R == null) {
			R = "";
		}
		System.out.println(R);
		String obA	= request.getParameter("obA");
		if(obA == null) {
			obA = "";
		}
		System.out.println(obA);
		String whiP	= request.getParameter("whiP");
		if(whiP == null) {
			whiP = "";
		}
		System.out.println(whiP);

		PitcherRecordDAO sprDAO = new PitcherRecordDAO();
		ArrayList<PitcherRecord> spr = null;
		try {
			spr = sprDAO.searchPitcherRecord(teamID, namE, yeaR, erA, O, stA,
					cG, iP, W, L, hold, hP, sV, wpcT, K, R, obA, whiP);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
//			System.out.println("入力されてない項目があります");
//			response.setIntHeader("Refresh", 5);
		}

//		リクエストスコープに保存！
		request.setAttribute("pitcherrecord", spr);
		session.setAttribute("teamId", teamId);
		session.setAttribute("name", name);
		session.setAttribute("year", year);
		session.setAttribute("avg", avg);
		session.setAttribute("g", g);
		session.setAttribute("pa", pa);
		session.setAttribute("ab", ab);
		session.setAttribute("h", h);
		session.setAttribute("hr", hr);
		session.setAttribute("rbi", rbi);
		session.setAttribute("so", so);
		session.setAttribute("fdb", fdb);
		session.setAttribute("sb", sb);
		session.setAttribute("obp", obp);
		session.setAttribute("scpos", scpos);
		session.setAttribute("e", e);
		session.setAttribute("ops", ops);

//		フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/WEB-INF/jsp/searchRecord.jsp");
		dispatcher.forward(request,  response);

	}
}