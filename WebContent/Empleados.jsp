<%@page import="java.util.*" %>
<%@page import="entities.Persona" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
	<meta charset="UTF-8">
	<link href="style/css/styles.css" rel="stylesheet" />
	<link rel="shortcut icon" href="https://img.icons8.com/ios-glyphs/30/ffffff/cinema---v1.png" />
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script src="Javascript/Script.js"></script>

	<title>--EMPLEADOS--</title>

<%

	Persona per = (Persona)request.getSession().getAttribute("usuario");

%>
</head>
<body>
<div class="fondo">
<%
if ( per != (null) ){
%>	


<!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark navbar-custom fixed-top">
            <div class="container px-5">
                <a class="navbar-brand" href="index.jsp">NUESTRO CINE</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto">	
                   
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


	<div class="opciones">
	<h1>Seccion peliculas</h1>
	<form action="ControladorPeliculas" method="post">
	<button class="buttonFiltros" id="agregar" name="opc1" value="add" >Agregar Pelicula</button>
	<button class="buttonFiltros" id="editar" name="opc2" value="edit" >Editar Pelicula</button>
	<button class="buttonFiltros" id="borrar" name="opc3" value="delete" >Borrar Pelicula</button>
	</form>
	<br>
	<h1>Seccion Funciones</h1>
	<form action="ControladorFunciones" method="post">
	<button class="buttonFiltros" id="agregar" name="opc1" value="add" >Agregar Funcion</button>
	<button class="buttonFiltros" id="editar" name="opc2" value="edit" >Editar Funcion</button>
	<button class="buttonFiltros" id="borrar" name="opc3" value="delete" >Borrar Funcion</button>
	</form>
	<br>
	<h1>Seccion Salas</h1>
	<form action="ControladorSalas" method="post">
	<button class="buttonFiltros" id="agregar" name="opc1" value="add" >Agregar Sala</button>
	<button class="buttonFiltros" id="editar" name="opc2" value="edit" >Editar Sala</button>
	<button class="buttonFiltros" id="borrar" name="opc3" value="delete" >Borrar Sala</button>
	</form>
	<br>
	<h1>Seccion Costo Entrada</h1>
	<form action="ControladorCostos" method="post">
	<button class="buttonFiltros" id="agregar" name="opc1" value="add" >Agregar Costo</button>
	<button class="buttonFiltros" id="editar" name="opc2" value="edit" >Editar Costo</button>
	<button class="buttonFiltros" id="borrar" name="opc3" value="delete" >Borrar Costo</button>
	</form>
	<br>
	<h1>Seccion Calificaciones</h1>
	<form action="ControladorCalificaciones" method="post">
	<button class="buttonFiltros" id="agregar" name="opc1" value="add" >Agregar Calificacion</button>
	<button class="buttonFiltros" id="editar" name="opc2" value="edit" >Editar Calificacion</button>
	<button class="buttonFiltros" id="borrar" name="opc3" value="delete" >Borrar Calificacion</button>
	</form>
	<br>
	<h1>Seccion Genero</h1>
	<form action="ControladorGeneros" method="post">
	<button class="buttonFiltros" id="agregar" name="opc1" value="add" >Agregar Genero</button>
	<button class="buttonFiltros" id="editar" name="opc2" value="edit" >Editar Genero</button>
	<button class="buttonFiltros" id="borrar" name="opc3" value="delete" >Borrar Genero</button>
	</form>
	</div>
</div>	
<% if (!(request.getAttribute("borrada")==(null)) ){  %>
		<script>
		Swal.fire({
			  icon: 'success',
			  title: 'Pelicula borrada',
			})
		</script>
		
	<%} %>
<% if (!(request.getAttribute("modificada")==(null)) ){  %>
		<script >
		Swal.fire({
			  icon: 'success',
			  title: 'Pelicula modificada',
			})
		</script>
		
	<%} %>
<% if (!(request.getAttribute("cargada")==(null)) ){  %>
		<script >
		Swal.fire({
			  icon: 'success',
			  title: 'Pelicula cargada',
			})
		</script>
	<%} %>
<% if (!(request.getAttribute("nocambio")==(null)) ){  %>
		<script >
		Swal.fire({
			  icon: 'warning',
			  title: 'Pelicula duplicada',
			  footer: 'No hubo cambios'
			})
		</script>
	<%} %>
	<% if (!(request.getAttribute("noAgregado")==(null)) ){  %>
	<script >
	Swal.fire({
		  icon: 'warning',
		  title: 'Genero duplicado',
		  footer: 'No hubo cambios'
		})
	</script> %>
	<%} if (!(request.getAttribute("Agregado")==(null)) ){  %>
	<script >
	Swal.fire({
		  icon: 'success',
		  title: 'Genero cargado',
		})
	</script> 
	<%} %>
	<% if (!(request.getAttribute("Cambiado")==(null)) ){  %>
	<script >
	Swal.fire({
		  icon: 'success',
		  title: 'Genero cambiado',
		})
	</script> 
	<%} } else {%>
	<jsp:forward page="index.jsp"/>
	<%} %>	
</body>
</html>