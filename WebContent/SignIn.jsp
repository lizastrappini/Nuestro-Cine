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

<!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark navbar-custom fixed-top">
            <div class="container px-5">
                <a class="navbar-brand" href="index.jsp">NUESTRO CINE</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto">	
                    	<li class="nav-item"><a class="nav-link" href="Peliculas.jsp">Cartelera</a></li>
                    	<li class="nav-item"><a class="nav-link" href="SignUp.html">Registrarse</a></li>
                    </ul>
                     
                </div>
            </div>
        </nav>


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