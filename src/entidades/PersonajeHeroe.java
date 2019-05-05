package entidades;

import java.util.Scanner;
import entidades.Usuario;

import entidades.ArtefactoEnemigo;
import entidades.ArtefactoTrampa;
import entidades.ObjetoPocion;
import entidades.ObjetoArma;
import entidades.ObjetoEscudo;
import entidades.ObjetoPadre;

/**
 * Creado por @sergiotremosa el xx/xx/2019.
 * Crear objeto personajehereo de personajeenemigojefe.
 * @author equipo 02
 *
 */
public class PersonajeHeroe extends PersonajeEnemigoJefe {

	// El personaje heroe tiene las mismas caracteristicas que personaje jefe mas
	// otras propias asi que hereda de personaje jefe
	
	/*
	* puede tener objetos arma escudo y artefacto
	*/

	private ObjetoArma arma;

	private ObjetoEscudo escudo;

	private ObjetoPocion artefacto;
	
	private Usuario usuario;
	private String avatarHeroe;

	/**
	 * Constructor para inicializar el objeto personajeHereo
	 * @param vida
	 * @param resistencia
	 * @param movimiento
	 * @param ataque
	 * @param fuerza
	 * @param nombre
	 * @param SAtaque
	 */
	
	public PersonajeHeroe(Usuario u, int vida, double resistencia, int movimiento, double ataque, int fuerza,
			String nombre, int sAtaque) {
		// TODO Auto-generated constructor stub		
		// con super() llamamos al constructor padre
		super(vida, resistencia, movimiento, ataque, fuerza, nombre, sAtaque);
		this.usuario = u;
	}
	
	public PersonajeHeroe() {
		super();
	}

	/**
	 * al pasar turno revisa su nivel de experiencia si es igual o mayor a 15 llama
	 * al metodo subirnivel
	 */
	public void pasarTurno() {
		this.nAtaques = 1;
		this.setMovimientoTurno(this.getMovimiento());
		if (this.getExperiencia() >= 15) {
			this.subirDeNivel();
		}
	}

	// este metodo aumenta todos los valores del heroe solo este tipo de personaje
	// dispone de él
	
	/**
	 * Informa que personajeHereo ha subido de nivel
	 * y los nuevos valores de los atributos
	 */
	public void subirDeNivel() {
		
		this.informar("Felicidades has subido de nivel !!!!!!!! \n "
				+ "Tus atributos se modifican: \n"
				+ "+5 en ataque \n"
				+ "+5 en fuerza\n"
				+ "+8 en movimiento total\n"
				+ "+5 en resistencia \n"
				+ "+1 Super Ataque \n"
				+ "+5 en vida total \n"
				+ "Recuperas toda tus puntos de vida gastados \n");
		
		this.setAtaque( + 5);
		this.setFuerza( + 5);
		this.setMovimiento(+ 8);

		this.setResistencia( + 5);
		this.setSuperAtaque( + 1);
		this.setVida( + 5);
		this.setVidaGastar(this.getVida());
		
		
	}
	
	/**
	* Metodos para interactuar con los objetos arma escudo y artefacto
	*/
	
	/**
	 * Coger un arma para personajeHereo
	 * @param arma
	 */
	private void cogerArma(ObjetoArma arma) {
		
		if(this.getMovimientoTurno()>0) {

		this.informar(arma.getDescripcion());

		@SuppressWarnings("resource")
		Scanner entradaEscaner = new Scanner(System.in);
		
		int entradaTeclado = 0;
		
		while (1!=entradaTeclado && 2 != entradaTeclado) {
			
		System.out.println("Quieres este arma?\n 1 = si,\n 2 = no");
		
		String entrada= entradaEscaner.next();
		
		try {
			entradaTeclado = Integer.parseInt(entrada);
			
		}catch(Exception e) {
			
			System.out.println("No has introducido un número " +e);
		}
		
		if (1!=entradaTeclado  && 2!=entradaTeclado ) {
			
			System.out.println("Opcion incorrecta. Por favor ingresa 1 o 2");
		}
			
		}		
			

		if ( 1==entradaTeclado) {

			if (this.arma == null) {

				this.setMovimiento(arma.getMovimiento());
				this.setFuerza(arma.getFuerza());
				this.setAtaque(arma.getAtaque());

				this.arma = arma;
				
				System.out.println("El arma " + arma.getNombre()+ " ha sido equipada");

			} else {

				
				entradaTeclado=0;
				
				while(entradaTeclado!=1 && entradaTeclado!=2) {
					this.informar("Ya tienes un arma quieres dejarla\n 1 = si, \n 2 = no\"");
					try {
						String entrada = entradaEscaner.next();
						
						entradaTeclado=Integer.parseInt(entrada);
						
						
					}catch(Exception e) {
						this.informar("No has introducido un numero " + e);
					} 
					
					if(entradaTeclado!=1 && entradaTeclado!=2) {
						this.informar("El valor introducido no es correcto. POr favor ingresa 1 o 2");
					}	
				}
				
				

				if (entradaTeclado == 1) {

					this.dejarArma();

					this.setMovimiento(arma.getMovimiento());
					this.setFuerza(arma.getFuerza());
					this.setAtaque(arma.getAtaque());
					
					this.informar("Has desechado el arma "+this.arma.getNombre()+" y te has equipado con "+ arma.getNombre());
					this.arma = arma;
					
					

				}
			}

		} else {

			this.informar("Arma rechazada");
		}		
		
		this.setMovimientoTurno(-1);
		
		}else if(this.getMovimientoTurno()<=0){
			this.informar("No tienes mas movimientos en este turno");
		}
	}

	/**
	 * Metodo para dejar el arma, la cual vuelve al inventario
	 */
	public void dejarArma() {

		if (this.arma != null) {

			this.setMovimiento(-(this.arma.getMovimiento()));
			this.setFuerza(-(this.arma.getFuerza()));
			this.setAtaque(-(this.arma.getAtaque()));
		} else {
			this.informar("no tienes ningun arma equipada que dejar");
		}

	}

	/**
	 * Coger un escudo para personajeHereo
	 * @param escudo
	 */
	private void cogerEscudo(ObjetoEscudo escudo) {
		
		if(this.getMovimientoTurno()>0) {

		this.informar(escudo.getDescripcion());

		@SuppressWarnings("resource")
		Scanner entradaEscaner = new Scanner(System.in);
		
		 int entradaTeclado=0;
		
		while(entradaTeclado!= 1 && entradaTeclado != 2) {
			

		System.out.println("Quieres este Escudo \n 1 si \n 2 no");
		
		try {
			String entrada = entradaEscaner.next();
			
			entradaTeclado=Integer.parseInt(entrada);
			 
			 
		}catch(Exception e){
			System.out.println("No has introducido un numero " + e);
		}

		
		 
		}

		if (entradaTeclado == 1) {

			if (this.escudo == null) {

				this.setMovimiento(escudo.getMovimiento());
				this.setResistencia(escudo.getResistencia());
				this.setAtaque(escudo.getAtaque());
				this.escudo = escudo;
				
				this.informar("Te has equipado con el Escudo " + escudo.getNombre());

			} else {
				 
				entradaTeclado=0;
				
				while(entradaTeclado !=1 && entradaTeclado!=2) {
					
				this.informar("Ya tienes un Escudo quieres dejarla si/no");
				
				try {
					String entrada = entradaEscaner.next();
					
					entradaTeclado = Integer.parseInt(entrada);
					
				}catch(Exception e) {
					System.out.println("El valor introducido no es un numero " + e);
				}
				
				if(entradaTeclado !=1 && entradaTeclado!=2) {
					this.informar("Valor introducido incorrecto. Por favor ingresa 1 o 2");
				}
				
				
				}
				
				if (entradaTeclado == 1) {

					this.dejarEscudo();

					this.setMovimiento(escudo.getMovimiento());
					this.setResistencia(escudo.getResistencia());
					this.setAtaque(escudo.getAtaque());
					
					this.informar("Has dejado el escudo " + this.escudo.getNombre()+ " y te has equipado con el escudo "+ escudo.getNombre());
					this.escudo = escudo;

				}
			}

		} else {

			this.informar("Escudo rechazado");
		}
		this.setMovimientoTurno(-1);
		}else {
			this.informar("No tienes mas movimientos en este turno");
		}
	}

	/**
	 * método para dejar el escudo y que éste vuelva al inventario
	 */
	public void dejarEscudo() {
		if (this.escudo != null) {

			this.setMovimiento(-(escudo.getMovimiento()));
			this.setResistencia(-(escudo.getResistencia()));
			this.setAtaque(-(escudo.getAtaque()));

		} else if(this.getMovimientoTurno()<=0){
			this.informar("No tienes ningun escudo esquipado no puedes dejarlo");
		}

	}

	/**
	 * Coger objetopocion
	 * @param artefacto
	 */
	private void cogerArtefacto(ObjetoPocion artefacto) {

		if(this.getMovimientoTurno()>0) {
		@SuppressWarnings("resource")
		Scanner entradaEscaner = new Scanner(System.in);
		this.verArtefacto(artefacto);
		
		int entradaTeclado =0;
		
		while(entradaTeclado!= 1 && entradaTeclado!= 2) {
			

		this.informar("quieres coger el artefacto \n 1 = si \n 2=no");
		
		try {
			int entrada =Integer.parseInt(entradaEscaner.nextLine());
		
		entradaTeclado= entrada;
		}catch(Exception e) {
			this.informar("El valor que has introducido no es un numero ");
		}
		
		if(entradaTeclado!=1 && entradaTeclado!= 2) {
		this.informar("Valor incorrecto");	
		}

		
		
		}

		if (entradaTeclado == 1) {

			if (this.artefacto == null) {
				this.artefacto = artefacto;
				this.informar("artefacto " + this.artefacto.getNombre() + " equipado");
				
			} else {
				
				entradaTeclado=0;
				
				while(entradaTeclado!=1 && entradaTeclado !=2) {
					this.informar(
						"tienes un artefacto equipado quieres desecharlo o consumirlo? \n  1= desecharlo \n  2 = consumirlo");
					try {
						int entrada =Integer.parseInt(entradaEscaner.nextLine());
						
						entradaTeclado=entrada;
					}catch(Exception e) {
						this.informar("El valor introducido no es un numero " + e);
					}
				

				
				}
				if (entradaTeclado == 1) {

					this.artefacto = artefacto;

				} else if (entradaTeclado == 2) {

					this.consumirArtefacto();

				}

			}
		}
		this.setMovimiento(-1);
		}else if(this.getMovimientoTurno()<=0){
			this.informar("No tienes mas movimientos en este turno");
		}
	}

	public void consumirArtefacto() {
		
		if(this.artefacto == null) {
			this.informar("No tienes ningun artefacto que consumir");
		}else {
			
			this.informar("Has consumido el artefacto " + this.artefacto);
			
			this.informar(" Tus valores varían así ");
			this.verArtefacto(this.artefacto);
			
			this.setVida(this.artefacto.getVida());
			this.setResistencia(this.artefacto.getResistencia());
			this.setMovimiento(this.artefacto.getMovimiento());
			this.setAtaque(this.artefacto.getAtaque());
			this.setFuerza(this.artefacto.getFuerza());
			this.setVidaGastar(this.artefacto.getVidaGastar());
			this.setMovimientoTurno(this.artefacto.getMovimientoTurno());
			this.setSuperAtaque(this.artefacto.getSuperAtaque());
			this.setExperiencia(this.artefacto.getExperiencia());
			
		}		

	}

	public void verArtefacto(ObjetoPocion artefacto) {
		this.informar("Este artefacto modifica los siguientes valores: \n" + "Vida " + artefacto.getVida() + "\n"
				+ "Resistecia " + artefacto.getResistencia() + "\n" + "Movimiento Total " + artefacto.getMovimiento()
				+ "\n" + "Ataque " + artefacto.getAtaque() + "\n" + "Fuerza " + artefacto.getFuerza() + "\n"
				+ "Vida gastada " + artefacto.getVidaGastar() + "\n" + "Movimiento " + artefacto.getMovimiento() + "\n"
				+ "Super Ataques " + artefacto.getSuperAtaque() + "\n" + "Nivel " + artefacto.getExperiencia() + "\n");
	}
 
	private void cogerArtefactoMalo(ArtefactoEnemigo artefacto) {
		this.informar("Has cogido un artefacto dañino tipo " + artefacto.getNombre());
		
		System.out.println("Los siguientes valores se restan automaticamente \n Experiencia = " + (artefacto.getExperiencia())+ "\n"
				+ "Ataque= "+ artefacto.getAtaque() + "\n"
				+ "Fuerza= " +artefacto.getFuerza() +"\n"
				+ "Movimiento del turno= " + artefacto.getMovimientoTurno() +"\n"
				+ "Resistencia= "+ artefacto.getResistencia() + "\n"
				+ "Super Ataque= " +artefacto.getSuperAtaque()+ "\n"
				+ "Vida= " + artefacto.getVidaGastar());
		
		
		
		this.setExperiencia(artefacto.getExperiencia());
		this.setAtaque(artefacto.getAtaque());
		this.setFuerza(artefacto.getFuerza());
		
		this.setMovimientoTurno(artefacto.getMovimientoTurno());
		this.setResistencia(artefacto.getResistencia());
		this.setSuperAtaque(artefacto.getSuperAtaque());
		this.setVidaGastar(artefacto.getVidaGastar());
		
		if (this.getVidaTurno()<=0) {
			this.informar("Has muerto");
			this.morir();
			this.setMuerto(true);
		}

	}
	
	/**
	 * Activar una trampa para personajeHereo
	 * @param trampa
	 */
	public void activarTrampa(ArtefactoTrampa trampa) {
		
		
		this.setMovimientoTurno(-1);
		int vida =trampa.juego();
		this.setVidaGastar(-vida);
		
		if(this.getVidaTurno()<=0) {
			
			this.morir();
			this.informar("El daño ha sido demasiado grande y has muerto");
		}
	
	}
	
	
	/**
	 * Coger un objeto 
	 * @param objeto
	 */
	public void coger(ObjetoPadre objeto) {
		if (objeto instanceof ObjetoArma) {
			this.cogerArma((ObjetoArma) objeto);

		} else if (objeto instanceof ObjetoEscudo) {
			this.cogerEscudo((ObjetoEscudo) objeto);

		} else if (objeto instanceof ArtefactoEnemigo) {
			this.cogerArtefactoMalo((ArtefactoEnemigo) objeto);

		} else if (objeto instanceof ObjetoPocion) {
			this.cogerArtefacto((ObjetoPocion) objeto);
		}
	}
	
	public void setUsuario(Usuario u) {
		this.usuario = u;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public String getAvatarHeroe() {
		return avatarHeroe;
	}

	public void setAvatarHeroe(String avatarHeroe) {
		this.avatarHeroe = avatarHeroe;
	}

}
