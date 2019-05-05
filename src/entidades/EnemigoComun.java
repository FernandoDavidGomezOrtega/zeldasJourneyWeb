package entidades;

import entidades.PersonajePadre;

/**
 * Creado por @sergiotremosa el xx/xx/2019.
 * Crear objeto enemigocomun de personajepadre. 
 * @author casa
 *
 */
public class EnemigoComun extends PersonajePadre {
	
	/**
	 * Este es un constructor para inicializar EnemigoComun
	 * @param experiencia
	 * @param vida
	 * @param resistencia
	 * @param movimiento
	 * @param movimientoTurno
	 * @param muerto
	 * @param turno
	 * @param n_ataques
	 * @param ataque
	 * @param fuerza
	 * @param nombre
	 */
	public EnemigoComun(int experiencia, int vida, double resistencia, int movimiento, int movimientoTurno, boolean muerto, boolean turno,  int nAtaques, double ataque, int vidaGastar, int fuerza, String nombre) {
		
		this.setExperiencia(experiencia);
		this.setVida(vida);
		this.setResistencia(resistencia);
		this.setMovimiento(movimiento);
		this.setMovimientoTurno(movimientoTurno);
		this.setMuerto(muerto);
		this.setTurno(turno);
		this.setNAtaques(nAtaques);
		this.setAtaque(ataque);
		this.setFuerza(fuerza);
		this.setNombre(nombre);
		this.setVidaGastar(this.getVida());
		//this.setVidaGastar(vidaGastar);
		
		
		
		
		this.setMovimientoTurno(this.getMovimiento()+5);
		
	}
	
	/**
	 * Constructor vacio
	 */
	public EnemigoComun() {
		super();
	}
	
	

	/**
	 * Método para que el personaje pase turno
	 * Cada personaje psa turno de diferente manera
	 */
	@Override
	public void pasarTurno() {
		this.setMovimientoTurno(this.getMovimiento());
		this.nAtaques=1;
	}

}
