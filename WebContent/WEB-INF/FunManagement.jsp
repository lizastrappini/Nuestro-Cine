<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Funcion"%>
<%@page import="java.util.LinkedList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
		<link rel="shortcut icon" href="https://img.icons8.com/ios-glyphs/30/ffffff/cinema---v1.png">
<title>Funciones</title>
<% 
	LinkedList<Funcion> lf=(LinkedList<Funcion>)request.getAttribute("listafunciones");
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
<br>
	<% for (Funcion fun : lf){ %>
	  <!-- Content section 1-->
        <div class="pelicula">
    
                            <p class="infopelicula" id="fechahora"><b>Fecha y hora de la funcion:</b> <%=fun.getFecha_hora() %></p>
                            <p class="infopelicula" id="numerosala"><b>Sala n°:</b>  <%=fun.getNumero_sala()%></p>
                            <br>
                            <button class="button" id="sacarentrada">  Sacar entrada   </button>
                            
        </div>
        
	<%} %>
<a class="boton_volver" href="Peliculas.html">VOLVER </a>
</div>
</body>
</html>