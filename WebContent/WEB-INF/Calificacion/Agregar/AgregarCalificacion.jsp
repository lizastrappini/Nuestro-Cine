<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Calificacion" %>
<%@page import="java.util.LinkedList"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="/Estilo.jsp" %>
	<title>NUEVA CALIFICACION</title>
</head>
<body>
<div class="fondo">
	<jsp:include page="/BarraMenu.jsp" />
    <br>
    <br>
	<h2>AGREGAR CALIFICACION</h2>
	<% if (request.getAttribute("cargada")!=null) {%>
		<div class="alert alert-success">¡Calificacion creada con exito!</div>
	<%} %>
	<form class="addCalificacion" action="NuevaCalificacion" method="post" >
		<label for="inputDescripcion" >Descripcion</label>
    	<input id="inputDescripcion" name="descripcion" class="form-control" placeholder="descripcion de la calificacion" required type="text">	
    	<br>
    	<button class="btn btn-lg btn-primary btn-block" type="submit" id="botonAgregar" >AGREGAR</button>
    </form>
</div>
</body>
</html>