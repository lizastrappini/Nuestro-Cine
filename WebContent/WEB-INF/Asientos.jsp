<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Persona" %>
<%@page import="entities.Sala" %>
<%@page import="entities.Pelicula" %>
<%@page import="entities.ButacaFuncion" %>
<%@page import="java.util.LinkedList"%>
<%@page import="java.time.LocalDateTime" %>
<%@page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="style/css/asientos.css" />
    <title>Seleccionar asientos</title>
    <%
    Pelicula peli = (Pelicula)request.getAttribute("peli");
    Double costo = Double.parseDouble(request.getAttribute("costo").toString());
    String fecha = request.getAttribute("fechafuncion").toString();
    LinkedList<ButacaFuncion> lf=(LinkedList<ButacaFuncion>)request.getAttribute("asientos");
    ButacaFuncion bf = (ButacaFuncion)request.getAttribute("butaca");
    %>
  </head>
  <body>
  	
    <input type="hidden" id="costo" name="costo" value="<%=Double.parseDouble(request.getAttribute("costo").toString())%>"> 
	<h1><%=peli.getNombre().toUpperCase()%></h1>
	<h2><%=fecha%></h2>
    <ul class="showcase">
      <li>
        <div class="seat"></div>
        <small>N/A</small>
      </li>

      <li>
        <div class="seat selected"></div>
        <small>Seleccionado</small>
      </li>

      <li>
        <div class="seat occupied"></div>
        <small>Ocupado</small>
      </li>
    </ul>
	 <input type="hidden" id="lista" name="lista" value="<%=lf%>" >
    <div class="container">
      <div class="screen"></div>
      <div class="row">
        <% for ( int i=1; i<49 ; i++){ 
//uso i-1 para empezar desde el indice 0 de la LinkedList (seria el asiento 1) sino se desconfiguraba el orden de los asientos
        	if(lf.get((i-1)).getEstado()==0){	%> 
       		 <div class="seat" >      		 
       		 </div>
 
       		 <%}else if(lf.get(i-1).getEstado()==1){ %>
       		 <div class="seat occupied" id="ocupado">     		
       		 </div>
       		 
       		 
        <%}if ( (i%8)== 0){%>
          </div>
          <div class="row">
        <% }} %>
      </div>
      </div>

    <p class="text">
      Seleccionaste <span id="count">0</span> asientos. Precio total $<span id="total">0</span>
    </p>
    <form name="entrada" action="AdquirirEntrada" method="post">
    
    <input type="hidden" id="preciototal" name="preciototal" >
     <input type="hidden" id="costo" name="costo" value="<%=costo%>">
    <input type="hidden" name="codigopeli" value="<%=bf.getCod_pelicula()%>">
    <input type="hidden" name="nrosala" value="<%=bf.getNro_sala()%>">
    <input type="hidden" name="fechahora" value="<%=bf.getFecha_hora_funcion()%>">
    <input type="hidden" id="indexes" name="indexes" >
    <button type="submit"class="buttonClass"> Comprar </button>
    </form>
    
    
    <script src="Javascript/asiento.js"></script>
  </body>
</html>