package dao;

import entidades.PersonajeHeroe;
import entidades.Usuario;

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
			stmt = c.prepareStatement("INSERT INTO HEROE( HEROE_ID_USUARIO, HEROE_ATAQUE, "+
		"HEROE_EXPERIENCIA, movimiento, movimientoTurno, muerto, n_ataques, nombre, resistencia,"+
					" turno, vida, vida_gastar, Super_ataque, fuerza, avatar_HEROE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
			
			ResultSet rs = stmt2.executeQuery("SELECT MAX(id_heroe) FROM HEROE");
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
	
	
public PersonajeHeroe insertHeroeFromTemplate(Connection c, Usuario u, int idPlantilla) throws Exception {
		
		PreparedStatement stmt = null;
		Statement stmt2=null;
		int result = 0;
		PreparedStatement pstmt = null;
		PersonajeHeroe h = null;
		try {
			pstmt = c.prepareStatement("select * from plantilla_heroe where id_plantilla =?");
			pstmt.setInt(1, idPlantilla);
			
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			
			stmt = c.prepareStatement("INSERT INTO HEROE( HEROE_ID_USUARIO, HEROE_ATAQUE, "+
		"HEROE_EXPERIENCIA, movimiento, movimientoTurno, muerto, n_ataques, nombre, resistencia,"+
					" turno, vida, vida_gastar, Super_ataque, fuerza, avatar_heroe, id_plantilla,super_poder_1, super_poder_2, descripcion) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setInt(1, u.getIdUsuario());
			stmt.setDouble(2, rs.getDouble("HEROE_ATAQUE") );
			stmt.setInt(3, 0);
			stmt.setInt(4,  rs.getInt("movimiento"));
			stmt.setInt(5,  rs.getInt("movimientoTurno"));
			stmt.setInt(6,  0);
			stmt.setInt(7, rs.getInt("n_ataques"));
			stmt.setString(8,  rs.getString("nombre"));
			stmt.setDouble(9,  rs.getDouble("resistencia"));
			stmt.setInt(10, 1 );
			stmt.setInt(11, rs.getInt("vida"));
			stmt.setInt(12,  rs.getInt("vida_gastar"));
			stmt.setInt(13, rs.getInt("super_ataque"));
			stmt.setInt(14, rs.getInt("fuerza"));
			stmt.setString(15,  rs.getString("avatar_heroe"));
			stmt.setInt(16, rs.getInt("id_plantilla"));
			stmt.setString(17, rs.getString("super_poder_1"));
			stmt.setString(18, rs.getString("super_poder_2"));
			stmt.setString(19, rs.getString("descripcion"));
			
			stmt.executeUpdate();
			
			h = new PersonajeHeroe();
			h.setAtaque(rs.getDouble("HEROE_ATAQUE"));
			h.setExperiencia(0);
			h.setMovimiento(rs.getInt("movimiento"));
			h.setMovimientoTurno(rs.getInt("movimientoTurno"));
			h.setMuerto(false);
			h.setNAtaques(rs.getInt("n_ataques"));
			h.setNombre(rs.getString("nombre"));
			h.setResistencia(rs.getDouble("resistencia"));
			h.setTurno(true);
			h.setVida(rs.getInt("vida"));
			h.setVidaGastar(rs.getInt("vida_gastar"));
			h.setSuperAtaque(rs.getInt("super_ataque"));
			h.setFuerza(rs.getInt("fuerza"));
			h.setAvatarHeroe(rs.getString("avatar_heroe"));
			h.setSuperPoder1(rs.getString("super_poder_1"));
			h.setSuperPoder2(rs.getString("super_poder_2"));
			
			stmt2 = c.createStatement();
			
			rs = stmt2.executeQuery("SELECT MAX(id_heroe) FROM heroe");
			rs.next();
			result = rs.getInt(1);
			
			h.setIDPropia(result);
			
			
			
			
		} catch(SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
	
		}catch (SQLException e) {
			e.printStackTrace();
	
		}
		try {
			if (stmt!=null) stmt.close(); //cerramos el Statement
		} catch (final SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return h;
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
	             stmt = c.prepareStatement("UPDATE HEROE SET HEROE_ATAQUE=?,HEROE_EXPERIENCIA=?,"+
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
	                        
	            stmt = c.prepareStatement("SELECT * FROM HEROE WHERE id_heroe=?");
	            stmt.setInt(1,p.getIDPropia());
	            rs =stmt.executeQuery();
	            //while (rs.next()) {
	               // personaje=new PersonajeHeroe();
	              // getHeroeRow(rs,personaje);
	               
               if(rs.next()) {
	               p.setAtaque(rs.getDouble("HEROE_ATAQUE"));
	               p.setExperiencia(rs.getInt("HEROE_EXPERIENCIA"));
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
	               u.setIdUsuario(rs.getInt("HEROE_ID_USUARIO"));
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
	
	
	
	public PersonajeHeroe findHeroeByIdPlantillaInPlantillaHeroe(Connection c, int idPlantilla ) throws Exception
	{
		
	    PreparedStatement stmt=null;
	    ResultSet rs=null;
	    PersonajeHeroe p = new PersonajeHeroe();
	    try {
	                        
	            stmt = c.prepareStatement("SELECT * FROM plantilla_heroe WHERE id_plantilla=?");
	            stmt.setInt(1, idPlantilla);
	            rs =stmt.executeQuery();
	            //while (rs.next()) {
	               // personaje=new PersonajeHeroe();
	              // getHeroeRow(rs,personaje);
	               
               if(rs.next()) {
	               p.setAtaque(rs.getDouble("HEROE_ATAQUE"));
	               p.setExperiencia(rs.getInt("HEROE_EXPERIENCIA"));
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
	               p.setAvatarHeroe(rs.getString("avatar_heroe"));
	               
	               
	               //UsuarioDAO udao = new UsuarioDAO();
	               //Usuario u = new Usuario();
	               //u.setIdUsuario(rs.getInt("HEROE_ID_USUARIO"));
	               //u = udao.findUsuarioById(c, u);
	               
	               //p.setUsuario(u);
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
	            stmt = c.prepareStatement("DELETE FROM HEROE WHERE id_heroe=?");
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
