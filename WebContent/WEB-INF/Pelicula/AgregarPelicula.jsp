<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.time.*"%>
    <%@page import="java.time.format.*"%>
    <%@page import="entities.Persona" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>---EDIT PELICULAS---</title>
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js" ></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="style/css/styles.css" rel="stylesheet" />
        <link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" >
		<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
		<script src="style/codigo.js"></script>
<title>NUEVA PELICULA</title>

<%  
	LocalDateTime fecha = LocalDateTime.now();
	DateTimeFormatter isoFecha = DateTimeFormatter.ISO_LOCAL_DATE;
	String bandera = null;
	if ( !(request.getAttribute("bandera")==(null)) ){
	bandera = request.getAttribute("bandera").toString();}
	
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
	<h2>AGREGAR PELICULA</h2>
	<form class="addPelicula" action="NuevaPelicula" method="get" >
	<label for="inputNombre" >Nombre de la pelicula</label>
    <input id="inputNombre" name="nombre" class="form-control" placeholder="nombre de la pelicula" required type="text">
    <label>Elegir genero:
			<input list="generos" name="genero" /></label>
			<datalist id="generos">
			<option value="romance">Romance</option>
			<option value="terror">Terror</option>
			<option value="suspenso">Suspenso</option>
			<option value="todas">Comedia</option>
			</datalist>
	<label>Elegir calificacion:
			<input list="edades" name="edad" /></label>
			<datalist id="edades">
			<option value="+3">+3</option>
			<option value="+7">+7</option>
			<option value="+16">+16</option>
			<option value="todas">Apta para todo publico</option>
			</datalist>
	<br>
	<label for="inputSinopsis" >Sinopsis de la pelicula</label>
    <input id="inputSinopsis" name="sinopsis" class="form-control" placeholder="sinopsis" required type="text">
    <label for="inputDirector" >Director de la pelicula</label>
    <input id="inputDirector" name="director" class="form-control" placeholder="director" required type="text">
    <label for="inputDuracion" >Duracion de la pelicula</label>
    <input id="inputDuracion" name="duracion" class="form-control" placeholder="duracion" required type="text">
    <label for="inputPortada" >Portada de la pelicula</label>
    <input id="inputPortada" name="portada" class="form-control" placeholder="url de la portada" required type="text">
    <label for="inputEstreno" >Fecha de estreno</label>
    <input id="inputEstreno" name="estreno" class="form-control" placeholder="<%=fecha.format(isoFecha)%>" required type="text">
    <br>
    <button class="btn btn-lg btn-primary btn-block" type="submit" id="botonAgregar" >AGREGAR</button>
    </form>
   
</div>
</body>
</html>