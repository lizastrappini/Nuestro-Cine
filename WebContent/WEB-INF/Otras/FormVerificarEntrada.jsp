<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Entrada" %>
<%@page import="java.util.LinkedList" %>
<%@page import="logic.LogicPelicula" %>
<%@page import="entities.Persona" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="/Estilo.jsp" %>
	<title>Verificar Entrada</title>
	<%
	LinkedList<Entrada> entradas = (LinkedList<Entrada>)request.getAttribute("entradas");
	LogicPelicula lp = new LogicPelicula();

	%>
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
		<%for (Entrada ent : entradas){ %>
		<div id="borderDemo">
			<div id="info">
				<div id="titulo">
					<p id="titulo"><b><%=lp.buscarPorCodigo(ent.getCod_pelicula()).getNombre().toUpperCase()%></b></p>
				</div>
				<p id="numeroAsiento"><b>Asiento: <%=ent.getNumero_butaca() %></b></p>
				<p id="fechaFuncion"><b>fecha: <%=ent.getFecha_hora_funcion() %></b> </p>
				<p id="salaFuncion"><b>sala n°: <%=ent.getNro_sala() %></b> </p>
				<p id="precio"><b>precio: $<%=ent.getTotal() %></b> </p>
				<p id="idEntrada"><b> #<%=ent.getDni()%> </b></p>
				<p id="textDni">Presente este dni para retirar la entrada en boleteria</p>
			</div>
			<div>
				<div id="titulo2">
					<p id="ticketMovie">TICKET MOVIE</p>
					<p id="titulo2"><b><%=lp.buscarPorCodigo(ent.getCod_pelicula()).getNombre().toUpperCase()%></b></p>
				</div>
				<div id="izq">
					<p id="numeroAsiento"><b>Asiento: <%=ent.getNumero_butaca() %></b> </p>
					<p id="fechaFuncion"><b>fecha: <%=ent.getFecha_hora_funcion() %></b></p>
				</div>
				<div id="der">
					<p id="salaFuncion"><b>sala n°:<%=ent.getNro_sala() %></b> </p>
					<p id="precio"><b>precio: $<%=ent.getTotal() %></b></p>
				</div>
			</div>
		</div>
<%} %>
	<%} %>
</div>
</body>
</html>