<%@page import="java.util.*" %>
<%@page import="entities.Persona" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
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
<title>--EMPLEADOS--</title>
<%
Persona per = (Persona)request.getSession().getAttribute("usuario");

%>
</head>
<body>
	<h1>Seleccione la opcion que desea</h1>
	<form action="ControladorPeliculas" method="post">
	<button id="agregar" name="opc1" value="add" >Agregar Pelicula</button>
	<button id="editar" name="opc2" value="edit" >Editar Pelicula</button>
	<button id="borrar" name="opc3" value="delete" >Borrar Pelicula</button>
	</form>
</body>
</html>