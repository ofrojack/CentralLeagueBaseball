<%@page import="java.util.ArrayList"%>
<%@page import= "model.PitcherRecord" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% ArrayList<PitcherRecord> pr = (ArrayList<PitcherRecord>) request.getAttribute("pitcherRecord"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/baseball/css/${teamId}.css" media="all">
<title>投手成績</title>
</head>
<body>

<header>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
</header>

<nav>
<jsp:include page="/WEB-INF/jsp/sideMenu.jsp" />
</nav>

<br>
<br>
<br>
<p>投手成績</p>
    <table class="record" border="1">
        <thead>
            <tr>
	            <th>名前</th>
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
			<c:forEach items="${pitcherRecord}" var="pr">
			    <tr>
	 			    <td><c:out value="${pr.name}" /></td>
	 			    <td><c:out value="${pr.era}" /></td>
	 			    <td><c:out value="${pr.o}" /></td>
	 			    <td><c:out value="${pr.sta}" /></td>
	 			    <td><c:out value="${pr.cg}" /></td>
	 			    <td><c:out value="${pr.ip}回" /></td>
	 			    <td><c:out value="${pr.w}" /></td>
	 			    <td><c:out value="${pr.l}" /></td>
	 			    <td><c:out value="${pr.h}" /></td>
	 			    <td><c:out value="${pr.hp}" /></td>
	 			    <td><c:out value="${pr.sv}" /></td>
	 			    <td><c:out value="${pr.wpct}" /></td>
	 			    <td><c:out value="${pr.k}" /></td>
	 			    <td><c:out value="${pr.r}" /></td>
	 			    <td><c:out value="${pr.oba}" /></td>
	 			    <td><c:out value="${pr.whip}" /></td>
			    </tr>
			</c:forEach>
        </tbody>
    </table>

<footer>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</footer>

</body>
</html>