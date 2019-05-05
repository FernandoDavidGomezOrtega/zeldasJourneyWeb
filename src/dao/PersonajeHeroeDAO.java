package zeldasjourney.dao;

import zeldasjourney.personaje.personajesHijo.PersonajeHeroe;
import zeldasjourney.usuario.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;


/**
 * DAO for object PersonajeHeroe
 * @author fernando
 *
 */
public class PersonajeHeroeDAO {
	
	
	/**
	 * Method to insert object PersonajeHeroe into DB
	 * @param c type Connection
	 * @param p type PersonajeHeroe
	 * @param u type Usuario
	 * @return result type int
	 */
	@SuppressWarnings("finally")
	public int insertHeroe(Connection c, PersonajeHeroe p, Usuario u) throws Exception {
		
		PreparedStatement stmt = null;
		Statement stmt2=null;
		int result = 0;
		try {
			stmt = c.prepareStatement("INSERT INTO Heroe( FK_ID_Usuario, ataque, "+
		"experiencia, movimiento, movimientoTurno, muerto, n_ataques, nombre, resistencia,"+
					" turno, vida, vida_gastar, Super_ataque, fuerza, avatar_heroe) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setInt(1, u.getIdUsuario());
			stmt.setDouble(2, p.getAtaque() );
			stmt.setInt(3, p.getExperiencia());
			stmt.setInt(4,  p.getMovimiento());
			stmt.setInt(5,  p.getMovimientoTurno());
			stmt.setInt(6,  (p.getMuerto()?1:0));
			stmt.setInt(7, p.getNAtaques());
			stmt.setString(8,  p.getNombre());
			stmt.setDouble(9,  p.getResistencia());
			stmt.setInt(10, (p.getTurno()?1:0) );
			stmt.setInt(11, p.getVida());
			stmt.setInt(12,  p.getVidaTurno());
			stmt.setInt(13, p.getSuperAtaques());
			stmt.setInt(14, p.getFuerza());
			stmt.setString(15,  p.getAvatarHeroe());
			
			stmt.executeUpdate();
			
			stmt2 = c.createStatement();
			
			ResultSet rs = stmt2.executeQuery("SELECT MAX(id_heroe) FROM heroe");
			rs.next();
			result = rs.getInt(1);
			
			
		} catch(SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			result = -1;
		}catch (SQLException e) {
			e.printStackTrace();
			result= -2;
		}finally {
			try {
				if (stmt!=null) stmt.close(); //cerramos el Statement
			} catch (final SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
	}
	
	
	/**
	 * Method to update PersonajeHeroe in DB
	 * @param c : Connection
	 * @param p: PersonajeHeroe
	 * @return result: int
	 * @throws Exception
	 */
	@SuppressWarnings("finally")
	public int updateHeroeById(Connection c, PersonajeHeroe p) throws Exception {
		int result = 1;
		 PreparedStatement stmt=null;           
	       try {
	             stmt = c.prepareStatement("UPDATE heroe SET ataque=?,experiencia=?,"+
	                    "movimiento=?,movimientoTurno=?,muerto=?,n_ataques=?,nombre=?, resistencia=?, turno=?, vida=?, vida_gastar=?, Super_ataque=?, fuerza=? WHERE id_heroe=?");
				stmt.setDouble(1, p.getAtaque() );
				stmt.setInt(2, p.getExperiencia());
				stmt.setInt(3,  p.getMovimiento());
				stmt.setInt(4,  p.getMovimientoTurno());
				stmt.setInt(5,  (p.getMuerto()?1:0));
				stmt.setInt(6, p.getNAtaques());
				stmt.setString(7,  p.getNombre());
				stmt.setDouble(8,  p.getResistencia());
				stmt.setInt(9, (p.getTurno()?1:0) );
				stmt.setInt(10, p.getVida());
				stmt.setInt(11,  p.getVidaTurno());
				stmt.setInt(12, p.getSuperAtaques());
				stmt.setInt(13,  p.getFuerza());
				stmt.setInt(14,  p.getIDPropia());
				
	            stmt.executeUpdate(); 
	            
	        } catch (SQLIntegrityConstraintViolationException e) {
				e.printStackTrace();
				result = -1;
			}catch (SQLException e) {
				
				e.printStackTrace();
				result =0;
			}finally {
				try {
					if (stmt!=null) stmt.close(); //cerramos el Statement
				} catch (final SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return result;
			}
	}
	
	
	/**
	 * Method to read data of PersonajeHeroe in DB
	 * @param c: Connection
	 * @param p: PersonajeHeroe
	 * @return p: PersonajeHeroe
	 * @throws Exception
	 */
	public PersonajeHeroe findHeroeById(Connection c,PersonajeHeroe p) throws Exception
	{
		
	    PreparedStatement stmt=null;
	    ResultSet rs=null;
	    try {
	                        
	            stmt = c.prepareStatement("SELECT * FROM heroe WHERE id_heroe=?");
	            stmt.setInt(1,p.getIDPropia());
	            rs =stmt.executeQuery();
	            //while (rs.next()) {
	               // personaje=new PersonajeHeroe();
	              // getHeroeRow(rs,personaje);
	               
               if(rs.next()) {
	               p.setAtaque(rs.getDouble("ataque"));
	               p.setExperiencia(rs.getInt("experiencia"));
	               p.setFuerza(rs.getInt("fuerza"));
	               p.setMovimiento(rs.getInt("movimiento"));
	               p.setMovimientoTurno(rs.getInt("movimientoturno"));
	               boolean aux = rs.getInt("muerto")==1;
	               p.setMuerto(aux);
	               p.setNAtaques(rs.getInt("n_ataques"));
	               p.setNombre(rs.getString("nombre"));
	               p.setResistencia(rs.getDouble("resistencia"));
	               p.setSuperAtaque(rs.getInt("super_ataque"));
	               aux = rs.getInt("turno")==1;
	               p.setTurno(aux);
	               
	               UsuarioDAO udao = new UsuarioDAO();
	               Usuario u = new Usuario();
	               u.setIdUsuario(rs.getInt("fk_id_usuario"));
	               u = udao.findUsuarioById(c, u);
	               
	               p.setUsuario(u);
	            } else p = null;                    
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }finally
	        {
	            if (rs != null) rs.close(); //Cerramos el resulset
	            if (stmt != null) stmt.close();//Cerramos el Statement   
	        }
	    return p;
	}
	
	
	/**
	 * Method to delete PersonajeHeroe from DB
	 * @param c: Connection
	 * @param p: PersonajeHeroe
	 * @return result: int
	 * @throws Exception
	 */
	@SuppressWarnings("finally")
	public int deleteHeroeById(Connection c,PersonajeHeroe p) throws Exception {   
		PreparedStatement stmt=null; 
		int result = 0;
	    try {
	            stmt = c.prepareStatement("DELETE FROM heroe WHERE id_heroe=?");
	            stmt.setInt(1, p.getIDPropia());
	            
	            stmt.executeUpdate();
	            result = 1;
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally
	        {
	            if (stmt != null) stmt.close();//Cerramos el Statement
	            return result;
	        }    
	}
	
}
