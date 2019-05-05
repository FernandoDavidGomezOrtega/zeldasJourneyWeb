package zeldasjourney.objetos.objetoPadre;

import java.util.Objects;

/**
 * Creado por @sergiotremosa el xx/xx/2019.
 * Crear el objetopadre 
 * @author equipo 02
 *
 */
public class ObjetoPadre implements Comparable<ObjetoPadre> {// todos los objetos tienen estos atributos
	
	private int idPropia;
	private int idPantalla;
	
	protected String nombre;
	protected String descripcion;
	protected String tipo;
	
	
	/**
	 * Obtener objetopadre nombre
	 * @return objetopadre nombre
	 */
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String n) {
		this.nombre = n;
	}

	/**
	 * Obtener objetopadre nombre
	 * @return objetopadre nombre
	 */
	public int getIdPropia() {
		return idPropia;
	}
	
	/**
	 * Definir objetopadre idpropia
	 * @param idPropia int idpropia de objetopadre
	 */
	public void setIdPropia(int idPropia) {
		this.idPropia = idPropia;
	}
	
	/**
	 * Obtener objetopadre idpantalla
	 * @return objetopadre idpantalla
	 */
	public int getIdPantalla() {
		return idPantalla;
	}
	
	/**
	 * Definir objetopadre idpantalla
	 * @param idPantalla idpantalla de objetopadre
	 */
	public void setIdPantalla(int idPantalla) {
		this.idPantalla = idPantalla;
	}


	public String getTipo() {
		return tipo;
	}

	/**
	 * Sobreescribimos comparador para ordenar objetos por orden alfabético de nombre.
	 */
	@Override
	public int compareTo(ObjetoPadre o) {
		return this.nombre.compareTo(o.nombre);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ObjetoPadre that = (ObjetoPadre) o;
		return idPropia == that.idPropia &&
				Objects.equals(nombre, that.nombre) &&
				Objects.equals(descripcion, that.descripcion) &&
				Objects.equals(tipo, that.tipo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPropia, nombre, descripcion, tipo);
	}

	@Override
	public String toString() {
		return "ObjetoPadre{" +
				"nombre='" + nombre + '\'' +
				", descripcion='" + descripcion + '\'' +
				", tipo='" + tipo + '\'' +
				'}';
	}

}
