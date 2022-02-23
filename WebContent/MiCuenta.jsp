<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Persona" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mi cuenta</title>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="Javascript/Script.js"></script>
<link href="style/css/styles.css" rel="stylesheet" />
<%
Integer isEmpleado = 0;
Persona per = (Persona)request.getSession().getAttribute("usuario");

if ( !(per==null)){
	isEmpleado = per.getHabilitado();
} else {isEmpleado = 0;}


%>
</head>
<body >
<%
if ( per != (null) ){
%>

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
                        <%}else {%> 
                        <li class="nav-item"><a class="nav-link">HOLA, <%=per.getNombre().toUpperCase()%>!</a></li>
                        
                   		<%} %>	
                    </ul>
                     
                </div>
            </div>
        </nav>
<div class="info">
<img class="avatar" src="https://cdn.pixabay.com/photo/2016/11/08/15/21/user-1808597_960_720.png"/>

<div class="compras">
<h1 class="miscompras">MIS COMPRAS</h1>

<!-- Tabla donde se veran las compras del usuario -->
<table class="blueTable">
<thead>
<tr>
<th>Fecha</th>
<th>Estado</th>
<th>Total</th>
<th></th>
</tr>
</thead>
<tbody>
<tr>
  <td></td>
  <td></td>
  <td></td>
  <td><button  class="botonVer">VER</button></td>
</tr>
</tbody>
</table>
</div>
<div class="micuenta"><%=(per.getNombre()+" "+per.getApellido()).toUpperCase()%></div>
<button class="micuenta" onclick="cambiarContra()" >CAMBIAR CONTRASEÑA</button>
<button class="signout"  onclick="cerrarSesion()" >CERRAR SESION</button>
</div>
</div>
<%
if (request.getAttribute("cambioPass")!=(null) && request.getAttribute("cambioPass").equals("passCambiada")){%>
	<script>
	Swal.fire({
		  icon: 'success',
		  title: 'cambiada con exito'
		})
	</script>
<%} else if ( request.getAttribute("cambioPass")!=(null) && request.getAttribute("cambioPass").equals("passNoCoinciden")){%>
	<script>
	Swal.fire({
		  icon: 'error',
		  title: 'Ops...',
		  text: 'La contraseña ingresada no coincide con la contraseña actual'
		})
	</script>
<%} } else {%>
<jsp:forward page="index.jsp"/>
 <%}%> 
</body>
</html>