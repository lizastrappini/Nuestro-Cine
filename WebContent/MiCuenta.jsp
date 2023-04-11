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
} else {isEmpleado = 0;
%>
<jsp:forward page="index.jsp"></jsp:forward>
<% }

Entrada ent = new Entrada();
ent.setDni(per.getDni());
LogicEntrada le = new LogicEntrada();
LinkedList<Entrada> entradas = le.buscar(ent);
LogicPelicula pl = new LogicPelicula();

%>
</head>
<body >

<div class="fondo">
<nav class="navbar navbar-expand-lg navbar-dark navbar-custom fixed-top">
	<div class="container px-5">
    	<a class="navbar-brand" href="index.jsp">NUESTRO CINE</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
        	<ul class="navbar-nav ms-auto">	
            	<%if ( isEmpleado==1){ %>
            		<li class="nav-item"><a class="nav-link" href="Empleados.jsp">EMPLEADOS</a></li> 
                <%}%>	 
                <li class="nav-item"><a class="nav-link" href="Peliculas.jsp">Cartelera</a></li>
                <% if ( request.getSession().getAttribute("usuario")==null ) {%>
                	<li class="nav-item"><a class="nav-link" href="SignUp.jsp">Registrarse</a></li>
                    <li class="nav-item"><a class="nav-link" href="SignIn.jsp" id="signin">Iniciar sesion</a></li>
                <%} else {%> 
                    	<li class="nav-item"><a class="nav-link">HOLA, <%=per.getNombre().toUpperCase()%>!</a></li>
                        <li class="nav-item"><a class="nav-link" id="signout"  onclick="cerrarSesion()">Cerrar sesion</a></li>
                        <li class="nav-item"><a class="nav-link" id="micuenta" href="MiCuenta.jsp" >Mi cuenta</a></li>               
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
<button class="signout" onclick="cambiarContra()" >CAMBIAR CONTRASEÑA</button>
<button class="signout2"  onclick="cerrarSesion()" >CERRAR SESION</button>
<% if (per.getHabilitado()==0){  %>
<button class="signout" onclick="editarPersona()" >EDITAR DATOS</button>
<button class="signout2" onclick="borrarCuenta()" >BORRAR CUENTA</button>
<%} %>
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
<%}  
if ( request.getAttribute("entradasCompradas")!= null){%>
   <script>
   Swal.fire({
		  icon: 'success',
		  title: 'Las entradas han sido reservadas!',
		  text: 'Las encontrara en su casilla de correo',
		})
   </script>
   <%} %> 

<%
if (request.getAttribute("cambio")!=(null) && request.getAttribute("cambio").equals("datoscambiados")){%>
	<script>
	Swal.fire({
		  icon: 'success',
		  title: 'Datos cambiados con exito'
		})
	</script>   
<%} %>  
<script>
function editarPersona(){
	  Swal.fire({
	    title: 'Editar datos',
	    html:
	    '<form name="cambio" action="EditarDatos" method="POST" >'+
	    '<input id="nombre" name="nombre" class="swal2-input" type="text" placeholder="nombre" value="<%=per.getNombre()%>">' +
	    '<input id="apellido" name="apellido" class="swal2-input" type="text" placeholder="apellido" value="<%=per.getApellido()%>">' +
	     '<input id="telefono" name="telefono" class="swal2-input" type="number" placeholder="telefono" value="<%=per.getTelefono()%>">'+
	     '<input id="edad" name="edad" class="swal2-input" type="number" placeholder="edad" value="<%=per.getEdad()%>">'+
	     '</form>',
	      focusConfirm: false,   
	  }).then((result) => {
	  if(result.isConfirmed){
		cambio.submit();   
	    }
	    })
	}
</script>   
</body>
</html>