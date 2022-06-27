<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Funcion"%>
<%@page import="entities.Pelicula"%>
<%@page import="entities.Persona"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.time.LocalDate" %>
<%@page import="java.time.Month" %>
<%@page import="java.time.format.TextStyle" %>
<%@page import="java.util.Locale" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="/Estilo.jsp" %>
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<title>Funciones</title>
<% 
	LinkedList<Funcion> lf=(LinkedList<Funcion>)request.getAttribute("listafunciones");
	Pelicula p  = (Pelicula)request.getAttribute("pel");
	Month mes = LocalDate.now().getMonth(); //obtengo el mes
	String nombre = mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES")).toUpperCase();
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
	  <!-- Content section 1-->
        <div class="pelicula">
    						<form action="MostrarAsientos" method="get">
                            <p class="infopelicula" id="fechahora" ><b>Fecha y hora de la funcion:</b> <%=fun.getFecha_hora() %></p>
                            <input type="hidden" name="fechahora" value="<%=fun.getFecha_hora() %>">
                            <p class="infopelicula" id="numerosala"><b>Sala n°:</b>  <%=fun.getNumero_sala()%></p>
                            <input type="hidden" name="nrosala" value="<%= fun.getNumero_sala() %>">
                            <input type="hidden" name="codigopeli" value="<%= p.getCodigo() %>">
                            <button class="button" id="sacarentrada">  Sacar entrada   </button><br>
                            
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
<a class="boton_volver" href="Peliculas.html">VOLVER </a>
</div>
</body>
</html>
