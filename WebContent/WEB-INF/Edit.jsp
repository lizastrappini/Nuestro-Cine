<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Pelicula"%>
<%@page import="java.time.*"%>
<%@page import="java.time.format.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EDITAR PELICULA</title>
<% 
Pelicula peli = (Pelicula)request.getAttribute("pel"); 
LocalDateTime fecha = LocalDateTime.now();
DateTimeFormatter isoFecha = DateTimeFormatter.ISO_LOCAL_DATE;

%>
</head>
<body>
	<h1>Edite la pelicula</h1>
	<form class="addPelicula" action="ActualizarPelicula" method="post" >
	<label for="inputNombre" >Nombre de la pelicula</label>
    <input id="inputNombre" name="nombre" class="form-control" placeholder="nombre de la pelicula" required type="text" value="<%= peli.getNombre() %>">
    <label>Elegir genero:
			<input list="generos" name="genero" value="<%= peli.getGenero() %>"  ></label>
			<datalist id="generos">
			<option value="romance">Romance</option>
			<option value="terror">Terror</option>
			<option value="suspenso">Suspenso</option>
			<option value="todas">Comedia</option>
			</datalist>
	<label>Elegir calificacion:
			<input list="edades" name="edad" value="<%= peli.getCalificacion() %>" ></label>
			<datalist id="edades">
			<option value="+3">+3</option>
			<option value="+7">+7</option>
			<option value="+16">+16</option>
			<option value="todas">Apta para todo publico</option>
			</datalist>
	<br>
	<label for="inputSinopsis" >Sinopsis de la pelicula</label>
    <input id="inputSinopsis" name="sinopsis" class="form-control" placeholder="sinopsis" required type="text" value="<%= peli.getSinopsis() %>">
    
    <label for="inputDirector" >Director de la pelicula</label>
    <input id="inputDirector" name= "director" class="form-control" placeholder="director" required type="text" value="<%= peli.getDirector() %>">
    
    <label for="inputDuracion" >Duracion de la pelicula</label>
    <input id="inputDuracion" name="duracion" class="form-control" placeholder="duracion" required type="text" value="<%= peli.getDuracion() %>">
    
    <label for="inputPortada" >Portada de la pelicula</label>
    <input id="inputPortada" name="portada" class="form-control" placeholder="url de la portada" required type="text" value="<%= peli.getPortada() %>">
    
    <label for="inputEstreno" >Fecha de estreno</label>
    <input type="date" id="inputestreno" name="estreno"
       value=""
       min="1950-01-01" max="<%=fecha.format(isoFecha)%>"  value="<%= peli.getFecha_estreno() %>">
       
    <br>
    <%-- <input type="hidden" name="codigo" value="<%= peli.getCodigo() %>"> --%>
    <button class="btn btn-lg btn-primary btn-block" type="submit" >EDITAR</button>
	</form>
</body>
</html>