package zeldasjourney;
import zeldasjourney.jdbc.ConnectionDB;

import java.sql.Connection;

import zeldasjourney.dao.EnemigoComunDAO;

import zeldasjourney.personaje.personajesHijo.EnemigoComun;


/**
 * Test of EnemigoComunDAOfindEnemigoComunById method
 * @author fernando
 *
 */
public class PruebaFindEnemigoComunById {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EnemigoComun ec = new EnemigoComun();
		ec.setIDPropia(2);
		
		ConnectionDB cdb = new ConnectionDB();
		Connection con = null;
		EnemigoComunDAO ecdao = null;
		try {
			con = cdb.openConnection();
			ecdao = new EnemigoComunDAO();
			ec = ecdao.findEnemigoComunById(con, ec);
			
			//mostramos los datos del enemigo comun
			System.out.println("Los datos del enemigo común son:\nNombre: " + ec.getNombre());
			System.out.println("\nLos datos del enemigo común son:\nId: " + ec.getIDPropia());
			System.out.println("\nLos datos del enemigo común son:\nAtaque: " + ec.getAtaque());
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


