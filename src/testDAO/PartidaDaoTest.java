/*
package zeldasjourney.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zeldasjourney.jdbc.ConnectionDB;
import zeldasjourney.objetos.objetoHijo.ObjetoArma;
import zeldasjourney.objetos.objetoHijo.ObjetoArtefacto;
import zeldasjourney.objetos.objetoHijo.ObjetoEscudo;
import zeldasjourney.partida.Partida;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static zeldasjourney.jdbc.ConnectionDB.printSQLException;

class PartidaDaoTest {

    private Connection connection;
    private PartidaDao partidaDao;
    private ArmasDao armasDao;
    private ArtefactoDao artefactoDao;
    private EscudoDao escudoDao;

    @BeforeEach
    void before() throws Exception {
        ConnectionDB cdb = new ConnectionDB();
        connection = cdb.openConnection();
        connection.setAutoCommit(false);
        partidaDao = new PartidaDao(connection);
        armasDao = new ArmasDao(connection);
        artefactoDao = new ArtefactoDao(connection);
        escudoDao = new EscudoDao(connection);
    }

    @AfterEach
    void after() throws SQLException {
        try {
            connection.rollback();
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            connection.close();
        }
    }


    @Test
    void saveAndGet() {

        Partida partida = new Partida();
        partida.setNombre("partida1");
        partida.setDescripcion("descripcion partida");

        partidaDao.save(partida);
        Optional<Partida> partidaFromDB = partidaDao.get(partida.getIdPropia());

        assertTrue(partidaFromDB.isPresent());
        assertEquals(partida.getIdPropia(), partidaFromDB.get().getIdPropia());
        assertEquals("partida1", partidaFromDB.get().getNombre());
        assertEquals("descripcion partida", partidaFromDB.get().getDescripcion());

    }

    @Test
    void getAll() {

        Partida partida = new Partida();
        partida.setNombre("partida1");
        partida.setDescripcion("descripcion partida");

        Partida partida2 = new Partida();
        partida2.setNombre("partida2");
        partida2.setDescripcion("descripcion partida2");

        partidaDao.save(partida);
        partidaDao.save(partida2);

        List<Partida> partidas = partidaDao.getAll();

        assertTrue(partidas.contains(partida));
        assertTrue(partidas.contains(partida2));
    }

    @Test
    void update() {

        Partida partida1 = new Partida();

        partida1.setNombre("partidaA");
        partida1.setDescripcion("descripcion nueva partida");

        partidaDao.save(partida1);

        partida1.setNombre("partidaB");
        partida1.setDescripcion("descripcion nueva partida");

        partidaDao.update(partida1);


        Optional<Partida> partidaFromDB = partidaDao.get(partida1.getIdPropia());

        assertTrue(partidaFromDB.isPresent());
        assertEquals("partidaB", partidaFromDB.get().getNombre());
    }

    @Test
    void delete() {

        Partida partida = new Partida();

        partida.setNombre("partidaA");
        partida.setDescripcion("descripcion nueva partida");

        partidaDao.save(partida);

        Optional<Partida> partidaFromDB = partidaDao.get(partida.getIdPropia());
        assertTrue(partidaFromDB.isPresent());

        partidaDao.delete(partida);

        partidaFromDB = partidaDao.get(partida.getIdPropia());
        assertFalse(partidaFromDB.isPresent());
    }

    @Test
    void addArma() {

        Partida partida = new Partida();
        partida.setNombre("partidaA");
        partida.setDescripcion("descripcion nueva partida");

        ObjetoArma arma1 = new ObjetoArma("test arma 1", 1, 2, 3);
        ObjetoArma arma2 = new ObjetoArma("test arma 2", 4, 5, 6);

        partidaDao.save(partida);
        armasDao.save(arma1);
        armasDao.save(arma2);

        Partida partidaFromDB = partidaDao.get(partida.getIdPropia())
                .orElseThrow(IllegalArgumentException::new);

        assertTrue(partidaFromDB.getArmas().isEmpty());

        partidaDao.addArma(partidaFromDB, arma1);

        assertTrue(partidaFromDB.getArmas().contains(arma1));
        assertEquals(1, partidaFromDB.getArmas().size());

        partidaFromDB = partidaDao.get(partida.getIdPropia())
                .orElseThrow(IllegalArgumentException::new);

        assertTrue(partidaFromDB.getArmas().contains(arma1));
        assertEquals(1, partidaFromDB.getArmas().size());

        partidaDao.addArma(partidaFromDB, arma2);

        assertTrue(partidaFromDB.getArmas().contains(arma1));
        assertTrue(partidaFromDB.getArmas().contains(arma2));
        assertEquals(2, partidaFromDB.getArmas().size());

        partidaFromDB = partidaDao.get(partida.getIdPropia())
                .orElseThrow(IllegalArgumentException::new);

        assertTrue(partidaFromDB.getArmas().contains(arma1));
        assertTrue(partidaFromDB.getArmas().contains(arma2));
        assertEquals(2, partidaFromDB.getArmas().size());

        partidaDao.addArma(partidaFromDB, arma2);

        assertTrue(partidaFromDB.getArmas().contains(arma1));
        assertTrue(partidaFromDB.getArmas().contains(arma2));
        assertEquals(2, partidaFromDB.getArmas().size());

        partidaFromDB = partidaDao.get(partida.getIdPropia())
                .orElseThrow(IllegalArgumentException::new);

        assertTrue(partidaFromDB.getArmas().contains(arma1));
        assertTrue(partidaFromDB.getArmas().contains(arma2));
        assertEquals(2, partidaFromDB.getArmas().size());
    }

    @Test
    void deleteArma() {

        Partida partida = new Partida();
        partida.setNombre("partidaA");
        partida.setDescripcion("descripcion nueva partida");

        ObjetoArma arma1 = new ObjetoArma("test arma 1", 1, 2, 3);
        ObjetoArma arma2 = new ObjetoArma("test arma 2", 4, 5, 6);

        partidaDao.save(partida);
        armasDao.save(arma1);
        armasDao.save(arma2);

        partidaDao.addArma(partida, arma1);
        partidaDao.addArma(partida, arma2);

        Partida partidaFromDB = partidaDao.get(partida.getIdPropia())
                .orElseThrow(IllegalArgumentException::new);

        assertTrue(partidaFromDB.getArmas().contains(arma1));
        assertTrue(partidaFromDB.getArmas().contains(arma2));
        assertEquals(2, partidaFromDB.getArmas().size());

        partidaDao.deleteArma(partidaFromDB, arma1);

        assertFalse(partidaFromDB.getArmas().contains(arma1));
        assertTrue(partidaFromDB.getArmas().contains(arma2));
        assertEquals(1, partidaFromDB.getArmas().size());

        partidaFromDB = partidaDao.get(partida.getIdPropia())
                .orElseThrow(IllegalArgumentException::new);

        assertFalse(partidaFromDB.getArmas().contains(arma1));
        assertTrue(partidaFromDB.getArmas().contains(arma2));
        assertEquals(1, partidaFromDB.getArmas().size());

        partidaDao.deleteArma(partidaFromDB, arma2);

        assertFalse(partidaFromDB.getArmas().contains(arma1));
        assertFalse(partidaFromDB.getArmas().contains(arma2));
        assertEquals(0, partidaFromDB.getArmas().size());

        partidaFromDB = partidaDao.get(partida.getIdPropia())
                .orElseThrow(IllegalArgumentException::new);

        assertFalse(partidaFromDB.getArmas().contains(arma1));
        assertFalse(partidaFromDB.getArmas().contains(arma2));
        assertEquals(0, partidaFromDB.getArmas().size());



    }

    @Test
    void addArtefacto() {

        Partida partida = new Partida();
        partida.setNombre("partidaA");
        partida.setDescripcion("descripcion nueva partida");

        ObjetoArtefacto artefacto1 = new ObjetoArtefacto("artefacto1", "descripcion artefacto", 2, 2.2, 5, 5.0, 5, 6, 7, 8, 9);
        ObjetoArtefacto artefacto2 = new ObjetoArtefacto("artefacto2", "descripcion artefacto", 2, 2.2, 5, 5.0, 5, 6, 7, 8, 9);

        partidaDao.save(partida);
        artefactoDao.save(artefacto2);
        artefactoDao.save(artefacto1);

        Partida partidaFromDB = partidaDao.get(partida.getIdPropia())
                .orElseThrow(IllegalArgumentException::new);

        assertTrue(partidaFromDB.getArtefactos().isEmpty());

        partidaDao.addArtefacto(partidaFromDB, artefacto1);

        assertTrue(partidaFromDB.getArtefactos().contains(artefacto1));
        assertEquals(1, partidaFromDB.getArtefactos().size());

        partidaFromDB = partidaDao.get(partida.getIdPropia())
                .orElseThrow(IllegalArgumentException::new);

        assertTrue(partidaFromDB.getArtefactos().contains(artefacto1));
        assertEquals(1, partidaFromDB.getArtefactos().size());

        partidaDao.addArtefacto(partidaFromDB, artefacto2);

        assertTrue(partidaFromDB.getArtefactos().contains(artefacto1));
        assertTrue(partidaFromDB.getArtefactos().contains(artefacto2));
        assertEquals(2, partidaFromDB.getArtefactos().size());

        partidaFromDB = partidaDao.get(partida.getIdPropia())
                .orElseThrow(IllegalArgumentException::new);

        assertTrue(partidaFromDB.getArtefactos().contains(artefacto1));
        assertTrue(partidaFromDB.getArtefactos().contains(artefacto2));
        assertEquals(2, partidaFromDB.getArtefactos().size());

        partidaDao.addArtefacto(partidaFromDB, artefacto2);

        assertTrue(partidaFromDB.getArtefactos().contains(artefacto1));
        assertTrue(partidaFromDB.getArtefactos().contains(artefacto2));
        assertEquals(2, partidaFromDB.getArtefactos().size());

        partidaFromDB = partidaDao.get(partida.getIdPropia())
                .orElseThrow(IllegalArgumentException::new);

        assertTrue(partidaFromDB.getArtefactos().contains(artefacto1));
        assertTrue(partidaFromDB.getArtefactos().contains(artefacto2));
        assertEquals(2, partidaFromDB.getArtefactos().size());
    }

    @Test
    void deleteArtefacto() {

        Partida partida = new Partida();
        partida.setNombre("partidaA");
        partida.setDescripcion("descripcion nueva partida");

        ObjetoArtefacto artefacto1 = new ObjetoArtefacto("artefacto1", "descripcion artefacto", 2, 2.2, 5, 5.0, 5, 6, 7, 8, 9);
        ObjetoArtefacto artefacto2 = new ObjetoArtefacto("artefacto2", "descripcion artefacto", 2, 2.2, 5, 5.0, 5, 6, 7, 8, 9);

        partidaDao.save(partida);
        artefactoDao.save(artefacto1);
        artefactoDao.save(artefacto2);

        partidaDao.addArtefacto(partida, artefacto1);
        partidaDao.addArtefacto(partida, artefacto2);

        Partida partidaFromDB = partidaDao.get(partida.getIdPropia())
                .orElseThrow(IllegalArgumentException::new);

        assertTrue(partidaFromDB.getArtefactos().contains(artefacto1));
        assertTrue(partidaFromDB.getArtefactos().contains(artefacto2));
        assertEquals(2, partidaFromDB.getArtefactos().size());

        partidaDao.deleteArtefacto(partidaFromDB, artefacto1);

        assertFalse(partidaFromDB.getArtefactos().contains(artefacto1));
        assertTrue(partidaFromDB.getArtefactos().contains(artefacto2));
        assertEquals(1, partidaFromDB.getArtefactos().size());

        partidaFromDB = partidaDao.get(partida.getIdPropia())
                .orElseThrow(IllegalArgumentException::new);

        assertFalse(partidaFromDB.getArtefactos().contains(artefacto1));
        assertTrue(partidaFromDB.getArtefactos().contains(artefacto2));
        assertEquals(1, partidaFromDB.getArtefactos().size());

        partidaDao.deleteArtefacto(partidaFromDB, artefacto2);

        assertFalse(partidaFromDB.getArtefactos().contains(artefacto1));
        assertFalse(partidaFromDB.getArtefactos().contains(artefacto2));
        assertEquals(0, partidaFromDB.getArtefactos().size());

        partidaFromDB = partidaDao.get(partida.getIdPropia())
                .orElseThrow(IllegalArgumentException::new);

        assertFalse(partidaFromDB.getArtefactos().contains(artefacto1));
        assertFalse(partidaFromDB.getArtefactos().contains(artefacto2));
        assertEquals(0, partidaFromDB.getArtefactos().size());

    }

    @Test
    void addEscudo() {

        Partida partida = new Partida();
        partida.setNombre("partidaA");
        partida.setDescripcion("descripcion nueva partida");

        ObjetoEscudo escudo1 = new ObjetoEscudo("test escudo 1", 1, 2, 3);
        ObjetoEscudo escudo2 = new ObjetoEscudo("test escudo 2", 4, 5, 6);

        partidaDao.save(partida);
        escudoDao.save(escudo1);
        escudoDao.save(escudo2);

        Partida partidaFromDB = partidaDao.get(partida.getIdPropia())
                .orElseThrow(IllegalArgumentException::new);

        assertTrue(partidaFromDB.getEscudos().isEmpty());

        partidaDao.addEscudo(partidaFromDB, escudo1);

        assertTrue(partidaFromDB.getEscudos().contains(escudo1));
        assertEquals(1, partidaFromDB.getEscudos().size());

        partidaFromDB = partidaDao.get(partida.getIdPropia())
                .orElseThrow(IllegalArgumentException::new);

        assertTrue(partidaFromDB.getEscudos().contains(escudo1));
        assertEquals(1, partidaFromDB.getEscudos().size());

        partidaDao.addEscudo(partidaFromDB, escudo2);

        assertTrue(partidaFromDB.getEscudos().contains(escudo1));
        assertTrue(partidaFromDB.getEscudos().contains(escudo2));
        assertEquals(2, partidaFromDB.getEscudos().size());

        partidaFromDB = partidaDao.get(partida.getIdPropia())
                .orElseThrow(IllegalArgumentException::new);

        assertTrue(partidaFromDB.getEscudos().contains(escudo1));
        assertTrue(partidaFromDB.getEscudos().contains(escudo2));
        assertEquals(2, partidaFromDB.getEscudos().size());

        partidaDao.addEscudo(partidaFromDB, escudo2);

        assertTrue(partidaFromDB.getEscudos().contains(escudo1));
        assertTrue(partidaFromDB.getEscudos().contains(escudo2));
        assertEquals(2, partidaFromDB.getEscudos().size());

        partidaFromDB = partidaDao.get(partida.getIdPropia())
                .orElseThrow(IllegalArgumentException::new);

        assertTrue(partidaFromDB.getEscudos().contains(escudo1));
        assertTrue(partidaFromDB.getEscudos().contains(escudo2));
        assertEquals(2, partidaFromDB.getEscudos().size());
    }

    @Test
    void deleteEscudo() {

        Partida partida = new Partida();
        partida.setNombre("partidaA");
        partida.setDescripcion("descripcion nueva partida");

        ObjetoEscudo escudo1 = new ObjetoEscudo("test escudo 1", 1, 2, 3);
        ObjetoEscudo escudo2 = new ObjetoEscudo("test escudo 2", 4, 5, 6);

        partidaDao.save(partida);
        escudoDao.save(escudo1);
        escudoDao.save(escudo2);

        partidaDao.addEscudo(partida, escudo1);
        partidaDao.addEscudo(partida, escudo2);

        Partida partidaFromDB = partidaDao.get(partida.getIdPropia())
                .orElseThrow(IllegalArgumentException::new);

        assertTrue(partidaFromDB.getEscudos().contains(escudo1));
        assertTrue(partidaFromDB.getEscudos().contains(escudo2));
        assertEquals(2, partidaFromDB.getEscudos().size());

        partidaDao.deleteEscudo(partidaFromDB, escudo1);

        assertFalse(partidaFromDB.getEscudos().contains(escudo1));
        assertTrue(partidaFromDB.getEscudos().contains(escudo2));
        assertEquals(1, partidaFromDB.getEscudos().size());

        partidaFromDB = partidaDao.get(partida.getIdPropia())
                .orElseThrow(IllegalArgumentException::new);

        assertFalse(partidaFromDB.getEscudos().contains(escudo1));
        assertTrue(partidaFromDB.getEscudos().contains(escudo2));
        assertEquals(1, partidaFromDB.getEscudos().size());

        partidaDao.deleteEscudo(partidaFromDB, escudo2);

        assertFalse(partidaFromDB.getEscudos().contains(escudo1));
        assertFalse(partidaFromDB.getEscudos().contains(escudo2));
        assertEquals(0, partidaFromDB.getEscudos().size());

        partidaFromDB = partidaDao.get(partida.getIdPropia())
                .orElseThrow(IllegalArgumentException::new);

        assertFalse(partidaFromDB.getEscudos().contains(escudo1));
        assertFalse(partidaFromDB.getEscudos().contains(escudo2));
        assertEquals(0, partidaFromDB.getEscudos().size());

    }
}
*/