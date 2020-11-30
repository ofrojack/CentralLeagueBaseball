<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/baseball/css/base.css" media="all">

<title>マイメニュー画面</title>
</head>
<body>

<header>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
</header>

<nav>
<jsp:include page="/WEB-INF/jsp/sideMenu.jsp" />
</nav>

<h2>マイメニュー画面</h2>

<c:choose>
	<c:when test="${userId != null}">
<p>ようこそ<c:out value="${userId}" />さん</p>
	</c:when>
	<c:otherwise>
<p>ようこそゲストさん</p>
	</c:otherwise>
</c:choose>

<footer>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</footer>

</body>
</html>