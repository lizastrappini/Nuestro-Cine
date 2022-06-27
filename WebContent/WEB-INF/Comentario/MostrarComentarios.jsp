<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entities.Comentario" %>
<%@page import="entities.Pelicula" %>
<%@page import="entities.Persona" %>
<%@page import="entities.Calificacion" %>
<%@page import="logic.LogicCalificacion" %>
<%@page import="logic.Login" %>
<%@ include file="/Estilo.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Detalles</title>
		<% 
		LinkedList<Comentario> listac=(LinkedList<Comentario>)request.getAttribute("listacomentarios");
		LogicCalificacion lc = new LogicCalificacion();
		Pelicula pel  = (Pelicula)request.getAttribute("pel");
		Login lp = new Login();
		%>
	</head>
<body>
	<div class="fondo" >
		<jsp:include page="/BarraMenu.jsp" />
		<br>
		<br>
		<br>
        <div class="pelicula">
        	<img class="infopelicula" id="fotopelicula" src="<%=pel.getPortada()%>" alt="Not Found"  />
            <h2 class="infopelicula" id="nombrepelicula"><%=pel.getNombre() %></h2>
            <p class="infopelicula" id="sinopsis"><%=pel.getSinopsis() %></p>
            <p class="infopelicula"> <b>Director :</b> <%=pel.getDirector() %></p>
            <% Calificacion c = new Calificacion(); %>
            <% c = lc.buscarPorCodigo(pel.getCodigo_calificacion());%>
            <p class="infopelicula"> <b>Calificacion : </b><%=c.getDescripcion()%></p>
            <p class="infopelicula"> <b>Duracion : </b><%=pel.getDuracion() %> min</p>   
        </div>
		<br>
		<br>
		<% for (Comentario com : listac){ %>
        	<div class="pelicula">
    			<!--<form action="MostrarAsientos" method="get"> -->
    				<% Persona per = new Persona(); %>
    				<% per.setDni(com.getDni()); %>
    				<% Persona p = lp.search(per); %>
                	<p class="infopelicula" id="nombreape" ><%=p.getNombre() %> <%=p.getApellido() %></p>
                    <p class="infopelicula" id="comentario"><%=com.getComentario()%></p>
                    <p class="infopelicula" id="fechahora"><%=com.getFecha_hora()%></p>
                    <br>
                <!--</form> -->
           </div>
        
	   <%} %>
	
	</div>	
</body>
</html>