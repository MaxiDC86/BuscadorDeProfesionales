<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Welcome to a Spring app</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/recursos/css/styles.css">
</head>
<body>

<div class="main-block">
<h1>Bienvenidos buscador de profesionales.</h1>

<form method="get" action="resultado">
    <button type="submit">Buscar</button>
</form>
</div>
</body>
</html>