<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav>
	<div class="logo"><img src="../assets/ski.png">SKISIS</div>
	<div>
		<a href="${pageContext.request.contextPath}/app" class="navigation">Accueil</a>
	</div>
	<div>
		<a href="${pageContext.request.contextPath}/app/categories" class="navigation">Catégorie</a>
	</div>
	<div>
		<a href="#" class="navigation">Promotions</a>
	</div>
	<div class="actions">
            <a href="${pageContext.request.contextPath}/app/panier"><i class="fa fa-shopping-basket"></i></a> <a href="${pageContext.request.contextPath}/app/auth"><i class="fa fa-user-circle"></i></a>
	</div>
</nav>