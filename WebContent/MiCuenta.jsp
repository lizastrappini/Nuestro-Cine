<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Persona" %>
<%@page import="entities.Compra" %>
<%@page import="logic.Login" %>
<%@page import="java.util.LinkedList"%>
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

String d = per.getDni();
Login lg = new Login();
LinkedList<Compra> compras= lg.getCompras(per);

%>
</head>
<body >
<%
if ( per != (null) ){
%>

<div class="fondo">
 <jsp:include page="/BarraMenu.jsp" />
<div class="info">
<img class="avatar" src="https://cdn.pixabay.com/photo/2016/11/08/15/21/user-1808597_960_720.png"/>

<div class="compras">
<h1 class="miscompras">MIS COMPRAS</h1>

<!-- Tabla donde se veran las compras del usuario -->
<table class="blueTable">
<thead>
<tr>
<th>Pelicula</th>
<th>Fecha</th>
<th>Hora</th>
<th>Cantidad</th>
<th>Total</th>
</tr>
</thead>
<tbody>
<% if ( !(compras.isEmpty()) ) { for (Compra c : compras){ %>
<tr>
  <td><%=c.getNombre() %></td>
  <td><%=c.getFecha() %></td>
  <td><%=c.getHora() %></td>
  <td><%=c.getCantidad() %></td>
  <td><%=c.getTotal() %></td>
</tr>
<%} }%>
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