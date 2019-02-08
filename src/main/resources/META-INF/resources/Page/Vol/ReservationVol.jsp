<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<head>
<meta charset="UTF-8">
<title>Reserver un vol</title>
</head>
<body>
	<form:form method="get" action="saveReservation?idVol=${idVol}" modelAttribute="reservation">
		<div class="form-group">
			<form:hidden path="version"/>
			<form:label path="date">Date reservation</form:label>
			<form:input type="date" path="date" cssClass="form-control" />
			<form:errors path="date"></form:errors>
		</div>
		
		<div class="form-group">
			<form:label path="numero">Numero reservation</form:label>
			<form:input path="numero" cssClass="form-control" />
			<form:errors path="numero"></form:errors>
		</div>
		<div class="form-group">
			<form:label path="passager.nom">Nom</form:label>
			<form:input path="passager.nom" cssClass="form-control" />
			<form:errors path="passager.nom"></form:errors>
		</div>
		<div class="form-group">
			<form:label path="passager.prenom">Prenom</form:label>
			<form:input path="passager.prenom" cssClass="form-control"/>
			<form:errors path="passager.prenom"></form:errors>
		</div>
		<div>
			<form:hidden path="vol.id" value="${idVol}"/>
		</div>
		<div>
			<button class="btn btn-success" type="submit">Valider</button>
		</div>
	</form:form>
</body>
</html>