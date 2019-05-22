<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.net.*" %>
<%@page import="entidades.PersonajeHeroe" %>
<%@page import="entidades.Usuario" %>
<%
//Verificacion de variable de sesión login
if(request.getSession().getAttribute("login") != null){ 
	
	String url ="/createOrSelect.jsp"; 
	RequestDispatcher rd = request.getServletContext().getRequestDispatcher(url);
 	rd.forward(request, response);
	}



%>
    
    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stage 1</title>

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="bootstrap/css/main.css" rel="stylesheet" type="text/css"/>
</head>


<body data-spy="scroll" data-target="#navbar" data-offset="74">
    <!-- Header -->
    <nav id="header" class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
      <div class="container">
        <span class="navbar-brand" >
          <img  src="images/link.jpg" alt="game logo">
          <b class="ml-5">ZELDA'S JOURNEY</b> <i class="ml-3 designed-by">the challenge</i>
        </span>   
        
        <%--Bienvenido (usuario) y boton Desconectar --%>
        
                   <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>

          <div class="collapse navbar-collapse" id="navbar">
            <ul class="navbar-nav ml-auto">
              <li class="mt-2 mr-5">
                <p class="designed-by">Bienvenid@, <b>Invitad@</b></p>
              </li>
              <li class="nav-item">
                  <form action="Controller" method="post">
                  	<input type="hidden" value="salirInvitado" name="opcion"/>
                  	<input class="btn btn-outline-primary pr-4 pl-4" type="submit" name="salir" value="Salir"/>
                  </form>
                </li>
            </ul>
          </div>
              
      </div>

    </nav>
    <!-- /Header -->

<section id="personajes" class="mt-4 mb-4 pt-4 pb-4 fondo-verde-claro">
      <div class="container  ">
        <div class="row col-8 offset-2 mt-3">
          <div class="col text-center mt-3 mb-3  ">
            <h2 class="pb-2 sin-fondo ">Stage 1    Fight!!</h2>
          </div>
        </div>
        <div class="row centrado">
          <div class="col-12 col-md-6 col-lg-2  mb-4">
            <div class="card ">
              <img class="card-img-top" src="images/link.jpg" alt="Héroe seleccionado">
            </div>
          </div>
          <div class="col-12 col-md-6 col-lg-2 mb-4 ml-5 mr-5">
            <div class="card ">
              <img class="card-img" src="images/versus.png" alt="versus">
				
            </div>
			<div class="centrado">
				<a href="guestWinner.jsp" class="  btn btn-blue  mb-2 mt-5 ">Luchar !</a>
			</div>
          </div>
          <div class="col-12 col-md-6 col-lg-2 mb-4">
            <div class="card ">
              <img class="card-img-top "  src="images/wonderWoman.jpg" alt="Wonder Woman">
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- /Speakers -->

    <!-- Footer -->
    <footer id="footer" class="pb-4 pt-4">
      <div class="container">
        <div class="row text-center">
          <div class="col-12 col-lg">
            <a href="https://sites.google.com/s/1y2C6rPDcKnd7HR0LB8RmgU6j0pvexoZP/p/144MdQoV1Qs2Y_6uxrhwuuy4g8RGycim-/edit" target="_blank">Google Sites del proyecto</a>
          </div>
          <div class="col-12 col-lg">
            <a href="https://github.com/FernandoDavidGomezOrtega/zeldasJourneyWeb"  target="_blank">Github</a>
          </div>
        </div>
        <div class="row pt-4 mt-3 ">
          <div class="col">
            <p class="designed-by">Designed by: MSF Team <br>Proyecto P_6 UOC 2019</p>
          </div>
        </div>
      </div>
    </footer>
    <!-- /Footer -->

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <script src="bootstrap/js/bootstrap.js"></script>
    
  </body>
  
</html>