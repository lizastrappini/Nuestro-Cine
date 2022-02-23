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
	<%if ( request.getAttribute("borrada")!=null ) { %>
        <div class="alert alert-success">¡Funcion borrada con exito!</div>
    <% } %>
	<% for (Funcion fun : lf){ %>
        <div class="funcion">
    		<form action="BorrarFuncion" method="post">
            	<p class="infopelicula" id="fechahora" ><b>Fecha y hora de la funcion:</b> <%=fun.getFecha_hora() %></p>
            	<input type="hidden" name="fechahora" value="<%=fun.getFecha_hora() %>">
            	<p class="infopelicula" id="numerosala"><b>Sala n°:</b>  <%=fun.getNumero_sala()%></p>
            	<input type="hidden" name="nrosala" value="<%= fun.getNumero_sala() %>">
            	<input type="hidden" name="codigopeli" value="<%= fun.getCodigo_pelicula() %>">
            	<br>
            	<button class="button" id="sacarentrada">Borrar Funcion</button>
            </form>
        </div>   
	<%} %>
</div>
</body>
</html>