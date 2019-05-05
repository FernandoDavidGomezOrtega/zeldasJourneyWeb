package zeldasjourney;

import zeldasjourney.dao.EnemigoComunDAO;
import zeldasjourney.jdbc.ConnectionDB;
import zeldasjourney.personaje.personajesHijo.EnemigoComun;
import java.sql.Connection;

/**
 * Test of EnemigoComunDAO.deleteEnemigoComunById method
 * @author fernando
 *
 */
public class PruebaDeleteEnemigoComunById {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub;
		
		ConnectionDB cdb = new ConnectionDB();
		Connection con = null;
		EnemigoComunDAO ecdao = null;
		EnemigoComun ec = new EnemigoComun();
		ec.setIDPropia(2);
		try {
			con = cdb.openConnection();
			ecdao = new EnemigoComunDAO();
			
			if(ecdao.deleteEnemigoComunById(con, ec) == 1) System.out.println("Enemigo común eliminado con éxito");
			else System.out.println("Error al eliminar enemigo comun");
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

