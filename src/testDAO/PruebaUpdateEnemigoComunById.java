package testDAO;
import dao.ConnectionDB;

import java.sql.Connection;
import dao.EnemigoComunDAO;
import entidades.EnemigoComun;

/**
 * Test of EnemigoComunDAO.updateEnemigoComunById()
 * @author fernando
 *
 */
public class PruebaUpdateEnemigoComunById {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		EnemigoComun ec= new EnemigoComun();
		ec.setIDPropia(2);
		
		ConnectionDB cdb = new ConnectionDB();
		Connection con = null;
		EnemigoComunDAO ecdao = null;
		try {
			con = cdb.openConnection();
			ecdao = new EnemigoComunDAO();
			ec = ecdao.findEnemigoComunById(con, ec);
			
			ec.setNombre("soldado");
			
			if (ecdao.updateEnemigoComunById(con, ec)==1) System.out.println("Actualización de enemigo común realizada con éxito");
			else System.out.println("Error al atualizar enemigo común");
			
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
