<%@page import="java.util.*" %>
<%@page import="entities.Persona" %>
<%@page import="entities.Pelicula" %>
<%@page import="entities.CostoEntrada" %>
<%@page import="logic.LogicPelicula" %>
<%@page import="logic.LogicCostoEntrada" %>
<%@page import="entities.ButacaFuncion" %>
<%@page import="java.time.LocalDateTime" %>
<%@page import="java.time.LocalDateTime" %>
<%@page import="java.time.*" %>
<%@page import="java.time.format.DateTimeFormatter" %>
<%@page import="java.time.format.FormatStyle" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>ENTRADAS</title>
<link href="style/css/styles.css" rel="stylesheet" />
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="Javascript/Script.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" >
<link href="https://fonts.googleapis.com/css2?family=ABeeZee&family=Abril+Fatface&family=Righteous&display=swap" rel="stylesheet">
		<%
		Integer isEmpleado = 0;
		Persona per = (Persona)request.getSession().getAttribute("usuario");
	
		if ( !(per==null)){
			isEmpleado = per.getHabilitado();
			} else { isEmpleado = 0;} 
		LinkedList<ButacaFuncion> listaButacas = (LinkedList<ButacaFuncion>)request.getAttribute("listaButacas");
		LogicPelicula lp = new LogicPelicula();
		Pelicula p = lp.buscarPorCodigo(listaButacas.get(0).getCod_pelicula());
		LogicCostoEntrada lce = new LogicCostoEntrada();
		CostoEntrada ce = lce.costoActual();
		
		String indexes = request.getAttribute("indexes").toString();
		LocalDateTime fechahora = listaButacas.get(0).getFecha_hora_funcion();
		Integer nrosala = listaButacas.get(0).getNro_sala();
		Integer codigo = listaButacas.get(0).getCod_pelicula();
		
%>
</head>
<body id="page-top">
<div class="fondo">
<jsp:include page="/BarraMenu.jsp" />
<%for (ButacaFuncion lb : listaButacas){ 
	DateTimeFormatter FORMATTER1 = DateTimeFormatter.ofPattern("dd/MM/yyyy ','hh:mm a");
    LocalDateTime fechahorafuncion = lb.getFecha_hora_funcion();
    String fechayhora = FORMATTER1.format(fechahorafuncion);
%>
	<div id="borderDemo">
		<div id="info">
		<div id="titulo">
			<p id="titulo"><b><%=p.getNombre().toUpperCase() %></b></p>
		</div>
		<p id="numeroAsiento"><b>Asiento: <%=lb.getNumero() %></b></p>
		<p id="fechaFuncion"><b>fecha y hora: <%=fechayhora %></b> </p>
		<p id="salaFuncion"><b>sala n°: <%=lb.getNro_sala() %></b> </p>
		<p id="precio"><b>precio: $<%=ce.getCosto() %></b> </p>
		<p id="idEntrada"><b> #<%=per.getDni()%> </b></p>
		<p id="textDni">Presente este dni para retirar la entrada en boleteria</p>
		</div>
		<div>
			<div id="titulo2">
			<p id="ticketMovie">TICKET MOVIE</p>
			<p id="titulo2"><b><%=p.getNombre().toUpperCase() %></b></p>
		</div>
		<div id="izq">
		<p id="numeroAsiento"><b>Asiento: <%=lb.getNumero() %></b> </p>
		<p id="fechaFuncion"><b>fecha y hora: <%=fechayhora %></b> </p>
		</div>
		<div id="der">
		<p id="salaFuncion"><b>sala n°:<%=lb.getNro_sala() %></b> </p>
		<p id="precio"><b>precio: $<%=ce.getCosto() %></b></p>
		</div>
	</div></div>
<%} %>
<form action="ComprarEntrada" method="post">
<input type="hidden" name="listaButacas" value="<%=indexes%>">
<input type="hidden" name="fechahora" value="<%=fechahora%>">
<input type="hidden" name="numeroSala" value="<%=nrosala%>">
<input type="hidden" name="codigo" value="<%=codigo%>">
<input type="hidden" name="precio" value="<%=ce.getCosto()%>">
<input type="hidden" name="dni" value="<%=per.getDni()%>">
<br>
<br>
<input class="comprarEntrada" type="submit" value="Comprar entradas" >
</form>
</div>
</body>
</html>
