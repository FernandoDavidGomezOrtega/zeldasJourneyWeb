package entidades;

import entidades.ObjetoPadre;

/**
 * Creado por @sergiotremosa el xx/xx/2019.
 * Crear objetoescudo de objetopadre 
 * @author equipo 02
 *
 */
public class ObjetoEscudo extends ObjetoPadre {
	
	/*
	 * resistencia de objetoescudo
	 * movimiento de objetoescudo
	 * ataque de objetoescudo
	 */
	private double resistencia;
	private int movimiento;
	private double ataque;
	
	/**
	 * Esto es un constructor para inicializar el objetoescudo.
	 * @param nombre
	 * @param resistencia
	 * @param movimiento
	 * @param ataque
	 */
	public ObjetoEscudo(String nombre, double resistencia, int movimiento, double ataque) {
		
		this.nombre=nombre;
		this.resistencia=resistencia;
		this.movimiento=movimiento;
		this.ataque=ataque;
		this.descripcion="El nombre de este escudo es "+this.nombre+ " sus caracteristiscas son: \n- Resistencia " +this.resistencia+ "\n - Movimiento "+ this.movimiento+ " \n -Ataque"+ this.ataque;
		this.tipo="escudo";
	}
	
	/**
	 * Obtener objetoescudo nombre
	 * @return objetoescudo nombre
	 */
	public String getNombre() {
		return this.nombre;
		
	}
	
	/**
	 * Obtener objetoescudo resistencia
	 * @return objetoescudo resistencia
	 */
	public double getResistencia() {
		return this.resistencia;
		
	}
	
	/**
	 * Obtener objetoescudo movimiento
	 * @return objetoescudo movimiento
	 */
	public int getMovimiento() {
		return this.movimiento;
		
	}
	
	/**
	 * Obtener objetoescudo ataque
	 * @return objetoescudo ataque
	 */
	public double getAtaque() {
		return this.ataque;
		
	}
	
	/**
	 * Obtener objetoescudo descripcion
	 * @return objetoescudo descripcion
	 */
	public String getDescripcion() {
		return this.descripcion;
		
	}
}
