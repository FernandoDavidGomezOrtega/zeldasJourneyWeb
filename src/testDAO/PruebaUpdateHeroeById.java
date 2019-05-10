package testDAO;
import dao.ConnectionDB;

import java.sql.Connection;

import dao.PersonajeHeroeDAO;
import entidades.PersonajeHeroe;

/**
 * Test of PersonajeHeroeDAO.updateHeroeById()
 * @author casa
 *
 */
public class PruebaUpdateHeroeById {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PersonajeHeroe p = new PersonajeHeroe();
		p.setIDPropia(17);
		
		ConnectionDB cdb = new ConnectionDB();
		Connection con = null;
		PersonajeHeroeDAO pdao = null;
		try {
			con = cdb.openConnection();
			pdao = new PersonajeHeroeDAO();
			p = pdao.findHeroeById(con, p);
			
			p.setFuerza(2);
			
			if (pdao.updateHeroeById(con, p)==1) System.out.println("Actualización de héroe realizada con éxito");
			else System.out.println("Error al atualizar el héroe");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				cdb.closeConnection(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
