package zeldasjourney;
import zeldasjourney.jdbc.ConnectionDB;

import java.sql.Connection;

import zeldasjourney.dao.PersonajeHeroeDAO;
import zeldasjourney.personaje.personajesHijo.PersonajeHeroe;


/**
 * Testof PersonajeHeroeDAO.findHeroeById() method
 * @author fernando
 *
 */
public class PruebaFindHeroeById {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		PersonajeHeroe p = new PersonajeHeroe();
		p.setIDPropia(8);
		
		ConnectionDB cdb = new ConnectionDB();
		Connection con = null;
		PersonajeHeroeDAO pdao = null;
		try {
			con = cdb.openConnection();
			pdao = new PersonajeHeroeDAO();
			p = pdao.findHeroeById(con, p);
			
			//mostramos los datos del heroe
			System.out.println("Los datos del heroe son: \nNombre: " + p.getNombre());
			System.out.println("\nLos datos del heroe son: \nId: " + p.getIDPropia());
			//cdb.closeConnection(con);
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

