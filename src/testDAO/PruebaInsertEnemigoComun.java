package testDAO;
import dao.ConnectionDB;
import java.sql.Connection;
import dao.EnemigoComunDAO;
import entidades.EnemigoComun;

/**
 * Test of EnemigoComunDAO.insertEnemigoComun() method
 * @author fernando
 *
 */
public class PruebaInsertEnemigoComun {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		EnemigoComun ec = new EnemigoComun(2, 1, 0.2, 3, 3, false, true,  4, 0.5, 3, 4,  "Esbirro");
		
		ConnectionDB cdb = new ConnectionDB();
		Connection con = null;
		EnemigoComunDAO ecdao = null;
		//UsuarioDAO udao = null;
		try {
			
			int idEnemigoComun;
			con = cdb.openConnection();
			ecdao = new EnemigoComunDAO();
			idEnemigoComun = ecdao.insertEnemigoComun(con, ec);
			switch(idEnemigoComun) {
			case -1: System.out.println("El nombre de personaje ya existe, ingrese otro"); break;
			case 0: System.out.println("Error al crear enemigo común: "+idEnemigoComun); break;
			default: System.out.println("Enemigo común creado con éxito\nId: "+ idEnemigoComun);
			ec.setIDPropia(idEnemigoComun);
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
