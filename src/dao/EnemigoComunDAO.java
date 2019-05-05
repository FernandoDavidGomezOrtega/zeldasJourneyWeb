package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import entidades.EnemigoComun;

/**
 * DAO for object EnemigoComun
 * @author fernando
 *
 */
public class EnemigoComunDAO {

	
	/**
	 * Método para ingresar EnemigoComun en la DB
	 * @param c de tipo Connenction
	 * @param ec de tipo EnemigoComun
	 * @return int result
	 * @throws Exception
	 */
	@SuppressWarnings("finally")
	public int insertEnemigoComun(Connection c, EnemigoComun ec) throws Exception {
		
		PreparedStatement stmt = null;
		Statement stmt2=null;
		int result = 0;
		try {
			stmt = c.prepareStatement("INSERT INTO enemigo_comun(ataque, experiencia, movimiento, movimientoTurno, muerto, n_ataques, nombre, resistencia, turno, vida, vida_gastar, fuerza) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setDouble(1, ec.getAtaque());
			stmt.setInt(2, ec.getExperiencia() );
			stmt.setInt(3, ec.getMovimiento());
			stmt.setInt(4,  ec.getMovimientoTurno());
			stmt.setInt(5,  (ec.getMuerto()?1:0));
			stmt.setInt(6, ec.getNAtaques()  );
			stmt.setString(7, ec.getNombre());
			stmt.setDouble(8,  ec.getResistencia());
			stmt.setInt(9, (ec.getTurno()?1:0));
			stmt.setInt(10, ec.getVida() );
			stmt.setInt(11, ec.getVidaTurno());
			stmt.setInt(12, ec.getFuerza());
			
			
			stmt.executeUpdate();
			
			stmt2 = c.createStatement();
			
			ResultSet rs = stmt2.executeQuery("SELECT MAX(id_enemigo_comun) FROM enemigo_comun");
			rs.next();
			result = rs.getInt(1);
			
		} catch(SQLIntegrityConstraintViolationException e)   {
			result = -1;
			e.printStackTrace();
			throw new Exception("El nombre: "+ec.getNombre()+" de enemigo común ya existe");
			
		}catch (SQLException e) {
			
			e.printStackTrace();
			throw new Exception("Ha habido un problema al guardar el personaje" + e.getMessage());
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
	 * Método para actualizar EnemigoComun en la DB
	 * @param c de tipo Connection
	 * @param ec de tipo EnemigoComun
	 * @return int result
	 * @throws Exception
	 */
	@SuppressWarnings("finally")
	public int updateEnemigoComunById(Connection c, EnemigoComun ec) throws Exception  {
		int result = 0;
		PreparedStatement pstmt=null;           
	       try {
	             pstmt = c.prepareStatement("UPDATE enemigo_comun SET ataque=?,experiencia=?,"+
	                    "movimiento=?,movimientoTurno=?,muerto=?,n_ataques=?,nombre=?, resistencia=?,"+
	            		 " turno=?, vida=?, vida_gastar=?, fuerza=? WHERE id_enemigo_comun=?");
				pstmt.setDouble(1, ec.getAtaque() );
				pstmt.setInt(2, ec.getExperiencia());
				pstmt.setInt(3,  ec.getMovimiento());
				pstmt.setInt(4,  ec.getMovimientoTurno());
				pstmt.setInt(5,  (ec.getMuerto()?1:0));
				pstmt.setInt(6, ec.getNAtaques());
				pstmt.setString(7,  ec.getNombre());
				pstmt.setDouble(8,  ec.getResistencia());
				pstmt.setInt(9, (ec.getTurno()?1:0) );
				pstmt.setInt(10, ec.getVida());
				pstmt.setInt(11,  ec.getVidaTurno());
				
				pstmt.setInt(12,  ec.getFuerza());
				pstmt.setInt(13,  ec.getIDPropia());
				
	            pstmt.executeUpdate(); 
	            result = 1;
	            
	        } catch (SQLIntegrityConstraintViolationException e) {
				e.printStackTrace();
				result = -1;
			}catch (SQLException e) {
				
				result =-2;
				e.printStackTrace();
			}finally {
				try {
					if (pstmt!=null) pstmt.close(); //cerramos el Statement
				} catch (final SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return result;
			}
	}
	
	
	/**
	 * Método para leer los datos de EnemigoComun en la DB
	 * @param c tipo Connection
	 * @param ec type EnemigoComun
	 * @return ec type EnemigoComun
	 * @throws Exception
	 */
	public EnemigoComun findEnemigoComunById(Connection c, EnemigoComun ec) throws Exception {
		
	    PreparedStatement pstmt=null;
	    ResultSet rs=null;
	    
	    try {
	                        
	            pstmt = c.prepareStatement("SELECT * FROM enemigo_comun WHERE id_enemigo_comun=?");
	            
				pstmt.setInt(1,  ec.getIDPropia());
				rs = pstmt.executeQuery();

				if(rs.next()) {
					
					ec.setAtaque(rs.getDouble("ataque"));
					ec.setExperiencia(rs.getInt("experiencia"));
					ec.setFuerza(rs.getInt("fuerza"));
					//ecomun.setIDPropia(rs.getInt("id_enemigo_comun"));
					ec.setMovimiento(rs.getInt("movimiento"));
					ec.setMovimientoTurno(rs.getInt("movimientoTurno"));
					boolean aux = rs.getInt("muerto") == 1;
					ec.setMuerto(aux);
					ec.setNAtaques(rs.getInt("n_ataques"));
					ec.setNombre(rs.getString("nombre"));
					ec.setResistencia(rs.getDouble("resistencia"));
					aux = rs.getInt("turno") == 1;
					ec.setTurno(aux);
					ec.setVida(rs.getInt("vida"));
					ec.setVidaGastar(rs.getInt("vida_gastar"));
					
				
				}
	            else ec = null;                    
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }finally
	        {
	            if (rs != null) rs.close(); //Cerramos el resulset
	            if (pstmt != null) pstmt.close();//Cerramos el Statement   
	        }
	    return ec;
	}
	
	
	/**
	 * Método para borrar EnemigoComun de la DB
	 * @param c type Connection
	 * @param ec type EnemigoComun
	 * @return int result
	 * @throws Exception
	 */
	@SuppressWarnings("finally")
	public int deleteEnemigoComunById(Connection c, EnemigoComun ec) throws Exception
	{   PreparedStatement stmt=null; 
		int result = 0;
	    try {
	            stmt = c.prepareStatement("DELETE FROM  enemigo_comun WHERE id_enemigo_comun=?");
	            stmt.setInt(1, ec.getIDPropia());
	            
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
