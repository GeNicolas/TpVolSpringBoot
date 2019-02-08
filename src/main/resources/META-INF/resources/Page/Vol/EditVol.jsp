<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="java.util.List"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<head>
<meta charset="ISO-8859-1">
<title>Ajouter un Vol</title>
</head>
<body class="container">
		<h1> edition des vols</h1>
		
		<form:form method="get" action="save" modelAttribute="vol">
		<form:hidden path="version" />
		<div class="form-group">
			<form:label path="id">identifiant</form:label>
			<form:input path="id" cssClass="form-control" readonly="true" />
		</div>
		<div class="form-group">
			<form:label path="aeroportDepart.id" >Aeroport Depart</form:label>
				<form:select path="aeroportDepart.id">
					<form:options items="${aeroport}" itemLabel="nom" itemValue="nom"/>
				</form:select>
		</div>
		<div class="form-group">
			<form:label path="aeroportArrivee.id">Aeroport Arrivee</form:label>
				<form:select path="aeroportDepart.id">
					<form:options items="${aeroport}" itemLabel="nom" itemValue="nom"/>
				</form:select>
		</div>
		<div class="form-group">
			<form:label path="dateDepart">date de départ</form:label>
			<form:input type="date" path="dateDepart" cssClass="form-control" />
			<form:errors path="dateDepart"></form:errors>
		</div>
		<div class="form-group">
			<form:label path="dateArrivee">date d'arrivee</form:label>
			<form:input type="date" path="dateArrivee" cssClass="form-control" />
			<form:errors path="dateArrivee"></form:errors>
		</div>
		<div>
			<button class="btn btn-success" type="submit">enregistrer vol</button>
			<a href="list" class="btn btn-warning">annuler</a>
		</div>
		
		
		</form:form>
		<%-- 
		<div id="booking" class="section">
		<div class="section-center">
			<div class="container">
				<div class="row">
					<div class="booking-form">
						<form>
							<div class="form-group">
							
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<span class="form-label">Départ de</span>
										<input class="form-control" type="text" placeholder="City or airport">
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<span class="form-label">Arrivée à</span>
										<input class="form-control" type="text" placeholder="City or airport">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-3">
									<div class="form-group">
										<span class="form-label">Date aller</span>
										<input class="form-control" type="date" required>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<span class="form-label">Date retour</span>
										<input class="form-control" type="date" required>
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<span class="form-label">Adulte(18+)</span>
										<select class="form-control">
											<option>1</option>
											<option>2</option>
											<option>3</option>
											<option>4</option>
											<option>5</option>
											<option>6</option>
											<option>7</option>
											<option>8</option>
											<option>9</option>
											<option>10</option>
										</select>
										<span class="select-arrow"></span>
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<span class="form-label">Enfants (0-17)</span>
										<select class="form-control">
											<option>1</option>
											<option>2</option>
											<option>3</option>
											<option>4</option>
											<option>5</option>
											<option>6</option>
											<option>7</option>
											<option>8</option>
											<option>9</option>
											<option>10</option>
										</select>
										<span class="select-arrow"></span>
									</div>
								</div>
							</div>
							<div class="row">
								
								<div class="col-md-3">
									<div class="form-btn">
										<button class="submit-btn">Editer vol</button>
									</div>
								</div>
							</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div> --%>
</body>
</html>