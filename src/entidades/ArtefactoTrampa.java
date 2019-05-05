package entidades;

/**
 * Creado por @sergiotremosa el xx/xx/2019.
 * Crear artefactotrampa de objetopadre.
 */

import java.util.Scanner;
import entidades.ObjetoPadre;


public class ArtefactoTrampa extends ObjetoPadre{
	
	private int numero;
	int diferencia=0;
	
	public ArtefactoTrampa() {
		
		this.nombre="Trampa nÃºmeros";
		this.descripcion="Has caido en una trampa tienes 5 oportunidades para acertar un numero del 1 al 100.\n "
				+ "Si no aciertas la diferencia entre tu Ãºltimo numero introducido y el numero oculto se te restara a la vida";
		this.tipo="DaÃ±ino";
		
		this.numero =(int)(Math.random()*100);
		
		
		
	}
	
	
	/**
	* Funcionamiento de artefactoTrampa en el juego
	*/
	public int juego() {
		
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println(this.nombre);
		
		System.out.println(this.descripcion);
		
		int intentos=0;
		boolean desactivado = false;
		int numeroUsuario = 0;
		
		while(intentos < 5 && !desactivado ) {
			try{
				System.out.println("Te quedan " + (5 - intentos) +" intentos");
				System.out.println("Por favor introduza un número entre 0 y 100");
				numeroUsuario=Integer.parseInt(entrada.next());
				if(this.numero== numeroUsuario) desactivado = true;
				else { intentos += 1;
				if(this.numero > numeroUsuario) {
					
					System.out.println("El numero oculto es mas mayor");
					
					}else {
					
					System.out.println("El numero oculto es menor");
					
				}
				}
			}
			catch (Exception e) {
				System.out.println("Ha introducido un caracter no numérico. \nPor favor introduzca un número");
			}
			
		}
		
		this.diferencia = Math.abs( this.numero - numeroUsuario);
		if(desactivado) {
			System.out.println("Has desactivado la trampa. No sufres daños");
		} 
		else System.out.println("Fallaste. Sufres " + this.diferencia + "puntos de daño");
		
//		for(int i =0; i < 5 ; i++) {
//			
//		System.out.println("Te quedan " + (5 - i) +" intentos");	
//			
//		try {
//			
//			int Numero=Integer.parseInt(entrada.next());
//			this.numeroUsuario= Numero;
//			
//		}catch(Exception e) {
//			System.out.println("El Valor que has introducido no es un numero has perdido un intento ");
//			this.numeroUsuario = 0;
//		}
//		
//		if(this.numeroUsuario > this.numero) {
//			
//			System.out.println("El numero oculto es mas pequeÃ±o");
//			
//		}else if (this.numeroUsuario<this.numero) {
//			
//			System.out.println("El numero oculto es mas grande");
//			
//		}else{
//			System.out.println("Felicidades acertaste el numero, no sufres ningun daÃ±o ");
//			
//			i=5;
//		}
//				
//		}
//		
//		if(this.numero!=this.numeroUsuario) {
//			
//			if(this.numero>this.numeroUsuario) {
//				this.diferencia= this.numero-this.numeroUsuario;
//			}else if(this.numeroUsuario> this.numero) {
//				this.diferencia= this.numeroUsuario - this.numero;
//			}
//			
//			System.out.println("No pudiste acertar pierdes " + this.diferencia + " puntos de vida");
//			
//		}
//		
		return this.diferencia;
	}
	
	

}
