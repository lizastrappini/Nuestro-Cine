<%@page import="java.util.*" %>
<%@page import="entities.Persona" %>
<%@page import="entities.Genero" %>
<%@page import="logic.LogicGenero" %>
<%@page import="entities.Calificacion" %>
<%@page import="logic.LogicCalificacion" %>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>---PELICULAS---</title>
        <link href="style/css/styles.css" rel="stylesheet" />
		<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" >
		<link href="https://fonts.googleapis.com/css2?family=ABeeZee&family=Abril+Fatface&family=Righteous&display=swap" rel="stylesheet">
		 <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="style/css/navbar.css" rel="stylesheet">
    <%
		LogicGenero lg = new LogicGenero();
		LinkedList<Genero> listaGeneros = lg.getAll();
		
		LogicCalificacion lc = new LogicCalificacion();
		LinkedList<Calificacion> listaCalif = lc.getAll();
		//LinkedList<Genero> gen=(LinkedList<Genero>)request.getAttribute("peliculas");
	%>
</head>
<body>

<div id="page-top" class="fondo">
	<header>
    	<jsp:include page="/BarraMenu.jsp" />   
	</header>
		
		<div class="filtroNombre">
		<h1>Nombre</h1>
		<form action="MostrarPeliculas" method="get">
		<input class="elegirNombre" name="nombre" type=text>
		<input class="buscar" type="submit" value="buscar">
		</form>
		</div>
		
		<form method="get" action="MostrarPeliculas">	
		<div class="filtroGenero">
		<h1>Buscar por genero</h1>
		<select class="elegirGenero" name="GeneroPelicula" required="required">		
		<% for (Genero g: listaGeneros){ %>
        	<option value="<%= g.getId() %>" selected="selected"><%= g.getDescripcion() %></option>
        <% } %>	
        <option value="todas" >Ver todas</option>	
        </select>
        <input class="buscar" type="submit" value="buscar">
		</div>
		</form>
		
		<form method="get" action="MostrarPeliculas">	
		<div class="filtroEdad">
		<h1>Buscar por edad</h1>
		<select class="elegirEdad" name="edadPelicula" required="required">		
		<% for (Calificacion c: listaCalif){ %>
        	<option value="<%= c.getCodigo_calificacion() %>" selected="selected"><%= c.getDescripcion() %></option>
        <% } %>		
         </select>
         <input class="buscar" type="submit" value="buscar">
		</div>
		</form>		
		</div>		
		<div style="clear:both"></div>
		
		
		<%if (!(request.getAttribute("noEncontrada")==(null))){  %>
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
    <%}%>
</body>
</html>