
    
    
<%@page import="entidades.Usuario" %>

<%@ page import="entidades.*" %>
<%@ page import="dao.*" %>
<%@ page import="java.sql.*" %>

<%
PersonajeHeroeDAO DAO=new PersonajeHeroeDAO();

ConnectionDB cdb= new ConnectionDB();

Connection con = null;

con = cdb.openConnection();

int id= ((PersonajeHeroe) request.getSession().getAttribute("idHeroe")).getIDPropia();

PersonajeHeroe Heroe1 = new PersonajeHeroe();

Heroe1.setIDPropia(id);

Heroe1= DAO.findHeroeById(con, Heroe1);

PersonajeHeroe Heroe2 = new PersonajeHeroe();

Heroe2.setIDPropia(3);

Heroe2=Heroe1= DAO.findHeroeById(con, Heroe2);

for (int i=0; i<3; i++){
	
	Heroe1.ataque(Heroe2);	
	Heroe1.pasarTurno();
	
	Heroe2.ataque(Heroe1);
	Heroe2.pasarTurno();
	
}


Heroe1.setAtaque(1);
Heroe1.setFuerza(1);
Heroe1.setVida(5);
Heroe1.setNAtaques(1);

response.sendRedirect("stage1.jsp");


%>

