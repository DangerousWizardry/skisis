<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Produits dans la catégorie '${selected.libelle}'</title>
	<link rel="stylesheet" type="text/css" href="../assets/style.css">
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="https://fonts.googleapis.com/css?family=Righteous|Raleway|Roboto+Condensed&display=swap" rel="stylesheet">
</head>
<body class="panier">
<%@include file="layout/nav.jsp" %>
	<div class="content">
		<h1>Votre panier</h1>
		<div class="productList">
			<c:forEach var="ligne" items="${panier.lignesPanier}">
			<div class="productLine">
				<div>${ligne.produit.reference}</div>
				<div>${ligne.produit.nom}</div>
				<div><form method="POST" action=""><input type="hidden" name="action" value="${ligne.produit.reference}"><input type="hidden" name="produit" value="${ligne.produit.reference}"><input type="hidden" name="produit" value="${ligne.produit.reference}"><label>Quantité </label><input type="number" class="number-input" value="${ligne.quantite}" name="quantite"><input type="submit" class="primary-button" name="choix" value="Modifier la quantité"></form></div>
				<div><form method="POST" action=""><input type="hidden" name="produit_delete" value="${ligne.produit.reference}"><input type="submit" class="cancel-button" name="choix" value="Supprimer du panier"></form></div>
			</div>
		</c:forEach>
		</div>
		<form method="POST" action=""><input type="hidden" name="valider" value="1"><input type="submit" class="primary-button" name="choix" value="Valider le panier"></form>
	</div>
    </body>
</html>
