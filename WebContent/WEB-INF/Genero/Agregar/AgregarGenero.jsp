<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.time.*"%>
<%@page import="java.time.format.*"%>
<%@page import="entities.Persona" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
        <title>---AGREGAR GENERO---</title>
        <%@ include file="/Estilo.jsp" %>
		<script src="style/codigo.js"></script>
<%  
	LocalDateTime fecha = LocalDateTime.now();
	DateTimeFormatter isoFecha = DateTimeFormatter.ISO_LOCAL_DATE;
	String bandera = null;
	if ( !(request.getAttribute("bandera")==(null)) ){
	bandera = request.getAttribute("bandera").toString();}
	

 
%>
</head>
<body>
	<div class="fondo">
	<jsp:include page="/BarraMenu.jsp" />
    <br>
    <br>
	<h2>AGREGAR GENERO</h2>
	<% if (request.getAttribute("Agregado")!=null) {%>
		<div class="alert alert-success">¡Genero creado con exito!</div>
	<%} if(request.getAttribute("noAgregado")!=null){%>
		<div class="alert alert-danger">El genero ya existe</div>
	<%} %>
	<form class="addCosto" action="NuevoGenero" method="get" >
    <label for="inputGenero" >Nuevo Genero</label>
    <input id="inputCosto" name="nombre" class="form-control" placeholder="nombre del genero" required type="text">
    <br>
    <button class="btn btn-lg btn-primary btn-block" type="submit" id="botonAgregar" >AGREGAR</button>
    </form>
   
	</div>
	
</body>
</html>