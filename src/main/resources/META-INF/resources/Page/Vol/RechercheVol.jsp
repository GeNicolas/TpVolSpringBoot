<%@ page language="java" contentType="text/html; charset=ISO-UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<head>
<meta charset="UTF-8">
<title>Recherche vols</title>
</head>
<body>
	<form:form method="get" action="afficherRechercheVol" modelAttribute="vol">
		<div class="form-group">
			<form:label path="aeroportDepart.id" >Aeroport Depart</form:label>
				<form:select path="aeroportDepart.id">
					<form:options items="${aeroport}" itemLabel="nom"/>
				</form:select>
		</div>
		<div class="form-group">
			<form:label path="dateDepart">date de départ</form:label>
			<form:input type="date" path="dateDepart" cssClass="form-control" />
			<form:errors path="dateDepart"></form:errors>
		</div>
		<div class="form-group">
			<form:label path="aeroportArrivee.id">Aeroport Arrivee</form:label>
				<form:select path="aeroportArrivee.id">
					<form:options items="${aeroport}" itemLabel="nom"/>
				</form:select>
		</div>
		<div class="form-group">
			<form:label path="dateArrivee">date d'arrivee</form:label>
			<form:input type="date" path="dateArrivee" cssClass="form-control" />
			<form:errors path="dateArrivee"></form:errors>
		</div>
		
		<div>
			<button class="btn btn-success" type="submit">Rechercher</button>
			<a href="list" class="btn btn-warning">annuler</a>
		</div>
	</form:form>

</body>
</html>