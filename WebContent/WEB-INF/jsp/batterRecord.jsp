<%@page import="java.util.ArrayList"%>
<%@page import= "model.BatterRecord" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% ArrayList<BatterRecord> br = (ArrayList<BatterRecord>) request.getAttribute("batterRecord"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/baseball/css/${teamId}.css" media="all">
<title>野手成績</title>
</head>
<body>

<header>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
</header>

<nav>
<jsp:include page="/WEB-INF/jsp/sideMenu.jsp" />
</nav>

<h2>野手成績</h2>
<table class="record" border="1">
	<thead>
        <tr>
        	<th>名前</th>
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
            <th>得点圏</th>
            <th>失策</th>
            <th>OPS</th>
        </tr>
    </thead>
    <tbody>
		<c:forEach items="${batterRecord}" var="br">
		   <tr>
			   <td><c:out value="${br.name}" /></td>
		       <td><c:out value="${br.avg}" /></td>
		       <td><c:out value="${br.g}" /></td>
		       <td><c:out value="${br.pa}" /></td>
		       <td><c:out value="${br.ab}" /></td>
		       <td><c:out value="${br.h}" /></td>
		       <td><c:out value="${br.hr}" /></td>
		       <td><c:out value="${br.rbi}" /></td>
		       <td><c:out value="${br.so}" /></td>
		       <td><c:out value="${br.fdb}" /></td>
		       <td><c:out value="${br.sb}" /></td>
		       <td><c:out value="${br.obp}" /></td>
		       <td><c:out value="${br.scpos}" /></td>
		       <td><c:out value="${br.e}" /></td>
		       <td><c:out value="${br.ops}" /></td>
		   </tr>
		</c:forEach>
	</tbody>
</table>

<footer>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</footer>

</body>
</html>