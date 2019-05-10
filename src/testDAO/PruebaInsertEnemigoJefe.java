package testDAO;
import dao.ConnectionDB;
import java.sql.Connection;
import dao.PersonajeEnemigoJefeDAO;
import entidades.PersonajeEnemigoJefe;

/**
 * Test of PersonajeEnemigoJefeDAO.insertPersonajeEnemigoJefe()
 * @author fernando
 *
 */
public class PruebaInsertEnemigoJefe {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		

		PersonajeEnemigoJefe ej = new PersonajeEnemigoJefe(2, 2.2, 3, 3.2, 5, "Frankenstein", 2 );
		
		ConnectionDB cdb = new ConnectionDB();
		Connection con = null;
		PersonajeEnemigoJefeDAO ejdao = null;
		
		try {
			
			int idEnemigoJefe;
			con = cdb.openConnection();
			ejdao = new PersonajeEnemigoJefeDAO();
			idEnemigoJefe = ejdao.insertPersonajeEnemigoJefe(con, ej);
			switch(idEnemigoJefe) {
			case -1: System.out.println("El nombre de enemigo jefe ya existe, ingrese otro"); break;
			case 0: System.out.println("Error al crear enemigo jefe" ); break;
			default: System.out.println("Enemigo jefe creado con éxito\nId: "+ idEnemigoJefe);
			
			
			ej.setIDPropia(idEnemigoJefe);
			break;
			}
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
