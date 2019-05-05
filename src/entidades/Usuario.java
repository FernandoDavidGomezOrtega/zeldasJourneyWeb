package zeldasjourney.usuario;

import java.util.ArrayList;
import java.util.Date;

import zeldasjourney.personaje.personajesHijo.PersonajeHeroe;

/**
 * Creado por @sergiotremosa el xx/xx/2019.
 * Crear objeto usuario. 
 * @author grupo 02
 *
 */
public class Usuario {
	
	private String nombre;
	private String apellido;
	private String nick;
	private String password;
	private int idUsuario;
	private ArrayList<PersonajeHeroe> personajes;
	private java.sql.Date fechaIngreso;
	
	/**
	 * obtener usuario nombre
	 * @return usuario nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Asignar string al atributo nombre
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * obtener usuario apellido
	 * @return usuario apellido
	 */
	public String getApellido() {
		return apellido;
	}
	
	/**
	 * Asignar string al atributo apellido
	 * @param apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	/**
	 * obtener usuario nick
	 * @return usuario nick
	 */
	public String getNick() {
		return nick;
	}
	
	/**
	 * Asignar string al atributo nick
	 * @param nick
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	/**
	 * obtener usuario password
	 * @return usuario password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Asignar string al atributo password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * obtener usuario idusuario
	 * @return usuario idusuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}
	
	/**
	 * Asignar string al atributo idusuario
	 * @param idUsuario
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	/**
	 * obtener usuario personajes
	 * @return usuario personajes
	 */
	public ArrayList<PersonajeHeroe> getPersonajes() {
		return personajes;
	}
	
	/**
	 * Asignar arraylist al atributo personajes
	 * @param personajes
	 */
	public void setPersonajes(ArrayList<PersonajeHeroe> personajes) {
		this.personajes = personajes;
	}
	
	/**
	 * obtener usuario fechaingreso
	 * @return usuario fechaingreso
	 */
	public java.sql.Date getFechaIngreso() {
		return fechaIngreso;
	}
	
	/**
	 * Asignar date al atributo fechaingreso
	 * @param fechaIngreso
	 */
	public void setFechaIngreso(java.sql.Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	

}
