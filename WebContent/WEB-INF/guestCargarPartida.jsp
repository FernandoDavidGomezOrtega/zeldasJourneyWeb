<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.net.*" %>
<%@page import="dao.PersonajeHeroeDAO" %>
<%@page import="dao.ConnectionDB" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.util.Date" %>
<%@page import="entidades.Usuario" %>
<%@page import="dao.UsuarioDAO" %>
<%@page import="entidades.PersonajeHeroe" %>

<%
//Verificacion de variable de sesión login
if(request.getSession().getAttribute("login") != null){ 
	
	String url ="/createOrSelect.jsp"; 
	RequestDispatcher rd = request.getServletContext().getRequestDispatcher(url);
 	rd.forward(request, response);
	}

%>

	<%
	
	ConnectionDB con = new ConnectionDB();
	Connection c = con.openConnection();
	PersonajeHeroeDAO hdao = new PersonajeHeroeDAO();
	
	
	Usuario u = new Usuario();
	u.setNombre("Invitado");
	u.setApellido("1");
	u.setNick("Invitado");
	u.setIdUsuario(1);
	u.setPassword("12");
	
	int idPlantilla = Integer.parseInt(request.getParameter("id_plantilla"));
	
	PersonajeHeroe h = hdao.insertHeroeFromTemplate(c, u, idPlantilla);
	
	u.getPersonajes().add(h);
	
	
	
	
	
	
	
	String url="";
	url ="/guestStage1.jsp"; 
	RequestDispatcher rd = request.getServletContext().getRequestDispatcher(url);
 	rd.forward(request, response);
 	
 	 
	%>
