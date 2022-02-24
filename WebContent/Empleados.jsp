<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="entities.Persona" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="/Estilo.jsp" %>
	<title>--EMPLEADOS--</title>
</head>
<body>
<div class="fondo">	
	<jsp:include page="/BarraMenu.jsp" />
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
		<br>
		<h1>Otras Opciones</h1>
		<form action="ControladorOtras" method="post">
			<button class="buttonFiltros" id="agregar" name="opc1" value="add" >Nuevo Costo de Entrada</button>
			<button class="buttonFiltros" id="verificar" name="opc2" value="veri" >Verificar Entrada</button>
		</form>
	</div>
</div>	
</body>
</html>