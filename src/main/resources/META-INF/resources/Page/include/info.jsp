<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenue</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body class="container">
	
	<div>
		<c:if test="${pageContext.request.userPrincipal != null}">
			Bonjour&nbsp;${pageContext.request.userPrincipal.name}&nbsp;
			<br/>
			<a href="/demo/logout" class="btn btn-link">Déconnexion</a>
		</c:if>
	</div>
	<hr>
		<h3>Vos infos personnels</h3>
		<hr>
		
		<table class="table">
	<tr>
			<th>Type</th>
			<th>Client id</th>
			<th>Civilite</th>
			<th>Prenom/Siret</th>
			<th>Nom</th>
			<th>Adresse</th>
			<th>Code Postal</th>
			<th>Ville</th>
			<th>Numero de téléphone</th>
			<th>Numero de fax</th>
			<th>E-mail</th>
			<th>Réservations</th>
			<th></th>
		</tr>
		<c:forEach var="c" items="${client}">
			<tr>
				<td>
					<c:choose>
						<c:when test="${c.getClass().simpleName=='ClientMoral'}">CM</c:when>
						<c:when test="${c.getClass().simpleName=='ClientEI'}">EI</c:when>
						<c:otherwise>CP</c:otherwise>
					</c:choose>
				</td>
				<td>${c.id}</td>
				<c:choose>
					<c:when test="${c.getClass().simpleName=='ClientMoral'}">
						<td>${c.titre.getTitre_moral()}</td>
					</c:when>
					<c:otherwise>
						<td>${c.titre}</td>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${c.getClass().simpleName=='ClientMoral'}">
						<td>${c.getSiret()}</td>
					</c:when>
					<c:otherwise>
						<td>${c.prenom}</td>
					</c:otherwise>
				</c:choose>
				<td>${c.nom}</td>
				<td>${c.adresse.adresse}&nbsp;${c.adresse.pays}</td>
				<td>${c.adresse.codePostal}</td>
				<td>${c.adresse.ville}</td>
				<td>${c.numerotel}</td>
				<td>${c.numerofax}</td>
				<td>${c.email}</td>
				<td>
					<form:select path="client">
						<form:options items="${clientRepo.findByIdWithReservation(c.id).get().getReservation()}" itemLabel="numero" itemValue="numero"/>
					</form:select>
				</td>
				<td><a class="btn btn-info" href="edit?id=${c.id}">Modifier</a></td>
		</c:forEach>
	</table>
	
	<td><a class="btn btn-danger btn-block" href="../reservation">Ajouter une réservation</a></td>
	
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<h3>Votre tableau de bord</h3>
		<hr>
			<a href="/Passager/listPassager" class="btn btn-info">Liste des clients</a>
			<a href="/Vol/listVols" class="btn btn-danger">Liste des vols</a>
	</sec:authorize>
	
</body>
</html>