<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Calificacion"%>
<%@page import="java.util.LinkedList" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="/Estilo.jsp" %>		
	<title>BORRAR CALIFICACION</title>
	<%
	LinkedList<Calificacion> lc=(LinkedList<Calificacion>)request.getAttribute("calificaciones");
	Calificacion calificacionEncontrada=(Calificacion)request.getAttribute("calificacionEncontrada");
	%>
</head>
<body>
<div class="fondo">
	<jsp:include page="/BarraMenu.jsp" />	
	<br>
	<br>
	<% if (request.getAttribute("encontrada")==null) {%>
		<h2>Seleccione una Calificacion</h2>
		<form class="addCalificacion" action="BuscarCalificacionBorrar" method="post" >
			<div>
        		<label>Calificaciones</label>
        		<select name="elegircalificacion" required="required">
        			<% for (Calificacion cali: lc){ %>
            			<option value="<%= cali.getCodigo_calificacion() %>"><%= cali.getDescripcion() %></option>
            		<% } %>
        		</select>
    		</div>
    		<br>
   			<button class="btn btn-lg btn-primary btn-block" type="submit" >BUSCAR</button>
    	</form>
    <%} %>
    <% if (request.getAttribute("encontrada")!=null) {%>
    	<% if (request.getAttribute("borrada")!=null) {%>
        	<div class="alert alert-success">¡Calificacion borrada con exito!</div>
    	<% }%>
    	<div class="alert alert-warning">Al eliminar una calificacion se borraran las peliculas con esa calificacion asignada</div>
		<div class="infocalificacion">
			<p class="infocalificacion"> <b>Descripcion :</b> <%= calificacionEncontrada.getDescripcion() %></p>
        	<form action="BuscarCalificacionBorrar" method="post">
            	<input type="hidden" name="codigocali" value="<%= calificacionEncontrada.getCodigo_calificacion() %>">
            	<input type="hidden" name="bandera" value="borrar">
            	<button id="botonBorrar" class="buttonBorrar" >Borrar</button>
        	</form>
    	</div>
    <%} %>
</div>
</body>
</html>