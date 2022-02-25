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
	<title>Funciones</title>
<% 
	LinkedList<Funcion> lf=(LinkedList<Funcion>)request.getAttribute("listafunciones");
	Pelicula p  = (Pelicula)request.getAttribute("pel");
%>
</head>
<body>
<div class="fondo" >
	<jsp:include page="/BarraMenu.jsp" />
<br>
<br>
<br>
<br>
	<% for (Funcion fun : lf){ %>
	  <!-- Content section 1-->
        <div class="pelicula">
    						<form action="MostrarAsientos" method="get">
                            <p class="infopelicula" id="fechahora" ><b>Fecha y hora de la funcion:</b> <%=fun.getFecha_hora() %></p>
                            <input type="hidden" name="fechahora" value="<%=fun.getFecha_hora() %>">
                            <p class="infopelicula" id="numerosala"><b>Sala n°:</b>  <%=fun.getNumero_sala()%></p>
                            <input type="hidden" name="nrosala" value="<%= fun.getNumero_sala() %>">
                            <input type="hidden" name="codigopeli" value="<%= p.getCodigo() %>">
                            <br>
                            <button class="button" id="sacarentrada">  Sacar entrada   </button>
                            </form>
        </div>
        
	<%} %>
<a class="boton_volver" href="Peliculas.html">VOLVER </a>
</div>
</body>
</html>
