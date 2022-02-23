<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Pelicula"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="entities.Persona" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="style/css/styles.css" rel="stylesheet" />
<script src="style/codigo.js"></script>
<title>EDITAR PELICULA</title>
<% 
Pelicula peli = (Pelicula)request.getAttribute("pelicula"); 
Integer isEmpleado = 0;
Persona per = (Persona)request.getSession().getAttribute("usuario");
	
	if ( !(per==null)){
		isEmpleado = per.getHabilitado();
	} else {isEmpleado = 0;}	 
%>
</head>
<body>
<div class="fondo">
<!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark navbar-custom fixed-top">
            <div class="container px-5">
                <a class="navbar-brand" href="index.jsp">NUESTRO CINE</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto">	
                    <%if ( isEmpleado==1){ %>
                    	<li class="nav-item"><a class="nav-link" href="Empleados.jsp">EMPLEADOS</a></li> 
                    <%} else {%>
                    	<%} %>	 
                    	<li class="nav-item"><a class="nav-link" href="Peliculas.jsp">Cartelera</a></li>
                        
                        <% if ( request.getSession().getAttribute("usuario")==null ) {%>
                        
                        <li class="nav-item"><a class="nav-link" href="SignUp.html">Registrarse</a></li>
                        <li class="nav-item"><a class="nav-link" href="SignIn.html" id="signin">Iniciar sesion</a></li>
                        <%}else {%> 
                        <li class="nav-item"><a class="nav-link">HOLA, <%=per.getNombre().toUpperCase()%>!</a></li>
                        <li class="nav-item"><a class="nav-link" id="signout" href="SignOut" >Cerrar sesion</a></li>
                        
                   		<%} %>	
                    </ul>
                     
                </div>
            </div>
        </nav>
     <br>
     <br>
	<h1>Edite la pelicula</h1>
	<form class="addPelicula" action="ActualizarPelicula" method="post" >
	<label for="inputNombre" >Nombre de la pelicula</label>
	<input type="hidden" name="codigo" value="<%= peli.getCodigo() %>">
    <input id="inputNombre" name="nombre" class="form-control"  required type="text" value="<%= peli.getNombre() %>">
    <label>Elegir genero:
			<input list="generos" name="genero" value="<%= peli.getGenero() %>"></label>
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
    <input type="text" id="inputestreno" name="estreno"   value="<%=peli.getFecha_estreno().toString()%>">
       
    <br>
    <input type="hidden" name="bandera" value="cambio">
    <input type="hidden" name="pelianterior" value="<%=peli%>">

    <button class="btn btn-lg btn-primary btn-block" type="submit" id="botonEditar">EDITAR</button>

	</form>
</div>	
</body>
</html>