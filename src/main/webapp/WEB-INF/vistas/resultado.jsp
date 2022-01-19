<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.*"%>
<%@ page import="net.guides.springboot2.crud.controller.*"%>
<%@ page import="net.guides.springboot2.crud.model.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu principal Pacientes.</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/recursos/css/styles.css">
</head>
<body>
	<div class="main-block">
		<h1>Resultado de busqueda.</h1>


		<br>
		<ul>
			<%
			for (Employee emp : Controlador.empleados) {
				out.println(emp.getLastName() + ", " + emp.getFirstName() + " " + emp.getEmailId() + "<br>");
			}
			%>
		</ul>

		<form method="get" action="/">
			<button type="submit">HOME</button>
		</form>

	</div>
</body>
</html>