<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Sala"%>
<%@page import="java.util.LinkedList" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="/Estilo.jsp" %>		
	<title>BORRAR SALA</title>
	<%
	LinkedList<Sala> ls=(LinkedList<Sala>)request.getAttribute("salas");
	Sala salaEncontrada=(Sala)request.getAttribute("salaEncontrada");
	%>
</head>
<body>
<div class="fondo">
	<jsp:include page="/BarraMenu.jsp" />	
	<br>
	<br>
	<% if (request.getAttribute("encontrada")==null) {%>
		<h2>Seleccione una sala</h2>
		<form class="addSala" action="BuscarSalaBorrar" method="post" >
			<div>
        		<label>Salas</label>
        		<select name="elegirsala" required="required">
        			<% for (Sala sal: ls){ %>
            			<option value="<%= sal.getNumero() %>"><%= sal.getNumero() %></option>
            		<% } %>
        		</select>
    		</div>
    		<br>
   			<button class="btn btn-lg btn-primary btn-block" type="submit" >BUSCAR</button>
    	</form>
    <%} %>
    <% if (request.getAttribute("encontrada")!=null) {%>
    	<% if (request.getAttribute("borrada")!=null) {%>
        	<div class="alert alert-success">¡Sala borrada con exito!</div>
    	<% }%>
    	<div class="alert alert-warning">Al eliminar una sala se borraran las funciones asignadas a esa sala</div>
		<div class="infosala">
			<p class="infosala"> <b>Numero Sala :</b> <%= salaEncontrada.getNumero() %></p>
			<p class="infosala"> <b>Descripcion :</b> <%= salaEncontrada.getDescripcion() %></p>
        	<form action="BuscarSalaBorrar" method="post">
            	<input type="hidden" name="numerosala" value="<%= salaEncontrada.getNumero() %>">
            	<input type="hidden" name="bandera" value="borrar">
            	<button id="botonBorrar" class="buttonBorrar" >Borrar</button>
        	</form>
    	</div>
    <%} %>
</div>
</body>
</html>