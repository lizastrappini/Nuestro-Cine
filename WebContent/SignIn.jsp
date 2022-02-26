<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>---INICIAR SESION---</title>
        <link href="style/css/styles.css" rel="stylesheet" />
		<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
		
</head>

<body>
<div class="fondo">

<jsp:include page="/BarraMenu.jsp" />


<form class="form-signin" action="iniciarSesion" method="post" >
      
      <h1 class="h3 mb-3 font-weight-normal">Ingrese sus datos</h1>
      <label for="inputEmail" >Email</label>
      <input id="inputEmail" name="email" class="form-control" placeholder="Email address" required type="email">
      <label for="inputPassword" >Contraseña</label>
      <input id="inputPassword" name="pass" class="form-control" placeholder="Password" required type="password">
      <br>
      <button class="buttonIniciar" type="submit" >Iniciar sesion</button> 
    </form>
    
</div>


<%
if (request.getAttribute("mensaje")!=(null) ){%>
	<script>
	Swal.fire({
		  icon: 'error',
		  title: 'Oops...',
		  text: 'Usuario o contraseña incorrectos',
		})
	</script>
<%} else if ( session.getAttribute("usuario")!=(null)){%>
	<script>
	Swal.fire({
	title: "Bienvenido!"
	});
	setTimeout( function() { window.location.href = "index.jsp"; }, 1600 );
	</script>
<%}
%>
</body>
</html>