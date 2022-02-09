<%@page import="entities.Persona" %>
<% 
Integer isEmpleado = 0;
Persona per = (Persona)request.getSession().getAttribute("usuario");
		
if ( !(per==null)){
	isEmpleado = per.getHabilitado();
} else {isEmpleado = 0;}	 
%>
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
                        <li class="nav-item"><a class="nav-link" id="signout" href="SignOut" >Cerrar sesion</a></li>               
                <%} %>	
            </ul> 
        </div>
    </div>
</nav>