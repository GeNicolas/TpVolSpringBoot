<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reservation vol</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h1> Liste des vols </h1>
		<div>
		<a href="addVol" class="btn btn-link"> ajouter un vol</a>
		<table class="table">
			
			<tr>
				<th>id</th>
				<th>date de depart</th>
				<th>Aeroport de depart </th>
				<th>date d'arrivée</th>
				<th> Aeroport d'arrivée</th>
			
				<th>Compagnie Aerienne du Vol</th>
				<th>Escale possible </th>
				<th>Reservations </th>
				
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
							<form:options items="${repovol.findByIdWithReservation(v.id).get().getReservation()}" itemLabel="numero" itemValue="numero"/>
						</form:select>
						</td>
					
					<td><a class="btn btn-info" href="edit?id=${v.id}">modifier</a></td>
				<td><a class="btn btn-danger" href="delete?id=${v.id}">supprimer</a></td>
					</tr>
			</c:forEach>
			
			</table>
		
		</div>
	</div>
</body>
</html>