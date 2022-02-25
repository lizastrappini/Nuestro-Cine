<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.time.*"%>
<%@page import="java.time.format.*"%>
<%@page import="entities.Persona" %>
<%@page import="entities.Genero" %>
<%@page import="logic.LogicGenero" %>
<%@page import="java.util.LinkedList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>---AGREGAR GENERO---</title>
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js" ></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="style/css/styles.css" rel="stylesheet" />
        <link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" >
		<link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&display=swap" rel="stylesheet">
		<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<%  
	LocalDateTime fecha = LocalDateTime.now();
	DateTimeFormatter isoFecha = DateTimeFormatter.ISO_LOCAL_DATE;
	String bandera = null;
	if ( !(request.getAttribute("bandera")==(null)) ){
	bandera = request.getAttribute("bandera").toString();}
	
	Integer isEmpleado = 0;
	Persona per = (Persona)request.getSession().getAttribute("usuario");
		
		if ( !(per==null)){
			isEmpleado = per.getHabilitado();
		} else {isEmpleado = 0;}	
		
	LogicGenero lg = new LogicGenero();
	LinkedList<Genero> listageneros = lg.getAll();
	
 
%>
</head>
<body>
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
    <br>
    <br>
	<h2>BORRAR GENERO</h2>
	<% if (   request.getAttribute("Encontrado")==null){ %>
	<form class="addCosto" action="BorrarGenero" method="post" >
    <select name="GeneroPelicula" required="required">		
		<% for (Genero g: listageneros){ %>
        	<option value="<%= g.getDescripcion() %>" selected="selected"><%= g.getDescripcion() %></option>
         <% } %>	
         </select>
         <br>
         <br>
    
    <button class="btn btn-lg btn-primary btn-block" type="submit" id="botonAgregar" >BORRAR</button>
    </form>
   <% }  if ( request.getAttribute("Encontrado") != null ) {%>
   		<form name="borrar" method="get" action="BorrarGenero">
		<input type="hidden" name="idGenero" value="<%=request.getAttribute("idGenero")%>">
		</form>
   		
		<script type="text/javascript">
		Swal.fire({
			  title: 'Estas seguro?',
			  text: "Las peliculas que pertenezcan al genero se borraran",
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: 'Si,borrar'
			  
			}).then((result) => {
			  if (result.isConfirmed) {
			    
			    borrar.submit()
			  }
			})
		</script>
		
		
   <%} %>
	</div>
	
</body>
</html>