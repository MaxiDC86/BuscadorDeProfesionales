<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.*"%>
<%@ page import="net.guides.springboot2.crud.controller.*"%>
<%@ page import="net.guides.springboot2.crud.model.*"%>

<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Resultado de busqueda.</title>
<!-- Favicon -->
<link rel="icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/recursos/imgs/favicon.png">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/recursos/css/styles.css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- Google Ads  -->
<script async
	src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js?client=ca-pub-4530209817571456"
	crossorigin="anonymous"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">SALUD CERCA</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="http://salud-cerca.site">Home</a></li>
					<li><a href="/contactoformulario">Contacto</a></li>
					<li><a href="#">Nosotros</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="main-block">
		<h1>Resultado de busqueda.</h1>
		<h6>
			Has elegido buscar:
			<%
		out.print(Controlador.selectionShowArea + " , especialidad: " + Controlador.selectionShowType);
		%>
			<br> en la zona:
			<%
			out.print(Controlador.selectionShowZone);
			%>
			<br> y la localidad:
			<%
			out.print(Controlador.selectionShowCity);
			%>
		</h6>

		<div class="cards">
			<%
			for (Client emp : Controlador.selected) {
				out.println("<div class='card border-dark bg-info mb-3' style='max-width: 25rem;'>");
				out.println("<div class='card-header'>" + emp.getType() + "</div>");
				out.println("<div class='card-body'>");
				out.println("<h5 class='card-title'>" + emp.getFirstName() + " , " + emp.getLastName() + " </h5>");
				out.println("</div>");
				out.println("<div class='card-footer bg-transparent border-success'>" + "cel: " + emp.getTelephone()
				+ "<br>   email: " + emp.getEmailId() + "</div>");
				out.println("<p class='card-text'>" + emp.getAttention() + "</p>");
				out.println("<div class='card-footer bg-transparent border-success'>Footer</div>");
				out.println("<form action='details' method='post' id='client_id'>");
				out.println("<div><button id='id' value=" + emp.getId() + " type='submit'>Detalles</button></div>");
				out.println("</form></div>");
			}
			%>

		</div>
		<form:form action="details" modelAttribute="client_id">
			<form:select path="id">
				<option value="3">3</option>
				<option value="2">2</option>
				<option value="1">1</option>
			</form:select>
			<div>
				<button type="submit" value="Enviar">Daleeeee</button>
			</div>
		</form:form>

		<br> <br>
		<form method="get" action="/">
			<button type="submit">Volver a buscar</button>
		</form>

	</div>
	</script>
	<!-- JavaScript -->
	<script>
		function myFunction() {
			var x = document.getElementById("myTopnav");
			if (x.className === "topnav") {
				x.className += " responsive";
			} else {
				x.className = "topnav";
			}
		}
	</script>
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
<!-- Footer -->
<footer class="page-footer font-small mdb-color darken-3 pt-4">

	<!-- Copyright -->
	<div class="footer-copyright text-center py-3">
		© 2022 Copyright: <a href="http://www.mediascorreia.online/">
			www.mediascorreia.online</a>
	</div>
	<!-- Copyright -->

</footer>
</html>