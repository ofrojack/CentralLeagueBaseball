<%@page import="java.util.ArrayList"%>
<%@page import= "model.CentralTeam" %>
<%@page import= "model.Account" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<link rel="stylesheet" href="/baseball/css/sideMenu.css" media="all">
<link href = "https://fonts.googleapis.com/css2？family = Pacifico＆ display = swap" rel = "stylesheet">
</head>

<div class="leftmenu">
	<div class="subinfo">メニュー</div>
<!-- サイドメニュー -->
	<div class="subinfo">
		<ul>
			<c:choose>
				<c:when test="${userId != null}">
					<li><a href="/baseball/LogoutServlet">ログアウト</a></li>
					<li><a href="/baseball/UserProfileServlet?userId=${userId}">会員情報の表示・変更</a></li>
					<li><a href="/baseball/SearchPlayerServlet?userId=${userId}">選手検索</a></li>
					<li><a href="/baseball/SearchRecordServlet">成績検索</a></li>
					<!-- <li><a href="/baseball/CreateMyAllSterTeamServlet">マイオールスターチーム</a></li> -->
					<li><a href="/baseball/TeamDataServlet">チーム情報</a></li>
					<li><a href="/baseball/FavoriteTeamOrPlayerServlet">お気に入り</a></li>
					<li><a href="/baseball/WelcomeServlet">トップへ</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/baseball/LoginServlet">ログイン</a></li>
					<li><a href="/baseball/CreateAccountServlet">アカウント登録</a></li>
					<li><a href="/baseball/WelcomeServlet">トップへ</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
	<br clear=left>
	<div class="central2"><img src="/baseball/img/central/2.jpg" width="210" height="136"></div>
	<br clear=left>
</div>