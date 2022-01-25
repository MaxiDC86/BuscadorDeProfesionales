<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Contacto</title>
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
					<li ><a href="http://salud-cerca.site">Home</a></li>
					<li class="active"><a href="#">Contacto</a></li>
					<li><a href="/nosotros">Nosotros</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="well well-sm">
					<form:form class="form-horizontal" action="enviarContactoFormulario"
						modelAttribute="contactoFormulario">
						<fieldset>
							<legend class="text-center">Contactanos!</legend>

							<!-- Name input-->
							<div class="form-group">
								<label class="col-md-3 control-label" >Nombre</label>
								<div class="col-md-9">
									<form:input path="name" type="text"
										placeholder="Your name" class="form-control"></form:input>
								</div>
							</div>

							<!-- Email input-->
							<div class="form-group">
								<label class="col-md-3 control-label" for="email">Tú
									E-mail</label>
								<div class="col-md-9">
									<form:input  path="email" type="text"
										placeholder="Your email" class="form-control"></form:input>
								</div>
							</div>

							<!-- Message body -->
							<div class="form-group">
								<label class="col-md-3 control-label" for="message">Tú
									mensage</label>
								<div class="col-md-9">
									<form:textarea class="form-control" path="message"
										placeholder="Please enter your message here..." rows="5"></form:textarea>
								</div>
							</div>

							<!-- Form actions -->
							<div class="form-group">
								<div class="col-md-12 text-right">
									<button type="submit" class="btn btn-primary btn-lg">Enviar</button>
								</div>
							</div>
						</fieldset>
					</form:form>
				</div>
			</div>
		</div>
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