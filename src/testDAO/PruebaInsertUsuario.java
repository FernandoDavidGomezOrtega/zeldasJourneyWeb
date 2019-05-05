package testDAO;
import entidades.Usuario;

import java.sql.Connection;
import java.util.ArrayList;

//import zeldasjourney.dao.PersonajeHeroeDAO;
import dao.UsuarioDAO;
import dao.ConnectionDB;
import entidades.PersonajeHeroe;

/**
 * Test of UsuarioDAO.insertUsuario()
 * @author casa
 *
 */
public class PruebaInsertUsuario {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int idUsuario;
		Usuario u = new Usuario ();
		u.setApellido("Herrera");
		u.setFechaIngreso(new java.sql.Date(2019, 4, 25));
		u.setNick("chahi");
		u.setNombre("pepe");
		u.setPassword("pp");
		u.setPersonajes(new ArrayList<PersonajeHeroe>());
		
		ConnectionDB cdb = new ConnectionDB();
		Connection con = null;
		UsuarioDAO udao = null;
		try {
			con = cdb.openConnection();
			udao = new UsuarioDAO();
			
			switch(idUsuario = udao.insertUsuario(con, u)) {
			case -1: System.out.println("El nick de usuario ya existe, ingrese otro"); break;
			case 0: System.out.println("Error al crear el usuario"); break;
			default: System.out.println("Usuario creado con éxito");
			u.setIdUsuario(idUsuario);
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
