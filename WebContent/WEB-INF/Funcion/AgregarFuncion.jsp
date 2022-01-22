<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.time.*"%>
<%@page import="java.time.format.*"%>
<%@page import="entities.Persona" %>
<%@page import="java.util.LinkedList"%>
<%@page import="entities.Pelicula"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>---EDIT FUNCIONES---</title>
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
	<title>NUEVA FUNCION</title>
<%

String bandera1 = "";

if ( !(request.getAttribute("encontrada")==(null)) ){
	 bandera1 = request.getAttribute("encontrada").toString();
} 

LinkedList<Pelicula> lp=(LinkedList<Pelicula>)request.getAttribute("peliculas");

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
	
	<%if ( request.getAttribute("encontrada")==(null) ) { %>
		<br>
		<br>
		<h2>Ingrese nombre de la pelicula</h2>
		<form class="addPelicula" action="MostrarPelicula" method="get" >
		<label for="inputNombre" >Nombre de la pelicula</label>
    	<input id="inputNombre" name="nombre" class="form-control" placeholder="nombre de la pelicula" required type="text">
    	<br>
   		 <button class="btn btn-lg btn-primary btn-block" type="submit" >BUSCAR</button>
    	</form>
    <%} %>
  
    <%if ( !(request.getAttribute("encontrada")==(null)) && bandera1.equals("encontrada") ) {%>
    	<br>
		<br>
    	<br>
		
			<%for (Pelicula pel : lp){ %>
			
			<div class="pelicula">
				<div class="infopelicula">
					<img class="infopelicula" id="fotopelicula" src="<%=pel.getPortada()%>"/>
					<p class="nombrepelicula" id="nombrepelicula" ><%= pel.getNombre() %></p>
                    <p class="sinopsis" id="sinopsis"><%= pel.getSinopsis() %></p>
                    <p class="infopelicula"> <b>Director :</b> <%= pel.getDirector() %></p>
                    <p class="infopelicula"> <b>Calificacion :</b> <%= pel.getCalificacion() %></p>
                    <p class="infopelicula"> <b>Duracion :</b> <%= pel.getDuracion() %></p>
                    <form action="NuevaFuncion" method="get">
                    	<input type="hidden" name="codigo" value="<%=pel.getCodigo() %>"/>
                    	<label for="inputNumeroSala" >Numero de Sala</label>
    					<input id="inputNumeroSala" name="numero" class="form-control" placeholder="numero" required type="text">
    					<label for="inputFecha" >Fecha y Hora de la Funcion (yyyy-MM-dd HH:mm)</label>
    					<input id="inputFecha" name="fechahora" class="form-control" placeholder="fechahora" required type="text">
                        <% //if ( request.getAttribute("errorFormatoFecha") != null ) {%>
                        	<!-- <span>Formato de fecha no valida</span> -->
                        <%//}%>
                        <br/>
                        <button class="btn btn-lg btn-primary btn-block" type="submit" id="botonAgregar" >AGREGAR FUNCION</button>
                    </form>
                </div>
            </div>
            <%}%>
    <%}%>
    
</div>
</body>
</html>