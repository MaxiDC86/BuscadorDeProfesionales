<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="net.guides.springboot2.crud.controller.*"%>
<%@ page import="net.guides.springboot2.crud.model.*"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Bienvenidos a busqueda de profesionales.</title>
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
					<li class="active"><a href="#">Home</a></li>
					<li><a href="/contactoformulario">Contacto</a></li>
					<li><a href="/nosotros">Nosotros</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="main-block">
		<h1>Bienvenidos al buscador de profesionales.</h1>
		<form:form action="procesaBusqueda" modelAttribute="selection">
			<div class="form-group">
				<!--AREA------------------------------------------------------------------>
				<label class="control-label">Profesional </label>
				<form:select class="form-select form-select-lg mb-3" path="area">
					<option disabled selected value>-- selecionar --</option>
					<option value="Kinesiologia">Kinesiología</option>
					<option value="Odontologia">Odontología</option>
				</form:select>
				<!--Especialidad------------------------------------------------------------------>
				<div id="specialMenu1" style="display: none;">
					<div class="form-group">
						<label>Especialidad</label>
						<form:select class="form-select form-select-lg mb-3"
							path="special1">
							<option disabled selected value>--TODOS--</option>
							<option value="Estimulacion temprana">Estimulacion
								Temprana</option>
							<option value="Psicomotricidad">Psicomotricidad</option>
							<option value="Neurodesarrollo">Neurodesarrollo</option>
						</form:select>
					</div>
				</div>
				<div id="specialMenu2" style="display: none;">
					<div class="form-group">
						<label>Especialidad</label>
						<form:select class="form-select form-select-lg mb-3"
							path="special2">
							<option disabled selected value>--TODOS--</option>
							<option value="General">General</option>
							<option value="Ortodoncista">Ortodoncista</option>
							<option value="Odontopediatra">Odontopediatra</option>
						</form:select>
					</div>
				</div>
				<!-- ZONA------------------------------------------------------------------>
				<label class="control-label">Elegir Zona</label>
				<form:select class="form-select form-select-lg mb-3" path="zone">
					<option disabled selected value>-- seleccionar --</option>
					<option value="norte">Zona Norte</option>
					<option value="sur">Zona Sur</option>
					<option value="oeste">Zona Oeste</option>
				</form:select>
				<!--zonaNorteMenu-->
				<div id="zonaNorteMenu" style="display: none;">
					<div class="form-group">
						<!--how many dining rooms-->
						<label>Localidad</label>
						<form:select class="form-select form-select-lg mb-3" path="city1">
							<option disabled selected value>--TODOS--</option>
							<option value="San Isidro">San Isidro</option>
							<option value="Vicente Lopez">Vicente Lopez</option>
							<option value="Villa Adelina">Villa Adelina</option>
						</form:select>
					</div>
				</div>
				<!--zonaSurMenu-->
				<div id="zonaSurMenu" style="display: none;">
					<div class="form-group">
						<!--how many dining room chairs-->
						<label>Localidad</label>
						<form:select class="form-select form-select-lg mb-3" path="city2">
							<option disabled selected value>--TODOS--</option>
							<option value="Avellaneda">Avellaneda</option>
							<option value="Lomas de Zamora">Lomas de Zamora</option>
						</form:select>
					</div>
				</div>
				<!--Zona Oeste-->
				<div id="zonaOesteMenu" style="display: none;">
					<div class="form-group">
						<!--how many dining room chairs-->
						<label>Localidad</label>
						<form:select class="form-select form-select-lg mb-3" path="city3">
							<option disabled selected value>-- select an option --</option>
							<option value="Castelar">Castelar</option>
							<option value="Moron">Moron</option>
						</form:select>
					</div>
				</div>
				<div>
					<button type="submit" value="Enviar">Buscar</button>
				</div>
		</form:form>
	</div>
	<!-- JavaScript -->
	<script>
		$("#area").change(
				function() {
					$("#specialMenu1,#specialMenu2").hide();
					$("#specialMenu1 select,#specialMenu2 select").prop(
							'selectedIndex', 0);
					if (this.value == "Kinesiologia") {
						$("#specialMenu1").show();
					} else if (this.value == "Odontologia") {
						$("#specialMenu2").show();
					}
				});
	</script>
	<script>
		$("#zone")
				.change(
						function() {
							$("#zonaNorteMenu,#zonaSurMenu,#zonaOesteMenu")
									.hide();
							$(
									"#zonaNorteMenu select,#zonaSurMenu select,#zonaOesteMenu select")
									.prop('selectedIndex', 0);
							if (this.value == "norte") {
								$("#zonaNorteMenu").show();
							} else if (this.value == "sur") {
								$("#zonaSurMenu").show();
							} else if (this.value == "oeste") {
								$("#zonaOesteMenu").show();
							}
						});
	</script>
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
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