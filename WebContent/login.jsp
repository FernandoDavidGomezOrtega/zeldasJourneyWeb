<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.net.*" %>
    
<%   

//Verificacion de la variable de sesion login

if(request.getSession().getAttribute("login") != null){ 
	
	String url ="/createOrSelect.jsp"; 
	RequestDispatcher rd = request.getServletContext().getRequestDispatcher(url);
 	rd.forward(request, response);
	}
%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="bootstrap/css/main.css" rel="stylesheet" type="text/css"/>


</head>


<body data-spy="scroll" data-target="#navbar" data-offset="74">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>

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
	<section id="" class=" fondo-amarillo-claro  pb-5 pt-5 mt-3 mb-3 centrado">
	
	  <div class="container">
        <form id="form"  action="Controller" method="post" onsubmit="return validarPassword()">
        <input type="hidden" value="dologin" name="opcion"/>
        	<div class="row centrado">
          <div class=" mb-2 mt-3 pt-3  ">
            <h3 class="text-align-center sin-fondo">Iniciar sesi�n</h3>
          </div>
        </div>
        
        <%--Mensaje de error --%>
        <%
        if(request.getAttribute("error") != null){
        %>
        
        <div class="row centrado">
          <div class="alert alert-danger text-align-center" role="alert">
            <%=request.getAttribute("error") %>
          </div>
        </div>
        
        <%
        request.setAttribute("error", null);
        }
          %>


        <table class="table col-6 offset-3 mt-3">
          <tbody>

            <tr class="table-success">
              <th scope="row">Nick:</th>
              <td><input type="text" name="nick_usuario" id="nameUser" maxlength="20" required="required" autofocus/></td>
            </tr>
            <tr class="table-danger">
              <th scope="row">Password:</th>
              <td><input type="password" name="password_usuario" id="loginPassword"  maxlength="10" required="required"/></td>
            </tr>

            
          </tbody>
        </table>

        <div class="row centrado">
          <div class="   pb-5 pt-4">
            <input type="submit" class=" btn btn-blue mt-2 mb-2 pl-5 pr-5" name="submit" value="Entrar"/>
          </div>
        </div>
        </form>
      
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
    
             <script type="text/javascript">
     // funci�n para validar el formato de nombre, password y confirmacion de password -->
        function validarPassword(){
          var p1 = document.getElementById("loginPassword").value;
          var userName = document.getElementById("nameUser").value;
          var htmlspecialchars = false;
          var cont = 0;
          var maxLenghtName = 20;
          var maxLenghtPassword = 10;

          // Verificamos el formato de nombre -->
          if (maxLenghtName < userName.length) {
            swal('', 'El nombre debe tener 20 caracteres como m�ximo', 'error');
            document.getElementById("nameUser").focus();
            return false;
          }

          while (!htmlspecialchars && (cont < userName.length)) {
            if ((userName.charAt(cont) == " ") || (userName.charAt(cont) == "/") || (userName.charAt(cont) == "\\")
              || (userName.charAt(cont) == "{") || (userName.charAt(cont) == "}")  || (userName.charAt(cont) == "(")
              || (userName.charAt(cont) == ")") || (userName.charAt(cont) == "<") || (userName.charAt(cont) == ">")
              || (userName.charAt(cont) == "'")  || (userName.charAt(cont) == '"') || (userName.charAt(cont) == '[')
              || (userName.charAt(cont) == ']'))
              htmlspecialchars = true;
            cont++;
          }

          if (htmlspecialchars) {
            swal('', 'Los campos no pueden contener espacios en blanco,\nni los siguentes caracteres: / \\ { } ( ) [ ] < > \' "', 'error');
            document.getElementById("nameUser").focus();
            return false;
          }

          // Verificamos el formato de password-->
          var cont = 0;

          if (maxLenghtPassword < p1.length) {
            swal('', 'La contrase�a debe tener 10 caracteres como m�ximo', 'error')
            document.getElementById("loginPassword").focus();
            return false;
          }

          while (!htmlspecialchars && (cont < p1.length)) {
            if ((p1.charAt(cont) == " ") || (p1.charAt(cont) == "/") || (p1.charAt(cont) == "\\")
              || (p1.charAt(cont) == "{") || (p1.charAt(cont) == "}")  || (p1.charAt(cont) == "(")
              || (p1.charAt(cont) == ")") || (p1.charAt(cont) == "<") || (p1.charAt(cont) == ">")
              || (p1.charAt(cont) == "'")  || (p1.charAt(cont) == '"') || (p1.charAt(cont) == '[')
              || (p1.charAt(cont) == ']'))
              htmlspecialchars = true;
            cont ++;
          }

          if (htmlspecialchars) {
        	  swal('', 'Los campos no pueden contener espacios en blanco,\nni los siguentes caracteres: / \\ { } ( ) [ ] < > \' "', 'error');
            document.getElementById("loginPassword").focus();
            return false;
          }
        }
      </script>
    

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <script src="bootstrap/js/bootstrap.js"></script>
    
  </body>
  
</html>