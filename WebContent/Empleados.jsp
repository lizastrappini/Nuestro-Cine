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
	<script src="style/script.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<title>--EMPLEADOS--</title>

<%
	String borrada = "";

	if ( !(request.getAttribute("borrada")==(null)) ){
	borrada = request.getAttribute("borrada").toString();
	} 	

	String modificada = "";

	if ( !(request.getAttribute("modificada")==(null)) ){
 	modificada = request.getAttribute("modificada").toString();
	} 
	
	String cargada = "";

	if ( !(request.getAttribute("cargada")==(null)) ){
 	cargada = request.getAttribute("cargada").toString();
	} 
	
	String nocambio = "";

	if ( !(request.getAttribute("nocambio")==(null)) ){
 	nocambio = request.getAttribute("nocambio").toString();
	} 
	
	Persona per = (Persona)request.getSession().getAttribute("usuario");

%>
</head>
<body>
<div class="fondo">
	
<% if (!(request.getAttribute("bandera1")==(null)) && borrada.equals("borrada")){  %>
		<script>
		Window.alert('Ejemplo basico de Sweet Alert 2');
		</script>
		
	<%} %>
<% if (!(request.getAttribute("bandera2")==(null)) && modificada.equals("modificada")){  %>
		<script >
		Window.alert("Pelicula modificada con exito!")
		</script>
		
	<%} %>
<% if (!(request.getAttribute("bandera3")==(null)) && cargada.equals("cargada")){  %>
		<script >
		Window.alert("Pelicula cargada con exito!")
		</script>
	<%} %>
<% if (!(request.getAttribute("bandera4")==(null)) && nocambio.equals("nocambio")){  %>
		<script >
		Window.alert("No hubo cambios en la pelicula")
		</script>
	<%} %>	

<!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark navbar-custom fixed-top">
            <div class="container px-5">
                <a class="navbar-brand" href="index.jsp">NUESTRO CINE</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto">	
                   
                    	<li class="nav-item"><a class="nav-link" href="Peliculas.jsp">Cartelera</a></li>
                        
                        <% if ( request.getSession().getAttribute("usuario")==null ) {%>
                        
                        <li class="nav-item"><a class="nav-link" href="SignUp.html">Registrarse</a></li>
                        <li class="nav-item"><a class="nav-link" href="SignIn.html" id="signin">Iniciar sesion</a></li>
                        <%}else {%> 
                        <li class="nav-item"><a class="nav-link">HOLA, <%=per.getNombre().toUpperCase()%>!</a></li>
                        <li class="nav-item"><a class="nav-link" id="signout" href="SignOut" >Cerrar sesion</a></li>
                        
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
	<h1>Seccion funciones</h1>
	<form action="ControladorFunciones" method="post">
	<button class="buttonFiltros" id="agregar" name="opc1" value="add" >Agregar funcion</button>
	<button class="buttonFiltros" id="editar" name="opc2" value="edit" >Editar funcion</button>
	<button class="buttonFiltros" id="borrar" name="opc3" value="delete" >Borrar funcion</button>
	</form>
	<br>
	<h1>Seccion salas</h1>
	<form action="ControladorSalas" method="post">
	<button class="buttonFiltros" id="agregar" name="opc1" value="add" >Agregar sala</button>
	<button class="buttonFiltros" id="editar" name="opc2" value="edit" >Editar sala</button>
	<button class="buttonFiltros" id="borrar" name="opc3" value="delete" >Borrar sala</button>
	</form>
	</div>
	

</div>	
</body>
</html>