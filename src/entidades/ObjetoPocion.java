package zeldasjourney.objetoBeneficio;

/**
 * Creado por @sergiotremosa el xx/xx/2019.
 * Crear objetopocion de objetopadre
 */

import zeldasjourney.objetos.objetoPadre.ObjetoPadre;

public class ObjetoPocion extends ObjetoPadre {
	/*
	 * vida de objetopocion
	 * resistencia de objetopocion
	 * movimiento de objetopocion
	 * ataque de objetopocion
	 * fuerza de objetopocion
	 * vidagastar de objetopocion
	 * movimientoturno de objetopocion
	 * superataque de objetopocion
	 * experiencia de objetopocion
	 */
	
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
	 * Esto es un constructor para inicializar el objetopocion
	 * @param nombre
	 * @param vida
	 * @param resistencia
	 * @param movimiento
	 * @param ataque
	 * @param fuerza
	 * @param VidaGastar
	 * @param MovimientoTurno
	 * @param SuperAtaque
	 * @param nivel
	 */
	public ObjetoPocion(String nombre, int vida, double resistencia, int movimiento, double ataque, int fuerza, int VidaGastar, int MovimientoTurno, int SuperAtaque, int nivel) {
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
	 * obtener objetopocion vida
	 * @return objetopocion vida
	 */
	public int getVida() {
		return this.vida;
	}
	
	/**
	 * obtener objetopocion resistencia
	 * @return objetopocion resistencia
	 */
	public double getResistencia() {
		return this.resistencia;
	}
	
	/**
	 * obtener objetopocion movimiento
	 * @return objetopocion movimiento
	 */
	public int getMovimiento() {
		return this.movimiento;
	}
	
	/**
	 * obtener objetopocion vida
	 * @return objetopocion vida
	 */
	public double getAtaque() {
		return this.ataque;
	}
	
	/**
	 * obtener objetopocion fuerza
	 * @return objetopocion fuerza
	 */
	public int getFuerza() {
		return this.fuerza;
	}
	
	/**
	 * obtener objetopocion vidagastar
	 * @return objetopocion vidagastar
	 */
	public int getVidaGastar() {
		return this.vidaGastar;
	}
	
	/**
	 * obtener objetopocion movimientoturno
	 * @return objetopocion movimientoturno
	 */
	public int getMovimientoTurno() {
		return this.movimientoTurno;
	}
	
	/**
	 * obtener objetopocion superataque
	 * @return objetopocion superataque
	 */
	public int getSuperAtaque() {
		return this.superAtaque;
	}
	
	/**
	 * obtener objetopocion experiencia
	 * @return objetopocion experiencia
	 */
	public int getExperiencia() {
		return this.experiencia;
	}
	
	/**
	 * obtener objetopocion nombre
	 * @return objetopocion nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

}
