<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.time.*"%>
    <%@page import="java.time.format.*"%>
    <%@page import="entities.Persona" %>
    <%@page import="entities.Genero" %>
	<%@page import="logic.LogicGenero" %>
	<%@page import="entities.Calificacion" %>
	<%@page import="logic.LogicCalificacion" %>
	<%@page import="java.util.LinkedList"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<%@ include file="/Estilo.jsp" %>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script src="Javascript/Script.js"></script>
	<title>NUEVA PELICULA</title>

<%  
	LocalDateTime fecha = LocalDateTime.now();
	DateTimeFormatter isoFecha = DateTimeFormatter.ISO_LOCAL_DATE;
	Integer isEmpleado = 0;
	Persona per = (Persona)request.getSession().getAttribute("usuario");
		
		if ( !(per==null)){
			isEmpleado = per.getHabilitado();
		} else {isEmpleado = 0;}	 
		LogicGenero lg = new LogicGenero();
		LinkedList<Genero> listaGeneros = lg.getAll();
		
		LogicCalificacion lc = new LogicCalificacion();
		LinkedList<Calificacion> listaCalif = lc.getAll();
    %>
</head>
<body>
<%if ( per != (null) && isEmpleado==1 ){ %>
<div class="fondo">
<!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark navbar-custom fixed-top">
            <div class="container px-5">
                <a class="navbar-brand" href="index.jsp">NUESTRO CINE</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto">	
                    <%if ( isEmpleado==1){ %>
                    	<li class="nav-item"><a class="nav-link" href="Empleados.jsp">EMPLEADOS</a></li> 
                    <%} else {%>
                    	<%} %>	 
                    	<li class="nav-item"><a class="nav-link" href="Peliculas.jsp">Cartelera</a></li>
                        
                        <% if ( request.getSession().getAttribute("usuario")==null ) {%>
                        
                        <li class="nav-item"><a class="nav-link" href="SignUp.jsp">Registrarse</a></li>
                        <li class="nav-item"><a class="nav-link" href="SignIn.jsp" id="signin">Iniciar sesion</a></li>
                        <%}else {%> 
                        <li class="nav-item"><a class="nav-link">HOLA, <%=per.getNombre().toUpperCase()%>!</a></li>
                        <li class="nav-item"><a class="nav-link" id="signout" onclick="cerrarSesion()" >Cerrar sesion</a></li>
                        <li class="nav-item"><a class="nav-link" id="" href="MiCuenta.jsp">Mi cuenta</a></li>
                   		<%} %>	
                    </ul>
                     
                </div>
            </div>
        </nav>
    <br>
    <br>
	<h1>AGREGAR PELICULA</h1>
	<% if (request.getAttribute("cargada")!=null) {%>
		<div class="alert alert-success">¡Pelicula creada con exito!</div>
	<%} %>
	<form class="addPelicula" action="NuevaPelicula" method="get" >
	<label for="inputNombre" >Nombre de la pelicula</label>
    <input id="inputNombre" name="nombre" class="form-control" placeholder="nombre de la pelicula" required type="text">
    <label>Genero</label>
    <select name="elegirGenero" required="required">
        		<% for (Genero gen: listaGeneros){ %>
        				<option value="<%= gen.getId() %>" selected="selected"><%=gen.getDescripcion() %></option>
            	<% } %>
     </select>
     <label>Calificacion</label>
        	<select name="elegirCalificacion" required="required">
        		<% for (Calificacion c: listaCalif){ %>
        				<option value="<%= c.getCodigo_calificacion() %>" selected="selected"><%=c.getDescripcion() %></option>
            		<% } %>
       </select>     	     	
	<br>
	<label for="inputSinopsis" >Sinopsis de la pelicula</label>
    <input id="inputSinopsis" name="sinopsis" class="form-control" placeholder="sinopsis" required type="text">
    <label for="inputDirector" >Director de la pelicula</label>
    <input id="inputDirector" name="director" class="form-control" placeholder="director" required type="text">
    <label for="inputDuracion" >Duracion de la pelicula</label>
    <input id="inputDuracion" name="duracion" class="form-control" placeholder="duracion" required type="text">
    <label for="inputPortada" >Portada de la pelicula</label>
    <input id="inputPortada" name="portada" class="form-control" placeholder="url de la portada" required type="text">
    <label for="inputEstreno" >Fecha de estreno</label>
    	<% if (request.getAttribute("errorFormatoFecha")!=null) {%>
        		<div class="alert alert-danger">Formato de fecha invalido</div>
    	<% }%>
    	<input id="inputFechaHora" name="fechahora" class="form-control" 
    		placeholder="fechahora" required type="text" value="<%=fecha.format(isoFecha)%>">
    <br>
    <button class="btn btn-lg btn-primary btn-block" type="submit" id="botonAgregar" >AGREGAR</button>
    </form>
  
</div>
<%} else {%>
<jsp:forward page="index.jsp"/>
<%} %>
</body>
</html>