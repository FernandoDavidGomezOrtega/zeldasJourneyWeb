<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Zelda's Journey</title>

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
      </div>

    </nav>
    <!-- /Header -->

    <!-- Main -->
	<section id="" class=" fondo-gris  mb-3 mt-4 mb-4  ">
		<div class="row container ml-5">
			<div class="col-9 pb-3 pt-1">
				<div id="carousel" class="carousel slide carousel-fade mt-3" data-ride="carousel" data-pause="false">
			        <div class="carousel-inner">
			          <div class="carousel-item active ml-5 pl-5">
			            <img class="d-block w-80 maindiv ml-5" src="images/escudo.png" alt="link">
			          </div>
			          <div class="carousel-item ml-5 pl-5">
			            <img class="d-block w-80 ml-5 pl-5 maindiv" src="images/enemigo_comun_2.png" alt="monstruo">
			          </div>
			          <div class="carousel-item ml-5">
			            <img class="d-block w-80 ml-5 pl-5 maindiv" src="images/enemigo_jefe_2.png" alt="monstruo">
			          </div>
			        </div>
      			</div>
			</div>
			<div class="col-3 mt-5" >
						<div class=" ">   
               <div class="row centrado mt-3">
	        	<h3 >Jugar como invitado</h3>
               </div>
               <div class="row centrado ">
				<form action="createOrSelect.jsp" method="post">
					<input class="  btn btn-blue mt-2 mb-2 pl-5 pr-5"  type="submit" value="Ok"></input>
					<input type="hidden" name="opcion" value="invitado"/>
      			</form>
               </div>
               <hr class="col-6">
               
               <div class="row centrado mt-3">
	        	<h3 >Iniciar sesión</h3>
               </div>
               <div class="row centrado">
				<form action="login.jsp" method="post">
					<input class="  btn btn-blue mt-2 mb-2 pl-5 pr-5" type="submit" value="Ok"></input>
					<input type="hidden" name="opcion" value="login"/>
      			</form>
               </div>
               <hr class="col-6">
               
               <div class="row centrado mt-3">
	        	<h3 >Regístrate</h3>
               </div>
               <div class="row centrado">
				<form action="signup.jsp" method="post">
					<input class="  btn btn-blue mt-2 mb-2 pl-5 pr-5" type="submit" value="Ok"></input>
					<input type="hidden" name="opcion" value="signup"/>
      			</form>
               </div>
		</div>
			</div>
		</div>
    </section>
    <!-- /Main -->

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