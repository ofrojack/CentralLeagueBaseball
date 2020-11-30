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
<title>Central League Baseball</title>
</head>
<body>

<header>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
</header>

<nav>
<jsp:include page="/WEB-INF/jsp/sideMenu.jsp" />
</nav>

<main>
	<section>
		<img class="central1" src="/baseball/img/central/1.jpg">
	</section>

	<section id="tb1">
		<h2>セ・リーグ順位表</h2>
	    <table class="tb1" border="1">
	        <thead>
	            <tr>
	                <th>チーム</th>
	                <th>試合数</th>
	                <th>勝利</th>
	                <th>敗戦</th>
	                <th>引き分け</th>
	                <th>ゲーム差</th>
	            </tr>
	        </thead>
	        <tbody>
				<c:forEach items="${centralTeam}" var="ct">
				    <tr>
				        <td><a class="teamName" href="/baseball/TeamServlet?homeAddress=${ct.homeAddress}&name=${ct.name}&homeStadium=${ct.homeStadium}
				        &teamId=${ct.teamId}&mapUrl=${ct.mapUrl}"><c:out value="${ct.name}" /></a></td>
				        <td><c:out value="${ct.game}" /></td>
				        <td><c:out value="${ct.win}" /></td>
				        <td><c:out value="${ct.lose}" /></td>
				        <td><c:out value="${ct.draw}" /></td>
				        <td><c:out value="${ct.gb}" /></td>
				    </tr>
				</c:forEach>
	        </tbody>
	    </table>
    </section>
</main>

<footer>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</footer>

</body>
</html>