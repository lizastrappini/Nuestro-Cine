<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Persona" %>
<%@page import="entities.Sala" %>
<%@page import="entities.Pelicula" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="style/css/asientos.css" />
    <title>Movie Seat Booking</title>
    <%
    Pelicula peli = (Pelicula)request.getAttribute("peli");
    Double costo = Double.parseDouble(request.getAttribute("costo").toString());
    String fecha = request.getAttribute("fechafuncion").toString();
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

    <div class="container">
      <div class="screen"></div>
      <div class="row">
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
      </div>
      <div class="row">
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat "></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
      </div>

      <div class="row">
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat "></div>
        <div class="seat "></div>
      </div>

      <div class="row">
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
      </div>

      <div class="row">
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat "></div>
        <div class="seat "></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
      </div>

      <div class="row">
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
      </div>
    </div>

    <p class="text">
      Seleccionaste <span id="count">0</span> asientos. Precio total $<span id="total">0</span>
    </p>
    <form name="entrada" action="AdquirirEntrada" method="post">
    <input type="hidden" id="total2" name="total2" >
    <input type="hidden" id="count2" name="count2" >
    <input type="hidden" id="indexes" name="indexes" >
    <button type="submit"class="buttonClass"> Comprar </button>
    </form>
    <script src="Javascript/asiento.js"></script>
  </body>
</html>