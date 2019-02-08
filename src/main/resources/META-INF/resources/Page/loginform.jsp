<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Authentification</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body class="container">
	
		<div style="align-content:center;">
			<h1> Connexion</h1>
			
			<form action="" method="post">
			<c:if test="${param.error}">
				<div class="alert alert-danger">Erreur d'authentification</div>
			</c:if>
				<div class="form-group">
					<label for="login">Login</label>
					<input id="login" name="login" class="form-control">
				</div>
				<div class="form-group">
					<label for="motDePasse">Mot de passe</label>
					<input id="motDePasse" name="motDePasse" type="password" class="form-control">
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-info">Se connecter</button>
				</div>
			</form>
		</div>
</body>
</html>