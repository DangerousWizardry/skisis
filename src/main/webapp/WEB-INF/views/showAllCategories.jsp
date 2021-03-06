<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Toutes les catégories</title>
	<link rel="stylesheet" type="text/css" href="../assets/style.css">
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="https://fonts.googleapis.com/css?family=Righteous|Raleway|Roboto+Condensed&display=swap" rel="stylesheet">
</head>
<body>
<%@include file="layout/nav.jsp" %>
	<h2>Nos catégories de produit</h2>
	<div class="content">
		<div class="productList">
		<c:forEach var="categorie" items="${categories}">
		<a href="${pageContext.request.contextPath}/app/categorieProduits?code=${categorie.getCode()}"><div class="categorieLine">
				<div>${categorie.code}</div>
				<div>${mvc.encoders.html(categorie.libelle)}</div>
				<div>${mvc.encoders.html(categorie.description)}</div>
			</div></a>
		</c:forEach>
	</div>
</div>
</body>
</html>