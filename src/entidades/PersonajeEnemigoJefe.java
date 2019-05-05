package entidades;


import entidades.PersonajePadre;

/**
 * Creado por @sergiotremosa el xx/xx/2019.
 * Crear objeto personajeenemigojefe de personajepadre. 
 * @author casa
 *
 */
public class PersonajeEnemigoJefe extends PersonajePadre {// Este objeto hereda de PersonajePadre

	private int superAtaque;
	
	/**
	 * Constructor para inicializar el objeto PersonajeEnemigoJefe
	 * @param vida
	 * @param resistencia
	 * @param movimiento
	 * @param ataque
	 * @param fuerza
	 * @param nombre
	 * @param SAtaque
	 */
	public PersonajeEnemigoJefe(int vida, double resistencia, int movimiento, double ataque, int fuerza, String nombre,
			int SAtaque) {

		this.setSuperAtaque(SAtaque);// Es caracteristica propia que no tiene el padre (personaje comun)
		this.setVida(vida);
		this.setVidaGastar(this.getVida());
		this.setResistencia(resistencia);
		this.setMovimiento(movimiento);
		this.setAtaque(ataque);
		this.setFuerza(fuerza);
		this.setNombre(nombre);
		this.setMovimientoTurno(this.getMovimiento());

	}
	
	public PersonajeEnemigoJefe() {
		super();
	}
	
	/**
	 * Obtener personajeEnemigoJefe superAtaques
	 * @return superAtaque
	 */
	public int getSuperAtaques() {
		return this.superAtaque;
	}
	
	/**
	 * Asignar int al atributo superAtaque
	 * @param SuperAtaque
	 */
	public void setSuperAtaque(int SuperAtaque) { // No se puede tener mas de 5 super ataques
		
		this.superAtaque = this.superAtaque + SuperAtaque;

		if (this.superAtaque >= 5) {
			this.informar("tienes todos los super ataques");
			this.superAtaque = 5;
		}
		this.informar("Dispones de "+ this.getSuperAtaques()+" Super Ataques");
	}

	// no se puede disponer de mas puntos de magia para gastar que puntos de magia

	// Cuando realizamos un super ataque nuestro valor de ataque se multiplica por 2
	
	/**
	 * Metodo para atacar con super ataque
	 * @param enemigo
	 */
	public void sAtaque(PersonajePadre enemigo) {
		
		if(this.getMovimientoTurno()>0) {
		
		this.informar("Has realizado un Super ataque ");
		
		double valorSuper = this.getAtaque();

		this.setAtaque(valorSuper);

		this.ataque(enemigo);

		this.setAtaque(-valorSuper);

		this.setSuperAtaque(- 1);
		
		this.setMovimientoTurno(-1);
		
		}else {
			this.informar("No tienes mas movimientos en este turno");
		}
	}
	
	/**
	* Al pasar turno se igual el movimiento con movimiento turno y volvemos a
	* tener ataques disponibles
	*/
	@Override
	public void pasarTurno() {
		this.setMovimientoTurno(this.getMovimiento());
		this.nAtaques = 1;

	}

}
