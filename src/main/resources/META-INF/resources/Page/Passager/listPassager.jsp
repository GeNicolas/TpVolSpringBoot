<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Information Client</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">


</head>
<body>

<div class="container">
<h1>liste des passagers</h1>
	<div>
		<a href="addClientEI" class="btn btn-link">Ajouter un clientEI</a>
		<a href="addClientMoral" class="btn btn-link">Ajouter un clientMoral</a>
		<a href="addClientPhysique" class="btn btn-link">Ajouter un clientPhysique</a>
			
	</div>
	<table class="table">
	
	<tr>
			<th>Type</th>
			<th>client id</th>
			<th>civilite</th>
			<th>prenom/siret</th>
			<th>nom</th>
			<th>adresse</th>
			<th>codePostal</th>
			<th>ville</th>
			<th>numeroTel</th>
			<th>numeroFax</th>
			<th>email</th>
			<th>reservation</th>
			<th></th>
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
				<td><a class="btn btn-info" href="edit?id=${c.id}">modifier</a></td>
				<td><a class="btn btn-danger" href="delete?id=${c.id}">supprimer</a></td>
	</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>