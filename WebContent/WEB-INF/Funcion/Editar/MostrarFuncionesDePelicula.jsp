<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Funcion"%>
<%@page import="entities.Pelicula"%>
<%@page import="entities.Persona"%>
<%@page import="java.util.LinkedList"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="/Estilo.jsp" %>
	<title>FUNCIONES</title>
	<% 
	LinkedList<Funcion> lf=(LinkedList<Funcion>)request.getAttribute("listafunciones");
	%>
</head>
<body>
<div class="fondo" >
	<jsp:include page="/BarraMenu.jsp" />
	<br>
	<br>
	<br>
	<br>
	<% if (lf.isEmpty() == false) { %>
		<% for (Funcion fun : lf){ %>
			<div class="pelicula">
    			<form action="ActualizarFuncion" method="post">
            		<p class="infopelicula" id="fechahora" ><b>Fecha y hora de la funcion:</b> <%=fun.getFecha_hora() %></p>
                	<input type="hidden" name="fechaHoraAct" value="<%=fun.getFecha_hora() %>">
                	<p class="infopelicula" id="numerosala"><b>Sala n°:</b>  <%=fun.getNumero_sala()%></p>
                	<input type="hidden" name="numSalaAct" value="<%= fun.getNumero_sala() %>">
                	<input type="hidden" name="codigoPelAct" value="<%= fun.getCodigo_pelicula() %>">
                	<br>
                	<button type="submit" class="btn btn-lg btn-primary btn-block" id="editar">Editar Funcion</button>
            	</form>
        	</div>
		<%} %>
	<%} else {%>
			<div class="alert alert-warning">No existen funciones para la pelicula</div>
	<%} %>
</div>
</body>
</html>