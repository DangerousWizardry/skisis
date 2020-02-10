<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Skisis</title>
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="assets/style.css">
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="https://fonts.googleapis.com/css?family=Righteous|Raleway|Roboto+Condensed&display=swap" rel="stylesheet">
</head>
<body>
<nav><div class="logo"><img src="assets/ski.png">SKISIS</div><div><a href="#" class="navigation">Accueil</a></div><div><a href="#" class="navigation">CatÃ©gorie</a></div><div><a href="#" class="navigation">Promotions</a></div><div class="actions"><i class="fa fa-shopping-basket"></i> <i class="fa fa-user-circle"></i></div></nav>
<div class="intro">
	<video autoplay muted loop id="myVideo">
	  <source src="assets/main_video.mp4" type="video/mp4">
	</video>
	<div class="title"><h1>Bienvenue sur SKISIS<br><small>Votre Magasin de sports d'hiver</small></h1></div>
</div>
<div class="container">
	<div class="separator"><span>Nos produits<span></div>
	<div class="grid">
		<div class="categorie ski"><span>Ski</span></div>
		<div class="categorie snowboard"><span>Snowboard</span></div>
		<div class="categorie accessoires"><span>Accessoires</span></div>
		<div class="categorie child"><span>Enfant</span></div>
		<div class="categorie promo"><span>Promo</span></div>
	</div>
</div>
<footer>&copy; SKISIS Corporation - ClÃ©mence B, Lucas D, Victoria V</footer>
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