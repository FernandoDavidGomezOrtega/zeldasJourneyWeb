<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.net.*" %>
    <%
    //Verificacion de variable de sesión login
    if(request.getSession().getAttribute("login") == null){ 
    	
    	String url ="/index.jsp"; 
    	RequestDispatcher rd = request.getServletContext().getRequestDispatcher(url);
     	rd.forward(request, response);
    	}

    
    	request.getSession().setAttribute("login", null);
    	
    RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/index.jsp");
 	rd.forward(request, response);
    %>