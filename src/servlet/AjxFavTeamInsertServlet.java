package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.FavoriteTeam;
import model.FavoriteTeamInsertLogic;

@WebServlet("/AjxFavTeamInsertServlet")
public class AjxFavTeamInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");

        // Ajaxで渡されたテキストボックスの値を変数に格納
        String teamID = request.getParameter("teamId");
        int teamId = Integer.parseInt(teamID);

        System.out.println("AjxFavTeamInsertServlet33/teamId：" + teamId);

        FavoriteTeam favoriteTeam = new FavoriteTeam(account.getAccountId(), teamId);
        System.out.println("AjxFavTeamInsertServlet36/accountId:" + account.getAccountId());
        int accountId = account.getAccountId();
        request.setAttribute("accountId", accountId);
        request.setAttribute("teamId", teamId);
        FavoriteTeamInsertLogic bo = new FavoriteTeamInsertLogic();
		boolean result = bo.execute(favoriteTeam);
		request.setAttribute("result", result);
		System.out.println("AjxFavTeamInsertServlet43/result:" + result);

        // 返却値に設定
        PrintWriter out = response.getWriter();
        out.print(result);
	}
}