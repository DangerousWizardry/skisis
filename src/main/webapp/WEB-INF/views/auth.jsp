<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login</title>
	<link rel="stylesheet" type="text/css" href="../assets/style.css">
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="https://fonts.googleapis.com/css?family=Righteous|Raleway|Roboto+Condensed&display=swap" rel="stylesheet">
</head>
<body id="loginPage">
	<div class="logo centered"><img src="../assets/ski.png">SKISIS</div>
	<h1>Authentification</h1>
	<div class="loginContainer">
		<form method="POST" action="" id="login">
			User<br><br>
			<input class="text-input" type="text" name="user"><br><br><br>
			Password<br><br>
			<input class="text-input" type="password" name="pass"><br><br><br>
			<input class="primary-button" type="submit" name="sub" value="Se connecter">
		</form>
	</div>
	<a href="${pageContext.request.contextPath}/app"><div class="backToHome"><i class="fa fa-chevron-circle-left"></i> Retour à l'accueil</div></a>
</body>
</html>