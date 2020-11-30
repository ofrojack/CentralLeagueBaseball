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
import model.FavoriteTeamDeleteLogic;


@WebServlet("/AjxFavTeamDeleteServlet")
public class AjxFavTeamDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");

        // Ajaxで渡されたテキストボックスの値を変数に格納
        String teamID = request.getParameter("teamId");
        int teamId = Integer.parseInt(teamID);

        System.out.println("AjxFavTeamDeleteServlet33/teamId：" + teamId);

        FavoriteTeam favoriteTeam = new FavoriteTeam(account.getAccountId(), teamId);
        FavoriteTeamDeleteLogic bo = new FavoriteTeamDeleteLogic();
		boolean result = bo.execute(favoriteTeam);

        // 返却値に設定
        PrintWriter out = response.getWriter();
        out.print(result);
	}

}