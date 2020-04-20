<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Validation du panier</title>
	<link rel="stylesheet" type="text/css" href="../../assets/style.css">
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="https://fonts.googleapis.com/css?family=Righteous|Raleway|Roboto+Condensed&display=swap" rel="stylesheet">
    </head>
    <body class="validPanier">
        <%@include file="layout/nav.jsp" %>
        <div class="content validation">
            <h1>Informations</h1>
            <div>
				<form method="POST" action="" class="simple-form">
					<label>Nom du destinataire</label><input type="text" name="destinataire" value="${client.contact}">
					<label>Adresse de livraison</label><input type="text" name="adresse" value="${client.adresse}">
					<label>Code Postal</label><input type="text" name="codePostal" value="${client.codePostal}">
					<label>Ville</label><input type="text" name="ville" value="${client.ville}">
					<label>Région</label><input type="text" name="region" value="${client.region}">
					<label>Pays</label><input type="text" name="pays" value="${client.pays}">
					<input type="submit" name="valider" value="Valider la commande">
				</form>
			</div>
        </div>
    </body>
</html>
