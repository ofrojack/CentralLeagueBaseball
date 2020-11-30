<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/baseball/css/base.css" media="all">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<title>アカウント登録画面</title>
</head>
<body>

<header>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
</header>

<nav>
<jsp:include page="/WEB-INF/jsp/sideMenu.jsp" />
</nav>

<h2>アカウント新規登録</h2>

<table class="loginTable" border="1">
	<form action="/baseball/CreateAccountCheckServlet" method="post">
		<thead>
			<tr>
				<th>ユーザー名*</th>
				<td><input type="text" name="userId" maxlength="12" placeholder="半角英数字4～12字" required autofocus></td>
			</tr>
			<tr>
				<th>姓</th>
				<td><input type="text" name="lastName" placeholder="野球"></td>
			</tr>
			<tr>
				<th>名</th>
				<td><input type="text" name="firstName" placeholder="セ太郎"></td>
			</tr>
			<tr>
				<th>パスワード*</th>
				<td><input type="password" name="pass" maxlength="12" placeholder="半角英数字4～12字" required></td>
			</tr>
			<tr>
				<th>メールアドレス</th>
				<td><input type="email" name="mail" placeholder="info@sample.com"></td>
			</tr>
			<tr>
				<th>住所</th>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<th>電話番号</th>
				<td><input type="tel" name="tel" placeholder="09012345678"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="登録"></td>
			</tr>
		</thead>
	</form>
</table>

<footer>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</footer>

</body>
</html>