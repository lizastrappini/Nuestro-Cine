<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="/Estilo.jsp" %>
	<title>Verificar Entrada</title>
</head>
<body>
<div class="fondo">
	<jsp:include page="/BarraMenu.jsp" />
    <br>
    <br>
    <% if (request.getAttribute("Noencontrada")!=null) {%>
    	<div class="alert alert-warning">No se encontraron entradas para ese documento</div>
    <%} %>
	<h2>INGRESE NUMERO DE DOCUMENTO</h2>
	<form class="verEntrada" action="BuscarEntrada" method="get" >
		<label for="inputDocumento" >Documento</label>
    	<input id="inputDocumento" name="documento" class="form-control" placeholder="documento" required type="text">	
    	<br>
    	<button class="btn btn-lg btn-primary btn-block" type="submit" id="botonBuscar" >BUSCAR</button>
    </form>
    
    <% if (request.getAttribute("encontrada")!=null) {%>
		<div class="alert alert-success">Existen estas entradas con ese numero de documento asignado</div>
	<%} %>
</div>
</body>
</html>