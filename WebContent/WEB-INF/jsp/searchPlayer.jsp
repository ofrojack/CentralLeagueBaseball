<%@page import="java.util.ArrayList"%>
<%@page import= "model.Player" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% ArrayList<Player> ps = (ArrayList<Player>) request.getAttribute("player"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/baseball/css/base.css" media="all">
<title>選手検索</title>
</head>
<body>

<header>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
</header>

<nav>
<jsp:include page="/WEB-INF/jsp/sideMenu.jsp" />
</nav>

<h2>選手検索結果</h2>
<table class="searchResult" border="1">
	<thead>
        <tr>
        	<th>名前</th>
        	<th>なまえ</th>
        	<th>チーム</th>
			<th>ポジション</th>
            <th>背番号</th>
            <th>生年月日</th>
            <th>身長</th>
            <th>体重</th>
            <th>血液型</th>
            <th>投/打</th>
            <th>ドラフト年</th>
            <th>プロ通算年</th>
            <th>出身地</th>
        </tr>
    </thead>
    <tbody>
		<c:forEach items="${player}" var="ps">
		   <tr>
		   		<td><c:out value="${ps.name}" /></td>
		   		<td><c:out value="${ps.kana}" /></td>
		   		<td>
		       <c:choose>
					<c:when test="${ps.teamId == 1}">読売ジャイアンツ</c:when>
					<c:when test="${ps.teamId == 2}">阪神タイガース</c:when>
					<c:when test="${ps.teamId == 3}">横浜DeNAベイスターズ</c:when>
					<c:when test="${ps.teamId == 4}">中日ドラゴンズ</c:when>
					<c:when test="${ps.teamId == 5}">広島東洋カープ</c:when>
					<c:when test="${ps.teamId == 6}">東京ヤクルトスワローズ</c:when>
			   </c:choose>
			   </td>
<!--			 <td><c:out value="${ps.teamId}" /></td>  -->
		       <td>
		       <c:choose>
					<c:when test="${ps.posiId == 1}">投手</c:when>
					<c:when test="${ps.posiId == 2}">捕手</c:when>
					<c:when test="${ps.posiId == 3}">内野手</c:when>
					<c:when test="${ps.posiId == 4}">外野手</c:when>
			   </c:choose>
			   </td>
<!-- 	       <td><c:out value="${ps.posiId}" /></td>-->
		       <td><c:out value="${ps.num}" /></td>
		       <td><c:out value="${ps.birth}" /></td>
		       <td><c:out value="${ps.height}cm" /></td>
		       <td><c:out value="${ps.weight}kg" /></td>
		       <td><c:out value="${ps.blood}" /></td>
		       <td><c:out value="${ps.dexterity}" /></td>
		       <td><c:out value="${ps.draft}年" /></td>
		       <td><c:out value="${ps.career}年" /></td>
		       <td><c:out value="${ps.born}" /></td>
		   </tr>
		</c:forEach>
	</tbody>
</table>

<footer>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</footer>

</body>
</html>