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
<title>成績検索フォーム</title>
</head>
<body>

<header>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
</header>

<nav>
<jsp:include page="/WEB-INF/jsp/sideMenu.jsp" />
</nav>

<h2>野手成績検索</h2>
<table class="searchPlayertb" border="1">
	<form action="/baseball/SearchRecordServlet" method="post">
		<thead>
			<tr>
				<th>名前</th>
				<th>チーム</th>
				<th>年度</th>
				<th>打率</th>
			</tr>
			<tr>
				<td><input type="text" name="name"></td>
				<td>
					<select name="teamId">
						<option value="" selected></option>
						<option value="1">読売ジャイアンツ</option>
						<option value="2">阪神タイガース</option>
						<option value="3">横浜DeNAベイスターズ</option>
						<option value="4">中日ドラゴンズ</option>
						<option value="5">広島東洋カープ</option>
						<option value="6">東京ヤクルトスワローズ</option>
					</select>
				</td>
				<td>
					<select name="year">
						<option value="" selected></option>
						<option value="2020">2020年</option>
						<option value="2019">2019年</option>
					</select>
				</td>
				<td><input type="text" name="avg"></td>
			</tr>
			<tr>
				<th>試合</th>
				<th>打席</th>
				<th>打数</th>
				<th>安打</th>
			</tr>
			<tr>
				<td><input type="text" name="g"></td>
				<td><input type="text" name="pa"></td>
				<td><input type="text" name="ab"></td>
				<td><input type="text" name="h"></td>
			</tr>
			<tr>
				<th>本塁打</th>
				<th>打点</th>
				<th>三振</th>
				<th>四死球</th>
			</tr>
			<tr>
				<td><input type="text" name="hr"></td>
				<td><input type="text" name="rbi"></td>
				<td><input type="text" name="so"></td>
				<td><input type="text" name="fdb"></td>

			</tr>
			<tr>
				<th>盗塁</th>
				<th>出塁率</th>
				<th>得点圏打率</th>
				<th>失策</th>
			</tr>
			<tr>
				<td><input type="text" name="sb"></td>
				<td><input type="text" name="obp"></td>
				<td><input type="text" name="scpos"></td>
				<td><input type="text" name="e"></td>
			</tr>
			<tr>
				<th colspan="2">OPS</th>
				<td colspan="2"><input type="text" name="ops"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="reset" name="Submit2" value="リセット"></td>
				<td colspan="2"><input type="submit" value="検索"></td>
			</tr>
		</thead>
	</form>
</table>


<br>

<h2>投手成績検索</h2>
<table class="searchPlayertb" border="1">
	<form action="/baseball/SearchRecordServlet" method="post">
		<thead>
			<tr>
				<th>名前</th>
				<th>チーム</th>
				<th>年度</th>
				<th>防御率</th>
				<th>登板</th>
				<th>先発</th>
			</tr>
			<tr>
				<td><input type="text" name="namE"></td>
				<td>
					<select name="teamID">
						<option value="" selected></option>
						<option value="1">読売ジャイアンツ</option>
						<option value="2">阪神タイガース</option>
						<option value="3">横浜DeNAベイスターズ</option>
						<option value="4">中日ドラゴンズ</option>
						<option value="5">広島東洋カープ</option>
						<option value="6">東京ヤクルトスワローズ</option>
					</select>
				</td>
				<td>
					<select name="yeaR">
						<option value="" selected></option>
						<option value="2020">2020年</option>
						<option value="2019">2019年</option>
					</select>
				</td>
				<td><input type="text" name="erA"></td>
				<td><input type="text" name="O"></td>
				<td><input type="text" name="stA"></td>
			</tr>
			<tr>
				<th>完投</th>
				<th>投球回</th>
				<th>勝利</th>
				<th>敗戦</th>
				<th>ホールド</th>
				<th>HP</th>
			</tr>
			<tr>
				<td><input type="text" name="cG"></td>
				<td><input type="text" name="iP"></td>
				<td><input type="text" name="W"></td>
				<td><input type="text" name="L"></td>
				<td><input type="text" name="H"></td>
				<td><input type="text" name="hP"></td>
			</tr>
			<tr>
				<th>セーブ</th>
				<th>勝率</th>
				<th>奪三振</th>
				<th>失点</th>
				<th>被打率</th>
				<th>WHIP</th>
			</tr>
			<tr>
				<td><input type="text" name="sV"></td>
				<td><input type="text" name="wpcT"></td>
				<td><input type="text" name="K"></td>
				<td><input type="text" name="R"></td>
				<td><input type="text" name="obA"></td>
				<td><input type="text" name="whiP"></td>
			</tr>
			<tr>
				<td colspan="3"><input type="reset" name="Submit2" value="リセット"></td>
				<td colspan="3"><input type="submit" value="検索"></td>
			</tr>
		</thead>
	</form>
</table>

<footer>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</footer>

</body>
</html>