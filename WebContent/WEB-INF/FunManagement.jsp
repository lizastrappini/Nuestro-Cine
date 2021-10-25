<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Funcion"%>
<%@page import="java.util.LinkedList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Funciones</title>
<% 
	LinkedList<Funcion> lf=(LinkedList<Funcion>)request.getAttribute("listafunciones");
%>
</head>
<body>
	<% for (Funcion fun : lf){ %>
	  <!-- Content section 1-->
        <div class="funcion">
                            <h2 class="funcion" id="fechahora"><%=fun.getFecha_hora() %></h2>
                            <p class="funcion" id="numerosala"><%=fun.getNumero_sala()%></p>
                            <br>
                            <button class="funcion" id="sacarentrada">  Sacar entrada   </button>
                            
        </div>
        
	<%} %>
</body>
</html>