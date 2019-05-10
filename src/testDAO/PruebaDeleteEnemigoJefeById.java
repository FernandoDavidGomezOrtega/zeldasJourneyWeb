package testDAO;
import dao.ConnectionDB;

import java.sql.Connection;

import dao.PersonajeEnemigoJefeDAO;
import entidades.PersonajeEnemigoJefe;

/**
 * Test of PersonajeEnemigojefeDAO.deleteEnemigoJefeById method
 * @author fernando
 *
 */
public class PruebaDeleteEnemigoJefeById {

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
			if (ejdao.deleteEnemigoJefeById(con, ej) == 1)
				System.out.println("Enemigo jefe borrado con éxito");
			else System.out.println("Error al borrar enemigo jefe");
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
