<%@page import="java.util.ArrayList"%>
<%@page import= "model.Player" %>
<%@page import= "model.FavoritePlayer" %>
<%@page import= "model.Account" %>
<%@page import= "model.BatterRecord" %>
<%@page import= "model.PitcherRecord" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/baseball/css/${teamId}.css" media="all">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<title>選手詳細</title>

    <script>

    $(function(){

   	<c:choose>
   		<c:when test="${result}">
    		$('#button2').hide();
            $('#button1').show();
   		</c:when>
   		<c:otherwise>
	    	$('#button1').hide();
	        $('#button2').show();
   		</c:otherwise>
   	</c:choose>

      // ボタン押下時の処理
      $('#favButtonInsert').on('click',function(){
        $.ajax({
          url: "AjxFavPlayerInsertServlet",
          type: "GET",
          data: {playerId : ${playerId}}
        }).done(function (result) {
          // 通信成功時のコールバック
          alert("お気に入りされました");
           $('#button2').hide();
           $('#button1').show();
        }).fail(function () {
          // 通信失敗時のコールバック
          alert("失敗");
        }).always(function (result) {
          // 常に実行する処理
        });
      });

      $('#favButtonDelete').on('click',function(){
          $.ajax({
            url: "AjxFavPlayerDeleteServlet",
            type: "GET",
            data: {playerId : ${playerId}}
          }).done(function (result) {
            // 通信成功時のコールバック
          	alert("お気に入りを解除しました");
          	$('#button1').hide();
            $('#button2').show();
          }).fail(function () {
            // 通信失敗時のコールバック
            alert("失敗");
          }).always(function (result) {
            // 常に実行する処理
          });
       });

 	  });
    </script>
</head>

<body>

<header>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
</header>

<nav>
<jsp:include page="/WEB-INF/jsp/sideMenu.jsp" />
</nav>

<h2>プロフィール</h2>
<img class="player" src="/baseball/img/player/${playerId}.jpg">

<p id="button1"><button id="favButtonDelete">★</button></p>
<p id="button2"><button id="favButtonInsert">☆</button></p>



<table class="searchResult" border="1">
	<thead>
        <tr>
        	<th>名前</th>
        	<th>チーム</th>
			<th>ポジション</th>
            <th>背番号</th>
            <th>生年月日</th>
            <th>身長</th>
            <th>体重</th>
            <th>血液型</th>
            <th>利き手</th>
            <th>ドラフト年</th>
            <th>プロ通算年</th>
            <th>出身地</th>
        </tr>
    </thead>
    <tbody>
		<c:forEach items="${player}" var="ps">
		   <tr>
		   		<td><c:out value="${ps.name}" /></td>
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
		       <td>
		       <c:choose>
					<c:when test="${ps.posiId == 1}">投手</c:when>
					<c:when test="${ps.posiId == 2}">捕手</c:when>
					<c:when test="${ps.posiId == 3}">内野手</c:when>
					<c:when test="${ps.posiId == 4}">外野手</c:when>
			   </c:choose>
			   </td>
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


<c:choose>
		<c:when test="${posiId == 1}">
			<h2>投手成績</h2>
		    <table class="record" border="1">
	    	    <thead>
	        	    <tr>
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
					<c:forEach items="${pitcherRecord}" var="pr2">
				    	<tr>
			 			    <td><c:out value="${pr2.era}" /></td>
			 			    <td><c:out value="${pr2.o}" /></td>
			 			    <td><c:out value="${pr2.sta}" /></td>
			 			    <td><c:out value="${pr2.cg}" /></td>
			 			    <td><c:out value="${pr2.ip}回" /></td>
			 			    <td><c:out value="${pr2.w}" /></td>
			 			    <td><c:out value="${pr2.l}" /></td>
			 			    <td><c:out value="${pr2.h}" /></td>
			 			    <td><c:out value="${pr2.hp}" /></td>
			 			    <td><c:out value="${pr2.sv}" /></td>
			 			    <td><c:out value="${pr2.wpct}" /></td>
			 			    <td><c:out value="${pr2.k}" /></td>
			 			    <td><c:out value="${pr2.r}" /></td>
			 			    <td><c:out value="${pr2.oba}" /></td>
			 			    <td><c:out value="${pr2.whip}" /></td>
					    </tr>
					</c:forEach>
	      	 	</tbody>
	    	</table>
		</c:when>
		<c:otherwise>
			<h2>野手成績</h2>
			<table class="record" border="1">
				<thead>
			        <tr>
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
					<c:forEach items="${batterRecord}" var="br2">
					   <tr>
					       <td><c:out value="${br2.avg}" /></td>
					       <td><c:out value="${br2.g}" /></td>
					       <td><c:out value="${br2.pa}" /></td>
					       <td><c:out value="${br2.ab}" /></td>
					       <td><c:out value="${br2.h}" /></td>
					       <td><c:out value="${br2.hr}" /></td>
					       <td><c:out value="${br2.rbi}" /></td>
					       <td><c:out value="${br2.so}" /></td>
					       <td><c:out value="${br2.fdb}" /></td>
					       <td><c:out value="${br2.sb}" /></td>
					       <td><c:out value="${br2.obp}" /></td>
					       <td><c:out value="${br2.scpos}" /></td>
					       <td><c:out value="${br2.e}" /></td>
					       <td><c:out value="${br2.ops}" /></td>
					   </tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
</c:choose>

<footer>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</footer>

</body>
</html>