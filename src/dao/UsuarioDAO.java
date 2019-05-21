package dao;

import entidades.PersonajeHeroe;
import entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;



/**
 * DAO for object Usuario
 * @author fernando
 *
 */
public class UsuarioDAO {
	
	
	/**
	 * Method to insert object Usuario into DB
	 * @param c: Connection
	 * @param u: Usuario
	 * @return result: int
	 * @throws Exception
	 */
	@SuppressWarnings("finally")
	public int insertUsuario(Connection c, Usuario u) throws Exception {
		PreparedStatement stmt = null;
		Statement stmt2 =null;
		ResultSet rs = null;
		int result = 0 ;
		try {
			stmt = c.prepareStatement("INSERT INTO USUARIO(USUARIO_FECHA_INGRESO, USUARIO_NICK, USUARIO_PASSWORD , USUARIO_NOMBRE, USUARIO_APELLIDO ) VALUES (?,?,?,?,?)");
			stmt.setDate (1, new Date(new java.util.Date().getTime()));
			stmt.setString(2, u.getNick() );
			stmt.setString(3, u.getPassword());
			stmt.setString(4,  u.getNombre());
			stmt.setString(5,  u.getApellido());
			
			stmt.executeUpdate();
			
			stmt2 = c.createStatement();
			rs = stmt2.executeQuery("SELECT MAX(USUARIO_ID) FROM USUARIO");
			rs.next();
			result = rs.getInt(1);
			
		}catch(SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			result = -1;
		}catch (SQLException e) {
			e.printStackTrace();
			result = -2;
		}finally {
			try {
				if(rs!=null) rs.close();
				if (stmt!=null) stmt.close(); //cerramos el Statement
			} catch (final SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
	}
	
	
	/**
	 * Method to get a Usuario's list of Heroes 
	 * @param c: Connection
	 * @param u: Usuario
	 * @return lista: ArrayList<PersonajeHeroe>
	 */
	private ArrayList<PersonajeHeroe> getListaHeroesByUsuario(Connection c, Usuario u) throws Exception {
		ResultSet rs = null;
		
		String sql = "SELECT * from HEROE where HEROE_USUARIO_ID=?";
		
		ArrayList<PersonajeHeroe> lista = new ArrayList<PersonajeHeroe>();
		try {
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setInt(1, u.getIdUsuario());
			rs = pstmt.executeQuery();
			
			PersonajeHeroe h;
			
			while(rs.next()) {
				h = new PersonajeHeroe(null, rs.getInt("vida"), rs.getDouble("resistencia"), 
						rs.getInt("movimiento"), rs.getDouble("ataque"), rs.getInt("fuerza"), 
						rs.getString("nombre"), rs.getInt("super_ataque"));
				
				lista.add(h);
			}
			
			if(pstmt!=null) pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
		
	}

	
	/**
	 * Method to read Usuario's data. Usuario found by Nick in the DB
	 * @param c: Connection
	 * @param u: Usuario
	 * @return u: Usuario
	 */
	public Usuario findUsuarioByNick(Connection c, Usuario u) throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="SELECT * from USUARIO where USUARIO_NICK =?";
		try {
			pstmt = c.prepareStatement(sql);
			pstmt.setString(1,  u.getNick());

			rs = pstmt.executeQuery();

			if(rs.next()) {
				u = new Usuario();
				u.setIdUsuario(rs.getInt("USUARIO_ID"));
				u.setApellido(rs.getString("USUARIO_APELLIDO"));
				u.setFechaIngreso(rs.getDate("USUARIO_FECHA_INGRESO"));
				u.setNombre(rs.getString("USUARIO_NOMBRE"));
				u.setNick(rs.getString("USUARIO_NICK"));
				u.setPassword(rs.getString("USUARIO_PASSWORD"));
				u.setPersonajes(this.getListaHeroesByUsuario(c, u));
			}
			else u = null;
		}catch (SQLException e){
			e.printStackTrace();
			u =null;
			
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return u;
	}
	

	/**
	 * Method to read Usuario's data. Usuario found by Id 
	 * @param c: Connection
	 * @param u: Usuario
	 * @return u: Usuario
	 * @throws Exception
	 */
	public Usuario findUsuarioById(Connection c, Usuario u) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql ="SELECT * from USUARIO where USUARIO_ID =?";
		try {
			pstmt = c.prepareStatement(sql);
			pstmt.setInt(1,  u.getIdUsuario());
			rs = pstmt.executeQuery();

			if(rs.next()) {
				
				
				u.setApellido(rs.getString("USUARIO_APELLIDO"));
				u.setFechaIngreso(rs.getDate("USUARIO_FECHA_INGRESO"));
				u.setNick(rs.getString("USUARIO_NICK"));
				u.setNombre(rs.getString("USUARIO_NOMBRE"));
				u.setPassword(rs.getString("USUARIO_PASSWORD"));
				u.setPersonajes(this.getListaHeroesByUsuario(c, u));
			} else {
				u = null;
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return u;
	}
	

	
	/**
	 * Method to update Usuario in the DB
	 * @param c: Connection
	 * @param u: Usuario
	 * @return result: int
	 */
	public int updateUsuarioById(Connection c, Usuario u)  {
		 PreparedStatement stmt=null;   
		 int result = 0;
	       try {
	             stmt = c.prepareStatement("UPDATE USUARIO SET USUARIO_NICK=?,USUARIO_PASSWORD=?,"+
	                    "USUARIO_NOMBRE=?,USUARIO_APELLIDO=? WHERE USUARIO_ID=?");
	            
				stmt.setString(1, u.getNick() );
				stmt.setString(2, u.getPassword());
				stmt.setString(3,  u.getNombre());
				stmt.setString(4,  u.getApellido());
				stmt.setInt(5, u.getIdUsuario() );
				
	            stmt.executeUpdate();   
	            result = 1;
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            result = -1;
	        }  finally
	        {
	            if (stmt != null)
					try {
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}//Cerramos el Statement
	            
	        } return result;
	}
	
	
	

	/**
	 * Method to delete Usuario from the DB
	 * @param c: Connection
	 * @param u: usuario
	 * @return result: int
	 * @throws Exception
	 */
	public int deleteUsuarioById(Connection c, Usuario u) throws Exception {   
		int result = 0;
		PreparedStatement stmt=null;  
		
		//borramos todos los heroes que haya para poder borrar después al usuario
		try {
            stmt = c.prepareStatement("DELETE FROM HEROE where HEROE_USUARIO_ID =  ? ");
            stmt.setInt(1, u.getIdUsuario());
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            

        }
		
		//ahora borramos Usuario
	    try {
	            stmt = c.prepareStatement("DELETE FROM USUARIO where USUARIO_ID =  ? ");
	            stmt.setInt(1, u.getIdUsuario());
	            stmt.executeUpdate();
	            result =1;
	        } catch (SQLException ex) {
	            ex.printStackTrace();

	        } finally
	        {
	            if (stmt != null)
					try {
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}//Cerramos el Statement
	        }   return result; 
	}

}
