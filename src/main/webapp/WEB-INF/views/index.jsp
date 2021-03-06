<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Skisis</title>
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/style.css">
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="https://fonts.googleapis.com/css?family=Righteous|Raleway|Roboto+Condensed&display=swap" rel="stylesheet">
</head>
<body class="mainpage">
    <nav class="mainpage"><div class="logo"><img src="assets/ski.png">SKISIS</div><div><a href="${pageContext.request.contextPath}/app" class="navigation">Accueil</a></div><div><a href="${pageContext.request.contextPath}/app/categories" class="navigation">Catégorie</a></div><div><a href="#" class="navigation">Promotions</a></div><div class="actions"><a href="${pageContext.request.contextPath}/app/panier"><i class="fa fa-shopping-basket"></i></a> <a href="${pageContext.request.contextPath}/app/auth"><i class="fa fa-user-circle"></i></a></div></nav>
<div class="intro">
	<video autoplay muted loop id="myVideo">
	  <source src="assets/main_video.mp4" type="video/mp4">
	</video>
	<div class="title"><h1>Bienvenue sur SKISIS<br><small>Votre épicerie de sports d'hiver</small></h1></div>
</div>
<div class="container">
	<div class="separator"><span>Nos produits<span></div>
	<div class="grid">
		<c:forEach items="${categories}" var="item">
			<a href="${pageContext.request.contextPath}/app/categorieProduits?code=${item.getCode()}"><div class="categorie ${item.getLibelle()}"><span>${item.getLibelle()}</span></div></a>
		</c:forEach>
		<!--
		<div class="categorie snowboard"><span>Snowboard</span></div>
		<div class="categorie accessoires"><span>Accessoires</span></div>
		<div class="categorie child"><span>Enfant</span></div>
		<div class="categorie promo"><span>Promo</span></div>-->
	</div>
</div>
<footer>&copy; SKISIS Corporation - Clémence B, Lucas D, Victoria V</footer>
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  crossorigin="anonymous"></script>
  <script type="text/javascript">
  	$("video").height(($("body").width()/16)*9);
  	$("video").width($("body").width());
  	$(".intro").height(($("body").width()/16)*9 - 80);
  </script>
</body>
</html>