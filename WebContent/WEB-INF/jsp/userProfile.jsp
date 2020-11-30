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

<title>会員情報の表示・変更</title>
</head>
<body>

<header>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
</header>

<nav>
<jsp:include page="/WEB-INF/jsp/sideMenu.jsp" />
</nav>

<h2>会員情報の表示・変更</h2>

<table class="tb2" border="1">
	<c:forEach items="${account}" var="at">
		<thead>
			<tr>
				<th>ID</th>
				<td><c:out value="${at.accountId}" /></td>
			</tr>
			<tr>
				<th>ユーザー名</th>
				<td><c:out value="${at.userId}" /></td>
			</tr>
			<tr>
				<th>姓</th>
				<td><c:out value="${at.lastName}" /></td>
			</tr>
			<tr>
				<th>名</th>
				<td><c:out value="${at.firstName}" /></td>
			</tr>
			<tr>
				<th>パスワード</th>
				<td><c:out value="${at.pass}" /></td>
			</tr>
			<tr>
				<th>メールアドレス</th>
				<td><c:out value="${at.mail}" /></td>
			</tr>
			<tr>
				<th>住所</th>
				<td><c:out value="${at.address}" /></td>
			</tr>
			<tr>
				<th>電話番号</th>
				<td><c:out value="${at.tel}" /></td>
			</tr>
		</thead>
	</c:forEach>
</table>

<p><a href="/baseball/UpdateAccountServlet?userId=${userId}">会員情報を変更</a></p>

<footer>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</footer>

</body>
</html>