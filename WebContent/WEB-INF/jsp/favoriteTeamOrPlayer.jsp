<%@page import="java.util.ArrayList"%>
<%@page import= "model.FavoritePlayer" %>
<%@page import= "model.FavoriteTeam" %>
<%@page import= "model.Account" %>
<%@page import= "model.Player" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% ArrayList<FavoritePlayer> fp = (ArrayList<FavoritePlayer>) request.getAttribute("favP"); %>
<% ArrayList<FavoriteTeam> ft = (ArrayList<FavoriteTeam>) request.getAttribute("favT"); %>
<% Account account = (Account) request.getAttribute("account"); %>
<% Player player = (Player) request.getAttribute("player"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/baseball/css/base.css" media="all">

<title>お気に入りチーム・選手</title>
</head>
<body>

<header>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
</header>

<nav>
<jsp:include page="/WEB-INF/jsp/sideMenu.jsp" />
</nav>

<h2>お気に入り選手</h2>

<p><c:out value="${account.getUserId()}さんのお気に入り" /></p>
<table class="tb2" border="1">
	<thead>
		<tr>
			<th>選手</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${favP}" var="fp">
			<tr>
				<td><a class="teamName" href="/baseball/PlayerDataServlet?accountId=${fp.accountId}&teamId=${fp.teamId}&posiId=${fp.posiId}&playerId=${fp.playerId}&userId=${account.getUserId()}"><c:out value="${fp.name}" /></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<br>

<table class="tb2" border="1">
	<thead>
		<tr>
			<th>チーム</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${favT}" var="ft">
			<tr>
				<td><a class="teamName" href="/baseball/TeamServlet?homeAddress=${ft.homeaddress}&name=${ft.name}&homeStadium=${ft.homestadium}&teamId=${ft.teamId}&mapUrl=${ft.mapurl}"><c:out value="${ft.name}" /></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>



<footer>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</footer>

</body>
</html>