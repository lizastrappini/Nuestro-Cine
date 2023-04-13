<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Funcion"%>
<%@page import="logic.LogicSala"%>
<%@page import="logic.LogicEntrada"%>
<%@page import="entities.Sala"%>
<%@page import="entities.Pelicula"%>
<%@page import="entities.Persona"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.time.LocalDate" %>
<%@page import="java.time.Month" %>
<%@page import="java.time.format.TextStyle" %>
<%@page import="java.util.Locale" %>
<%@page import="java.time.LocalDateTime" %>
<%@page import="java.time.*" %>
<%@page import="java.time.format.DateTimeFormatter" %>
<%@page import="java.time.format.FormatStyle" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="/Estilo.jsp" %>
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Alfa+Slab+One&family=Lato&display=swap" rel="stylesheet">
	<title>Funciones</title>
<% 
	Persona per = (Persona)request.getSession().getAttribute("usuario");
	LinkedList<Funcion> lf=(LinkedList<Funcion>)request.getAttribute("listafunciones");
	Pelicula p  = (Pelicula)request.getAttribute("pel");
	Month mes = LocalDate.now().getMonth(); //obtengo el mes
	String nombre = mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES")).toUpperCase();
	LogicEntrada le = new LogicEntrada();
%>
</head>
<body>
<div class="fondo" >
	<jsp:include page="/BarraMenu.jsp" />
<br>
<br>
<br>
<br>
<div class="contenedor">
	<% for (Funcion fun : lf){ %>	  
	   <%
       LogicSala ls = new LogicSala();
       Sala s = new Sala();
       s.setNumero(fun.getNumero_sala());
       s = ls.buscar(s);
       int cantidad = le.contarEntradasPorFuncion(fun);
       
       %>
        <div class="pelicula">
        <br>
        <% 
        DateTimeFormatter FORMATTER1 = DateTimeFormatter.ofPattern("EEEE,dd 'de' MMMM ");
        DateTimeFormatter FORMATTER2 = DateTimeFormatter.ofPattern("h:mm a");
        LocalDateTime fechahora = fun.getFecha_hora();
        String fecha = FORMATTER1.format(fechahora);
        String hora = FORMATTER2.format(fechahora); %>
    						<form action="MostrarAsientos" method="get">
                            <p class="infopelicula" id="fecha" ><b>Fecha de la funcion:</b> <%=fecha %></p>
                            <p class="infopelicula" id="hora" ><b>Hora de la funcion:</b> <%=hora %></p>
                            <input type="hidden" name="fechahora" value="<%=fun.getFecha_hora() %>">
                            <p class="infopelicula" id="numerosala"><b>Sala n°:</b>  <%=fun.getNumero_sala()%></p>                           
                            <div class="descsala"><p class="descsala"><%=s.getDescripcion().toUpperCase() %></p></div>
                            <input type="hidden" name="nrosala" value="<%= fun.getNumero_sala() %>">
                            <input type="hidden" name="codigopeli" value="<%= p.getCodigo() %>">
                            <% if ( !(per==null) && cantidad <48 ){%>
                            <button class="buttonClass" id="">  Sacar entrada   </button><br>
                            <%} else{  %>
                            <button class="buttonClassDisabled" id="" disabled>  Sacar entrada   </button>
                            <%
                            if (cantidad==48){%>
                            <p class="entradasAgotadas">¡Entradas agotadas!</p>
                            <% }  %>
                            
                            <%} %>
                            </form>
        </div>
        
	<%} %>
</div>
	<% if (lf.isEmpty()){%>
	<script type="text/javascript">
	Swal.fire({
		  imageUrl: 'https://images.emojiterra.com/twitter/v13.1/512px/2639.png',
		  imageHeight: 100,
		  text: 'No hay funciones para la pelicula elegida',
		  timer: 2000,
		  timerProgressBar: true,
		  allowOutsideClick: false,
		  didOpen: () => {
			    Swal.showLoading()
			    const b = Swal.getHtmlContainer().querySelector('b')
			    timerInterval = setInterval(() => {
			      b.textContent = Swal.getTimerLeft()
			    }, 100)
			  },
		})
		setTimeout( function() { window.location.href = "Peliculas.jsp"; }, 2000 );
		</script>
	<%} %>
<a class="boton_volver" href="Peliculas.jsp">VOLVER </a>
</div>
</body>
</html>
