<%@page import="java.util.*" %>
<%@page import="entities.Persona" %>
<%@page import="entities.Pelicula" %>
<%@page import="entities.CostoEntrada" %>
<%@page import="logic.LogicPelicula" %>
<%@page import="logic.LogicCostoEntrada" %>
<%@page import="entities.ButacaFuncion" %>
<%@page import="java.time.LocalDateTime" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>

        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
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
		} else {isEmpleado = 0;}
		LinkedList<ButacaFuncion> listaButacas = (LinkedList<ButacaFuncion>)request.getAttribute("listaButacas");
		LogicPelicula lp = new LogicPelicula();
		Pelicula p = lp.buscarPorCodigo(listaButacas.get(0).getCod_pelicula());
		LogicCostoEntrada lce = new LogicCostoEntrada();
		CostoEntrada ce = lce.costoActual();
		System.out.println(ce);
		String indexes = request.getAttribute("indexes").toString();
		LocalDateTime fechahora = listaButacas.get(0).getFecha_hora_funcion();
		Integer nrosala = listaButacas.get(0).getNro_sala();
		Integer codigo = listaButacas.get(0).getCod_pelicula();
		
		%>
    </head>
    <body id="page-top">
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
<%for (ButacaFuncion lb : listaButacas){ %>
	<div id="borderDemo">
		<div id="info">
		<div id="titulo">
			<p id="titulo"><b><%=p.getNombre().toUpperCase() %></b></p>
		</div>
		<p id="numeroAsiento"><b>Asiento: <%=lb.getNumero() %></b></p>
		<p id="fechaFuncion"><b>fecha: <%=lb.getFecha_hora_funcion() %></b> </p>
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
		<p id="fechaFuncion"><b>fecha: <%=lb.getFecha_hora_funcion() %></b></p>
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
