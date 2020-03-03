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
<body>
<%@include file="layout/nav.jsp" %>
	<h2>Nos produits ${selected.libelle}</h2>
	<div class="content">
		<div class="productList">
			<c:forEach var="produit" items="${selected.produitCollection}">
			<div class="productLine">
				<div>${produit.reference}</div>
				<div>${produit.nom}</div>
				<div><c:choose><c:when test="${produit.indisponible eq 1}"><span class="error">Produit Indisponible</span></c:when><c:otherwise><input type="hidden" name="produit" value="${produit.reference}"><label>Quantité </label><input type="number" class="number-input" value="1" name="quantite"><input type="submit" class="primary-button" value="Ajouter au panier"></form></c:otherwise></c:choose></div>
				<div><div class="light <c:if test="${produit.indisponible eq 1}">red</c:if>"></div></div>
			</div>
		</c:forEach>
	</div>
</div>
</body>
</html>