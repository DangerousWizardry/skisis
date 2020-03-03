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
			<c:forEach var="produit" items="${panier.produitCollection}">
			<div class="productLine">
				<div>${produit.reference}</div>
				<div>${produit.nom}</div>
				<div><form><input type="hidden" name="produit" value="${produit.reference}"><label>Quantité </label><input type="number" class="number-input" value="1" name="quantite"><input type="submit" class="primary-button" value="Modifier la quantité"></form></div>
				<div><form><input type="hidden" name="produit_delete" value="${produit.reference}"><input type="submit" class="cancel-button" value="Supprimer du panier"></form></div>
			</div>
		</c:forEach>
		</div>
		<form><input type="hidden" name="valider" value="1"><input type="submit" class="primary-button" value="Valider le panier"></form>
	</div>
    </body>
</html>
