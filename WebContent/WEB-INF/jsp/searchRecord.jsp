<%@page import="java.util.ArrayList"%>
<%@page import= "model.BatterRecord" %>
<%@page import= "model.PitcherRecord" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% ArrayList<BatterRecord> sbr = (ArrayList<BatterRecord>) request.getAttribute("batterrecord"); %>
<% ArrayList<PitcherRecord> spr = (ArrayList<PitcherRecord>) request.getAttribute("pitcherRecord"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/baseball/css/base.css" media="all">
<title>成績検索</title>
</head>
<body>

<header>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
</header>

<nav>
<jsp:include page="/WEB-INF/jsp/sideMenu.jsp" />
</nav>

<h2>野手成績検索結果</h2>
<table class="searchResult" border="1">
	<thead>
        <tr>
        	<th>名前</th>
        	<th>チーム</th>
			<th>年度</th>
            <th>打率</th>
            <th>試合</th>
            <th>打席</th>
            <th>打数</th>
            <th>安打</th>
            <th>本塁打</th>
            <th>打点</th>
            <th>三振</th>
            <th>四死球</th>
            <th>盗塁</th>
            <th>出塁率</th>
            <th>得点圏打率</th>
            <th>失策</th>
            <th>OPS</th>
        </tr>
    </thead>
    <tbody>
		<c:forEach items="${batterrecord}" var="sbr">
		   <tr>
		   		<td><c:out value="${sbr.name}" /></td>
		   		<td>
		       <c:choose>
					<c:when test="${sbr.teamId == 1}">読売ジャイアンツ</c:when>
					<c:when test="${sbr.teamId == 2}">阪神タイガース</c:when>
					<c:when test="${sbr.teamId == 3}">横浜DeNAベイスターズ</c:when>
					<c:when test="${sbr.teamId == 4}">中日ドラゴンズ</c:when>
					<c:when test="${sbr.teamId == 5}">広島東洋カープ</c:when>
					<c:when test="${sbr.teamId == 6}">東京ヤクルトスワローズ</c:when>
			   </c:choose>
			   </td>
		       <td><c:out value="${sbr.year}" /></td>
		       <td><c:out value="${sbr.avg}" /></td>
		       <td><c:out value="${sbr.g}" /></td>
		       <td><c:out value="${sbr.pa}" /></td>
		       <td><c:out value="${sbr.ab}" /></td>
		       <td><c:out value="${sbr.h}" /></td>
		       <td><c:out value="${sbr.hr}" /></td>
		       <td><c:out value="${sbr.rbi}" /></td>
		       <td><c:out value="${sbr.so}" /></td>
		       <td><c:out value="${sbr.fdb}" /></td>
		       <td><c:out value="${sbr.sb}" /></td>
		       <td><c:out value="${sbr.obp}" /></td>
		       <td><c:out value="${sbr.scpos}" /></td>
		       <td><c:out value="${sbr.e}" /></td>
		       <td><c:out value="${sbr.ops}" /></td>
		   </tr>
		</c:forEach>
	</tbody>
</table>

<h2>投手成績検索結果</h2>
<table class="searchResult" border="1">
	<thead>
        <tr>
        	<th>名前</th>
        	<th>チーム</th>
			<th>年度</th>
            <th>防御率</th>
            <th>登板</th>
            <th>先発</th>
            <th>完投</th>
            <th>投球回</th>
            <th>勝利</th>
            <th>敗戦</th>
            <th>ホールド</th>
            <th>HP</th>
            <th>セーブ</th>
            <th>勝率</th>
            <th>奪三振</th>
            <th>失点</th>
            <th>被打率</th>
            <th>WHIP</th>
        </tr>
    </thead>
    <tbody>
		<c:forEach items="${pitcherrecord}" var="spr">
		   <tr>
		   		<td><c:out value="${spr.name}" /></td>
		   		<td>
		       <c:choose>
					<c:when test="${spr.teamId == 1}">読売ジャイアンツ</c:when>
					<c:when test="${spr.teamId == 2}">阪神タイガース</c:when>
					<c:when test="${spr.teamId == 3}">横浜DeNAベイスターズ</c:when>
					<c:when test="${spr.teamId == 4}">中日ドラゴンズ</c:when>
					<c:when test="${spr.teamId == 5}">広島東洋カープ</c:when>
					<c:when test="${spr.teamId == 6}">東京ヤクルトスワローズ</c:when>
			   </c:choose>
			   </td>
		       <td><c:out value="${spr.year}" /></td>
		       <td><c:out value="${spr.era}" /></td>
		       <td><c:out value="${spr.o}" /></td>
		       <td><c:out value="${spr.sta}" /></td>
		       <td><c:out value="${spr.cg}" /></td>
		       <td><c:out value="${spr.ip}" /></td>
		       <td><c:out value="${spr.w}" /></td>
		       <td><c:out value="${spr.l}" /></td>
		       <td><c:out value="${spr.h}" /></td>
		       <td><c:out value="${spr.hp}" /></td>
		       <td><c:out value="${spr.sv}" /></td>
		       <td><c:out value="${spr.wpct}" /></td>
		       <td><c:out value="${spr.k}" /></td>
		       <td><c:out value="${spr.r}" /></td>
		       <td><c:out value="${spr.oba}" /></td>
		       <td><c:out value="${spr.whip}" /></td>
		   </tr>
		</c:forEach>
	</tbody>
</table>

<footer>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</footer>

</body>
</html>