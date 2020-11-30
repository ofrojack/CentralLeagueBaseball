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
<title>選手検索フォーム</title>
</head>
<body>

<header>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
</header>

<nav>
<jsp:include page="/WEB-INF/jsp/sideMenu.jsp" />
</nav>

<h2>選手検索</h2>
<table class="searchPlayertb" border="1">
	<form action="/baseball/SearchPlayerServlet" method="post">
		<thead>
			<tr>
				<th>名前</th>
				<th>チーム</th>
				<th>ポジション</th>
				<th>背番号</th>
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
					<select name="posiId">
						<option value="" selected></option>
						<option value="1">投手</option>
						<option value="2">捕手</option>
						<option value="3">内野手</option>
						<option value="4">外野手</option>
					</select>
				</td>
				<td><input type="text" name="num"></td>
			</tr>
			<tr>
				<th>なまえ</th>
				<th>身長</th>
				<th>体重</th>
<!-- 			<th>身長
				<select name="height">
					<option value="" selected></option>
					<option value="<= 170">170cm以下</option>
					<option value="171 and 180">171cm-180cm</option>
					<option value="181 and 190">181cm-190cm</option>
					<option value=">= 191">191cm以上</option>
				</select>
				</th>
				<th>体重
					<select name="weight">
						<option value="" selected></option>
						<option value="<= 70">70kg以下</option>
						<option value="71 and 80">71kg-80kg</option>
						<option value="81 and 90">81kg-90kg</option>
						<option value="91 and 100">91kg-100kg</option>
						<option value="101 and 110">101kg-110kg</option>
						<option value="111 and 120">111kg-120kg</option>
						<option value=">= 120">120kg以上</option>
					</select>
				</th>
-->
				<th>投/打</th>
			</tr>
			<tr>
				<td><input type="text" name="kana"></td>
				<td><input type="text" name="height"></td>
				<td><input type="text" name="weight"></td>
				<td>
					<select name="dexterity">
						<option value="" selected></option>
						<option value="右/右">右/右</option>
						<option value="右/左">右/左</option>
						<option value="左/右">左/右</option>
						<option value="左/左">左/左</option>
						<option value="右/両">右/両</option>
						<option value="左/両">左/両</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>血液型</th>
				<th>ドラフト年</th>
				<th>プロ通算年</th>
				<th>出身地</th>
			</tr>
			<tr>
				<td>
					<select name="blood">
						<option value="" selected></option>
						<option value="A">A</option>
						<option value="B">B</option>
						<option value="O">O</option>
						<option value="AB">AB</option>
						<option value="不明">不明</option>
					</select>
				</td>
				<td><input type="text" name="draft"></td>
				<td><input type="text" name="career"></td>
				<td>
					<select name="born">
						<option value="" selected></option>
						<option value="北海道">北海道</option>
						<option value="青森">青森県</option>
						<option value="岩手">岩手県</option>
						<option value="宮城">宮城県</option>
						<option value="秋田">秋田県</option>
						<option value="山形">山形県</option>
						<option value="福島">福島県</option>
						<option value="茨城">茨城県</option>
						<option value="栃木">栃木県</option>
						<option value="群馬">群馬県</option>
						<option value="埼玉">埼玉県</option>
						<option value="千葉">千葉県</option>
						<option value="東京">東京都</option>
						<option value="神奈川">神奈川県</option>
						<option value="新潟">新潟県</option>
						<option value="富山">富山県</option>
						<option value="石川">石川県</option>
						<option value="福井">福井県</option>
						<option value="山梨">山梨県</option>
						<option value="長野">長野県</option>
						<option value="岐阜">岐阜県</option>
						<option value="静岡">静岡県</option>
						<option value="愛知">愛知県</option>
						<option value="三重">三重県</option>
						<option value="滋賀">滋賀県</option>
						<option value="京都">京都府</option>
						<option value="大阪">大阪府</option>
						<option value="兵庫">兵庫県</option>
						<option value="奈良">奈良県</option>
						<option value="和歌山">和歌山県</option>
						<option value="鳥取">鳥取県</option>
						<option value="島根">島根県</option>
						<option value="岡山">岡山県</option>
						<option value="広島">広島県</option>
						<option value="山口">山口県</option>
						<option value="徳島">徳島県</option>
						<option value="香川">香川県</option>
						<option value="愛媛">愛媛県</option>
						<option value="高知">高知県</option>
						<option value="福岡">福岡県</option>
						<option value="佐賀">佐賀県</option>
						<option value="長崎">長崎県</option>
						<option value="熊本">熊本県</option>
						<option value="大分">大分県</option>
						<option value="宮崎">宮崎県</option>
						<option value="鹿児島">鹿児島県</option>
						<option value="沖縄">沖縄県</option>
						<option value="アメリカ">アメリカ</option>
						<option value="ドミニカ">ドミニカ共和国</option>
						<option value="キューバ">キューバ</option>
						<option value="台湾">台湾</option>
					</select>
				</td>
			</tr>
			<tr>
				<th colspan="2">生年月日</th>
				<td colspan="2"><input type="text" name="birth"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="reset" name="Submit2" value="リセット"></td>
				<td colspan="2"><input type="submit" value="検索"></td>
			</tr>
		</thead>
	</form>
</table>

<footer>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</footer>

</body>
</html>