<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.time.*"%>
<%@page import="java.time.format.*"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entities.Pelicula"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="/Estilo.jsp" %>
	<title>NUEVA FUNCION</title>
	<%

	String bandera1 = "";

	if ( !(request.getAttribute("encontrada")==(null)) ){
		bandera1 = request.getAttribute("encontrada").toString();
	} 

	LinkedList<Pelicula> lp=(LinkedList<Pelicula>)request.getAttribute("peliculas");	 	 
	%>
</head>
<body>
<div class="fondo">
<!-- Navigation-->
	<jsp:include page="/BarraMenu.jsp" />
	<%if ( request.getAttribute("encontrada")==(null) ) { %>
		<br>
		<br>
		<h2>Ingrese nombre de la pelicula</h2>
		<form class="addPelicula" action="BuscarPeliculasAgregar" method="get" >
			<label for="inputNombre" >Nombre de la pelicula</label>
    		<input id="inputNombre" name="nombre" class="form-control" placeholder="nombre de la pelicula" required type="text">
    		<br>
   		 	<button class="btn btn-lg btn-primary btn-block" type="submit" >BUSCAR</button>
    	</form>
    <%} %>
  
    <%if ( !(request.getAttribute("encontrada")==(null)) && bandera1.equals("encontrada") ) {%>
    	<br>
		<br>
    	<br>
		<%for (Pelicula pel : lp){ %>
			<div class="pelicula">
				<div class="infopelicula">
					<img class="infopelicula" id="fotopelicula" src="<%=pel.getPortada()%>"/>
					<p class="nombrepelicula" id="nombrepelicula" ><%= pel.getNombre() %></p>
                    <p class="sinopsis" id="sinopsis"><%= pel.getSinopsis() %></p>
                    <p class="infopelicula"> <b>Director :</b> <%= pel.getDirector() %></p>
                    <p class="infopelicula"> <b>Calificacion :</b> <%= pel.getCalificacion() %></p>
                    <p class="infopelicula"> <b>Duracion :</b> <%= pel.getDuracion() %></p>
                    <form action="NuevaFuncion" method="post">
                    	<input type="hidden" name="codigo" value="<%=pel.getCodigo() %>"/>
                        <br>
                        <button class="btn btn-lg btn-primary btn-block" type="submit" id="botonAgregar" >AGREGAR FUNCION</button>
                    </form>
                </div>
            </div>
       <%}%>
    <%}%>
</div>
</body>
</html>