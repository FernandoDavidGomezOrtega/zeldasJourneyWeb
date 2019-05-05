package zeldasjourney.dao;

import zeldasjourney.jdbc.ConnectionDB;
import zeldasjourney.objetos.objetoHijo.ObjetoArtefacto;
import zeldasjourney.objetos.objetoHijo.ObjetoEscudo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EscudoDao {

    private static final String SELECT_ONE_QUERY = "SELECT Id_escudo, nombre, tipo, Descripcion, Ataque, Movimiento, Resistencia " +
            "FROM Escudo where Id_escudo = ?";
    private static final String SELECT_ALL_QUERY = "SELECT Id_escudo, nombre, tipo, Descripcion, Ataque, Movimiento, Resistencia " +
            "FROM Escudo";
    private static final String SELECT_BY_PARTIDA_QUERY = "SELECT Id_escudo, nombre, tipo, Descripcion, Ataque, Movimiento, Resistencia " +
            "FROM Escudo e JOIN Escudo_Partida p ON e.id_escudo = p.fk_id_escudo WHERE p.fk_id_partida = ?";
    private static final String INSERT_QUERY = "INSERT INTO Escudo(nombre, tipo, Descripcion, Ataque, Movimiento, Resistencia) " +
            "VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE Escudo " +
            "SET nombre = ?, tipo = ?, Descripcion = ?, Ataque = ?, Movimiento = ?, Resistencia = ? " +
            "WHERE Id_escudo = ?";
    private static final String DELETE_QUERY = "DELETE FROM Escudo WHERE Id_escudo = ?";

    private final Connection connection;

    public EscudoDao(Connection connection) {
        this.connection = connection;
    }

    public Optional<ObjetoEscudo> get(Integer id) {
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

    public List<ObjetoEscudo> getAll() {
        Connection connection = getConnection();

        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {

            List<ObjetoEscudo> results = new ArrayList<>();

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

    public List<ObjetoEscudo> getAllByPartida(int idPartida) {
        Connection connection = getConnection();

        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_PARTIDA_QUERY)) {
            statement.setInt(1, idPartida);

            List<ObjetoEscudo> results = new ArrayList<>();

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

    public void save(ObjetoEscudo escudo) {
        Connection connection = getConnection();

        try (PreparedStatement statement = connection
                .prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {

            //nombre, tipo, Descripcion, Ataque, Movimiento, Resistencia
            statement.setString(1, escudo.getNombre());
            statement.setString(2, escudo.getTipo());
            statement.setString(3, escudo.getDescripcion());
            statement.setDouble(4, escudo.getAtaque());
            statement.setInt(5, escudo.getMovimiento());
            statement.setDouble(6, escudo.getResistencia());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating escudo failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    escudo.setIdPropia(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating escudo failed, no ID obtained.");
                }
            }

        } catch (SQLException e) {
            ConnectionDB.printSQLException(e);
            throw new RuntimeException(e);
        }
    }

    public void update(ObjetoEscudo escudo) {
        Connection connection = getConnection();

        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, escudo.getNombre());
            statement.setString(2, escudo.getTipo());
            statement.setString(3, escudo.getDescripcion());
            statement.setDouble(4, escudo.getAtaque());
            statement.setInt(5, escudo.getMovimiento());
            statement.setDouble(6, escudo.getResistencia());
            statement.setDouble(7, escudo.getIdPropia());
            statement.executeUpdate();
        } catch (SQLException e) {
            ConnectionDB.printSQLException(e);
            throw new RuntimeException(e);
        }
    }

    public void delete(ObjetoEscudo escudo) {
        Connection connection = getConnection();
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, escudo.getIdPropia());
            statement.executeUpdate();
        } catch (SQLException e) {
            ConnectionDB.printSQLException(e);
            throw new RuntimeException(e);
        }
    }

    Connection getConnection() {
        return connection;
    }


    private ObjetoEscudo buildFromResultSet(ResultSet resultSet) {

        // Id_escudo, nombre, tipo, Descripcion, Ataque, Movimiento, Resistencia
        try {
            String nombre = resultSet.getString("nombre");
            double resistencia = resultSet.getDouble("Resistencia");
            int movimiento = resultSet.getInt("Movimiento");
            double ataque = resultSet.getDouble("Ataque");
            ObjetoEscudo escudo = new ObjetoEscudo(nombre, resistencia, movimiento, ataque);
            escudo.setIdPropia(resultSet.getInt("Id_escudo"));
            return escudo;
        } catch (SQLException e) {
            ConnectionDB.printSQLException(e);
            throw new RuntimeException(e);
        }
    }
}
