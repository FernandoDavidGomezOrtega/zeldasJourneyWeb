package dao;

import dao.ConnectionDB;
import entidades.ObjetoArma;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArmasDao {

    private static final String SELECT_ONE_QUERY = "SELECT id_arma, nombre, descripcion, tipo, ataque, fuerza, movimiento " +
            "FROM Armas where Id_arma = ?";
    private static final String SELECT_ALL_QUERY = "SELECT id_arma, nombre, descripcion, tipo, ataque, fuerza, movimiento " +
            "FROM Armas";
    private static final String SELECT_BY_PARTIDA_QUERY = "SELECT id_arma, nombre, descripcion, tipo, ataque, fuerza, movimiento " +
            "FROM Armas a JOIN Arma_Partida p ON a.id_arma = p.fk_id_arma WHERE p.fk_id_partida = ?";
    private static final String INSERT_QUERY = "INSERT INTO Armas(nombre, descripcion, tipo, ataque, fuerza, movimiento) " +
            "VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE Armas " +
            "SET nombre = ?, descripcion = ?, tipo = ?, ataque = ?, fuerza = ?, movimiento = ? " +
            "WHERE Id_Arma = ?";
    private static final String DELETE_QUERY = "DELETE FROM Armas WHERE Id_Arma = ?";

    private final Connection connection;

    public ArmasDao(Connection connection) {
        this.connection = connection;
    }

    public Optional<ObjetoArma> get(Integer id) {
        Connection connection = getConnection();

        try (PreparedStatement statement = connection.prepareStatement(SELECT_ONE_QUERY)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(buildFromResultSet(resultSet));
                } else {
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            ConnectionDB.printSQLException(e);
            throw new RuntimeException(e);
        }
    }

    public List<ObjetoArma> getAll() {
        Connection connection = getConnection();

        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {

            List<ObjetoArma> results = new ArrayList<>();

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    results.add(buildFromResultSet(resultSet));
                }
            }

            return results;
        } catch (SQLException e) {
            ConnectionDB.printSQLException(e);
            throw new RuntimeException(e);
        }
    }

    public List<ObjetoArma> getAllByPartida(int idPartida) {
        Connection connection = getConnection();

        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_PARTIDA_QUERY)) {
            statement.setInt(1, idPartida);

            List<ObjetoArma> results = new ArrayList<>();

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    results.add(buildFromResultSet(resultSet));
                }
            }

            return results;
        } catch (SQLException e) {
            ConnectionDB.printSQLException(e);
            throw new RuntimeException(e);
        }
    }

    public void save(ObjetoArma arma) {
        Connection connection = getConnection();

        try (PreparedStatement statement = connection
                .prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {

            //nombre, descripcion, tipo, ataque, fuerza, movimiento
            statement.setString(1, arma.getNombre());
            statement.setString(2, arma.getDescripcion());
            statement.setString(3, arma.getTipo());
            statement.setDouble(4, arma.getAtaque());
            statement.setInt(5, arma.getFuerza());
            statement.setInt(6, arma.getMovimiento());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating arma failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    arma.setIdPropia(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating arma failed, no ID obtained.");
                }
            }

        } catch (SQLException e) {
            ConnectionDB.printSQLException(e);
            throw new RuntimeException(e);
        }
    }

    public void update(ObjetoArma arma) {
        Connection connection = getConnection();

        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, arma.getNombre());
            statement.setString(2, arma.getDescripcion());
            statement.setString(3, arma.getTipo());
            statement.setDouble(4, arma.getAtaque());
            statement.setInt(5, arma.getFuerza());
            statement.setInt(6, arma.getMovimiento());
            statement.setDouble(7, arma.getIdPropia());
            statement.executeUpdate();
        } catch (SQLException e) {
            ConnectionDB.printSQLException(e);
            throw new RuntimeException(e);
        }
    }

    public void delete(ObjetoArma arma) {
        Connection connection = getConnection();
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, arma.getIdPropia());
            statement.executeUpdate();
        } catch (SQLException e) {
            ConnectionDB.printSQLException(e);
            throw new RuntimeException(e);
        }
    }

    Connection getConnection() {
        return connection;
    }

    private ObjetoArma buildFromResultSet(ResultSet resultSet) {

        // id_arma, nombre, descripcion, tipo, ataque, fuerza, movimiento
        try {
            String nombre = resultSet.getString("nombre");
//            String descripcion = resultSet.getString("descripcion");
//            String tipo = resultSet.getString("tipo");
            double ataque = resultSet.getDouble("Ataque");
            int fuerza = resultSet.getInt("Fuerza");
            int movimiento = resultSet.getInt("Movimiento");

            ObjetoArma arma = new ObjetoArma(nombre, movimiento, ataque, fuerza);
            arma.setIdPropia(resultSet.getInt("Id_arma"));
            return arma;
        } catch (SQLException e) {
            ConnectionDB.printSQLException(e);
            throw new RuntimeException(e);
        }
    }
}
