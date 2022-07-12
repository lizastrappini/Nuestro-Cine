<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Sala" %>
<%@page import="java.util.LinkedList"%>
<%@page import="entities.Persona" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="/Estilo.jsp" %>
	<title>NUEVA SALA</title>
	<%
	Integer isEmpleado = 0;
	Persona per = (Persona)request.getSession().getAttribute("usuario");
	
	if ( !(per==null)){
		isEmpleado = per.getHabilitado();
		} else { isEmpleado = 0;} %>
</head>
<body>
<div class="fondo">
	<jsp:include page="/BarraMenu.jsp" />
    <br>
    <br>
	<h2>AGREGAR SALA</h2>
	<% if (request.getAttribute("cargada")!=null) {%>
		<div class="alert alert-success">¡Sala creada con exito!</div>
	<%} %>
	<form class="addSala" action="NuevaSala" method="post" >
		<label for="inputDescripcion" >Descripcion</label>
    	<input id="inputDescripcion" name="descripcion" class="form-control" placeholder="descripcion de la sala" required type="text">	
    	<br>
    	<button class="btn btn-lg btn-primary btn-block" type="submit" id="botonAgregar" >AGREGAR</button>
    </form>
</div>
</body>
</html>