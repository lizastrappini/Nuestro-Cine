<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="java.sql.*" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="entities.Persona" %>
<%@page import="data.DbConnector" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
    <title>INICIO</title>
    <link href="style/css/styles.css" rel="stylesheet" />
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" />
	
</head>
<body >
<div class="fondo">
	<jsp:include page="/BarraMenu.jsp" />	
	<div class="Inicio">	
	
	
            	<form class="form-signin" action="MostrarPeliculas" method="post">
                	<h1 class="textoInicio">TODOS LOS ESTRENOS</h1>
                    <h2 class="textoInicio">EN UN MISMO LUGAR</h2>
                    <button class="botonEstreno" >Ver estrenos</button>
                </form>
            </div>
            
            <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <div id="carouselExampleControls" class="carousel slide carousel-fade" data-ride="carousel" data-interval="2500" >
                        <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img class="d-block w-100" src="style/assets/img/light.jpg" alt="Lightyear" width="300px" height="200px">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="style/assets/img/cars.jpg" alt="Cars"width="300px" height="200px">
                        </div>
                        <div class="carousel-item">
                          <img class="d-block w-100" src="style/assets/img/spiderman.jpg" alt="Spiderman no way home" width="300px" height="200px">
                        </div>
                        <div class="carousel-item">
                          <img class="d-block w-100" src="style/assets/img/busq.jpg" alt="Busqueda Implacable" width="300px" height="200px">
                        </div>
                        <div class="carousel-item">
                          <img class="d-block w-100" src="style/assets/img/saw.jpg" alt="El juego del miedo" width="300px" height="200px">
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev" >
                        <span class="carousel-control-prev-icon" aria-hidden="true" ></span>
                        <span class="sr-only">Anterior</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Siguiente</span>
                  </a>
                </div>
                </div>
            </div>
        </div>
        
        


</div>
  <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" ></script>    
    <script src="Javascript/Script.js"></script>  
</body>
</html>
