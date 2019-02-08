<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des vols</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h1> Liste des vols </h1>
		<div>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<a href="addVol" class="btn btn-link"> Ajouter un vol</a>
			</sec:authorize>
		
		<table class="table">
			
			<tr>
				<th>Id</th>
				<th>Date de depart</th>
				<th>Aeroport de depart </th>
				<th>Date d'arrivée</th>
				<th> Aeroport d'arrivée</th>
				<th>Reservations </th>
				<th></th>
				<th></th>
			
				
			</tr>
			<c:forEach var="v" items="${vol}">
				<tr>
					<td> ${v.id}</td>
					<td> ${v.dateDepart}</td>	
					<td> ${v.aeroportDepart.nom}</td>
					<td> ${v.dateArrivee}</td>
					<td> ${v.aeroportArrivee.nom}</td>
					<td> 
						<form:select path="vol">
							<form:options items="${repovol.findByIdWithReservation(v.id).get().getReservation()}" itemLabel="reservation.id" itemValue="reservation.nom"/>
						</form:select>
					</td>
					<td></td>
					<td></td>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<td><a class="btn btn-info" href="edit?id=${v.id}">Modifier</a></td>
						<td><a class="btn btn-danger" href="delete?id=${v.id}">Supprimer</a></td>
					</sec:authorize>
					</tr>
			</c:forEach>
			
			</table>
		
		</div>
	</div>
</body>
</html>