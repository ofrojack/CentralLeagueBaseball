<%@page import="java.util.ArrayList"%>
<%@page import= "model.CentralTeam" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% ArrayList<CentralTeam> ct = (ArrayList<CentralTeam>) request.getAttribute("centralTeam"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/baseball/css/base.css" media="all">

<title>チーム一覧画面</title>
</head>
<body>

<header>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
</header>

<nav>
<jsp:include page="/WEB-INF/jsp/sideMenu.jsp" />
</nav>

<h2>チーム一覧</h2>

<table class="tb2" border="1">
	<thead>
		<tr>
			<th>チーム</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${centralTeam}" var="ct">
			<tr>
				<td><a class="teamName" href="/baseball/TeamServlet?homeAddress=${ct.homeAddress}&name=${ct.name}&homeStadium=${ct.homeStadium}&teamId=${ct.teamId}&mapUrl=${ct.mapUrl}"><c:out value="${ct.name}" /></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<footer>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</footer>

</body>
</html>