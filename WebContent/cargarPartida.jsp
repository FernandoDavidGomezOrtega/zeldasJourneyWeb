<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.net.*" %>
<%@page import="dao.PersonajeHeroeDAO" %>
<%@page import="dao.ConnectionDB" %>
<%@page import="java.sql.Connection" %>
<%@page import="entidades.Usuario" %>
<%@page import="dao.UsuarioDAO" %>
<%@page import="entidades.PersonajeHeroe" %>
<%
//Verificacion de variable de sesión login
if(request.getSession().getAttribute("login") == null){ 
	
	String url ="/index.jsp"; 
	RequestDispatcher rd = request.getServletContext().getRequestDispatcher(url);
 	rd.forward(request, response);
	}

%>

	<%
	int idPlantilla = Integer.parseInt(request.getParameter("id_plantilla"));
	
	ConnectionDB con = new ConnectionDB();
	Connection c = con.openConnection();
	PersonajeHeroeDAO hdao = new PersonajeHeroeDAO();
	
	
	Usuario u = (Usuario)request.getSession().getAttribute("login");
	
	PersonajeHeroe hero = hdao.insertHeroeFromTemplate(c, u, idPlantilla);
	
	//creamos el heroe como variable de sesion
		request.getSession().setAttribute("hero", hero);
	
	u.getPersonajes().add(hero);
	
	
	
	
	
	
	
	String url="";
	url ="/stage1.jsp"; 
	RequestDispatcher rd = request.getServletContext().getRequestDispatcher(url);
 	rd.forward(request, response);
 	
 	 
	%>
