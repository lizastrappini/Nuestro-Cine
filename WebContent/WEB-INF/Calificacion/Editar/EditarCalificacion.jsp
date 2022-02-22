<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.LinkedList" %>
<%@page import="entities.Calificacion"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="/Estilo.jsp" %>
	<title>EDITAR SALA</title>
	<%
	LinkedList<Calificacion> lc=(LinkedList<Calificacion>)request.getAttribute("calificaciones");
	Calificacion calificacionEncontrada = (Calificacion)request.getAttribute("calificacionEncontrada");	  
	%>
</head>
<body>
<div class="fondo">
	<jsp:include page="/BarraMenu.jsp" />	
	<%	if ( request.getAttribute("encontrada")==null ){ %>
	<br>
	<br>
	<h2>Seleccione una calificacion</h2>
	<form class="addCalificacion" action="ActualizarCalificacion" method="post" >
		<div>
        	<label>Calificaciones</label>
        	<select name="elegircalificacion" required="required">
        		<% for (Calificacion cali: lc){ %>
            		<option value="<%= cali.getCodigo_calificacion() %>"><%= cali.getCodigo_calificacion() %></option>
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
        	<div class="alert alert-success">¡Calificacion editada con exito!</div>
    	<% }%>
		<div class="infocalificacion">
			<p class="infocalificacion"> <b>Descripcion :</b> <%= calificacionEncontrada.getDescripcion() %></p>
			<h2>Edite la calificacion</h2>
        	<form action="ActualizarCalificacion" method="post">
            	<label for="descripcion">Ingrese Nueva Descripcion</label>
            	<input type="text" id="descripcion" name="descripcion" value="<%= calificacionEncontrada.getDescripcion() %>">
            	<input type="hidden" name="codigocali" value="<%= calificacionEncontrada.getCodigo_calificacion() %>">
            	<input type="hidden" name="bandera" value="editar">
            	<button id="botonEditar" class="buttonEditar" >Editar</button>
        	</form>
    	</div>
    <%} %>
</div>
</body>
</html>