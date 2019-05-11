/*
package testDAO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.ArmasDao;
import dao.ConnectionDB;
import entidades.ObjetoArma;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static dao.ConnectionDB.printSQLException;

class ArmasDaoTest {

    private Connection connection;
    private ArmasDao armasDao;

    @BeforeEach
    void before() throws Exception {
        ConnectionDB cdb = new ConnectionDB();
        connection = cdb.openConnection();
        connection.setAutoCommit(false);
        armasDao = new ArmasDao(connection);
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

        ObjetoArma arma = new ObjetoArma("test arma", 1, 2, 3);

        armasDao.save(arma);
        Optional<ObjetoArma> armaFromDB = armasDao.get(arma.getIdPropia());

        assertTrue(armaFromDB.isPresent());
        assertEquals(arma.getIdPropia(), armaFromDB.get().getIdPropia());
        assertEquals("test arma", armaFromDB.get().getNombre());
        assertEquals(3, armaFromDB.get().getFuerza());
        assertEquals(1, armaFromDB.get().getMovimiento());
        assertEquals(2, armaFromDB.get().getAtaque());
    }

    @Test
    void getAll() {


        ObjetoArma arma1 = new ObjetoArma("test arma 1", 1, 2, 3);
        ObjetoArma arma2 = new ObjetoArma("test arma 2", 4, 5, 6);

        armasDao.save(arma1);
        armasDao.save(arma2);

        List<ObjetoArma> armas = armasDao.getAll();

        assertTrue(armas.contains(arma1));
        assertTrue(armas.contains(arma2));
    }

    @Test
    void update() {

        ObjetoArma arma = new ObjetoArma("test escudo 1", 1, 2, 3);

        armasDao.save(arma);
        arma.setNombre("test arma 2");

        armasDao.update(arma);


        Optional<ObjetoArma> armaFromDB = armasDao.get(arma.getIdPropia());

        assertTrue(armaFromDB.isPresent());
        assertEquals("test arma 2", armaFromDB.get().getNombre());
    }

    @Test
    void delete() {

        ObjetoArma arma = new ObjetoArma("test escudo 1", 1, 2, 3);

        armasDao.save(arma);

        Optional<ObjetoArma> armaFromDB = armasDao.get(arma.getIdPropia());
        assertTrue(armaFromDB.isPresent());

        armasDao.delete(arma);

        armaFromDB = armasDao.get(arma.getIdPropia());
        assertFalse(armaFromDB.isPresent());

        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
*/