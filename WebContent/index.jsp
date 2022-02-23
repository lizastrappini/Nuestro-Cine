<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="entities.Persona" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
    <%@ include file="/Estilo.jsp" %>
    <title>INICIO</title>
    <link href="style/css/styles.css" rel="stylesheet" />
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script src="Javascript/Script.js"></script>
</head>
<body id="page-top">
<div class="fondo">
	<jsp:include page="/BarraMenu.jsp" />
    <header class="masthead text-center text-white">
    	<div class="masthead-content">
        	<div class="container px-5">
            	<form class="form-signin" action="MostrarPeliculas" method="post">
                	<h1 class="masthead-heading mb-0">TODOS LOS ESTRENOS</h1>
                    <h2 class="masthead-subheading mb-0">EN UN MISMO LUGAR</h2>
                    <button class="botonEstreno"  >Ver estrenos</button>
                </form>
            </div>
        </div>
	</header>
    <section id="scroll">
    	<div class="container px-5">
        	<div class="row gx-5 align-items-center">
            	<div class="col-lg-6 order-lg-2">
                	<div class="p-5">
                		<img class="img-fluid rounded-circle" src="assets/img/01.jpg" alt="..." />
                	</div>
                </div>
            	<div class="col-lg-6 order-lg-1">
                	<div class="p-5">
                    	<h2 class="display-4">CARACTERISTICA 1</h2>
                        <p>
                        	Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                            quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                            consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
                            cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
                            proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section>
    	<div class="container px-5">
        	<div class="row gx-5 align-items-center">
            	<div class="col-lg-6">
                	<div class="p-5">
                		<img class="img-fluid rounded-circle" src="assets/img/02.jpg" alt="..." />
                	</div>
                </div>
                <div class="col-lg-6">
                <div class="p-5">
                	<h2 class="display-4">We salute you!</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quod aliquid, mollitia odio veniam sit iste esse assumenda amet aperiam exercitationem, ea animi blanditiis recusandae! Ratione voluptatum molestiae adipisci, beatae obcaecati.</p>
                </div>
            	</div>
        	</div>
    	</div>
    </section>
    <section>
    	<div class="container px-5">
        	<div class="row gx-5 align-items-center">
            	<div class="col-lg-6 order-lg-2">
                	<div class="p-5">
                		<img class="img-fluid rounded-circle" src="assets/img/03.jpg" alt="..." /></div>
                    </div>
                    <div class="col-lg-6 order-lg-1">
                        <div class="p-5">
                            <h2 class="display-4">Let there be rock!</h2>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quod aliquid, mollitia odio veniam sit iste esse assumenda amet aperiam exercitationem, ea animi blanditiis recusandae! Ratione voluptatum molestiae adipisci, beatae obcaecati.</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <footer class="py-5 bg-black">
            <div class="container px-5"><p class="m-0 text-center text-white small">Copyright &copy; Your Website 2021</p></div>
        </footer>
</div>  
   <%if ( request.getAttribute("entradasCompradas")!= null){%>
   <script>
   Swal.fire({
		  icon: 'success',
		  title: 'Las entradas han sido reservadas!',
		  text: 'Las encontrara en su casilla de correo',
		})
   </script>
   <%} %>      
</body>
</html>
