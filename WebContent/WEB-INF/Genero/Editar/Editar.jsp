<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.time.*"%>
<%@page import="java.time.format.*"%>
<%@page import="entities.Persona" %>
<%@page import="entities.Genero" %>
<%@page import="logic.LogicGenero" %>
<%@page import="java.util.LinkedList"%>

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
	
	Integer isEmpleado = 0;
	Persona per = (Persona)request.getSession().getAttribute("usuario");
		
		if ( !(per==null)){
			isEmpleado = per.getHabilitado();
		} else {isEmpleado = 0;}	
		
	LogicGenero lg = new LogicGenero();
	LinkedList<Genero> listageneros = lg.getAll();
	
 
%>
</head>
<body>
	<div class="fondo">
	<jsp:include page="/BarraMenu.jsp" />
    <br>
    <br>
	<h2>EDITAR GENERO</h2>
	<form class="addCosto" action="EditarGenero" method="get" >
    <label for="inputGenero" >Editar Genero</label>
    <input id="inputCosto" name="nombre" class="form-control" placeholder="nombre del genero" required type="text">
    <input type="hidden" value="">
    <br>
    <br>
    <button class="btn btn-lg btn-primary btn-block" type="submit" id="botonAgregar" >EDITAR</button>
    </form>
   
	</div>
	
</body>
</html>