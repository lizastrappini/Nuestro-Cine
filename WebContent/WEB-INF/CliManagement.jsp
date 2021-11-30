<%@page import="com.mysql.cj.xdevapi.Session"%>
<%@page import="entities.Persona"%>
<%@page import="logic.Login"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=UTF-8"> 
 	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="generator" content="">
	<meta http-equiv="refresh" content="0.5; index.jsp">
	<link rel="shortcut icon" href="https://img.icons8.com/ios-glyphs/30/ffffff/cinema---v1.png">
	<title>Bienvenido</title>
	<%

	Persona per = (Persona) session.getAttribute("usuario");
	%>
</head>

<body >

<div class="fondo">

<script >
window.alert("Bienvenido <%=per.getNombre()%> a nuestro sitio web")
</script>
<%
System.out.println(per.getNombre());
%>
</div>
</body>
</html>