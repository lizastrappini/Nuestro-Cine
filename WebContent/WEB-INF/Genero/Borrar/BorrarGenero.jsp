<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Genero"%>
<%@page import="java.util.LinkedList" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="/Estilo.jsp" %>		
	<title>BORRAR GENERO</title>
	<%
	LinkedList<Genero> lg=(LinkedList<Genero>)request.getAttribute("generos");
	Genero generoEncontrado=(Genero)request.getAttribute("generoEncontrado");
	%>
</head>
<body>
<div class="fondo">
	<jsp:include page="/BarraMenu.jsp" />	
	<br>
	<br>
	<% if (request.getAttribute("encontrada")==null) {%>
		<h2>Seleccione un Genero</h2>
		<form class="addGenero" action="BorrarGenero" method="post" >
			<div>
        		<label>Generos</label>
        		<select name="elegirgenero" required="required">
        			<% for (Genero gen: lg){ %>
            			<option value="<%= gen.getId() %>"><%= gen.getDescripcion() %></option>
            		<% } %>
        		</select>
    		</div>
    		<br>
   			<button class="btn btn-lg btn-primary btn-block" type="submit" >BUSCAR</button>
    	</form>
    <%} %>
    <% if (request.getAttribute("encontrada")!=null) {%>
    	<% if (request.getAttribute("borrada")!=null) {%>
        	<div class="alert alert-success">¡Genero borrado con exito!</div>
    	<% }%>
    	<div class="alert alert-warning">Al eliminar un genero se borraran las peliculas con ese genero asignado</div>
		<div class="infocalificacion">
			<p class="infocalificacion"> <b>Descripcion :</b> <%= generoEncontrado.getDescripcion() %></p>
        	<form action="BorrarGenero" method="post">
            	<input type="hidden" name="idgen" value="<%= generoEncontrado.getId() %>">
            	<input type="hidden" name="bandera" value="borrar">
            	<button id="botonBorrar" class="buttonBorrar" >Borrar</button>
        	</form>
    	</div>
    <%} %>
</div>
</body>
</html>