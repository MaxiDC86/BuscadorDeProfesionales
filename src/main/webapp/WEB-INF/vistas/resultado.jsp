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
<title>Resultado de busqueda.</title>
<link rel="icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/recursos/imgs/favicon.png">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/recursos/css/styles.css">
</head>
<body>
	<div class="main-block">
		<h1>Resultado de busqueda.</h1>
		<h2>
			Has elegido buscar en zona:
			<%
		out.print(Controlador.selectionShowZone);
		%>
			y Has elegido la localiad:
			<%
		out.print(Controlador.selectionShowCity);
		%>
		</h2>
		<table style="width: 90%">
			<tr>
				<th>Apellido</th>
				<th>Nombre</th>
				<th>Email</th>
				<th>Telefono</th>
			</tr>
			<tr>
				<%
				for (Client emp : Controlador.selectedZoneAndCity) {
					out.println("<tr><td>" + emp.getLastName() + "</td><td>" + emp.getFirstName() + "</td><td>" + emp.getEmailId()
					+ "</td><td>" + emp.getTelephone() + "</td></tr>");
				}
				%>
			</tr>
		</table>
		<form method="get" action="/">
			<button type="submit">HOME</button>
		</form>

	</div>
	</script>
	<!-- JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>