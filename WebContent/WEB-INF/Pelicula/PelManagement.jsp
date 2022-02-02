<%@page import="entities.Pelicula"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.time.LocalDate" %>
<%@page import="java.time.Month" %>
<%@page import="java.util.Locale" %>
<%@page import="entities.Persona" %>
<%@page import="java.time.format.TextStyle" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>---CINE---</title>
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <link href="style/css/styles.css" rel="stylesheet" />
        <script src="Javascript/SweetAlert.js"></script>
		<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
		<script src="Javascript/Script.js"></script>
		 <% 
		 
		Month mes = LocalDate.now().getMonth(); //obtengo el mes
		String nombre = mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES")).toUpperCase();  // convierto a mayusculas
		
		LinkedList<Pelicula> lp=(LinkedList<Pelicula>)request.getAttribute("listapeliculas");
		Integer isEmpleado = 0;
		Persona per = (Persona)request.getSession().getAttribute("usuario");
		
		if ( !(per==null)){
			isEmpleado = per.getHabilitado();
		} else {isEmpleado = 0;}
		
		%>
   </head>

<body>

<div class="fondo" >		
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
                        
                        <li class="nav-item"><a class="nav-link" href="SignUp.html">Registrarse</a></li>
                        <li class="nav-item"><a class="nav-link" href="SignIn.html" id="signin">Iniciar sesion</a></li>
                        <%}else {%> 
                        <li class="nav-item"><a class="nav-link">HOLA, <%=per.getNombre().toUpperCase()%>!</a></li>
                        <li class="nav-item"><a class="nav-link"  onclick="cerrarSesion()">Cerrar sesion</a></li>
                        <li class="nav-item"><a class="nav-link" id="" href="MiCuenta.jsp">Mi cuenta</a></li>
                        
                   		<%} %>	
                    </ul>
                     
                </div>
            </div>
        </nav>
        <div></div>
<div></div>
<div></div>
        
<br>
<br>
<br>
<!-- titulo si seleccionamos estrenos -->

<%if( !(request.getAttribute("estrenos")==null) ){%> 

	<% if ( lp==null || lp.isEmpty()){ %>
	<script type="text/javascript">
	Swal.fire({
		  imageUrl: 'https://images.emojiterra.com/twitter/v13.1/512px/2639.png',
		  imageHeight: 100,
		  text: 'No hay estrenos este mes',
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
		setTimeout( function() { window.location.href = "index.jsp"; }, 2000 );
	</script>
	
	<%} else {%>
	<h1 class="titulo_estrenos"> ESTRENOS DEL MES DE <%=nombre %></h1>
	
	<% }} %>

<% for (Pelicula pel : lp){ %>
	  <!-- Contenido peliculas-->
        <div class="pelicula">
          					<img class="infopelicula" id="fotopelicula" src="<%=pel.getPortada()%>" alt="Not Found"  />
                            <h2 class="infopelicula" id="nombrepelicula"><%=pel.getNombre() %></h2>
                            <p class="infopelicula" id="sinopsis"><%=pel.getSinopsis() %></p>
                            <p class="infopelicula"> <b>Director :</b> <%=pel.getDirector() %></p>
                            <p class="infopelicula"> <b>Calificacion : </b><%=pel.getCalificacion() %></p>
                            <p class="infopelicula"> <b>Duracion : </b><%=pel.getDuracion() %></p> 
                            <form class="infopelicula" action="Funciones" method="post">
                            <input type="hidden" name="codigo" value="<%= pel.getCodigo() %>">
                            <button class="buttonClass" id="">  Comprar   </button>
                            </form>
                            
                            
        </div>
        
	<%} %>
	<a class="boton_volver" href="index.jsp">VOLVER </a>
	<% if (lp.isEmpty() && request.getAttribute("estrenos")==null){ %>
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
		setTimeout( function() { window.location.href = "Peliculas.jsp"; }, 2000 );
		</script>

	<%} %>
<br>
<br>
</div>	


</body>
</html>