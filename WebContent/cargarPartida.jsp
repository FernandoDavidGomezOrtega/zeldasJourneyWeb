<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.net.*" %>
<%@page import="dao.PersonajeHeroeDAO" %>
<%@page import="dao.ConnectionDB" %>
<%@page import="java.sql.Connection" %>
<%@page import="entidades.Usuario" %>
<%@page import="dao.UsuarioDAO" %>
<%@page import="entidades.PersonajeHeroe" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	int idPlantilla = Integer.parseInt(request.getParameter("id_plantilla"));
	
	ConnectionDB con = new ConnectionDB();
	Connection c = con.openConnection();
	PersonajeHeroeDAO hdao = new PersonajeHeroeDAO();
	
	
	Usuario u = (Usuario)request.getSession().getAttribute("login");
	
	PersonajeHeroe h = hdao.insertHeroeFromTemplate(c, u, idPlantilla);
	
	u.	
	
	
	
	
	
	
	String url="";
	url ="/stage1.jsp"; 
	RequestDispatcher rd = request.getServletContext().getRequestDispatcher(url);
 	rd.forward(request, response);
 	
 	 
	%>
</body>
</html>