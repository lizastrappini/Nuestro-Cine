<%@page import="com.mysql.cj.xdevapi.Session"%>
<%@page import="entities.Persona"%>
<%@page import="logic.Login"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=UTF-8"> 
 	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="generator" content="">
    <link rel="icon" href="http://getbootstrap.com/favicon.ico">
	<meta http-equiv="refresh" content="1; index.html">
	<title>Bienvenido</title>
	<%
	String name=null;
	name = request.getAttribute("nombre").toString();
	
	%>
</head>

<body >
<%=name%>
<div class="fondo">
<script >
window.alert("Bienvenido <%=name%> a nuestro sitio web"); /* //muestra BIENVENIDO null ¿¿¿?? // */
</script>
</div>
</body>
</html>