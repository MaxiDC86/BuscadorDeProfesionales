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
<script
	src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>

	<div class="main-block">
		<h1>Bienvenidos al buscador de profesionales.</h1>

		
		<form:form action="procesaBusqueda" modelAttribute="selection">  
			<div class="form-group">
				<label for="cleaning-service" class="control-label">Elegir
					Zona a buscar</label> <select class="form-control" id="location"
					path="zone">
					<option disabled selected value>-- select an option --</option>
					<option value="norte">Zona Norte</option>
					<option value="sur">Zona Sur</option>
					<option value="oeste">Zona Oeste</option>
				</select>
			</div>
			<!--carpet cleaning-->
			<div id="zonaNorteMenu" style="display: none;">
				<div class="form-group">
					<!--how many dining rooms-->
					<label>Elegir Localidad</label> <select path="city">
						<option>San Isidro</option>
						<option>Vicente Lopez</option>
					</select>
				</div>
			</div>
			<!--upholstery cleaning-->
			<div id="zonaSurMenu" style="display: none;">
				<div class="form-group">
					<!--how many dining room chairs-->
					<label>Elegir Localidad</label> <select path="city">
						<option>Avellaneda</option>
						<option>Lomas de Zamora</option>
					</select>
				</div>
			</div>

			<!--Zona Oeste-->
			<div id="zonaOesteMenu" style="display: none;">
				<div class="form-group">
					<!--how many dining room chairs-->
					<label>Elegir Localidad</label> <select path="city">
						<option>Castelar</option>
						<option>Moron</option>
					</select>
				</div>
			</div>
			<div>
				<button type="submit" value="Enviar">Buscar</button>

			</div>

		</form:form>

	</div>

	<script>
		$("#location")
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
</body>
</html>