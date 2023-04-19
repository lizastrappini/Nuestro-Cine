<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
    <title>Ups</title>
    <link href="style/css/styles.css" rel="stylesheet" />
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
	<div class="fondo">
	<jsp:include page="/BarraMenu.jsp" />
	<div class="contenedorError">
	<h1 class="textoError">Ups..pagina no encontrada</h1>
	<img alt="" src="./style/assets/img/404.png" class="fotoError">
	<br>
	<a href="index.jsp" class="myButton">Ir al index</a>
	</div>
		
</div>
</body>
</html>
