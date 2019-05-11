/*
package zeldasjourney.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zeldasjourney.jdbc.ConnectionDB;
import zeldasjourney.objetos.objetoHijo.ObjetoEscudo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static zeldasjourney.jdbc.ConnectionDB.printSQLException;

class EscudoDaoTest {

    private Connection connection;
    private EscudoDao escudoDao;

    @BeforeEach
    void before() throws Exception {
        ConnectionDB cdb = new ConnectionDB();
        connection = cdb.openConnection();
        connection.setAutoCommit(false);
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

        ObjetoEscudo escudo = new ObjetoEscudo("test escudo", 1, 2, 3);


        escudoDao.save(escudo);
        Optional<ObjetoEscudo> escudoFromDB = escudoDao.get(escudo.getIdPropia());

        assertTrue(escudoFromDB.isPresent());
        assertEquals(escudo.getIdPropia(), escudoFromDB.get().getIdPropia());
        assertEquals("test escudo", escudoFromDB.get().getNombre());
        assertEquals(1, escudoFromDB.get().getResistencia());
        assertEquals(2, escudoFromDB.get().getMovimiento());
        assertEquals(3, escudoFromDB.get().getAtaque());
    }

    @Test
    void getAll() {


        ObjetoEscudo escudo1 = new ObjetoEscudo("test escudo 1", 1, 2, 3);
        ObjetoEscudo escudo2 = new ObjetoEscudo("test escudo 2", 4, 5, 6);

        escudoDao.save(escudo1);
        escudoDao.save(escudo2);

        List<ObjetoEscudo> escudos = escudoDao.getAll();

        assertTrue(escudos.contains(escudo1));
        assertTrue(escudos.contains(escudo2));
    }

    @Test
    void update() {

        ObjetoEscudo escudo = new ObjetoEscudo("test escudo 1", 1, 2, 3);

        escudoDao.save(escudo);
        escudo.setNombre("test escudo 2");

        escudoDao.update(escudo);

        Optional<ObjetoEscudo> escudoFromDB = escudoDao.get(escudo.getIdPropia());

        assertTrue(escudoFromDB.isPresent());
        assertEquals("test escudo 2", escudoFromDB.get().getNombre());
    }

    @Test
    void delete() {

        ObjetoEscudo escudo = new ObjetoEscudo("test escudo 1", 1, 2, 3);


        escudoDao.save(escudo);

        Optional<ObjetoEscudo> escudoFromDB = escudoDao.get(escudo.getIdPropia());
        assertTrue(escudoFromDB.isPresent());

        escudoDao.delete(escudo);

        escudoFromDB = escudoDao.get(escudo.getIdPropia());
        assertFalse(escudoFromDB.isPresent());
    }
}
*/