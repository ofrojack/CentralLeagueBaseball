<%@page import="java.util.ArrayList"%>
<%@page import= "model.Account" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% ArrayList<Account> at = (ArrayList<Account>) request.getAttribute("account"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/baseball/css/base.css" media="all">

<title>会員情報の変更</title>
</head>
<body>

<header>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
</header>

<nav>
<jsp:include page="/WEB-INF/jsp/sideMenu.jsp" />
</nav>

<table class="updateForm" border="1">
	<c:forEach items="${account}" var="at">
		<form action="/baseball/UpdateAccountCheckServlet?userID=${userID}" method="post">
			<thead>
				<tr>
					<th>項目</th>
					<th>変更前</th>
					<th>変更後</th>
				</tr>
				<tr>
					<th>ユーザー名*</th>
					<td><c:out value="${at.userId}" /></td>
					<td><input type="text" name="userId" pattern="^([a-zA-Z0-9]{4,12})$" maxlength="12" placeholder="英数字半角4字以上12字以内" required autofocus></td>
				</tr>
				<tr>
					<th>姓</th>
					<td><c:out value="${at.lastName}" /></td>
					<td><input type="text" name="lastName" placeholder="野球"></td>
				</tr>
				<tr>
					<th>名</th>
					<td><c:out value="${at.firstName}" /></td>
					<td><input type="text" name="firstName" placeholder="セ太郎"></td>
				</tr>
				<tr>
					<th>パスワード*</th>
					<td><c:out value="${at.pass}" /></td>
					<td><input type="password" name="pass" maxlength="8" placeholder="英数字半角8字以内" required></td>
				</tr>
				<tr>
					<th>メールアドレス</th>
					<td><c:out value="${at.mail}" /></td>
					<td><input type="email" name="mail" placeholder="info@sample.com"></td>
				</tr>
				<tr>
					<th>住所</th>
					<td><c:out value="${at.address}" /></td>
					<td><input type="text" name="address"></td>
				</tr>
				<tr>
					<th>電話番号</th>
					<td><c:out value="${at.tel}" /></td>
					<td><input type="tel" name="tel" pattern="[0-9]{3}[0-9]{4}[0-9]{4}" placeholder="09012345678"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="reset" name="Submit2" value="リセット"></td>
					<td colspan="3"><input type="submit" value="登録"></td>
				</tr>
			</thead>
		</form>
	</c:forEach>
</table>

<footer>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</footer>

</body>
</html>