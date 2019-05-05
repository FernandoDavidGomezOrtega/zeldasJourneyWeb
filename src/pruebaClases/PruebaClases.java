package zeldasjourney;

import java.util.Scanner;

import zeldasjourney.artefactoEnemigo.ArtefactoEnemigo;
import zeldasjourney.artefactoEnemigo.ArtefactoTrampa;
import zeldasjourney.objetoBeneficio.ObjetoPocion;
import zeldasjourney.objetos.objetoHijo.ObjetoArma;
import zeldasjourney.objetos.objetoHijo.ObjetoEscudo;
import zeldasjourney.personaje.personajesHijo.EnemigoComun;
import zeldasjourney.personaje.personajesHijo.PersonajeEnemigoJefe;
import zeldasjourney.personaje.personajesHijo.PersonajeHeroe;


/**
 *Esta clase sirve para hacer un testeo del correcto funcionamiento
 *de las clases implementadas hasta el momento
 * @author grupo 02
 *
 */
public class PruebaClases {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner(System.in);

		/*
		*Prueba de personajes
		*/
		
		/*
		 * Creacion heroe
		 */
		PersonajeHeroe Heroe1 = new PersonajeHeroe(30, 10, 10, 2, 5, "Ruggerini", 5);
		
		/*
		*Creación enemigos comunes
		*/
		EnemigoComun Enemigo1 = new EnemigoComun(5, 5, 5, 1, 5, "JOSmith");
		EnemigoComun Enemigo2 = new EnemigoComun(5, 5, 5, 1, 5, "LBelindaR");
		EnemigoComun Enemigo3 = new EnemigoComun(5, 5, 5, 1, 5, "Mazali");
		EnemigoComun Enemigo4 = new EnemigoComun(5, 5, 5, 1, 5, "Concicao");
		EnemigoComun Enemigo5 = new EnemigoComun(5, 5, 5, 1, 5, "LBelindaR");
		EnemigoComun Enemigo6 = new EnemigoComun(5, 5, 5, 1, 5, "LBelindaR");
		
		/*
		*Creacion PersonajeEnemigoJefe
		*/

		PersonajeEnemigoJefe Jefe1 = new PersonajeEnemigoJefe(50, 10, 15, 5, 7, "SanAscal", 3);
		
		/*
		*Creacion de distintos tipos de Ojetos (Armas, pocimas, etc)
		*/
		
				ObjetoArma Arma1 = new ObjetoArma("Espada Mata demonios", 5, 2,3);
				ObjetoArma Arma2 = new ObjetoArma("Hacha espanta Gaviotas", 10, 3,2);
				
				ObjetoEscudo Escudo1 = new ObjetoEscudo("Escudo Espejo", 3, 2, -1);
				ObjetoEscudo Escudo2 = new ObjetoEscudo("Escudo Mágico", 4,3,0);
				
				ArtefactoTrampa Trampa1 = new ArtefactoTrampa();
				ArtefactoEnemigo Veneno1 = new ArtefactoEnemigo("Veneno azul", -10, -10, -10, -10, -10, -10, -10, -1, -10);
				
				ObjetoPocion Pocion1 = new ObjetoPocion("Poción multivitamínica" , 10, 10, 10, 10, -10, 5, 3, 5, 15);

		Heroe1.informar("1-------------------------------------------------------------------------------- Setters y getters");
	
		/*
		* Prueba Setters y getters para objervar las variaciones
		*/

		Heroe1.informar("El nombre del heroe es " + Heroe1.getNombre());
		Heroe1.setNombre("Claudia Ruggerini");
		Heroe1.informar("El nombre del heroe es " + Heroe1.getNombre());

		Heroe1.informar(Heroe1.getNombre() + " Su ataque tiene un valor de " + Heroe1.getAtaque());
		Heroe1.setAtaque(5);
		Heroe1.informar(Heroe1.getNombre() + " Su ataque tiene un valor de " + Heroe1.getAtaque());
		Heroe1.informar("2--------------------------------------------------------------------------------");

		Heroe1.informar(Heroe1.getNombre() + " Tiene una experiencia de " + Heroe1.getExperiencia());
		Heroe1.setExperiencia(10);
		Heroe1.informar(Heroe1.getNombre() + " Tiene una experiencia de " + Heroe1.getExperiencia());
		Heroe1.informar("3--------------------------------------------------------------------------------");

		Heroe1.informar(Heroe1.getNombre() + " Tiene una fuerza de " + Heroe1.getFuerza());
		Heroe1.setFuerza(5);
		Heroe1.informar(Heroe1.getNombre() + " Tiene una fuerza de " + Heroe1.getFuerza());
		Heroe1.informar("4--------------------------------------------------------------------------------");

		Heroe1.informar(Heroe1.getNombre() + " Tine un movimiento total de " + Heroe1.getMovimiento());
		Heroe1.setMovimiento(10);
		Heroe1.informar(Heroe1.getNombre() + " Tine un movimiento total de " + Heroe1.getMovimiento());
		Heroe1.informar("5--------------------------------------------------------------------------------");

		Heroe1.informar(
				Heroe1.getNombre() + " En este turno dispone de un movimiento de " + Heroe1.getMovimientoTurno());
		Heroe1.setMovimientoTurno(20); // El movimiento que dispone el Personaje en el turno nunca puede superar el
										// movimiento total.
		Heroe1.informar(
				Heroe1.getNombre() + " En este turno dispone de un movimiento de " + Heroe1.getMovimientoTurno());
		Heroe1.informar("6--------------------------------------------------------------------------------");

		Heroe1.informar(Heroe1.getNombre() + " Tiene una resistencia de " + Heroe1.getResistencia());
		Heroe1.setResistencia(5);
		Heroe1.informar(Heroe1.getNombre() + " Tiene una resistencia de " + Heroe1.getResistencia());
		Heroe1.informar("7--------------------------------------------------------------------------------");

		Heroe1.informar(
				Heroe1.getNombre() + " Tiene un numero de super ataques por pantalla de " + Heroe1.getSuperAtaques());
		Heroe1.setSuperAtaque(10);// los super ataques siempre seran 5 como máximo
		Heroe1.informar(
				Heroe1.getNombre() + " Tiene un numero de super ataques por pantalla de " + Heroe1.getSuperAtaques());
		Heroe1.informar("8--------------------------------------------------------------------------------");

		Heroe1.informar(Heroe1.getNombre() + " Tiene una vida total de " + Heroe1.getVida());
		Heroe1.setVida(10);
		Heroe1.informar(Heroe1.getNombre() + " Tiene una vida total de " + Heroe1.getVida());
		Heroe1.informar("9--------------------------------------------------------------------------------");

		Heroe1.informar(Heroe1.getNombre() + " Su vida en este momento del juego es de " + Heroe1.getVidaTurno());
		Heroe1.setVidaGastar(20); // La vida consumida durante el juego no puede ser mayor a la vida total
		Heroe1.informar(Heroe1.getNombre() + " Su vida en este momento del juego es de " + Heroe1.getVidaTurno());
		Heroe1.informar("10-------------------------------------------------------------------------------- Heroe ataca Enemigo1");
		
		/**
		* Interacción con otros Personajes
		*/		
		
		//Ataque Normal
		Heroe1.ataque(Enemigo1);
		//Solo se puede atacar una ver por turno 
		Heroe1.ataque(Enemigo1);
		// Hay que pasar turno 
		Heroe1.pasarTurno();
		
		Heroe1.informar("11----------------------------------------------------------- Turno del enemigo \n Pulsa una tecla");
		entrada.nextLine();
		
		Enemigo1.ataque(Heroe1);
		Enemigo1.pasarTurno();
		
		//Super Ataque	
		Heroe1.informar("12------------------------------------------------------------Turno del heroe realiza un super ataque \n Pulsa una tecla");
		entrada.nextLine();
		
		Heroe1.informar("Ataca con el valor ataque multiplicado por 2");
		
		Heroe1.sAtaque(Enemigo1);
		
		
		/*
		*ObjetoArtefacto Pocion = new ObjetoArtefacto();
		*/
		
		Heroe1.informar("13---------------------------------------------------------------------------Coger nueva arma, y pasa el turno \n Pulsa una tecla");
		entrada.nextLine();
		
		Heroe1.informar(Heroe1.getNombre() + " Su ataque tiene un valor de " + Heroe1.getAtaque());
		
		Heroe1.coger(Arma1);
		
		Heroe1.informar(Heroe1.getNombre() + " Su ataque tiene un valor de " + Heroe1.getAtaque());
		
		Heroe1.pasarTurno();
		
		Heroe1.informar("14--------------------------------------------------------------------------Atacan los enemigos cercanos y pasan turno  \n Pulsa una tecla");
		entrada.nextLine();
		
		Enemigo2.ataque(Heroe1);
		
		Enemigo2.pasarTurno();
		
		Enemigo3.ataque(Heroe1);
		
		Enemigo3.pasarTurno();
		
		Heroe1.informar("15----------------------------------------------------------------------------Ataca el heroe \n Pulsa una tecla");
		entrada.nextLine();
		Heroe1.ataque(Enemigo2);
		
		Heroe1.informar("16----------------------------------------------------------------------------El heroe coge otro arma  \n Pulsa una tecla");
		
		Heroe1.coger(Arma2);
		
		Heroe1.informar("" + Heroe1.getAtaque());
		
		Heroe1.informar("17---------------------------------------------------------------------------- El Heroe coge dos escudos desechando uno \n Pulsa una tecla");
		entrada.nextLine();
		
		Heroe1.coger(Escudo1);
		
		Heroe1.coger(Escudo2);
		
		Heroe1.informar("18----------------------------------------------------------------------------Heroe activa trampa  \n Pulsa una tecla");
		entrada.nextLine();
		
		Heroe1.activarTrampa(Trampa1);
		
		Heroe1.informar("19-------------------------------------------------------------------------------Heroe coge poción  \n Pulsa una tecla");
		entrada.nextLine();
		
		Heroe1.coger(Pocion1);
		
		Heroe1.informar("20-------------------------------------------------------------------------------Heroe coge veneno  \n Pulsa una tecla");
		entrada.nextLine();
		
		Heroe1.coger(Veneno1);
		
		Heroe1.informar("21--------------------------------------------------------------------------------Heroe consume Poción equipada  \n Pulsa una tecla");
		entrada.nextLine();
		
		Heroe1.consumirArtefacto();
		
		Heroe1.pasarTurno();
		
		Heroe1.informar("22--------------------------------------------------------------------------------Heroe lucha con enemigos y pasa turno  \n Pulsa una tecla");
		entrada.nextLine();
		
		Heroe1.ataque(Enemigo1);
		
		Heroe1.ataque(Enemigo2);
		
		Heroe1.pasarTurno();
		
		Heroe1.informar("23----------------------------------------------------------------------------------Turno de los enemigos  \n Pulsa una tecla");
		entrada.nextLine();
		
		Enemigo2.ataque(Heroe1);
		
		Enemigo2.pasarTurno();
		
		Enemigo3.ataque(Heroe1);
		
		Enemigo3.pasarTurno();
		
		Heroe1.informar("24-----------------------------------------------------------------------------------Turno Hereo de nuevo \n Pulsa una tecla");
		entrada.nextLine();
		
		Heroe1.ataque(Enemigo3);
		
		Heroe1.pasarTurno();
		
		Heroe1.informar("--------------------------------------------------------------------------------------Heroe ataca Jefe  \n Pulsa una tecla");
		entrada.nextLine();
		
		
		Heroe1.sAtaque(Jefe1);
		
		

	}

}
