<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.LinkedList" %>
<%@page import="entities.Genero"%>
<%@page import="entities.Persona" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="/Estilo.jsp" %>
	<title>EDITAR SALA</title>
	<%

	LinkedList<Genero> lg=(LinkedList<Genero>)request.getAttribute("generos");
	Genero generoEncontrado = (Genero)request.getAttribute("generoEncontrado");	  
	%>
</head>
<body>
<div class="fondo">
	<jsp:include page="/BarraMenu.jsp" />	
	<%	if ( request.getAttribute("encontrada")==null ){ %>
	<br>
	<br>
	<h2>Seleccione un Genero</h2>
	<form class="addGenero" action="EditarGenero" method="post" >
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
	<% } %>
	<% if (request.getAttribute("encontrada")!=null){  %>
		<br>
		<br>
    	<% if (request.getAttribute("editada")!=null) {%>
        	<div class="alert alert-success">¡Genero editado con exito!</div>
    	<% }%>
		<div class="infogenero">
			<p class="infogenero"> <b>Descripcion :</b> <%= generoEncontrado.getDescripcion() %></p>
			<h2>Edite el genero</h2>
        	<form action="EditarGenero" method="post">
            	<label for="descripcion">Ingrese Nueva Descripcion</label>
            	<input type="text" id="descripcion" name="descripcion" value="<%= generoEncontrado.getDescripcion() %>">
            	<input type="hidden" name="idgen" value="<%= generoEncontrado.getId() %>">
            	<input type="hidden" name="bandera" value="editar">
            	<button id="botonEditar" class="buttonEditar" >Editar</button>
        	</form>
    	</div>
    <%} %>
</div>
</body>
</html>