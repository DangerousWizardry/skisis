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
 <body>
     <%@include file="layout/nav.jsp" %>
     <h1>Profil client</h1>
        <form method="POST">
		Login<input name="login" value=${user.contact}><br>
                Mot de passe<input name="mdp" type="password" value=${user.code}><br>
                Société<input name="societe" value=${user.societe}><br>
		Fonction<input name="fonction" value=${user.fonction}><br>
                Adresse<input name="adresse" value=${user.adresse}><br>
                Ville<input name="ville" value=${user.ville}><br>
                Région<input name="region" value=${user.region}><br>
                Code Postal<input name="region" value=${user.codePostal}><br>
                Pays<input name="pays" value=${user.pays}><br>
                Téléphone<input name="telehpone" value=${user.telephone}><br>
                Fax<input name="fax" value=${user.fax}><br>
		<input type="submit" value="Modifier mes données">
	</form>
    </body>
</html>
