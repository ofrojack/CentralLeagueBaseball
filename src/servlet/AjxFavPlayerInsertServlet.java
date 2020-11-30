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
import model.FavoritePlayer;
import model.FavoritePlayerInsertLogic;

@WebServlet("/AjxFavPlayerInsertServlet")
public class AjxFavPlayerInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");

//      Ajaxで渡されたテキストボックスの値を変数に格納
        String playerID = request.getParameter("playerId");
        int playerId = Integer.parseInt(playerID);

        System.out.println("AjxFavPlayerInsertServlet32/playerId：" + playerId);

        FavoritePlayer favoritePlayer = new FavoritePlayer(account.getAccountId(), playerId);
        System.out.println("AjxFavPlayerInsertServlet36/accountId:" + account.getAccountId());
        int accountId = account.getAccountId();
        request.setAttribute("accountId", accountId);
        request.setAttribute("playerId", playerId);

        FavoritePlayerInsertLogic bo = new FavoritePlayerInsertLogic();
		boolean result = bo.execute(favoritePlayer);
		request.setAttribute("result", result);
		System.out.println("AjxFavPlayerInsertServlet43/result:" + result);

        // 返却値に設定
        PrintWriter out = response.getWriter();
        out.print(result);
	}
}