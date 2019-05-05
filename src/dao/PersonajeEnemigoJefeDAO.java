package dao;

import entidades.PersonajeEnemigoJefe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;


/**
 * DAO for object PersonajeEnemigoJefe
 * @author fernando
 *
 */
public class PersonajeEnemigoJefeDAO {
	
	
	/**
	 * Método para insertar PersonajeEnemigoJefe en la DB
	 * @param c type Connection
	 * @param ej type PersonajeEnemigoJefe
	 * @return int result
	 * @throws Exception
	 */
	@SuppressWarnings("finally")
	public int insertPersonajeEnemigoJefe(Connection c, PersonajeEnemigoJefe ej) throws Exception  {
		
		PreparedStatement stmt = null;
		Statement stmt2=null;
		int result = 0;
		try {
			stmt = c.prepareStatement("INSERT INTO enemigo_jefe( ataque, experiencia,"+
		" movimiento, movimientoTurno, muerto, n_ataques, nombre, resistencia, turno,"+
					" vida, vida_gastar, Super_ataque, fuerza) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setDouble(1, ej.getAtaque());
			stmt.setInt(2, ej.getExperiencia() );
			stmt.setInt(3, ej.getMovimiento());
			stmt.setInt(4,  ej.getMovimientoTurno());
			stmt.setInt(5,  (ej.getMuerto() ? 1 : 0));
			stmt.setInt(6,  ej.getNAtaques());
			stmt.setString(7, ej.getNombre());
			stmt.setDouble(8,  ej.getResistencia());
			stmt.setInt(9,  (ej.getTurno()?1:0));
			stmt.setInt(10, ej.getVida());
			stmt.setInt(11, ej.getVidaTurno());
			stmt.setInt(12,  ej.getSuperAtaques());
			stmt.setInt(13, ej.getFuerza());
			
			stmt.executeUpdate();
			
			stmt2 = c.createStatement();
			
			ResultSet rs = stmt2.executeQuery("SELECT MAX(id_enemigo_jefe) FROM enemigo_jefe");
			rs.next();
			result = rs.getInt(1);
			
			
		} catch(SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			result = -1;
		}catch (SQLException e) {
			e.printStackTrace();
			result = -2;
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
	 * Methos for insert PersonajeEnemigoJefe into DB
	 * @param c type Connection
	 * @param ej type PersonajeEnemigoJefe
	 * @return int result
	 * @throws Exception
	 */
	@SuppressWarnings("finally")
	public int updateEnemigoJefeById(Connection c, PersonajeEnemigoJefe ej) throws Exception {
		int result = 1;
		 PreparedStatement stmt=null;           
	       try {
	             stmt = c.prepareStatement("UPDATE enemigo_jefe SET ataque=?,experiencia=?,"+
	                    "movimiento=?,movimientoTurno=?,muerto=?,n_ataques=?,nombre=?,"+
	            		 " resistencia=?, turno=?, vida=?, vida_gastar=?, Super_ataque=?,"+
	                    " fuerza=? WHERE id_enemigo_jefe=?");
				stmt.setDouble(1, ej.getAtaque() );
				stmt.setInt(2, ej.getExperiencia());
				stmt.setInt(3,  ej.getMovimiento());
				stmt.setInt(4,  ej.getMovimientoTurno());
				stmt.setInt(5,  (ej.getMuerto()?1:0));
				stmt.setInt(6, ej.getNAtaques());
				stmt.setString(7,  ej.getNombre());
				stmt.setDouble(8,  ej.getResistencia());
				stmt.setInt(9, (ej.getTurno()?1:0) );
				stmt.setInt(10, ej.getVida());
				stmt.setInt(11,  ej.getVidaTurno());
				stmt.setInt(12, ej.getSuperAtaques());
				stmt.setInt(13,  ej.getFuerza());
				stmt.setInt(14,  ej.getIDPropia());
				
	            stmt.executeUpdate(); 
	            
	        } catch (SQLIntegrityConstraintViolationException e) {
	        	e.printStackTrace();
				result = -1;
			}catch (SQLException e) {
				result =0;
				e.printStackTrace();
				result = -2;
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
	 * Method to read data of PersonajeEnemigoJefe in DB
	 * @param c type Connection
	 * @param ej type PersonajeEnemigoJefe
	 * @return ej type PersonajeEnemigJefe
	 * @throws Exception
	 */
	public PersonajeEnemigoJefe findEnemigoJefeById(Connection c,PersonajeEnemigoJefe ej) throws Exception
	{
		
	    PreparedStatement stmt=null;
	    ResultSet rs=null;
	    try {
	                        
	            stmt = c.prepareStatement("SELECT * FROM enemigo_jefe WHERE id_enemigo_jefe=?");
	            stmt.setInt(1,ej.getIDPropia());
	            rs =stmt.executeQuery();
	            //while (rs.next()) {
	               // personaje=new PersonajeHeroe();
	              // getHeroeRow(rs,personaje);
	               
               if(rs.next()) {
	               ej.setAtaque(rs.getInt("ataque"));
	               ej.setExperiencia(rs.getInt("experiencia"));
	               ej.setFuerza(rs.getInt("fuerza"));
	               ej.setMovimiento(rs.getInt("movimiento"));
	               ej.setMovimientoTurno(rs.getInt("movimientoturno"));
	               boolean aux = rs.getInt("muerto")==1;
	               ej.setMuerto(aux);
	               ej.setNAtaques(rs.getInt("n_ataques"));
	               ej.setNombre(rs.getString("nombre"));
	               ej.setResistencia(rs.getDouble("resistencia"));
	               ej.setSuperAtaque(rs.getInt("super_ataque"));
	               aux = rs.getInt("turno")==1;
	               ej.setTurno(aux);
	               ej.setVida(rs.getInt("vida"));
	               ej.setVidaGastar(rs.getInt("vida_gastar"));
	           
	            } else ej = null;                    
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            
	        }finally
	        {
	            if (rs != null) rs.close(); //Cerramos el resulset
	            if (stmt != null) stmt.close();//Cerramos el Statement   
	        }
	    return ej;
	}
	
	
	/**
	 * Method to delete PersonajeEnemigoJefe into DB
	 * @param c type Connection
	 * @param ej type PersonajeEnemigoJefe
	 * @return result type int
	 * @throws Exception
	 */
	@SuppressWarnings("finally")
	public int deleteEnemigoJefeById(Connection c,PersonajeEnemigoJefe ej) throws Exception
	{   PreparedStatement stmt=null; 
		int result = 0;
	    try {
	            stmt = c.prepareStatement("DELETE FROM enemigo_jefe WHERE id_enemigo_jefe=?");
	            stmt.setInt(1, ej.getIDPropia());
	            

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
