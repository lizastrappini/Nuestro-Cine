<%@page import="com.mysql.cj.xdevapi.Session"%>
<%@page import="entities.Cliente"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenido</title>
<% 
	Cliente c = (Cliente)session.getAttribute("cliente");
%>
</head>
<body>

	<h1>Bienvenido <%=c.getNombre()%> !</h1>

</body>
</html>