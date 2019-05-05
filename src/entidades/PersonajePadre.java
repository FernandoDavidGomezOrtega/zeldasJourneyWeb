package entidades;


/**
 * Creado por @sergiotremosa el xx/xx/2019.
 * Crear objeto personajepadre 
 * @author equipo 02
 *
 */
public abstract class PersonajePadre {

	// Estos son los valores predeterminados de todos los personajes
	
	private int iDPropia;
	private int idPantalla;
	
	/*
	 * vida de personajepadre. Si la vida llega a 0 el personaje muere.
	 * vidagastar de personajepadre. Es el valor de vida que se consume durante la partida. Se iguala a "vida" y nunca puede superarla
	 * resistencia de personajepadre. Valor necesario para los ataques.
	 * movimiento de personajepadre. Las unidades que puede mover en total.
	 * movimientoturno de personajepadre. Este valor se iguala a movimiento, es el valor que se consume por turno.
	 * ataque de personajepadre. Valor necesario para los ataques.
	 * fuerza de personajepadr. Valor necesario para los ataques.
	 * nombre de personajepadre. Nombre del personaje.
	 * turno de personajepadre.  Si esta variable esta a true el personaje puede actuar.
	 * experiencia de personajepadre. Necesaria para subir de nivel.
	 * numero de ataques de personajepadre. Es el numero de ataques disponiles por turno, si el numero de ataques es 0 nopuedes atacar
	 */
	
	/**
	 * Vida del personaje. si la vida del personaje llega a 0 el personaje muere
	 * @see PersonajePadre.muerto
	 */
	private int vida = 20; 
	
	/**
	 * es el valor de vida que se consume durante la partida, se iguala a "vida" y
	 * nunca debe superarla
	 */
	private int vidaGastar; 
	
	/**
	 * indica que el personaje está muerto
	 */
	private boolean muerto= false;
	
	/**
	 * valor necesario para los ataques
	 */
	private double resistencia = 20; 
	
	/**
	 * las unidades que puede mover en total
	 */
	private int movimiento; 
	
	/**
	 * Este valor se iguala a movimiento, es el valor que se consume por turno
	 */
	private int movimientoTurno; 
	
	/**
	 * valor necesario para los ataques
	 */
	private double ataque ; 
	
	/**
	 * valor necesario para los ataques
	 */
	private int fuerza ; 
	
	/**
	 * Nombre del personaje
	 */
	private String nombre; 
	
	/**
	 * Si esta variable esta en true el personaje puede actuar 
	 */
	private boolean turno = true; 
	
	/**
	 * necesaria para subir de nivel
	 */
	private int experiencia = 0;
	
	/**
	 * Es el numero de ataques disponibles por turno, si el numero de ataques es 0 no
	 * puedes atacar
	 */
	protected int nAtaques = 1; 
	
	/**
	 * metodo abstracto. Cada personaje pasará turno de forma diferente
	 */
	public abstract void pasarTurno();  
	
	/**
	 * para atacar necesitamos introducir un objeto tipo PersonajePadre
	 * @param personaje
	 */
	public void ataque(PersonajePadre personaje) {  

		if(this.getMovimientoTurno()>0) {
		if(!personaje.muerto) {
			
		
		if (this.nAtaques > 0) { // verificamos que disponemos de ataques

			// (ataque*random) /(resistencia*random) = porcentaje( numero entre 0 y mucho )
			double valorAtacante = this.ataque * Math.random();
			double valorDefensor = personaje.resistencia * Math.random();
			double porcentaje = valorAtacante / valorDefensor;
			// si el valor de porcentaje es mas alto que 1 el ataque ha sido mas fuerte k la
			// resistencia si es menor no

			if (porcentaje > 1 && porcentaje < 3) {

				personaje.vida = personaje.vidaGastar - this.fuerza;

				this.informar("Tu enemigo a recibido el impacto, ganas 1 punto de experiencia");

				this.setExperiencia(+1);

				if (personaje.vida <= 0) {

					this.informar(personaje.nombre + " ha muerto, ganas 5 puntos de experiencia ");
					personaje.morir();
					this.setExperiencia(+5); // Al matar un enemigo gana experiencia
				}

				// Si el resultado del ataque es mas de 3 veces mayor que el de la resistencia,
				// la fuerza del golpe se multiplica por 2
			} else if (porcentaje > 3 && porcentaje < 5) {

				personaje.vida = personaje.vidaGastar - this.fuerza * 2;

				this.informar(
						"Tu enemigo a recibido el impacto fuerte el daño se multiplica por 2, ganas dos puntos de experiencia ");

				this.setExperiencia(+2);

				if (personaje.vida <= 0) {

					this.informar(personaje.nombre + " ha muerto, ganas 5 puntos de experiencia ");
					
					personaje.morir();
					this.setExperiencia(+5); // Al matar una enemigo gana experiencia
				}

				// Si el resultado del atque es mayor de 5 veces mayor que el de la resistencia,
				// la fuerza del golpe se multiplica por3

			} else if (porcentaje > 5) {

				personaje.vida = personaje.vidaGastar - this.fuerza * 3;

				this.informar(
						"Tu enemigo a recibido un super impacto el daño se multiplica por 3, ganas 3 puntos de experiencia ");

				this.setExperiencia(+3);

				if (personaje.vida <= 0) {
					
					this.informar(personaje.nombre + " ha muerto, ganas 5 puntos de experiencia ");
					
					personaje.morir();
					
					this.setExperiencia(+5); // Al matar una enemigo gana experiencia
				}

				// Si el valor del la operacion es menor a 1 resitencia el impacto a sido
				// bloqueado
			} else if (porcentaje < 1 && porcentaje > 0.2) {

				this.informar("Tu enemigo ha parado el impacto");

				// Si el valor del la operacion es menor a 0.2 resitencia el impacto a sido
				// bloqueado y contratacado
			} else if (porcentaje < 0.2) {

				this.vida = this.vidaGastar - personaje.fuerza;

				this.informar("Tu enemigo ha parado el impacto y a contratacado has perdido " + personaje.getFuerza()+" de vida");

				personaje.setExperiencia(+1);

			}

			this.nAtaques = 0; // restamos el ataque que acabamos de realizar
			
			this.setMovimientoTurno(-1);

		} else {
			this.informar("No puedes atacar mas en este turno, ya has atacado");
		}}else {
			this.informar("Este Personaje esta muerto no es muy adecuado atacar a los muertos");
		}}else if(this.getMovimientoTurno()<=0){
			
			
			this.informar("No tienes mas movimientos en este turno");
		}
	}
	
	/**
	 * Método que sirve para matar un personaje
	 */
	public void morir() {
		 
		 vidaGastar=0;  
		 movimientoTurno=0; 
		 ataque = 0; 
		 fuerza = 0; 	 
	     nAtaques = 0; 
	      this.setMuerto(true);
	}
	
	/*
	* la ventaja de crear un metodo donde se ejecuta un metodo predefinido de java
	* es que si queremos cambiar la manera de enviar el mensaje solo hay que
	* cambiarlo aquí
	*/
	
	/**
	 * Informa por medio de un mensaje
	 * @param mensaje
	 */
	public void informar(String mensaje) {

		System.out.println(mensaje);
	}

	/**
	 * Asigna un entero al atributo vida
	 * @param vida
	 */
	public void setVida(int vida) {

		this.vida = this.vida + vida;
	}
	
	/**
	 * Asigna un entero al atributo vidaGastar
	 * @param vidaGastar
	 */
	public void setVidaGastar(int vidaGastar) {
		this.vidaGastar = this.vidaGastar + vidaGastar;
		if (this.vidaGastar > this.vida) {
			this.vidaGastar = this.vida;
		}

	}

	/**
	 * Asigna un double al atributo resistencia
	 * @param resistencia
	 */
	public void setResistencia(double resistencia) {

		this.resistencia = this.resistencia + resistencia;
	}

	/**
	 * Asigna un entero al atributo movimiento
	 * @param movimiento
	 */
	public void setMovimiento(int movimiento) {

		this.movimiento = this.movimiento + movimiento;
	}

	/**
	 * Asigna un double al atributo ataque
	 * @param ataque
	 */
	public void setAtaque(double ataque) {

		this.ataque = this.ataque + ataque;
	}

	/**
	 * Asigna un entero al atributo fuerza
	 * @param fuerza
	 */
	public void setFuerza(int fuerza) {

		this.fuerza = this.fuerza + fuerza;
	}

	/**
	 * Asigna un string al atributo nombre
	 * @param nombre
	 */
	public void setNombre(String nombre) {

		this.nombre = nombre;
	}

	/**
	 * Asigna un entero al atributo movimientoGastar
	 * @param movimientoGastar
	 */
	public void setMovimientoTurno(int movimientoGastar) {

		this.movimientoTurno =this.movimientoTurno+ movimientoGastar;
		
		if(this.movimientoTurno>this.getMovimiento()){
			this.movimientoTurno=this.movimiento;
		}
	}

	/**
	 * Asigna un entero al atributo experiencia
	 * @param experiencia
	 */
	public void setExperiencia(int experiencia) {

		this.experiencia = this.experiencia + experiencia;
	}
	
	
	/**
	 * Asigna un entero al atributo nAtaques
	 * @param nAtaques
	 */
	public void setNAtaques(int nAtaques) {

		this.nAtaques = nAtaques;
	}	
	
	/**
	 * Asigna un entero al atributo Turno
	 * @param Turno
	 */
	public void setTurno(boolean turno) {

		this.turno = turno;
	}
	
	

	/**
	 * Obtener personajePadre experiencia
	 * @return personajePadre experiencia
	 */
	public int getExperiencia() {
		return this.experiencia;
	}

	/**
	 * Obtener personajePadre vidaTurno
	 * @return personajePadre visaTurno
	 */
	public int getVidaTurno() {
		return this.vidaGastar;
	}

	/**
	 * Obtener personajePadre vida
	 * @return personajePadre vida
	 */
	public int getVida() {

		return this.vida;
	}

	/**
	 * Obtener personajePadre resistencia
	 * @return personajePadre resistencia
	 */
	public double getResistencia() {

		return this.resistencia;
	}

	/**
	 * Obtener personajePadre movimiento
	 * @return personajePadre movimiento
	 */
	public int getMovimiento() {

		return this.movimiento;
	}

	/**
	 * Obtener personajePadre ataque
	 * @return personajePadre ataque
	 */
	public double getAtaque() {

		return this.ataque;
	}
	
	/**
	 * Obtener personajePadre ataque
	 * @return personajePadre ataque
	 */
	public int getNAtaques() {

		return this.nAtaques;
	}
	
	/**
	 * Obtener personajePadre turno
	 * @return personajePadre turno
	 */
	public boolean getTurno() {

		return this.turno;
	}

	/**
	 * Obtener personajePadre fuerza
	 * @return personajePadre fuerza
	 */
	public int getFuerza() {

		return this.fuerza;
	}

	/**
	 * Obtener personajePadre nombre
	 * @return personajePadre nombre
	 */
	public String getNombre() {

		return this.nombre;
	}

	/**
	 * Obtener personajePadre movimientoTurno
	 * @return personajePadre movimientoTurno
	 */
	public int getMovimientoTurno() {
		return this.movimientoTurno;
	}

	/**
	 * Obtener personajePadre muerto
	 * @return personajePadre muerto
	 */
	public boolean getMuerto() {
		return muerto;
	}

	/**
	 * asignar boolean al atributo muerto
	 * @param muerto
	 */
	public void setMuerto(boolean muerto) {
		this.muerto = muerto;
	}

	/**
	 * Obtener personajePadre idPropia
	 * @return personajePadre idPropia
	 */
	public int getIDPropia() {
		return iDPropia;
	}

	/**
	 * Asignar entero al atributo idPropia
	 * @param iDPropia
	 */
	public void setIDPropia(int iDPropia) {
		this.iDPropia = iDPropia;
	}

	/**
	 * Obtener personajePadre idPantalla
	 * @return personajePadre idPantalla
	 */
	public int getIdPantalla() {
		return idPantalla;
	}

	/**
	 * Asignar entero al atributo idPantalla
	 * @param idPantalla
	 */
	public void setIdPantalla(int idPantalla) {
		this.idPantalla = idPantalla;
	}

}
