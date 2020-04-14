<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
     <h1>Mon profil</h1>
	 <h2>Mes informations</h2>
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
		<h2>Mes commandes</h2>
		<div class="orders">
			<c:forEach var="commande" items="${user.commandeCollection}">
				<div class="order-container">
				<div class="order"><b>N°${commande.numero}</b><b>Le <fmt:formatDate value="${commande.saisieLe}" pattern="dd/MM/yyyy à HH:mm:ss" /></b><b>Nombre de référence : ${commande.ligneCollection.size()}</b><i id="${commande.numero}" class="fa fa-2x fa-plus-circle"></i></div>
				<div class="product header order-${commande.numero}"><b>Référence</b><b>Nom du produit</b><b>Prix Unitaire</b><b>Quantité</b><b>Total</b></div>
				<c:forEach var="ligne" items="${commande.ligneCollection}">
					<div class="product order-${commande.numero}" ><span>${ligne.produit1.reference}</span><span>${ligne.produit1.nom}</span><span>${ligne.produit1.prixUnitaire}</span><span>${ligne.quantite}</span><span>${ligne.produit1.prixUnitaire*ligne.quantite}</span></div>
				</c:forEach>
				</div>
			</c:forEach>
			
		</div>
		<script>
			let plusList = document.getElementsByClassName('fa-plus-circle');
			for(order of plusList){
				console.log(order);
				order.addEventListener('click',function(e){toggleOrderDisplay(e.target.id)});
			}
			function toggleOrderDisplay(orderNumber){
				let rowList = document.getElementsByClassName('order-'+orderNumber);
				for(row of rowList){
					row.style.display = (row.style.display=='grid'?'none':'grid');
				}
			}
		</script>
    </body>
</html>
