<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
	<title>Affiche toutes les produits</title>
</head>

<body>
	<h1>Liste des produits</h1>
	<table border='1'>
		<tr><th>Code</th><th>Libellé</th><th>Prix Unitaire</th><th>Catégorie</th></tr>
		<%-- Pour chaque catégorie, une ligne dans la table HTML --%>
		<c:forEach var="produit" items="${produits}">
			<tr>
				<td>${produit.reference}</td>
				<%-- Le libellé ou la description peuvent contenir des caractères spéciaux HTML ! --%>
				<td>${mvc.encoders.html(produit.nom)}</td>
				<td>${mvc.encoders.html(produit.prixUnitaire)}</td>
				<td>${mvc.encoders.html(produit.categorie.libelle)}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}">Retour au menu</a>
</body>

</html>