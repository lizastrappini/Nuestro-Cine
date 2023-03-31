<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entities.Comentario" %>
<%@page import="entities.Pelicula" %>
<%@page import="entities.Persona" %>
<%@page import="entities.Calificacion" %>
<%@page import="logic.LogicCalificacion" %>
<%@page import="logic.LogicComentario" %>
<%@page import="logic.LogicPelicula" %>
<%@page import="logic.Login" %>
<%@page import="java.time.LocalDateTime" %>
<%@page import="java.time.*" %>
<%@page import="java.time.format.DateTimeFormatter" %>
<%@page import="java.time.format.FormatStyle" %>
<%@ include file="/Estilo.jsp" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Detalles</title>
		<% 
		Integer isEmpleado = 0;
		Persona per = (Persona)request.getSession().getAttribute("usuario");

		LinkedList<Comentario> listac=(LinkedList<Comentario>)request.getAttribute("listacomentarios");		
		LogicCalificacion lc = new LogicCalificacion();
		Pelicula pel  = (Pelicula)request.getAttribute("pel");
		if(pel==null ){
			Integer codigo = Integer.parseInt(request.getAttribute("codigopeli").toString());
			LogicPelicula lpel = new LogicPelicula();
			pel = lpel.buscarPorCodigo(codigo);
			LogicComentario lcom = new LogicComentario();			
			listac = lcom.listarComentarios(pel);
			
		}
		Login lp = new Login();
		
		%>
	</head>
<body>
	<div class="fondo" >
		
		<jsp:include page="/BarraMenu.jsp" />
		<br>
		<br>
		<br>
		<% if (request.getAttribute("publicado")!=null) {%>
		<div class="alert alert-success">¡Comentario agregado!</div>
	<%} %>
        <div class="pelicula">
        	<img class="infopelicula" id="fotopelicula" src="<%=pel.getPortada()%>" alt="Not Found"  />
            <h2 class="infopelicula" id="nombrepelicula"><%=pel.getNombre() %></h2>
            <p class="infopelicula" id="sinopsis"><%=pel.getSinopsis() %></p>
            <p class="infopelicula"> <b>Director :</b> <%=pel.getDirector() %></p>
            <% Calificacion c = new Calificacion(); %>
            <% c = lc.buscarPorCodigo(pel.getCodigo_calificacion());%>
            <p class="infopelicula"> <b>Calificacion : </b><%=c.getDescripcion()%></p>
            <p class="infopelicula"> <b>Duracion : </b><%=(int)pel.getDuracion() %> min</p>
            <br>
               
        </div>

<h1 class="comments-container">Comentarios </h1>
<form class="form-card" action="NuevoComentario" method="post">
    <fieldset class="form-fieldset">  
        
        <div class="form-element form-textarea">
            <input type="text" name="comentario" id="field-3naeph-0f3yuw-x153ph-dzmahy-qhkmgm" class="form-element-field">
            <div class="form-element-bar"></div>
            <label class="form-element-label" for="field-3naeph-0f3yuw-x153ph-dzmahy-qhkmgm">Escribe un comentario</label>
        </div>
        
    </fieldset>
    <div class="form-actions">
    <input type="hidden" name="codigo" value="<%= pel.getCodigo() %>">
   
    <%if ( !(per==null)){ %>
        <button class="form-btn" type="submit">Publicar</button>
         <input type="hidden" name="dni" value="<%= per.getDni() %>">   
       <%} else{ %>      		
          <button class="form-btn-disabled" type="submit" disabled>Publicar</button>      
          <%} %>
    </div>
</form>
		
		
			<!-- Contenedor Principal -->
    		<div class="comments-container">
        <ul id="comments-list" class="comments-list">
		<% for (Comentario com : listac){ %>
		<% Persona pers = new Persona(); %>
    	<% pers.setDni(com.getDni()); %>
    	<% Persona p = lp.search(pers); 
    	DateTimeFormatter FORMATTER1 = DateTimeFormatter.ofPattern("dd/MM/yyyy 'a las 'hh:mm a");
        LocalDateTime fechahorafuncion = com.getFecha_hora();
        String fechayhora = FORMATTER1.format(fechahorafuncion);    	
    	%>
    			<!--<form action="MostrarAsientos" method="get"> -->
    			
            	<li>
                <div class="comment-main-level">
                    <!-- Avatar -->
                    <div class="comment-avatar"><img src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png" alt=""></div>
                    <!-- Contenedor del Comentario -->
                    <div class="comment-box">
                        <div class="comment-head">
                            <p class="comment-name"><%=p.getNombre() %> <%=p.getApellido() %></p>
                            <span><%=fechayhora%></span>
                        </div>
                        <div class="comment-content">
                            <%=com.getComentario()%>
                        </div>
                    </div>
                </div> 
                <li>
                
				
				
                <!--</form> -->
	   <%} %>
	   
</ul>
</div>
</div>
<script src="Javascript/Script.js"></script>
</body>
</html>