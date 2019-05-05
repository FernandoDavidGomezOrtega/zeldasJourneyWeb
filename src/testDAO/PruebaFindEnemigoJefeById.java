package zeldasjourney;
import zeldasjourney.jdbc.ConnectionDB;

import java.sql.Connection;

import zeldasjourney.dao.PersonajeEnemigoJefeDAO;
import zeldasjourney.personaje.personajesHijo.PersonajeEnemigoJefe;


/**
 * Test of PersonajeEnemigoJefeDAO.findEnemigoJefeById method
 * @author fernando
 *
 */
public class PruebaFindEnemigoJefeById {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		PersonajeEnemigoJefe ej = new PersonajeEnemigoJefe();
		ej.setIDPropia(1);
		
		ConnectionDB cdb = new ConnectionDB();
		Connection con = null;
		PersonajeEnemigoJefeDAO ejdao = null;
		try {
			con = cdb.openConnection();
			ejdao = new PersonajeEnemigoJefeDAO();
			ej = ejdao.findEnemigoJefeById(con, ej);
			
			//mostramos los datos de enemigo jefe
			System.out.println("Los datos enemigo jefe son: \nNombre: " + ej.getNombre());
			System.out.println("\nLos datos enemigo jefe son: \nId: " + ej.getIDPropia());
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


