package zeldasjourney.objetos.objetoHijo;


import zeldasjourney.objetos.objetoPadre.ObjetoPadre;

/**
 * Creado por @sergiotremosa el xx/xx/2019.
 * Crear objetoarma de objetopadre
 * @author equipo 02
 *
 */
public class ObjetoArma extends ObjetoPadre {
	
	/*
	 * movimiento de objetoarma
	 * fuerza de objetoarma
	 * ataque de objetoarma
	 */
	protected int movimiento;
	protected int fuerza;
	protected double ataque;
	
	/**
	 * Esto es un constructor para inicializar el objetoarma.
	 *
	 */
	public ObjetoArma(String nombre, int movimiento, double ataque, int fuerza) {
		
		
		this.nombre= nombre;
		this.movimiento= movimiento;
		this.ataque= ataque;
		this.fuerza= fuerza;
		this.descripcion= ("El nombre de esta arma es "+this.nombre+" te proporciona: fuerza " + this.fuerza+"\n Ataque "+this.ataque+"\n movimiento "+this.movimiento);
		this.tipo="arma";
	}
	
	/**
	 * Obtener objetoarma nombre
	 * @return objetoarma nombre
	 */
	public String getNombre() {
		return this.nombre;
	}
	
	/**
	 * Obtener objetoarma descripcion
	 * @return objetoarma descripcion
	 */
	public String getDescripcion() {
		return this.descripcion;
	}
	
	/**
	 * Obtener objetoarma movimiento
	 * @return objetoarma movimiento
	 */
	public int getMovimiento() {
		return this.movimiento;
	}
	
	/**
	 * Obtener objetoarma ataque
	 * @return objetoarma ataque
	 */
	public double getAtaque() {
		return this.ataque;
	}
	
	/**
	 * Obtener objetoarma fuerza
	 * @return objetoarma fuerza
	 */
	public int getFuerza() {
		return this.fuerza;
	}
}


