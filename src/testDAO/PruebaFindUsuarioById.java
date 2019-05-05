package zeldasjourney;
import zeldasjourney.jdbc.ConnectionDB;

import java.sql.Connection;

import zeldasjourney.dao.UsuarioDAO;
import zeldasjourney.usuario.Usuario;

/**
 * Test of UsuarioDAO.findUsuarioById() method
 * @author fernando
 *
 */
public class PruebaFindUsuarioById {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Usuario u = new Usuario();
		u.setIdUsuario(10);
		
		ConnectionDB cdb = new ConnectionDB();
		Connection con = null;
		UsuarioDAO udao = null;
		try {
			con = cdb.openConnection();
			udao = new UsuarioDAO();
			u = udao.findUsuarioById(con, u);
			
			//mostramos los datos de Usuario
			System.out.println("Los datos del usuario son:\nNick: " + u.getNick());
			System.out.println("\nLos datos del usuario son:\nIdUsuario: " + u.getIdUsuario());
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


