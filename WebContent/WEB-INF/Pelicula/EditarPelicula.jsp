<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.time.*"%>
<%@page import="java.time.format.*"%>
<%@page import="entities.Pelicula"%>
<%@page import="logic.LogicPelicula"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entities.Persona"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>---EDIT PELICULAS---</title>
        <link href="style/css/styles.css" rel="stylesheet" />
		<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
		<script src="Javascript/Script.js"></script>
<%  
	

	 LinkedList<Pelicula> lp=(LinkedList<Pelicula>)request.getAttribute("peliculas");
	
	 Integer isEmpleado = 0;
	Persona per = (Persona)request.getSession().getAttribute("usuario");
		
	if ( !(per==null)){
		isEmpleado = per.getHabilitado();
		} else { isEmpleado = 0;}
	 
    %>
</head>
<body>
<%if ( per != (null) && isEmpleado==1){ %>
<div class="fondo">
<jsp:include page="/BarraMenu.jsp" />
	<%if ( (request.getAttribute("encontrada")==(null))) { %>
	<br>
	<br>
	<% if (request.getAttribute("editada")!=null) {%>
        <div class="alert alert-success">¡Pelicula editada con exito!</div>
    <% }%>
    <% if (request.getAttribute("nocambio")!=null) {%>
        <div class="alert alert-warning">No se han detectado cambios</div>
    <% }%>
	<h2>Ingrese nombre de la pelicula</h2>
	<form class="addPelicula" action="BuscarPelicula" method="post" >
    <input id="inputNombre" name="nombre" class="form-control" placeholder="nombre de la pelicula" required type="text">
    <br>
    <button class="btn btn-lg btn-primary btn-block" >BUSCAR</button>
    </form>
	
	<%} if (!(request.getAttribute("encontrada")==(null)) ){  %>
		<br>
		<br>
		
		
			<% for (Pelicula pel : lp){ %>
			
			<div class="pelicula">
							<div class="infopelicula">
							<img class="infopelicula" id="fotopelicula" src="<%=pel.getPortada()%>"  />
							<h2 class="infopelicula" id="nombrepelicula" ><%= pel.getNombre() %></h2>
                            <p class="infopelicula" id="sinopsis"><%= pel.getSinopsis() %></p>
                            <p class="infopelicula"> <b>Director :</b> <%= pel.getDirector() %></p>
                            <p class="infopelicula"> <b>Calificacion :</b> <%= pel.getCodigo_calificacion() %></p>
                            <p class="infopelicula"> <b>Duracion :</b> <%= pel.getDuracion() %></p>
                            <form action="ActualizarPelicula" method="post">
                            <input type="hidden" name="codigo" value="<%= pel.getCodigo() %>">
                            <br>
                            <br>
                            <button class="buttonClass">Editar</button>
                            </form>
                            </div>
              </div>
              
	<%}}
	else if (!(request.getAttribute("noencontrada")==(null))){  %>
	<script type="text/javascript">
	Swal.fire({
		  imageUrl: 'https://images.emojiterra.com/twitter/v13.1/512px/2639.png',
		  imageHeight: 100,
		  text: 'No hay peliculas que coincidan con la busqueda',
		  timer: 2000,
		  timerProgressBar: true,
		  allowOutsideClick: false,
		  didOpen: () => {
			    Swal.showLoading()
			    const b = Swal.getHtmlContainer().querySelector('b')
			    timerInterval = setInterval(() => {
			      b.textContent = Swal.getTimerLeft()
			    }, 100)
			  },
		})
		setTimeout( function() { window.location.href = "Empleados.jsp"; }, 2000 );
		</script>
    <%} } else {%>
    <jsp:forward page="index.jsp"/>
    <%} %>
</div>
</body>
</html>