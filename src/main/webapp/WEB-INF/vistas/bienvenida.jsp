<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Bienvenidos a busqueda de profesionales.</title>
<link rel="icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/recursos/imgs/foto.png">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/recursos/css/styles.css">
</head>
<body>

	<div class="main-block">
		<h1>Bienvenidos al buscador de profesionales.</h1>

		<form:form action="procesaBusqueda" modelAttribute="selection">
			<label id="icon" for="name"><i class="fas fa-envelope"></i></label>

			<form:input path="zone" />
			<br>
			<br>

	</div>
	<button type="submit" value="Enviar">Ingresar</button>
	</form:form>



	<form method="get" action="resultado">
		<button type="submit">Buscar</button>
	</form>
	</div>
</body>
</html>