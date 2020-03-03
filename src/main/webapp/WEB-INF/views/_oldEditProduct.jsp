<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Edition des produits</title>
	</head>

	<body>
		<h1>Edition des produits</h1>
		
		<form method="POST" id="form1"> <%-- L'action par défaut est de revenir à l'URL du contrôleur --%>
			<input name="nom" placeholder="Nom du produit"><br>		
			<input name="prixUnitaire" type="number" placeholder="Prix unitaire du produit"><br>
			<select name="code" form="form1">
				<c:forEach var="cat" items="${categories}"><option value="${cat.code}">${cat.libelle}</option>></c:forEach>
			</select>
			<input type="submit" value="ajouter un nouveau produit">
		</form>
		<%-- Est-ce qu'on a un message d'erreur à afficher ? --%>
		<c:if test="${not empty databaseErrorMessage}">
			<h2>Erreur !</h2>
			<span style="color: red;">${databaseErrorMessage}</span>
		</c:if>
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