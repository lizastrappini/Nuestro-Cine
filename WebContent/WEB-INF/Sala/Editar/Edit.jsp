<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Sala"%>
<%@page import="entities.Persona" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="style/css/styles.css" rel="stylesheet" />
<script src="style/codigo.js"></script>
<title>EDITAR SALA</title>
<% 
Sala sala = (Sala)request.getAttribute("sala"); 
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
	<h1>Edite la sala</h1>
	<form class="addSala" action="ActualizarSala" method="post" >
	<input type="hidden" id="inputNumero" name="numero" class="form-control" placeholder="numero" required type="text" value="<%= sala.getNumero() %>">
    <br>
    <input type="hidden" name="bandera" value="cambio">
    <input type="hidden" name="salaanterior" value="<%=sala%>">

    <button class="btn btn-lg btn-primary btn-block" type="submit" id="botonEditar">EDITAR</button>

	</form>
</div>	
</body>
</html>