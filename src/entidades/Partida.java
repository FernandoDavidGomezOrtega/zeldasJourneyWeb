package zeldasjourney.partida;

import zeldasjourney.objetos.objetoHijo.ObjetoArma;
import zeldasjourney.objetos.objetoHijo.ObjetoArtefacto;
import zeldasjourney.objetos.objetoHijo.ObjetoEscudo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Partida {

    private Integer idPropia;
    private String nombre;
    private String descripcion;
    private List<ObjetoArma> armas = new ArrayList<>();
    private List<ObjetoArtefacto> artefactos = new ArrayList<>();
    private List<ObjetoEscudo> escudos = new ArrayList<>();

    public Integer getIdPropia() {
        return idPropia;
    }

    public void setIdPropia(Integer idPartida) {
        this.idPropia = idPartida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<ObjetoArma> getArmas() {
        return armas;
    }

    public void setArmas(List<ObjetoArma> armas) {
        this.armas = armas;
    }

    public List<ObjetoArtefacto> getArtefactos() {
        return artefactos;
    }

    public void setArtefactos(List<ObjetoArtefacto> artefactos) {
        this.artefactos = artefactos;
    }

    public List<ObjetoEscudo> getEscudos() {
        return escudos;
    }

    public void setEscudos(List<ObjetoEscudo> escudos) {
        this.escudos = escudos;
    }

    public void addArma(ObjetoArma arma) {
        this.armas.add(arma);
    }

    public void addArtefacto(ObjetoArtefacto artefacto) {
        this.artefactos.add(artefacto);
    }

    public void addEscudo(ObjetoEscudo escudo) {
        this.escudos.add(escudo);
    }

    public void deleteArma(ObjetoArma arma) {
        this.armas.remove(arma);
    }

    public void deleteArtefacto(ObjetoArtefacto artefacto) {
        this.artefactos.remove(artefacto);
    }

    public void deleteEscudo(ObjetoEscudo escudo) {
        this.escudos.remove(escudo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partida partida = (Partida) o;
        return idPropia == partida.idPropia &&
                Objects.equals(nombre, partida.nombre) &&
                Objects.equals(descripcion, partida.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPropia, nombre, descripcion);
    }
}
