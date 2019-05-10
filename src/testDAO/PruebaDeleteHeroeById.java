package testDAO;
import dao.ConnectionDB;

import java.sql.Connection;

import dao.PersonajeHeroeDAO;
import entidades.PersonajeHeroe;

/**
 * Test of PersonajeHeroeDAO.deleteHeroeById method
 * @author casa
 *
 */
public class PruebaDeleteHeroeById {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		PersonajeHeroe p = new PersonajeHeroe();
		p.setIDPropia(1);
		
		ConnectionDB cdb = new ConnectionDB();
		Connection con = null;
		PersonajeHeroeDAO pdao = null;
		try {
			con = cdb.openConnection();
			pdao = new PersonajeHeroeDAO();
			if (pdao.deleteHeroeById(con, p) == 1)
				System.out.println("Héroe borrado con éxito");
			else System.out.println("Error al borrar el héroe");
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
