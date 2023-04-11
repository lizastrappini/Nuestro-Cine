<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Funcion"%>
<%@page import="entities.Persona" %>
<%@page import="entities.Pelicula" %>
<%@page import="entities.Sala" %>
<%@page import="java.util.LinkedList"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="/Estilo.jsp" %>
	<title>EDITAR SALA</title>
	<%
	Funcion funcionActual = (Funcion)request.getAttribute("funcionActual");

	Pelicula pelActual = (Pelicula)request.getAttribute("pelActual");

	LinkedList<Pelicula> lp=(LinkedList<Pelicula>)request.getAttribute("peliculas");
	LinkedList<Sala> ls=(LinkedList<Sala>)request.getAttribute("salas");	 
	%>
</head>
<body>
<div class="fondo">
	<jsp:include page="/BarraMenu.jsp" />
    <br>
    <br>
    <% if (request.getAttribute("modificada")!=null) {%>
    	<div class="alert alert-success">¡Funcion actualizada con exito!</div>
    <% } %>
	<h1>Edite la funcion</h1>
	<form class="addFuncion" action="ActualizarFuncion" method="post" >
		<div>
        	<label>Peliculas</label>
        	<select name="elegirpelicula" required="required">
        		<% for (Pelicula pel: lp){ %>
        			<% if (pel.getCodigo() == pelActual.getCodigo()){ %>
        				<option value="<%= pel.getCodigo() %>" selected="selected"><%= pel.getNombre() %></option>
        			<% } else { %>
            			<option value="<%= pel.getCodigo() %>"><%= pel.getNombre() %></option>
            		<% } %>
            	<% } %>
        	</select>
    	</div>
    	<br>
    	<div>
        	<label>Salas</label>
        	<select name="elegirsala" required="required">
        		<% for (Sala sal: ls){ %>
        			<% if (sal.getNumero() == funcionActual.getNumero_sala() ){ %>
        				<option value="<%= sal.getNumero() %>" selected="selected"><%= sal.getNumero() %></option>
        			<% } else { %>
            			<option value="<%= sal.getNumero() %>"><%= sal.getNumero() %></option>
            		<% } %>
            	<% } %>
        	</select>
    	</div>
    	<br>
    	<label for="inputFechaHora" >Ingrese Fecha y Hora de la Funcion con el siguiente formato: yyyy-MM-dd HH:mm</label>
    	<% if (request.getAttribute("errorFormatoFecha")!=null) {%>
        		<div class="alert alert-danger">Formato de fecha invalido</div>
    	<% }%>
    	<% if (request.getAttribute("fechaExiste")!=null) {%>
        	<div class="alert alert-danger">Ya existe una funcion en esa sala a ese horario</div>
    	<% }%>
    	<% if (request.getAttribute("fechaInvalida")!=null) {%>
        	<div class="alert alert-warning">La fecha no puede ser menor al dia de hoy</div>
        <%}%>
    	<input id="inputFechaHora" name="fechahora" class="form-control" 
    		placeholder="fechahora" required type="text" value="<%= funcionActual.getFecha_hora() %>">
    	<br>
    	<input type="hidden" name="codigoPelAct" value="<%=funcionActual.getCodigo_pelicula()%>">
    	<input type="hidden" name="numSalaAct" value="<%=funcionActual.getNumero_sala()%>">
    	<input type="hidden" name="fechaHoraAct" value="<%=funcionActual.getFecha_hora()%>">
    	<input type="hidden" name="bandera" value="actualizar">
		
    	<button class="btn btn-lg btn-primary btn-block" type="submit" id="botonEditar">EDITAR</button>
	</form>
</div>	
</body>
</html>