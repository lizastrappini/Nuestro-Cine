<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Persona" %>
<%@page import="entities.Pelicula" %>
<%@page import="logic.Login" %>
<%@page import="java.util.LinkedList"%>
<%@page import="entities.Entrada" %>
<%@page import="logic.LogicEntrada" %>
<%@page import="logic.LogicPelicula" %>
<%@page import="java.util.LinkedList" %>
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

Entrada ent = new Entrada();
ent.setDni(per.getDni());
LogicEntrada le = new LogicEntrada();
LinkedList<Entrada> entradas = le.buscar(ent);
LogicPelicula pl = new LogicPelicula();

%>
</head>
<body >

<div class="fondo">
<jsp:include page="/BarraMenu.jsp" />
<div class="info">
<img class="avatar" src="https://cdn.pixabay.com/photo/2016/11/08/15/21/user-1808597_960_720.png"/>

<div class="compras">
<h1 class="miscompras">MIS COMPRAS</h1>

<!-- Tabla donde se veran las compras del usuario -->

<form name="cancelarEntrada" action="BorrarEntrada" method="post" id="cancelarEntrada" >
	<% if (request.getAttribute("borrada")!=null) {%>
    	<div class="alert alert-success">¡Entrada cancelada con exito!</div>
    <% }%>
	<table class="table table-bordered">
	<thead>
		<tr>
			<th>Pelicula</th>
			<th>Fecha</th>
			<th>Hora</th>
			<th>Precio</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<%for (Entrada e:entradas){
		Pelicula p = pl.buscarPorCodigo(e.getCod_pelicula());%>
		<tr>
  			<td><%=p.getNombre()%></td>
  			<%String[] fechaHora = e.getFecha_hora_funcion().toString().split("T"); %>
  			<td><%=fechaHora[0]%></td>
  			<td><%=fechaHora[1]%></td>
  			<td><%=e.getTotal()%></td>
  			<td><input type="hidden" name="identrada" value="<%=e.getId_entrada()%>">
  			<input type="hidden" name="codpelicula" value="<%=e.getCod_pelicula()%>">
  			<input type="button" name="cancelar" value="CANCELAR" class="btn btn-danger" onclick="borrarEntrada()"></td>
		</tr>
		<%} %>
	</tbody>
	</table>
</form> 
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
<%}  %>

</body>
</html>