<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.time.*"%>
<%@page import="java.time.format.*"%>
<%@page import="entities.Persona" %>
<%@page import="entities.Genero" %>
<%@page import="logic.LogicGenero" %>
<%@page import="java.util.LinkedList"%>

<!DOCTYPE html>
<html>
<head>
<title>---AGREGAR GENERO---</title>
<%@ include file="/Estilo.jsp" %>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<%  
	LocalDateTime fecha = LocalDateTime.now();
	DateTimeFormatter isoFecha = DateTimeFormatter.ISO_LOCAL_DATE;
	String bandera = null;
	if ( !(request.getAttribute("bandera")==(null)) ){
	bandera = request.getAttribute("bandera").toString();}
	
	Integer isEmpleado = 0;
	Persona per = (Persona)request.getSession().getAttribute("usuario");
		
		if ( !(per==null)){
			isEmpleado = per.getHabilitado();
		} else {isEmpleado = 0;}	
		
	LogicGenero lg = new LogicGenero();
	LinkedList<Genero> listageneros = lg.getAll();
	
 
%>
</head>
<body>
	<div class="fondo">
<jsp:include page="/BarraMenu.jsp" />
    <br>
    <br>
	<h2>BORRAR GENERO</h2>
	<% if (   request.getAttribute("Encontrado")==null){ %>
	<form class="addCosto" action="BorrarGenero" method="post" >
    <select name="GeneroPelicula" required="required">		
		<% for (Genero g: listageneros){ %>
        	<option value="<%= g.getDescripcion() %>" selected="selected"><%= g.getDescripcion() %></option>
         <% } %>	
         </select>
         <br>
         <br>
    
    <button class="btn btn-lg btn-primary btn-block" type="submit" id="botonAgregar" >BORRAR</button>
    </form>
   <% }  if ( request.getAttribute("Encontrado") != null ) {%>
   		<form name="borrar" method="get" action="BorrarGenero">
		<input type="hidden" name="idGenero" value="<%=request.getAttribute("idGenero")%>">
		</form>
   		
		<script type="text/javascript">
		Swal.fire({
			  title: 'Estas seguro?',
			  text: "Las peliculas que pertenezcan al genero se borraran",
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: 'Si,borrar'
			  
			}).then((result) => {
			  if (result.isConfirmed) {
			    
			    borrar.submit()
			  }
			})
		</script>
		
		
   <%} %>
	</div>
	
</body>
</html>