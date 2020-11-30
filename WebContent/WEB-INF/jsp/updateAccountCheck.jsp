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

<title>会員情報の変更の確認</title>
</head>
<body>

<header>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
</header>

<nav>
<jsp:include page="/WEB-INF/jsp/sideMenu.jsp" />
</nav>

<%
String userID = (String) session.getAttribute("userID");
String userId = (String) session.getAttribute("userId");
String lastName = (String) session.getAttribute("lastName");
String firstName = (String) session.getAttribute("firstName");
String pass = (String) session.getAttribute("pass");
String mail = (String) session.getAttribute("mail");
String address = (String) session.getAttribute("address");
String tel = (String) session.getAttribute("tel");


request.setAttribute("userID", userID);
request.setAttribute("userId", userId);
request.setAttribute("lastName", lastName);
request.setAttribute("firstName", firstName);
request.setAttribute("pass", pass);
request.setAttribute("mail", mail);
request.setAttribute("address", address);
request.setAttribute("tel", tel);

%>

<p>下記の内容に変更してもよろしいですか？</p>

<table class="updateForm" border="1">
	<form action="UpdateAccountResultServlet?userID=${userID}" method="post">
		<thead>
			<tr>
				<th>ユーザー名*</th>
				<td><c:out value="${userId}" /></td>
				<input type="hidden" name="userId" value="${userId}">
			</tr>
			<tr>
				<th>姓</th>
				<td><c:out value="${lastName}" /></td>
				<input type="hidden" name="lastName" value="${lastName}">
			</tr>
			<tr>
				<th>名</th>
				<td><c:out value="${firstName}" /></td>
				<input type="hidden" name="firstName" value="${firstName}">
			</tr>
			<tr>
				<th>パスワード*</th>
				<td><c:out value="${pass}" /></td>
				<input type="hidden" name="pass" value="${pass}">
			</tr>
			<tr>
				<th>メールアドレス</th>
				<td><c:out value="${mail}" /></td>
				<input type="hidden" name="mail" value="${mail}">
			</tr>
			<tr>
				<th>住所</th>
				<td><c:out value="${address}" /></td>
				<input type="hidden" name="address" value="${address}">
			</tr>
			<tr>
				<th>電話番号</th>
				<td><c:out value="${tel}" /></td>
				<input type="hidden" name="tel" value="${tel}">
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