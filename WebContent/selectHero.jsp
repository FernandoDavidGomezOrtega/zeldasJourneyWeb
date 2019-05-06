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

<section id="personajes" class="mt-4 mb-4 fondo-gris">
      <div class="container  ">
        <div class="row col-8 offset-2 mt-3">
          <div class="col text-center mt-3 mb-3 ">
            
            <h2 class="pb-2 ">Escoge tu Héroe</h2>
          </div>
        </div>
        <div class="row">
          <div class="col-12 col-md-6 col-lg-4 mb-4">
            <div class="card">
              <img class="card-img-top" src="images/capitan_america.jpg" alt="Capitán América">
              <div class="card-body">
                <div class="badges">
                  <span class="badge badge-warning">Super resistencia</span>
                  <span class="badge badge-info">Escudo proyectil</span>
                </div>
                <h5 class="card-title">Capitán América</h5>
                <p class="card-text">Luchando por la justicia después de haber estado congelado durante muchos años. En un mundo en guerra siempre es fiel a sus ideales</p>
                <form action="cargarPartida.jsp">
                	<div class="centrado">
                		<input class="  btn btn-blue  mb-2 pl-5 pr-5" type="submit" name="hero" value="Seleccionar" />
                		<input type="hidden" value="capitanAmerica"/>
                	</div>
                </form>
              </div>
            </div>
          </div>
          <div class="col-12 col-md-6 col-lg-4 mb-4">
            <div class="card">
              <img class="card-img-top mt-3 mb-5" src="images/astro-boy.png" alt="Astro boy">
              <div class="card-body">
                <div class="badges mt-3">
                  <span class="badge badge-secondary">Super velocidad</span>
                  <span class="badge badge-danger">Viajes interplanetarios</span>
                </div>
                <h5 class="card-title">Astro Boy</h5>
                <p class="card-text">Viene del futuro y está dispuesto a ayudar a la humanidad. Controla todas les tecnologías cibernéticas y de fusión nuclear.</p>
                <form action="cargarPartida.jsp">
                	<div class="centrado">
                		<input class="  btn btn-blue  mb-2 pl-5 pr-5" type="submit" name="hero" value="Seleccionar" />
                		<input type="hidden" value="astroBoy"/>
                	</div>
                </form>
              </div>
            </div>
          </div>
          <div class="col-12 col-md-6 col-lg-4 mb-4">
            <div class="card pb-2">
              <img class="card-img-top mt-3 mb-3" src="images/gladiator.jpg" alt="Astro boy">
              <div class="card-body">
                <div class="badges mt-1">
                  <span class="badge badge-warning">Super fuerza</span>
                  <span class="badge badge-info">Resistencia máxima</span>
                </div>
                <h5 class="card-title">Gladiator</h5>
                <p class="card-text mb-3 pb-4">Viene del antiguo imperio romano. Su fuerza descomunal lo convierte en un enemigo temible. No tiene miedo a nada.</p>
                <form action="cargarPartida.jsp">
                	<div class="centrado mt-3">
                		<input class="  btn btn-blue  mb-2 pl-5 pr-5" type="submit" name="hero" value="Seleccionar" />
                		<input type="hidden" value="gladiator"/>
                	</div>
                </form>
              </div>
            </div>
          </div>
          <div class="col-12 col-md-6 col-lg-4 mb-4">
            <div class="card">
              <img class="card-img-top mt-5" src="images/super_woman.jpg" alt="Astro boy">
              <div class="card-body">
                <div class="badges mt-3">
                  <span class="badge badge-secondary">Viajes multiverso</span>
                  <span class="badge badge-danger">Telepatía</span>
                </div>
                <h5 class="card-title">Super Woman</h5>
                <p class="card-text">Viene de otra dimensión donde el planeta Kripton pudo ser salvado de su destrucción. Atrapada en éste universo decide unirse a los superhéroes para cuidar la galaxia.</p>
                <form action="cargarPartida.jsp">
                	<div class="centrado">
                		<input class="  btn btn-blue  mb-2 pl-5 pr-5" type="submit" name="hero" value="Seleccionar" />
                		<input type="hidden" value="superWoman"/>
                	</div>
                </form>
              </div>
            </div>
          </div>
          <div class="col-12 col-md-6 col-lg-4 mb-4">
            <div class="card">
              <img class="card-img-top mt-5" src="images/link2.jpg" alt="Astro boy">
              <div class="card-body">
                <div class="badges">
                  <span class="badge badge-warning">Super astucia</span>
                  <span class="badge badge-info">Diseño de trampas</span>
                </div>
                <h5 class="card-title">Link</h5>
                <p class="card-text">Es un gran espadachín, arquero, jinete, ejecutante musical, y tiene una gran habilidad para el combate combate en modo duelo. El más hábil de todos</p>
                <form action="cargarPartida.jsp">
                	<div class="centrado">
                		<input class="  btn btn-blue  mb-2 pl-5 pr-5" type="submit" name="hero" value="Seleccionar" />
                		<input type="hidden" value="link"/>
                	</div>
                </form>
              </div>
            </div>
          </div>
          <div class="col-12 col-md-6 col-lg-4 mb-4">
            <div class="card">
              <img class="card-img-top mt-3" src="images/robot_heroe.png" alt="Astro boy">
              <div class="card-body">
                <div class="badges mt-2">
                  <span class="badge badge-secondary">Casi indestructible</span>
                  <span class="badge badge-danger">Rayo aniquilador</span>
                </div>
                <h5 class="card-title">Robot Z-Storm</h5>
                <p class="card-text">Construído como un proyecto secreto del Pentágono, Z-Storm utiliza su inteligencia artificial para empatizar con los seres humanos y socorrer en catástrofes naturales. Esta vez está dispuesto a todo en The Challenge</p>
                <form action="cargarPartida.jsp">
                	<div class="centrado">
                		<input class="  btn btn-blue  mb-2 pl-5 pr-5" type="submit" name="hero" value="Seleccionar" />
                		<input type="hidden" value="zstorm"/>
                	</div>
                </form>
              </div>
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