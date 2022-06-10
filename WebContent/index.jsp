<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="entities.Persona" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
    <title>INICIO</title>
    <link href="style/css/styles.css" rel="stylesheet" />
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script src="Javascript/Script.js"></script>
</head>
<body id="page-top">
<div class="fondo">
	<jsp:include page="/BarraMenu.jsp" />
    <header class="masthead text-center text-white">
    	<div class="masthead-content">
        	<div class="container px-5">
            	<form class="form-signin" action="MostrarPeliculas" method="post">
                	<h1 class="masthead-heading mb-0">TODOS LOS ESTRENOS</h1>
                    <h2 class="masthead-subheading mb-0">EN UN MISMO LUGAR</h2>
                    <button class="botonEstreno"  >Ver estrenos</button>
                </form>
            </div>
        </div>
	</header>
    
</div>  
   <%if ( request.getAttribute("entradasCompradas")!= null){%>
   <script>
   Swal.fire({
		  icon: 'success',
		  title: 'Las entradas han sido reservadas!',
		  text: 'Las encontrara en su casilla de correo',
		})
   </script>
   <%} %>      
</body>
</html>
