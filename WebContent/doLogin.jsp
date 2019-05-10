<%@page import="dao.ConnectionDB"%>
<%@page import="java.sql.Connection"%>

<%@page import="entidades.Usuario" %>
<%@page import="dao.UsuarioDAO" %>
<%@page import="java.net.*" %>

<%
	ConnectionDB c = new ConnectionDB();
    Connection con = c.openConnection();
	String error = "";
	String url ="";
	
	
    Usuario u = new Usuario();
    UsuarioDAO udao = new UsuarioDAO();
    
    //u.setPassword(request.getParameter("password_usuario"));
    
 	u.setNick(request.getParameter("nick_usuario"));
 	u = udao.findUsuarioByNick(con, u);
 	
 	
 	
 	//System.out.println( "get  password = "+ u.getPassword() );
 	//System.out.println( "variable  password = "+ u.getPassword() );
 	
 	//System.out.println("request password="+ request.getParameter("password_usuario"));
 	//System.out.println("variable confirmar password="+ request.getParameter("password_usuario"));
 	if(u != null){
 		String password = (String)u.getPassword();
 		String confirmarPassword = request.getParameter("password_usuario");
 		
		if(password.equals(confirmarPassword)){
 			
 			
 			request.getSession().setAttribute("login", u);
 			
 			 url ="/createOrSelect.jsp";
 		}
 		else {
 			
 			
 			error = "Los datos introducidos son incorrectos";
			request.setAttribute("error", error );
 		url="/login.jsp";
 		}
 		
 		
 	
 		
 	} else {
 		error = "Los datos introducidos son incorrectos";
			request.setAttribute("error", error );
 		url="/login.jsp";
 	}
 	RequestDispatcher rd = request.getServletContext().getRequestDispatcher(url);
 	rd.forward(request, response);
%>
