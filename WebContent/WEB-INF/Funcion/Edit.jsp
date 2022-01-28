<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Funcion"%>
<%@page import="entities.Persona" %>
<%@page import="entities.Pelicula" %>
<%@page import="entities.Sala" %>
<%@page import="java.util.LinkedList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="style/css/styles.css" rel="stylesheet" />
<script src="style/codigo.js"></script>
<title>EDITAR SALA</title>
<% 
Funcion funcionanterior = (Funcion)request.getAttribute("funcionanterior");

Pelicula pelant = (Pelicula)request.getAttribute("pelicula");

Integer isEmpleado = 0;
Persona per = (Persona)request.getSession().getAttribute("usuario");

LinkedList<Pelicula> lp=(LinkedList<Pelicula>)request.getAttribute("peliculas");
LinkedList<Sala> ls=(LinkedList<Sala>)request.getAttribute("salas");
	
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
	<h1>Edite la funcion</h1>
	<form class="addFuncion" action="ActualizarFuncion" method="post" >
	<div>
        <label>Peliculas</label>
        <select name="elegirpelicula" required="required">
        	<% for (Pelicula pel: lp){ %>
        		<% if (pel.getCodigo() == pelant.getCodigo()){ %>
        			<option value="<%= pel.getCodigo() %>" selected="selected"><%= pel.getNombre() %></option>
        		<% } else { %>
            		<option value="<%= pel.getCodigo() %>"><%= pel.getNombre() %></option>
            	<% } %>
            <% } %>
        </select>
    </div>
    <br>
    <div>
        <label>Salas</label>
        <select name="elegirsala" required="required">
        	<% for (Sala sal: ls){ %>
        		<% if (sal.getNumero() == funcionanterior.getNumero_sala() ){ %>
        			<option value="<%= sal.getNumero() %>" selected="selected"><%= sal.getNumero() %></option>
        		<% } else { %>
            		<option value="<%= sal.getNumero() %>"><%= sal.getNumero() %></option>
            	<% } %>
            <% } %>
        </select>
    </div>
    <br>
    <label for="inputFechaHora" >Fecha y Hora</label>
    <% if (request.getAttribute("errorFormatoFecha")!=null) {%>
        		<div class="alert alert-danger">Formato de fecha invalido</div>
    <%}%>
    <input id="inputFechaHora" name="fechahora" class="form-control" placeholder="fechahora" required type="text" value="<%= funcionanterior.getFecha_hora() %>">
    <br>
    <input type="hidden" name="bandera" value="cambio">
    <input type="hidden" name="codigoPelAnt" value="<%=funcionanterior.getCodigo_pelicula()%>">
    <input type="hidden" name="numSalaAnt" value="<%=funcionanterior.getNumero_sala()%>">
    <input type="hidden" name="fechaHoraAnt" value="<%=funcionanterior.getFecha_hora()%>">

    <button class="btn btn-lg btn-primary btn-block" type="submit" id="botonEditar">EDITAR</button>

	</form>
</div>	
</body>
</html>