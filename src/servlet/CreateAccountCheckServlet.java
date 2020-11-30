package servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CreateAccountCheckServlet")
public class CreateAccountCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

//		リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String pass = request.getParameter("pass");
		String mail = request.getParameter("mail");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");

//		正規表現パターンを用意する
		String regex_num = "[0-9]{3}[0-9]{4}[0-9]{4}+$" ;//半角数字のみ
		String regex_alphaNum = "^[A-Za-z0-9]{4,12}+$" ; // 半角英数字のみ
	    String regex_mail = "^([a-zA-Z0-9])+([a-zA-Z0-9\\._-])*@([a-zA-Z0-9_-])+([a-zA-Z0-9\\._-]+)+$";//mail

//	    Javaの正規表現ライブラリで事前準備をする
//	    ドSやめる
	    Pattern p1 = Pattern.compile(regex_num); // 正規表現パターンの読み込み
	    Pattern p2 = Pattern.compile(regex_alphaNum);
	    Pattern p3 = Pattern.compile(regex_mail);
	    Matcher m1 = p1.matcher(tel); // パターンと検査対象文字列の照合
	    Matcher m2 = p2.matcher(userId);
	    Matcher m3 = p3.matcher(mail);
	    Matcher m4 = p2.matcher(pass);
	    boolean result1 = m1.matches(); // 照合結果をtrueまたはfalseで取得する
	    boolean result2 = m2.matches();
	    boolean result3 = m3.matches();
	    boolean result4 = m4.matches();

//	    結果をコンソールで確認できるように出力する
//	    telの正規表現
	    if(result1) {
	      System.out.println("telは数値です。");
	    } else {
	      System.out.println("telは正しくありません。");
//			フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher(
					"/WEB-INF/jsp/createAccount.jsp");
			dispatcher.forward(request,  response);
	    }

//	    userIdの正規表現
	    if(result2) {
	      System.out.println("userIdは半角英数字です。");
	    } else {
	      System.out.println("userIdは正しくありません。");
//			フォワード
	      RequestDispatcher dispatcher = request.getRequestDispatcher(
					"/WEB-INF/jsp/createAccount.jsp");
	      dispatcher.forward(request,  response);
	    }

//	    mailの正規表現
	    if(result3) {
	      System.out.println("正しいアドレスです。");
	    } else {
	      System.out.println("mailに正しい表現がなされていません。");
//			フォワード
	      RequestDispatcher dispatcher = request.getRequestDispatcher(
					"/WEB-INF/jsp/createAccount.jsp");
	      dispatcher.forward(request,  response);
	    }

//	    passの正規表現
	    if(result4) {
	      System.out.println("passは半角英数字です。");
	    } else {
	      System.out.println("passは正しくありません。");
//			フォワード
	      RequestDispatcher dispatcher = request.getRequestDispatcher(
					"/WEB-INF/jsp/createAccount.jsp");
	      dispatcher.forward(request,  response);
	    }

//		リクエストスコープに保存！
		HttpSession session = request.getSession();
		session.setAttribute("userId", userId);
		session.setAttribute("lastName", lastName);
		session.setAttribute("firstName", firstName);
		session.setAttribute("pass", pass);
		session.setAttribute("mail", mail);
		session.setAttribute("address", address);
		session.setAttribute("tel", tel);

//		フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/WEB-INF/jsp/createAccountCheck.jsp");
		dispatcher.forward(request,  response);

	}
}
