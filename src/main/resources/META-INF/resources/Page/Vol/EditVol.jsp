<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<head>
<meta charset="UTF-8">
<title>Ajouter un Vol</title>
</head>

<body class="container">
		<h1> edition des vols</h1>
		
		<form:form method="get" action="save" modelAttribute="vol">
		<form:hidden path="version" />
		<div class="form-group">
			<form:label path="id">Identifiant</form:label>
			<form:input path="id" cssClass="form-control" readonly="true" />
		</div>
		<div class="form-group">
			<form:label path="aeroportDepart.id" >Aeroport de départ</form:label>
				<form:select path="aeroportDepart.id">
					<form:options items="${aeroport}" itemLabel="nom"/>
				</form:select>
		</div>
		<div class="form-group">
			<form:label path="aeroportArrivee.id">Aeroport d'arrivée</form:label>
				<form:select path="aeroportArrivee.id">
					<form:options items="${aeroport}" itemLabel="nom"/>
				</form:select>
		</div>
		<div class="form-group">
			<form:label path="dateDepart">Date de départ</form:label>
			<form:input type="date" path="dateDepart" cssClass="form-control" />
			<form:errors path="dateDepart"></form:errors>
		</div>
		<div class="form-group">
			<form:label path="dateArrivee">Date d'arrivée</form:label>
			<form:input type="date" path="dateArrivee" cssClass="form-control" />
			<form:errors path="dateArrivee"></form:errors>
		</div>
		<div>
			<button class="btn btn-success" type="submit">Enregistrer vol</button>
			<a href="list" class="btn btn-warning">Annuler</a>
		</div>
		
		
	</form:form>
		
</body>
</html>