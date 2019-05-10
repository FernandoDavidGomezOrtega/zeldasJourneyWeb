package testDAO;
import dao.ConnectionDB;
import entidades.Usuario;
import java.sql.Connection;
import dao.PersonajeHeroeDAO;
import dao.UsuarioDAO;
import entidades.PersonajeHeroe;

/**
 * Test of PersonajeHeroeDAO.insertHeroe()
 * @author fernando
 *
 */
public class PruebaInsertHeroe {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Usuario u = new Usuario ();
		/*
		u.setFechaIngreso(new java.sql.Date(2019, 4, 25));
		u.setNick("dante");

		u.setNombre("diego");
		u.setPassword("asd12");
		
		u.setApellido("herrera");
		u.setPersonajes(new ArrayList<PersonajeHeroe>());
		*/
		PersonajeHeroe p = new PersonajeHeroe();
		p.setNombre("SuperWoman");
		p.setAtaque(3.5);
		p.setExperiencia(0);
		p.setFuerza(2);
		p.setMovimiento(10);
		p.setMovimientoTurno(2);
		p.setMuerto(false);
		p.setNAtaques(3);
		p.setResistencia(10);
		p.setSuperAtaque(2);
		p.setTurno(false);
		p.setAvatarHeroe("../../../../images/heroes/superWomanBlack.jpg");
		
		ConnectionDB cdb = new ConnectionDB();
		Connection con = null;
		PersonajeHeroeDAO pdao = null;
		UsuarioDAO udao = null;
		try {
			
			int idHeroe;
			con = cdb.openConnection();
			pdao = new PersonajeHeroeDAO();
			udao = new UsuarioDAO();
			u.setNick("zaya");
			u = udao.findUsuarioByNick(con, u);
			idHeroe = pdao.insertHeroe(con, p, u);
			switch(idHeroe) {
			case -1: System.out.println("El nombre de personaje ya existe, ingrese otro"); break;
			case 0: System.out.println("Error al crear el Héroe" ); break;
			default: System.out.println("Héroe creado con éxito\nId: "+ idHeroe);
			u.getPersonajes().add(p);
			p.setUsuario(u);
			p.setIDPropia(idHeroe);
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
