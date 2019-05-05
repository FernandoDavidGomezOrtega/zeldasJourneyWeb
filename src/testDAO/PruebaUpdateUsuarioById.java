package zeldasjourney;

import java.sql.Connection;

import zeldasjourney.dao.UsuarioDAO;
import zeldasjourney.jdbc.ConnectionDB;
import zeldasjourney.usuario.Usuario;

/**
 * Test of UsuarioDAO.updateUsuarioById()
 * @author fernando
 *
 */
public class PruebaUpdateUsuarioById {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuario u = new Usuario();
		u.setIdUsuario(8);
		
		ConnectionDB cdb = new ConnectionDB();
		Connection con = null;
		UsuarioDAO udao = null;
		try {
			con = cdb.openConnection();
			udao = new UsuarioDAO();
			u = udao.findUsuarioById(con, u);
			
			u.setApellido("lopez");
			
			if (udao.updateUsuarioById(con, u)==1) System.out.println("Actualización del usuario realizada con éxito");
			else System.out.println("Error al atualizar el usuario");
			
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
