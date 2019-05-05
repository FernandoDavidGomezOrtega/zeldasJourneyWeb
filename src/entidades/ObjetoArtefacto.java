package entidades;


import entidades.ObjetoPadre;

import java.util.Objects;

/**
 * Creado por @sergiotremosa el xx/xx/2019.
 * Crear objetoartefacto de objetopadre
 * @author equipo 02
 *
 */
public class ObjetoArtefacto extends ObjetoPadre {
	
	/*
	 * nombre de objetoartefacto
	 * descripcion de objetoartefacto
	 * vida de objetoartefacto
	 * resistencia de objetoartefacto
	 * movimiento de objetoartefacto
	 * ataque de objetoartefacto
	 * fuerza de objetoartefacto
	 * vidagastar de objetoartefacto
	 * movimientoturno de objetoartefacto
	 * superataque de objetoartefacto
	 * nivel de objetoartefacto
	 */
	
	private String nombre;
	private String descripcion;
	private int vida=0;

	private double resistencia=0;
	private int movimiento=0;
	private double ataque=0;
	private int fuerza=0;
	private int vidaGastar=0;
	private int movimientoTurno=0;
	private int superAtaque=0;	
	private int nivel=0;

	/**
	 * Esto es un constructor para inicializar el objetoartefacto.
	 *
	 */
	public ObjetoArtefacto(String nombre, String descripcion, int vida, double resistencia, int movimiento, double ataque, int fuerza, int VidaGastar, int MovimientoTurno, int SuperAtaque, int nivel) {
		
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.vida=vida;
		this.resistencia=resistencia;
		this.movimiento=movimiento;
		this.ataque=ataque;
		this.fuerza=fuerza;
		this.vidaGastar=VidaGastar;
		this.movimientoTurno=MovimientoTurno;
		this.superAtaque=SuperAtaque;
		this.nivel=nivel;
		this.tipo="artefacto";
	}

	/**
	 * Obtener objetoartefacto descripcion
	 * @return objetoartefacto descripcion
	 */
	public String getDescripcion() {
		return this.descripcion;
	}

	/**
	 * Definir objetoartefacto descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtener objetoartefacto vida
	 * @return objetoartefacto vida
	 */
	public int getVida() {
		return this.vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	/**
	 * Obtener objetoartefacto resistencia
	 * @return objetoartefacto resistencia
	 */
	public double getResistencia() {
		return this.resistencia;
	}

	public void setResistencia(double resistencia) {
		this.resistencia = resistencia;
	}

	/**
	 * Obtener objetoartefacto movimiento
	 * @return objetoartefacto movimiento
	 */
	public int getMovimiento() {
		return this.movimiento;
	}

	public void setMovimiento(int movimiento) {
		this.movimiento = movimiento;
	}

	/**
	 * Obtener objetoartefacto ataque
	 * @return objetoartefacto ataque
	 */
	public double getAtaque() {
		return this.ataque;
	}

	public void setAtaque(double ataque) {
		this.ataque = ataque;
	}

	/**
	 * Obtener objetoartefacto fuerza
	 * @return objetoartefacto fuerza
	 */
	public int getFuerza() {
		return this.fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	/**
	 * Obtener objetoartefacto vidagastar
	 * @return objetoartefacto vidagastar
	 */
	public int getVidaGastar() {
		return this.vidaGastar;
	}

	public void setVidaGastar(int vidaGastar) {
		this.vidaGastar = vidaGastar;
	}

	/**
	 * Obtener objetoartefacto movimientoturno
	 * @return objetoartefacto movimientoturno
	 */
	public int getMovimientoTurno() {
		return this.movimientoTurno;
	}

	public void setMovimientoTurno(int movimientoTurno) {
		this.movimientoTurno = movimientoTurno;
	}

	/**
	 * Obtener objetoartefacto superataque
	 * @return objetoartefacto superataque
	 */
	public int getSuperAtaque() {
		return this.superAtaque;
	}

	public void setSuperAtaque(int superAtaque) {
		this.superAtaque = superAtaque;
	}

	/**
	 * Obtener objetoartefacto nivel
	 * @return objetoartefacto nivel
	 */
	public int getNivel() {
		return this.nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	/**
	 * Obtener objetoartefacto nombre
	 * @return objetoartefacto nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * definir objetoartefacto nombre
	 * @param nombre que se le da a objetoartefacto 
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		ObjetoArtefacto artefacto = (ObjetoArtefacto) o;
		return vida == artefacto.vida &&
				Double.compare(artefacto.resistencia, resistencia) == 0 &&
				movimiento == artefacto.movimiento &&
				Double.compare(artefacto.ataque, ataque) == 0 &&
				fuerza == artefacto.fuerza &&
				vidaGastar == artefacto.vidaGastar &&
				movimientoTurno == artefacto.movimientoTurno &&
				superAtaque == artefacto.superAtaque &&
				nivel == artefacto.nivel &&
				Objects.equals(nombre, artefacto.nombre) &&
				Objects.equals(descripcion, artefacto.descripcion);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), nombre, descripcion, vida, resistencia, movimiento, ataque, fuerza, vidaGastar, movimientoTurno, superAtaque, nivel);
	}
}
