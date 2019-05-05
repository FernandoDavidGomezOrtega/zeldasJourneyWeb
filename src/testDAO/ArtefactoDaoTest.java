package zeldasjourney.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zeldasjourney.jdbc.ConnectionDB;
import zeldasjourney.objetos.objetoHijo.ObjetoArtefacto;
import zeldasjourney.objetos.objetoHijo.ObjetoEscudo;
import zeldasjourney.partida.Partida;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static zeldasjourney.jdbc.ConnectionDB.printSQLException;

class ArtefactoDaoTest {

    private Connection connection;
    private ArtefactoDao artefactoDao;

    @BeforeEach
    void before() throws Exception {
        ConnectionDB cdb = new ConnectionDB();
        connection = cdb.openConnection();
        connection.setAutoCommit(false);
        artefactoDao = new ArtefactoDao(connection);
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


        //String nombre, String descripcion, int vida, double resistencia, int movimiento, double ataque, int fuerza, int VidaGastar, int MovimientoTurno, int SuperAtaque, int nivel
        ObjetoArtefacto artefacto = new ObjetoArtefacto("test artefacto","descripcion artefacto", 2, 2.2, 5, 5.0, 6, 6, 7, 8, 9);

        artefactoDao.save(artefacto);
        Optional<ObjetoArtefacto> artefactoFromDB = artefactoDao.get(artefacto.getIdPropia());

        assertTrue(artefactoFromDB.isPresent());
        assertEquals(artefacto.getIdPropia(), artefactoFromDB.get().getIdPropia());
        assertEquals("test artefacto", artefactoFromDB.get().getNombre());
        assertEquals("descripcion artefacto", artefactoFromDB.get().getDescripcion());
        assertEquals(6, artefactoFromDB.get().getVidaGastar());
        assertEquals(2, artefactoFromDB.get().getVida());
        assertEquals(2.2, artefactoFromDB.get().getResistencia());
        assertEquals(5, artefactoFromDB.get().getMovimiento());
        assertEquals(5.0, artefactoFromDB.get().getAtaque());
        assertEquals(6, artefactoFromDB.get().getFuerza());
        assertEquals(7, artefactoFromDB.get().getMovimientoTurno());
        assertEquals(8, artefactoFromDB.get().getSuperAtaque());
        assertEquals(9, artefactoFromDB.get().getNivel());
    }

    @Test
    void getAll() {

        ObjetoArtefacto artefacto1 = new ObjetoArtefacto("test artefacto", "descripcion artefacto", 2, 2.2, 5, 5.0, 5, 6, 7, 8, 9);
        ObjetoArtefacto artefacto2 = new ObjetoArtefacto("test artefacto", "descripcion artefacto", 2, 2.2, 5, 5.0, 5, 6, 7, 8, 9);

        artefactoDao.save(artefacto1);
        artefactoDao.save(artefacto2);

        List<ObjetoArtefacto> artefactos = artefactoDao.getAll();

        assertTrue(artefactos.contains(artefacto1));
        assertTrue(artefactos.contains(artefacto2));
    }

    @Test
    void update() {

        ObjetoArtefacto artefacto = new ObjetoArtefacto("test artefacto", "descripcion artefacto", 2, 2.2, 5, 5.0, 6, 6, 7, 8, 9);

        artefactoDao.save(artefacto);
        artefacto.setNombre("test artefacto2");
        artefacto.setDescripcion("descripcion artefacto");
        artefacto.setVida(2);
        artefacto.setVidaGastar(6);
        artefacto.setResistencia(2.2);
        artefacto.setMovimiento(5);
        artefacto.setAtaque(5.0);
        artefacto.setFuerza(6);
        artefacto.setMovimientoTurno(7);
        artefacto.setSuperAtaque(8);
        artefacto.setNivel(9);
        artefactoDao.update(artefacto);

        Optional<ObjetoArtefacto> artefactoFromDB = artefactoDao.get(artefacto.getIdPropia());

        assertTrue(artefactoFromDB.isPresent());
        assertEquals("test artefacto2", artefactoFromDB.get().getNombre());
        assertEquals("descripcion artefacto", artefactoFromDB.get().getDescripcion());
        assertEquals(2, artefactoFromDB.get().getVida());
        assertEquals(6, artefactoFromDB.get().getVidaGastar());
        assertEquals(2.2, artefactoFromDB.get().getResistencia());
        assertEquals(5, artefactoFromDB.get().getMovimiento());
        assertEquals(5.0, artefactoFromDB.get().getAtaque());
        assertEquals(6, artefactoFromDB.get().getFuerza());
        assertEquals(7, artefactoFromDB.get().getMovimientoTurno());
        assertEquals(8, artefactoFromDB.get().getSuperAtaque());
        assertEquals(9, artefactoFromDB.get().getNivel());
    }

    @Test
    void delete() {

        ObjetoArtefacto artefacto = new ObjetoArtefacto("test artefacto", "descripcion artefacto", 2, 2.2, 5, 5.0, 5, 6, 7, 8, 9);

        artefactoDao.save(artefacto);

        Optional<ObjetoArtefacto> artefactoFromDB = artefactoDao.get(artefacto.getIdPropia());
        assertTrue(artefactoFromDB.isPresent());

        artefactoDao.delete(artefacto);

        artefactoFromDB = artefactoDao.get(artefacto.getIdPropia());
        assertFalse(artefactoFromDB.isPresent());
    }
}