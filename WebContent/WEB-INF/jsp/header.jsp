<%@page import="java.util.ArrayList"%>
<%@page import= "model.CentralTeam" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% ArrayList<CentralTeam> ct = (ArrayList<CentralTeam>) request.getAttribute("centralTeam"); %>
<!DOCTYPE html>
<head>
<link rel="stylesheet" href="/baseball/css/header.css" media="all">
<link href = "https://fonts.googleapis.com/css2？family = Pacifico＆ display = swap" rel = "stylesheet">
</head>

<main>
	<div class="header">

		<img class="centralLogo" src="/baseball/img/logo/centralLogo.png">

		<h1>Central League Baseball</h1>

		<div class="account">
			<c:choose>
				<c:when test="${userId != null}">
					<p>ようこそ<c:out value="${userId}" />さん</p>
				</c:when>
			<c:otherwise>
					<p>ようこそゲストさん</p>
			</c:otherwise>
			</c:choose>
		</div>

	</div>
</main>
