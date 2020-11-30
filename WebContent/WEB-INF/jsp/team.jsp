<%@page import="java.util.ArrayList"%>
<%@page import= "model.CentralTeam" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% ArrayList<CentralTeam> ct = (ArrayList<CentralTeam>) request.getAttribute("centralTeam"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/baseball/css/${teamId}.css" media="all">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<title>${name}</title>
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
      $('#favTeamButtonInsert').on('click',function(){
        $.ajax({
          url: "AjxFavTeamInsertServlet",
          type: "GET",
          data: {teamId : ${teamId}}
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

      $('#favTeamButtonDelete').on('click',function(){
          $.ajax({
            url: "AjxFavTeamDeleteServlet",
            type: "GET",
            data: {teamId : ${teamId}}
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

<img class="logo" src="/baseball/img/logo/logo${teamId}.jpg">
<h2>${name}</h2>


<p id="button1"><button id="favTeamButtonDelete">★</button></p>
<p id="button2"><button id="favTeamButtonInsert">☆</button></p>


<main>
<!-- スライドショー第一弾 -->
<!-- <div class="photo"> -->
	<img class="photo" src="/baseball/img/team/${teamId}/1.jpg">
<!-- </div> -->
	<h3>メニュー</h3>
	<ul class="menu">
		<li><a href="PlayerListServlet?teamId=${teamId}">選手一覧</a></li>
		<li><a href="/baseball/BatterRecordServlet?teamId=${teamId}">野手成績</a></li>
		<li><a href="/baseball/PitcherRecordServlet?teamId=${teamId}">投手成績</a></li>
		<li><a href="/baseball/OnlineStoreServlet?teamId=${teamId}">オンラインストア</a></li>
	</ul>

	<h3>本拠地：${homeStadium}</h3>
<!--<p>本拠地：${homeStadium}<br></p> -->
	<!-- 〒112-0004 東京都文京区後楽1丁目3-61
	<c:out value="${homeAddress}" /> -->
	<!-- 本拠地のMap表示 -->
	<div class="map">
		<iframe src="${mapUrl}"
		width="400" height="300" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
	</div>

	<h3>オンラインストア</h3>
	<div class="goods">
			<img src="/baseball/img/goods/${teamId}/1.jpg">
			<img src="/baseball/img/goods/${teamId}/2.jpg">
			<img src="/baseball/img/goods/${teamId}/3.jpg">
			<img src="/baseball/img/goods/${teamId}/4.jpg">
			<img src="/baseball/img/goods/${teamId}/5.jpg">
	</div>

</main>
<footer>
	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</footer>

</body>
</html>