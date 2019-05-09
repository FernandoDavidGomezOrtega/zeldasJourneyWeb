<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.net.*" %>
    <%
    	request.getSession().setAttribute("login", null);
    	
    RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/index.jsp");
 	rd.forward(request, response);
    %>