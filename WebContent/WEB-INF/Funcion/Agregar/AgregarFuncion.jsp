<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entities.Pelicula"%><%@page import="entities.Persona" %>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="/Estilo.jsp" %>
	<title>NUEVA FUNCION</title>
	<%
	LinkedList<Pelicula> lp=(LinkedList<Pelicula>)request.getAttribute("peliculas");
	Pelicula peliculaEncontrada = (Pelicula)request.getAttribute("peliculaEncontrada");
	%>
</head>
<body>
<div class="fondo">
	<jsp:include page="/BarraMenu.jsp" />
	<%if ( request.getAttribute("encontrada")==null ) { %>
		<br>
		<br>
		<%if ( request.getAttribute("Noencontrada")!=null ) { %>
        	<div class="alert alert-warning">No se encontro la pelicula seleccionada</div>
        <% } %>
		<h2>Seleccione una pelicula</h2>
		<form class="addPelicula" action="BuscarPeliculasAgregar" method="get" >
			<div>
        		<label>Peliculas</label>
        		<select name="elegirpelicula" required="required">
        			<% for (Pelicula pel: lp){ %>
            			<option value="<%= pel.getCodigo() %>"><%= pel.getNombre() %></option>
            		<% } %>
        		</select>
    		</div>
    		<br>
   		 	<button class="btn btn-lg btn-primary btn-block" type="submit" >BUSCAR</button>
    	</form>
    <%} %>
  
    <%if ( request.getAttribute("encontrada")!=null ) {%>
    	<br>
		<br>
    	<br>
		<div class="pelicula">
			<div class="infopelicula">
				<img class="infopelicula" id="fotopelicula" src="<%=peliculaEncontrada.getPortada()%>"/>
				<p class="nombrepelicula" id="nombrepelicula" ><%= peliculaEncontrada.getNombre() %></p>
                <p class="sinopsis" id="sinopsis"><%= peliculaEncontrada.getSinopsis() %></p>
                <p class="infopelicula"> <b>Director :</b> <%= peliculaEncontrada.getDirector() %></p>
                <p class="infopelicula"> <b>Calificacion :</b> <%= peliculaEncontrada.getCodigo_calificacion() %></p>
                <p class="infopelicula"> <b>Duracion :</b> <%= peliculaEncontrada.getDuracion() %></p>
                <form action="NuevaFuncion" method="post">
                    <input type="hidden" name="codigoPel" value="<%=peliculaEncontrada.getCodigo() %>"/>
                    <br>
                    <button class="btn btn-lg btn-primary btn-block" type="submit" id="botonAgregar" >AGREGAR FUNCION</button>
                </form>
            </div>
        </div>
    <%}%>
</div>
</body>
</html>