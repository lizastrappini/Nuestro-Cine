<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Funcion"%>
<%@page import="entities.Pelicula"%>
<%@page import="entities.Persona"%>
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
	Pelicula p  = (Pelicula)request.getAttribute("pel");
	Integer isEmpleado = 0;
	Persona per = (Persona)request.getSession().getAttribute("usuario");
	
	if ( !(per==null)){
		isEmpleado = per.getHabilitado();
	} else {isEmpleado = 0;}
%>
</head>
<body>
<div class="fondo" >
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
    						<form action="MostrarAsientos" method="get">
                            <p class="infopelicula" id="fechahora" ><b>Fecha y hora de la funcion:</b> <%=fun.getFecha_hora() %></p>
                            <input type="hidden" name="fechahora" value="<%=fun.getFecha_hora() %>">
                            <p class="infopelicula" id="numerosala"><b>Sala n°:</b>  <%=fun.getNumero_sala()%></p>
                            <input type="hidden" name="nrosala" value="<%= fun.getNumero_sala() %>">
                            <input type="hidden" name="codigopeli" value="<%= p.getCodigo() %>">
                            <br>
                            <button class="button" id="sacarentrada">  Sacar entrada   </button>
                            </form>
        </div>
        
	<%} %>
<a class="boton_volver" href="Peliculas.html">VOLVER </a>
</div>
</body>
</html>
