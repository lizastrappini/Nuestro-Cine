<%@page import="entities.Pelicula"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="entities.Persona" %>
<%@page import="entities.Genero" %>
<%@page import="logic.LogicGenero" %>
<%@page import="entities.Calificacion" %>
<%@page import="logic.LogicCalificacion" %>
<%@page import="java.util.LinkedList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="style/css/styles.css" rel="stylesheet" />
<title>EDITAR PELICULA</title>
<%
LogicGenero lg = new LogicGenero();
LinkedList<Genero> listaGeneros = lg.getAll();

LogicCalificacion lc = new LogicCalificacion();
LinkedList<Calificacion> listaCalif = lc.getAll();

Pelicula peli = (Pelicula)request.getAttribute("pelicula"); 
Integer isEmpleado = 0;
Persona per = (Persona)request.getSession().getAttribute("usuario");
	
if ( !(per==null)){
	isEmpleado = per.getHabilitado();
	} else { isEmpleado = 0;} 
	

%>
</head>
<body>
<div class="fondo">
<jsp:include page="/BarraMenu.jsp" />
     <br>
     <br>
	<h1>Edite la pelicula</h1>
	<form class="addPelicula" action="ActualizarPelicula" method="post" >
	<label for="inputNombre" >Nombre de la pelicula</label>
	<input type="hidden" name="codigo" value="<%= peli.getCodigo() %>">
    <input id="inputNombre" name="nombre" class="form-control"  required type="text" value="<%= peli.getNombre() %>">
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
    <input id="inputSinopsis" name="sinopsis" class="form-control" placeholder="sinopsis" required type="text" value="<%= peli.getSinopsis() %>">
    
    <label for="inputDirector" >Director de la pelicula</label>
    <input id="inputDirector" name= "director" class="form-control" placeholder="director" required type="text" value="<%= peli.getDirector() %>">
    
    <label for="inputDuracion" >Duracion de la pelicula</label>
    <input id="inputDuracion" name="duracion" class="form-control" placeholder="duracion" required type="number" value="<%= peli.getDuracion() %>">
    
    <label for="inputPortada" >Portada de la pelicula</label>
    <input id="inputPortada" name="portada" class="form-control" placeholder="url de la portada" required type="text" value="<%= peli.getPortada() %>">
    
    <label for="inputEstreno" >Fecha de estreno</label>
    <% if (request.getAttribute("errorFormatoFecha")!=null) {%>
        	<div class="alert alert-danger">Formato de fecha invalido</div>
    <% }%>
    <input id="inputestreno" name="estreno" class="from-control" placeholder="fecha" required type="text" 
    	value="<%=peli.getFecha_estreno()%>">
    <br>
    <input type="hidden" name="bandera" value="cambio">
    <input type="hidden" name="pelianterior" value="<%=peli.getCodigo()%>">

    <button class="btn btn-lg btn-primary btn-block" type="submit" id="botonEditar">EDITAR</button>

	</form>
</div>	
</body>
</html>