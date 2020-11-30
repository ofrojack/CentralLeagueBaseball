<%@page import="java.util.ArrayList"%>
<%@page import= "model.Player" %>
<%@page import= "model.Account" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% ArrayList<Player> ps = (ArrayList<Player>) request.getAttribute("player"); %>
<% ArrayList<Account> at = (ArrayList<Account>) request.getAttribute("user"); %>
<% Account account = (Account) request.getAttribute("account"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/baseball/css/${teamId}.css" media="all">
<!-- ↑今だけnewPlayerList.cssでテスト。元は${teamId}.css。 -->
<title>選手一覧</title>
</head>
<body>

<header>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
</header>

<nav>
	<jsp:include page="/WEB-INF/jsp/sideMenu.jsp" />
</nav>

<h2>選手一覧</h2>

<div class="full" id="content">
	<div class="playerlist">
		<h3>投　手</h3>
		<table class="tb3" border="1">
			<tbody>
				<c:forEach items="${pitcher}" var="p">
					<tr>
						<td class="td_l">
							<div class="player_btn">
								<a href="PlayerDataServlet?teamId=${teamId}&playerId=${p.playerId}&posiId=${p.posiId}&userId=${userId}"><img src="/baseball/img/player/${p.playerId}.jpg" alt="${p.name}"  class="floatleft">
									<div class="player_text">
										<p class="num"><c:out value="${p.num}" /></p>
										<p class="name"><c:out value="${p.name}" /></p>
										<p class="name2"><c:out value="${p.kana}" /></p>
									</div>
								</a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="playerlist">
		<h3>捕　手</h3>
		<table class="tb3" border="1">
			<tbody>
				<c:forEach items="${catcher}" var="c">
					<tr>
						<td class="td_l">
							<div class="player_btn">
								<a href="PlayerDataServlet?teamId=${teamId}&playerId=${c.playerId}&posiId=${c.posiId}&userId=${userId}&accountId=${account.getAccountId()}"><img src="/baseball/img/player/${c.playerId}.jpg" alt="${c.name}" width="50" height="60" class="floatleft">
									<div class="player_text">
										<p class="num"><c:out value="${c.num}" /></p>
										<p class="name"><c:out value="${c.name}" /></p>
										<p class="name2"><c:out value="${c.kana}" /></p>
									</div>
								</a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="playerlist">
		<h3>内野手</h3>
		<table class="tb3" border="1">
			<tbody>
				<c:forEach items="${infielder}" var="in">
					<tr>
						<td class="td_l">
							<div class="player_btn">
								<a href="PlayerDataServlet?teamId=${teamId}&playerId=${in.playerId}&posiId=${in.posiId}&userId=${userId}&accountId=${account.getAccountId()}"><img src="/baseball/img/player/${in.playerId}.jpg" alt="${in.name}" width="50" height="60" class="floatleft">
									<div class="player_text">
										<p class="num"><c:out value="${in.num}" /></p>
										<p class="name"><c:out value="${in.name}" /></p>
										<p class="name2"><c:out value="${in.kana}" /></p>
									</div>
								</a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="playerlist">
		<h3>外野手</h3>
		<table class="tb3" border="1">
			<tbody>
				<c:forEach items="${outfielder}" var="ou">
					<tr>
						<td class="td_l">
							<div class="player_btn">
								<a href="PlayerDataServlet?teamId=${teamId}&playerId=${ou.playerId}&posiId=${ou.posiId}&userId=${userId}&accountId=${account.getAccountId()}"><img src="/baseball/img/player/${ou.playerId}.jpg" alt="${ou.name}" width="50" height="60" class="floatleft">
									<div class="player_text">
										<p class="num"><c:out value="${ou.num}" /></p>
										<p class="name"><c:out value="${ou.name}" /></p>
										<p class="name2"><c:out value="${ou.kana}" /></p>
									</div>
								</a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>


<!--
<table border="1">
    <thead>
        <tr>
        	<th></th>
            <th>背番号</th>
            <th>名前</th>
        </tr>
    </thead>
    <tbody>
<c:forEach items="${player}" var="ps">
   <tr>
  	 <td><a href="PlayerDataServlet?teamId=${teamId}&playerId=${ps.playerId}&posiId=${ps.posiId}"><img class="player" src="/baseball/img/player/${ps.playerId}.jpg"></a></td>
     <td><c:out value="${ps.num}" /></td>
     <td><c:out value="${ps.lastName} ${ps.firstName}" /></td>
   </tr>
</c:forEach>
    </tbody>
</table>
 -->

<footer>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</footer>

</body>
</html>