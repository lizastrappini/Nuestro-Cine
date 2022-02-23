<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.LinkedList" %>
<%@page import="entities.Sala"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="/Estilo.jsp" %>
	<title>EDITAR SALA</title>
	<%
	LinkedList<Sala> ls=(LinkedList<Sala>)request.getAttribute("salas");
	Sala salaEncontrada = (Sala)request.getAttribute("salaEncontrada");	  
	%>
</head>
<body>
<div class="fondo">
	<jsp:include page="/BarraMenu.jsp" />	
	<%	if ( request.getAttribute("encontrada")==null ){ %>
	<br>
	<br>
	<h2>Seleccione una sala</h2>
	<form class="addSala" action="ActualizarSala" method="post" >
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
	<% } %>
	<% if (request.getAttribute("encontrada")!=null){  %>
		<br>
		<br>
    	<% if (request.getAttribute("editada")!=null) {%>
        	<div class="alert alert-success">¡Sala editada con exito!</div>
    	<% }%>
		<div class="infosala">
			<p class="infosala"> <b>Numero Sala :</b> <%= salaEncontrada.getNumero() %></p>
			<p class="infosala"> <b>Descripcion :</b> <%= salaEncontrada.getDescripcion() %></p>
			<h2>Edite la sala</h2>
        	<form action="ActualizarSala" method="post">
            	<label for="descripcion">Ingrese Nueva Descripcion</label>
            	<input type="text" id="descripcion" name="descripcion" value="<%= salaEncontrada.getDescripcion() %>">
            	<input type="hidden" name="numerosala" value="<%= salaEncontrada.getNumero() %>">
            	<input type="hidden" name="bandera" value="editar">
            	<button id="botonEditar" class="buttonEditar" >Editar</button>
        	</form>
    	</div>
    <%} %>
</div>
</body>
</html>