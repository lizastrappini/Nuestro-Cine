<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Pelicula"%>
<%@page import="logic.LogicPelicula"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entities.Persona" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>---EDIT PELICULAS---</title>
        <link href="style/css/styles.css" rel="stylesheet" />
		<script src="Javascript/Script.js"></script>
		<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
		
<title>Borrar Pelicula</title>
<%

LinkedList<Pelicula> lp=(LinkedList<Pelicula>)request.getAttribute("peliculas");
Integer isEmpleado = 0;
Persona per = (Persona)request.getSession().getAttribute("usuario");
			
if ( !(per==null)){
	isEmpleado = per.getHabilitado();
	} else {isEmpleado = 0;}	 
	 
%>
</head>
<body>
<%if ( per!= (null) && isEmpleado==1){ %>
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
                        <li class="nav-item"><a class="nav-link"  onclick="cerrarSesion()">Cerrar sesion</a></li>
                        <li class="nav-item"><a class="nav-link" id="" href="MiCuenta.jsp">Mi cuenta</a></li>
                        
                   		<%} %>	
                    </ul>
                     
                </div>
            </div>
        </nav>
	
	<%if ( request.getAttribute("encontrada")==(null) ) { %>
		<br>
		<br>
		<h2>Ingrese nombre de la pelicula</h2>
		<form class="addPelicula" action="BuscarPelicula" method="get" >
		<label for="inputNombre" >Nombre de la pelicula</label>
    	<input id="inputNombre" name="nombre" class="form-control" placeholder="nombre de la pelicula" required type="text">
    	<br>
   		 <button class="btn btn-lg btn-primary btn-block" type="submit" >BUSCAR</button>
    	</form>
    <%} %>
  
    <%if ( !(request.getAttribute("encontrada")==(null))) {%>
    	<br>
		<br>
    	<br>
		
			<% for (Pelicula pel : lp){ %>
			
			<div class="pelicula">
							<div class="infopelicula">
							<img class="infopelicula" id="fotopelicula" src="<%=pel.getPortada()%>"  />
							<p class="nombrepelicula" id="nombrepelicula" ><%= pel.getNombre() %></p>
                            <p class="sinopsis" id="sinopsis"><%= pel.getSinopsis() %></p>
                            <p class="infopelicula"> <b>Director :</b> <%= pel.getDirector() %></p>
                            <p class="infopelicula"> <b>Calificacion :</b> <%= pel.getCodigo_calificacion() %></p>
                            <p class="infopelicula"> <b>Duracion :</b> <%= pel.getDuracion() %></p>
                            <form action="BorraPelicula" method="get" name="form">
                            <input type="hidden" name="codigo" value="<%=pel.getCodigo() %>">
                            <br>
                            <button id="botonBorrar" class="buttonBorrar">Borrar</button>
                            </form>
                            </div>
              </div>
              
              <%}} 
    else if (!(request.getAttribute("noencontrada")==(null))){ %>
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