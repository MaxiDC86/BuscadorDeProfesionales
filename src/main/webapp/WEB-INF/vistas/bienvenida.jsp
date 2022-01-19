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
			<br>Elija Zona:<form:select path="zone">
				<form:option value="norte" label="NORTE" />
				<form:option value="sur" label="SUR" />
				<form:option value="oeste" label="OESTE" />
				<form:option value="caba" label="CABA" />
			</form:select>
			<br>Elija Localidad o Barrio:<form:select path="city">
				<form:option value="Villa Adelina" label="Villa Adelina" />
				<form:option value="Boulogne" label="Boulogne" />
				<form:option value="Carapachay" label="Carapachay" />
				<form:option value="Munro" label="Munro" />
			</form:select>
			<br>
			<br>
			<br>

			<button type="submit" value="Enviar">Buscar</button>
		</form:form>

	</div>
</body>
</html>