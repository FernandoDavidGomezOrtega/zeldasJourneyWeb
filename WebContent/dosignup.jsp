<%@page import="dao.ConnectionDB"%>
<%@page import="java.sql.Connection"%>
<%

	ConnectionDB c = new ConnectionDB();
    Connection con = c.openConnection();

 	
%>
