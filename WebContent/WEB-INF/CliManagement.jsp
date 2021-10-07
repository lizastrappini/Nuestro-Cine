<%@page import="com.mysql.cj.xdevapi.Session"%>
<%@page import="entities.Cliente"%>
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

	<title>Bienvenido</title>
	<% 
	Cliente cli = (Cliente)session.getAttribute("usuario");
	
	%>
</head>
<body>

	<h1>Bienvenido </h1>
	<h1><%=cli.getNombre() %></h1>

</body>
</html>