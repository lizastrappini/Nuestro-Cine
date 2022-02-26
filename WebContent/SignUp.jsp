<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>---REGISTRARSE---</title>
        <link href="style/css/styles.css" rel="stylesheet" />
		<script src="Javascript/CheckPass.js"></script>
		<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
		
</head>
<body>

<div class="fondo">
<jsp:include page="/BarraMenu.jsp" />

<form class="form-signin" action="Registrarse" method="post" name="form" onsubmit="return checkForm(this);">
      
      <h1 class="h3 mb-3 font-weight-normal">Complete todos sus datos</h1>
      <label for="inputEmail" >Email</label>
      <input id="inputEmail" name="email" class="form-control" placeholder="Email address" required  type="email">
      <label for="inputPassword" >Contraseña (entre 8 y 16 caracteres,al menos un dígito, al menos una minúscula y al menos una mayúscula)</label>
      <input id="inputPassword" name="pwd1" class="form-control" placeholder="Password"  type="password" required title="Debe tener al menos una mayúscula, una minúscula y un dígito">
      <label for="inputPassword" >Vuelva a ingresar la contraseña</label>
      <input id="inputPassword" name="pwd2" class="form-control" placeholder="Password" required type="password">
      <label for="inputNombre" >Nombre</label>
      <input id="inputNombre" name="nombre" class="form-control" placeholder="Nombre" required type="text">
      <label for="inputApellido" >Apellido</label>
      <input id="inputApellido" name="apellido" class="form-control" placeholder="Apellido" required  type="text">
      <label for="inputEdad" >Edad</label>
      <input id="inputEdad" name="edad" class="form-control" placeholder="edad" required type="number">
      <label for="inputDni" >Dni</label>
      <input id="inputDni" name="dni" class="form-control" placeholder="dni" required type="number">
      <label for="inputTel" >Telefono</label>
      <input id="inputTel" name="tel" class="form-control" placeholder="telefono" required type="number">
      <input type="hidden" name="habilitado" value="0">
      <button class="buttonIniciar" type="submit" value="Enviar" >Registrarse</button> 
      
    </form>
</div>
<%
if (request.getAttribute("registro")!=(null) && request.getAttribute("registro").toString().equals("noregistrado")){%>
	<script>
	Swal.fire({
		  icon: 'error',
		  title: 'Oops...',
		  text: 'El usuario ya esta registrado',
		})
	</script>
<%} else if ( request.getAttribute("registro")!=(null) && request.getAttribute("registro").toString().equals("registrado") ){%>
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