package testDAO;
import dao.ConnectionDB;

import java.sql.Connection;

import dao.PersonajeEnemigoJefeDAO;
import entidades.PersonajeEnemigoJefe;

/**
 * Test of PersonajeEnemigoJefeDAO.updateEnemigoJefeById()
 * @author ferando
 *
 */
public class PruebaUpdateEnemigoJefeById {

	public static void main(String[] args) {
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
			
			ej.setFuerza(2);;
			
			if (ejdao.updateEnemigoJefeById(con, ej)==1) System.out.println("Actualización de enemigo jefe realizada con éxito");
			else System.out.println("Error al atualizar enemigo jefe");
			
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
