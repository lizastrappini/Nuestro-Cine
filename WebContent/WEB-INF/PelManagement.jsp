<%@page import="entities.Pelicula"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.time.LocalDate" %>
<%@page import="java.time.Month" %>
<%@page import="java.util.Locale" %>
<%@page import="java.time.format.TextStyle" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>---CINE---</title>
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
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" >
		<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Inconsolata:wght@200&display=swap" rel="stylesheet">
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" >
		<link href="https://fonts.googleapis.com/css2?family=Hind:wght@300&display=swap" rel="stylesheet">
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" >
		<link href="https://fonts.googleapis.com/css2?family=Anton&display=swap" rel="stylesheet">
		 <% 
		 
		Month mes = LocalDate.now().getMonth(); //obtengo el mes
		String nombre = mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES")).toUpperCase();  //lo convierto a mayusculas
		LinkedList<Pelicula> lp=(LinkedList<Pelicula>)request.getAttribute("listapeliculas");
		
		%>
   </head>

<body>
<div class="fondo" >		
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark navbar-custom fixed-top">
            <div class="container px-5">
                <a class="navbar-brand" href="index.html">NUESTRO CINE </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item"><a class="nav-link" href="#!">Registrarse</a></li>
                        <li class="nav-item" ><a class="nav-link" >Iniciar sesion</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div></div>
<div></div>
<div></div>
        
<br>
<br>
<br>
<!-- titulo si seleccionamos estrenos -->

<%if( !(request.getAttribute("estrenos")==null) && (request.getAttribute("estrenos").toString()).equals("true")){%> 

	<h1 class="titulo_estrenos"> ESTRENOS DEL MES DE <%=nombre %></h1>

	<%}  %>


<% for (Pelicula pel : lp){ %>
	  <!-- Contenido peliculas-->
        <div class="pelicula">
          					<img class="infopelicula" id="fotopelicula" src="<%=pel.getPortada()%>"  />
                            <h2 class="infopelicula" id="nombrepelicula"><%=pel.getNombre() %></h2>
                            <p class="infopelicula" id="sinopsis"><%=pel.getSinopsis() %></p>
                            <p class="infopelicula"> <b>Director :</b> <%=pel.getDirector() %></p>
                            <p class="infopelicula"> <b>Calificacion : </b><%=pel.getCalificacion() %></p>
                            <p class="infopelicula"> <b>Duracion : </b><%=pel.getDuracion() %></p>
                            <form class="infopelicula" action="Funciones" method="post">
                            	<input type="hidden" name="codigo" value="<%= pel.getCodigo() %>">
                            	<button class="button" id="sacarentrada">  Comprar   </button>
                            </form>
                            
                            
        </div>
        
	<%} %>
<br>
<br>
<a class="boton_volver" href="index.html">VOLVER </a>
</div>	
</body>
</html>