package zeldasjourney;

import zeldasjourney.dao.UsuarioDAO;
import zeldasjourney.jdbc.ConnectionDB;
import zeldasjourney.usuario.Usuario;
import java.sql.Connection;

/**
 * Test of UsuarioDAO.deleteUsuarioById method
 * @author fernando
 *
 */
public class PruebaDeleteUsuarioById {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub;
		
		ConnectionDB cdb = new ConnectionDB();
		Connection con = null;
		UsuarioDAO udao = null;
		Usuario u = new Usuario();
		u.setIdUsuario(24);
		try {
			con = cdb.openConnection();
			udao = new UsuarioDAO();
			
			if(udao.deleteUsuarioById(con, u) == 1) System.out.println("Usuario eliminado con éxito");
			else System.out.println("Error al eliminar el usuario");
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

