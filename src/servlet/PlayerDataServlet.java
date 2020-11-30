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
import dao.SelectAllPlayerDAO;
import model.Account;
import model.BatterRecord;
import model.FavoritePlayerInsertLogic;
import model.PitcherRecord;
import model.Player;
import model.SearchFavPlayer;

@WebServlet("/PlayerDataServlet")
public class PlayerDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");
//		String accountID = request.getParameter("accountId");
//		int accountId = Integer.parseInt(accountID);
//		System.out.println("PlayerDataServlet39/accountId:" + accountId);
		String userId = request.getParameter("userId");
		System.out.println("PlayerDataServlet41/userId:" + userId);
		String playerID = request.getParameter("playerId");
		int playerId = Integer.parseInt(playerID);
		System.out.println("PlayerDataServlet44/playerId:" + playerId);
		String teamID = request.getParameter("teamId");
		int teamId = Integer.parseInt(teamID);
		System.out.println("PlayerDataServlet47/teamId:" + teamId);
		String posiID = request.getParameter("posiId");
		int posiId = Integer.parseInt(posiID);
		System.out.println("PlayerDataServlet50/posiId:" + posiId);

//		favplayerから検索
//		ログイン処理の実行
		SearchFavPlayer searchFavPlayer = new SearchFavPlayer(account.getAccountId(), playerId);
        FavoritePlayerInsertLogic bo = new FavoritePlayerInsertLogic();
		boolean result = bo.execute2(searchFavPlayer);

//		セッションスコープにresultを保存
		session.setAttribute("result", result);
		System.out.println("PlayerDataServlet85/result:" + result);
		request.setAttribute("result", result);

//		選手情報を検索
		SelectAllPlayerDAO psDAO = new SelectAllPlayerDAO();
		ArrayList<Player> ps = null;
		try {
			ps = psDAO.getPlayer2(teamId, playerId);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if(posiId == 1){//posiIdが1(投手)の処理
			PitcherRecordDAO pr2DAO = new PitcherRecordDAO();
			ArrayList<PitcherRecord> pr2 = null;
			try {
				pr2 = pr2DAO.getPitcherRecord(playerId);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			request.setAttribute("pitcherRecord", pr2);
		}else{//posiIdが1(投手)以外の処理
			BatterRecordDAO br2DAO = new BatterRecordDAO();
			ArrayList<BatterRecord> br2 = null;
			try {
				br2 = br2DAO.getBatterRecord(playerId);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			request.setAttribute("batterRecord", br2);
		}

		request.setAttribute("player", ps);
		request.setAttribute("playerId", playerId);
		request.setAttribute("teamId", teamId);
		request.setAttribute("posiId", posiId);

		String view = "/WEB-INF/jsp/playerData.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
	}
}