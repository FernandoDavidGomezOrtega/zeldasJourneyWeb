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
 	u.setNick(request.getParameter("nick_usuario"));
 	u = udao.findUsuarioByNick(con, u);
 	
 	if(u == null){
 		u = new Usuario();
 		u.setNombre(request.getParameter("nombre_usuario"));
 		u.setApellido(request.getParameter("apellido_usuario"));
 		u.setNick(request.getParameter("nick_usuario"));
 		u.setPassword(request.getParameter("password_usuario"));
 		int idUsuario = udao.insertUsuario(con, u);
 		if(idUsuario <= 0){
 			error = "Se ha producido un error interno. Prueba de nuevo";
 			request.setAttribute("error", error );
 			url ="/signup.jsp";
 		} else {
 			
 			u.setIdUsuario(idUsuario);
 			
 			u = udao.findUsuarioByNick(con, u);
 			
 			request.getSession().setAttribute("login", u);
 			 url ="/createOrSelect.jsp";
 			
 		}
 		
 	} else {
 		error = "El nick ya existe. Ingresa otro por favor";
			request.setAttribute("error", error );
 		url="/signup.jsp";
 	}
 	RequestDispatcher rd = request.getServletContext().getRequestDispatcher(url);
 	rd.forward(request, response);
%>
