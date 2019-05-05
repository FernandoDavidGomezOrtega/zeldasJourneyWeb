package zeldasjourney.artefactoEnemigo;

/**
 * Creado por @sergiotremosa el xx/xx/2019.
 * Crear artefactoenemigo de objetopadre.
 */

import zeldasjourney.objetos.objetoPadre.ObjetoPadre;

public class ArtefactoEnemigo extends ObjetoPadre{
	
	private int vida=0;
	private double resistencia=0;
	private int movimiento=0;
	private double ataque=0;
	private int fuerza=0;
	private int vidaGastar=0;
	private int movimientoTurno=0;
	private int superAtaque=0;
	private int experiencia=0;
	private String nombre;
	
	/**
	 * Esto es un constructor para inicializar el objeto artefactoenemigo.
	 *
	 */
	
	public ArtefactoEnemigo(String nombre, int vida, double resistencia, int movimiento, double ataque, int fuerza, int VidaGastar, int MovimientoTurno, int SuperAtaque, int nivel) {
		this.vida=vida;
		this.resistencia=resistencia;
		this.movimiento=movimiento;
		this.ataque=ataque;
		this.vidaGastar=VidaGastar;
		this.movimientoTurno=MovimientoTurno;
		this.superAtaque=SuperAtaque;
		this.experiencia=nivel;
		this.nombre=nombre;
	}
	
	/**
	 * obtener artefactoenemigo vida
	 * @return artefactoenemigo vida
	 */	
	public int getVida() {
		return this.vida;
	}
	
	/**
	 * obtener artefactoenemigo resistencia
	 * @return artefactoenemigo resistencia
	 */
	public double getResistencia() {
		return this.resistencia;
	}
	
	/**
	 * obtener artefactoenemigo movimiento
	 * @return artefactoenemigo movimiento
	 */
	public int getMovimiento() {
		return this.movimiento;
	}
	
	/**
	 * obtener artefactoenemigo ataque
	 * @return artefactoenemigo ataque
	 */
	public double getAtaque() {
		return this.ataque;
	}
	
	/**
	 * obtener artefactoenemigo fuerza
	 * @return artefactoenemigo fuerza
	 */
	public int getFuerza() {
		return this.fuerza;
	}
	
	/**
	 * obtener artefactoenemigo vidagastar
	 * @return artefactoenemigo vidagastar
	 */
	public int getVidaGastar() {
		return this.vidaGastar;
	}
	
	
	/**
	 * obtener artefactoenemigo movimientoturno
	 * @return artefactoenemigo movimientoturno
	 */
	public int getMovimientoTurno() {
		return this.movimientoTurno;
	}
	
	/**
	 * obtener artefactoenemigo superataque
	 * @return artefactoenemigo superataque
	 */
	public int getSuperAtaque() {
		return this.superAtaque;
	}
	
	/**
	 * obtener artefactoenemigo experiencia
	 * @return artefactoenemigo experiencia
	 */
	public int getExperiencia() {
		return this.experiencia;
	}
	
	/**
	 * obtener artefactoenemigo nombre
	 * @return artefactoenemigo nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

}
