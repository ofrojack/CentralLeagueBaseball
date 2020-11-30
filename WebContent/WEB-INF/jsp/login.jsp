<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/baseball/css/base.css" media="all">

<title>Central League Baseball</title>
</head>
<body>

<header>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
</header>

<nav>
<jsp:include page="/WEB-INF/jsp/sideMenu.jsp" />
</nav>


<h2>マイページへログイン</h2>

<table class="loginTable" border="1">
	<form action="/baseball/LoginServlet" method="post">
		<thead>
			<tr>
				<th>ユーザーID</th>
				<td><input type="text" name="userId"></td>
			</tr>
			<tr>
				<th>パスワード</th>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="ログイン"></td>
			</tr>
		</thead>
	</form>
</table>


<p><a href="/baseball/CreateAccountServlet">新規アカウント登録はこちら</a></p>

<!--
<p><a href="/baseball/WelcomeServlet">トップへ戻る</a></p>
-->

<footer>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</footer>

</body>
</html>