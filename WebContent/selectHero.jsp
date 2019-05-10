<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="dao.ConnectionDB"%>
<%@page import="java.sql.Connection"%>
<%@page import="dao.ConnectionDB"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.net.*" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.SQLException" %>
<%@page import="entidades.PersonajeHeroe" %>
<%@page import="entidades.Usuario" %>
<%@page import="dao.PersonajeHeroeDAO" %>
<%@page import="java.net.*" %>

<%
//Verificacion de variable de sesi�n login
if(request.getSession().getAttribute("login") == null){ 
	
	String url ="/index.jsp"; 
	RequestDispatcher rd = request.getServletContext().getRequestDispatcher(url);
 	rd.forward(request, response);
	}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seleccionar personaje</title>

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
                <p class="designed-by">Bienvenido, <b><%
		if(request.getSession().getAttribute("login") != null){ 
		  out.println(((Usuario) request.getSession().getAttribute("login")).getNick());
		  
		} else out.println("Invitado");
                
                %></b></p>
              </li>
              
              <%
              if(request.getSession().getAttribute("login") != null){
            	%>
            	  <li class="nav-item">
                  
                  <form action="Controller" method="post">
                  	<input type="hidden" value="logout" name="opcion"/>
                  	<input class="btn btn-outline-primary" type="submit" name="salir" value="Desconectar"/>
                  </form>
                </li>
                <%
              }
              %>
              
              
            </ul>
          </div>
        
              
      </div>

    </nav>
    <!-- /Header -->

	<!-- Main -->
	<section id="personajes" class="mt-4 mb-4 fondo-gris">
      <div class="container  ">
        <div class="row col-8 offset-2 mt-3">
          <div class="col text-center mt-3 mb-3 ">
            
            <h2 class="pb-2 ">Escoge tu H�roe</h2>
          </div>
        </div>
        <div class="row">
        
        <% 
        ResultSet rs = null;
        Statement stmt =null;
        ConnectionDB c =null;
        Connection con =null;
        try {
                 
        	 c = new ConnectionDB();
             con = c.openConnection();
        	String error = "";
        	String url ="";
        	PersonajeHeroeDAO hdao = null;
        	PersonajeHeroe h=new PersonajeHeroe();
        	
        	 stmt = con.createStatement();

        	 rs = stmt.executeQuery("SELECT * FROM plantilla_heroe");
        	
        	
                //stmt = con.prepareStatement("SELECT * FROM heroe_plantilla");
                //stmt.setInt(1,articulo.getIdArticulo());
                //rs =stmt.executeQuery();
                while (rs.next()) {
                    
                   System.out.println("exito"); 
                   
             %>
	            <div class="col-12 col-md-6 col-lg-4 mb-4">
	            <div class="card">
	              <img class="card-img-top" src=<%= rs.getString("avatar_heroe") %> alt="Capit�n Am�rica">
	              <div class="card-body">
	                <div class="badges">
	                  <span class="badge badge-warning"><%= rs.getString("super_poder_1") %></span>
	                  <span class="badge badge-info"><%= rs.getString("super_poder_2") %></span>
	                </div>
	                <h5 class="card-title"><%= rs.getString("nombre") %></h5>
	                <p class="card-text"><%= rs.getString("descripcion") %></p>
	                <form action="cargarPartida.jsp">
	                	<div class="centrado">
	                		<input class="  btn btn-blue  mb-2 pl-5 pr-5" type="submit" name="hero" value="Seleccionar" />
	                		<input type="hidden" value=<%=rs.getInt("id_plantilla") %> name="id_plantilla"/>
	                	</div>
	                </form>
	              </div>
	            </div>
	          </div>
                   
              <%
                   
                }                     
            } catch (SQLException ex) {
                //ex.printStackTrace();
               // throw new Exception("Ha habido un problema al cargar los resultados "+ex.getMessage());
            }finally
            {
                if (rs != null) rs.close(); //Cerramos el resulset
                if (stmt != null) stmt.close();//Cerramos el Statement   
                if (con != null) c.closeConnection(con);
            }
        
        %>
        
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