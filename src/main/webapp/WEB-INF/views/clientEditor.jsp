<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Profil</title>
        <link rel="stylesheet" type="text/css" href="../assets/style.css">
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="https://fonts.googleapis.com/css?family=Righteous|Raleway|Roboto+Condensed&display=swap" rel="stylesheet">
</head>
 <body class="profile">
     <%@include file="layout/nav.jsp" %>
     <h1>Profil client</h1>
        <form method="POST">
			<div>Login<input name="contact" value="${user.contact}"></div>
            <div>Société<input name="societe" value="${user.societe}"></div>
			<div>Fonction<input name="fonction" value="${user.fonction}"></div>
            <div>Adresse<input name="adresse" value="${user.adresse}"></div>
			<div>Ville<input name="ville" value="${user.ville}"></div>
			<div>Région<input name="region" value="${user.region}"></div>
			<div>Code Postal<input name="region" value="${user.codePostal}"></div>
			<div>Pays<input name="pays" value="${user.pays}"></div>
			<div>Téléphone<input name="telephone" value="${user.telephone}"></div>
			<div>Fax<input name="fax" value="${user.fax}"></div>
		<input type="submit" value="Modifier mes données">
	</form>
    </body>
</html>
