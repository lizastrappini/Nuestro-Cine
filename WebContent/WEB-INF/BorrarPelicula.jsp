<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form class="addPelicula" action="EditPeliculas" method="get" >
	<h2>Ingrese nombre de la pelicula</h2>
	<label for="inputNombre" >Nombre de la pelicula</label>
    <input id="inputNombre" name="nombre" class="form-control" placeholder="nombre de la pelicula" required type="text">
    <button class="btn btn-lg btn-primary btn-block" type="submit" >BUSCAR</button>
    </form>
</body>
</html>